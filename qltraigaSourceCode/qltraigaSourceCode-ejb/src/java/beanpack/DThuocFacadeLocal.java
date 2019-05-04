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
public interface DThuocFacadeLocal {

    void create(DThuoc dThuoc);

    void edit(DThuoc dThuoc);

    void remove(DThuoc dThuoc);

    DThuoc find(Object id);

    List<DThuoc> findAll();

    List<DThuoc> findRange(int[] range);

    int count();
    
}
