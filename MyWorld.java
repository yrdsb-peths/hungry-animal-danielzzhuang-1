import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public ButtonLayout[] LayoutArr=new ButtonLayout[2];
    public Button[] oldButtonArr=new Button[1];
    public Button[] newButtonArr=new Button[1];
    public ConfirmButton cButton;
    
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
        
        for(int i=0; i<oldButtonArr.length; i++){
            oldButtonArr[i]= new Button(i, true);
            addObject(oldButtonArr[i], 175, 100*(i+1));
        }
        
        for(int j=0; j<newButtonArr.length; j++){
            newButtonArr[j]= new Button(1, false);
            addObject(newButtonArr[j], 500, 100*(j+1));
        }
        //0 for old, 1 for new
        for(int i=0; i<LayoutArr.length; i++){
            LayoutArr[i]= new ButtonLayout();
            addObject(LayoutArr[i], 1000, 1000);
        }
        
        cButton = new ConfirmButton();
        addObject(cButton, 300, 300);
    }
    /*
    public int getOldSkillId(int id){
        return oldSkillId;
    }
    */
    public void callLayout(boolean oldSkill, int x, int y){
        if(oldSkill){
            LayoutArr[0].setLocation(x, y);
        }
        else if(!oldSkill){
            LayoutArr[1].setLocation(x, y);
        }
    }
    public void replaceId(){
        for(int i=0; i<oldButtonArr.length; i++){
            if(LayoutArr[0]. getY()==oldButtonArr[i].getY()){
                for(int j=0; j<newButtonArr.length; j++){
                    if(LayoutArr[1]. getY()==newButtonArr[j].getY() && cButton.getConfirm()){
                        oldButtonArr[i].setId(newButtonArr[j].getId());
                        cButton.resetConfirm();
                    }
                }
            }
        }
        
        
    }
    public void act(){
        
    }
}
