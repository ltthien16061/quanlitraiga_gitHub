/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import beanpack.FThucAn;
import beanpack.FThucAnFacadeLocal;
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
@Named(value = "food2MB")
@SessionScoped
public class Food2MB implements Serializable {

    @EJB
    private FThucAnFacadeLocal fThucAnFacade;
    
    private int kindID;
    private String kindName;
    List<FThucAn> foodList = new ArrayList<FThucAn>();
    /**
     * Creates a new instance of Food2MB
     */
    public Food2MB() {
    }
    
     //Show all by spID
    public String showFoodByKind(int kID,String kName) {
        kindID = kID;      
        kindName = kName;
        foodList = fThucAnFacade.showFoodByKind(kindID);
        return "food2";
    }  

    public int getKindID() {
        return kindID;
    }

    public void setKindID(int kindID) {
        this.kindID = kindID;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }
    
    public List<FThucAn> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<FThucAn> foodList) {
        this.foodList = foodList;
    }
    
}
