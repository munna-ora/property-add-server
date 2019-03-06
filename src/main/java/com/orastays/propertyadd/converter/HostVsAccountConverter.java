/**
 * @author Avirup
 */
package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.HostVsAccountEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.HostVsAccountModel;

@Component
public class HostVsAccountConverter extends CommonConverter
		implements BaseConverter<HostVsAccountEntity, HostVsAccountModel> {

	private static final long serialVersionUID = 9085582036182090828L;
	private static final Logger logger = LogManager.getLogger(HostVsAccountConverter.class);

	@Override
	public HostVsAccountEntity modelToEntity(HostVsAccountModel m) {

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		HostVsAccountEntity userVsAccountEntity = new HostVsAccountEntity();
		userVsAccountEntity = (HostVsAccountEntity) Util.transform(modelMapper, m, userVsAccountEntity);
		userVsAccountEntity.setStatus(Status.ACTIVE.ordinal());
		userVsAccountEntity.setCreatedDate(Util.getCurrentDateTime());

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return userVsAccountEntity;
	}

	@Override
	public HostVsAccountModel entityToModel(HostVsAccountEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		HostVsAccountModel userVsAccountModel = null;
		if (Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			userVsAccountModel = new HostVsAccountModel();
			userVsAccountModel = (HostVsAccountModel) Util.transform(modelMapper, e, userVsAccountModel);
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return userVsAccountModel;
	}

	@Override
	public List<HostVsAccountModel> entityListToModelList(List<HostVsAccountEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<HostVsAccountModel> userVsAccountModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			userVsAccountModels = new ArrayList<>();
			for (HostVsAccountEntity userVsAccountEntity : es) {
				userVsAccountModels.add(entityToModel(userVsAccountEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return userVsAccountModels;
	}
}