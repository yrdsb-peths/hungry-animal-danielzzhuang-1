import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**b
 * Write a description of class atk_c1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class skill extends Actor
{
    GreenfootImage[] playerSkill_idle = new GreenfootImage[2];
    public int skillNum;
    public int identificationNum=0;
    
    MouseInfo mi = Greenfoot.getMouseInfo();
    MyWorld world = (MyWorld) getWorld();
    
    /**
     * Act - do whatever the atk_c1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public skill(int identificationNum){
        this.identificationNum=identificationNum;
    }
    /*
    public void setSkillNum(int skillNum){
        this.skillNum=skillNum;
    }
    
    public int getSkillNum(){
        return skillNum;
    }
    */
    public void setIdentificationNum(int identificationNum){
        this.identificationNum=identificationNum;
    }
    
    /*
    public void show(){
        setLocation(450, 50+skillNum*100);
        //y:150, 250, 350, 450 
    }
    */
    public void hide(){
        setLocation(450, 1000);
    }
    
    
    //images/gameSkill_idle/playerSkill
    public void act(){
        //test 
        if(Greenfoot.mouseClicked(this)){
            world.setSkillSelect(identificationNum);
            if(world.getSkillSelectNum() == this.identificationNum){
                world.skillSelect(getX(), getY());
            }
        }
        
        //set image and size 
        playerSkill_idle[identificationNum] = new GreenfootImage("images/gameSkill_idle/playerSkill_"+identificationNum+".png");
        setImage(playerSkill_idle[identificationNum]);
        playerSkill_idle[identificationNum].scale(300, 300);
    }
}
