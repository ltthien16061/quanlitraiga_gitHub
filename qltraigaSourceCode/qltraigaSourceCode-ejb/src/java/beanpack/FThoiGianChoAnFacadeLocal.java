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
public interface FThoiGianChoAnFacadeLocal {

    void create(FThoiGianChoAn fThoiGianChoAn);

    void edit(FThoiGianChoAn fThoiGianChoAn);

    void remove(FThoiGianChoAn fThoiGianChoAn);

    FThoiGianChoAn find(Object id);

    List<FThoiGianChoAn> findAll();

    List<FThoiGianChoAn> findRange(int[] range);

    int count();    
            
    public List<Object[]> showAllByGroup(String groupID);
    
    public List<FThoiGianChoAn> showAllByDel();
    
}
