    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    /**
     * A Red Tank class that cannot move and is used in the title screen world.
     * @author Neelan
     * @version Jan 18th, 2023
     */
    public class TitleTank2 extends Actor
    {
        SimpleTimer timer = new SimpleTimer();
        SimpleTimer shootTimer = new SimpleTimer();
        int level = 1;
        
        int rotation = getRotation();
        String facing = "right";
        GreenfootImage [] images = new GreenfootImage[3];
        
        
        public TitleTank2()
        {
            for(int i = 0; i < images.length; i++)
            {
                images[i] = new GreenfootImage("images/redtank" + i + ".png");
                images[i].scale(100, 80);
            }
            setImage(images[0]);
            setRotation(180);

            timer.mark();
            shootTimer.mark();
        }
        public void act() {
            if(isTouching(Wall1.class))
            {
                Wall1 wall = (Wall1)getOneIntersectingObject(Wall1.class);
                if(wall.getY() > this.getY() )
                {
                    setLocation(getX(), getY() - 5);
                }
                else {
                    setLocation(getX(), getY() + 5);
                }

                



  
  
                

            }
            if(isTouching(Wall2.class))
            {
                Wall2 wall = (Wall2)getOneIntersectingObject(Wall2.class);
                if(wall.getX() > this.getX() )
                {
                    setLocation(getX() - 5, getY() );
                }
                else {
                    setLocation(getX() + 5, getY() );
                }
                
            }
            if(isTouching(Bullet.class) && shootTimer.millisElapsed() > 150)
            {
                MyWorld world = (MyWorld) getWorld();
                removeTouching(Bullet.class);
                world.removeObject(this);
                

                
            }
           
            if (Greenfoot.isKeyDown("left")) {
                turn(-3);
                rotation = getRotation();
            }
            if (Greenfoot.isKeyDown("right")) {
                turn(3);
                rotation = getRotation();
            }
            if (Greenfoot.isKeyDown("down")) {
                move(-5);
            }
            if (Greenfoot.isKeyDown("up")) {
                move(5);

            }

            animate();
        }
    int i = 0;
    public void animate()
    {
        if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s")) {
            if(timer.millisElapsed() >= 40)
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

}
