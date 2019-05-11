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
public class GDotNhapGaGiongFacade extends AbstractFacade<GDotNhapGaGiong> implements GDotNhapGaGiongFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GDotNhapGaGiongFacade() {
        super(GDotNhapGaGiong.class);
    }

    @Override
    public List<GDotNhapGaGiong> showChickenImportBySp(int spID) {
        String sqlString = "select * from [GDotNhapGaGiong] where masocc = ? and xoa = ?";
        Query query = em.createNativeQuery(sqlString, GDotNhapGaGiong.class);
        query.setParameter(1, spID);  
        query.setParameter(2, false);
        return query.getResultList();
    }

    @Override
    public List<Object[]> showChickenImportByDel() {
        String sqlString = "select a.*, b.ten, b.macc from [GDotNhapGaGiong] a, [GNhaCungCap] b where a.xoa = 'false' and a.masocc = b.maso";
        Query query = em.createNativeQuery(sqlString);
        return query.getResultList();
    }
    
}
