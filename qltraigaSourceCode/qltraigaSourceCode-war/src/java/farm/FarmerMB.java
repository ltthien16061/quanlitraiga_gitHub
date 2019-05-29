/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm;

import beanpack.GDanGhep;
import beanpack.GDanGhepFacadeLocal;
import beanpack.GDanGhepPK;
import beanpack.GNhomGa;
import beanpack.GNhomGaFacadeLocal;
import beanpack.HNongHoGa;
import beanpack.HNongHoGaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
    private GNhomGaFacadeLocal gNhomGaFacade;

    @EJB
    private GDanGhepFacadeLocal gDanGhepFacade;

    @EJB
    private HNongHoGaFacadeLocal hNongHoGaFacade;

    private HNongHoGa selectedFarmer = new HNongHoGa();
    private GNhomGa selectedEggGroup = new GNhomGa();
    private GDanGhep selectedGraftGroup = new GDanGhep();

    public FarmerMB() {
    }

    public List<HNongHoGa> showAllFarmer() {
        List<HNongHoGa> listFarmer = hNongHoGaFacade.findAllFarmerWithNotDel();
        return listFarmer;
    }

    public List<GNhomGa> showAllSuitableEggGroup() {
        List<GNhomGa> listEggGroup = hNongHoGaFacade.findAllSuitableEggGroup();
        return listEggGroup;
    }

    public List<GDanGhep> showGraftGroupByFarmerID() {
        List<GDanGhep> listGraftGroup = hNongHoGaFacade.findGraftGroupByFarmerID(selectedFarmer.getManongho());
        return listGraftGroup;
    }
    
    public String selectFarmer(HNongHoGa farmer, String page) {
        selectedFarmer = farmer;
        return page;
    }

    public void selectEggGroup(GNhomGa eggGroup) {
        selectedEggGroup = eggGroup;
    }

    public String addFarmer() {
        try {
            if (selectedEggGroup.getSoluonghientai() < 10) {
                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Số Lượng Gà Không Đủ Để Ghép", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            } else {
                Date now = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                int farmerNumber = hNongHoGaFacade.count() + 1;
                String code = selectedEggGroup.getManhom().substring(selectedEggGroup.getManhom().indexOf("G")) + "-" + sdf.format(now) + "H" + farmerNumber;
                selectedFarmer.setManongho(code);
                selectedFarmer.setTinhtrang(0);
                selectedFarmer.setThoigiancapnhat(now);
                hNongHoGaFacade.create(selectedFarmer);
                
                GDanGhep graftGroup = new GDanGhep();
                graftGroup.setGDanGhepPK(new GDanGhepPK(selectedEggGroup.getManhom(), selectedFarmer.getManongho()));
                graftGroup.setThoidiemghep(now);
                graftGroup.setXoa(false);
                gDanGhepFacade.create(graftGroup);

                selectedEggGroup.setSoluonghientai(selectedEggGroup.getSoluonghientai() - 10);
                gNhomGaFacade.edit(selectedEggGroup);

                FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thêm Thành Công", null);
                FacesContext.getCurrentInstance().addMessage(null, fMsg);
            }
            return "farmer";
        } catch (Exception ex) {
            FacesMessage fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phát Sinh Lỗi Khi Thêm!)", null);
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
            selectedGraftGroup = hNongHoGaFacade.findGraftGroupByFarmerID(selectedFarmer.getManongho()).get(0);
            selectedGraftGroup.setXoa(true);
            gDanGhepFacade.edit(selectedGraftGroup);
            
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

    public GNhomGa getSelectedEggGroup() {
        return selectedEggGroup;
    }

    public void setSelectedEggGroup(GNhomGa selectedEggGroup) {
        this.selectedEggGroup = selectedEggGroup;
    }

    public GDanGhep getSelectedGraftGroup() {
        return selectedGraftGroup;
    }

    public void setSelectedGraftGroup(GDanGhep selectedGraftGroup) {
        this.selectedGraftGroup = selectedGraftGroup;
    }

}
