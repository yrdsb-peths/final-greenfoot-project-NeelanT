import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
* This is the Tank class where the functions such as shooting and moving are defined.
* 
* @author Neelan  
* @version Jan 18th, 2023
*/
public class Tank extends Actor
{
    SimpleTimer timer = new SimpleTimer();
    SimpleTimer shootTimer = new SimpleTimer();
    int level = 1;
    int count = 0;
    boolean scored = false;
    String facing = "right";
    GreenfootImage [] images = new GreenfootImage[3];
    GreenfootSound gunshot = new GreenfootSound("sounds/gunshot1.wav"); 
    /**
     * This is the constructor for the Tank, loads the animation images and starts timers
     */
    public Tank()
    {
        for(int i = 0; i < images.length; i++)
        {
            images[i] = new GreenfootImage("images/tank" + i + ".png");
            images[i].scale(80, 64);
        }
        setImage(images[0]);
        timer.mark();
        shootTimer.mark();
    }
    /**
     * This is the act method, which allows the tank to move, turn and shoot bullets using WASD and spacebar. It also checks if a bullet has hit the tank.
     */
    public void act() {
        if (scored){
            MyWorld world = (MyWorld) getWorld();
            if(world.counterBlue == 0 && world.counterRed == 0)
                world.reset();
        }
        // If the tank is touching a vertical wall, makes the tank move back
        if(isTouching(Wall1.class))
        {
            Wall1 wall = (Wall1)getOneIntersectingObject(Wall1.class);
            if(wall.getY() > this.getY() )
            {
                setLocation(getX(), getY() - 4);
            }
            else {
                setLocation(getX(), getY() + 4);
            }

            
        }
        // If the tank is touching a horizontal wall, makes the tank move back
        if(isTouching(Wall2.class))
        {
            Wall2 wall = (Wall2)getOneIntersectingObject(Wall2.class);
            if(wall.getX() > this.getX() )
            {
                setLocation(getX() - 4, getY() );
            }
            else {
                setLocation(getX() + 4, getY() );
            }
            
        }
        
        if(isTouching(Bullet.class) && shootTimer.millisElapsed() > 200)
        {
            MyWorld world = (MyWorld) getWorld();
            removeTouching(Bullet.class);
            world.scored = true;
            world.increaseScore("red");
            world.decreaseCounter("blue");
            world.decreaseCounter("red");
            
            world.removeObject(this);

            

            
        }
       
        if (Greenfoot.isKeyDown("a")) {
            turn(-3);
            
        }
        if (Greenfoot.isKeyDown("d")) {
            turn(3);
            
        }
        if (Greenfoot.isKeyDown("s")) {
            move(-4);
        }
        if (Greenfoot.isKeyDown("w")) {
            move(4);

        }
        if (Greenfoot.isKeyDown("space") )
        {
            shoot();
            
        }
        animate();
    }
    /**
     * This is the animate method that changes the image of the tank when it moves to show animation
     */
    int i = 0;
    
    public void animate()
    {
        if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s")) {
            if(timer.millisElapsed() >= 70)
            {
                setImage(images[(i  % 2) + 1]);
                i++;
                timer.mark();
            }
        }
        else
        {
            setImage(images[0]);
        }
        


    }
    /**
     * This is the shoot method, when the player presses space a Bullet object is created on the tank and the player's bullet count is updated.
     * The method only shoots when a cooldown of 425ms is done and the player has less than 5 bullets on screen.
     * 
     */
    public void shoot()
    {
        
        
        if(shootTimer.millisElapsed() > 425)
        {
            
            MyWorld world = (MyWorld) getWorld();
            
            
            if(world.counterBlue < 5 && !world.scored)
            {
                gunshot.play();
                world.increaseCounter("blue");
                shootTimer.mark();
                Bullet bullet = new Bullet(getRotation(), "blue");
                world.addObject(bullet, getX(), getY()); 
            }

        }
       
         
    }
}
