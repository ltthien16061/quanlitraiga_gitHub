/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbpack;

import beanpack.GDotNhapGaGiongFacadeLocal;
import beanpack.GNhomGa;
import beanpack.GNhomGaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Baotiso Laptop
 */
@Named(value = "group2MB")
@SessionScoped
public class Group2MB implements Serializable {

    @EJB
    private GNhomGaFacadeLocal gNhomGaFacade;

    @EJB
    private GDotNhapGaGiongFacadeLocal gDotNhapGaGiongFacade;
    
    private int importID;
    private Date importDate;
    
     List<GNhomGa> groupList = new ArrayList<GNhomGa>();
     
     
    /**
     * Creates a new instance of Group2MB
     */
    public Group2MB() {
    }
    
     //Show all by importID
    public String showGroupbyImportID(int id,Date date) {
        importID = id;      
        importDate = date;
        groupList = gNhomGaFacade.showGroupByImport(id);
        return "chicken-group2";
    }    
    public List<GNhomGa> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GNhomGa> groupList) {
        this.groupList = groupList;
    }
    

    public int getImportID() {
        return importID;
    }

    public void setImportID(int importID) {
        this.importID = importID;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }
}
