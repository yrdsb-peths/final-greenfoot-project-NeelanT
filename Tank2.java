    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    public class Tank2 extends Actor
    {
        SimpleTimer timer = new SimpleTimer();
        SimpleTimer shootTimer = new SimpleTimer();
        int level = 1;
        boolean scored = false;
        int rotation = getRotation();
        String facing = "right";
        GreenfootImage [] images = new GreenfootImage[3];
        GreenfootSound gunshot = new GreenfootSound("sounds/gunshot2.wav"); 
        
        public Tank2()
        {
            for(int i = 0; i < images.length; i++)
            {
                images[i] = new GreenfootImage("images/redtank" + i + ".png");
                images[i].scale(80, 64);
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
                    setLocation(getX() - 4, getY() );
                }
                else {
                    setLocation(getX() + 4, getY() );
                }
                
            }
            if(isTouching(Bullet.class) && shootTimer.millisElapsed() > 150)
            {
                MyWorld world = (MyWorld) getWorld();
                removeTouching(Bullet.class);
                world.scored = true;
                world.increaseScore("blue");
                world.decreaseCounter("blue");
                world.decreaseCounter("red");
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
                move(-4);
            }
            if (Greenfoot.isKeyDown("up")) {
                move(4);

            }
            if (Greenfoot.isKeyDown("shift") )
            {
                shoot();
                
            }
            animate();
        }
    int i = 0;
    public void animate()
    {
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down")) {
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
    public void shoot()
    {
        if(shootTimer.millisElapsed() > 425)
        {
            
            MyWorld world = (MyWorld) getWorld();
            world.increaseCounter("red");
            if(world.counterRed < 5)
            {   
                gunshot.play();
                shootTimer.mark();
                Bullet bullet = new Bullet(getRotation(), "red");
                world.addObject(bullet, getX(), getY()); 
            }

        }
       
         
    }
}
