package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.GstSlabEntity;

@Repository
public class GstSlabDAO extends GenericDAO<GstSlabEntity, Long> {

	private static final long serialVersionUID = 4458145644390220480L;

	public GstSlabDAO() {
		super(GstSlabEntity.class);

	}
}
