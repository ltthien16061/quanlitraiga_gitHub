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
public interface NCaiDatFacadeLocal {

    void create(NCaiDat nCaiDat);

    void edit(NCaiDat nCaiDat);

    void remove(NCaiDat nCaiDat);

    NCaiDat find(Object id);

    List<NCaiDat> findAll();

    List<NCaiDat> findRange(int[] range);

    int count();
    
}
