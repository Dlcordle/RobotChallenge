package com.revature.main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.revature.model.Board;
import com.revature.service.PathFinder;

public class Driver 
{

	public static void main(String[] args) 
	{
		LinkedList<int[]> closedPositions = new LinkedList<int[]>();
		
		int[] start = {0, 0};
		int[] goal = {4, 4};
		
		int[] one = {1, 0};
		int[] two = {1, 1};
		int[] three = {1, 2};
		int[] four = {1, 3};
//		int[] five = {1, 4};
		
		closedPositions.add(one);
		closedPositions.add(two);
		closedPositions.add(three);
		closedPositions.add(four);
//		closedPositions.add(five);
		
		Board mainBoard = new Board(10, 10, start, goal, closedPositions);
		
		Stack <int[]> pathways = new Stack<int[]>();
		
		PathFinder.init(mainBoard, pathways);
		
		if(PathFinder.recursiveSearch(0, 0) == -2)
		{
			System.out.println("No Path Exists!");
		}
		
		System.out.println(mainBoard);
		
	}

}
