package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.SpecialtiesEntity;

@Repository
public class SpecialtiesDAO extends GenericDAO<SpecialtiesEntity, Long>{

	private static final long serialVersionUID = 8334316579662908618L;

	public SpecialtiesDAO() {
		super(SpecialtiesEntity.class);
	}
}
