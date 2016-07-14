package com.mangocity.de.mbr.util.mongo;

import java.util.ArrayList;
import java.util.List;

/**
 * mongo操作标准
 * @author longshu.chen
 *
 */
public class Criteria {
	private String collectionName;
	private Operation operation;
	private List<Restrictions> restrictions;
	private List<Order> orders;
	private int max=0;
	private int min=0;
	
	public Criteria(String collectionName,Operation operation){
		this.collectionName=collectionName;
		this.operation=operation;
		restrictions=new ArrayList<Restrictions>();
	}
	
	public void add(Restrictions restriction){
		if(restrictions ==null){
			restrictions=new ArrayList<Restrictions>();
		}
		this.restrictions.add(restriction);
	}
	
	public void addOrder(Order order){
		if(orders ==null){
			orders=new ArrayList<Order>();
		}
		orders.add(order);
	}
	

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public List<Restrictions> getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(List<Restrictions> restrictions) {
		this.restrictions = restrictions;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
}
