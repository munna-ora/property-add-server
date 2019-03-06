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
@Table(name = "master_cancellation_slab")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class CancellationSlabEntity extends CommonEntity{
	
	private static final long serialVersionUID = -6035398241294191312L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cancellation_slab_id")
	@JsonProperty("cancellationSlabId")
	private Long cancellationSlabId;
	
	@Column(name = "start_time")
	@JsonProperty("startTime")
	private String startTime;
	
	@Column(name = "end_time")
	@JsonProperty("endTime")
	private String endTime;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cancellationSlabEntity", cascade = { CascadeType.ALL })
	@JsonProperty("roomVsCancellations")
	private List<RoomVsCancellationEntity> roomVsCancellationEntities;
	
	@Override
	public String toString() {
		return Long.toString(cancellationSlabId);
	}

}
