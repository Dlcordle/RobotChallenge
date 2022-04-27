package com.revature.model;

import java.util.Arrays;
import java.util.LinkedList;
import com.revature.model.Spaces;

public class Board 
{
	private LinkedList<int[]> closedPositions = new LinkedList<int[]>();
	private Spaces [][] boardSpace;
	
	int height, width;
	
	public Board(int height, int width)
	{
		boardSpace = new Spaces[height+1][width+1];
		
		generateBlankBoard(height, width);
	
		boardSpace[0][0] = Spaces.Start;
		boardSpace[height-1][width-1] = Spaces.Goal;
		
		this.height = height;
		this.width = width;
	}
	
	public Board(int height, int width, LinkedList<int[]> closedPositions)
	{
		boardSpace = new Spaces[height+1][width+1];
		
		generateBlankBoard(height, width);
		
		for (int[] c : closedPositions)
		{
			boardSpace[c[0]][c[1]] = Spaces.Closed;
		}
		
		boardSpace[0][0] = Spaces.Start;
		boardSpace[height-1][width-1] = Spaces.Goal;
	}
	
	public Board(int height, int width, int [] startPosition, int [] goalPosition, LinkedList<int[]> closedPositions)
	{
		boardSpace = new Spaces[height+1][width+1];
		
		generateBlankBoard(height, width);
		
		for (int[] c : closedPositions)
		{
			boardSpace[c[0]][c[1]] = Spaces.Closed;
		}
		
		boardSpace[startPosition[0]][startPosition[1]] = Spaces.Start;
		boardSpace[goalPosition[0]][goalPosition[1]] = Spaces.Goal;
	}
	
	public Spaces checkSpace(int x, int y)
	{
		return boardSpace[x][y];
	}
	
	public void setPath(int x, int y)
	{
		boardSpace[x][y] = Spaces.Path;
	}
	
	public void closePath(int x, int y)
	{
		boardSpace[x][y] = Spaces.Closed;
	}
	
	private void generateBlankBoard(int height, int width)
	{
		for(int i = 0; i < height; i++)
		{
			for(int c = 0; c < width; c++)
			{
				boardSpace[i][c] = Spaces.Open;
			}
			
			boardSpace[i][width] = Spaces.Border;
		}
		
		for(int a = 0; a < width + 1; a++)
		{
			boardSpace[height][a] = Spaces.Border;
		}
	}

	@Override
	public String toString() 
	{
		String printedBoard = "";
		
		for(int i = 0; i < boardSpace.length; i++)
		{
			for(int c = 0; c < boardSpace[i].length; c++)
			{
				switch(boardSpace[i][c])
				{
					case Start: printedBoard += "S ";
								break;
					case Open: printedBoard += "_ ";
								break;
					case Closed: printedBoard += "X ";
								break;
					case Goal: printedBoard += "! ";
								break;
					case Path: printedBoard += "* ";
								break;
					case Border: printedBoard += "% ";
								break;
					default: break;
				}
			}
			
			printedBoard += "\n";
		}
			
		return printedBoard;
	}

	public int height() 
	{
		return height;
	}
	
	public int width()
	{
		return width();
	}
	
	
}
