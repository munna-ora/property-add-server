package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.PropertyTypeEntity;

@Repository
public class PropertyTypeDAO extends GenericDAO<PropertyTypeEntity, Long>{

	private static final long serialVersionUID = 484373964101928009L;

	public PropertyTypeDAO() {
		super(PropertyTypeEntity.class);
	}
}
