package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.PropertyEntity;

@Repository
public class PropertyDAO extends GenericDAO<PropertyEntity, Long>{

	private static final long serialVersionUID = -7671486148453498082L;

	public PropertyDAO() {
		super(PropertyEntity.class);
	}
}
