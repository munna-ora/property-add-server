package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.PriceDropEntity;

@Repository
public class PriceDropDAO extends GenericDAO<PriceDropEntity, Long>{

	private static final long serialVersionUID = -7008495150227852367L;

	public PriceDropDAO() {
		super(PriceDropEntity.class);
	}
}
