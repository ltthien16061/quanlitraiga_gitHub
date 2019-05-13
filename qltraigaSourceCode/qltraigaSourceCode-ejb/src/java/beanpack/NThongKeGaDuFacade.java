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
public class NThongKeGaDuFacade extends AbstractFacade<NThongKeGaDu> implements NThongKeGaDuFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NThongKeGaDuFacade() {
        super(NThongKeGaDu.class);
    }

    @Override
    public List<NThongKeGaDu> checkSurplus(String groupID) {
        String sqlString = "select * from [NThongKeGaDu] where manhomga =?";
        Query query = em.createNativeQuery(sqlString,NThongKeGaDu.class);
        query.setParameter(1, groupID);  
        return query.getResultList();
    }
    
}
