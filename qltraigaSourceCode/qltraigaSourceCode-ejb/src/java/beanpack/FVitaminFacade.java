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
public class FVitaminFacade extends AbstractFacade<FVitamin> implements FVitaminFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FVitaminFacade() {
        super(FVitamin.class);
    }

    @Override
    public List<FVitamin> showAllwithNotDel() {
        Query query = em.createNamedQuery("FVitamin.findByXoa");
        query.setParameter("xoa", false);
        return query.getResultList();
    }
    
}
