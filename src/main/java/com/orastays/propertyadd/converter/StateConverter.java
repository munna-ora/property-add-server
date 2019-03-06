package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.StateEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.StateModel;

@Component
public class StateConverter extends CommonConverter implements
		BaseConverter<StateEntity, StateModel> {

	private static final long serialVersionUID = 7484543161542099221L;
	private static final Logger logger = LogManager.getLogger(StateConverter.class);

	@Override
	public StateEntity modelToEntity(StateModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateModel entityToModel(StateEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		StateModel stateModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()){
			stateModel = new StateModel();
			stateModel = (StateModel) Util.transform(modelMapper, e, stateModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return stateModel;
	}

	@Override
	public List<StateModel> entityListToModelList(List<StateEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<StateModel> stateModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			stateModels = new ArrayList<>();
			for(StateEntity stateEntity:es) {
				stateModels.add(entityToModel(stateEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return stateModels;
	}

}
