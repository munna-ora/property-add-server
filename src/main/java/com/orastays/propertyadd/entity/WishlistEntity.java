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
@Table(name = "master_wishlist")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class WishlistEntity extends CommonEntity {

	private static final long serialVersionUID = 4668857794991186192L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_id")
	@JsonProperty("wishlistId")
	private Long wishlistId;
	
	@Column(name = "user_id")
	@JsonProperty("userId")
	private Long userId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "property_id", nullable = false)
	@JsonProperty("property")
	private PropertyEntity propertyEntity;

	@Override
	public String toString() {
		return Long.toString(wishlistId);
	}

}
