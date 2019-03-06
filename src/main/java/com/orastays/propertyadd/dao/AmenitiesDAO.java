package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.AmenitiesEntity;

@Repository
public class AmenitiesDAO extends GenericDAO<AmenitiesEntity, Long> {

	private static final long serialVersionUID = -4781993867491997948L;

	public AmenitiesDAO() {
		super(AmenitiesEntity.class);

	}
}
