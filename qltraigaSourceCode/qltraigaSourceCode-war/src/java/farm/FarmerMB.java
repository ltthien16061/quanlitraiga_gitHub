/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm;

import beanpack.HNongHoGa;
import beanpack.HNongHoGaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Cungbonvotang
 */
@Named(value = "farmerMB")
@SessionScoped
public class FarmerMB implements Serializable {

    @EJB
    private HNongHoGaFacadeLocal hNongHoGaFacade;

    private HNongHoGa selectedFarmer = new HNongHoGa();
    
    public FarmerMB() {
    }
    
    public List<HNongHoGa> showAllIncubatorTray() {
        List<HNongHoGa> listTray = hNongHoGaFacade.findAllFarmerWithNotDel();
        return listTray;
    }
    
    public String selectFarmer(HNongHoGa farmer, String page) {
        selectedFarmer = farmer;
        return page;
    }

    public String addFarmer() {
        try {
            
            Date now = new Date();
            selectedFarmer.setThoigiancapnhat(now);
            hNongHoGaFacade.create(selectedFarmer);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "farmer";
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm (Có thể [Mã Cung Cấp] đã tồn tại!)", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "farmer-add";
        }
    }

    public String editFarmer() {
        try {
            Date now = new Date();
            selectedFarmer.setThoigiancapnhat(now);
            hNongHoGaFacade.edit(selectedFarmer);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập Nhật Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "farmer";
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Có Lỗi Xảy ra", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "farmer-edit";
        }
    }

    public void deleteFarmer() {
        try {
            selectedFarmer.setXoa(true);
            hNongHoGaFacade.edit(selectedFarmer);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xóa Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Có Lỗi Xảy Ra", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }
    }

    public HNongHoGa getSelectedFarmer() {
        return selectedFarmer;
    }

    public void setSelectedFarmer(HNongHoGa selectedFarmer) {
        this.selectedFarmer = selectedFarmer;
    }
    
}
