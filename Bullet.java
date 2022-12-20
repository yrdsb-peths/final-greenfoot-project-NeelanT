import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    public Bullet()
    {
        GreenfootImage image = new GreenfootImage("images/bullet.png");
        image.scale(30, 50);
        setImage(image);
    }

    public void act() 
    {
        move(10);
    }    
}
