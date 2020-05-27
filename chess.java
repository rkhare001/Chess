package com.chess;

import java.util.Random;
import java.util.Scanner;

public class chess
{
    private int white_piece = 16;
    private int black_piece = 16;
    private final int blocks = 64;
    private boolean defeat = false;
    private boolean blackCheck = false;
    private boolean whiteCheck = false;
    private boolean checkMate = false;*/
    private int[][][] square = new int[64][64][64];
    private int[] pie = new int[18];
    pie = {1,2,3,10,11,-3,-2,-1,91,92,93,94,95,96,97,98};
    //1 = Rook
    //2 = Knight
    //3 = Bishop (black)
    //10 = Queen
    //11 = King
    //-3 = Bishop (white)
    //-2 = Knight
    //-1 = Rook
    //91 to 98 = Pawn
    //private int winner;
    
    public void board()
    {     
      int i = 0;      
       //1 for player 1
      //  2 for player 
     //    0 for empty space
      while(i < 16)
      {
        square[i][0] = i+1;        
        square[i][1] = 1;
        square[i][2] = pie[i];
        i++;
      }
      i = 16;
      while(i < 48)
      {
        square[i][0] = i+1;
        square[i][1] = 0;
        i++;
      }
      
      i = 48;
      int z = 15;
      while(i < 64)
      {
        square[i][0] = i+1;
        square[i][1] = 2;
        square[i][2] = pie[z];
        i++;
        z--;
      }
    }
         
    public int totalBlackPiece()
    {
        return black_piece;
    }
    
    public int totalWhitePiece()
    {
        return white_piece;
    }
    
    public void killBlackPiece()
    {
        black_piece -= 1;
    }
    
    public void killWhitePiece()
    {
        white_piece -= 1;
    }
           
    public void path()
    {
        
    }
    
    public void play()
    {        
// Black Player Pieces.
        piece bpKing = piece.KING;
        piece bpQueen = piece.QUEEN;
        
        piece bpBlackBishop = piece.BISHOP;
        piece bpBlackKnight = piece.KNIGHT;
        piece bpBlackRook = piece.ROOK;
        
        piece bpWhiteBishop = piece.BISHOP;
        piece bpWhiteKnight = piece.KNIGHT;
        piece bpWhiteRook = piece.ROOK;
        
        piece bpPawnOne = piece.PAWN;
        piece bpPawnTwo = piece.PAWN;
        piece bpPawnThree = piece.PAWN;
        piece bpPawnFour = piece.PAWN;
        piece bpPawnFive = piece.PAWN;
        piece bpPawnSix = piece.PAWN;
        piece bpPawnSeven = piece.PAWN;
        piece bpPawnEight = piece.PAWN;
//Black Pieces created.

//White Player Pieces.
        piece wpKing = piece.KING;
        piece wpQueen = piece.QUEEN;
        
        piece wpBlackBishop = piece.BISHOP;
        piece wpBlackKnight = piece.KNIGHT;
        piece wpBlackRook = piece.ROOK;
        
        piece wpWhiteBishop = piece.BISHOP;
        piece wpWhiteKnight = piece.KNIGHT;
        piece wpWhiteRook = piece.ROOK;
        
        piece wpPawnOne = piece.PAWN;
        piece wpPawnTwo = piece.PAWN;
        piece wpPawnThree = piece.PAWN;
        piece wpPawnFour = piece.PAWN;
        piece wpPawnFive = piece.PAWN;
        piece wpPawnSix = piece.PAWN;
        piece wpPawnSeven = piece.PAWN;
        piece wpPawnEight = piece.PAWN;        
//White Piece Created.

//Game Started......
//generate first move of any player.
//which will hold white pieces.

		Scanner sc = new Scanner(System.in);
		System.out.println("Player 1 name : ");
		String P1 = sc.nextLine();
		System.out.println("\nPlayer 2 name : ");
		String P2 = sc.nextLine();
		sc.close();
        Random rand = new Random();
        int n = 0;
        while(n == 0 || n == 3)
        {
            n = rand.nextInt(3);            
        }
        if(n == 1)
        {
System.out.println("Player "+n+" : "+P1+" : white pieces");
        }
        else
        {
          System.out.println("Player 2 : "+P2+" : white piece");
        }
//Players and pieces chosen.
		System.out.println("Player "+n+" chance");
        while(!defeat)
        {            
            Scanner move = new Scanner(System.in);
            String go = move.nextLine();            
            move.close();
        }                
        System.out.println(winner+"Wins");
    }
}
