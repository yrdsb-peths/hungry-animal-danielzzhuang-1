import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**b
 * Write a description of class atk_c1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Button extends Actor
{
    GreenfootImage[] playerSkill_idle = new GreenfootImage[12];
    public int buttonNum;
    public int id;
    public boolean ifOldButton;
    public boolean ifPressed=false;
    
    
    
    /**
     * Act - do whatever the atk_c1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Button(int id, boolean ifOldButton){
        this.id=id;
        this.ifOldButton=ifOldButton;
    }
    /*
    public void setSkillNum(int skillNum){
        this.skillNum=skillNum;
    }
    
    public int getSkillNum(){
        return skillNum;
    }
    */
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public boolean getIfOldButton(){
        return ifOldButton;
    }
    public boolean ifSelected(){
        return ifPressed;
    }
    public void resetSelected(){
        ifPressed=false;
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
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.mouseClicked(this)){
            world.cancelSelect(ifOldButton);
            ifPressed=true;
        }
        if(ifPressed){
            playerSkill_idle[id] = new GreenfootImage("images/gameSkill_idle/playerSkill_"+(id+0.1)+".png");
            setImage(playerSkill_idle[id]);
            playerSkill_idle[id].scale(300, 300);
        }
        else if(!ifPressed){
            playerSkill_idle[id] = new GreenfootImage("images/gameSkill_idle/playerSkill_"+id+".png");
            setImage(playerSkill_idle[id]);
            playerSkill_idle[id].scale(300, 300);
        }
        //set image and size 
        
    }
}
