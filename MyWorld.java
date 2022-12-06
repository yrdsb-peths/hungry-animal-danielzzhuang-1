import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score=0;
    Label scoreLabel;
    Apple apple = new Apple();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true);
        
        prepare();
        backGround bg =new backGround();
        addObject(bg, 200, 200);
        prepare();
        
        
        
        scoreLabel = new Label(score, 80);
        addObject(scoreLabel, 50, 50);
        
    }
    
    public void gameOver(){
        Label gameOverLabel=new Label("Game over", 100);
        addObject(gameOverLabel, 300, 200);

    }
    
    public void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,300,300);

    }
    
     public void spawnApple(){
        
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
    }
    
    public void act(){
        spawnApple();
        if(apple.getY()>350){
            gameOver();
        }
    }
}
