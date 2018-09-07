 
public class Random
{
   public Random()//empty
   {
       
       
    }// end Random()
    
    public void addCard(Integer[][] name)// adds either a 2 or a 4 at a random space in the 4x4 array that isn't taken up yet
    {
        while(true)// runs until valid space found
        {
            int r = (int)(Math.random()*4);
            int c = (int)(Math.random()*4);
            if(name[r][c] == 0)// valid space found
            {
                int t = (int)(Math.random()*15);// 1:14 ratio of 4s to 2s
                if(t == 0)// 4
                {
                    name[r][c] = 4;
                    break;
                }// end if
                else// 2
                {
                   name[r][c] = 2;
                    break;
               }// end else
            }// end if
        }// end whoile
        
    }// end addCard()
}// end Random
