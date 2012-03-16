/**
 * 
 */
package com.openappengine.service.user;

import com.openappengine.entity.api.ValueEntity;

/**
 * @author hrishikesh.joshi
 * @since  Mar 16, 2012
 *
 */
public class UserService {
	
	private ValueEntity user;
	
	public void registerUser() {
		user.storeValueEntity();
	}

}
