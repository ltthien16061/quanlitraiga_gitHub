/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import beanpack.NCaiDat;
import beanpack.NCaiDatFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Cungbonvotang
 */
@Named(value = "settingMB")
@SessionScoped
public class SettingMB extends CustomValidator implements Serializable {

    @EJB
    private NCaiDatFacadeLocal nCaiDatFacade;
    private NCaiDat setting = new NCaiDat();

    public SettingMB() {
    }

    @PostConstruct
    public void init() {
        setting = nCaiDatFacade.find(1);
    }

    public void editSetting() {
        try {
            nCaiDatFacade.edit(setting);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cập Nhật Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Có Lỗi Xảy ra", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
        }
    }

    public NCaiDat getSetting() {
        return setting;
    }

    public void setSetting(NCaiDat setting) {
        this.setting = setting;
    }
}