/**
 * <b>invoke</b> offers a more tightly coupled form of communication, 
 * specifically the ability to trigger a platform-defined service 
 * and pass data to it. 
 */
package com.openappengine.bpm.procmod;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hrishikesh.joshi
 *
 */
//TODO - Implement Action
public class Invoke implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String type;
	
	private String src;
	
	private Set<Param> params = new HashSet<Param>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void addParam(Param param) {
		if(param == null) {
			return;
		}
		
		params.add(param);
	}

	public Set<Param> getParams() {
		return params;
	}

	public void setParams(Set<Param> params) {
		this.params = params;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}
