package com.openappengine.entity.delegator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.entity.api.ValueEntity;
import com.openappengine.entity.model.ModelEntity;
import com.openappengine.entity.model.ModelEntityFactory;
import com.openappengine.entity.model.ModelRelationship;
import com.openappengine.utility.UtilXml;

public class EntityDelegator implements Delegator {
	
	private ModelEntityFactory modelEntityFactory;
	
	public EntityDelegator() {
	}

	@Override
	public ValueEntity makeValueEntity(String entityName) {
		ModelEntity modelEntity = getModelEntity(entityName);
		if(modelEntity == null) {
			return null;
		}
		
		ValueEntity valueEntity = ValueEntity.createValueEntity(modelEntity);
		valueEntity.init(modelEntity, this);
		
		return valueEntity;
	}
	
	public ValueEntity makeRelatedValueEntity(ValueEntity valueEntity, String relationshipName) {
		if(valueEntity == null) {
			throw new IllegalArgumentException("ValueEntity cannot be null.");
		}
		
		ModelRelationship modelRelationship = valueEntity.getModelRelationship(relationshipName);
		if(modelRelationship == null) {
			throw new IllegalArgumentException(
					"No ModelRelationship exists for ValueEntity : "
							+ valueEntity.getEntityName()
							+ " with relationship title " + relationshipName
							+ ".");
		}
		
		String relatedEntityName = modelRelationship.getRelatedEntityName();
		ValueEntity relatedValueEntity = makeValueEntity(relatedEntityName);
		
		if(StringUtils.equals("one", modelRelationship.getType())) {
			valueEntity.getOneMappedRelatedValueEntityMap().put(relationshipName, relatedValueEntity);
		} else if(StringUtils.equals("many", modelRelationship.getType())) {
			if(!valueEntity.getManyMappedRelatedValueEntityMap().containsKey(relationshipName)) {
				Set<ValueEntity> valueEntities = new HashSet<ValueEntity>();
				valueEntities.add(relatedValueEntity);
				valueEntity.getManyMappedRelatedValueEntityMap().put(relationshipName, valueEntities);
			} else {
				Set<ValueEntity> valueEntities = valueEntity.getManyMappedRelatedValueEntityMap().get(relationshipName);
				valueEntities.add(relatedValueEntity);
				valueEntity.getManyMappedRelatedValueEntityMap().put(relationshipName, valueEntities);
			}
		}
		
		return valueEntity;
	}
	
	@Override
	public ValueEntity fromXml(Document document) {
		if(document == null) {
			return null;
		}
		
		Element documentElement = document.getDocumentElement();
		String entityName = UtilXml.readElementAttribute(documentElement, "entityName");
		
		List<? extends Element> childElementList = UtilXml.childElementList(documentElement);
		Map<String,Object> values = new HashMap<String, Object>();
		if(childElementList != null) {
			for (Element element : childElementList) {
				String field = element.getNodeName();
				String value = element.getNodeValue();
				
				values.put(field, value);
			}
		}
		
		ValueEntity valueEntity = makeValueEntity(entityName, values);
		return valueEntity;
	}
	
	@Override
	public Document makeValueEntityAsXml(String entityName) {
		ValueEntity valueEntity = makeValueEntity(entityName);
		if(valueEntity != null) {
			return valueEntity.toXml();
		}
		return null;
	}

	@Override
	public Document makeValueEntityAsXml(String entityName,Map<String, Object> values) {
		ValueEntity valueEntity = makeValueEntity(entityName, values);
		if(valueEntity != null) {
			return valueEntity.toXml();
		}
		return null;
	}
	
	@Override
	public ValueEntity makeValueEntity(String entityName,Map<String, Object> values) {
		ModelEntity modelEntity = getModelEntity(entityName);
		if(modelEntity == null) {
			return null;
		}
		
		ValueEntity valueEntity = ValueEntity.createValueEntity(modelEntity);
		valueEntity.init(modelEntity, this,values);
		return valueEntity;
	}

	@Override
	public ValueEntity createEntity(String entityName,Map<String, Object> values) {
		ValueEntity valueEntity = makeValueEntity(entityName, values);
		//Store to the persistence layer
		return valueEntity;
	}

	@Override
	public ValueEntity storeEntity(String entityName, Map<String, Object> values) {
		ValueEntity valueEntity = makeValueEntity(entityName, values);
		//Store to the persistence layer
		return valueEntity;
	}

	@Override
	public ValueEntity findByPrimaryKey(String entityName,Map<String, Object> values) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ModelEntity getModelEntity(String entityName) {
		if(StringUtils.isEmpty(entityName)) {
			throw new IllegalArgumentException("EntityName required to find a ModelEntity.");
		}
		return getModelEntityFactory().getModelEntity(entityName);
	}

	protected ModelEntityFactory getModelEntityFactory() {
		return modelEntityFactory;
	}

	public void setModelEntityFactory(ModelEntityFactory modelEntityFactory) {
		this.modelEntityFactory = modelEntityFactory;
	}

}
