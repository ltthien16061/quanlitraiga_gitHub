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
public class GThongKeNhomGaFacade extends AbstractFacade<GThongKeNhomGa> implements GThongKeNhomGaFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GThongKeNhomGaFacade() {
        super(GThongKeNhomGa.class);
    }

    @Override
    public List<GThongKeNhomGa> showStatisticalByGroup(String groupID) {
        String sqlString = "select * from [GThongKeNhomGa] where manhomga = ?";
        Query query = em.createNativeQuery(sqlString, GThongKeNhomGa.class);
        query.setParameter(1, groupID); 
        return query.getResultList();
    }
    
}
