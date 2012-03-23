package com.openappengine.entity.datasource;

import java.io.Serializable;

import com.openappengine.entity.api.ValueEntity;

/**
 * 
 * @author hrishi
 * since Mar 17, 2012
 */
public class GenericEntityHelper implements EntityHelper {
	
	private EntityDao entityDao;

	@Override
	public int create(ValueEntity valueEntity) throws EntityException {
		return entityDao.save(valueEntity);
	}

	@Override
	public ValueEntity findValueEntityByPK(Serializable pk) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEntityDao(EntityDao entityDao) {
		this.entityDao = entityDao;
	}

}
