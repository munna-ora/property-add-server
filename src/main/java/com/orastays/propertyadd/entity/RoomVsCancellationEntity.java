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
@Table(name = "room_vs_cancellation")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomVsCancellationEntity extends CommonEntity {

	private static final long serialVersionUID = -8225974515594117532L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rc_id")
	@JsonProperty("rcId")
	private Long rcId;

	@Column(name = "percentage")
	@JsonProperty("percentage")
	private String percentage;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "cancellation_slab_id", nullable = false)
	@JsonProperty("cancellationSlab")
	private CancellationSlabEntity cancellationSlabEntity;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "room_id", nullable = false)
	@JsonProperty("room")
	private RoomEntity roomEntity;

	@Override
	public String toString() {
		return Long.toString(rcId);
	}
}