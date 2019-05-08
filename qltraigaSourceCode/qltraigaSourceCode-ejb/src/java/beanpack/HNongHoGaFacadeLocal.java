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
public interface HNongHoGaFacadeLocal {

    void create(HNongHoGa hNongHoGa);

    void edit(HNongHoGa hNongHoGa);

    void remove(HNongHoGa hNongHoGa);

    HNongHoGa find(Object id);

    List<HNongHoGa> findAll();

    List<HNongHoGa> findRange(int[] range);

    int count();
    
}
