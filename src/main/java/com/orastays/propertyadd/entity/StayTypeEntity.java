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
@Table(name = "master_stay_type")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class StayTypeEntity  extends CommonEntity {

	private static final long serialVersionUID = -3614599798351715620L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stay_type_id")
	@JsonProperty("stayTypeId")
	private Long stayTypeId;
	
	@Column(name = "language_id")
	@JsonProperty("languageId")
	private Long languageId;

	@Column(name = "parent_id")
	@JsonProperty("parentId")
	private Long parentId;

	@Column(name = "stay_type_name")
	@JsonProperty("stayTypeName")
	private String stayTypeName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stayTypeEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertys")
	private List<PropertyEntity> propertyEntities;
	
	@Override
	public String toString() {
		return Long.toString(stayTypeId);
	}
	
}
