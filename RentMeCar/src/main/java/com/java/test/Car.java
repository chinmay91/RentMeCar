package com.java.test;

public class Car extends Vehicle {

	@Override
	public void drive(){
		System.out.println("Car drive");
	}
	
	public static void accelerate(){
		System.out.println("Car is sppeding up");
	}
}