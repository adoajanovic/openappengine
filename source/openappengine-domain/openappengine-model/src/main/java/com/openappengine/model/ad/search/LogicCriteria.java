/**
 * 
 */
package com.openappengine.model.ad.search;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.truemesh.squiggle.output.Output;

/**
 * @author hrishikesh.joshi
 * 
 */
@Entity
@Table(name="AD_LOGIC_CRITERIA")
public class LogicCriteria extends Criteria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "LC_NAME", nullable = false, length = 50)
	private String name;

	@OneToOne
	@JoinColumn(name="LC_OPERATOR_ID")
	private Operator operator;

	@OneToOne
	@JoinColumn(name="MC_LEFT_OPERAND_ID")
	private Criteria leftOperand;

	@OneToOne
	@JoinColumn(name="MC_RIGHT_OPERAND_ID")
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
