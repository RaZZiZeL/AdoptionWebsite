import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        prepare();
        
    }
    
    public void prepare(){
        Kitty kitty = new Kitty();
        addObject(kitty,452,456);
        Shuriken shuriken = new Shuriken();
        addObject(shuriken, 617, 34);
        Cookie cookie = new Cookie();
        addObject(cookie, 45, 35);
        
    }
}
