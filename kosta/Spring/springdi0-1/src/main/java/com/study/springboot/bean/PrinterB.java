package com.study.springboot.bean;

public class PrinterB implements Printer{

	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		System.out.println("Printer B : "+message) ;
	}

}
