package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.PropertyVsToiletryEntity;

@Repository
public class PropertyVsToiletryDAO extends GenericDAO<PropertyVsToiletryEntity, Long> {

	private static final long serialVersionUID = -6726728077825480970L;

	public PropertyVsToiletryDAO() {
		super(PropertyVsToiletryEntity.class);
	}
}
