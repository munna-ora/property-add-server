package com.orastays.propertyadd.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.orastays.propertyadd.entity.HostVsAccountEntity;
import com.orastays.propertyadd.entity.PropertyEntity;
import com.orastays.propertyadd.entity.PropertyVsDescriptionEntity;
import com.orastays.propertyadd.entity.PropertyVsDocumentEntity;
import com.orastays.propertyadd.entity.PropertyVsGuestAccessEntity;
import com.orastays.propertyadd.entity.PropertyVsImageEntity;
import com.orastays.propertyadd.entity.PropertyVsNearbyEntity;
import com.orastays.propertyadd.entity.PropertyVsPriceDropEntity;
import com.orastays.propertyadd.entity.PropertyVsSpaceRuleEntity;
import com.orastays.propertyadd.entity.PropertyVsSpecialExperienceEntity;
import com.orastays.propertyadd.entity.RoomEntity;
import com.orastays.propertyadd.entity.RoomVsAmenitiesEntity;
import com.orastays.propertyadd.entity.RoomVsCancellationEntity;
import com.orastays.propertyadd.entity.RoomVsImageEntity;
import com.orastays.propertyadd.entity.RoomVsMealEntity;
import com.orastays.propertyadd.entity.RoomVsSpecialitiesEntity;
import com.orastays.propertyadd.exceptions.FormExceptions;
import com.orastays.propertyadd.helper.Accommodation;
import com.orastays.propertyadd.helper.AmenitiesType;
import com.orastays.propertyadd.helper.PropertyAddConstant;
import com.orastays.propertyadd.helper.Sex;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.AmenitiesModel;
import com.orastays.propertyadd.model.CancellationSlabModel;
import com.orastays.propertyadd.model.CityModel;
import com.orastays.propertyadd.model.CommonModel;
import com.orastays.propertyadd.model.ContactPurposeModel;
import com.orastays.propertyadd.model.CountryModel;
import com.orastays.propertyadd.model.DocumentModel;
import com.orastays.propertyadd.model.PriceDropModel;
import com.orastays.propertyadd.model.PropertyModel;
import com.orastays.propertyadd.model.PropertyTypeModel;
import com.orastays.propertyadd.model.PropertyVsDescriptionModel;
import com.orastays.propertyadd.model.PropertyVsDocumentModel;
import com.orastays.propertyadd.model.PropertyVsGuestAccessModel;
import com.orastays.propertyadd.model.PropertyVsImageModel;
import com.orastays.propertyadd.model.PropertyVsNearbyModel;
import com.orastays.propertyadd.model.PropertyVsPriceDropModel;
import com.orastays.propertyadd.model.PropertyVsSpaceRuleModel;
import com.orastays.propertyadd.model.PropertyVsSpecialExperienceModel;
import com.orastays.propertyadd.model.PropertyVsToiletryModel;
import com.orastays.propertyadd.model.RoomCategoryModel;
import com.orastays.propertyadd.model.RoomModel;
import com.orastays.propertyadd.model.RoomVsAmenitiesModel;
import com.orastays.propertyadd.model.RoomVsCancellationModel;
import com.orastays.propertyadd.model.RoomVsImageModel;
import com.orastays.propertyadd.model.RoomVsMealModel;
import com.orastays.propertyadd.model.RoomVsSpecialitiesModel;
import com.orastays.propertyadd.model.SpaceRuleModel;
import com.orastays.propertyadd.model.SpecialExperienceModel;
import com.orastays.propertyadd.model.SpecialtiesModel;
import com.orastays.propertyadd.model.StateModel;
import com.orastays.propertyadd.model.StayTypeModel;
import com.orastays.propertyadd.model.auth.UserModel;
import com.orastays.propertyadd.service.PropertyService;

@Service
@Transactional
public class PropertyServiceImpl extends BaseServiceImpl implements PropertyService {

	private static final Logger logger = LogManager.getLogger(PropertyServiceImpl.class);
	
