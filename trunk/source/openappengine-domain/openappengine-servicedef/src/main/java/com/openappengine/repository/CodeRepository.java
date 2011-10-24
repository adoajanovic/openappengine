/**
 * 
 */
package com.openappengine.repository;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.openappengine.model.code.Code;
import com.openappengine.model.code.CodeType;

/**
 * @author hrishi
 *
 */
public class CodeRepository extends GenericRepository<CodeType>{
	
	/**
	 * @return List of All {@link CodeType}.
	 */
	public List<CodeType> getCodeTypes() { 
		List<CodeType> list = hibernateTemplate.loadAll(CodeType.class);
		return list;
	}
	
	/**
	 * @param codeType
	 * @return List of all {@link Code} by Code Type.
	 */
	public List<Code> getCodesByCodeType(String codeType) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CodeType.class)
				.add(Restrictions.eq("codeTypeValue", codeType))
				.setProjection(Projections.property("codes"));
		List list = hibernateTemplate.findByCriteria(criteria);
		return list;
	}

	
	public void addCodeToCodeType(CodeType codeType, Code code) {
		if(codeType == null) {
			return;
		}

		codeType.addCode(code);
		hibernateTemplate.save(codeType);
	}
	
}
