package com.chess;

import java.util.Scanner;

public class chess
{
  private int[][] blocks = new int[64][3];
  private final int totalBlocks = 65;
  private int pos = 0;
  private int reversePos;
  public int move;
  private int reverse;
  private boolean check = false;
  private final int[] pieces = {0, 1, 2, 3, 5, 10, -3, -2, -1};
  private final int[] knightMoves = {17, 15, 10, 6, -17, -15, -10, -6};
  private final int[] bishopMoves = {9, 7, -9, -7};
  private final int[] rookMoves = {1, -1, 8, -8};
  private final int[] queenMoves = {9, 7, -9, -7, 1, -1, 8, -8};
  private final int[] pawnCheckMoves = {7, 8};
  private final int[] pawnMoves = {1, 2};
  private final int fill = 1;
  private final int empty = 0;
    
  public chess()
  {
    boardOne();
    
  }
  private void boardOne()
  {
    int i = 0;
    int n = 1;
    while(i < 16)
    {
      blocks[i][0] = 1;
      blocks[i][1] = 1;
      if(i < 8)
      {
        blocks[i][2] = pieces[n];
        n++;              
      }
      else
      {
        n = 0;
        blocks[i][2] = pieces[n];
      }
      i++;     
    }
    n = 0;
    while(i < 48)
    {
      blocks[i][0] = 0;
      blocks[i][1] = 0;
      blocks[i][2] = pieces[n];            
      i++;
    }
    n = 9;
    while(i < 64)
    {
      blocks[i][0] = 1;
      blocks[i][1] = 2;
      if(i < 56)
      {
        blocks[i][2] = pieces[0];              
      }
      else
      {
        n--;
        blocks[i][2] = pieces[n];        
      }      
      i++;
    }    
  }
  public void playP1(int p1)
  {
    //this.move = move;
    int select = blocks[p1][2];
    for(int piece: pieces)
    {
      if(piece == select)
      {
        if((knightCheck() == false) && (isCheck() == false))
        {
          //fill the new block with piece
          blocks[move][0] = 1;
          blocks[move][1] = 1;
          blocks[move][2] = select;
          //now empty the previous block
          blocks[p1][0] = 0;
          blocks[p1][1] = 0;
          blocks[p1][2] = 0;
        }
      }
    }
  }
  //check path
  // knight CHECK
  public boolean knightCheck(int kingPos, int knightPos)
  {
    kingPos -= 1;
    knightPos -= 1;
    int n = max(kingPos,knightPos) - min(kingPos,knightPos);
    boolean res = false;
    int i = 0;
    
    while(i < knightMoves.length)
    {
      if(n == knightMoves[i])
      {
        res = true;
        break;
      }
      i++;
    }
    return res;
  }
  // Bishop Check Elements
  private boolean upRightCheckBishop(int kingPos, int bishopPos, int target)
  {
    boolean res = false;
    int n = kingPos - bishopPos;
    int point = bishopPos + 9;
    while(point < 64)
    {
      if(blocks[point][0] == fill)
      {
        if(blocks[point][1] == target)
        {
          if(blocks[point][2] == pieces[5])
          {
            res = true;
            break;
          }
        }
        else
        {
          break;
        }
      }
      else
      {
        point += 9;
      }
    }
    return res;
  }
  
  private boolean upLeftCheckBishop(int kingPos, int bishopPos, int target)
  {
    boolean res = false;
    int n = kingPos - bishopPos;
    int point = bishopPos + 7;
    while(point < 64)
    {
      if(blocks[point][0] == fill)
      {
        if(blocks[point][1] == target)
        {
          if(blocks[point][2] == pieces[5])
          {
            res = true;
            break;
          }
        }
        else
        {
          break;
        }
      }
      else
      {
        point += 7;
      }
    }
    return res;
  }
  
