/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm;

import beanpack.HKhayAp;
import beanpack.HKhayApFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import other.CustomValidator;

/**
 *
 * @author Cungbonvotang
 */
@Named(value = "incubatorTrayMB")
@SessionScoped
public class IncubatorTrayMB extends CustomValidator implements Serializable {

    @EJB
    private HKhayApFacadeLocal hKhayApFacade;

    private HKhayAp selectedTray = new HKhayAp();

    public IncubatorTrayMB() {
    }
    
    public List<HKhayAp> showAllIncubatorTray() {
        List<HKhayAp> listTray = hKhayApFacade.findAllTrayWithNotDel();
        return listTray;
    }
    
    public String selectTray(HKhayAp tray, String page) {
        selectedTray = tray;
        return page;
    }

    public String addIncubatorTray() {
        try {
            Date now = new Date();
            selectedTray.setThoigiancapnhat(now);
            hKhayApFacade.create(selectedTray);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "incubatorTray";
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm (Có thể [Mã Cung Cấp] đã tồn tại!)", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "incubatorTray-add";
        }
    }

    public String editIncubatorTray() {
        try {
            Date now = new Date();
            selectedTray.setThoigiancapnhat(now);
            hKhayApFacade.edit(selectedTray);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập Nhật Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "incubatorTray";
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Có Lỗi Xảy ra", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "incubatorTray-edit";
        }
    }

    public void deleteIncubatorTray() {
        try {
            selectedTray.setXoa(true);
            hKhayApFacade.edit(selectedTray);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Xóa Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Có Lỗi Xảy Ra", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }
    }

    public HKhayAp getSelectedTray() {
        return selectedTray;
    }

    public void setSelectedTray(HKhayAp selectedTray) {
        this.selectedTray = selectedTray;
    }
}