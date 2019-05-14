/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import beanpack.FCongThucFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "recipe2MB")
@SessionScoped
public class Recipe2MB implements Serializable {

    @EJB
    private FCongThucFacadeLocal fCongThucFacade;
    private int foodID;
    private String foodName;
    private int vitaminID;
    private String vitaminName;
    List<Object[]> foodRecipeList = new ArrayList<Object[]>();   
    List<Object[]> vitaminRecipeList = new ArrayList<Object[]>();

    /**
     * Creates a new instance of Recipe2MB
     */
    public Recipe2MB() {
    }
    
     //Show all by foodID
    public String showRecipebyFood(int fID,String fName) {
        foodID = fID;
        foodName = fName;
        foodRecipeList = fCongThucFacade.showRecipeForFood(fID);
        return "food-recipe";
    }  
    //Show all by vitaminID
    public String showRecipebyVitamin(int vID,String vName) {
        vitaminID = vID;
        vitaminName = vName;
        vitaminRecipeList = fCongThucFacade.showRecipeForVitamin(vitaminID);
        return "vitamin-recipe";
    }  
    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getVitaminID() {
        return vitaminID;
    }

    public void setVitaminID(int vitaminID) {
        this.vitaminID = vitaminID;
    }

    public String getVitaminName() {
        return vitaminName;
    }

    public void setVitaminName(String vitaminName) {
        this.vitaminName = vitaminName;
    }

    public List<Object[]> getFoodRecipeList() {
        return foodRecipeList;
    }

    public void setFoodRecipeList(List<Object[]> foodRecipeList) {
        this.foodRecipeList = foodRecipeList;
    }

    public List<Object[]> getVitaminRecipeList() {
        return vitaminRecipeList;
    }

    public void setVitaminRecipeList(List<Object[]> vitaminRecipeList) {
        this.vitaminRecipeList = vitaminRecipeList;
    }
    
}