  private boolean downLeftCheckBishop(int kingPos, int bishopPos, int target)
  {
    boolean res = false;
    int n = bishopPos - kingPos;
    int point = bishopPos - 9;
    while(point > 0)
    {
      if(blocks[point][0] == fill)
      {
        if(blocks[point][1] == target)
        {
          if(blocks[point][2] == pieces[5])
          {
            res = true;
            break;
          }
        }
        else
        {
          break;
        }
      }
      else
      {
        point -= 9;
      }
    }
    return res;
  }
  
  private boolean downRightCheckBishop(int kingPos, int bishopPos, int target)
  {
    boolean res = false;
    int n = kingPos - bishopPos;
    int point = bishopPos - 7;
    while(point > 0)
    {
      if(blocks[point][0] == fill)
      {
        if(blocks[point][1] == target)
        {
          if(blocks[point][2] == pieces[5])
          {
            res = true;
            break;
          }
        }
        else
        {
          break;
        }
      }
      else
      {
        point -= 7;
      }
    }
    return res;
  }
  
  // Bishop CHECK
  public boolean bishopCheck(int kingPos,int bishopPos, int target)
  {
    kingPos -= 1;
    bishopPos -= 1;
    boolean res = false;
    if(upRightCheckBishop(kingPos,bishopPos,target) == true)
    {
      res = true;
    }
    else if(upLeftCheckBishop(kingPos,bishopPos,target) == true)
    {
      res = true;
    }
    else if(downLeftCheckBishop(kingPos,bishopPos,target) == true)
    {
      res = true;
    }
    else if(downRightCheckBishop(kingPos,bishopPos,target) == true)
    {
      res = true;
    }
    return res;
  }
  
  public boolean rookCheck(int kingPos, int p, int target)
  {
    boolean res = false;
    int i = 0;
      if(downRookCheck(kingPos,p,target) == true)
      {
        res = true;
        break;
      }
      else if(upRookCheck(kingPos,p,target) == true)
      {
        res = true;
        break;
      }
      else if(rightRookCheck(kingPos,p,target) == true)
      {
        res = true;
        break;
      }
      else if(leftRookCheck(kingPos,p,target) == true)
      {
        res = true;
        break;
      }
    return res;
  }
  
  private boolean downRookCheck(int kingPos, int rookPos, int target)
  {
    boolean res = false;
    rookPos -= 1;
    kingPos -= 1;
    int n = rookPos - kingPos;
    int point = rookPos - 8;
    if(n % 8 == 0)
    {
      while(point >= 0)
      {
        if(blocks[point][0] == fill)
        {
          if(blocks[point][1] == target)
          {
            if(blocks[point][2] == pieces[5])
            {
              res = true;
              break;
            }
          }
          else
          {
            break;
          }
        }
        else
        {
          point -= 8;
        }
      }
    }
    return res;
  }
  
  private boolean upRookCheck(int kingPos, int rookPos, int target)
  {
    boolean res = false;
    rookPos -= 1;
    kingPos -= 1;
    int n = kingPos - rookPos;
    int point = kingPos + 8;
    if(n % 8 == 0)
    {
      while(point < 64)
      {
        if(blocks[point][0] == fill)
        {
          if(blocks[point][1] == target)
          {
            if(blocks[point][2] == pieces[5])
            {
              res = true;
              break;
            }
          }
          else
          {
            break;
          }
        }
        else
        {
          point += 8;
        }
      }
    }
    return res;
  }
  
