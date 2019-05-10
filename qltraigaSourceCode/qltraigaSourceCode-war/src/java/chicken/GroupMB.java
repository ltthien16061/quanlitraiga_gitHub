/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chicken;

import beanpack.GDotNhapGaGiong;
import beanpack.GDotNhapGaGiongFacadeLocal;
import beanpack.GNhomGa;
import beanpack.GNhomGaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "groupMB")
@SessionScoped
public class GroupMB extends CustomValidator implements Serializable {
    
    @EJB
    private GNhomGaFacadeLocal gNhomGaFacade;

    @EJB
    private GDotNhapGaGiongFacadeLocal gDotNhapGaGiongFacade;
    
    //Parameter for table GNhomGa
    private String groupID;
    private int importID;
    private int num1;
    private int num2;
    private boolean status;
    private Date divideDate;
    private Date update;
    private boolean xoa;

    /**
     * Creates a new instance of GroupMB
     */
    public GroupMB() {
    }
    
      //show all
    public List<Object[]> showAllGroup() {
        List<Object[]> listGroup = new ArrayList<Object[]>();
        listGroup = gNhomGaFacade.showAllGroup();
        return listGroup;
    }
    //Delete    
        //get id for delete
        public void getIdForDel(String id, int ipID){
            groupID = id;
            importID = ipID;
        }
        public String deleteGroup() {
            try{
                num1 = gNhomGaFacade.find(groupID).getSoluongbandau();
                num2 = gNhomGaFacade.find(groupID).getSoluonghientai();
                status = gNhomGaFacade.find(groupID).getTinhtrang();
                divideDate = gNhomGaFacade.find(groupID).getThoigianchianhom();
                update = gNhomGaFacade.find(groupID).getThoigiancapnhat();
                xoa = true;
                //Set forgein key
                GDotNhapGaGiong dotnhap = gDotNhapGaGiongFacade.find(importID);
                GNhomGa nhomga = gNhomGaFacade.find(groupID);
                nhomga.setMadotnhap(dotnhap);
                nhomga.setSoluongbandau(num1);
                nhomga.setSoluonghientai(num2);
                nhomga.setTinhtrang(status);
                nhomga.setThoigianchianhom(divideDate);
                nhomga.setThoigiancapnhat(update);
                nhomga.setXoa(xoa);
                gNhomGaFacade.edit(nhomga);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xóa Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }catch(Exception ex){
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Xóa", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }        
            return "chicken-group";
        }
    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public int getImportID() {
        return importID;
    }

    public void setImportID(int importID) {
        this.importID = importID;
    }
    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDivideDate() {
        return divideDate;
    }

    public void setDivideDate(Date divideDate) {
        this.divideDate = divideDate;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public boolean isXoa() {
        return xoa;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
    }

}
