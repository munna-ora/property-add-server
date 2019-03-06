package com.orastays.propertyadd.validation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.PropertyEntity;
import com.orastays.propertyadd.exceptions.FormExceptions;
import com.orastays.propertyadd.helper.PropertyAddConstant;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.UserType;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.PropertyModel;
import com.orastays.propertyadd.model.auth.UserModel;
import com.orastays.propertyadd.model.auth.UserVsTypeModel;
import com.orastays.propertyadd.model.booking.BookingModel;
import com.orastays.propertyadd.model.booking.BookingVsRoomModel;
import com.orastays.propertyadd.model.booking.CancellationModel;

@Component
@Transactional
public class ReportValidation extends AuthorizeUserValidation {

	private static final Logger logger = LogManager.getLogger(ReportValidation.class);
	
	public List<CancellationModel> validatePropertyCancellationList(BookingModel bookingModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("validatePropertyCancellationList -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<CancellationModel> cancellationModels = null;
		List<CancellationModel> finalCancellationModels = new ArrayList<>();
		UserModel userModel = null;
		if(Objects.nonNull(bookingModel)){
			
			// Validate User Token
			if (StringUtils.isBlank(bookingModel.getUserToken())) {
				exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
			} else {
				userModel = getUserDetails(bookingModel.getUserToken());
			}
			
			// Validate Host Login Details
			if(Objects.nonNull(userModel)){
				if(Objects.nonNull(userModel.getUserVsTypes())){
					boolean flag = false;
					for(UserVsTypeModel userVsTypeModel : userModel.getUserVsTypes()){
						if(Objects.nonNull(userVsTypeModel.getUserType())) {
							if(userVsTypeModel.getUserType().getUserTypeId().equals(String.valueOf(UserType.HOST.ordinal()))){
								flag = true;
							}
						} else {
							exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
						}
					}
					
					if(!flag){
						exceptions.put(messageUtil.getBundle("user.type.invalid.code"), new Exception(messageUtil.getBundle("user.type.invalid.message")));
					}
				} else {
					exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
				}
			} else {
				exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
			}
			
			//Validate Property
			if (StringUtils.isBlank(String.valueOf(bookingModel.getPropertyId()))) {
				exceptions.put(messageUtil.getBundle("property.id.null.code"), new Exception(messageUtil.getBundle("property.id.null.message")));
			} else {
				
				if (!Util.isNumeric(String.valueOf(bookingModel.getPropertyId()))) {
					exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
				} else {
					PropertyEntity propertyEntity = null;
					
					try {
						Map<String, String> innerMap1 = new LinkedHashMap<>();
						innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
						innerMap1.put(PropertyAddConstant.PROPERTYID, String.valueOf(bookingModel.getPropertyId()));
				
						Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
						outerMap1.put("eq", innerMap1);
				
						Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
						alliasMap.put(entitymanagerPackagesToScan+".PropertyEntity", outerMap1);
						
						propertyEntity = propertyDAO.fetchObjectBySubCiteria(alliasMap);
						
						if (Objects.isNull(propertyEntity)) {
							exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
						} else {
							//validate BookingID
							if(StringUtils.isEmpty(bookingModel.getBookingId())){
								exceptions.put(messageUtil.getBundle("booking.id.null.code"), new Exception(messageUtil.getBundle("booking.id.null.message")));
								
							} else if(StringUtils.isEmpty(bookingModel.getOrabookingId())){ //Validate Ora Booking Id
								
								exceptions.put(messageUtil.getBundle("orabooking.id.null.code"), new Exception(messageUtil.getBundle("orabooking.id.null.message")));
								
							} else {
									cancellationModels = getPropertyCancellationList(bookingModel);
									
									if(!CollectionUtils.isEmpty(cancellationModels)){
										for(CancellationModel model:cancellationModels){
											
											CancellationModel cancellationModel = new CancellationModel();
											cancellationModel = model;
											if(Objects.nonNull(propertyEntity)){
												cancellationModel.getBookingModel().setPropertyName(propertyEntity.getName());
												cancellationModel.getBookingModel().setPropertyAddress(propertyEntity.getAddress());
												cancellationModel.getBookingModel().setOraname(propertyEntity.getOraname());
											}
											finalCancellationModels.add(cancellationModel);
											
										}
									}
							}
						}

					} catch (Exception e) {
						exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
					}
					
				}
			}
			
		} else {
			 exceptions.put(messageUtil.getBundle("property.null.code"), new Exception(messageUtil.getBundle("property.null.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validatePropertyCancellationList -- End");
		}
		
		return finalCancellationModels;
		
	}

	
	public List<CancellationModel> validateUserCancellationList(BookingModel bookingModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("validateUserCancellationList -- START");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<CancellationModel> cancellationModels = null;
		List<CancellationModel> finalCancellationModels = new ArrayList<>();
		UserModel userModel = null;
		if(Objects.nonNull(bookingModel)){
			// Validate User Token
			if (StringUtils.isBlank(bookingModel.getUserToken())) {
				exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
			} else {
				userModel = getUserDetails(bookingModel.getUserToken());
			}
			
			// Validate User Login Details
			if(Objects.nonNull(userModel)){
				if(Objects.nonNull(userModel.getUserVsTypes())){
					boolean flag = false;
					for(UserVsTypeModel userVsTypeModel : userModel.getUserVsTypes()){
						if(Objects.nonNull(userVsTypeModel.getUserType())) {
							if(userVsTypeModel.getUserType().getUserTypeId().equals(String.valueOf(UserType.CUSTOMER.ordinal()))){
								flag = true;
							}
						} else {
							exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
						}
					}
					
					if(!flag){
						exceptions.put(messageUtil.getBundle("user.type.invalid.code"), new Exception(messageUtil.getBundle("user.type.invalid.message")));
					} else {
						//validate BookingID
						if(StringUtils.isEmpty(bookingModel.getBookingId())){
							exceptions.put(messageUtil.getBundle("booking.id.null.code"), new Exception(messageUtil.getBundle("booking.id.null.message")));
							
						} else if(StringUtils.isEmpty(bookingModel.getOrabookingId())){ //Validate Ora Booking Id
							
							exceptions.put(messageUtil.getBundle("orabooking.id.null.code"), new Exception(messageUtil.getBundle("orabooking.id.null.message")));
							
						} else {
							cancellationModels = getUserCancellationList(bookingModel);
							if(!CollectionUtils.isEmpty(cancellationModels)){
								for(CancellationModel model : cancellationModels){
									
									if (Objects.nonNull(model.getBookingModel())) {
										exceptions.put(messageUtil.getBundle("property.id.null.code"), new Exception(messageUtil.getBundle("property.id.null.message")));
									} else {
											if (!Util.isNumeric(String.valueOf(model.getBookingModel().getPropertyId()))) {
												exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
											} else {
												PropertyEntity propertyEntity = propertyDAO.find(Long.valueOf(model.getBookingModel().getPropertyId()));
												CancellationModel cancellationModel = new CancellationModel();
												cancellationModel = model;
												if(Objects.nonNull(propertyEntity)){
													cancellationModel.getBookingModel().setPropertyName(propertyEntity.getName());
													cancellationModel.getBookingModel().setPropertyAddress(propertyEntity.getAddress());
													cancellationModel.getBookingModel().setOraname(propertyEntity.getOraname());
												}
												
												finalCancellationModels.add(cancellationModel);
											}
									}
								}
							}
						}
					}
				} else {
					exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
				}
			} else {
				exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
			}

		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("validateUserCancellationList -- End");
		}
		
		return finalCancellationModels;
	}
	
	public List<BookingModel> validateUserBookingList(BookingModel bookingModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("validateUserBookingList -- START");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<BookingModel> bookingModels = null;
		List<BookingModel> finalBookingModels = new ArrayList<>();
		UserModel userModel = null;
		if(Objects.nonNull(bookingModel)){
			// Validate User Token
			if (StringUtils.isBlank(bookingModel.getUserToken())) {
				exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
			} else {
				userModel = getUserDetails(bookingModel.getUserToken());
			}
			
			// Validate User Login Details
			if(Objects.nonNull(userModel)){
				if(Objects.nonNull(userModel.getUserVsTypes())){
					boolean flag = false;
					for(UserVsTypeModel userVsTypeModel : userModel.getUserVsTypes()){
						if(Objects.nonNull(userVsTypeModel.getUserType())) {
							if(userVsTypeModel.getUserType().getUserTypeId().equals(String.valueOf(UserType.CUSTOMER.ordinal()))){
								flag = true;
							}
						} else {
							exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
						}
					}
					
					if(!flag){
						exceptions.put(messageUtil.getBundle("user.type.invalid.code"), new Exception(messageUtil.getBundle("user.type.invalid.message")));
					} else {
						bookingModels = getUserBookingList(userModel.getUserId());
						if(!CollectionUtils.isEmpty(bookingModels)){
							for(BookingModel bookingModel2:bookingModels){
								if (StringUtils.isBlank(String.valueOf(bookingModel2.getPropertyId()))) {
									exceptions.put(messageUtil.getBundle("property.id.null.code"), new Exception(messageUtil.getBundle("property.id.null.message")));
								} else {
										if (!Util.isNumeric(String.valueOf(bookingModel2.getPropertyId()))) {
											exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
										} else {
											PropertyEntity propertyEntity = propertyDAO.find(Long.valueOf(bookingModel2.getPropertyId()));
											
											BookingModel bModel  = new BookingModel();
											bModel = bookingModel2;
											if(Objects.nonNull(propertyEntity)){
												bModel.setPropertyName(propertyEntity.getName());
												bModel.setPropertyAddress(propertyEntity.getAddress());
												bModel.setOraname(propertyEntity.getOraname());
											}
											finalBookingModels.add(bModel);
										}
									}
								}
							}	
						}
				} else {
					exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
				}
			} else {
				exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
			}

		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("validateUserBookingList -- End");
		}

		
		return finalBookingModels;
	}
	
	public List<BookingModel> validatePropertyBookingList(BookingModel bookingModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("validatePropertyBookingList -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<BookingModel> bookingModels = null;
		List<BookingModel> finalBookingModels = new ArrayList<>();
		UserModel userModel = null;
		if(Objects.nonNull(bookingModel)){
			
			// Validate User Token
			if (StringUtils.isBlank(bookingModel.getUserToken())) {
				exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
			} else {
				userModel = getUserDetails(bookingModel.getUserToken());
			}
			
			// Validate Host Login Details
			if(Objects.nonNull(userModel)){
				if(Objects.nonNull(userModel.getUserVsTypes())){
					boolean flag = false;
					for(UserVsTypeModel userVsTypeModel : userModel.getUserVsTypes()){
						if(Objects.nonNull(userVsTypeModel.getUserType())) {
							if(userVsTypeModel.getUserType().getUserTypeId().equals(String.valueOf(UserType.HOST.ordinal()))){
								flag = true;
							}
						} else {
							exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
						}
					}
					
					if(!flag){
						exceptions.put(messageUtil.getBundle("user.type.invalid.code"), new Exception(messageUtil.getBundle("user.type.invalid.message")));
					}
				} else {
					exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
				}
			} else {
				exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
			}
			
			//Validate Property
			if (StringUtils.isBlank(String.valueOf(bookingModel.getPropertyId()))) {
				exceptions.put(messageUtil.getBundle("property.id.null.code"), new Exception(messageUtil.getBundle("property.id.null.message")));
			} else {
				
				if (!Util.isNumeric(String.valueOf(bookingModel.getPropertyId()))) {
					exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
				} else {
					PropertyEntity propertyEntity = null;
					try {
						Map<String, String> innerMap1 = new LinkedHashMap<>();
						innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
						innerMap1.put(PropertyAddConstant.PROPERTYID, String.valueOf(bookingModel.getPropertyId()));
				
						Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
						outerMap1.put("eq", innerMap1);
				
						Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
						alliasMap.put(entitymanagerPackagesToScan+".PropertyEntity", outerMap1);
						
						propertyEntity = propertyDAO.fetchObjectBySubCiteria(alliasMap);
						
						if (Objects.isNull(propertyEntity)) {
							exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
						} else {
							bookingModels = getPropertyBookingList(bookingModel);
							if(!CollectionUtils.isEmpty(bookingModels)) {
								Double price = 0.0D;
								for(BookingModel bookingModel2:bookingModels){
									
									BookingModel bModel  = new BookingModel();
									bModel = bookingModel2;
									bModel.setPropertyName(propertyEntity.getName());
									bModel.setPropertyAddress(propertyEntity.getAddress());
									bModel.setOraname(propertyEntity.getOraname());
									if(Objects.nonNull(bookingModel2)) {
										if(!CollectionUtils.isEmpty(bookingModel2.getBookingVsRooms())) {
											for(BookingVsRoomModel bookingVsRoomModel : bookingModel2.getBookingVsRooms()) {
												price = price + Double.parseDouble(bookingVsRoomModel.getHostPrice());
											}
										}
									}
									bModel.setHostPrice(String.valueOf(price));
									finalBookingModels.add(bModel);
								}
							}
						}

					} catch (Exception e) {
						exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
					}
				}
			}
		} else {
			 exceptions.put(messageUtil.getBundle("property.null.code"), new Exception(messageUtil.getBundle("property.null.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);

		if (logger.isInfoEnabled()) {
			logger.info("validatePropertyBookingList -- End");
		}
		
		return finalBookingModels;
		
	}
	
	public List<Object> requestToiletry(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("requestToiletry -- Start");
		}

		List<Object> objects = new ArrayList<>();
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		PropertyEntity propertyEntity = null;
		UserModel userModel = null;
		if(Objects.nonNull(propertyModel)){
			
			// Validate User Token
			if (StringUtils.isBlank(propertyModel.getUserToken())) {
				exceptions.put(messageUtil.getBundle("token.null.code"), new Exception(messageUtil.getBundle("token.null.message")));
			} else {
				userModel = getUserDetails(propertyModel.getUserToken());
			}
			
			// Validate Host Login Details
			if(Objects.nonNull(userModel)){
				if(Objects.nonNull(userModel.getUserVsTypes())){
					boolean flag = false;
					for(UserVsTypeModel userVsTypeModel : userModel.getUserVsTypes()){
						if(Objects.nonNull(userVsTypeModel.getUserType())) {
							if(userVsTypeModel.getUserType().getUserTypeId().equals(String.valueOf(UserType.HOST.ordinal()))){
								flag = true;
							}
						} else {
							exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
						}
					}
					
					if(!flag){
						exceptions.put(messageUtil.getBundle("user.type.invalid.code"), new Exception(messageUtil.getBundle("user.type.invalid.message")));
					}
				} else {
					exceptions.put(messageUtil.getBundle("user.type.null.code"), new Exception(messageUtil.getBundle("user.type.null.message")));
				}
			} else {
				exceptions.put(messageUtil.getBundle("token.invalid.code"), new Exception(messageUtil.getBundle("token.invalid.message")));
			}
			
			//Validate Property
			if (StringUtils.isBlank(String.valueOf(propertyModel.getPropertyId()))) {
				exceptions.put(messageUtil.getBundle("property.id.null.code"), new Exception(messageUtil.getBundle("property.id.null.message")));
			} else {
				
				if (!Util.isNumeric(String.valueOf(propertyModel.getPropertyId()))) {
					exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
				} else {
					
					try {
						Map<String, String> innerMap1 = new LinkedHashMap<>();
						innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
						innerMap1.put(PropertyAddConstant.PROPERTYID, String.valueOf(propertyModel.getPropertyId()));
				
						Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
						outerMap1.put("eq", innerMap1);
				
						Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
						alliasMap.put(entitymanagerPackagesToScan+".PropertyEntity", outerMap1);
						
						propertyEntity = propertyDAO.fetchObjectBySubCiteria(alliasMap);
						
						if (Objects.isNull(propertyEntity)) {
							exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
						}
					} catch (Exception e) {
						exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
					}
				}
			}
		} else {
			 exceptions.put(messageUtil.getBundle("property.null.code"), new Exception(messageUtil.getBundle("property.null.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		else {
			objects.add(propertyEntity);
			objects.add(userModel);
		}

		if (logger.isInfoEnabled()) {
			logger.info("requestToiletry -- End");
		}
		
		return objects;
		
	}
}