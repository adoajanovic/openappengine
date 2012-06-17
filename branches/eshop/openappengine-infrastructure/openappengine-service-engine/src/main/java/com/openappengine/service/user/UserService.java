/**
 * 
 */
package com.openappengine.service.user;

import com.openappengine.entity.api.ValueEntity;
import com.openappengine.service.AbstractBaseService;

/**
 * @author hrishikesh.joshi
 * @since  Mar 16, 2012
 *
 */
public class UserService extends AbstractBaseService {
	
	private ValueEntity user;
	
	public void registerUser() {
		getUser().storeValueEntity();
	}

	public ValueEntity getUser() {
		return user;
	}

	public void setUser(ValueEntity user) {
		this.user = user;
	}

}
