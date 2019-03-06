package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.RoomVsMealEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.RoomVsMealModel;

@Component
public class RoomVsMealConverter extends CommonConverter
		implements BaseConverter<RoomVsMealEntity, RoomVsMealModel> {

	private static final long serialVersionUID = -4627576649206466658L;
	
	private static final Logger logger = LogManager.getLogger(RoomVsMealConverter.class);

	@Override
	public RoomVsMealEntity modelToEntity(RoomVsMealModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomVsMealEntity roomVsMealEntity = new RoomVsMealEntity();
		roomVsMealEntity = (RoomVsMealEntity) Util.transform(modelMapper, m, roomVsMealEntity);
		roomVsMealEntity.setMealPlanEntity(mealPlanDAO.find(Long.valueOf(m.getMealPlanModel().getMealPlanId())));
		roomVsMealEntity.setStatus(Status.ACTIVE.ordinal());
		roomVsMealEntity.setCreatedDate(Util.getCurrentDateTime());

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomVsMealEntity;
	}

	@Override
	public RoomVsMealModel entityToModel(RoomVsMealEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomVsMealModel roomVsMealModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			roomVsMealModel = new RoomVsMealModel();
			roomVsMealModel = (RoomVsMealModel) Util.transform(modelMapper, e, roomVsMealModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomVsMealModel;
	}

	@Override
	public List<RoomVsMealModel> entityListToModelList(List<RoomVsMealEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomVsMealModel> roomVsMealModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomVsMealModels = new ArrayList<>();
			for(RoomVsMealEntity roomVsMealEntity:es) {
				roomVsMealModels.add(entityToModel(roomVsMealEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomVsMealModels;
	}

}
