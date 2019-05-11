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
public interface GThongKeNhomGaFacadeLocal {

    void create(GThongKeNhomGa gThongKeNhomGa);

    void edit(GThongKeNhomGa gThongKeNhomGa);

    void remove(GThongKeNhomGa gThongKeNhomGa);

    GThongKeNhomGa find(Object id);

    List<GThongKeNhomGa> findAll();

    List<GThongKeNhomGa> findRange(int[] range);

    int count();
    
    public List<GThongKeNhomGa> showStatisticalByGroup(String groupID);
    
}
