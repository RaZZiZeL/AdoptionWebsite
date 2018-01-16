import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shuriken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuriken extends Actor
{
  /**
     * Act - do whatever the Cookie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { 
        World w = getWorld();
         if(Greenfoot.getRandomNumber(65)==1){
             int x = Greenfoot.getRandomNumber(w.getWidth());
                if(w.numberOfObjects()<5)
                 w.addObject(new Shuriken(), x, 0);
             
         }
 
        this.setLocation(getX(), getY()+2);
      
        if(this.isAtEdge()){
            w.removeObject(this);
        }
     
    
    }
}
