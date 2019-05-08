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
public interface FThucAnFacadeLocal {

    void create(FThucAn fThucAn);

    void edit(FThucAn fThucAn);

    void remove(FThucAn fThucAn);

    FThucAn find(Object id);

    List<FThucAn> findAll();

    List<FThucAn> findRange(int[] range);

    int count();
    
}
