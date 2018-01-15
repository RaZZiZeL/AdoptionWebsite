import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Actor mPoint;
    int score = 0;
    public void act() 
    {
     if(checkWin()==1)
     {
            Win win = new Win();
            getWorld().addObject(win,getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
     }
     movePlayer();  
     eat();// Add your action code here.
    }    
    public void eat()
    { 
        mPoint = this.getOneIntersectingObject(Point.class);
        if( mPoint != null)
        {
            this.getWorld().removeObject(mPoint);
            score++;
        }
        
    }
    
    public void movePlayer()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-2);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+2);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-2,getY());
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+2,getY());
        }
        
    }
    public int checkWin()
    {
        if(score==5)
        {return 1;}
        else{return 0;}
     
    }
}
