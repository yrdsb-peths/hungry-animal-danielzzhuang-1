import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class skillC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class skillC extends Actor
{
    /**
     * Act - do whatever the skillC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage image = getImage();
        image.scale(300, 300);
        setImage(image);
    }
    public void skillSelected(int x, int y){
        setLocation(x,y);
    }
}
