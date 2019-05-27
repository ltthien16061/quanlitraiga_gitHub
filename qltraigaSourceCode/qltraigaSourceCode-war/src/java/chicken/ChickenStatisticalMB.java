/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chicken;

import beanpack.GNhomGa;
import beanpack.GNhomGaFacadeLocal;
import beanpack.GThongKeNhomGa;
import beanpack.GThongKeNhomGaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import other.CustomValidator;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "chickenStatisticalMB")
@SessionScoped
public class ChickenStatisticalMB extends CustomValidator implements Serializable {

    @EJB
    private GThongKeNhomGaFacadeLocal gThongKeNhomGaFacade;

    @EJB
    private GNhomGaFacadeLocal gNhomGaFacade;
    
    private String groupID;
    private int deadQuantity;
    /**
     * Creates a new instance of ChickenStatistical2MB
     */
    public ChickenStatisticalMB() {
    }
    
    public String getGroupIDForShow(String gID){        
        this.groupID = gID;
        return "chicken-statistical";
    }
    
    public List<GThongKeNhomGa> showGroupStatistical(){
        List<GThongKeNhomGa> listStatistical = new ArrayList<GThongKeNhomGa>();
        listStatistical = gThongKeNhomGaFacade.showStatisticalByGroup(groupID);
        return listStatistical;
    }
    //Add statistical
    public String addGroupSttistical() {
            try{
                GThongKeNhomGa thongke = new GThongKeNhomGa();
                GNhomGa nhomga = gNhomGaFacade.find(groupID);
                //get current time for primaryKey
                java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                thongke.setThoidiemtk(date);
                thongke.setManhomga(nhomga);
                thongke.setSoluonggachet(deadQuantity); 
                //get group remaining number
                int remainingCK = nhomga.getSoluonghientai();
                //check dead quantity
                if(deadQuantity > remainingCK){
                    FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Số Lượng Gà Chết Không Được Nhiều Hơn Số Lượng Gà Hiện Tại !", null);
                    FacesContext.getCurrentInstance().addMessage(null, fMsg);
                    return "chicken-statistical";
                }
                thongke.setSoluongconlai(remainingCK-deadQuantity);
                gThongKeNhomGaFacade.create(thongke);
                //update remaining chicken
                nhomga.setSoluonghientai(remainingCK-deadQuantity);
                gNhomGaFacade.edit(nhomga);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                }catch(Exception ex){
                ex.printStackTrace();
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm !", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }
            return "chicken-statistical";
        }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public int getDeadQuantity() {
        return deadQuantity;
    }

    public void setDeadQuantity(int deadQuantity) {
        this.deadQuantity = deadQuantity;
    }
    
}
