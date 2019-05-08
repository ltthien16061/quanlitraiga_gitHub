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
public interface HKhayApDotTrungFacadeLocal {

    void create(HKhayApDotTrung hKhayApDotTrung);

    void edit(HKhayApDotTrung hKhayApDotTrung);

    void remove(HKhayApDotTrung hKhayApDotTrung);

    HKhayApDotTrung find(Object id);

    List<HKhayApDotTrung> findAll();

    List<HKhayApDotTrung> findRange(int[] range);

    int count();
    
}
