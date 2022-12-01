import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public skillC skillC;
    public skill[] skillArr=new skill[2];
    public skill[] newSkillArr=new skill[2];
    public door door;
    public int skillSelect = -1;
    
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
        
        for(int i=0; i<skillArr.length; i++){
            skillArr[i]= new skill(i);
            addObject(skillArr[i], 175, 100*(i+1));
        }
        
        for(int i=0; i<skillArr.length; i++){
            newSkillArr[i]= new skill(i);
            addObject(newSkillArr[i], 575, 100*(i+1));
        }
        
        
        skillC=new skillC();
        addObject(skillC, 150, 200);
    }
    public void setSkillSelect(int identificationNum){
        this.skillSelect=identificationNum;
    }
    public int getSkillSelect(){
        return skillSelect;
    }
    public void skillSelect(int x, int y){
        skillC.skillSelected(x, y);
    }
    public void act(){
        showText("run", 450, 300);
    }
}
