import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kitty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kitty extends Actor
{
   /**
     * Act - do whatever the Kitty wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        
        World world = getWorld();
        if(isTouching(Cookie.class))
        {
            removeTouching(Cookie.class);
            int x = Greenfoot.getRandomNumber(world.getWidth());
            world.addObject(new Cookie(), x, 0);
        }
        
        if(isTouching(Shuriken.class)){
     
            while(!this.isAtEdge()){
               this.setLocation(getX(), getY()+1);
               Greenfoot.delay(1);
            }
            world.removeObject(this);
            world.removeObjects(world.getObjects(null));
            Greenfoot.stop();
            
        }
    }

    public void move(){
        if(Greenfoot.isKeyDown("Up")){
            setLocation(getX(), getY()-10);
        }
        if(Greenfoot.isKeyDown("Down")){
            setLocation(getX(), getY()+10);
        }
        if(Greenfoot.isKeyDown("Left")){
            setLocation(getX()-10, getY());
        }
        if(Greenfoot.isKeyDown("Right")){
            setLocation(getX()+10, getY());
        }
        
    }
}
