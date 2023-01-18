import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * This is the Bullet class that manages the trajectory of the bullet.
 * 
 * @author Neelan
 * @version Jan 18th, 2023
 */

public class Bullet extends Actor

{
    String type;
    boolean scored;
    SimpleTimer bulletTimer = new SimpleTimer();
    /**
    * Constructor for Bullet class.
    */
    public Bullet(int rotation, String type)
    {
        scored = false;
        this.type = type;
        GreenfootImage image = new GreenfootImage("images/bullet.png");
        image.scale(25, 35);
        setImage(image);
        setRotation(rotation);
        bulletTimer.mark();
        move(9);
        
    }
    /**
    * This is the act method for the bullet that controls the speed of the bullet.
    * It also controls how the bullet interacts with walls.
    * When the bullet touches a horizontal or vertical wall, the rotation is set to reflect the bullet off the wall.
    * The method also controls the lifetime of the bullet.
    */
    public void act() 
    {
        move(9);
        MyWorld world = (MyWorld) getWorld();
        // When the bullet hits the boundaries of the world or a wall, 
        // the rotation is changed to reflect off depending on if the wall is horizontal or vertical 
        if(getX() >= world.getWidth() - 1 || getX() <= 1 || isTouching(Wall2.class))
        {
            setRotation(180 - getRotation());
            move(2);
        }
        else if (getY() >= world.getHeight() - 1 || getY() <= 1 || isTouching(Wall1.class))
        {
            setRotation(270 - (getRotation() - 90));
            move(2);
        }
        // Lifetime of the bullet before it despawns
        if(bulletTimer.millisElapsed() > 3500)
        {
            if(type == "blue")
            {
                world.decreaseCounter("blue");
                
            }
            else {
                world.decreaseCounter("red");
            }
            world.removeObject(this);
        }
        
    }    
}
