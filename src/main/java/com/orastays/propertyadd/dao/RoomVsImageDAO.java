package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.RoomVsImageEntity;

@Repository
public class RoomVsImageDAO extends GenericDAO<RoomVsImageEntity, Long>{

	private static final long serialVersionUID = -2939940872528393803L;

	public RoomVsImageDAO() {
		super(RoomVsImageEntity.class);
	}
}
