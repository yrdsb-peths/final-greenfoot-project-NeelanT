import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        Label title = new Label("Tank Trouble 3", 100);
        addObject(title, getWidth()/2, getHeight()/2); 
        Label space = new Label("Press space to start", 45);
        addObject(space, getWidth()/2, 450); 
        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space") && Greenfoot.isKeyDown("shift"))
        {
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
        Tank2 tank2 = new Tank2();

        addObject(tank2,1000,getHeight()/2);
        Tank tank = new Tank();
        addObject(tank,200, getHeight()/2);


    }
}
