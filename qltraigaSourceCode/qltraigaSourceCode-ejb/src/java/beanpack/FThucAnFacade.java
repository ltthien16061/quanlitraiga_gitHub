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

    @Override
    public List<FThucAn> showFoodByKind(int kindID) {
        String sqlString = "select a.* from [FThucAn] a, [FLoaiThucAn] b where a.xoa = 'false' and a.maloai = b.maso and b.maso = ?";
        Query query = em.createNativeQuery(sqlString,FThucAn.class);
        query.setParameter(1, kindID); 
        return query.getResultList();
    }

    @Override
    public List<Object[]> showFoodByDel() {
        String sqlString = "select a.* , b.tenloai from [FThucAn] a, [FLoaiThucAn] b where a.xoa = 'false' and a.maloai = b.maso";
        Query query = em.createNativeQuery(sqlString);
        return query.getResultList();
    }
    
}
