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
public interface GNhomGaFacadeLocal {

    void create(GNhomGa gNhomGa);

    void edit(GNhomGa gNhomGa);

    void remove(GNhomGa gNhomGa);

    GNhomGa find(Object id);

    List<GNhomGa> findAll();

    List<GNhomGa> findRange(int[] range);

    int count();
    
    public List<Object[]> showAllGroup();
    
    public List<GNhomGa> showGroupByImport(int importID);
    
}
