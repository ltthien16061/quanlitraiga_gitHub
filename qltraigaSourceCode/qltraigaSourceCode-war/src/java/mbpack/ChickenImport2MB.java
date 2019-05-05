/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbpack;

import beanpack.GDotNhapGaGiong;
import beanpack.GDotNhapGaGiongFacadeLocal;
import beanpack.GNhaCungCapFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "chickenImport2MB")
@SessionScoped
public class ChickenImport2MB extends CustomValidator implements Serializable{

    @EJB
    private GDotNhapGaGiongFacadeLocal gDotNhapGaGiongFacade;
    
    @EJB
    private GNhaCungCapFacadeLocal gNhaCungCapFacade;
    
    private int macc; //macc is primary key of GNhaCungCap (int)
    private String code; //code is forgein key of GDotNhapGaGiong (String)
    private String ten;
    
    List<GDotNhapGaGiong> chickenimport = new ArrayList<GDotNhapGaGiong>();
    /**
     * Creates a new instance of ChickenImportMB
     */
    public ChickenImport2MB() {
    }
    
     //Show all by spID
    public String showImportBySup(int spID,String name) {
        macc = spID;      
        ten = name;
        code = gNhaCungCapFacade.find(spID).getMacc();
        chickenimport = gDotNhapGaGiongFacade.showChickenImportBySp(spID);
        return "chicken-import2";
    }    
    public List<GDotNhapGaGiong> getChickenimport() {
        return chickenimport;
    }

    public void setChickenimport(List<GDotNhapGaGiong> chickenimport) {
        this.chickenimport = chickenimport;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    
    
    public int getMacc() {
        return macc;
    }

    public void setMacc(int macc) {
        this.macc = macc;
    }

    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
