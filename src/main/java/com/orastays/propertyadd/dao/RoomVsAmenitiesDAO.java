package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.RoomVsAmenitiesEntity;

@Repository
public class RoomVsAmenitiesDAO  extends GenericDAO<RoomVsAmenitiesEntity, Long>{

	private static final long serialVersionUID = -6937519057315280276L;

	public RoomVsAmenitiesDAO() {
		super(RoomVsAmenitiesEntity.class);
	}
}
