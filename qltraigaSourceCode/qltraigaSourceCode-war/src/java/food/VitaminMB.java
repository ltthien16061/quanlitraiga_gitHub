/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import beanpack.FVitamin;
import beanpack.FVitaminFacadeLocal;
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
import other.CustomValidator;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "vitaminMB")
@SessionScoped
public class VitaminMB extends CustomValidator implements Serializable {

    @EJB
    private FVitaminFacadeLocal fVitaminFacade;
    
    private int maso;
    private String ten;
    private int gia;
    private Date ngaymua;
    private int ngaymuatamthoi;
    private Date thoigiancapnhat;
    /**
     * Creates a new instance of VitaminMB
     */
    public VitaminMB() {
    }
    
    
    //show all
    public List<FVitamin> showAllVitamin() {
        List<FVitamin> vitaminList = new ArrayList<FVitamin>();
        vitaminList = fVitaminFacade.showAllwithNotDel();
        return vitaminList;
    }
    
    //Add
    public String addVitamin() {
        try{
            FVitamin vitamin = new FVitamin();
            vitamin.setTen(ten);
            vitamin.setGia(gia);
            if(ngaymua == null){  
                   java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                   ngaymua = date;
                   vitamin.setNgaymua(ngaymua);      
            }else{          
                vitamin.setNgaymua(ngaymua);
            } 
            vitamin.setXoa(false);
            fVitaminFacade.create(vitamin);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "vitamin";
            }catch(Exception ex){
            ex.printStackTrace();
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm (Có thể tên Vitamin này đã tồn tại!)", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "vitamin-add";
        }
    }
    
    //edit
      //Find the row to edit
    public String editVitamin(int vID) {
        maso = vID;
        ten = fVitaminFacade.find(vID).getTen();
        gia = fVitaminFacade.find(vID).getGia();
        ngaymua = fVitaminFacade.find(vID).getNgaymua();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        thoigiancapnhat = date;
        return  "vitamin-edit";
    }
    //Edit it
    public String editVitamin() {
        try{
            FVitamin vitamin = fVitaminFacade.find(maso);
            vitamin.setTen(ten);
            vitamin.setGia(gia);
             if(ngaymua == null){  
                   java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                   ngaymua = date;
                   vitamin.setNgaymua(ngaymua);      
            }else{          
                vitamin.setNgaymua(ngaymua);
            } 
            vitamin.setThoigiancapnhat(thoigiancapnhat);
            vitamin.setXoa(false);
            fVitaminFacade.edit(vitamin);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập Nhật Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return  "vitamin";
        }catch(Exception ex){
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Có Lỗi Xảy ra", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return  "vitamin-edit";
        }
    }
    //Delete
        //get id for delete
        public void getIdFormView(int vID){
            maso = vID;
        }
        public String deleteVitamin() {
        try{
            FVitamin vitamin = fVitaminFacade.find(maso);
            vitamin.setXoa(true);
            fVitaminFacade.edit(vitamin);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xóa Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }catch(Exception ex){
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Xóa", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }
        return  "vitamin";
    }
    
    
    public FVitaminFacadeLocal getfVitaminFacade() {
        return fVitaminFacade;
    }

    public void setfVitaminFacade(FVitaminFacadeLocal fVitaminFacade) {
        this.fVitaminFacade = fVitaminFacade;
    }

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public Date getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(Date ngaymua) {
        this.ngaymua = ngaymua;
    }

    public int getNgaymuatamthoi() {
        return ngaymuatamthoi;
    }

    public void setNgaymuatamthoi(int ngaymuatamthoi) {
        this.ngaymuatamthoi = ngaymuatamthoi;
    }

    public Date getThoigiancapnhat() {
        return thoigiancapnhat;
    }

    public void setThoigiancapnhat(Date thoigiancapnhat) {
        this.thoigiancapnhat = thoigiancapnhat;
    }
    
}
