/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbpack;

import beanpack.GDotNhapGaGiong;
import beanpack.GDotNhapGaGiongFacadeLocal;
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
@Named(value = "chickenImportMB")
@SessionScoped
public class ChickenImportMB extends CustomValidator implements Serializable {
    
    //For chickenInport
    @EJB
    private GDotNhapGaGiongFacadeLocal gDotNhapGaGiongFacade;
    
    @EJB
    private GNhaCungCapFacadeLocal gNhaCungCapFacade;
    
    private int maso;
    private int macc; 
    private String ten; //Supplier's Name 
    private int tuoi;
    private int soluong;    
    private int conlai;
    private Date thoigiannhap;
    private Date thoigiannhaptam; //use when user delete info form thoigiannhap in EditMethod
    private Date thoigiancapnhat;
    private boolean xoa;
    
    /**
     * Creates a new instance of ChickenImport2
     */
    public ChickenImportMB() {
    }
    //show all
    public List<Object[]> showAllChickenImport() {
        List<Object[]> listChickenSupplier = new ArrayList<Object[]>();
        listChickenSupplier = gDotNhapGaGiongFacade.showChickenImportByDel();
        return listChickenSupplier;
    }
    //show all
    public List<GNhaCungCap> showAllChickenSupplier() {
        List<GNhaCungCap> listChickenSupplier = new ArrayList<GNhaCungCap>();
        listChickenSupplier = gNhaCungCapFacade.showAllwithNotDel();
        return listChickenSupplier;
    }

    //Delete
        //get id for delete
        public void getIdForDel(int id, int supID){
            maso = id;
            macc = supID;
        }
        
    //Add
        //get id for add
        public void getIdForAdd(int supID){
            macc = supID;
        }
        public String add() {
            try{
                GDotNhapGaGiong dotnhap = new GDotNhapGaGiong();

                GNhaCungCap nhacungcap = gNhaCungCapFacade.find(macc);             
                dotnhap.setMasocc(nhacungcap);

                dotnhap.setDotuoi(tuoi);
                dotnhap.setSoluongnhap(soluong);            
                dotnhap.setSoluongconlai(soluong);
                if(thoigiannhap == null){  
                    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                    thoigiannhap = date;
                    dotnhap.setThoigiannhap(thoigiannhap);        
                }else{          
                    dotnhap.setThoigiannhap(thoigiannhap);
                }      
                dotnhap.setXoa(false);
                gDotNhapGaGiongFacade.create(dotnhap);
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "chicken-import";
                }catch(Exception ex){
                ex.printStackTrace();
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm !", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
                return "chicken-addimport";
            }
        }
      //edit
      //Find the row to edit
    public String edit(int idCKImport) {
        maso = idCKImport;
        tuoi = gDotNhapGaGiongFacade.find(maso).getDotuoi();
        soluong = gDotNhapGaGiongFacade.find(maso).getSoluongnhap();
        conlai = gDotNhapGaGiongFacade.find(maso).getSoluongconlai();
        thoigiannhap = gDotNhapGaGiongFacade.find(maso).getThoigiannhap();
        thoigiannhaptam = thoigiannhap;
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        thoigiancapnhat = date;     
        xoa = false;
        return  "chicken-editimport";
    }
        //Edit it
    public String edit() {
        try{
           //Set forgein key
            GDotNhapGaGiong dotnhap = gDotNhapGaGiongFacade.find(maso);
            GNhaCungCap nhacungcap = gNhaCungCapFacade.find(macc);            
            dotnhap.setMasocc(nhacungcap);
            
            dotnhap.setDotuoi(tuoi);
            dotnhap.setSoluongnhap(soluong);
            dotnhap.setSoluongconlai(conlai); 
            if(thoigiannhap==null){
              dotnhap.setThoigiannhap(thoigiannhaptam);  
            }else{
              dotnhap.setThoigiannhap(thoigiannhap);  
            }               
            dotnhap.setThoigiancapnhat(thoigiancapnhat);
            dotnhap.setXoa(xoa);
            gDotNhapGaGiongFacade.edit(dotnhap);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập Nhật Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }catch(Exception ex){
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Cập Nhật", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }        
        return "chicken-import";
    }    
       
    //delete   
    public String delete() {
        try{
            tuoi = gDotNhapGaGiongFacade.find(maso).getDotuoi();
            soluong = gDotNhapGaGiongFacade.find(maso).getSoluongnhap();
            conlai = gDotNhapGaGiongFacade.find(maso).getSoluongconlai();
            thoigiannhap = gDotNhapGaGiongFacade.find(maso).getThoigiannhap();
            thoigiancapnhat = gDotNhapGaGiongFacade.find(maso).getThoigiancapnhat();
            xoa = true;
            //Set forgein key
            GDotNhapGaGiong dotnhap = gDotNhapGaGiongFacade.find(maso);
            GNhaCungCap nhacungcap = gNhaCungCapFacade.find(macc);            
            dotnhap.setMasocc(nhacungcap);
            
            dotnhap.setDotuoi(tuoi);
            dotnhap.setSoluongnhap(soluong);
            dotnhap.setSoluongconlai(conlai);
            dotnhap.setThoigiannhap(thoigiannhap);
            dotnhap.setThoigiancapnhat(thoigiancapnhat);
            dotnhap.setXoa(xoa);
            gDotNhapGaGiongFacade.edit(dotnhap);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xóa Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }catch(Exception ex){
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Xóa", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }        
        return "chicken-import";
    }
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public int getMacc() {
        return macc;
    }

    public void setMacc(int macc) {
        this.macc = macc;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getConlai() {
        return conlai;
    }

    public void setConlai(int conlai) {
        this.conlai = conlai;
    }

    public Date getThoigiannhap() {
        return thoigiannhap;
    }

    public void setThoigiannhap(Date thoigiannhap) {
        this.thoigiannhap = thoigiannhap;
    }

    public Date getThoigiannhaptam() {
        return thoigiannhaptam;
    }

    public void setThoigiannhaptam(Date thoigiannhaptam) {
        this.thoigiannhaptam = thoigiannhaptam;
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
