package com.orastays.propertyadd.validation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orastays.propertyadd.dao.AmenitiesDAO;
import com.orastays.propertyadd.dao.CancellationSlabDAO;
import com.orastays.propertyadd.dao.CityDAO;
import com.orastays.propertyadd.dao.DocumentDAO;
import com.orastays.propertyadd.dao.HostVsAccountDAO;
import com.orastays.propertyadd.dao.MealPlanDAO;
import com.orastays.propertyadd.dao.PropertyDAO;
import com.orastays.propertyadd.dao.PropertyTypeDAO;
import com.orastays.propertyadd.dao.PropertyVsDescriptionDAO;
import com.orastays.propertyadd.dao.PropertyVsDocumentDAO;
import com.orastays.propertyadd.dao.PropertyVsGuestAccessDAO;
import com.orastays.propertyadd.dao.PropertyVsImageDAO;
import com.orastays.propertyadd.dao.PropertyVsNearbyDAO;
import com.orastays.propertyadd.dao.PropertyVsSpaceRuleDAO;
import com.orastays.propertyadd.dao.PropertyVsSpecialExperienceDAO;
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
import com.orastays.propertyadd.dao.StayTypeDAO;
import com.orastays.propertyadd.exceptions.FormExceptions;
import com.orastays.propertyadd.helper.AzureApp;
import com.orastays.propertyadd.helper.MessageUtil;
import com.orastays.propertyadd.model.CommonModel;
import com.orastays.propertyadd.model.ResponseModel;
import com.orastays.propertyadd.model.auth.UserModel;
import com.orastays.propertyadd.model.booking.BookingModel;
import com.orastays.propertyadd.model.booking.CancellationModel;

@Component
public class AuthorizeUserValidation {

	private static final Logger logger = LogManager.getLogger(AuthorizeUserValidation.class);
	
	@Value("${entitymanager.packagesToScan}")
	protected String entitymanagerPackagesToScan;
	
	@Autowired
	protected MessageUtil messageUtil;
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected PropertyTypeDAO propertyTypeDAO;
	
	@Autowired
	protected SpaceRuleDAO spaceRuleDAO;
	
	@Autowired
	protected SpecialExperienceDAO specialExperienceDAO;
	
	@Autowired
	protected DocumentDAO documentDAO;
	
	@Autowired
	protected RoomCategoryDAO roomCategoryDAO;
	
	@Autowired
	protected RoomVsAmenitiesDAO roomVsAmenitiesDAO;
	
	@Autowired
	protected RoomVsCancellationDAO roomVsCancellationDAO;
	
	@Autowired
	protected CancellationSlabDAO cancellationSlabDAO;
	
	@Autowired
	protected SpecialtiesDAO specialtiesDAO;
	
	@Autowired
	protected AmenitiesDAO amenitiesDAO;
	
	@Autowired
	protected PropertyDAO propertyDAO;
	
	@Autowired
	protected PropertyVsDescriptionDAO propertyVsDescriptionDAO;
	
	@Autowired
	protected PropertyVsGuestAccessDAO propertyVsGuestAccessDAO;
	
	@Autowired
	protected PropertyVsNearbyDAO propertyVsNearbyDAO;
	
	@Autowired
	protected PropertyVsSpaceRuleDAO propertyVsSpaceRuleDAO;
	
	@Autowired
	protected PropertyVsSpecialExperienceDAO propertyVsSpecialExperienceDAO;
	
	@Autowired
	protected PropertyVsDocumentDAO propertyVsDocumentDAO;
	
	@Autowired
	protected RoomVsSpecialitiesDAO roomVsSpecialitiesDAO;
	
	@Autowired
	protected RoomVsMealDAO roomVsMealDAO;
	
	@Autowired
	protected HostVsAccountDAO userVsAccountDAO;
	
	@Autowired
	protected PropertyVsImageDAO propertyVsImageDAO;
	
	@Autowired
	protected RoomVsImageDAO roomVsImageDAO;
	
	@Autowired
	protected MealPlanDAO mealPlanDAO;
	
	@Autowired
	protected StayTypeDAO stayTypeDAO;
	
	@Autowired
	protected RoomDAO roomDAO;
	
	@Autowired
	protected AzureApp azureApp;
	
	@Autowired
	protected CityDAO cityDAO;
	
