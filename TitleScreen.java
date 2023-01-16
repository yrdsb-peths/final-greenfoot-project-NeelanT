
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen of Tank Trouble 3.
 * 
 * @author Neelan 
 * @version Jan 13th, 2023
 */
public class TitleScreen extends World
{
    /**
     * Constructor for TitleScreen.
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        
        Label title = new Label("Tank Trouble 3", 100);
        addObject(title, getWidth()/2, getHeight()/2); 
        Label space = new Label("Press space to start", 45);
        
        addObject(space, getWidth()/2, 450); 
        Label controls1 = new Label("Player 1: ", 45);
        addObject(controls1, 400, 525); 
        Arrows arrows = new Arrows();
        addObject(arrows, 388, 635);
        Label controls2 = new Label("Player 2: ", 45);
        Wasd wasd = new Wasd();
        addObject(wasd, 788, 635);
        addObject(controls2, 800, 525); 
        prepare();
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
    private void prepare()
    {
        TitleTank2 tank2 = new TitleTank2();
        addObject(tank2,1000,getHeight()/2);
        TitleTank1 tank = new TitleTank1();
        addObject(tank,200, getHeight()/2);

    }
}
