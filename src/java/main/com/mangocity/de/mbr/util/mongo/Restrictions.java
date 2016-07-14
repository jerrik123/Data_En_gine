package com.mangocity.de.mbr.util.mongo;

import java.util.List;

/**
 * mongo条件约束
 * @author longshu.chen
 *
 */
public class Restrictions {
	private Operation operation;
	private String name;
	private Object value;
	private List<Object> valueList;
	
	private Restrictions(Operation operation,String name,Object value){
		this.operation=operation;
		this.name=name;
		this.value=value;
	}
	private Restrictions(Operation operation,String name,List<Object> valueList){
		this.operation=operation;
		this.name=name;
		this.valueList=valueList;
	}
	
	public static Restrictions eq(String name,Object value){
		return new Restrictions(Operation.eq,name,value);
	}
	public static Restrictions gt(String name,Object value){
		return new Restrictions(Operation.gt,name,value);
	}
	public static Restrictions lt(String name,Object value){
		return new Restrictions(Operation.lt,name,value);
	}
	public static Restrictions or(String name,Object value){
		return new Restrictions(Operation.or,name,value);
	}
	public static Restrictions and(String name,Object value){
		return new Restrictions(Operation.and,name,value);
	}
	public static Restrictions like(String name,Object value){
		return new Restrictions(Operation.like,name,value);
	}
	public static Restrictions in(String name,List<Object> valueList){
		return new Restrictions(Operation.in,name,valueList);
	}
	public static Restrictions order(String name,Object value){
		return new Restrictions(Operation.order,name,value);
	}
	
	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	public List<Object> getValueList() {
		return valueList;
	}
	public void setValueList(List<Object> valueList) {
		this.valueList = valueList;
	}
}
