/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import beanpack.FLoaiThucAn;
import beanpack.FLoaiThucAnFacadeLocal;
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
@Named(value = "foodKindMB")
@SessionScoped
public class FoodKindMB extends CustomValidator implements Serializable {

    @EJB
    private FLoaiThucAnFacadeLocal fLoaiThucAnFacade;
    private int maso;
    private String tenloai;
    private String tenmoi;
    private Date thoigiancapnhat;
    private boolean xoa;
    
    /**
     * Creates a new instance of FoodKindMB
     */
    
    public FoodKindMB() {
    }
    
    //show all KindOfFood
    public List<Object[]> showAllKindOfFood() {
        List<Object[]> listKindOfFood = new ArrayList<Object[]>();
        listKindOfFood = fLoaiThucAnFacade.showAllwithNotDel();
        return listKindOfFood;
    }
     //Add
    public String addAllKindOfFood() {
        try{
            FLoaiThucAn loaithucan = new FLoaiThucAn();
            loaithucan.setTenloai(tenloai);
            loaithucan.setXoa(false);
            fLoaiThucAnFacade.create(loaithucan);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "food-kind";
            }catch(Exception ex){
            ex.printStackTrace();
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm (Có thể loại thức ăn này đã tồn tại!)", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "food-addkind";
        }
    }
    
    //Edit
        //get id for Edit
        public void getIdForEdit(int idKind){
            maso = idKind;
        }
        public String editKindOfFood() {
        try{
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            thoigiancapnhat = date;
            FLoaiThucAn loaithucan = fLoaiThucAnFacade.find(maso);
            loaithucan.setTenloai(tenmoi);
            loaithucan.setThoigiancapnhat(thoigiancapnhat);
            fLoaiThucAnFacade.edit(loaithucan);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập Nhật Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }catch(Exception ex){
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Cập Nhật (Có Thể Tên Loại Đã Được Sử Dụng!)", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }
        return  "food-kind";
    }
    //Delete
        //get id for delete
        public void getIdForDel(int idKind){
            maso = idKind;
        }
        public String deleteKindOfFood() {
        try{
            xoa = true;
            FLoaiThucAn loaithucan = fLoaiThucAnFacade.find(maso);
            loaithucan.setXoa(xoa);
            fLoaiThucAnFacade.edit(loaithucan);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xóa Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }catch(Exception ex){
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Xóa", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }
        return  "food-kind";
    }
    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public boolean isXoa() {
        return xoa;
    }

    public Date getThoigiancapnhat() {
        return thoigiancapnhat;
    }

    public void setThoigiancapnhat(Date thoigiancapnhat) {
        this.thoigiancapnhat = thoigiancapnhat;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
    }

    public String getTenmoi() {
        return tenmoi;
    }

    public void setTenmoi(String tenmoi) {
        this.tenmoi = tenmoi;
    }
    
}
