import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ConfirmButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConfirmButton extends Actor
{
    public boolean confirm=false;
    /**
     * Act - do whatever the ConfirmButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean getConfirm(){
        return confirm;
    }
    public void resetConfirm(){
        confirm=false;
    }
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.mouseClicked(this)){
            world.replaceId();
            confirm=true;
        }
    }
}
