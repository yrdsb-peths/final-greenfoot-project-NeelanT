import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    public Bullet(int rotation)
    {
        GreenfootImage image = new GreenfootImage("images/bullet.png");
        image.scale(30, 50);
        setImage(image);
        setRotation(rotation);
    }

    public void act() 
    {
        move(10);
    }    
}
