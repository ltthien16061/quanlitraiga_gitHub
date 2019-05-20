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
import org.primefaces.event.SelectEvent;
import other.CustomValidator;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "feedMB")
@SessionScoped
public class FeedMB extends CustomValidator implements Serializable {

    @EJB
    private FCongThucFacadeLocal fCongThucFacade;

    @EJB
    private GNhomGaFacadeLocal gNhomGaFacade;

    @EJB
    private FThoiGianChoAnFacadeLocal fThoiGianChoAnFacade;
    
    private int feedID;
    private String groupID;
    private int recipeID;
    private Date feedDate;
    private int quantity;
    /**
     * Creates a new instance of FeedMB
     */
    public FeedMB() {
    }
    
    //Show all by foodID
    public String putGroupIDShowFeed(String gID) {
        groupID = gID;
        return "chicken-feed";
    }  
    public List<Object[]> showFeedscheduleByGroup() {
        List<Object[]> feedList = new ArrayList<Object[]>();
        feedList = fThoiGianChoAnFacade.showAllByGroup(groupID);
        return feedList;
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
        public void handleDateSelect(SelectEvent event) {       
            System.out.println("Input Date : " + feedDate);
            java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(feedDate.getTime());
            System.out.println("Converted Date: " + sqlTimeStamp);
        }
        //Add FeedSchedule
        public String addFeedByGroup(){   
            try{
            FThoiGianChoAn fschedule = new FThoiGianChoAn();
            GNhomGa group = gNhomGaFacade.find(groupID);      
            FCongThuc recipe = fCongThucFacade.find(recipeID);

            java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(feedDate.getTime());
            fschedule.setThoidiem(sqlTimeStamp);

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
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm (Kiểm tra lại ngày nhập - không được quá hôm nay!)", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "/food/feed-addgroup";
            } 
        }
        
    //Edit
        //get id for edit
        public String getIdForEdit(int fID){
            feedID = fID;
            return "/food/feed-editgroup";
        }
        public String editGroupFeed() {
            try{
                FThoiGianChoAn feed = fThoiGianChoAnFacade.find(feedID);
                //Time
                java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(feedDate.getTime());
                feed.setThoidiem(sqlTimeStamp);
                //Group ID
                groupID = fThoiGianChoAnFacade.find(feedID).getManhom().getManhom();
                GNhomGa group = gNhomGaFacade.find(groupID);
                feed.setManhom(group);
                //Recipe ID
                recipeID = fThoiGianChoAnFacade.find(feedID).getMacongthuc().getMaso();
                FCongThuc recipe = fCongThucFacade.find(recipeID);
                feed.setMacongthuc(recipe);
                //Quantity
                feed.setKhauphan(quantity);
                //Update time
                java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                feed.setThoigiancapnhat(date);
                feed.setXoa(false);
                fThoiGianChoAnFacade.edit(feed);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập Nhật Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }catch(Exception ex){
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Cập Nhật", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }
            return  "/chicken/chicken-feed";
        }
    
    //Delete
        //get id for delete
        public void getIdForDel(int fID){
            feedID = fID;
        }
        public String deleteFeed() {
            try{
                FThoiGianChoAn feed = fThoiGianChoAnFacade.find(feedID);
                feed.setXoa(true);
                fThoiGianChoAnFacade.edit(feed);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xóa Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }catch(Exception ex){
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Xóa", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }
            return  "/chicken/chicken-feed";
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

    public Date getFeedDate() {
        return feedDate;
    }

    public void setFeedDate(Date feedDate) {
        this.feedDate = feedDate;
    }

    public int getFeedID() {
        return feedID;
    }

    public void setFeedID(int feedID) {
        this.feedID = feedID;
    }
}
