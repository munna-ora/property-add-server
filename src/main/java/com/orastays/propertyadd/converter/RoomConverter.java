package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.RoomEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.RoomModel;

@Component
public class RoomConverter extends CommonConverter
		implements BaseConverter<RoomEntity, RoomModel> {

	
	private static final long serialVersionUID = -6532505845959859730L;
	private static final Logger logger = LogManager.getLogger(RoomConverter.class);

	@Override
	public RoomEntity modelToEntity(RoomModel m) {

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomEntity roomEntity = new RoomEntity();
		roomEntity = (RoomEntity) Util.transform(modelMapper, m, roomEntity);
		roomEntity.setStatus(Status.ACTIVE.ordinal());
		roomEntity.setCreatedDate(Util.getCurrentDateTime());
		
		roomEntity.setRoomCategoryEntity(roomCategoryDAO.find(Long.valueOf(m.getRoomCategoryModel().getRoomCatId())));

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomEntity;
		
	}

	@Override
	public RoomModel entityToModel(RoomEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomModel roomModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()){
			roomModel = new RoomModel();
			roomModel = (RoomModel) Util.transform(modelMapper, e, roomModel);
			
			roomModel.setRoomCategoryModel(roomCategoryConverter.entityToModel(e.getRoomCategoryEntity()));
			roomModel.setRoomVsAmenitiesModels(roomVsAmenitiesConverter.entityListToModelList(e.getRoomVsAmenitiesEntities()));
			roomModel.setRoomVsCancellationModels(roomVsCancellationConverter.entityListToModelList(e.getRoomVsCancellationEntities()));
			roomModel.setRoomVsImageModels(roomVsImageConverter.entityListToModelList(e.getRoomVsImageEntities()));
			roomModel.setRoomVsSpecialitiesModels(roomVsSpecialitiesConverter.entityListToModelList(e.getRoomVsSpecialitiesEntities()));
			roomModel.setRoomVsMealModels(roomVsMealConverter.entityListToModelList(e.getRoomVsMealEntities()));
			
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomModel;
	}

	@Override
	public List<RoomModel> entityListToModelList(List<RoomEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomModel> roomModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomModels = new ArrayList<>();
			for(RoomEntity roomEntity:es) {
				roomModels.add(entityToModel(roomEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomModels;
	}

	

}
