/**
 * @author Krishanu 
 */
package com.orastays.propertyadd.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class HostVsAccountModel extends CommonModel {

	@JsonProperty("hostVsAccountId")
	private String hostVsAccountId;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("accountNumber")
	private String accountNumber;

	@JsonProperty("accountHolderName")
	private String accountHolderName;

	@JsonProperty("accountType")
	private String accountType;

	@JsonProperty("bankName")
	private String bankName;

	@JsonProperty("branchName")
	private String branchName;

	@JsonProperty("ifscCode")
	private String ifscCode;

	@JsonProperty("propertys")
	private List<PropertyModel> propertyModels;
}
