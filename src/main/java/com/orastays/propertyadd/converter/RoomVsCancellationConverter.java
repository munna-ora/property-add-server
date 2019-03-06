package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.RoomVsCancellationEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.RoomVsCancellationModel;

@Component
public class RoomVsCancellationConverter extends CommonConverter
		implements BaseConverter<RoomVsCancellationEntity, RoomVsCancellationModel> {

	private static final long serialVersionUID = 5826695203338063494L;
	private static final Logger logger = LogManager.getLogger(RoomVsCancellationConverter.class);

	@Override
	public RoomVsCancellationEntity modelToEntity(RoomVsCancellationModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomVsCancellationEntity roomVsCancellationEntity = new RoomVsCancellationEntity();
		roomVsCancellationEntity = (RoomVsCancellationEntity) Util.transform(modelMapper, m, roomVsCancellationEntity);
		roomVsCancellationEntity.setStatus(Status.ACTIVE.ordinal());
		roomVsCancellationEntity.setCreatedDate(Util.getCurrentDateTime());
		roomVsCancellationEntity.setCancellationSlabEntity(cancellationSlabDAO.find(Long.valueOf(m.getCancellationSlabModel().getCancellationSlabId())));

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomVsCancellationEntity;
	}

	@Override
	public RoomVsCancellationModel entityToModel(RoomVsCancellationEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomVsCancellationModel roomVsCancellationModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()){
			roomVsCancellationModel = new RoomVsCancellationModel();
			roomVsCancellationModel = (RoomVsCancellationModel) Util.transform(modelMapper, e, roomVsCancellationModel);
			roomVsCancellationModel.setCancellationSlabModel(cancellationSlabConverter.entityToModel(e.getCancellationSlabEntity()));
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomVsCancellationModel;
	}

	@Override
	public List<RoomVsCancellationModel> entityListToModelList(List<RoomVsCancellationEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomVsCancellationModel> roomVsCancellationModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomVsCancellationModels = new ArrayList<>();
			for(RoomVsCancellationEntity roomVsCancellationEntity:es) {
				roomVsCancellationModels.add(entityToModel(roomVsCancellationEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomVsCancellationModels;
	}

}
