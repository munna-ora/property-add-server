/**
 * @author Abhideep
 */
package com.orastays.propertyadd.model.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.orastays.propertyadd.model.CommonModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class UserVsTypeModel extends CommonModel {

	@JsonProperty("userVsTypeId")
	private String userVsTypeId;
	
	@JsonProperty("user")
	private UserModel userModel;
	
	@JsonProperty("userType")
	private UserTypeModel userType;
}
