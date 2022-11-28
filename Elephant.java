import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    private boolean isFacingRight=true;
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Elephant(){
        
    }
    public void move(){
        int x=getX();
        int y=getY();
        if(Greenfoot.isKeyDown("A")){
            isFacingRight=true;
            x-=4;
        }
        if(Greenfoot.isKeyDown("D")){
            isFacingRight=false;
            x+=4;
        }
        setLocation(x,y);
    }
    public void act(){
        move();
        if(isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            world.spawnApple();
        }
    }
}
