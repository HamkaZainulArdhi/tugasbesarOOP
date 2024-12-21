/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris2;

import javax.swing.JFrame;

/**
 *
 * @author Pongo
 */
public class WindowsGame {
   public static final int  WIDTH = 445, HEIGHT =629;
    
    
    private Board board;
    private JFrame windows;
    
    
    public WindowsGame(){
        windows = new JFrame("Tetris");
        windows.setSize(WIDTH, HEIGHT);
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setResizable(false);
        windows.setLocationRelativeTo(null);
        
        
        board = new Board();
        windows.add(board);
        windows.addKeyListener(board);
        windows.setVisible(true);
        
    }
    
    public static void main (String[] args){
    new WindowsGame();
    }
}
