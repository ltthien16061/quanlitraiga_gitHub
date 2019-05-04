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
public interface DThoiGianDungThuocFacadeLocal {

    void create(DThoiGianDungThuoc dThoiGianDungThuoc);

    void edit(DThoiGianDungThuoc dThoiGianDungThuoc);

    void remove(DThoiGianDungThuoc dThoiGianDungThuoc);

    DThoiGianDungThuoc find(Object id);

    List<DThoiGianDungThuoc> findAll();

    List<DThoiGianDungThuoc> findRange(int[] range);

    int count();
    
}
