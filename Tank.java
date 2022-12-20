import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tank extends Actor
{
    int level = 1;
    String facing = "right";
    GreenfootImage [] images = new GreenfootImage[8];
    GreenfootImage [] imagesLeft = new GreenfootImage[8];
    
    public Tank()
    {
        
        GreenfootImage image = new GreenfootImage("images/tank1.png");
        image.scale(75, 75);
        setImage(image);
    }
    public void act() {
        
        if (Greenfoot.isKeyDown("a")) {
            turn(-2);
        }
        if (Greenfoot.isKeyDown("d")) {
            turn(2);
        }
        if (Greenfoot.isKeyDown("s")) {
            move(-3);
        }
        if (Greenfoot.isKeyDown("w")) {
            move(3);
        }
        if (Greenfoot.isKeyDown("space"))
        {
           shoot();
        }
    }
    public void shoot()
    {
        


    }
}
