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
@Table(name = "master_gst_slab")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class GstSlabEntity extends CommonEntity {

	private static final long serialVersionUID = -3976213837715041852L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gst_slab_id")
	@JsonProperty("gstSlabId")
	private Long gstSlabId;

	@Column(name = "from_amount")
	@JsonProperty("fromAmount")
	private String fromAmount;

	@Column(name = "to_amount")
	@JsonProperty("toAmount")
	private String toAmount;

	@Column(name = "percentage")
	@JsonProperty("percentage")
	private String percentage;

	@Override
	public String toString() {
		return Long.toString(gstSlabId);
	}

}
