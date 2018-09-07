 
public class GameMaster  
{
      
     private Integer[][] numbers;
     // 4x4 array
     
      
     
     Random r;
       MyFrame f; 
     public GameMaster()// sets up initial 4x4 array of numbers
     {
           
          r = new Random();// randomly places new card in 4x4 array
           
        
          
         numbers = new Integer[4][4];
         for(int r = 0; r < 4; r++)// creates empty 4x4for game
         {
             for(int c = 0; c <4; c++)
             {
                 numbers[r][c] = 0;
                }// end for inner
            }// end for outer
          
          
         r.addCard(numbers);
         r.addCard(numbers);
           // adds two numbers randomly to start with
     }// end Gamemaster
     public void go()// Starts the GUI and game
     {
          f = new MyFrame(numbers);
        }// end go()
     
  
            
     }// end Game Master
     
     

