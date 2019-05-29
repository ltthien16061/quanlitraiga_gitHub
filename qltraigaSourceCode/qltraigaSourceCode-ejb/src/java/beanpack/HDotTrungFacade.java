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
public class HDotTrungFacade extends AbstractFacade<HDotTrung> implements HDotTrungFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HDotTrungFacade() {
        super(HDotTrung.class);
    }
    
    
    @Override
    public List<HDotTrung> findAllEggPeriodWithNotDel(){
        Query query = em.createNamedQuery("HDotTrung.findByXoa");
        query.setParameter("xoa", false);
        return query.getResultList();
    }
    
    @Override
    public List<GDanGhep> findAllSuitableFarmer(){
        String sql = "select * from GDanGhep g where g.thoidiemghep <= dateadd(month, -9, getdate()) and g.xoa = 0";
        Query query = em.createNativeQuery(sql);
        return query.getResultList();
    }
}
