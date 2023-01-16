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
    int blueWinstreak = 0;
    int redWinstreak = 0;
    int longestRedStreak = 0;
    int longestBlueStreak = 0;
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        
        if(winner == "blue"){
            
            blueWinstreak++;
            if(blueWinstreak > longestBlueStreak){
                longestBlueStreak = blueWinstreak;
            }
            
            longestRedStreak = redWinstreak;
            redWinstreak = 0;
        }
        else{
            redWinstreak++;
            if(redWinstreak > longestRedStreak){
                longestRedStreak = redWinstreak;
            }
            
            longestBlueStreak = blueWinstreak;
            blueWinstreak = 0;
        }
       
        Label title = new Label("Game Over! " + winner, 100);
        addObject(title, getWidth()/2, getHeight()/2); 
        Label space = new Label("Press space to replay", 45);
        addObject(space, getWidth()/2, 450); 
        Label blue = new Label("Longest blue winstreak:" + longestBlueStreak, 30);
        addObject(blue, getWidth()/2 - 100, 525); 
        Label red = new Label("Longest red winstreak:" + longestRedStreak, 30);
        addObject(red, getWidth()/2 + 100, 525); 
       
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("shift")) {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);

        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

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
