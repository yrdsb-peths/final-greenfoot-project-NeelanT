import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the MyWorld class where the actual game takes place with 2 tanks shooting at each other with bullets that bounce off walls.
 * 
 * @author Neelan  
 * @version Jan 13th, 2023
 */
public class MyWorld extends World
{
    int counterBlue = 0;
    int counterRed = 0;
    int scoreBlue = 0;
    int scoreRed = 0;
    String state = "";
    boolean scored = false;
    Tank tank1;
    Tank2 tank2;
    Label score;
    
    EndScreen end = new EndScreen();
    
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1);
        score = new Label(scoreBlue + " - " + scoreRed, 50);
        addObject(score, getWidth()/2, 50);
        tank1 = new Tank();
        addObject(tank1, 0, getHeight()/2);
        tank2 = new Tank2();
        addObject(tank2, getWidth(), getHeight()/2);
        Wall1 wall1 = new Wall1(500);
        addObject(wall1, 0, 150);
        Wall2 wall = new Wall2(13);
        addObject(wall, 245, 150);
        Wall2 wall2 = new Wall2(500);
        addObject(wall2, 500, 150);
        Wall1 wall4 = new Wall1(19);
        addObject(wall4, 500, 398);
        Wall2 wall5 = new Wall2(310);
        addObject(wall5, 207, 440);
        Wall1 wall6 = new Wall1(19);
        addObject(wall6, 207, 285);
        Wall1 wall10 = new Wall1(19);
        addObject(wall10, 207, 595);
        Wall2 wall7 = new Wall2(360);
        addObject(wall7, 980, 325);
        Wall1 wall8 = new Wall1(450);
        addObject(wall8, 600, 564);
        Wall2 wall11 = new Wall2(13);
        addObject(wall11, 375, 564);
        Wall2 wall12 = new Wall2(13);
        addObject(wall12, 825, 564);
        Wall2 wall9 = new Wall2(600);
        addObject(wall9, 727, 2);
        Wall1 wall13 = new Wall1(19);
        addObject(wall13, 727, 300);
        Wall1 wall14 = new Wall1(19);
        addObject(wall14, 980, 149);
        Wall1 wall15 = new Wall1(19);
        addObject(wall15, 980, 501);
    }
    /**
     * Act method of MyWorld
     * Checks if game is won and if a score is made 
     */
    public void act(){
        if(scoreBlue == 10|| scoreRed == 10){
            if(scoreBlue == 10 && scoreRed < 10){
                
                end.state = "Blue wins!";
                end.blueWinstreak++;
                if(end.blueWinstreak > end.longestBlueStreak){
                    end.longestBlueStreak = end.blueWinstreak;
                }
                
                
                end.redWinstreak = 0;
                end.world(this);
                Greenfoot.setWorld(end);
            

            }
            else if (scoreRed == 10 && scoreBlue < 10){
                
                end.state = "Red wins!";
                end.redWinstreak++;
                if(end.redWinstreak > end.longestRedStreak){
                    end.longestRedStreak = end.redWinstreak;
                }
                
                
                end.blueWinstreak = 0;
                end.world(this);
                Greenfoot.setWorld(end);
            }
            else{
                end.state = "It's a draw!";
                end.world(this);
                Greenfoot.setWorld(end);
            }
            scoreBlue = 0;
            scoreRed = 0;
            score.setValue("0 - 0");
        }
        
        if(scored && numberOfObjects() < 18){
            reset();
            scored = false;
            counterBlue = 0;
            counterRed = 0;

        }
        
    }
    public void map1()
    {

    }
    /**
     * This method increases the respective score when a bullet hits a tank.
     */
    public void increaseScore(String color){
        if(color == "blue"){
            scoreBlue++;
            
        }
        else{
            scoreRed++;
        }
        score.setValue(scoreBlue + " - " + scoreRed);
        
        
    }
    /**
     * This method increases the counterBlue and counterRed variables that manage the amount of bullets each tank can shoot.
     * 
     */
    public void increaseCounter(String color){
        if(color == "blue")
        {
            counterBlue++;
            
        }
        else{
            counterRed++;
        }
        
    }
    /**
     * This method decreases the counterBlue and counterRed variables that manage the amount of bullets each tank can shoot.
     */
    public void decreaseCounter(String color){
        if(color == "blue")
        {
            counterBlue--;
            
        }
        else{
            counterRed--;
        }
        
    }
    /**
     * When a score is made, this method resets the positions of each tank to start again.
     */
    public void reset()
    {
        removeObjects(getObjects(Bullet.class));
        removeObject(tank1);
        removeObject(tank2);
        addObject(tank1, 0, getHeight()/2);
        addObject(tank2, getWidth(), getHeight()/2);
    }

}
