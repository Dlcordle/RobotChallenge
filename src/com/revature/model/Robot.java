package com.revature.model;

import java.util.LinkedList;

public class Robot 
{
	private int [] previousPosition;
	private int [] currentPosition;
	
	private LinkedList <int []> pathway = new LinkedList <int []>();
	
	public Robot()
	{
		previousPosition[0] = 0;
		previousPosition[1] = 0;
		
		currentPosition[0] = 0;
		currentPosition[0] = 0;
	}
	
	public Robot(int[] startPosition)
	{
		currentPosition = startPosition;
	}

	public int[] getPreviousPosition() {
		return previousPosition;
	}

	public void setPreviousPosition(int[] previousPosition) {
		this.previousPosition = previousPosition;
	}

	public int[] getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int[] currentPosition) {
		this.currentPosition = currentPosition;
	}
}
