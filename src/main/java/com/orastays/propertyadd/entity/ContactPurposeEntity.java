package com.orastays.propertyadd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_contact_purpose")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ContactPurposeEntity extends CommonEntity {

	private static final long serialVersionUID = -7751225088629091390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_purpose_id")
	@JsonProperty("contactPurposeId")
	private Long contactPurposeId;

	@Column(name = "contact_purpose_name")
	@JsonProperty("contactPurposeName")
	private String contactPurposeName;

	@Override
	public String toString() {
		return Long.toString(contactPurposeId);
	}

}
