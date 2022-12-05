import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public skillC[] skillSelectArr=new skillC[2];
    public skill[] oldSkillArr=new skill[2];
    public skill[] newSkillArr=new skill[2];
    public int oldSkillId=-1;
    public int newSkillId=-1;
    
    public boolean e=true;
    public boolean fixed=false;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1, false); 
        
        for(int i=0; i<oldSkillArr.length; i++){
            oldSkillArr[i]= new skill(i, true);
            addObject(oldSkillArr[i], 175, 100*(i+1));
        }
        
        for(int j=0; j<newSkillArr.length; j++){
            newSkillArr[j]= new skill(j, false);
            addObject(newSkillArr[j], 500, 100*(j+1));
        }
        
        //0 for old, 1 for new
        for(int i=0; i<skillSelectArr.length; i++){
            skillSelectArr[i]= new skillC();
            addObject(skillSelectArr[i], 1000, 1000);
        }
    }
    /*
    public int getOldSkillId(int id){
        return oldSkillId;
    }
    */
    public void skillSelect(boolean oldSkill, int x, int y){
        if(oldSkill){
            skillSelectArr[0].setLocation(x, y);
        }
        else if(!oldSkill){
            skillSelectArr[1].setLocation(x, y);
        }
    }
    /*
    public void changeSkill(int oldSkillNum, int newSkillId){
        oldSkillArr[oldSkillNum].setId(newSkillId);
    }
    */
    public void act(){
        
        if(skillSelectArr[0].getY()==100){
            showText("run", 450, 300);
        }
    }
}
