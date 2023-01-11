    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    public class TitleTank1 extends Actor
    {
        SimpleTimer timer = new SimpleTimer();
        SimpleTimer shootTimer = new SimpleTimer();
        int level = 1;
        
        String facing = "right";
        GreenfootImage [] images = new GreenfootImage[3];
        
        
        public TitleTank1()
        {
            for(int i = 0; i < images.length; i++)
            {
                images[i] = new GreenfootImage("images/tank" + i + ".png");
                images[i].scale(100, 80);
            }
            setImage(images[0]);
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
