/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanpack;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Baotiso Laptop
 */
@Stateless
public class FThucAnFacade extends AbstractFacade<FThucAn> implements FThucAnFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FThucAnFacade() {
        super(FThucAn.class);
    }
    
}
