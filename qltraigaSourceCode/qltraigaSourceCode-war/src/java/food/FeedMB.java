/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import beanpack.FCongThuc;
import beanpack.FCongThucFacadeLocal;
import beanpack.FThoiGianChoAn;
import beanpack.FThoiGianChoAnFacadeLocal;
import beanpack.GNhomGa;
import beanpack.GNhomGaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "feedMB")
@SessionScoped
public class FeedMB implements Serializable {

    @EJB
    private FCongThucFacadeLocal fCongThucFacade;

    @EJB
    private GNhomGaFacadeLocal gNhomGaFacade;

    @EJB
    private FThoiGianChoAnFacadeLocal fThoiGianChoAnFacade;
    
    private String groupID;
    private int quantity;
    private int recipeID;

    List<Object[]> feedList = new ArrayList<Object[]>();  
    /**
     * Creates a new instance of FeedMB
     */
    public FeedMB() {
    }
    
    //Show all by foodID
    public String showFeedscheduleByGroup(String gID) {
        groupID = gID;
        feedList = fThoiGianChoAnFacade.showAllByGroup(gID);
        return "chicken-feed";
    }  
     //Show all food Schedule
    public List<FThoiGianChoAn> showAllFeedschedule() {
        List<FThoiGianChoAn> listFeedSchedule = new ArrayList<FThoiGianChoAn>();
        listFeedSchedule = fThoiGianChoAnFacade.showAllByDel();
        return listFeedSchedule;
    }  
    //Add feed schedule by group
        //get recipe ID
        public void getRecipeFormGroup(int rID){
            recipeID = rID;
        }
        //Add FeedSchedule
        public String addFeedByGroup(){
             try{
                FThoiGianChoAn fschedule = new FThoiGianChoAn();
                GNhomGa group = gNhomGaFacade.find(groupID);      
                FCongThuc recipe = fCongThucFacade.find(recipeID);
                Date date = new Date();
                fschedule.setThoidiem(date);
                fschedule.setManhom(group);
                fschedule.setMacongthuc(recipe);
                fschedule.setKhauphan(quantity);
                fschedule.setXoa(false);
                fThoiGianChoAnFacade.create(fschedule);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "/chicken/chicken-group";
                }catch(Exception ex){
                ex.printStackTrace();
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm !", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "/food/feed-addgroup";
            }
        }
    public List<Object[]> getFeedList() {
        return feedList;
    }

    public void setFeedList(List<Object[]> feedList) {
        this.feedList = feedList;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }
}
