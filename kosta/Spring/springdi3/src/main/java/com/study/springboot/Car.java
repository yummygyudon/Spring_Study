package com.study.springboot;

public class Car {
	private String model;

	public Car(String model) {
		super();
		this.model = model;
	}

	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}


	@Override
	public String toString() {
		return "Car [model=" + model + "]";
	}
	
	
}
