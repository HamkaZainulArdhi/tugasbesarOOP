/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import static tetris2.Board.BLOCK_SIZE;
import static tetris2.Board.BOARD_HEIGHT;

/**
 *
 * @author Pongo
 */
public class Shape {
   private int x = 4, y = 0;
    private int normal = 600;
    private int fast = 50;
    private int delayTimeForMovement = normal;
    private long beginTime;
    
    private int deltax = 0;
    private boolean collision = false;
    
    private int [][] coords;
    private Board board;
    private Color color;
    
    public Shape (int[][] coords,Board board, Color color){
        this.coords = coords;
        this.board = board;
        this.color = color;
    } 
    
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    
    public void reset(){
        this.x = 4;
        this.y = 0;
        collision = false;
    }
    
    
    public void update(){
         if(collision){
             // fill the color for board
             for(int row =  0; row < coords.length; row++){
                 for(int col = 0; col < coords[0].length; col++){
                     if(coords[row][col] != 0){
                        board.getBoard()[y + row][x + col] = color;
                     }
                 }
             }
             checkLine();
             // set current shape
             board.setCurrentShape();
             
                    return;
                }
                
                //check move horizontal
                boolean moveX = true;
                if(!(x + deltax + coords[0].length > 10)&& !(x+deltax < 0)){
                for(int row = 0; row < coords.length; row++){
                  for(int col = 0; col < coords.length; col++){
                      if(coords[row][col] !=0){
                      if(board.getBoard()[y + row][x+deltax + col]!= null){
                       moveX = false;    
                      }
                         
                      }
                  }   
                }
                if(moveX) {
                x+=deltax;
                }
                }
                deltax = 0;
                if(System.currentTimeMillis() - beginTime > delayTimeForMovement){
                 // vertical movement   
                if (!(y + 1 + coords.length > BOARD_HEIGHT)){
                    for(int row = 0; row < coords.length; row++){
                        for(int col = 0; col < coords[row].length; col++){
                          if(coords[row][col] != 0){
                           if(board.getBoard() [y + 1 + row] [x +  + deltax + col] !=null){
                               collision = true;
                           }  
                          }  
                        }
                    }
                    if(!collision){
                     y++;
                    }
                }else {
                  collision = true;  
                }
                
                 beginTime = System.currentTimeMillis();
                }
      
    }
    
    private void checkLine(){
      int bottomLine = board.getBoard().length -1;
      for(int topLine = board.getBoard().length -1; topLine > 0; topLine--){
         int count = 0;
         for(int col = 0; col<board.getBoard()[0].length; col++){
          if(board.getBoard()[topLine][col]!= null) {
              count++;
          } 
          board.getBoard()[bottomLine][col] = board.getBoard()[topLine][col];
         }
         if(count< board.getBoard()[0].length){
             bottomLine--;
         }
      }
      
    }
    
    public void render(Graphics g) {
        //draw the shape
        for(int row = 0; row < coords.length; row ++){
            for(int col = 0; col < coords[0].length; col ++){
                if(coords[row][col] != 0){
                    g.setColor(color);
                    g.fillRect(col * BLOCK_SIZE + x * BLOCK_SIZE,row * BLOCK_SIZE + y * BLOCK_SIZE,BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
    }
    
    public void speedUp (){ 
      delayTimeForMovement = fast;
      
   }
    public void speedDown (){
        delayTimeForMovement = normal;
    }
    public void moveRight (){
          deltax = 1; 
    }
    public void moveLeft (){
          deltax = -1; 
    }
}
