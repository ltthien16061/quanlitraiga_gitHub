/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chicken;

import beanpack.GNhaCungCap;
import beanpack.GNhaCungCapFacadeLocal;
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
@Named(value = "chickenSupplierMB")
@SessionScoped
public class ChickenSupplierMB extends CustomValidator implements Serializable {

    @EJB
    private GNhaCungCapFacadeLocal gNhaCungCapFacade;
    
    private int maso;
    private String macc;
    private String ten;
    private String diachi;
    private Date thoigiancapnhat;
    private boolean xoa;
    /**
     * Creates a new instance of ChickenSupplierMB
     */
    public ChickenSupplierMB() {
    }
    
    //show all
    public List<GNhaCungCap> showAllChickenSupplier() {
        List<GNhaCungCap> listChickenSupplier = new ArrayList<GNhaCungCap>();
        listChickenSupplier = gNhaCungCapFacade.showAllwithNotDel();
        return listChickenSupplier;
    }
    //Add
    public String addChickenSupplier() {
        try{
            GNhaCungCap nhacungcap = new GNhaCungCap();
            nhacungcap.setMacc(macc);
            nhacungcap.setTen(ten);
            nhacungcap.setDiachi(diachi);       
            nhacungcap.setXoa(false);
            gNhaCungCapFacade.create(nhacungcap);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "chicken-supplier";
            }catch(Exception ex){
            ex.printStackTrace();
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm (Có thể [Mã Cung Cấp] đã tồn tại!)", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "chicken-addsupplier";
        }
    }
    //edit
      //Find the row to edit
    public String editChickenSupplier(int idSupplier) {
        maso = idSupplier;
        macc = gNhaCungCapFacade.find(idSupplier).getMacc();
        ten = gNhaCungCapFacade.find(idSupplier).getTen();
        diachi = gNhaCungCapFacade.find(idSupplier).getDiachi();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        thoigiancapnhat = date;
        xoa = gNhaCungCapFacade.find(maso).getXoa();
        return  "chicken-editsupplier";
    }
    //Edit it
    public String editChickenSupplier() {
        try{
            GNhaCungCap nhacungcap = gNhaCungCapFacade.find(maso);
            nhacungcap.setMacc(macc);
            nhacungcap.setTen(ten);
            nhacungcap.setDiachi(diachi);             
            nhacungcap.setXoa(false);
            gNhaCungCapFacade.edit(nhacungcap);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập Nhật Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return  "chicken-supplier";
        }catch(Exception ex){
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Có Lỗi Xảy ra", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return  "chicken-editsupplier";
        }
    }
    //Delete
        //get id for delete
        public void getIdFormView(int idSupplier){
            maso = idSupplier;
        }
        public String deleteChickenSupplier() {
        try{
            xoa = true;
            
            GNhaCungCap nhacungcap = gNhaCungCapFacade.find(maso);
            nhacungcap.setXoa(xoa);
            gNhaCungCapFacade.edit(nhacungcap);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xóa Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }catch(Exception ex){
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Xóa", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }
        return  "chicken-supplier";
    }
    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public String getMacc() {
        return macc;
    }

    public void setMacc(String macc) {
        this.macc = macc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Date getThoigiancapnhat() {
        return thoigiancapnhat;
    }

    public void setThoigiancapnhat(Date thoigiancapnhat) {
        this.thoigiancapnhat = thoigiancapnhat;
    }

    public boolean isXoa() {
        return xoa;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
    }
    
}
