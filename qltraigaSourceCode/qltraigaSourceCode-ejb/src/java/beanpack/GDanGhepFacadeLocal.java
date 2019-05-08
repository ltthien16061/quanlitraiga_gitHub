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
public interface GDanGhepFacadeLocal {

    void create(GDanGhep gDanGhep);

    void edit(GDanGhep gDanGhep);

    void remove(GDanGhep gDanGhep);

    GDanGhep find(Object id);

    List<GDanGhep> findAll();

    List<GDanGhep> findRange(int[] range);

    int count();
    
}
