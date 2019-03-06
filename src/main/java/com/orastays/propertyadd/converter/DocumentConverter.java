package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.DocumentEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.DocumentModel;

@Component
public class DocumentConverter extends CommonConverter implements
		BaseConverter<DocumentEntity, DocumentModel> {

	private static final long serialVersionUID = 9153911938075936205L;
	private static final Logger logger = LogManager.getLogger(DocumentConverter.class);

	@Override
	public DocumentEntity modelToEntity(DocumentModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		DocumentEntity documentEntity = new DocumentEntity();
		documentEntity = (DocumentEntity) Util.transform(modelMapper, m, documentEntity);
		documentEntity.setStatus(Status.ACTIVE.ordinal());
		documentEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		documentEntity.setCreatedDate(Util.getCurrentDateTime());
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return documentEntity;
	}

	@Override
	public DocumentModel entityToModel(DocumentEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		DocumentModel documentModel = null;
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			documentModel = new DocumentModel();
			documentModel = (DocumentModel) Util.transform(modelMapper, e, documentModel);
		}
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return documentModel;
	}

	@Override
	public List<DocumentModel> entityListToModelList(List<DocumentEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<DocumentModel> documentModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			documentModels = new ArrayList<>();
			for(DocumentEntity documentEntity:es) {
				documentModels.add(entityToModel(documentEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return documentModels;
	}

}
