package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.OfferEntity;

@Repository
public class OfferDAO extends GenericDAO<OfferEntity, Long> {

	private static final long serialVersionUID = 6689374192495957552L;

	public OfferDAO() {
		super(OfferEntity.class);
	}
}
