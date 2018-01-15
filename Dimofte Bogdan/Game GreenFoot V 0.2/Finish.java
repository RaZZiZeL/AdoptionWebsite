import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Finish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Finish extends Actor

{
    /**
     * Act - do whatever the Finish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //GreenfootSound gameOver = new GreenfootSound("gameOver.wav");
    
    Actor a;

    public void act() 
    {
       
         a = this.getOneIntersectingObject(Player.class);
        if( a!=null)
        {   GameOver gameover = new GameOver();
            getWorld().addObject(gameover,getWorld().getWidth()/2,getWorld().getHeight()/2);
           Greenfoot.playSound("gameOver.wav");
            
           Greenfoot.stop();
            // this.getWorld().removeObject(a);
        }
        
        
       
    } 
    
   
    
    
    
    
     
}
