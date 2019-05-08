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
public interface DLoaiBenhFacadeLocal {

    void create(DLoaiBenh dLoaiBenh);

    void edit(DLoaiBenh dLoaiBenh);

    void remove(DLoaiBenh dLoaiBenh);

    DLoaiBenh find(Object id);

    List<DLoaiBenh> findAll();

    List<DLoaiBenh> findRange(int[] range);

    int count();
    
}
