/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chicken;

import beanpack.GNhomGa;
import beanpack.GNhomGaFacadeLocal;
import beanpack.NThongKeGaDu;
import beanpack.NThongKeGaDuFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "chickenSurplusMB")
@SessionScoped
public class ChickenSurplusMB implements Serializable {

    @EJB
    private NThongKeGaDuFacadeLocal nThongKeGaDuFacade;


    @EJB
    private GNhomGaFacadeLocal gNhomGaFacade;
    
    private String groupID;
    private int reamainingQuantity;
    private int surplusQuantity;
    private Date sDate;
    /**
     * Creates a new instance of ChickenSsurplusMB
     */
    public ChickenSurplusMB() {
    }
    
    public void getInfoSurplus(String gID, int rNum){
        groupID = gID;
        reamainingQuantity = rNum;
    }
    
    
    public String updateSurplusChicken(){
        System.out.println("Group ID : " +groupID);
        List<NThongKeGaDu> listSurplus = nThongKeGaDuFacade.checkSurplus(groupID);
        GNhomGa nhomga = gNhomGaFacade.find(groupID);    
        //Check if surplus info does not exist -> create new / if existed -> delete / then update group.remaining quantity
        if(listSurplus.isEmpty()){
            System.out.println("Have not data!");
            try{
            //Create new surplus info
            NThongKeGaDu tkdu = new NThongKeGaDu();
            tkdu.setMaso(1);
            tkdu.setManhomga(nhomga);
            tkdu.setSogadu(reamainingQuantity);
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            tkdu.setThoigiantk(date);
            nThongKeGaDuFacade.create(tkdu);
            //Update group.remaining quantity
            nhomga.setSoluonghientai(0);
            gNhomGaFacade.edit(nhomga);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập Nhật Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }catch(Exception ex){
            ex.printStackTrace();
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Cập Nhật!)", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }
        }else{
            try{
            //Update group.remaining quantity
            int numTemp = listSurplus.get(0).getSogadu();
            nhomga.setSoluonghientai(numTemp);
            gNhomGaFacade.edit(nhomga);
            //Delete current surplus info
            nThongKeGaDuFacade.remove(listSurplus.get(0));
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập Nhật Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }catch(Exception ex){
            ex.printStackTrace();
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Hoàn Tác!)", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }            
        }
        return "chicken-group";
    }
    
    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public int getReamainingQuantity() {
        return reamainingQuantity;
    }

    public void setReamainingQuantity(int reamainingQuantity) {
        this.reamainingQuantity = reamainingQuantity;
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public int getSurplusQuantity() {
        return surplusQuantity;
    }

    public void setSurplusQuantity(int surplusQuantity) {
        this.surplusQuantity = surplusQuantity;
    }
    
}