	public UserModel getUserDetails(String userToken) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("getUserDetails -- START");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		UserModel userModel = null;
		try {
			
			// Validate User Token
			if(StringUtils.isBlank(userToken)) {
				exceptions.put(messageUtil.getBundle("user.token.null.code"), new Exception(messageUtil.getBundle("user.token.null.message")));
			} else {
				try {
					ResponseModel responseModel = restTemplate.getForObject(messageUtil.getBundle("auth.server.url") +"check-token?userToken="+userToken, ResponseModel.class);
					Gson gson = new Gson();
					String jsonString = gson.toJson(responseModel.getResponseBody());
					userModel = gson.fromJson(jsonString, UserModel.class);
					if(Objects.isNull(userModel)) {
						exceptions.put(messageUtil.getBundle("session.expires.code"), new Exception(messageUtil.getBundle("session.expires.message")));
					}
				} catch(HttpClientErrorException e) {
					exceptions.put(messageUtil.getBundle("session.expires.code"), new Exception(messageUtil.getBundle("session.expires.message")));
				}
				
				if (logger.isInfoEnabled()) {
					logger.info("userModel ==>> "+userModel);
				}
			}
			
		} catch (Exception e) {
			// Disabled the below line to pass the Token Validation
			exceptions.put(messageUtil.getBundle("session.expires.code"), new Exception(messageUtil.getBundle("session.expires.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("getUserDetails -- END");
		}
		
		return userModel;
	}
	
	public CommonModel validateLanguage(String languageId) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("validateLanguage -- START");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		CommonModel commonModel = null;
		try {
			
			if(StringUtils.isBlank(languageId)) {
				exceptions.put(messageUtil.getBundle("language.id.null.code"), new Exception(messageUtil.getBundle("language.id.null.message")));
			} else {
			
				try {	
						ResponseModel responseModel = restTemplate.getForObject(messageUtil.getBundle("auth.server.url") +"check-language?languageId="+languageId, ResponseModel.class);
						Gson gson = new Gson();
						String jsonString = gson.toJson(responseModel.getResponseBody());
						commonModel = gson.fromJson(jsonString, CommonModel.class);
						if(Objects.isNull(commonModel)) {
							exceptions.put(messageUtil.getBundle("language.id.invalid.code"), new Exception(messageUtil.getBundle("language.id.invalid.message")));
						}
					
				} catch(HttpClientErrorException e) {
					exceptions.put(messageUtil.getBundle("language.id.invalid.code"), new Exception(messageUtil.getBundle("language.id.invalid.message")));
				}
				
				if (logger.isInfoEnabled()) {
					logger.info("commonModel ==>> "+commonModel);
				}
			}
			
		} catch (Exception e) {
			// Disabled the below line to pass the Language Validation
			exceptions.put(messageUtil.getBundle("language.id.invalid.code"), new Exception(messageUtil.getBundle("language.id.invalid.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("validateLanguage -- END");
		}
		
		return commonModel;
	}
	
	public List<BookingModel> getPropertyBookingList(BookingModel bookingModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("getPropertyBookingList -- START");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<BookingModel> bookingModels = null;
		try {
			
			String url = messageUtil.getBundle("booking.server.url") +"get-property-bookings";
			ResponseModel responseModel = restTemplate.postForObject(url, bookingModel,ResponseModel.class);
			
			Gson gson = new Gson();
			String jsonString = gson.toJson(responseModel.getResponseBody());
			bookingModels = gson.fromJson(jsonString,new TypeToken<List<BookingModel>>(){}.getType());
			
			if (logger.isInfoEnabled()) {
				logger.info("bookingModels ==>> "+bookingModels);
			}
			
		} catch (Exception e ) {
			exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("getPropertyBookingList -- END");
		}
		
		return bookingModels;
	}
	
	public List<BookingModel> getUserBookingList(String userId) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("getUserBookingList -- START");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<BookingModel> bookingModels = null;
		BookingModel bookingModel = new BookingModel();
		bookingModel.setUserId(userId);
		try {
			String url = messageUtil.getBundle("booking.server.url") +"get-user-bookings";
			ResponseModel responseModel = restTemplate.postForObject(url, bookingModel,ResponseModel.class);
			
			Gson gson = new Gson();
			String jsonString = gson.toJson(responseModel.getResponseBody());
			bookingModels = gson.fromJson(jsonString,new TypeToken<List<BookingModel>>(){}.getType());
			
			if (logger.isInfoEnabled()) {
				logger.info("bookingModels ==>> "+bookingModels);
			}
		} catch (Exception e) {
			exceptions.put(messageUtil.getBundle("user.id.invalid.code"), new Exception(messageUtil.getBundle("user.id.invalid.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("getUserBookingList -- END");
		}
		
		return bookingModels;
	}
	
	public List<CancellationModel> getPropertyCancellationList(BookingModel bookingModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("getPropertyCancellationList -- START");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<CancellationModel> cancellationModels = null;
		try {
			String url = messageUtil.getBundle("booking.server.url") +"get-property-cancellations";
			ResponseModel responseModel = restTemplate.postForObject(url, bookingModel,ResponseModel.class);
			
			Gson gson = new Gson();
			String jsonString = gson.toJson(responseModel.getResponseBody());
			cancellationModels = gson.fromJson(jsonString,new TypeToken<List<CancellationModel>>(){}.getType());
			
			if (logger.isInfoEnabled()) {
				logger.info("cancellationModels ==>> "+cancellationModels);
			}
		} catch (Exception e) {
			exceptions.put(messageUtil.getBundle("property.id.invalid.code"), new Exception(messageUtil.getBundle("property.id.invalid.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("getPropertyBookingList -- END");
		}
		
		return cancellationModels;
	}
	
	public List<CancellationModel> getUserCancellationList(BookingModel bookingModel) throws FormExceptions {

		if (logger.isInfoEnabled()) {
			logger.info("getUserCancellationList -- START");
		}
		
		Map<String, Exception> exceptions = new LinkedHashMap<>();
		List<CancellationModel> cancellationModels = null;
		try {
			String url = messageUtil.getBundle("booking.server.url") +"get-user-cancellations";
			ResponseModel responseModel = restTemplate.postForObject(url, bookingModel,ResponseModel.class);
			
			Gson gson = new Gson();
			String jsonString = gson.toJson(responseModel.getResponseBody());
			cancellationModels = gson.fromJson(jsonString,new TypeToken<List<BookingModel>>(){}.getType());
			
			if (logger.isInfoEnabled()) {
				logger.info("cancellationModels ==>> "+cancellationModels);
			}
		} catch (Exception e) {
			exceptions.put(messageUtil.getBundle("user.id.invalid.code"), new Exception(messageUtil.getBundle("user.id.invalid.message")));
		}
		
		if (exceptions.size() > 0)
			throw new FormExceptions(exceptions);
		
		if (logger.isInfoEnabled()) {
			logger.info("getUserCancellationList -- END");
		}
		
		return cancellationModels;
	}
	
}