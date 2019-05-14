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
public interface FLoaiThucAnFacadeLocal {

    void create(FLoaiThucAn fLoaiThucAn);

    void edit(FLoaiThucAn fLoaiThucAn);

    void remove(FLoaiThucAn fLoaiThucAn);

    FLoaiThucAn find(Object id);

    List<FLoaiThucAn> findAll();

    List<FLoaiThucAn> findRange(int[] range);

    int count();
        
    public List<Object[]> showAllwithNotDel();
    
    public List<FLoaiThucAn> showKindForAddFood();
    
}