  private boolean rightRookCheck(int kingPos, int rookPos, int target)
  {
    boolean res = false;
    kingPos -= 1;
    rookPos -= 1;
    int n = kingPos - rookPos;
    int point = rookPos + 1;
    if((n <= 7) && (n > 0))
    {
      while((point < kingPos+1)) && (point >= 0))
      {
        if(blocks[point][0] == fill)
        {
          if(blocks[point][1] == target)
          {
            if(blocks[point][2] == pieces[5])
            {
              res = true;
              break;
            }
          }
          else
          {
            break;
          }
        }
        else
        {
          point++;
        }
      }
    }
    return res;
  }
  
  private boolean leftRookCheck(int kingPos, int rookPos, int target)
  {
    boolean res = false;
    kingPos -= 1;
    rookPos -= 1;
    int n = rookPos - kingPos;
    int point = rookPos - 1;
    if((n <= 7) && (n > 0))
    {
      while((point < kingPos+1) && (point >= 0))
      {
        if(blocks[point][0] == fill)
        {
          if(blocks[point][1] == target)
          {
            if(blocks[point][2] == pieces[5])
            {
              res = true;
              break;
            }
          }
          else
          {
            break;
          }
        }
        else
        {
          point--;
        }
      }
    }
    return res;
  }
  
  public boolean pawnCheck(int kingPos, int pawnPos, int target)
  {
    kingPos -= 1;
    pawnPos -= 1;
    int n = kingPos - pawnPos;
    int point1 = pawmPos + 9;
    int point2 = pawnPos + 7;
    boolean res = false;
    if((n == 9) || (n == 7))
    {
      if(point1 == kingPos)
      {
        res = true;
      }
      else if(point2 == kingPos)
      {
        res = true;
      }
    }    
    return res;
  }
  
  public boolean queenCheck(int kingPos,int queenPos, int target)
  {
    kingPos -= 1;
    queenPos -= 1;
    boolean res = false;
    if(rookCheck(kingPos, queenPos, target) == true)
    {
      res = true;
    }
    else if(bishopCheck(kingPos, queenPos, target) == true)
    {
      res = true;
    }
    return res;
  }
  
  public boolean isCheck(int kingPos)
  {
    int min = 0;
    int up = 8;
    int down = -8;
    int right = 1;
    int left = -1;
    int upRight = 9;
    int upLeft = 7;
    int downLeft = -9;
    int downRight = -7;
    kingPos -= 1;
    for(int i = kingPos; i < 64; i++)
    {
      //checking up-direction for rook or queen
      if(blocks[kingPos+up][0] == 1 && kingPos >= 0)
      {
        if(blocks[kingPos+up][1] == 2)
        {
          if(blocks[kingPos+up][2] == pieces[1] || blocks[kingPos+up][2] == pieces[4])
          {
            check = true;
            break;
          }
        }
      }
      else
      {
        up *= 2;
      }
      //checking down-direction for rook or queen
      if(blocks[kingPos+down][0] == 1)
      {
        if(blocks[kingPos+down][1] == 2)
        {
          if(blocks[kingPos+down][2] == pieces[1] || blocks[kingPos][2] == pieces[4])
          {
            check = true;
            break;
          }
        } 
      }
      else
      {
        down *= 2;
      }
      //checking right-side for rook or queen
      if(blocks[kingPos+right][0] == 1)
      {
        if(blocks[kingPos+right][1] == 2)
        {
          if(blocks[kingPos+right][2] == pieces[1] || blocks[kingPos+right][2] == pieces[4])
          {
            check = true;
            break;
          }
        }
      }
      else
      {
        right++;
      }
      //checking left-side for rook or queen
      if(blocks[kingPos+left][0] == 1)
      {
        if(blocks[kingPos+left][1] == 2)
        {
          if(blocks[kingPos+left][2] == pieces[1] || blocks[kingPos+left][2] == pieces[4])
          {
            check = true;
            break;
          }
        }
      }
      else
      {
        left--;
      }       
    } 
    return check;
  }
  
  public void boardTwo(int pos)
  {
    this.pos = pos;
    reversePos = totalBlocks - pos;
  }
  public void play(int p1, int p2)
  {
    Scanner sc = new Scanner(System.in);
    p1 = sc.nextInt(); //select piece
    move = sc.nextInt(); //move to that position
    sc.close();
    //p1 -= 1;
    //move -= 1;
  }
}