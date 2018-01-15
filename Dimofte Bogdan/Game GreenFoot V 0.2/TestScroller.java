import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestScroller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestScroller extends RealActor
{
    private int  speed = 5;
    
    public void act() 
    {
        
         
       
            if(Greenfoot.isKeyDown("right")){
               
               setLocation(getX() +speed , getY());
            }
            
            if(Greenfoot.isKeyDown("left")){
                  
                  setLocation(getX() -speed , getY());
                }
            
                if(Greenfoot.isKeyDown("up")){
                  
                  setLocation(getX()  , getY()-speed);
                }
                
                 if(Greenfoot.isKeyDown("down")){
                  
                  setLocation(getX()  , getY()+speed);
                }
    }    
}
