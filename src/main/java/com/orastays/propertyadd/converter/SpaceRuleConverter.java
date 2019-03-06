package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.SpaceRuleEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.SpaceRuleModel;

@Component
public class SpaceRuleConverter extends CommonConverter implements BaseConverter<SpaceRuleEntity, SpaceRuleModel> {

	private static final long serialVersionUID = 2903501634398417294L;
	private static final Logger logger = LogManager.getLogger(SpaceRuleConverter.class);

	@Override
	public SpaceRuleEntity modelToEntity(SpaceRuleModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpaceRuleModel entityToModel(SpaceRuleEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		SpaceRuleModel spaceRuleModel = null;
				
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			spaceRuleModel = new SpaceRuleModel();
			spaceRuleModel = (SpaceRuleModel) Util.transform(modelMapper, e, spaceRuleModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return spaceRuleModel;
	}

	@Override
	public List<SpaceRuleModel> entityListToModelList(List<SpaceRuleEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<SpaceRuleModel> spaceRuleModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			spaceRuleModels = new ArrayList<>();
			for(SpaceRuleEntity spaceRuleEntity:es) {
				spaceRuleModels.add(entityToModel(spaceRuleEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return spaceRuleModels;
	}

}
