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
        super(1200, 700, 1);
        Tank tank = new Tank();
        addObject(tank, 0, getHeight()/2);
        Tank2 tank2 = new Tank2();
        addObject(tank2, getWidth(), getHeight()/2);
        Wall1 wall1 = new Wall1(500);
        addObject(wall1, 0, 150);
        Wall2 wall = new Wall2(13);
        addObject(wall, 240, 150);
        Wall2 wall2 = new Wall2(500);
        addObject(wall2, 500, 150);
        Wall1 wall4 = new Wall1(19);
        addObject(wall4, 500, 398);
        Wall2 wall5 = new Wall2(500);
        addObject(wall5, 750, 300);
    }
    public void map1()
    {
        
        
    }
}
