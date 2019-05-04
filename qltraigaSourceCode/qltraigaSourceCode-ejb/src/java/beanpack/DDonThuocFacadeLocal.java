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
public interface DDonThuocFacadeLocal {

    void create(DDonThuoc dDonThuoc);

    void edit(DDonThuoc dDonThuoc);

    void remove(DDonThuoc dDonThuoc);

    DDonThuoc find(Object id);

    List<DDonThuoc> findAll();

    List<DDonThuoc> findRange(int[] range);

    int count();
    
}
