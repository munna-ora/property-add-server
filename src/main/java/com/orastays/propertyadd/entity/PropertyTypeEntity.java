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
@Table(name = "master_property_type")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PropertyTypeEntity extends CommonEntity {

	private static final long serialVersionUID = 4064653909402332809L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_type_id")
	@JsonProperty("propertyTypeId")
	private Long propertyTypeId;

	@Column(name = "language_id")
	@JsonProperty("languageId")
	private Long languageId;

	@Column(name = "parent_id")
	@JsonProperty("parentId")
	private Long parentId;

	@Column(name = "name")
	@JsonProperty("name")
	private String name;
	
	@Column(name = "img_url")
	@JsonProperty("imgUrl")
	private String imgUrl;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyTypeEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertys")
	private List<PropertyEntity> propertyEntities;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyTypeEntity", cascade = { CascadeType.ALL })
	@JsonProperty("roomCategorys")
	private List<RoomCategoryEntity> roomCategoryEntities;

	@Override
	public String toString() {
		return Long.toString(propertyTypeId);
	}
}
