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
public class GNhomGaFacade extends AbstractFacade<GNhomGa> implements GNhomGaFacadeLocal {

    @PersistenceContext(unitName = "qltraigaSourceCode-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GNhomGaFacade() {
        super(GNhomGa.class);
    }

    @Override
    public List<Object[]> showAllGroup() {
//        String sqlString = "select c.manhom,  a.ten, c.soluongbandau, c.soluonghientai, c.tinhtrang, c.thoigianchianhom, c.madotnhap " +
//                           "from [GNhaCungCap] a, [GDotNhapGaGiong] b, [GNhomGa] c " +
//                           "where a.maso = b.masocc and b.maso = c.madotnhap and c.xoa = 'false'";
        String sqlString = "SELECT c.manhom,  a.ten, c.soluongbandau, c.soluonghientai, c.tinhtrang, c.thoigianchianhom, c.madotnhap, n.sogadu " +
                            "FROM  [GNhaCungCap] a,[GDotNhapGaGiong] b, [GNHomGa] c left Join [NThongKeGaDu] n " +
                            "on  c.manhom = n.manhomga " +
                            "where  a.maso = b.masocc and b.maso = c.madotnhap and c.xoa = 'false' " +
                            "group by c.manhom,  a.ten, c.soluongbandau, c.soluonghientai, c.tinhtrang, c.thoigianchianhom, c.madotnhap, n.sogadu";
        Query query = em.createNativeQuery(sqlString);
        return query.getResultList();
    }

    @Override
    public List<GNhomGa> showGroupByImport(int importID) {
        String sqlString = "select * from [GNhomGa] where madotnhap = ? and xoa = ?";
        Query query = em.createNativeQuery(sqlString, GNhomGa.class);
        query.setParameter(1, importID);  
        query.setParameter(2, false);
        return query.getResultList();
    }

    @Override
    public int countGroupID() {
        String sqlString = "select count(manhom) from [GNhomGa]";
        Query query = em.createNativeQuery(sqlString);        
        return (int)query.getSingleResult();
    }
    
}
