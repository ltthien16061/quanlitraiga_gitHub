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
public interface NThongKeGaDuFacadeLocal {

    void create(NThongKeGaDu nThongKeGaDu);

    void edit(NThongKeGaDu nThongKeGaDu);

    void remove(NThongKeGaDu nThongKeGaDu);

    NThongKeGaDu find(Object id);

    List<NThongKeGaDu> findAll();

    List<NThongKeGaDu> findRange(int[] range);

    int count();
    
}
