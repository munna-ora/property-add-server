package com.orastays.propertyadd.model;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class DocumentModel {

	@JsonProperty("documentId")
	private String documentId;

	@JsonProperty("documentName")
	private String documentName;

	@JsonProperty("propertyVsDocuments")
	private List<PropertyVsDocumentModel> propertyVsDocumentModels;
}
