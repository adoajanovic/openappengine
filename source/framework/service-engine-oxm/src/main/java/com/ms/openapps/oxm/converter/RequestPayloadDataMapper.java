package com.ms.openapps.oxm.converter;

import com.thoughtworks.xstream.mapper.DefaultMapper;

/**
 * @author hrishikesh
 *
 */
public class RequestPayloadDataMapper extends DefaultMapper {

	private final String packageName = "com.ms.openapps.oxm.beans";

	public RequestPayloadDataMapper(ClassLoader classLoader) {
		super(classLoader);
	}
	
	@Override
	public Class realClass(String className) {
		if(className == null) {
			return null;
		}
		String fullyQualifiedClassName = this.packageName + "." + className;
		return super.realClass(fullyQualifiedClassName);
	}


	@Override
	public String realMember(Class type, String serialized) {
		return serialized;//super.realMember(type, serialized);
	}

	@Override
	public String serializedClass(Class type) {
		if(type == null) {
			return "";
		}
		
		String className = type.getName();
		int idx = className.lastIndexOf(".");
		if(idx != -1) {
			return className.substring(idx+1);
		}
		
		return className;
	}

	@Override
	public String serializedMember(Class type, String memberName) {
		return memberName;
	}
}