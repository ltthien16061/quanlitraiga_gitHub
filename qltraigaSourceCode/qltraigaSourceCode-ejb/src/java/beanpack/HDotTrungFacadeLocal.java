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
public interface HDotTrungFacadeLocal {

    void create(HDotTrung hDotTrung);

    void edit(HDotTrung hDotTrung);

    void remove(HDotTrung hDotTrung);

    HDotTrung find(Object id);

    List<HDotTrung> findAll();

    List<HDotTrung> findRange(int[] range);

    int count();
    
}
