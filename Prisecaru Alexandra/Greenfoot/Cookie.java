import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cookie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cookie extends Actor
{
   /**
     * Act - do whatever the Cookie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { 
        World w = getWorld();
        this.setLocation(getX(), getY()+1);
      
        if(this.isAtEdge()){
            w.removeObject(this);
        }
     
    
    }
}
