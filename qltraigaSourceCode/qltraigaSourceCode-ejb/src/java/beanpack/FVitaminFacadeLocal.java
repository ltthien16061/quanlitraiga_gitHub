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
public interface FVitaminFacadeLocal {

    void create(FVitamin fVitamin);

    void edit(FVitamin fVitamin);

    void remove(FVitamin fVitamin);

    FVitamin find(Object id);

    List<FVitamin> findAll();

    List<FVitamin> findRange(int[] range);

    int count();
    
}
