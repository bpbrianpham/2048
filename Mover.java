 
public class Mover
{
    int score;
    public Mover()// intitalize score
    {
         score = 0;
    }// end Mover()
    public void moveS(Integer[][] name)// moves all bocks down
    {
        Boolean b = false;
        for(int col = 0; col < name[0].length; col++)// traverse
        {
            for(int row = 3; row > 0; row--)
            {
                if(name[row][col] == 0)// if blank sure all blocks move as far as needed
                {
                    for(int r = row; r > 0; r--)
                    {
                        if(name[r-1][col] != 0)
                        {
                            b = true;
                        }//end if
                        name[r][col] = name[r-1][col];
                        name[r-1][col] = 0;
                    }//end for
                     if(b == true)
                    {
                         row++;
                         b = false;
                    }// end if
                }// end if
            }// end for
        }// end for
    }// end moveS()
    public void moveD(Integer[][] name)// moves all blocks to the right
    {
        Boolean b = false;
        for(int row = 0; row < name.length; row++)// traverse
        {
            for(int col = 3; col > 0; col--)
            {
                if(name[row][col] == 0)// if blank sure all blocks move as far as needed
                {
                    for(int c = col; c > 0; c--)
                    {
                        if(name[row][c-1] != 0)
                        {
                            b = true;
                        }// end if
                        name[row][c] = name[row][c-1];
                        name[row][c-1] = 0;
                    }// end for
                    if(b == true)
                    {
                         col++;
                         b = false;
                    }// end if
                   
                }// end if
            }// end for
        }// end for
    }// end moveD()
    public void moveA(Integer[][] name)// moves all blocks to the left
    { 
        Boolean b = false;
        for(int row = 0; row < name.length; row++)// traverse
        {
            for(int col = 0; col < 3; col++)
            {
                if(name[row][col] == 0)// if blank sure all blocks move as far as needed
                {
                    for(int c = col; c < 3; c++)
                    {
                        if(name[row][c+1] != 0)
                        {
                            b = true;
                        }// end if
                        name[row][c] = name[row][c+1];
                        name[row][c+1] = 0;
                    }// end for
                    if(b == true)
                    {
                         col--;
                         b = false;
                    }// end if
                     
                }//end if
            }//end for
        }// end for
    }// end moveA()
    public void moveW(Integer[][] name)// moves all blocks upward
    {
        Boolean b = false;
        for(int col = 0; col < name[0].length; col++)// traverse
        {
            for(int row = 0; row < 3; row++)
            {
                if(name[row][col] == 0)// if blank sure all blocks move as far as needed
                {
                    for(int r = row; r < 3; r++)
                    {
                         if(name[r+1][col] != 0)
                        {
                            b = true;
                        }// end if
                        name[r][col] = name[r+1][col];
                        name[r+1][col] = 0;
                    }//end for
                     if(b == true)
                    {
                         row--;
                         b = false;
                    }// end if
                }// end if
            }// end for
        }//end for
    }// end moveW()
    public void consolidateD(Integer[][] name)//combines blocks in esterly direction
    {
         
        for(int row = 0; row < name.length; row++)// traverse
        {
            for(int col = 3; col > 0; col--)
            {
                if(name[row][col] != 0 && name[row][col].equals(name[row][col-1]))// if alike block then combine
                {
                  name[row][col] += name[row][col-1];
                  score+= name[row][col];// score update
                  name[row][col - 1] = 0;
                }// end if
            }// end for
        } // end for
    }// end conoslidateD()
    public void consolidateS(Integer[][] name)// combines blocks in a southerly direction
    {
         for(int col = 0; col < name[0].length; col++)// traverse
        {
            for(int row = 3; row > 0; row--)
            {
               if(name[row][col] != 0 && name[row][col].equals(name[row-1][col])   )// if alike block then combine
                {
                  name[row][col] += name[row-1][col];
                  score+= name[row][col];// score update
                  name[row-1][col] = 0;
                }  //end if
            }// end for
        }// end for
    }// end conoslidateS()
    public void consolidateA(Integer[][] name)// combines blocks in a westerly direction
    {
        for(int row = 0; row < name.length; row++)// traverse
        {
            for(int col = 0; col < 3; col++)
            {
                if( name[row][col] != 0 && name[row][col].equals(name[row][col+1])  )// if alike block then combine
                {
                  name[row][col] += name[row][col+1];
                  score+= name[row][col];// score update
                  name[row][col + 1] = 0;
                }// end if
            }// end for
        } // end for
     }// end conoslidateA()
    public void consolidateW(Integer[][] name)// combines blocks in a northerly direction
    {
         for(int col = 0; col < name[0].length; col++)// traverse
        {
            for(int row = 0; row < 3; row++)
            {
               if(name[row][col] != 0 && name[row][col].equals(name[row+1][col])  )// if alike block then combine
                {
                  name[row][col] += name[row+1][col];
                  score+= name[row][col];// score update
                  name[row+1][col] = 0;
                }  // end if
            }// end for
        }// end for
    }// end conoslidateW()
    public  boolean check(Integer[][] name, Integer[][] copy)// checks if two arrays the same
    {
        for(int r = 0; r < 4; r++)//checks all locations
        {
            for(int c = 0; c < 4; c++)
            {
                long a = name[r][c];
                long b = copy[r][c];
                if(a != b)// if not same at certain location
                {
                    return true;
                }// end if
            }// end for
        }// end for
        return false;
    }// end check
    public boolean lost(Integer[][]name)// checks for if lost by checking if all move options do not hchange the 4x4 array
    {
        Integer [][] copy = new Integer[4][4];
        for(int r = 0; r < 4; r++)// creates copy of the 4x4 array
        {
            for(int c = 0; c < 4; c++)
            {
                copy[r][c] = name[r][c];
            }// end for
        }// end for
        moveA(copy);
        consolidateA(copy);
        moveA(copy);
        if(check(copy,name) == true)
        {
            return false;
        }// end if
        moveS(copy);
        consolidateS(copy);
        moveS(copy);
        if(check(copy,name) == true)
        {
            return false;
        }// end if
        moveW(copy);
        consolidateW(copy);
        moveW(copy);
        if(check(copy,name) == true)
        {
            return false;
        }// end if
        moveD(copy);
        consolidateD(copy);
        moveD(copy);
        if(check(copy,name) == true)
        {
            return false;
        }// end if
        return true;
        
    }// end lost()
    public int score()// returns local score
    {
        return score;
    }// end score()
    public void reset()// resets loca score after every call
    {
        score= 0;
    }// end reset()
}//end Mover
