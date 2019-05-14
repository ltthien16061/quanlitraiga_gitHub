/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanpack;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Baotiso Laptop
 */
@Stateless
public class FCongThucFacade extends AbstractFacade<FCongThuc> implements FCongThucFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FCongThucFacade() {
        super(FCongThuc.class);
    }

    @Override
    public List<Object[]> showRecipeForFood(int foodID) {        
        String sqlString = "SELECT  a.maso, a.mathucan, b.ten, a.slthucan, a.mavitamin, c.ten, a.slvitamin, a.mota, a.thoigiancapnhat " +
                            "FROM [FCongThuc] a left Join [FThucAn] b " +
                            "on  a.mathucan = b.maso \n" +
                            "left join [FVitamin] c on a.mavitamin = c.maso " +
                            "where a.mathucan = ? " +
                            "group by a.maso, a.mathucan, b.ten, a.slthucan, a.mavitamin, c.ten, a.slvitamin, a.mota, a.thoigiancapnhat";
        Query query = em.createNativeQuery(sqlString);
        query.setParameter(1, foodID);
        return query.getResultList();
    }

    @Override
    public List<Object[]> showRecipeForVitamin(int vitaminID) {
        String sqlString = "SELECT a.maso, a.mathucan, b.ten, a.slthucan, a.mavitamin, c.ten, a.slvitamin, a.mota, a.thoigiancapnhat " +
                            "FROM [FCongThuc] a left Join [FThucAn] b " +
                            "on  a.mathucan = b.maso \n" +
                            "left join [FVitamin] c on a.mavitamin = c.maso " +
                            "where a.mavitamin = ? " +
                            "group by a.maso, a.mathucan, b.ten, a.slthucan, a.mavitamin, c.ten, a.slvitamin, a.mota, a.thoigiancapnhat";
        Query query = em.createNativeQuery(sqlString);
        query.setParameter(1, vitaminID);
        return query.getResultList();
    }

    @Override
    public List<Object[]> showAllRecipe() {
        String sqlString = "SELECT a.maso, a.mathucan, b.ten, a.slthucan, a.mavitamin, c.ten, a.slvitamin, a.mota, a.thoigiancapnhat " +
                            "FROM [FCongThuc] a left Join [FThucAn] b " +
                            "on  a.mathucan = b.maso " +
                            "left join [FVitamin] c on a.mavitamin = c.maso " +
                            "where a.xoa = 'false' " +
                            "group by a.maso, a.mathucan, b.ten, a.slthucan, a.mavitamin, c.ten, a.slvitamin, a.mota, a.thoigiancapnhat";
        Query query = em.createNativeQuery(sqlString);
        return query.getResultList();
    }
    
}
