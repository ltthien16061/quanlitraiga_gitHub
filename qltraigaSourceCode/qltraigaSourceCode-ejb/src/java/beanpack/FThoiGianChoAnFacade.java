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
public class FThoiGianChoAnFacade extends AbstractFacade<FThoiGianChoAn> implements FThoiGianChoAnFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FThoiGianChoAnFacade() {
        super(FThoiGianChoAn.class);
    }

    @Override
    public List<Object[]> showAllByGroup(String groupID) {        
        String sqlString = "select b.thoidiem, b.macongthuc, b.khauphan, b.thoigiancapnhat, b.maso from [GNhomGa] a, [FThoiGianChoAn] b where a.manhom = b.manhom and b.manhom = ? and b.xoa = 'false'";
        Query query = em.createNativeQuery(sqlString);
        query.setParameter(1, groupID); 
        return query.getResultList();
    }

    @Override
    public List<FThoiGianChoAn> showAllByDel() {
        Query query = em.createNamedQuery("FThoiGianChoAn.findByXoa");
        query.setParameter("xoa", false);
        return query.getResultList();
    }
    
}
