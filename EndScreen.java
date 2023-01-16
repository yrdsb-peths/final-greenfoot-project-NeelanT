import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The end screen of Tank Trouble 3.
 * 
 * @author Neelan 
 * @version Jan 13, 2023
 */
public class EndScreen extends World
{
    /**
     * Constructor 
     */
    String state = "";
    MyWorld world;
    int blueWinstreak = 0;
    int redWinstreak = 0;
    int longestRedStreak = 0;
    int longestBlueStreak = 0;
    Label blue;
    Label red;
    Label title;
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        
        
       
        title = new Label("Game Over!", 100);
        addObject(title, getWidth()/2, getHeight()/2); 
        Label space = new Label("Press enter to replay", 45);
        addObject(space, getWidth()/2, 450); 
        blue = new Label("Longest blue winstreak:" + longestBlueStreak, 30);
        addObject(blue, getWidth()/2 - 150, 525); 
        red = new Label("Longest red winstreak:" + longestRedStreak, 30);
        addObject(red, getWidth()/2 + 150, 525); 
       
    }

    public void act()
    {
 
        System.out.println(redWinstreak);
        if(Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(world);

        }
        title.setValue("Game Over!" + state);
        blue.setValue("Longest blue winstreak:" + longestBlueStreak);
        red.setValue("Longest red winstreak:" + longestRedStreak);
    }

    public void world(MyWorld tankworld){
        world = tankworld;
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        TitleTank2 tank2 = new TitleTank2();
        addObject(tank2,1000,getHeight()/2);
        TitleTank1 tank = new TitleTank1();
        addObject(tank,200, getHeight()/2);


    }
}
