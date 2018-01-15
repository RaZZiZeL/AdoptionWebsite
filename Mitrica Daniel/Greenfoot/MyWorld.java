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
        super(600, 400, 1); 
  
        Player player = new Player();
        Point point0 = new Point();
        Point point1 = new Point();
        Point point2 = new Point();
        Point point3 = new Point();
        Point point4 = new Point();
        Danger danger0 = new Danger();
        Danger danger1 = new Danger();
        addObject(player, getWidth()/2, getHeight()/2);
        
        addObject(point0,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject(point1,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject(point2,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject(point3,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject(point4,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        
        addObject(danger0,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject(danger1,Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
    }
}
