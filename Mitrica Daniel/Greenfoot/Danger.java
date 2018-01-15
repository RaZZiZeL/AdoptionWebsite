import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Danger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Danger extends Actor
{
    /**
     * Act - do whatever the Danger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Actor mPlayer;
    public void act() 
    {
        // Add your action code here.
        moveAround();
        die();
    }    
     public void die()
    { 
        mPlayer = this.getOneIntersectingObject(Player.class);
        if( mPlayer != null)
        {
            GameOver gameover = new GameOver();
            getWorld().addObject(gameover,getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
           // this.getWorld().removeObject(mPlayer);
        }
        
    }
    
    public void moveAround()
    {
        move(2);
        if(Greenfoot.getRandomNumber(100)<10)
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
        if(getX()<=5||getX()>= getWorld().getWidth()-5)
        {
            turn(180);
        }
        if(getY()<=5||getY()>= getWorld().getWidth()-5)
        {
            turn(180);
        }
    }
}
