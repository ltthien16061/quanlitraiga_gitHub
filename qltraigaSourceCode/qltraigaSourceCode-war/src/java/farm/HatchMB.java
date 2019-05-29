/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm;

import beanpack.HDotTrung;
import beanpack.HDotTrungFacadeLocal;
import beanpack.HKhayAp;
import beanpack.HKhayApDotTrung;
import beanpack.HKhayApDotTrungFacadeLocal;
import beanpack.HKhayApDotTrungPK;
import beanpack.HKhayApFacadeLocal;
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
@Named(value = "hatchMB")
@SessionScoped
public class HatchMB extends CustomValidator implements Serializable {

    @EJB
    private HKhayApFacadeLocal hKhayApFacade;

    @EJB
    private HDotTrungFacadeLocal hDotTrungFacade;

    @EJB
    private HKhayApDotTrungFacadeLocal hKhayApDotTrungFacade;

    private HKhayApDotTrung selectedHatch = new HKhayApDotTrung();
    private HKhayAp selectedTray = new HKhayAp();
    private HDotTrung selectedEggPeriod = new HDotTrung();
    private int eggPeriodNumber;
    private int trayNumber;
    private int soluonggacon = 0;
    private int soluongkhongdat = 0;
            
    public HatchMB() {
    }
    
    public String selectHatch(HKhayApDotTrung hatch, String page){
        selectedHatch = hatch;
        return page;
    }
    
    public List<HKhayApDotTrung> showAllHatch(){
        List<HKhayApDotTrung> listHatch = hKhayApDotTrungFacade.findAllHatchWithNotDel();
        return listHatch;
    }
    
    public List<HKhayAp> showAllSuitableTray(){
        List<HKhayAp> listTray = hKhayApDotTrungFacade.findAllSuitableTray();
        return listTray;
    }
    
    public List<HDotTrung> showAllSuitableEggPeriod(){
        List<HDotTrung> listEggPeriod = hKhayApDotTrungFacade.findAllSuitableEggPeriod();
        return listEggPeriod;
    }

    public String addHatch(){
        try {
            Date now = new Date();
            selectedHatch.setHKhayApDotTrungPK(new HKhayApDotTrungPK(trayNumber, eggPeriodNumber));
            int count = 0;
            selectedTray = hKhayApFacade.find(trayNumber);
            selectedEggPeriod = hDotTrungFacade.find(eggPeriodNumber);
            if(selectedTray.getSucchua() > selectedEggPeriod.getSoluong()){
                selectedEggPeriod.setSoluong(0);
                hDotTrungFacade.edit(selectedEggPeriod);
                selectedHatch.setSoluongdatchuan(selectedEggPeriod.getSoluong());
            } else{
                count = selectedEggPeriod.getSoluong() - selectedTray.getSucchua();
                selectedHatch.setSoluongdatchuan(selectedTray.getSucchua());
                
                selectedTray.setTinhtrang(1);
                hKhayApFacade.edit(selectedTray);
                selectedEggPeriod.setSoluong(count);
                hDotTrungFacade.edit(selectedEggPeriod);
            }
            selectedHatch.setThoigianbatdau(now);
            
            selectedHatch.setSoluongkhongdat(0);
            hKhayApDotTrungFacade.create(selectedHatch);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "hatch";
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm!", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "hatch-add";
        }
    }
    
    public String editHatch(){
        try {
            Date now = new Date();
            
            selectedHatch.setThoigiancapnhat(now);
            hKhayApDotTrungFacade.edit(selectedHatch);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "hatch";
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm!", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "hatch-edit";
        }
    }
    
    public String deleteHatch(){
        try {
            selectedHatch.setXoa(true);
            hKhayApDotTrungFacade.edit(selectedHatch);
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "hatch";
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm!", null);
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            return "hatch";
        }
    }
    
    public HKhayApDotTrung getSelectedHatch() {
        return selectedHatch;
    }

    public void setSelectedHatch(HKhayApDotTrung selectedHatch) {
        this.selectedHatch = selectedHatch;
    }

    public HKhayAp getSelectedTray() {
        return selectedTray;
    }

    public void setSelectedTray(HKhayAp selectedTray) {
        this.selectedTray = selectedTray;
    }

    public HDotTrung getSelectedEggPeriod() {
        selectedEggPeriod.setSoluong(0);
        return selectedEggPeriod;
    }

    public void setSelectedEggPeriod(HDotTrung selectedEggPeriod) {
        this.selectedEggPeriod = selectedEggPeriod;
    }

    public int getEggPeriodNumber() {
        return eggPeriodNumber;
    }

    public void setEggPeriodNumber(int eggPeriodNumber) {
        this.eggPeriodNumber = eggPeriodNumber;
    }

    public int getTrayNumber() {
        return trayNumber;
    }

    public void setTrayNumber(int trayNumber) {
        this.trayNumber = trayNumber;
    }

    public int getSoluonggacon() {
        return soluonggacon;
    }

    public void setSoluonggacon(int soluonggacon) {
        this.soluonggacon = soluonggacon;
    }

    public int getSoluongkhongdat() {
        return soluongkhongdat;
    }

    public void setSoluongkhongdat(int soluongkhongdat) {
        this.soluongkhongdat = soluongkhongdat;
    }
    
}
