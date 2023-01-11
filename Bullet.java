import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Bullet extends Actor

{
    
    SimpleTimer bulletTimer = new SimpleTimer();
    public Bullet(int rotation)
    {
        GreenfootImage image = new GreenfootImage("images/bullet.png");
        image.scale(30, 50);
        setImage(image);
        setRotation(rotation);
        bulletTimer.mark();
        move(10);
        
    }

    public void act() 
    {
        move(10);
        MyWorld world = (MyWorld) getWorld();

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
        if(bulletTimer.millisElapsed() > 4000)
        {
            world.removeObject(this);
        }
        
    }    
}