	@Override
	public List<PropertyTypeModel> fetchPropertyTypes() throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyTypes -- START");
		}
		
		List<PropertyTypeModel> propertyTypeModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".PropertyTypeEntity", outerMap1);
			
			propertyTypeModels = propertyTypeConverter.entityListToModelList(propertyTypeDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchPropertyTypes -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyTypes -- END");
		}
		
		return propertyTypeModels;
	}
	
	@Override
	public List<ContactPurposeModel> fetchContactPurpose() throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchContactPurpose -- START");
		}
		
		List<ContactPurposeModel> contactPurposeModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".ContactPurposeEntity", outerMap1);
			
			contactPurposeModels = contactPurposeConverter.entityListToModelList(contactPurposeDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchContactPurpose -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchContactPurpose -- END");
		}
		
		return contactPurposeModels;
	}
	
	
	@Override
	public List<CountryModel> fetchCountryList() throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchCountryList -- START");
		}
		
		List<CountryModel> countryModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".CountryEntity", outerMap1);
			
			countryModels = countryConverter.entityListToModelList(countryDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchCountryList -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchCountryList -- END");
		}
		
		return countryModels;
	}
	
	
	@Override
	public List<StateModel> fetchStateByCountry(CountryModel countryModel) {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchStateByCountry -- START");
		}
		
		List<StateModel> stateModels=null;
		try {
		Map<String,String> innerMap1=new LinkedHashMap<>();
		innerMap1.put("status", String.valueOf(Status.ACTIVE.ordinal()));
		
		Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
		outerMap1.put("eq", innerMap1);
		
		Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
		alliasMap.put(entitymanagerPackagesToScan+".StateEntity", outerMap1);
		
		Map<String, String> innerMap2 = new LinkedHashMap<>();
		innerMap1.put("countryId", countryModel.getCountryId());

		Map<String, Map<String, String>> outerMap2 = new LinkedHashMap<>();
		outerMap2.put("eq", innerMap2);

		alliasMap.put("countryEntity", outerMap2);

		stateModels = stateConverter.entityListToModelList(stateDAO.fetchListBySubCiteria(alliasMap));
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchStateByCountry -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchStateByCountry -- END");
		}
		
		return stateModels;
		
	}
	
	@Override
	public List<CityModel> fetchCityByState(StateModel stateModel) {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchCityByState -- START");
		}
		
		List<CityModel> cityModels=null;
		try {
		Map<String,String> innerMap1=new LinkedHashMap<>();
		innerMap1.put("status", String.valueOf(Status.ACTIVE.ordinal()));
		
		Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
		outerMap1.put("eq", innerMap1);
		
		Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
		alliasMap.put(entitymanagerPackagesToScan+".CityEntity", outerMap1);
		
		Map<String, String> innerMap2 = new LinkedHashMap<>();
		innerMap2.put("stateId", stateModel.getStateId());

		Map<String, Map<String, String>> outerMap2 = new LinkedHashMap<>();
		outerMap2.put("eq", innerMap2);

		alliasMap.put("stateEntity", outerMap2);

		cityModels = cityConverter.entityListToModelList(cityDAO.fetchListBySubCiteria(alliasMap));
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchCityByState -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchCityByState -- END");
		}
		
		return cityModels;
		
	}
	
	@Override
	public List<StayTypeModel> fetchStayTypeList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchStayTypeList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
		List<StayTypeModel> stayTypeModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".StayTypeEntity", outerMap1);
	
			stayTypeModels = stayTypeConverter.entityListToModelList(stayTypeDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchStayTypeList -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchStayTypeList -- END");
		}
		
		return stayTypeModels;
	}
	
	@Override
	public List<String> fetchAccommodationByLanguage(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAccommodationByLanguage -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
		
		List<String> accommodations = Stream.of(Accommodation.values()).map(Accommodation::name).collect(Collectors.toList());
		accommodations.remove(0);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAccommodationByLanguage -- END");
		}
		
		return accommodations;
	}
	
	@Override
	public List<String> fetchPgCategorySexListByLanguage(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPgCategorySexListByLanguage -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
		
		List<String> pgCategorySex =  Stream.of(Sex.values()).map(Sex::name).collect(Collectors.toList());
		pgCategorySex.remove(0);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPgCategorySexListByLanguage -- END");
		}
		
		return pgCategorySex;
	}
	
	@Override
	public List<String> fetchAmenitiesTypeList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesTypeList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
		//propertyValidation.validateLanguageWithUserToken(commonModel);
		
		List<String> amenitiesTypes =  Stream.of(AmenitiesType.values()).map(AmenitiesType::name).collect(Collectors.toList());
		amenitiesTypes.remove(0);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesTypeList -- END");
		}
		
		return amenitiesTypes;
	}
	
	@Override
	public List<AmenitiesModel> fetchAmenitiesList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
		List<AmenitiesModel> amenitiesModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".AmenitiesEntity", outerMap1);
	
			amenitiesModels = amenitiesConverter.entityListToModelList(amenitiesDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchAmenitiesList -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesList -- END");
		}
		
		return amenitiesModels;
	}
	
	@Override
	public List<AmenitiesModel> fetchAmenitiesForFilter() throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesForFilter -- START");
		}
		
		List<AmenitiesModel> amenitiesModels = null;
		
		try {
			
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.FILTER_FLAG, PropertyAddConstant.STR_Y);
			 
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
			 
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".AmenitiesEntity", outerMap1);
			
			amenitiesModels = amenitiesConverter.entityListToModelList(amenitiesDAO.fetchListBySubCiteria(alliasMap));
			
			Collections.reverse(amenitiesModels);
			
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchAmenitiesForFilter -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchAmenitiesForFilter -- END");
		}
		
		return amenitiesModels;
	}
	
	@Override
	public List<SpecialExperienceModel> fetchSpecialExperienceList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialExperienceList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
		List<SpecialExperienceModel> specialExperienceModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".SpecialExperienceEntity", outerMap1);
	
			specialExperienceModels = specialExperienceConverter.entityListToModelList(specialExperienceDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchSpecialExperienceList -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialExperienceList -- END");
		}
		
		return specialExperienceModels;
	}
	
	
	@Override
	public List<DocumentModel> fetchDocumentList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchDocumentList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
		List<DocumentModel> documentModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".DocumentEntity", outerMap1);
	
			documentModels = documentConverter.entityListToModelList(documentDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchSpecialExperienceList -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialExperienceList -- END");
		}
		
		return documentModels;
	}
	
	@Override
	public List<SpaceRuleModel> fetchSpaceRuleList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpaceRuleList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
		List<SpaceRuleModel> spaceRuleModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".SpaceRuleEntity", outerMap1);
	
			spaceRuleModels = spaceRuleConverter.entityListToModelList(spaceRuleDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchSpaceRuleList -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpaceRuleList -- END");
		}
		
		return spaceRuleModels;
	}
	
	@Override
	public List<SpecialtiesModel> fetchSpecialtiesList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialtiesList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
		List<SpecialtiesModel> specialtiesModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".SpecialtiesEntity", outerMap1);
	
			specialtiesModels = specialtiesConverter.entityListToModelList(specialtiesDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchSpecialtiesList -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchSpecialtiesList -- END");
		}
		
		return specialtiesModels;
	}
	
	@Override
	public List<RoomCategoryModel> fetchRoomCategoryList(CommonModel commonModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchRoomCategoryList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(commonModel);
		List<RoomCategoryModel> roomCategoryModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
			innerMap1.put(PropertyAddConstant.LANGUAGEID, commonModel.getLanguageId());
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".RoomCategoryEntity", outerMap1);
	
			roomCategoryModels = roomCategoryConverter.entityListToModelList(roomCategoryDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchRoomCategoryList -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchRoomCategoryList -- END");
		}
		
		return roomCategoryModels;
	}
	
	@Override
	public List<CancellationSlabModel> fetchCancellationSlabList() throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchCancellationSlabList -- START");
		}
		
		propertyValidation.validateLanguageWithUserToken(null);
		List<CancellationSlabModel> cancellationSlabModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".CancellationSlabEntity", outerMap1);
	
			cancellationSlabModels = cancellationSlabConverter.entityListToModelList(cancellationSlabDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchCancellationSlabList -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchCancellationSlabList -- END");
		}
		
		return cancellationSlabModels;
	}
	
	@Override
	public List<PriceDropModel> fetchPriceDropList() throws FormExceptions{
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPriceDropList -- Start");
		}
		
		List<PriceDropModel> priceDropModels = null;
		
		try {
			Map<String, String> innerMap1 = new LinkedHashMap<>();
			innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
	
			Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
			outerMap1.put("eq", innerMap1);
	
			Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
			alliasMap.put(entitymanagerPackagesToScan+".PriceDropEntity", outerMap1);
	
			priceDropModels = priceDropConverter.entityListToModelList(priceDropDAO.fetchListBySubCiteria(alliasMap));

		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("Exception in fetchPriceDropList -- "+Util.errorToString(e));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPriceDropList -- End");
		}
		
		return priceDropModels;
	}

	@Override
	public void saveProperty(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("saveProperty -- Start");
		}
		
		UserModel userModel = propertyValidation.validatePropertyAdd(propertyModel);
		Long userId = Long.valueOf(userModel.getUserId());
		// User vs Account
		propertyModel.getHostVsAccountModel().setCreatedBy(userId);
		propertyModel.getHostVsAccountModel().setUserId(userModel.getUserId());
		HostVsAccountEntity userVsAccountEntity = userVsAccountConverter.modelToEntity(propertyModel.getHostVsAccountModel());
		userVsAccountDAO.save(userVsAccountEntity);
		
		//Property
		propertyModel.setCreatedBy(userId);
		propertyModel.setAdvancePercentage(PropertyAddConstant.ADVPERCENTAGE);
		PropertyEntity propertyEntity = propertyConverter.modelToEntity(propertyModel);
		propertyEntity.setHostVsAccountEntity(userVsAccountEntity);
		propertyDAO.save(propertyEntity);
		
		//Property Vs Description
		for(PropertyVsDescriptionModel propertyVsDescriptionModel:propertyModel.getPropertyVsDescriptionModels()){
			propertyVsDescriptionModel.setCreatedBy(userId);
			PropertyVsDescriptionEntity propertyVsDescriptionEntity = propertyVsDescriptionConverter.modelToEntity(propertyVsDescriptionModel);
			propertyVsDescriptionEntity.setPropertyEntity(propertyEntity);			
			propertyVsDescriptionDAO.save(propertyVsDescriptionEntity);
		}
		
		//Property Vs Document
		for(PropertyVsDocumentModel propertyvsDocumentModel:propertyModel.getPropertyVsDocumentModels()){
			propertyvsDocumentModel.setCreatedBy(userId);
			PropertyVsDocumentEntity propertyVsDocumentEntity = propertyVsDocumentConverter.modelToEntity(propertyvsDocumentModel);
			propertyVsDocumentEntity.setPropertyEntity(propertyEntity);
			propertyVsDocumentDAO.save(propertyVsDocumentEntity);
		}
		
		//Property Vs Special Experience
		for(PropertyVsSpecialExperienceModel specialExperienceModel:propertyModel.getPropertyVsSpecialExperienceModels()){
			specialExperienceModel.setCreatedBy(userId);
			PropertyVsSpecialExperienceEntity propertyVsSpecialExperienceEntity = pVsSpecialExperienceConverter.modelToEntity(specialExperienceModel);
			propertyVsSpecialExperienceEntity.setPropertyEntity(propertyEntity);
			propertyVsSpecialExperienceDAO.save(propertyVsSpecialExperienceEntity);
		}
		
		//Property Vs Guest Access
		for(PropertyVsGuestAccessModel guestAccessModel:propertyModel.getPropertyVsGuestAccessModels()){
			guestAccessModel.setCreatedBy(userId);
			PropertyVsGuestAccessEntity propertyVsGuestAccessEntity = propertyVsGuestAccessConverter.modelToEntity(guestAccessModel);
			propertyVsGuestAccessEntity.setPropertyEntity(propertyEntity);
			propertyVsGuestAccessDAO.save(propertyVsGuestAccessEntity);
		}
		
		//Property Vs Image
		if(!CollectionUtils.isEmpty(propertyModel.getPropertyVsImageModels())) {
			for(PropertyVsImageModel propertyVsImageModel:propertyModel.getPropertyVsImageModels()){
				propertyVsImageModel.setCreatedBy(userId);
				PropertyVsImageEntity propertyVsImageEntity = propertyVsImageConverter.modelToEntity(propertyVsImageModel);
				propertyVsImageEntity.setPropertyEntity(propertyEntity);
				propertyVsImageDAO.save(propertyVsImageEntity);
			}
		}
		
		//Property Vs NearBy
		for(PropertyVsNearbyModel propertyVsNearbyModel:propertyModel.getPropertyVsNearbyModels()){
			propertyVsNearbyModel.setCreatedBy(userId);
			PropertyVsNearbyEntity propertyVsNearbyEntity = propertyVsNearbyConverter.modelToEntity(propertyVsNearbyModel);
			propertyVsNearbyEntity.setPropertyEntity(propertyEntity);
			propertyVsNearbyDAO.save(propertyVsNearbyEntity);
		}
		
		//Property Vs PriceDrop
		if(propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_Y)){
			List<PriceDropModel> priceDropModels = fetchPriceDropList();
			for(PriceDropModel priceDropModel:priceDropModels){
				PropertyVsPriceDropModel propertyVsPriceDropModel = new PropertyVsPriceDropModel();
				propertyVsPriceDropModel.setPriceDropModel(priceDropModel);
				propertyVsPriceDropModel.setPercentage(PropertyAddConstant.STR_ZERO);
				propertyVsPriceDropModel.setCreatedBy(userId);
				PropertyVsPriceDropEntity propertyVsPriceDropEntity = propertyVsPriceDropConverter.modelToEntity(propertyVsPriceDropModel);
				propertyVsPriceDropEntity.setPropertyEntity(propertyEntity);
				propertyVsPriceDropDAO.save(propertyVsPriceDropEntity);
			}
		}
		
		//Property Vs SpaceRule
		for(PropertyVsSpaceRuleModel propertyVsSpaceRuleModel:propertyModel.getPropertyVsSpaceRuleModels()){
			propertyVsSpaceRuleModel.setCreatedBy(userId);
			PropertyVsSpaceRuleEntity propertyVsSpaceRuleEntity = propertyVsSpaceRuleConverter.modelToEntity(propertyVsSpaceRuleModel);
			propertyVsSpaceRuleEntity.setPropertyEntity(propertyEntity);
			propertyVsSpaceRuleDAO.save(propertyVsSpaceRuleEntity);
		}
		
		///////////////// Room Data Insert Code ///////////////////////////
		//Room 
		for(RoomModel roomModel:propertyModel.getRoomModels()){
			roomModel.setOraRoomName("ORA"+new Date().getTime());
			roomModel.setCreatedBy(userId);
			roomModel.setOraPercentage(PropertyAddConstant.STR_ZERO);
			roomModel.setOraDiscountPercentage(PropertyAddConstant.STR_ZERO);
			RoomEntity roomEntity = roomConverter.modelToEntity(roomModel);
			roomEntity.setPropertyEntity(propertyEntity);
			roomDAO.save(roomEntity);
			
			//Room vs Amenities
			for(RoomVsAmenitiesModel roomVsAmenitiesModel:roomModel.getRoomVsAmenitiesModels()){
				roomVsAmenitiesModel.setCreatedBy(userId);
				RoomVsAmenitiesEntity roomVsAmenitiesEntity = roomVsAmenitiesConverter.modelToEntity(roomVsAmenitiesModel);
				roomVsAmenitiesEntity.setRoomEntity(roomEntity);
				roomVsAmenitiesDAO.save(roomVsAmenitiesEntity);
			}
			
			//Room Vs Image
			if(!CollectionUtils.isEmpty(roomModel.getRoomVsImageModels())) {
				for(RoomVsImageModel roomVsImageModel:roomModel.getRoomVsImageModels()){
					roomVsImageModel.setCreatedBy(userId);
					RoomVsImageEntity roomVsImageEntity = roomVsImageConverter.modelToEntity(roomVsImageModel);
					roomVsImageEntity.setRoomEntity(roomEntity);
					roomVsImageDAO.save(roomVsImageEntity);
				}
			}
			// Room vs Specilities
			for(RoomVsSpecialitiesModel roomVsSpecialitiesModel:roomModel.getRoomVsSpecialitiesModels()){
				roomVsSpecialitiesModel.setCreatedBy(userId);
				RoomVsSpecialitiesEntity roomVsSpecialitiesEntity = roomVsSpecialitiesConverter.modelToEntity(roomVsSpecialitiesModel);
				roomVsSpecialitiesEntity.setRoomEntity(roomEntity);
				roomVsSpecialitiesDAO.save(roomVsSpecialitiesEntity);
			}
			
			//Room Vs Meal
			for(RoomVsMealModel roomVsMeal:roomModel.getRoomVsMealModels()){
				roomVsMeal.setCreatedBy(userId);
				RoomVsMealEntity roomVsMealEntity = roomVsMealConverter.modelToEntity(roomVsMeal);
				roomVsMealEntity.setRoomEntity(roomEntity);
				roomVsMealDAO.save(roomVsMealEntity);
			}
			
			//Room vs Cancellation
			for(RoomVsCancellationModel roomVsCancellationModel:roomModel.getRoomVsCancellationModels()){
				roomVsCancellationModel.setCreatedBy(userId);
				RoomVsCancellationEntity roomVsCancellationEntity = roomVsCancellationConverter.modelToEntity(roomVsCancellationModel);
				roomVsCancellationEntity.setRoomEntity(roomEntity);
				roomVsCancellationDAO.save(roomVsCancellationEntity);
			}
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("saveProperty -- End");
		}
	}

	@Override
	public List<PropertyModel> fetchActivePropertyList(CommonModel commonModel) throws FormExceptions {
			
			if (logger.isInfoEnabled()) {
				logger.info("fetchActivePropertyList -- START");
			}
			
			UserModel userModel = propertyValidation.validateUserToken(commonModel);
			List<PropertyModel> propertyModels = null;
			
			try {
				Map<String, String> innerMap1 = new LinkedHashMap<>();
				//innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
				innerMap1.put(PropertyAddConstant.CREATEDBY, String.valueOf(userModel.getUserId()));
		
				Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
				outerMap1.put("eq", innerMap1);
		
				Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
				alliasMap.put(entitymanagerPackagesToScan+".PropertyEntity", outerMap1);
				
				propertyModels = propertyConverter.entityListToModelList(propertyDAO.fetchListBySubCiteria(alliasMap));

			} catch (Exception e) {
				if (logger.isInfoEnabled()) {
					logger.info("Exception in fetchActivePropertyList -- "+Util.errorToString(e));
				}
			}
			
			if (logger.isInfoEnabled()) {
				logger.info("fetchActivePropertyList -- END");
			}
			
		return propertyModels;
	}
	
	@Override
	public List<PropertyVsToiletryModel> fetchToiletry(CommonModel commonModel) throws FormExceptions {
			
			if (logger.isInfoEnabled()) {
				logger.info("fetchPropertyVsToiletryList -- START");
			}
			
			UserModel userModel = propertyValidation.validateUserToken(commonModel);
			List<PropertyVsToiletryModel> propertyVsToiletryModels = null;
			
			try {
				Map<String, String> innerMap1 = new LinkedHashMap<>();
				innerMap1.put(PropertyAddConstant.STATUS, String.valueOf(Status.ACTIVE.ordinal()));
				//innerMap1.put(PropertyAddConstant.CREATEDBY, String.valueOf(userModel.getUserId()));
		
				Map<String, Map<String, String>> outerMap1 = new LinkedHashMap<>();
				outerMap1.put("eq", innerMap1);
		
				Map<String, Map<String, Map<String, String>>> alliasMap = new LinkedHashMap<>();
				alliasMap.put(entitymanagerPackagesToScan+".PropertyVsToiletryEntity", outerMap1);
				
				propertyVsToiletryModels = propertyVsToiletryConverter.entityListToModelList(propertyVsToiletryDAO.fetchListBySubCiteria(alliasMap));

			} catch (Exception e) {
				if (logger.isInfoEnabled()) {
					logger.info("Exception in fetchPropertyVsToiletryList -- "+Util.errorToString(e));
				}
			}
			
			if (logger.isInfoEnabled()) {
				logger.info("fetchPropertyVsToiletryList -- END");
			}
			
		return propertyVsToiletryModels;
	}

	@Override
	public PropertyModel fetchPropertyById(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyById -- START");
		}
		
		propertyValidation.validateFetchPropertyById(propertyModel);
		
		if (logger.isInfoEnabled()) {
			logger.info("fetchPropertyById -- END");
		}
		
		return propertyConverter.entityToModel(propertyDAO.find(Long.valueOf(propertyModel.getPropertyId())));
	}
	
	@Override
	public void updateProperty(PropertyModel propertyModel) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("updateProperty -- START");
		}

		UserModel userModel = propertyValidation.validatePropertyUpdate(propertyModel);
		Long userId = Long.valueOf(userModel.getUserId());
		// User vs Account Delete
		
		HostVsAccountEntity userVsAccountEntity = userVsAccountDAO.find(Long.valueOf(propertyModel.getHostVsAccountModel().getHostVsAccountId()));
		userVsAccountEntity.setModifiedDate(Util.getCurrentDateTime());
		userVsAccountEntity.setModifiedBy(userId);
		userVsAccountEntity.setStatus(Status.DELETE.ordinal());
		userVsAccountDAO.update(userVsAccountEntity);
		
		//Property Delete
		PropertyEntity propertyEntity = propertyDAO.find(Long.valueOf(propertyModel.getPropertyId()));
		propertyEntity.setModifiedDate(Util.getCurrentDateTime());
		propertyEntity.setModifiedBy(userId);
		propertyEntity.setStatus(Status.DELETE.ordinal());
		propertyDAO.update(propertyEntity);
		
				//Property Vs Description Delete
				for(PropertyVsDescriptionModel propertyVsDescriptionModel:propertyModel.getPropertyVsDescriptionModels()){
					PropertyVsDescriptionEntity propertyVsDescriptionEntity = propertyVsDescriptionDAO.find(Long.valueOf(propertyVsDescriptionModel.getPropertyDescId()));
					propertyVsDescriptionEntity.setModifiedBy(userId);
					propertyVsDescriptionEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsDescriptionEntity.setStatus(Status.DELETE.ordinal());
					propertyVsDescriptionDAO.update(propertyVsDescriptionEntity);
				}
				
				//Property Vs Document Delete
				for(PropertyVsDocumentModel propertyvsDocumentModel:propertyModel.getPropertyVsDocumentModels()){
					PropertyVsDocumentEntity propertyVsDocumentEntity = propertyVsDocumentDAO.find(Long.valueOf(propertyvsDocumentModel.getPropertyVsDocumentId()));
					propertyVsDocumentEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsDocumentEntity.setModifiedBy(userId);
					propertyVsDocumentEntity.setStatus(Status.DELETE.ordinal());
					propertyVsDocumentDAO.update(propertyVsDocumentEntity);
				}
				
				//Property Vs Special Experience Delete
				for(PropertyVsSpecialExperienceModel specialExperienceModel:propertyModel.getPropertyVsSpecialExperienceModels()){
					PropertyVsSpecialExperienceEntity propertyVsSpecialExperienceEntity = propertyVsSpecialExperienceDAO.find(Long.valueOf(specialExperienceModel.getPropertyExpId()));
					propertyVsSpecialExperienceEntity.setModifiedBy(userId);
					propertyVsSpecialExperienceEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsSpecialExperienceEntity.setStatus(Status.DELETE.ordinal());
					propertyVsSpecialExperienceDAO.update(propertyVsSpecialExperienceEntity);
				}
				
				//Property Vs Guest Access Delete
				for(PropertyVsGuestAccessModel guestAccessModel:propertyModel.getPropertyVsGuestAccessModels()){
					PropertyVsGuestAccessEntity propertyVsGuestAccessEntity = propertyVsGuestAccessDAO.find(Long.valueOf(guestAccessModel.getPropertyGAccessId()));
					propertyVsGuestAccessEntity.setModifiedBy(userId);
					propertyVsGuestAccessEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsGuestAccessEntity.setStatus(Status.DELETE.ordinal());
					propertyVsGuestAccessDAO.update(propertyVsGuestAccessEntity);
				}
				
				//Property Vs Image  Delete
				if(!CollectionUtils.isEmpty(propertyModel.getPropertyVsImageModels())) {
					for(PropertyVsImageModel propertyVsImageModel:propertyModel.getPropertyVsImageModels()){
						if(StringUtils.isNotEmpty(propertyVsImageModel.getPropertyImageId())){
							PropertyVsImageEntity propertyVsImageEntity = propertyVsImageDAO.find(Long.valueOf(propertyVsImageModel.getPropertyImageId()));
							propertyVsImageEntity.setModifiedBy(userId);
							propertyVsImageEntity.setModifiedDate(Util.getCurrentDateTime());
							propertyVsImageEntity.setStatus(Status.DELETE.ordinal());
							propertyVsImageDAO.save(propertyVsImageEntity);
						}
					}
				}
				
				//Property Vs NearBy Delete
				for(PropertyVsNearbyModel propertyVsNearbyModel:propertyModel.getPropertyVsNearbyModels()){
					PropertyVsNearbyEntity propertyVsNearbyEntity = propertyVsNearbyDAO.find(Long.valueOf(propertyVsNearbyModel.getPropertyNearbyId()));
					propertyVsNearbyEntity.setModifiedBy(userId);
					propertyVsNearbyEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsNearbyEntity.setStatus(Status.DELETE.ordinal());
					propertyVsNearbyDAO.update(propertyVsNearbyEntity);
				}
				
				//Property Vs PriceDrop Delete
				if(propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_Y)){
					
					for(PropertyVsPriceDropModel propertyVsPriceDropModel : propertyModel.getPropertyVsPriceDropModels()){
						PropertyVsPriceDropEntity propertyVsPriceDropEntity = propertyVsPriceDropDAO.find(Long.valueOf(propertyVsPriceDropModel.getPropertyPDropId()));
						propertyVsPriceDropEntity.setModifiedBy(userId);
						propertyVsPriceDropEntity.setModifiedDate(Util.getCurrentDateTime());
						propertyVsPriceDropEntity.setStatus(Status.DELETE.ordinal());
						propertyVsPriceDropDAO.update(propertyVsPriceDropEntity);
					}
					
						
				}
				
				//Property Vs SpaceRule Delete
				for(PropertyVsSpaceRuleModel propertyVsSpaceRuleModel:propertyModel.getPropertyVsSpaceRuleModels()){
					
					PropertyVsSpaceRuleEntity propertyVsSpaceRuleEntity = propertyVsSpaceRuleDAO.find(Long.valueOf(propertyVsSpaceRuleModel.getPropertySpaceId()));
					propertyVsSpaceRuleEntity.setModifiedBy(userId);
					propertyVsSpaceRuleEntity.setModifiedDate(Util.getCurrentDateTime());
					propertyVsSpaceRuleEntity.setStatus(Status.DELETE.ordinal());
					propertyVsSpaceRuleDAO.update(propertyVsSpaceRuleEntity);
				}
				
				///////////////// Room Data Delete Code ///////////////////////////
				//Room  Delete
				for(RoomModel roomModel:propertyModel.getRoomModels()){
					RoomEntity roomEntity = roomDAO.find(Long.valueOf(roomModel.getRoomId()));
					roomEntity.setModifiedBy(userId);
					roomEntity.setModifiedDate(Util.getCurrentDateTime());
					roomEntity.setStatus(Status.DELETE.ordinal());
					roomDAO.update(roomEntity);
					
					//Room vs Amenities Delete
					for(RoomVsAmenitiesModel roomVsAmenitiesModel:roomModel.getRoomVsAmenitiesModels()){
						RoomVsAmenitiesEntity roomVsAmenitiesEntity = roomVsAmenitiesDAO.find(Long.valueOf(roomVsAmenitiesModel.getRoomVsAminitiesId()));
						roomVsAmenitiesEntity.setModifiedBy(userId);
						roomVsAmenitiesEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsAmenitiesEntity.setStatus(Status.DELETE.ordinal());
						roomVsAmenitiesDAO.save(roomVsAmenitiesEntity);
					}
					
					//Room Vs Image Delete
					if(!CollectionUtils.isEmpty(roomModel.getRoomVsImageModels())) {
						for(RoomVsImageModel roomVsImageModel:roomModel.getRoomVsImageModels()){
							if(StringUtils.isNotEmpty(roomVsImageModel.getRoomVsImageId())){
								RoomVsImageEntity roomVsImageEntity = roomVsImageDAO.find(Long.valueOf(roomVsImageModel.getRoomVsImageId()));
								roomVsImageEntity.setModifiedBy(userId);
								roomVsImageEntity.setModifiedDate(Util.getCurrentDateTime());
								roomVsImageEntity.setStatus(Status.DELETE.ordinal());
								roomVsImageDAO.update(roomVsImageEntity);
							}
						}
					}
					
					
					// Room vs Specilities Delete
					for(RoomVsSpecialitiesModel roomVsSpecialitiesModel:roomModel.getRoomVsSpecialitiesModels()){
						RoomVsSpecialitiesEntity roomVsSpecialitiesEntity = roomVsSpecialitiesDAO.find(Long.valueOf(roomVsSpecialitiesModel.getRoomspecId()));
						roomVsSpecialitiesEntity.setModifiedBy(userId);
						roomVsSpecialitiesEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsSpecialitiesEntity.setStatus(Status.DELETE.ordinal());
						roomVsSpecialitiesDAO.update(roomVsSpecialitiesEntity);
					}
					
					//Room Vs Meal Delete
					for(RoomVsMealModel roomVsMeal:roomModel.getRoomVsMealModels()){
						RoomVsMealEntity roomVsMealEntity = roomVsMealDAO.find(Long.valueOf(roomVsMeal.getRoomVsMealId()));
						roomVsMealEntity.setModifiedBy(userId);
						roomVsMealEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsMealEntity.setStatus(Status.DELETE.ordinal());
						roomVsMealDAO.update(roomVsMealEntity);
					}
					
					//Room vs Cancellation Delete
					for(RoomVsCancellationModel roomVsCancellationModel:roomModel.getRoomVsCancellationModels()){
						RoomVsCancellationEntity roomVsCancellationEntity = roomVsCancellationDAO.find(Long.valueOf(roomVsCancellationModel.getRcId()));
						roomVsCancellationEntity.setModifiedBy(userId);
						roomVsCancellationEntity.setModifiedDate(Util.getCurrentDateTime());
						roomVsCancellationEntity.setStatus(Status.DELETE.ordinal());
						roomVsCancellationDAO.update(roomVsCancellationEntity);
					}
					
				}
				
				
				//////////////////////////////////////////////////////////// Property Add ////////////////////////////////////////////////
				
				
				// User vs Account
				propertyModel.getHostVsAccountModel().setCreatedBy(userId);
				propertyModel.getHostVsAccountModel().setUserId(userModel.getUserId());
				HostVsAccountEntity userVsAccountEntity2 = userVsAccountConverter.modelToEntity(propertyModel.getHostVsAccountModel());
				userVsAccountDAO.save(userVsAccountEntity2);
				
				//Property
				propertyModel.setCreatedBy(userId);
				propertyModel.setAdvancePercentage(PropertyAddConstant.ADVPERCENTAGE);
				PropertyEntity propertyEntity2 = propertyConverter.modelToEntity(propertyModel);
				propertyEntity2.setStatus(Status.ACTIVE.ordinal());
				propertyEntity2.setHostVsAccountEntity(userVsAccountEntity2);
				propertyDAO.save(propertyEntity2);
				
				//Property Vs Description
				for(PropertyVsDescriptionModel propertyVsDescriptionModel:propertyModel.getPropertyVsDescriptionModels()){
					propertyVsDescriptionModel.setCreatedBy(userId);
					PropertyVsDescriptionEntity propertyVsDescriptionEntity = propertyVsDescriptionConverter.modelToEntity(propertyVsDescriptionModel);
					propertyVsDescriptionEntity.setPropertyEntity(propertyEntity2);			
					propertyVsDescriptionDAO.save(propertyVsDescriptionEntity);
				}
				
				//Property Vs Document
				for(PropertyVsDocumentModel propertyvsDocumentModel:propertyModel.getPropertyVsDocumentModels()){
					propertyvsDocumentModel.setCreatedBy(userId);
					PropertyVsDocumentEntity propertyVsDocumentEntity = propertyVsDocumentConverter.modelToEntity(propertyvsDocumentModel);
					propertyVsDocumentEntity.setPropertyEntity(propertyEntity2);
					propertyVsDocumentDAO.save(propertyVsDocumentEntity);
				}
				
				//Property Vs Special Experience
				for(PropertyVsSpecialExperienceModel specialExperienceModel:propertyModel.getPropertyVsSpecialExperienceModels()){
					specialExperienceModel.setCreatedBy(userId);
					PropertyVsSpecialExperienceEntity propertyVsSpecialExperienceEntity = pVsSpecialExperienceConverter.modelToEntity(specialExperienceModel);
					propertyVsSpecialExperienceEntity.setPropertyEntity(propertyEntity2);
					propertyVsSpecialExperienceDAO.save(propertyVsSpecialExperienceEntity);
				}
				
				//Property Vs Guest Access
				for(PropertyVsGuestAccessModel guestAccessModel:propertyModel.getPropertyVsGuestAccessModels()){
					guestAccessModel.setCreatedBy(userId);
					PropertyVsGuestAccessEntity propertyVsGuestAccessEntity = propertyVsGuestAccessConverter.modelToEntity(guestAccessModel);
					propertyVsGuestAccessEntity.setPropertyEntity(propertyEntity2);
					propertyVsGuestAccessDAO.save(propertyVsGuestAccessEntity);
				}
				
				//Property Vs Image 
				if(!CollectionUtils.isEmpty(propertyModel.getPropertyVsImageModels())){
					for(PropertyVsImageModel propertyVsImageModel:propertyModel.getPropertyVsImageModels()){
						propertyVsImageModel.setCreatedBy(userId);
						PropertyVsImageEntity propertyVsImageEntity = propertyVsImageConverter.modelToEntity(propertyVsImageModel);
						propertyVsImageEntity.setPropertyEntity(propertyEntity2);
						propertyVsImageDAO.save(propertyVsImageEntity);
					}
				}
				
				//Property Vs NearBy
				for(PropertyVsNearbyModel propertyVsNearbyModel:propertyModel.getPropertyVsNearbyModels()){
					propertyVsNearbyModel.setCreatedBy(userId);
					PropertyVsNearbyEntity propertyVsNearbyEntity = propertyVsNearbyConverter.modelToEntity(propertyVsNearbyModel);
					propertyVsNearbyEntity.setPropertyEntity(propertyEntity2);
					propertyVsNearbyDAO.save(propertyVsNearbyEntity);
				}
				
				//Property Vs PriceDrop
				if(propertyModel.getPriceDrop().equals(PropertyAddConstant.STR_Y)){
					List<PriceDropModel> priceDropModels = fetchPriceDropList();
					for(PriceDropModel priceDropModel:priceDropModels){
						PropertyVsPriceDropModel propertyVsPriceDropModel = new PropertyVsPriceDropModel();
						propertyVsPriceDropModel.setPriceDropModel(priceDropModel);
						propertyVsPriceDropModel.setPercentage(PropertyAddConstant.STR_ZERO);
						propertyVsPriceDropModel.setCreatedBy(userId);
						PropertyVsPriceDropEntity propertyVsPriceDropEntity = propertyVsPriceDropConverter.modelToEntity(propertyVsPriceDropModel);
						propertyVsPriceDropEntity.setPropertyEntity(propertyEntity2);
						propertyVsPriceDropDAO.save(propertyVsPriceDropEntity);
					}
				}
				
				//Property Vs SpaceRule
				for(PropertyVsSpaceRuleModel propertyVsSpaceRuleModel:propertyModel.getPropertyVsSpaceRuleModels()){
					propertyVsSpaceRuleModel.setCreatedBy(userId);
					PropertyVsSpaceRuleEntity propertyVsSpaceRuleEntity = propertyVsSpaceRuleConverter.modelToEntity(propertyVsSpaceRuleModel);
					propertyVsSpaceRuleEntity.setPropertyEntity(propertyEntity2);
					propertyVsSpaceRuleDAO.save(propertyVsSpaceRuleEntity);
				}
				
				///////////////// Room Data Insert Code ///////////////////////////
				//Room 
				for(RoomModel roomModel:propertyModel.getRoomModels()){
					roomModel.setCreatedBy(userId);
					RoomEntity roomEntity = roomConverter.modelToEntity(roomModel);
					roomEntity.setOraPercentage(PropertyAddConstant.STR_ZERO);
					roomEntity.setOraDiscountPercentage(PropertyAddConstant.STR_ZERO);
					roomEntity.setPropertyEntity(propertyEntity2);
					roomDAO.save(roomEntity);
					
					//Room vs Amenities
					for(RoomVsAmenitiesModel roomVsAmenitiesModel:roomModel.getRoomVsAmenitiesModels()){
						roomVsAmenitiesModel.setCreatedBy(userId);
						RoomVsAmenitiesEntity roomVsAmenitiesEntity = roomVsAmenitiesConverter.modelToEntity(roomVsAmenitiesModel);
						roomVsAmenitiesEntity.setRoomEntity(roomEntity);
						roomVsAmenitiesDAO.save(roomVsAmenitiesEntity);
					}
					
					//Room Vs Image
					if(!CollectionUtils.isEmpty(roomModel.getRoomVsImageModels())) {
						for(RoomVsImageModel roomVsImageModel:roomModel.getRoomVsImageModels()){
							roomVsImageModel.setCreatedBy(userId);
							RoomVsImageEntity roomVsImageEntity = roomVsImageConverter.modelToEntity(roomVsImageModel);
							roomVsImageEntity.setRoomEntity(roomEntity);
							roomVsImageDAO.save(roomVsImageEntity);
						}
					}
					
					// Room vs Specilities
					for(RoomVsSpecialitiesModel roomVsSpecialitiesModel:roomModel.getRoomVsSpecialitiesModels()){
						roomVsSpecialitiesModel.setCreatedBy(userId);
						RoomVsSpecialitiesEntity roomVsSpecialitiesEntity = roomVsSpecialitiesConverter.modelToEntity(roomVsSpecialitiesModel);
						roomVsSpecialitiesEntity.setRoomEntity(roomEntity);
						roomVsSpecialitiesDAO.save(roomVsSpecialitiesEntity);
					}
					
					//Room Vs Meal
					for(RoomVsMealModel roomVsMeal:roomModel.getRoomVsMealModels()){
						roomVsMeal.setCreatedBy(userId);
						RoomVsMealEntity roomVsMealEntity = roomVsMealConverter.modelToEntity(roomVsMeal);
						roomVsMealEntity.setRoomEntity(roomEntity);
						roomVsMealDAO.save(roomVsMealEntity);
					}
					
					//Room vs Cancellation
					for(RoomVsCancellationModel roomVsCancellationModel:roomModel.getRoomVsCancellationModels()){
						roomVsCancellationModel.setCreatedBy(userId);
						RoomVsCancellationEntity roomVsCancellationEntity = roomVsCancellationConverter.modelToEntity(roomVsCancellationModel);
						roomVsCancellationEntity.setRoomEntity(roomEntity);
						roomVsCancellationDAO.save(roomVsCancellationEntity);
					}
					
				}
				
				if (logger.isInfoEnabled()) {
					logger.info("updateProperty -- END");
				}


	}

	@Override
	public List<String> uploadFiles(MultipartFile[] files,String userToken) throws FormExceptions {
		
		if (logger.isInfoEnabled()) {
			logger.info("uploadFiles -- START");
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("uploadFiles -- END");
		}
		return propertyValidation.uploadFilesToLocalDrive(files,userToken);
	}

}