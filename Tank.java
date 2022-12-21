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
    int rotation = getRotation();
    String facing = "right";
    GreenfootImage [] images = new GreenfootImage[3];
    
    
    public Tank()
    {
        for(int i = 0; i < images.length; i++)
        {
            images[i] = new GreenfootImage("images/tank" + i + ".png");
            images[i].scale(100, 80);
        }
        setImage(images[0]);
    }
    public void act() {
       
        if (Greenfoot.isKeyDown("a")) {
            turn(-2);
            rotation = getRotation();
        }
        if (Greenfoot.isKeyDown("d")) {
            turn(2);
            rotation = getRotation();
        }
        if (Greenfoot.isKeyDown("s")) {
            move(-3);
        }
        if (Greenfoot.isKeyDown("w")) {
            move(3);
            animate();
        }
        if (Greenfoot.isKeyDown("space"))
        {
           shoot();
        }
    }
    int i = 0;
    public void animate()
    {
        setImage(images[(i  % 2) + 1]);
        i++;
    }
    public void shoot()
    {
        Bullet bullet = new Bullet();
        MyWorld world = (MyWorld) getWorld();
        world.addObject(bullet, getX(), getY());
        


    }
}
