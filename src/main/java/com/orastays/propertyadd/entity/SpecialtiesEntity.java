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
@Table(name = "master_specialties")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SpecialtiesEntity extends CommonEntity {

	private static final long serialVersionUID = -6613026495348387173L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "specialties_id")
	@JsonProperty("specialtiesId")
	private Long specialtiesId;

	@Column(name = "name")
	@JsonProperty("specialitiesName")
	private String specialitiesName;

	@Column(name = "language_id")
	@JsonProperty("languageId")
	private Long languageId;

	@Column(name = "parent_id")
	@JsonProperty("parentId")
	private Long parentId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialtiesEntity", cascade = { CascadeType.ALL })
	@JsonProperty("roomVsSpecialities")
	private List<RoomVsSpecialitiesEntity> roomVsSpecialitiesEntities;

	@Override
	public String toString() {
		return Long.toString(specialtiesId);
	}
}
