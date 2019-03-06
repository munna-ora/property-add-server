package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.DocumentEntity;

@Repository
public class DocumentDAO extends GenericDAO<DocumentEntity, Long>{
	
	private static final long serialVersionUID = 2934314275641836859L;

	public DocumentDAO() {
		super(DocumentEntity.class);
	}

}
