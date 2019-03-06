package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.ContactPurposeEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.ContactPurposeModel;

@Component
public class ContactPurposeConverter extends CommonConverter
		implements BaseConverter<ContactPurposeEntity, ContactPurposeModel> {

	private static final long serialVersionUID = -9031725856569716104L;
	private static final Logger logger = LogManager.getLogger(ContactPurposeConverter.class);

	@Override
	public ContactPurposeEntity modelToEntity(ContactPurposeModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactPurposeModel entityToModel(ContactPurposeEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		ContactPurposeModel contactPurposeModel = null;

		if (Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			contactPurposeModel = new ContactPurposeModel();
			contactPurposeModel = (ContactPurposeModel) Util.transform(modelMapper, e, contactPurposeModel);
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return contactPurposeModel;
	}

	@Override
	public List<ContactPurposeModel> entityListToModelList(List<ContactPurposeEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<ContactPurposeModel> contactPurposeModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			contactPurposeModels = new ArrayList<>();
			for (ContactPurposeEntity contactPurposeEntity : es) {
				contactPurposeModels.add(entityToModel(contactPurposeEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return contactPurposeModels;
	}

}
