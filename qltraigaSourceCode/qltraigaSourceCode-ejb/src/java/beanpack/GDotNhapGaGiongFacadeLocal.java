/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanpack;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Baotiso Laptop
 */
@Local
public interface GDotNhapGaGiongFacadeLocal {

    void create(GDotNhapGaGiong gDotNhapGaGiong);

    void edit(GDotNhapGaGiong gDotNhapGaGiong);

    void remove(GDotNhapGaGiong gDotNhapGaGiong);

    GDotNhapGaGiong find(Object id);

    List<GDotNhapGaGiong> findAll();

    List<GDotNhapGaGiong> findRange(int[] range);

    int count();
    
    public List<GDotNhapGaGiong> showChickenImportBySp(int spID);
    
    public List<Object[]> showChickenImportByDel();
    
}
