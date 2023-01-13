import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Bullet extends Actor

{
    String type;
    boolean scored;
    SimpleTimer bulletTimer = new SimpleTimer();
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

    public void act() 
    {
        move(9);
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
        if(bulletTimer.millisElapsed() > 5000)
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
