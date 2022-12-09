import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**b
 * Write a description of class atk_c1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Button extends Actor
{
    public int id;
    GreenfootImage[] selected = new GreenfootImage[6];
    GreenfootImage[] deselected = new GreenfootImage[6];
    public int size=300;    
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
    j
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
    //images/gameSkill_idle/playerSkill
    public void act(){
        //test 
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.mouseClicked(this)){
            world.cancelSelect(ifOldButton);
            ifPressed=true;
        }
        if(ifPressed){
            deselected[id] = new GreenfootImage("images/playerSkill_deselected/playerSkill_"+id+".png");
            setImage(deselected[id]);
            deselected[id].scale(size, size);
        }
        else if(!ifPressed){
            selected[id] = new GreenfootImage("images/playerSkill_selected/playerSkill_"+id+".png");
            setImage(selected[id]);
            selected[id].scale(size, size);
        }
        //set image and siz
        
    }
}
