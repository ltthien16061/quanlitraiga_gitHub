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
public interface GDotNhapNhomGaFacadeLocal {

    void create(GDotNhapNhomGa gDotNhapNhomGa);

    void edit(GDotNhapNhomGa gDotNhapNhomGa);

    void remove(GDotNhapNhomGa gDotNhapNhomGa);

    GDotNhapNhomGa find(Object id);

    List<GDotNhapNhomGa> findAll();

    List<GDotNhapNhomGa> findRange(int[] range);

    int count();
    
}
