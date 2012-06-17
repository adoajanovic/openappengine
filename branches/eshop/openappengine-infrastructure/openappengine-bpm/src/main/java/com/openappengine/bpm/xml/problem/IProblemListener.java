package com.openappengine.bpm.xml.problem;

import com.openappengine.bpm.xml.Problem;

public interface IProblemListener {
	
	/**
	 * Add a Problem.
	 * @param problem
	 */
	public void addProblem(Problem problem);

}
