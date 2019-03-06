package com.orastays.propertyadd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.orastays.propertyadd.converter.AmenitiesConverter;
import com.orastays.propertyadd.converter.CancellationSlabConverter;
import com.orastays.propertyadd.converter.CityConverter;
import com.orastays.propertyadd.converter.ContactPurposeConverter;
import com.orastays.propertyadd.converter.CountryConverter;
import com.orastays.propertyadd.converter.DocumentConverter;
import com.orastays.propertyadd.converter.HostVsAccountConverter;
import com.orastays.propertyadd.converter.PriceDropConverter;
import com.orastays.propertyadd.converter.PropertyConverter;
import com.orastays.propertyadd.converter.PropertyTypeConverter;
import com.orastays.propertyadd.converter.PropertyVsDescriptionConverter;
import com.orastays.propertyadd.converter.PropertyVsDocumentConverter;
import com.orastays.propertyadd.converter.PropertyVsGuestAccessConverter;
import com.orastays.propertyadd.converter.PropertyVsImageConverter;
import com.orastays.propertyadd.converter.PropertyVsNearbyConverter;
import com.orastays.propertyadd.converter.PropertyVsPriceDropConverter;
import com.orastays.propertyadd.converter.PropertyVsSpaceRuleConverter;
import com.orastays.propertyadd.converter.PropertyVsSpecialExperienceConverter;
import com.orastays.propertyadd.converter.PropertyVsToiletryConverter;
import com.orastays.propertyadd.converter.RoomCategoryConverter;
import com.orastays.propertyadd.converter.RoomConverter;
import com.orastays.propertyadd.converter.RoomVsAmenitiesConverter;
import com.orastays.propertyadd.converter.RoomVsCancellationConverter;
import com.orastays.propertyadd.converter.RoomVsImageConverter;
import com.orastays.propertyadd.converter.RoomVsMealConverter;
import com.orastays.propertyadd.converter.RoomVsSpecialitiesConverter;
import com.orastays.propertyadd.converter.SpaceRuleConverter;
import com.orastays.propertyadd.converter.SpecialExperienceConverter;
import com.orastays.propertyadd.converter.SpecialtiesConverter;
import com.orastays.propertyadd.converter.StateConverter;
import com.orastays.propertyadd.converter.StayTypeConverter;
import com.orastays.propertyadd.dao.AmenitiesDAO;
import com.orastays.propertyadd.dao.CancellationSlabDAO;
import com.orastays.propertyadd.dao.CityDAO;
import com.orastays.propertyadd.dao.ContactPurposeDAO;
import com.orastays.propertyadd.dao.CountryDAO;
import com.orastays.propertyadd.dao.DocumentDAO;
import com.orastays.propertyadd.dao.HostVsAccountDAO;
import com.orastays.propertyadd.dao.PriceDropDAO;
import com.orastays.propertyadd.dao.PropertyDAO;
import com.orastays.propertyadd.dao.PropertyTypeDAO;
import com.orastays.propertyadd.dao.PropertyVsDescriptionDAO;
import com.orastays.propertyadd.dao.PropertyVsDocumentDAO;
import com.orastays.propertyadd.dao.PropertyVsGuestAccessDAO;
import com.orastays.propertyadd.dao.PropertyVsImageDAO;
import com.orastays.propertyadd.dao.PropertyVsNearbyDAO;
import com.orastays.propertyadd.dao.PropertyVsPriceDropDAO;
import com.orastays.propertyadd.dao.PropertyVsSpaceRuleDAO;
import com.orastays.propertyadd.dao.PropertyVsSpecialExperienceDAO;
import com.orastays.propertyadd.dao.PropertyVsToiletryDAO;
import com.orastays.propertyadd.dao.RoomCategoryDAO;
import com.orastays.propertyadd.dao.RoomDAO;
import com.orastays.propertyadd.dao.RoomVsAmenitiesDAO;
import com.orastays.propertyadd.dao.RoomVsCancellationDAO;
import com.orastays.propertyadd.dao.RoomVsImageDAO;
import com.orastays.propertyadd.dao.RoomVsMealDAO;
import com.orastays.propertyadd.dao.RoomVsSpecialitiesDAO;
import com.orastays.propertyadd.dao.SpaceRuleDAO;
import com.orastays.propertyadd.dao.SpecialExperienceDAO;
import com.orastays.propertyadd.dao.SpecialtiesDAO;
import com.orastays.propertyadd.dao.StateDAO;
import com.orastays.propertyadd.dao.StayTypeDAO;
import com.orastays.propertyadd.helper.AzureFileUpload;
import com.orastays.propertyadd.helper.DateCalculation;
import com.orastays.propertyadd.helper.MailHelper;
import com.orastays.propertyadd.helper.MessageUtil;
import com.orastays.propertyadd.validation.PropertyValidation;
import com.orastays.propertyadd.validation.ReportValidation;

public abstract class BaseServiceImpl {

	@Value("${entitymanager.packagesToScan}")
	protected String entitymanagerPackagesToScan;
	
	@Autowired
	protected MessageUtil messageUtil;
	
	@Autowired
	protected DateCalculation dateCalculation;

	@Autowired
	protected PropertyValidation propertyValidation;
	
