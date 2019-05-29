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
public class HNongHoGaFacade extends AbstractFacade<HNongHoGa> implements HNongHoGaFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HNongHoGaFacade() {
        super(HNongHoGa.class);
    }
    
    @Override
    public List<HNongHoGa> findAllFarmerWithNotDel(){
        Query query = em.createNamedQuery("HNongHoGa.findByXoa");
        query.setParameter("xoa", false);
        return query.getResultList();
    }
    
    @Override
    public List<GDanGhep> findAllGraftGroupWithNotDel(){
        Query query = em.createNamedQuery("GDanGhep.findByXoa");
        query.setParameter("xoa", false);
        return query.getResultList();
    }
    
    @Override
    public List<GDanGhep> findGraftGroupByFarmerID(String farmerID){
        Query query = em.createNamedQuery("GDanGhep.findByManongho");
        query.setParameter("manongho", farmerID);
        return query.getResultList();
    }
    
    @Override
    public List<GNhomGa> findAllSuitableEggGroup(){
        String sql = "select * from [GNhomGa] where thoigianchianhom <= dateadd(month, -6, getdate())";
        Query query = em.createNativeQuery(sql, GNhomGa.class);
        return query.getResultList();
    }
}
