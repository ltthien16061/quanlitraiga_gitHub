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
public class FLoaiThucAnFacade extends AbstractFacade<FLoaiThucAn> implements FLoaiThucAnFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FLoaiThucAnFacade() {
        super(FLoaiThucAn.class);
    }

    @Override
    public List<Object[]> showAllwithNotDel() {
        String sqlString = "SELECT a.maso, a.tenloai, count(b.ten) as no, a.thoigiancapnhat  " +
                            "FROM [FLoaiThucAn] a left Join [FThucAn] b " +
                            "on  a.maso = b.maloai " +
                            "where a.xoa = 'false' " +
                            "group by a.maso, a.tenloai, a.thoigiancapnhat";
        Query query = em.createNativeQuery(sqlString);
        return query.getResultList();
    }

    @Override
    public List<FLoaiThucAn> showKindForAddFood() {
         Query query = em.createNamedQuery("FLoaiThucAn.findByXoa");
        query.setParameter("xoa", false);
        return query.getResultList();
    }
    
}
