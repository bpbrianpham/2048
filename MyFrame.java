
import java.awt.AWTEventMulticaster;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.*;  
import java.awt.*; 
import java.lang.Object;
public class MyFrame extends JFrame implements KeyListener // a JFrame main frame
{
    private char c = 'e';
     boolean won;
     Mover m;
     Random r;
     Integer score;
     Integer[][]namee  ;  //4x4 array of model
     Block[][] grid; //grid for the game display
     JPanel point;// score panel
     JLabel scores;// label for score counter
     JPanel game;// game is on this panel
    public MyFrame(Integer[][]name) {//sets up intial game look
       super("2048");// creates a frame
             this.setResizable(true);// resizable
                 this.getContentPane().setBackground(Color.BLACK); // set fram background
                this.setLayout(null);// absolute positioning
                 game = new JPanel();// new panel
                 game.setBackground(Color.BLACK);// set background
                game.setLayout(new GridLayout(4,4,10,10));  // set layout of game panel
       
                score = 0;// score begins at 0
       
                won = false;// not won
        
                m= new Mover();
        
                r= new Random();
        
                namee = name; // given 4x4 array from gamemaster
       
                setSize(510,510);  // size of frame      
       
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close on x
                 
                 
                 
                grid=new Block[4][4]; //array of blocks 
                
              
                for(int y=0; y<4; y++){//assigns blocks created from 4x4 integer array info into the game 4x4 layout panel
                    for(int x=0; x<4; x++){
                        grid[x][y]=new Block(namee[y][x]);
                        game.add(grid[x][y]);  
                    }// end for
                }//end for
                 
                this.add(game);// adds panel to frame
                game.setBounds(0,0,500,500);//sets location of game panel in frame
                
                
                point = new JPanel();// panel for score
                scores = new JLabel("SCORE: " +score.toString(), JLabel.CENTER);// label of current score
                scores.setFont(scores.getFont().deriveFont(70.0f));
                point.add(scores);
                this.add(point);
                point.setBounds(0,700,700,100); // set location of score panel into frame
                 
                this.setVisible(true); //makes frame visible
                this.addKeyListener(this);// allows for keylistener on frame
                JOptionPane.showMessageDialog(this,"This is a 2048 game.\n" +
                                            "Slide the blocks together using the arrow keys to create bigger blocks.\n" +
                                            "The goal is to reach the 2048 block without losing.\n"+
                                            "GOOD LUCK!");
                //message to explain game
    }// end MyFrame()
     

    public void keyPressed(KeyEvent e) {//empty
       
         
       

    }// end keyPressed

    public void keyReleased(KeyEvent e) { //action of game upon execution of arrow key
         int a = 0;
        if (e.getKeyCode()==39)// right movement
       {
           a = 1;
       }// end if

       if (e.getKeyCode()==37)// left movement
       {
               a = 2;
       }  //end if
       if(e.getKeyCode()==38)// up movement
       {
           a = 3;
       }// end if
       if(e.getKeyCode()==40)// south movement
       {
           a= 4;
       }// end if
        
          
         
       
           Integer[][]copy = new Integer[4][4];
           
           for(int row = 0; row < namee.length; row++)// create copy for checking purposes
         {
            for(int col = 0; col < namee[row].length; col++)
            {
                copy[row][col] = namee[row][col];
            }// end for
             
         }// end for
      
           
         
           m.reset();   
            if(a == 1)// move right ececute
            {
                m.moveD(namee);
                m.consolidateD(namee);
                m.moveD(namee);
                }// end if
            if(a == 4)// move down ececute
            {
                m.moveS(namee);
                m.consolidateS(namee);
                m.moveS(namee);
                }// end if
            if(a == 2)// move left ececute
            {
                m.moveA(namee); 
                m.consolidateA(namee);
                m.moveA(namee);
            }// end if
            if(a == 3)// move up ececute
            {
                m.moveW(namee);
                m.consolidateW(namee);
                m.moveW(namee);
            }// end if
                
       score+= m.score(); // update score after moves
       
             Boolean aaa = false; 
             aaa = m.check(namee,copy);// did the move do anything
               if(aaa == true)// if good move add card randomly
               {
                   r.addCard(namee);
                }// end if
            
       redo(); // redoes the frame update
         Boolean lost = m.lost(namee);// check if lost
           if(lost == true)// if you lost show message
           {
               JOptionPane.showMessageDialog(this,"You've lost\nYour score is "+ score);
           }//end if
       for(int r = 0; r < 4; r++)// check for winning block
         {
             for(int c = 0; c <4; c++)
             {
                 if(namee[r][c]==2048 && won == false)// if won 
                 {
                     JOptionPane.showMessageDialog(this,"You've won!");
                     won = true;
                    }// end if
                }// end for
            } //end for
        }// end KeyListener KeyReleased()


    public void keyTyped(KeyEvent e) {// empty
         //nothin needed here 
         //actually i really dont know what this is supposed to do
         
    }//end keytyped()
    
    public void redo()// redoes frame update
    {
          
        for(int y=0; y<4; y++){// redo the panel 4x4 display
            for(int x=0; x<4; x++){
                game.remove(grid[x][y]);
                grid[x][y]=new Block(namee[y][x]);
                game.add(grid[x][y]); //adds button to grid
                        }// end for
                }//e nd for
            
                // redo the score display
             point.remove(scores);
             scores = new JLabel("SCORE: " +score.toString(), JLabel.CENTER);
             scores.setFont(scores.getFont().deriveFont(70.0f));
             point.add(scores);
             this.add(point);   
                
             this.setVisible(true); //makes frame visible of new changes 
            
    } // end redo()
 
}// end MyFrame

