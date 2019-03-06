package com.orastays.propertyadd.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.orastays.propertyadd.exceptions.FormExceptions;
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
import com.orastays.propertyadd.model.PropertyVsToiletryModel;
import com.orastays.propertyadd.model.RoomCategoryModel;
import com.orastays.propertyadd.model.SpaceRuleModel;
import com.orastays.propertyadd.model.SpecialExperienceModel;
import com.orastays.propertyadd.model.SpecialtiesModel;
import com.orastays.propertyadd.model.StateModel;
import com.orastays.propertyadd.model.StayTypeModel;

public interface PropertyService {

	List<PropertyTypeModel> fetchPropertyTypes() throws FormExceptions;
	List<ContactPurposeModel> fetchContactPurpose() throws FormExceptions;
	List<CountryModel> fetchCountryList() throws FormExceptions;
	List<StateModel> fetchStateByCountry(CountryModel countryModel);
	List<CityModel> fetchCityByState(StateModel stateModel);
	List<StayTypeModel> fetchStayTypeList(CommonModel commonModel) throws FormExceptions;
	List<String> fetchAccommodationByLanguage(CommonModel commonModel) throws FormExceptions;
	List<String> fetchPgCategorySexListByLanguage(CommonModel commonModel) throws FormExceptions;
	List<String> fetchAmenitiesTypeList(CommonModel commonModel) throws FormExceptions;
	List<AmenitiesModel> fetchAmenitiesList(CommonModel commonModel) throws FormExceptions;
	List<SpecialExperienceModel> fetchSpecialExperienceList(CommonModel commonModel) throws FormExceptions;
	List<DocumentModel> fetchDocumentList(CommonModel commonModel) throws FormExceptions;
	List<SpaceRuleModel> fetchSpaceRuleList(CommonModel commonModel) throws FormExceptions;
	List<SpecialtiesModel> fetchSpecialtiesList(CommonModel commonModel) throws FormExceptions;
	List<RoomCategoryModel> fetchRoomCategoryList(CommonModel commonModel) throws FormExceptions;
	List<CancellationSlabModel> fetchCancellationSlabList() throws FormExceptions;
	List<PriceDropModel> fetchPriceDropList() throws FormExceptions;
	void saveProperty(PropertyModel propertyModel) throws FormExceptions;
	List<PropertyModel> fetchActivePropertyList(CommonModel commonModel) throws FormExceptions;
	List<PropertyVsToiletryModel> fetchToiletry(CommonModel commonModel) throws FormExceptions;
	PropertyModel fetchPropertyById(PropertyModel propertyModel) throws FormExceptions;
	void updateProperty(PropertyModel propertyModel) throws FormExceptions;
	List<AmenitiesModel> fetchAmenitiesForFilter() throws FormExceptions;
	List<String> uploadFiles(MultipartFile[] file,String userToken) throws FormExceptions;
}