package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.RoomCategoryEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.RoomCategoryModel;

@Component
public class RoomCategoryConverter extends CommonConverter
		implements BaseConverter<RoomCategoryEntity, RoomCategoryModel> {

	private static final long serialVersionUID = 6255959173759896724L;
	private static final Logger logger = LogManager.getLogger(RoomCategoryConverter.class);

	@Override
	public RoomCategoryEntity modelToEntity(RoomCategoryModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomCategoryEntity roomCategoryEntity = new RoomCategoryEntity();
		roomCategoryEntity = (RoomCategoryEntity) Util.transform(modelMapper, m, roomCategoryEntity);
		roomCategoryEntity.setStatus(Status.INACTIVE.ordinal());
		roomCategoryEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		roomCategoryEntity.setCreatedDate(Util.getCurrentDateTime());

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomCategoryEntity;
	}

	@Override
	public RoomCategoryModel entityToModel(RoomCategoryEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomCategoryModel roomCategoryModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
		 roomCategoryModel = new RoomCategoryModel();
		 roomCategoryModel = (RoomCategoryModel) Util.transform(modelMapper, e, roomCategoryModel);
		}
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomCategoryModel;
	}

	@Override
	public List<RoomCategoryModel> entityListToModelList(List<RoomCategoryEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomCategoryModel> roomCategoryModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomCategoryModels = new ArrayList<>();
			for(RoomCategoryEntity roomCategoryEntity:es) {
				roomCategoryModels.add(entityToModel(roomCategoryEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomCategoryModels;
	}

}
