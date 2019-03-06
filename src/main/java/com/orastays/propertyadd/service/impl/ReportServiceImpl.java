package com.orastays.propertyadd.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;

import com.orastays.propertadd.model.report.Category;
import com.orastays.propertadd.model.report.Graph;
import com.orastays.propertadd.model.report.Series;
import com.orastays.propertyadd.entity.PropertyEntity;
import com.orastays.propertyadd.exceptions.FormExceptions;
import com.orastays.propertyadd.helper.PropertyAddConstant;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.model.PropertyModel;
import com.orastays.propertyadd.model.ResponseModel;
import com.orastays.propertyadd.model.auth.UserModel;
import com.orastays.propertyadd.model.booking.BookingModel;
import com.orastays.propertyadd.model.booking.BookingVsRoomModel;
import com.orastays.propertyadd.model.booking.CancellationModel;
import com.orastays.propertyadd.service.ReportService;

@Service
@Transactional
public class ReportServiceImpl extends BaseServiceImpl implements ReportService {

	private static final Logger logger = LogManager.getLogger(ReportServiceImpl.class);
	

	@Override
	public List<BookingModel> viewPropertyBookingList(BookingModel bookingModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyBookingList -- START");
		}
		
		
		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyBookingList -- END");
		}
		
		return  reportValidation.validatePropertyBookingList(bookingModel);
	}

	@Override
	public List<BookingModel> viewUserBookingList(BookingModel bookingModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("viewUserBookingList -- START");
		}
		
		
		
		if (logger.isInfoEnabled()) {
			logger.info("viewUserBookingList -- END");
		}
		
		return reportValidation.validateUserBookingList(bookingModel);
	}

	@Override
	public List<CancellationModel> viewPropertyCancellationList(BookingModel bookingModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyCancellationList -- START");
		}
		

		if (logger.isInfoEnabled()) {
			logger.info("viewPropertyCancellationList -- END");
		}
		
		return reportValidation.validatePropertyCancellationList(bookingModel);
	}

	@Override
	public List<CancellationModel> viewUserCancellationList(BookingModel bookingModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("viewUserCancellationList -- START");
		}
		

		if (logger.isInfoEnabled()) {
			logger.info("viewUserCancellationList -- END");
		}
		return reportValidation.validateUserCancellationList(bookingModel);
	}

	@Override
	public Object requestToiletry(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("requestToiletry -- START");
		}
		
		String result = messageUtil.getBundle("mail.send.success");
		try {
			List<Object> objects = reportValidation.requestToiletry(propertyModel);
			PropertyEntity propertyEntity = (PropertyEntity) objects.get(0);
			UserModel userModel = (UserModel) objects.get(1);
			String body = "Hi Admin, "+userModel.getName()+" has requested for more toiletry kit";
			String subject = messageUtil.getBundle("toiletry.subject") + propertyEntity.getOraname();
			ResponseModel response = mailHelper.sendMail(messageUtil.getBundle("admin.email"), subject, body);
		} catch (HttpClientErrorException e) {
			result = messageUtil.getBundle("mail.send.failed");
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("requestToiletry -- START");
		}
		
		return result;
	}

	@Override
	public Graph fetchHostLineGraph(String userToken, String year) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchHostLineGraph -- START");
		}
		
		UserModel userModel = reportValidation.getUserDetails(userToken);
		Graph graph = new Graph();
		String[] categories = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		Category category = new Category();
		category.setCategories(categories);
		graph.setCategory(category);
		List<Series> series = new ArrayList<>();
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put("createdBy", userModel.getUserId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".PropertyEntity", outerMap1);
			
			List<PropertyEntity> propertyEntities = propertyDAO.fetchListBySubCiteria(alliasMap);
			
			if(!CollectionUtils.isEmpty(propertyEntities)) {
				for(PropertyEntity propertyEntity : propertyEntities) {
					for(int i = 1; i <= categories.length; i++) {
						
						List<String> dates = dateCalculation.findDate(Integer.valueOf(year), i);
						BookingModel bookingModel = new BookingModel();
						bookingModel.setPropertyId(String.valueOf(propertyEntity.getPropertyId()));
						bookingModel.setCheckinDate(dates.get(0));
						bookingModel.setCheckoutDate(dates.get(1));
						List<BookingModel> bookingModels = reportValidation.getPropertyBookingList(bookingModel);
						Series serie = new Series();
						serie.setName(propertyEntity.getOraname());
						String[] datas = new String[12];
						if(!CollectionUtils.isEmpty(bookingModels)) {
							Double price = 0.0D;
							for(BookingModel bookingModel2 : bookingModels) {
								if(Objects.nonNull(bookingModel2)) {
									if(!CollectionUtils.isEmpty(bookingModel2.getBookingVsRooms())) {
										for(BookingVsRoomModel bookingVsRoomModel : bookingModel2.getBookingVsRooms()) {
											price = price + Double.parseDouble(bookingVsRoomModel.getHostPrice());
										}
									}
								}
							}
							datas[i - 1] = String.valueOf(price);
						}
						serie.setData(datas);
						series.add(serie);
					}
				}
				graph.setSeries(series);
			}
		} catch (Exception e) {
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchHostLineGraph -- START");
		}
		
		return graph;
	}

	@Override
	public Graph fetchHostBarGraph(String userToken, String year) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchHostBarGraph -- START");
		}
		
		UserModel userModel = reportValidation.getUserDetails(userToken);
		Graph graph = new Graph();
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put("createdBy", userModel.getUserId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".PropertyEntity", outerMap1);
			
			List<PropertyEntity> propertyEntities = propertyDAO.fetchListBySubCiteria(alliasMap);
			
			if(!CollectionUtils.isEmpty(propertyEntities)) {
				String[] categories = new String[propertyEntities.size()];
				List<Series> series = new ArrayList<>();
				for(int i = 0; i <= propertyEntities.size(); i ++) {
					PropertyEntity propertyEntity = propertyEntities.get(i);
					categories[i] = propertyEntity.getOraname();
					
					BookingModel bookingModel = new BookingModel();
					bookingModel.setPropertyId(String.valueOf(propertyEntity.getPropertyId()));
					List<BookingModel> bookingModels = reportValidation.getPropertyBookingList(bookingModel);
					// Pending Amount Calculation
					Series serie = new Series();
					serie.setName("Pending Amount");
					String[] datas = new String[propertyEntities.size()];
					if(!CollectionUtils.isEmpty(bookingModels)) {
						Double price = 0.0D;
						for(BookingModel bookingModel2 : bookingModels) {
							if(Objects.nonNull(bookingModel2)) {
								if(!CollectionUtils.isEmpty(bookingModel2.getBookingVsRooms())) {
									for(BookingVsRoomModel bookingVsRoomModel : bookingModel2.getBookingVsRooms()) {
										price = price + Double.parseDouble(bookingVsRoomModel.getHostPrice());
									}
								}
							}
						}
						datas[i] = String.valueOf(price);
					}
					serie.setData(datas);
					series.add(serie);
					
					// Realize Amount Calculation
					serie = new Series();
					serie.setName("Realize Amount");
					datas = new String[propertyEntities.size()];
					if(!CollectionUtils.isEmpty(bookingModels)) {
						Double price = 0.0D;
						Double userPaid = 0.0D;
						for(BookingModel bookingModel2 : bookingModels) {
							if(Objects.nonNull(bookingModel2)) {
								if(!CollectionUtils.isEmpty(bookingModel2.getBookingVsRooms())) {
									for(BookingVsRoomModel bookingVsRoomModel : bookingModel2.getBookingVsRooms()) {
										price = price + Double.parseDouble(bookingVsRoomModel.getHostPrice());
									}
								}
							}
							userPaid = userPaid + Double.parseDouble(bookingModel2.getUserFinalPrice());
						}
						price = price - userPaid;
						datas[i] = String.valueOf(price);
					}
					serie.setData(datas);
					series.add(serie);
				}
				Category category = new Category();
				category.setCategories(categories);
				graph.setCategory(category);
				graph.setSeries(series);
			}
		} catch (Exception e) {
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchHostBarGraph -- START");
		}
		
		return graph;
	}

}