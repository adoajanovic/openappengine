/**
 * 
 */
package com.openappengine.crud.list;

import com.openappengine.web.apps.login.LoginFormBean;

/**
 * @author hrishi
 *
 */
public class TestDataListAdapter extends DataListAdapter<LoginFormBean> {

    public TestDataListAdapter() {
	LoginFormBean t = new LoginFormBean();
	t.setUsername("user1");
	t.setPassword("pass1");
	this.addData(t);
	
	t = new LoginFormBean();
	t.setUsername("user2");
	t.setPassword("pass2");
	this.addData(t);
    }

}

