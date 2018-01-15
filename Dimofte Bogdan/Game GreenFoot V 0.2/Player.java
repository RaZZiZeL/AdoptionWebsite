import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Player extends RealActor
{
   private int speed = 2;
   private int vSpeed =5;
   private int acceleration = 2;
   private int jumpForce = 20;
    GreenfootSound jumpSound = new GreenfootSound("jump.wav");
   
   
   // on 600 x 400 groundXPosition = 314;
   //private int groundXPosition = 185;
  

    
    
    public void act() 
    {
      
         jumpSound.setVolume(85);
        
        checkKeys();
        checkFall();
        checkCollision();
    }    
    
    public void checkKeys()
    {
        
        String key = Greenfoot.getKey();
         
        
         //Idle animation 
         if (! (Greenfoot.isKeyDown( "right" ) ||Greenfoot.isKeyDown( "left") || Greenfoot.isKeyDown( "space") ) )
         {
             setImage("idle.png");
         }
         
        if (!checkRightCollide())
        {
            if(Greenfoot.isKeyDown("right") && getX()<560 ){
               moveRight();
               setImage("move.png");
            }
            
            //Fake move
            if(Greenfoot.isKeyDown("right") && getX()>=520 ){
               
               setImage("move.png");
            }
            
        }
        
        if(!checkLeftCollide())
        {
                 if(Greenfoot.isKeyDown("left") && getX()>=436){
                  moveLeft();
                  setImage("move.png");
                }
                //Fake move
                 if(Greenfoot.isKeyDown("left") && getX()<=436){
                 
                  setImage("move.png");
                }
                
         }
       
         
         if(key !=null)
           { 
               
               if(key.equals("space") && getY()> 465 - getImage().getHeight() )
               {    
                   //System.out.println( getImage().getHeight());
                   setImage("jump.png");
                   //Greenfoot.playSound("jump.wav");
                   
                   jumpSound.play();
                   jump();
                }
               
               
            }
            
        
       
        
        
    }
    
  
    
    public void checkCollision()
    {
        checkRightCollide();
        checkLeftCollide();
       
    }
    
    public boolean checkLeftCollide()
    {
        Actor leftCollide = getOneObjectAtOffset(0, 10, Platform.class);
        return leftCollide !=null;
    }
    
    public boolean checkRightCollide()
    {
        Actor rightCollide = getOneObjectAtOffset(10, 0, Platform.class);
        return rightCollide !=null;
    }
    
    
    
    
     public void jump()
     {
         vSpeed = -jumpForce;
         fall();
     }
    
    
    public void moveRight()
    {
         setLocation(getX() +speed , getY());
    }
    
    public void moveLeft()
    {
          setLocation(getX() -speed, getY());
    }
    
  
   
    public void checkFall()
    {
        if(onGround()){
            vSpeed=0;
        }

        else  if(getY()<groundXPosition)
        {
            fall();
        }
        else if (onGroundCorect()==false)
        {
            setLocation(getX(),groundXPosition);
           
           
        }
        
        
        
    
    }
    
    public boolean onGroundCorect(){
        if(getY()>groundXPosition)
        return false;
        else
        return true;
    }
    
    
    
    public boolean onGround()
    {
   Actor under = getOneObjectAtOffset( 0 ,  getImage().getHeight() /2   ,Platform.class);
    return under !=null;
    }
    
    
    
    
    public void fall()
    {
       
       
        setLocation(getX(),getY()+vSpeed);
        vSpeed= vSpeed + acceleration;
        
       
       
    }
    
    
    

}