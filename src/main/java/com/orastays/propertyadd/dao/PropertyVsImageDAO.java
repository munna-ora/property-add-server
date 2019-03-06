package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.PropertyVsImageEntity;

@Repository
public class PropertyVsImageDAO extends GenericDAO<PropertyVsImageEntity, Long>{

	private static final long serialVersionUID = 6621661402386620619L;

	public PropertyVsImageDAO() {
		super(PropertyVsImageEntity.class);
	}
}
