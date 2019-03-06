package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.SpecialExperienceEntity;

@Repository
public class SpecialExperienceDAO extends GenericDAO<SpecialExperienceEntity, Long>{

	private static final long serialVersionUID = 8791719028635636471L;

	public SpecialExperienceDAO() {
		super(SpecialExperienceEntity.class);
	}
}
