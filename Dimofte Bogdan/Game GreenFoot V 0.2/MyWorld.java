import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

 //public GreenfootSound  musicGame = new GreenfootSound("GameMusic.wav");

public class MyWorld extends World
{
    private Background img0;
    private Background img1;
    private RealActor Player1;
    private RealActor Ant;
    private Actor Finish1;

    // private barrel Barrel;
    public barrel[] barrelArray = { new barrel(), new barrel(), new barrel(), new barrel(), new barrel() };
    private boolean isFinish=false;
    public boolean isMoving;
    public boolean endGame = false;
    public boolean stopMove = false;
    public boolean isBlock = false;
    public boolean isLoop = true;
    public boolean isMusicStart = false;
    private int  xPosOnMap;
    private int it=1;
    
    
     GreenfootSound backgroundMusic = new GreenfootSound("GameMusic.wav");
 
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(600,500,1,false);
        Player1 = new Player();
        Finish1 = new Finish();
         
        
        Ant = new TestScroller();

        img0 = new Background();
        addObject( img0,getWidth()/2-2,getHeight()/2);

        xPosOnMap = img0.getX();
        
        
        
            //game music
        
        //backgroundMusic.play();
        
        
        // img1 = new Background();

        //addObject( img1,  getWidth()/2 - getWidth() ,getHeight()/2);

        addObject(Player1, 499, 470);
        //Adding barrel
        addObject(barrelArray[0], getRandomNumber(0,300),476);
        addObject(barrelArray[1], getRandomNumber(0,300),476);
        addObject(barrelArray[2], -getRandomNumber(0,900),476);
        addObject(barrelArray[3], -getRandomNumber(0,900),476);
        addObject(barrelArray[4], -300,470);
        it=5;

        
        prepare();
    }

    
    public void act()
    {

        /*
        if(Greenfoot.isKeyDown("right")){
        img0.scrollRight();
        img1.scrollRight();
        }
         */
        
       

        addFinishObject();
        moveBackground();
        moveItem();
        addObjectRandom();
        loopMusic();
        
        
        
        
        // 
       

        // addObject(Ant, 499, 185);
        
    }
    
    public void StartMusic()
    {
          //game music
        if(isMusicStart == false)
           { backgroundMusic.play();
               isMusicStart = true;
            }
    }
    
    public void loopMusic()
    {
        if(isLoop == true)
        backgroundMusic.playLoop();
    }
    
    public int getRandomNumber(int start,int end)
    {
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal+start;
    }

    public void addObjectRandom()
    {

        
      
        if( img0.getX() - xPosOnMap  <=150 &&  img0.getX() -  xPosOnMap >= 100)
        {

            //addObject(new barrel(), 193, 470);
            //  
            /*
             * if(it<5)
             *  {addObject(barrelArray[it],193,470);
            it++;
            //   moveObjects(barrelArray);

            }
             */

            //Functional 
            //  if(Greenfoot.isKeyDown("left") && it>=0 )
            //{
            // for(int aux=0;aux<it;it++)
            //  {
            //   barrelArray[0].setLocation(barrelArray[0].getX()+30,barrelArray[0].getY());
            //}
            //}

            xPosOnMap = img0.getX();

         
        }
    }

     public void CheckEndGame(int xz)
     {
       
                if( xz  >-183)
                {
                   isLoop = false;
                   isMusicStart = true;
                    backgroundMusic.stop();
                }
            
        }
    
    public void moveItem()
    {
        if(isFinish == true && Greenfoot.isKeyDown("left") && isBlock == false )
        {
            Finish1.setLocation(Finish1.getX()+2, Finish1.getY());
            CheckEndGame(Finish1.getX() - Player1.getX());

           
          
        }
        
           
        
        if(Greenfoot.isKeyDown("left") && barrelArray[0]!=null)
        {
            //It Work
            /*
            barrelArray[0].setLocation(barrelArray[0].getX()+2,barrelArray[0].getY());
            barrelArray[1].setLocation(barrelArray[1].getX()+2,barrelArray[1].getY());
            barrelArray[2].setLocation(barrelArray[2].getX()+2,barrelArray[2].getY());
            barrelArray[3].setLocation(barrelArray[3].getX()+2,barrelArray[3].getY());

             */
            for(int aux=0;aux<it && barrelArray[aux]!=null;aux++)
            {
                if( (Player1.getX() - barrelArray[aux].getX()>=50 || Player1.getY() <=405
                    || barrelArray[aux].getX() -  Player1.getX() >=39) &&  isBlock == false )
                { barrelArray[aux].setLocation(barrelArray[aux].getX()+2,barrelArray[aux].getY());
                    stopMove = false;
                }
                else
                { stopMove =true;
                    isBlock = true;
                }
                if(  Player1.getY() <=405 )
                    isBlock = false;

            } 

        }
        
         
    }

    public void moveBackground()
    {
        if(Greenfoot.isKeyDown("left") && Player1.getX()< 470 && stopMove == false  ){
            img0.scrollLeft();
           
        }
    }

    public void addFinishObject()
    {
        if(img0.getX()>=1100 && isFinish == false)
        { addObject(Finish1, -50, 450);
            isFinish = true;
        }

    }
  
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
      
        
    }
}
