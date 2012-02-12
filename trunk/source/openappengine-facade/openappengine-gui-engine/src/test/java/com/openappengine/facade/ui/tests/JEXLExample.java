package com.openappengine.facade.ui.tests;
import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionFactory;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlHelper;

public class JEXLExample {

	public static void main(String[] args) {
		MyObject myObject = new MyObject();

		String expr;
		expr = "(myObject.number1 + myObject.number2) / myObject.number3";
		processExpression(myObject, expr);
		expr = "(N1 + N2) / N3";
		processExpression(myObject, expr);
		expr = "myObject.itsTrue";
		processExpression(myObject, expr);
		expr = "myObject.itsFalse";
		processExpression(myObject, expr);

		expr = "myObject.getThePresident().equals('Barack Obama')";
		processExpression(myObject, expr);
		expr = "myObject.thePresident.equals(\"George Bush\")";
		processExpression(myObject, expr);

	}

	/**
	 * @param containerObject
	 * @param expression
	 */
	private static void processExpression(MyObject containerObject, String expression) {
		try {
			Expression e = ExpressionFactory.createExpression(expression);
			JexlContext jc = JexlHelper.createContext();
			//"myObject" is the alias to be used for expression evaluation
			jc.getVars().put("myObject", containerObject);
			jc.getVars().put("N1", containerObject.getNumber1());
			jc.getVars().put("N2", containerObject.getNumber2());
			jc.getVars().put("N3", containerObject.getNumber3());
			System.out.println("Evaluating: " + expression );
			System.out.println("  \\--------> " + e.evaluate(jc) );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
