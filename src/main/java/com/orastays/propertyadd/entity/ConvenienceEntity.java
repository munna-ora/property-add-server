/**
 * @author SUDEEP
 */
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
@Table(name = "master_convenience")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ConvenienceEntity extends CommonEntity {

	private static final long serialVersionUID = -5524139157964589439L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "convenience_id")
	@JsonProperty("convenienceId")
	private Long convenienceId;

	@Column(name = "amount")
	@JsonProperty("amount")
	private String amount;
	
	@Column(name = "gst_percentage")
	@JsonProperty("gstPercentage")
	private String gstPercentage;
	
	@Override
	public String toString() {
		return Long.toString(convenienceId);
	}

}
