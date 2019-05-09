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
public interface NTaiKhoanFacadeLocal {

    void create(NTaiKhoan nTaiKhoan);

    void edit(NTaiKhoan nTaiKhoan);

    void remove(NTaiKhoan nTaiKhoan);

    NTaiKhoan find(Object id);

    List<NTaiKhoan> findAll();

    List<NTaiKhoan> findRange(int[] range);

    int count();
    
    public List<Object[]> findAccount(String username, String pass);
    
}
