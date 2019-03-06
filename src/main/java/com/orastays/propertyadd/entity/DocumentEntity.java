package com.orastays.propertyadd.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_document")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class DocumentEntity extends CommonEntity {

	private static final long serialVersionUID = -2618733428008081069L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "document_id")
	@JsonProperty("documentId")
	private Long documentId;

	@Column(name = "document_name")
	@JsonProperty("documentName")
	private String documentName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "documentEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertyVsDocuments")
	private List<PropertyVsDocumentEntity> propertyVsDocumentEntities;

	@Override
	public String toString() {
		return Long.toString(documentId);
	}

}
