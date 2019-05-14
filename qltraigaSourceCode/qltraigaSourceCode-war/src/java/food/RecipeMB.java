/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import beanpack.FCongThuc;
import beanpack.FCongThucFacadeLocal;
import beanpack.FThucAn;
import beanpack.FThucAnFacadeLocal;
import beanpack.FVitamin;
import beanpack.FVitaminFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import other.CustomValidator;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "recipeMB")
@SessionScoped
public class RecipeMB extends CustomValidator implements Serializable {

    @EJB
    private FCongThucFacadeLocal fCongThucFacade;

    @EJB
    private FVitaminFacadeLocal fVitaminFacade;

    @EJB
    private FThucAnFacadeLocal fThucAnFacade;
    
    private int recipeID;
    private int foodID;
    private String foodName;
    private int foodQuantity;
    private Integer vitaminID;
    private String vitaminName;
    private int vitaminQuantity;
    private String description;
    
    /**
     * Creates a new instance of RecipeMB
     */
    public RecipeMB() {
    }
    
    //show all Recipe
    public List<Object[]> showAllRecipe() {
        List<Object[]> recipeList = new ArrayList<Object[]>();
        recipeList = fCongThucFacade.showAllRecipe();
        return recipeList;
    }     
    
    //Add New Recipe
        //get id Food
        public void getFoodInfoForAdd(int fID, String fName){
            foodID = fID;
            foodName = fName;
        }
        //get id Vitamin
        public String getVitaminInfoForAdd(int vID, String vName){
            vitaminID = vID;
            vitaminName = vName;
            return "recipe-add2";
        }
        public String skipVitamin(){
            vitaminID = null;
            vitaminName = "Không có";
            vitaminQuantity = 0;
            return "recipe-add2";
        }
        public String addRecipe(){
              try{
                FCongThuc congthuc = new FCongThuc();
                FThucAn food = fThucAnFacade.find(foodID);
                congthuc.setMathucan(food);
                congthuc.setSlthucan(foodQuantity);
                if(vitaminID!=null){
                    FVitamin vitamin = fVitaminFacade.find(vitaminID);
                    congthuc.setMavitamin(vitamin);
                    congthuc.setSlvitamin(vitaminQuantity);
                }else{
                    congthuc.setSlvitamin(0);
                }
                if(description!=null){
                    congthuc.setMota(description);
                }
                congthuc.setXoa(false);
                fCongThucFacade.create(congthuc);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "recipe";
                }catch(Exception ex){
                ex.printStackTrace();
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm !", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "recipe-add";
            }
        }
        
    //EditRecipe
         public String getIdForEdit(int rID){
             recipeID = rID;
             FCongThuc congthuc = fCongThucFacade.find(rID);
             foodQuantity = congthuc.getSlthucan();
             vitaminQuantity = congthuc.getSlvitamin();
             return "recipe-edit";
         }
         //get id Food
        public void getFoodInfoForEdit(int fID, String fName){
            foodID = fID;
            foodName = fName;
        }
        //get id Vitamin
        public String getVitaminInfoForEdit(int vID, String vName){
            vitaminID = vID;
            vitaminName = vName;
            return "recipe-edit2";
        }
        public String skipVitaminEdit(){
            vitaminID = null;
            vitaminName = "Không có";
            vitaminQuantity = 0;
            return "recipe-edit2";
        }
         public String editRecipe() {
            try{
               //Set forgein key
                FCongThuc congthuc = fCongThucFacade.find(recipeID);                
                FThucAn food = fThucAnFacade.find(foodID);
                congthuc.setMathucan(food);
                congthuc.setSlthucan(foodQuantity);
                if(vitaminID!=null){
                    FVitamin vitamin = fVitaminFacade.find(vitaminID);
                    congthuc.setMavitamin(vitamin);
                    congthuc.setSlvitamin(vitaminQuantity);
                }else{
                    congthuc.setSlvitamin(0);
                }
                if(description!=null){
                    congthuc.setMota(description);
                }
                congthuc.setXoa(false);
                fCongThucFacade.edit(congthuc);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập Nhật Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "recipe";
            }catch(Exception ex){
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Cập Nhật", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "recipe-edit";
            }        
        }  
       
    //Delete  Recipe  
        //get id for delete
        public void getIdForDel(int rID, int fID, int vID){
            recipeID = rID;
            foodID = fID;
            vitaminID = vID;
        }
        public String deleteRecipe() {
            try{
                //Set forgein key
                FCongThuc congthuc = fCongThucFacade.find(recipeID);
                FThucAn food = fThucAnFacade.find(foodID);
                FVitamin vitamin = fVitaminFacade.find(vitaminID);
                
                congthuc.setMathucan(food);
                congthuc.setMavitamin(vitamin);
                congthuc.setXoa(true);
                fCongThucFacade.edit(congthuc);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xóa Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }catch(Exception ex){
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Xóa", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }        
            return "recipe";
        }

    public FThucAnFacadeLocal getfThucAnFacade() {
        return fThucAnFacade;
    }

    public void setfThucAnFacade(FThucAnFacadeLocal fThucAnFacade) {
        this.fThucAnFacade = fThucAnFacade;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public Integer getVitaminID() {
        return vitaminID;
    }

    public void setVitaminID(Integer vitaminID) {
        this.vitaminID = vitaminID;
    }

    public int getVitaminQuantity() {
        return vitaminQuantity;
    }

    public void setVitaminQuantity(int vitaminQuantity) {
        this.vitaminQuantity = vitaminQuantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getVitaminName() {
        return vitaminName;
    }

    public void setVitaminName(String vitaminName) {
        this.vitaminName = vitaminName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
