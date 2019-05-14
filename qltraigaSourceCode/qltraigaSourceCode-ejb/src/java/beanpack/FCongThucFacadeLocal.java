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
public interface FCongThucFacadeLocal {

    void create(FCongThuc fCongThuc);

    void edit(FCongThuc fCongThuc);

    void remove(FCongThuc fCongThuc);

    FCongThuc find(Object id);

    List<FCongThuc> findAll();

    List<FCongThuc> findRange(int[] range);

    int count();
    
    public List<Object[]> showRecipeForFood(int foodID);
    
    public List<Object[]> showRecipeForVitamin(int VitaminID);
    
    public List<Object[]> showAllRecipe();
}
