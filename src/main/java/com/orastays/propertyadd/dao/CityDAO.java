package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.CityEntity;

@Repository
public class CityDAO extends GenericDAO<CityEntity, Long>{


	private static final long serialVersionUID = 1349708224691598471L;

	public CityDAO() {
		super(CityEntity.class);
	}
}
