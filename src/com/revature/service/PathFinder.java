package com.revature.service;

import java.util.Stack;

import com.revature.model.Board;
import com.revature.model.Spaces;

public class PathFinder 
{
	private static Board mainBoard;
	private static Stack<int[]> pathway;
	
	public static void init(Board newBoard, Stack<int[]> paths)
	{
		mainBoard = newBoard;
		pathway = paths;
	}
	
	public static int recursiveSearch(int x, int y)
	{
		if(mainBoard.checkSpace(x, y) == Spaces.Goal)
		{
			pathway.add(new int[]{x,y});
			return 0;
		}
		else if(mainBoard.checkSpace(x, y) == Spaces.Open || mainBoard.checkSpace(x, y) == Spaces.Start)
		{
			pathway.add(new int[] {x, y});
			
			if (recursiveSearch(x+1, y) == 0)
			{
				mainBoard.setPath(x, y);
				pathway.push(new int[] {x,y});
				return 0;
			}
			else if (recursiveSearch(x, y+1) == 0)
			{
				mainBoard.setPath(x, y);
				pathway.push(new int[] {x,y});
				return 0;
			}
		}
		else if(mainBoard.checkSpace(x, y) == Spaces.Border)
		{
			//System.out.println("Border X:"+ x + " Y: " + y);
			if (pathway.empty())
			{
				return -2;
			}
			else
			{
				pathway.pop();
				return -1;
			}
		}
		else if(mainBoard.checkSpace(x, y) == Spaces.Closed)
		{
			//System.out.println("Closed X:"+ x + " Y: " + y);
			if (pathway.empty())
			{
				return -2;
			}
			else
			{
				pathway.pop();
				return -1;
			}
		}
		return -1;
	}
}
