/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import beanpack.FLoaiThucAn;
import beanpack.FLoaiThucAnFacadeLocal;
import beanpack.FThucAn;
import beanpack.FThucAnFacadeLocal;
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
@Named(value = "foodMB")
@SessionScoped
public class FoodMB extends CustomValidator implements Serializable {

    @EJB
    private FThucAnFacadeLocal fThucAnFacade;

    @EJB
    private FLoaiThucAnFacadeLocal fLoaiThucAnFacade;
    
    private int maso;
    private int maLoai;
    private String ten;
    private int gia;
    private Date ngaymua;
    private Date thoigianmuatam;
    private Date thoigiancapnhat;
    
    /**
     * Creates a new instance of FoodMB
     */
    public FoodMB() {
    }
    
    //show all
    public List<Object[]> showAllFood() {
        List<Object[]> foodList = new ArrayList<Object[]>();
        foodList = fThucAnFacade.showFoodByDel();
        return foodList;
    }
    
    //Add        
        //show all supplier for add
        public List<FLoaiThucAn> showAllFoodKind() {
            List<FLoaiThucAn> kindList = new ArrayList<FLoaiThucAn>();
            kindList = fLoaiThucAnFacade.showKindForAddFood();
            return kindList;
        }        
        //get id for add
        public void getIdForAdd(int kindID){
            maLoai = kindID;
        }
        public String addFood() {
            try{
                FThucAn food = new FThucAn();
                FLoaiThucAn foodkind = fLoaiThucAnFacade.find(maLoai);
                food.setMaloai(foodkind);
                food.setTen(ten);
                food.setGia(gia);                
                if(ngaymua == null){  
                    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                    ngaymua = date;
                    food.setNgaymua(ngaymua);      
                }else{    
                    food.setNgaymua(ngaymua);      
                }      
                food.setXoa(false);
                fThucAnFacade.create(food);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "food";
                }catch(Exception ex){
                ex.printStackTrace();
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm (Có thể tên đã tồn tại)!", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "food-add";
            }
        }
    //edit
        //Find the row to edit
        public String editFood(int fID) {
            maso = fID;
            maLoai = fThucAnFacade.find(maso).getMaloai().getMaso();
            ten = fThucAnFacade.find(maso).getTen();
            gia = fThucAnFacade.find(maso).getGia();
            ngaymua = fThucAnFacade.find(maso).getNgaymua(); 
            thoigianmuatam = ngaymua;
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            thoigiancapnhat = date;     
            return  "food-edit";
        }
        //Edit it
        public String editFood() {
            try{
               //Set forgein key
                FThucAn food = fThucAnFacade.find(maso);
                FLoaiThucAn foodkind = fLoaiThucAnFacade.find(maLoai);
                food.setMaloai(foodkind);
                food.setTen(ten);
                food.setGia(gia);                 
                if(ngaymua==null){
                  food.setNgaymua(thoigianmuatam);  
                }else{
                  food.setNgaymua(ngaymua);
                }  
                food.setThoigiancapnhat(thoigiancapnhat);
                food.setXoa(false);
                fThucAnFacade.edit(food);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập Nhật Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "food";
            }catch(Exception ex){
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Cập Nhật (Có thể tên đã tồn tại)", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "food-edit";
            }        
        }    
       
       
    //Delete    
        //get id for delete
        public void getIdForDel(int foodID, int kindID){
            maso = foodID;
            maLoai = kindID;
        }
        public String deleteFood() {
            try{
                boolean xoa = true;
                //Set forgein key
                FThucAn food = fThucAnFacade.find(maso);
                FLoaiThucAn kindfood = fLoaiThucAnFacade.find(maLoai);
                food.setMaloai(kindfood);
                food.setXoa(xoa);
                fThucAnFacade.edit(food);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xóa Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }catch(Exception ex){
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Xóa", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }        
            return "food";
        }

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
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

    public Date getThoigiancapnhat() {
        return thoigiancapnhat;
    }

    public void setThoigiancapnhat(Date thoigiancapnhat) {
        this.thoigiancapnhat = thoigiancapnhat;
    }
}
