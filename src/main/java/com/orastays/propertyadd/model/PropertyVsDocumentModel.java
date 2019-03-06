package com.orastays.propertyadd.model;

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
public class PropertyVsDocumentModel extends CommonModel {

	@JsonProperty("propertyVsDocumentId")
	private String propertyVsDocumentId;

	@JsonProperty("documentNumber")
	private String documentNumber;

	@JsonProperty("fileUrl")
	private String fileUrl;

	@JsonProperty("property")
	private PropertyModel propertyModel;

	@JsonProperty("document")
	private DocumentModel documentModel;
}
