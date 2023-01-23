import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public ArrayList<Button> oldButtonArr=new ArrayList<Button>();
    public ArrayList<Button> newButtonArr=new ArrayList<Button>();
    public ArrayList<Integer> skillArr = new ArrayList<Integer>();
    
    public ConfirmButton cButton;
    public int testOne=0;
    public int temp;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1, false); 
        for(int i=0; i<2; i++){
            oldButtonArr.add(new Button(i, true));
        }
        for(int i=0; i<oldButtonArr.size(); i++){
            addObject(oldButtonArr.get(i), 175, 100*(i+1));
        }
        
       for(int i=0; i<2; i++){
            newButtonArr.add(new Button(i+2, false));
        }
        for(int i=0; i<newButtonArr.size(); i++){
            addObject(newButtonArr.get(i), 500, 100*(i+1));
        }
        //0 for old, 1 for new
        
        for(int i=0; i<6; i++){
            skillArr.add(i);
        }
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
            for(int i=0; i<oldButtonArr.size(); i++){
                oldButtonArr.get(i).resetSelected();
            }
        }
        else if(!ifOldButton){
            for(int i=0; i<newButtonArr.size(); i++){
                newButtonArr.get(i).resetSelected();
            }
        }
    }
    public void cancelSelect(){
        for(int i=0; i<oldButtonArr.size(); i++){
            oldButtonArr.get(i).resetSelected();
        }
        for(int i=0; i<newButtonArr.size(); i++){
            newButtonArr.get(i).resetSelected();
        }
    }
    public ArrayList<Integer> removeComEle(ArrayList<Button> a, ArrayList<Integer> b){
        for(int i=0; i<a.size(); i++){
          for(int j=0; j<b.size(); j++){
            if(a.get(i).getId()==b.get(j)){
              b.remove(0);
            }
          }
        }
        return b;
    }
    public ArrayList<Integer> swapEle(ArrayList<Button> a, ArrayList<Integer> b){
        for(int i=0; i<a.size(); i++){
          for(int j=0; j<b.size(); j++){
            if(a.get(i).getId()!=b.get(j)){
              b.add(a.get(i).getId());
            }
          }
        }
        return b;
    }
    public ArrayList<Integer> randomArr(ArrayList<Integer> a){
        for(int i=0; i<a.size(); i++){
          int rNum=(int)(Math.random()* a.size());
          Collections.swap(a, i, rNum);
        }
        return a;
    
    }
    public void replaceId(){
        for(int i=0; i<oldButtonArr.size(); i++){
            if(oldButtonArr.get(i).ifSelected()){
                for(int j=0; j<newButtonArr.size(); j++){
                    if(newButtonArr.get(j).ifSelected() && cButton.getConfirm()){
                        temp=oldButtonArr.get(i).getId();
                        oldButtonArr.get(i).setId(newButtonArr.get(j).getId());
                        newButtonArr.get(j).setId(temp);
                        cancelSelect();
                        cButton.resetConfirm();
                        testOne=0;
                    }
                }
            }
        }
    }
    public void learnNewSkill(){
        if(testOne==0){
            removeComEle(oldButtonArr, skillArr);
            randomArr(skillArr); 
            for(int i=0; i<newButtonArr.size(); i++){
                removeComEle(oldButtonArr, skillArr);
                newButtonArr.get(i).setId(skillArr.get(i));
            }
            testOne=1;
        }
        if(oldButtonArr.size()==2 && testOne==1){
            replaceId();
            if(testOne==0){
                swapEle(newButtonArr, skillArr);
            }
        }
    }
    public void act(){
        learnNewSkill();
    }
}
