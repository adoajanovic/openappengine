/**
 * 
 */
package com.openappengine.bpm.state;

import java.util.Date;

/**
 * @author hrishikesh.joshi
 *
 */
public class RunningStateInfo {
	
	/* In This State From Date*/
	private Date started;
	
	/* End Date */
	private Date end;
	
	/* State */
	private State state;

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	} 

}
