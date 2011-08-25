package com.ms.openapps.appflow.params;


public class InParam {
	
	private String name;
	
	private Class<?> clazz;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the clazz
	 */
	public Class<?> getClazz() {
		return clazz;
	}

	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	/**
	 * @param name
	 * @param clazz
	 */
	public InParam(String name, Class<?> clazz) {
		super();
		this.name = name;
		this.clazz = clazz;
	}
	
}
