package com.chess;

public class Moves
{
	public void Pawn(int current, String move, int pos)
	{
		if(pos > 1)
		{
			
		}
	}
	
	public int Rook(int current, String move, int pos)
	{
		move = move.toLowerCase();
		int right = current + 1;
		int up = current + 8;
		int left = current - 1;
		int down = current - 8;
		int final_move = 0;
		if(move.equals("right"))
		{
			final_move = right * pos;
		}
		else if(move.equals("up"))
		{
			final_move = up * pos;
		}
		else if(move.equals("left"))
		{
			final_move = left * pos;
		}
		else if(move.equals("down"))
		{
			final_move = down * pos;
		}
		else 
		{
			final_move = 0;
		}
		return final_move;
	}
	
}
