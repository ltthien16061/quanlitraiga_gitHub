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
public class HKhayApDotTrungFacade extends AbstractFacade<HKhayApDotTrung> implements HKhayApDotTrungFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HKhayApDotTrungFacade() {
        super(HKhayApDotTrung.class);
    }
    
    @Override
    public List<HKhayApDotTrung> findAllHatchWithNotDel(){
        Query query = em.createNamedQuery("HKhayApDotTrung.findByXoa");
        query.setParameter("xoa", false);
        return query.getResultList();
    }
    
    @Override
    public List<HKhayAp> findAllSuitableTray(){
        String sql = "select * from HKhayAp h where h.xoa = 0 and h.tinhtrang = 0";
        Query query = em.createNativeQuery(sql);
        return query.getResultList();
    }
    
    @Override
    public List<HDotTrung> findAllSuitableEggPeriod(){
        String sql = "select * from HDotTrung h where h.xoa = 0 and h.soluong > 0 and h.thoidiemthuhoach <= dateadd(day, -14, getdate())";
        Query query = em.createNativeQuery(sql);
        return query.getResultList();
    }
}
