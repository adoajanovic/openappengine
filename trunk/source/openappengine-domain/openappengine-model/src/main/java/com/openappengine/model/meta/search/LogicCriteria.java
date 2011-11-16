/**
 * 
 */
package com.openappengine.model.meta.search;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.truemesh.squiggle.output.Output;

/**
 * @author hrishikesh.joshi
 * 
 */
@Entity
@Table(name = "AD_LOGIC_CRITERIA")
public class LogicCriteria extends Criteria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LC_COLUMN_ID", unique = true, nullable = false)
	private int adLogicCriteriaId;

	@Column(name = "LC_NAME", nullable = false, length = 50)
	private String name;

	@OneToOne
	@Column(name = "LC_OPERATOR", nullable = false, length = 50)	
	private Operator operator;

	@OneToOne
	@Column(name = "LC_LEFT_OPERAND", nullable = false, length = 50)
	private Criteria leftOperand;

	@OneToOne
	@Column(name = "LC_RIGHT_OPERAND", nullable = false, length = 50)
	private Criteria rightOperand;
	
	//TODO
	public void write(Output out) {
        out.print("( ");
        leftOperand.write(out);
        out.print(' ')
           .print(operator)
           .print(' ');
        rightOperand.write(out);
        out.print(" )");
    }

	public int getAdLogicCriteriaId() {
		return adLogicCriteriaId;
	}

	public void setAdLogicCriteriaId(int adLogicCriteriaId) {
		this.adLogicCriteriaId = adLogicCriteriaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Criteria getLeftOperand() {
		return leftOperand;
	}

	public void setLeftOperand(Criteria leftOperand) {
		this.leftOperand = leftOperand;
	}

	public Criteria getRightOperand() {
		return rightOperand;
	}

	public void setRightOperand(Criteria rightOperand) {
		this.rightOperand = rightOperand;
	}
	
}
