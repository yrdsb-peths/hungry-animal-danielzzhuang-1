import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public Button[] oldButtonArr=new Button[3];
    public Button[] newButtonArr=new Button[3];
    public ConfirmButton cButton;
    public int temp;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1, false); 
        
        for(int i=oldButtonArr.length-1; i>-1; i--){
            oldButtonArr[i]= new Button(i, true);
            addObject(oldButtonArr[i], 175, 100*(i+1));
        }
        
        for(int j=newButtonArr.length-1; j>-1; j--){
            newButtonArr[j]= new Button(j+3, false);
            addObject(newButtonArr[j], 500, 100*(j+1));
        }
        //0 for old, 1 for new
        
        cButton = new ConfirmButton();
        addObject(cButton, 300, 450);
    }
    /*
    public int getOldSkillId(int id){
        return oldSkillId;
    }
    */
    public void cancelSelect(boolean ifOldButton){
        if(ifOldButton){
            for(int i=0; i<oldButtonArr.length; i++){
                oldButtonArr[i].resetSelected();
            }
        }
        else if(!ifOldButton){
            for(int i=0; i<newButtonArr.length; i++){
                newButtonArr[i].resetSelected();
            }
        }
    }
    public void cancelSelect(){
        for(int i=0; i<oldButtonArr.length; i++){
            oldButtonArr[i].resetSelected();
        }
        for(int i=0; i<newButtonArr.length; i++){
            newButtonArr[i].resetSelected();
        }
    }
    
    public void replaceId(){
        for(int i=0; i<oldButtonArr.length; i++){
            if(oldButtonArr[i].ifSelected()){
                for(int j=0; j<newButtonArr.length; j++){
                    if(newButtonArr[j].ifSelected() && cButton.getConfirm()){
                        temp=oldButtonArr[i].getId();
                        oldButtonArr[i].setId(newButtonArr[j].getId());
                        newButtonArr[j].setId(temp);
                        cancelSelect();
                        cButton.resetConfirm();
                    }
                }
            }
        }
    }
    public void act(){
        
    }
}
