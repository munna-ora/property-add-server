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
@Table(name = "room_vs_image")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomVsImageEntity extends CommonEntity {

	private static final long serialVersionUID = -3792169192286757956L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_vs_image_id")
	@JsonProperty("roomVsImageId")
	private Long roomVsImageId;

	@Column(name = "image_url")
	@JsonProperty("imageUrl")
	private String imageUrl;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "room_id", nullable = false)
	@JsonProperty("room")
	private RoomEntity roomEntity;

	@Override
	public String toString() {
		return Long.toString(roomVsImageId);
	}

}