	@Autowired
	protected ReportValidation reportValidation;

	@Autowired
	protected PropertyTypeDAO propertyTypeDAO;

	@Autowired
	protected PropertyTypeConverter propertyTypeConverter;

	@Autowired
	protected StayTypeConverter stayTypeConverter;

	@Autowired
	protected StayTypeDAO stayTypeDAO;
	
	@Autowired
	protected CountryConverter countryConverter;

	@Autowired
	protected CountryDAO countryDAO;

	@Autowired
	protected AmenitiesConverter amenitiesConverter;

	@Autowired
	protected AmenitiesDAO amenitiesDAO;

	@Autowired
	protected SpecialExperienceConverter specialExperienceConverter;

	@Autowired
	protected SpecialExperienceDAO specialExperienceDAO;

	@Autowired
	protected SpaceRuleConverter spaceRuleConverter;

	@Autowired
	protected SpaceRuleDAO spaceRuleDAO;

	@Autowired
	protected SpecialtiesConverter specialtiesConverter;

	@Autowired
	protected SpecialtiesDAO specialtiesDAO;
	
	@Autowired
	protected StateConverter stateConverter;

	@Autowired
	protected StateDAO stateDAO;
	
	@Autowired
	protected CityConverter cityConverter;

	@Autowired
	protected CityDAO cityDAO;

	@Autowired
	protected RoomCategoryConverter roomCategoryConverter;

	@Autowired
	protected RoomCategoryDAO roomCategoryDAO;

	@Autowired
	protected CancellationSlabConverter cancellationSlabConverter;

	@Autowired
	protected CancellationSlabDAO cancellationSlabDAO;
	
	@Autowired
	protected DocumentConverter documentConverter;

	@Autowired
	protected DocumentDAO documentDAO;

	@Autowired
	protected PriceDropDAO priceDropDAO;

	@Autowired
	protected PriceDropConverter priceDropConverter;

	@Autowired
	protected PropertyConverter propertyConverter;

	@Autowired
	protected PropertyDAO propertyDAO;

	@Autowired
	protected HostVsAccountConverter userVsAccountConverter;

	@Autowired
	protected HostVsAccountDAO userVsAccountDAO;

	@Autowired
	protected PropertyVsDescriptionConverter propertyVsDescriptionConverter;

	@Autowired
	protected PropertyVsDescriptionDAO propertyVsDescriptionDAO;

	@Autowired
	protected PropertyVsDocumentConverter propertyVsDocumentConverter;

	@Autowired
	protected PropertyVsDocumentDAO propertyVsDocumentDAO;

	@Autowired
	protected PropertyVsSpecialExperienceConverter pVsSpecialExperienceConverter;

	@Autowired
	protected PropertyVsSpecialExperienceDAO propertyVsSpecialExperienceDAO;

	@Autowired
	protected PropertyVsGuestAccessConverter propertyVsGuestAccessConverter;

	@Autowired
	protected PropertyVsGuestAccessDAO propertyVsGuestAccessDAO;

	@Autowired
	protected PropertyVsImageConverter propertyVsImageConverter;

	@Autowired
	protected PropertyVsImageDAO propertyVsImageDAO;

	@Autowired
	protected PropertyVsNearbyConverter propertyVsNearbyConverter;

	@Autowired
	protected PropertyVsNearbyDAO propertyVsNearbyDAO;

	@Autowired
	protected PropertyVsPriceDropConverter propertyVsPriceDropConverter;

	@Autowired
	protected PropertyVsPriceDropDAO propertyVsPriceDropDAO;

	@Autowired
	protected PropertyVsSpaceRuleConverter propertyVsSpaceRuleConverter;

	@Autowired
	protected PropertyVsSpaceRuleDAO propertyVsSpaceRuleDAO;

	@Autowired
	protected RoomConverter roomConverter;

	@Autowired
	protected RoomDAO roomDAO;

	@Autowired
	protected RoomVsAmenitiesDAO roomVsAmenitiesDAO;

	@Autowired
	protected RoomVsAmenitiesConverter roomVsAmenitiesConverter;

	@Autowired
	protected RoomVsImageDAO roomVsImageDAO;

	@Autowired
	protected RoomVsImageConverter roomVsImageConverter;
	
	@Autowired
	protected PropertyVsToiletryDAO propertyVsToiletryDAO;

	@Autowired
	protected PropertyVsToiletryConverter propertyVsToiletryConverter;

	@Autowired
	protected RoomVsSpecialitiesConverter roomVsSpecialitiesConverter;

	@Autowired
	protected RoomVsSpecialitiesDAO roomVsSpecialitiesDAO;
	
	@Autowired
	protected ContactPurposeConverter contactPurposeConverter;

	@Autowired
	protected ContactPurposeDAO contactPurposeDAO;

	@Autowired
	protected RoomVsMealConverter roomVsMealConverter;

	@Autowired
	protected RoomVsMealDAO roomVsMealDAO;

	@Autowired
	protected RoomVsCancellationConverter roomVsCancellationConverter;

	@Autowired
	protected RoomVsCancellationDAO roomVsCancellationDAO;

	@Autowired
	protected AzureFileUpload azureFileUpload;
	
	@Autowired
	protected MailHelper mailHelper;

}
