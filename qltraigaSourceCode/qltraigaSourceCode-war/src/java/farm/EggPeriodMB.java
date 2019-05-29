/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm;

import beanpack.GDanGhep;
import beanpack.HDotTrung;
import beanpack.HDotTrungFacadeLocal;
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
import other.CustomValidator;

/**
 *
 * @author Cungbonvotang
 */
@Named(value = "eggPeriodMB")
@SessionScoped
public class EggPeriodMB extends CustomValidator implements Serializable {

    @EJB
    private HNongHoGaFacadeLocal hNongHoGaFacade;

    @EJB
    private HDotTrungFacadeLocal hDotTrungFacade;

    private HDotTrung selectedEggPeriod = new HDotTrung();
    private String manongho;

    public EggPeriodMB() {
    }

    public List<HDotTrung> showAllEggPeriod() {
        List<HDotTrung> listEggPeriod = hDotTrungFacade.findAllEggPeriodWithNotDel();
        return listEggPeriod;
    }
    
    public List<GDanGhep> showAllSuitableFarmer() {
        List<GDanGhep> listFarmer = hDotTrungFacade.findAllSuitableFarmer();
        return listFarmer;
    }

    public String selectEggPeriod(HDotTrung eggPeriod, String page) {
        selectedEggPeriod = eggPeriod;
        return page;
    }
    
    public String addEggPeriod(){
        try {
            Date now = new Date();
            selectedEggPeriod.setManongho(hNongHoGaFacade.find(manongho));
            selectedEggPeriod.setThoidiemthuhoach(now);
            hDotTrungFacade.create(selectedEggPeriod);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "eggPeriod";
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm!", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "eggPeriod-add";
        }
    }

    public String editEggPeriod() {
        try {
            Date now = new Date();
            selectedEggPeriod.setManongho(hNongHoGaFacade.find(manongho));
            selectedEggPeriod.setThoigiancapnhat(now);
            hDotTrungFacade.edit(selectedEggPeriod);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "eggPeriod";
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm!", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "eggPeriod-edit";
        }
    }
    
    public String deleteEggPeriod(){
        try {
            selectedEggPeriod.setXoa(true);
            hDotTrungFacade.edit(selectedEggPeriod);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "eggPeriod";
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm!", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "eggPeriod";
        }
    }

    public HDotTrung getSelectedEggPeriod() {
        return selectedEggPeriod;
    }

    public void setSelectedEggPeriod(HDotTrung selectedEggPeriod) {
        this.selectedEggPeriod = selectedEggPeriod;
    }

    public String getManongho() {
        return manongho;
    }

    public void setManongho(String manongho) {
        this.manongho = manongho;
    }

}
