/**
 * @author Abhideep
 */
package com.orastays.propertyadd.model.auth;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orastays.propertyadd.model.CommonModel;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class UserModel extends CommonModel {

	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("mobileNumber")
	private String mobileNumber;
	
	@JsonProperty("emailId")
	private String emailId;
	
	@JsonProperty("userVsTypes")
	private List<UserVsTypeModel> userVsTypes;
}