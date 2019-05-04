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
public interface HKhayApFacadeLocal {

    void create(HKhayAp hKhayAp);

    void edit(HKhayAp hKhayAp);

    void remove(HKhayAp hKhayAp);

    HKhayAp find(Object id);

    List<HKhayAp> findAll();

    List<HKhayAp> findRange(int[] range);

    int count();
    
}
