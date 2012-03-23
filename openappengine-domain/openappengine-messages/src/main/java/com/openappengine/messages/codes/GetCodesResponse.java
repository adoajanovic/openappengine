/**
 * 
 */
package com.openappengine.messages.codes;

import java.io.Serializable;
import java.util.List;

/**
 * @author hrishi
 *
 */
public class GetCodesResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Code> codes;

	public List<Code> getCodes() {
		return codes;
	}

	public void setCodes(List<Code> codes) {
		this.codes = codes;
	}

}
