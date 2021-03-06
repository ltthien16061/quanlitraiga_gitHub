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
public class HKhayApFacade extends AbstractFacade<HKhayAp> implements HKhayApFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HKhayApFacade() {
        super(HKhayAp.class);
    }
    
    
    public List<HKhayAp> findAllTrayWithNotDel(){
        Query query = em.createNamedQuery("HKhayAp.findByXoa");
        query.setParameter("xoa", false);
        return query.getResultList();
    }
}
