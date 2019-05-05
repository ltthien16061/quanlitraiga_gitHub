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
public interface GNhaCungCapFacadeLocal {

    void create(GNhaCungCap gNhaCungCap);

    void edit(GNhaCungCap gNhaCungCap);

    void remove(GNhaCungCap gNhaCungCap);

    GNhaCungCap find(Object id);

    List<GNhaCungCap> findAll();

    List<GNhaCungCap> findRange(int[] range);

    int count();
    
    public List<GNhaCungCap> showAllwithNotDel();
    
}
