package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.RoomVsCancellationEntity;

@Repository
public class RoomVsCancellationDAO extends GenericDAO<RoomVsCancellationEntity, Long>{

	private static final long serialVersionUID = -5550519055926672481L;

	public RoomVsCancellationDAO() {
		super(RoomVsCancellationEntity.class);
	}
}
