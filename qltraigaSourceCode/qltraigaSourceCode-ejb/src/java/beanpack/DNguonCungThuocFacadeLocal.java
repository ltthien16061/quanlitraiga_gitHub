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
public interface DNguonCungThuocFacadeLocal {

    void create(DNguonCungThuoc dNguonCungThuoc);

    void edit(DNguonCungThuoc dNguonCungThuoc);

    void remove(DNguonCungThuoc dNguonCungThuoc);

    DNguonCungThuoc find(Object id);

    List<DNguonCungThuoc> findAll();

    List<DNguonCungThuoc> findRange(int[] range);

    int count();
    
}
