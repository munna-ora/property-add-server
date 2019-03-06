package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.RoomCategoryEntity;

@Repository
public class RoomCategoryDAO extends GenericDAO<RoomCategoryEntity, Long>{

	private static final long serialVersionUID = 9118506140095758344L;

	public RoomCategoryDAO() {
		super(RoomCategoryEntity.class);
	}
}
