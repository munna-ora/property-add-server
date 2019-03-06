package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.RoomVsAmenitiesEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.RoomVsAmenitiesModel;

@Component
public class RoomVsAmenitiesConverter extends CommonConverter
		implements BaseConverter<RoomVsAmenitiesEntity, RoomVsAmenitiesModel> {

	private static final long serialVersionUID = -4858154515911634790L;
	private static final Logger logger = LogManager.getLogger(RoomVsAmenitiesConverter.class);

	@Override
	public RoomVsAmenitiesEntity modelToEntity(RoomVsAmenitiesModel m) {

		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomVsAmenitiesEntity roomVsAmenitiesEntity = new RoomVsAmenitiesEntity();
		roomVsAmenitiesEntity = (RoomVsAmenitiesEntity) Util.transform(modelMapper, m, roomVsAmenitiesEntity);
		roomVsAmenitiesEntity.setStatus(Status.ACTIVE.ordinal());
		roomVsAmenitiesEntity.setCreatedDate(Util.getCurrentDateTime());
		roomVsAmenitiesEntity.setAmenitiesEntity(amenitiesDAO.find(Long.valueOf(m.getAmenitiesModel().getAminitiesId())));

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomVsAmenitiesEntity;
		
	}

	@Override
	public RoomVsAmenitiesModel entityToModel(RoomVsAmenitiesEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomVsAmenitiesModel roomVsAmenitiesModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()){
			roomVsAmenitiesModel = new RoomVsAmenitiesModel();
			roomVsAmenitiesModel = (RoomVsAmenitiesModel) Util.transform(modelMapper, e, roomVsAmenitiesModel);
			roomVsAmenitiesModel.setAmenitiesModel(amenitiesConverter.entityToModel(e.getAmenitiesEntity()));
		}
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomVsAmenitiesModel;
	}

	@Override
	public List<RoomVsAmenitiesModel> entityListToModelList(List<RoomVsAmenitiesEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomVsAmenitiesModel> roomVsAmenitiesModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomVsAmenitiesModels = new ArrayList<>();
			for(RoomVsAmenitiesEntity roomVsAmenitiesEntity:es) {
				roomVsAmenitiesModels.add(entityToModel(roomVsAmenitiesEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomVsAmenitiesModels;
	}

}
