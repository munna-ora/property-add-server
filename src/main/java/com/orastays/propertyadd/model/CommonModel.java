/**
 * @author Abhideep
 */
package com.orastays.propertyadd.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class CommonModel {

	private Integer status;
	private String createdDate;
	private Long createdBy;
	private String modifiedDate;
	private Long modifiedBy;
	private String userToken;
	private String languageId;

}