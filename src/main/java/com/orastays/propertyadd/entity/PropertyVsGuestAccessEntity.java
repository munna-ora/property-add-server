package com.orastays.propertyadd.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "property_vs_guest_access")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PropertyVsGuestAccessEntity extends CommonEntity  {
	
	private static final long serialVersionUID = 3583573903856801930L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_gaccess_id")
	@JsonProperty("propertyGAccessId")
	private Long propertyGAccessId;

	@Column(name = "guest_access")
	@JsonProperty("guestAccess")
	private String guestAccess;
	
	@Column(name = "language_id")
	@JsonProperty("languageId")
	private Long languageId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "property_id", nullable = false)
	@JsonProperty("property")
	private PropertyEntity propertyEntity;
	
	@Override
	public String toString() {
		return Long.toString(propertyGAccessId);
	}
}
