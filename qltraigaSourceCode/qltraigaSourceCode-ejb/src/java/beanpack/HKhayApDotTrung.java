/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanpack;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Baotiso Laptop
 */
@Entity
@Table(name = "HKhayApDotTrung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKhayApDotTrung.findAll", query = "SELECT h FROM HKhayApDotTrung h")
    , @NamedQuery(name = "HKhayApDotTrung.findByMakhay", query = "SELECT h FROM HKhayApDotTrung h WHERE h.hKhayApDotTrungPK.makhay = :makhay")
    , @NamedQuery(name = "HKhayApDotTrung.findByMadot", query = "SELECT h FROM HKhayApDotTrung h WHERE h.hKhayApDotTrungPK.madot = :madot")
    , @NamedQuery(name = "HKhayApDotTrung.findByThoigianbatdau", query = "SELECT h FROM HKhayApDotTrung h WHERE h.thoigianbatdau = :thoigianbatdau")
    , @NamedQuery(name = "HKhayApDotTrung.findBySoluongdatchuan", query = "SELECT h FROM HKhayApDotTrung h WHERE h.soluongdatchuan = :soluongdatchuan")
    , @NamedQuery(name = "HKhayApDotTrung.findBySoluongkhongdat", query = "SELECT h FROM HKhayApDotTrung h WHERE h.soluongkhongdat = :soluongkhongdat")
    , @NamedQuery(name = "HKhayApDotTrung.findBySoluonggacon", query = "SELECT h FROM HKhayApDotTrung h WHERE h.soluonggacon = :soluonggacon")
    , @NamedQuery(name = "HKhayApDotTrung.findByThoigiancapnhat", query = "SELECT h FROM HKhayApDotTrung h WHERE h.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "HKhayApDotTrung.findByXoa", query = "SELECT h FROM HKhayApDotTrung h WHERE h.xoa = :xoa")})
public class HKhayApDotTrung implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HKhayApDotTrungPK hKhayApDotTrungPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigianbatdau")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigianbatdau;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluongdatchuan")
    private int soluongdatchuan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluongkhongdat")
    private int soluongkhongdat;
    @Column(name = "soluonggacon")
    private Integer soluonggacon;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @JoinColumn(name = "madot", referencedColumnName = "maso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HDotTrung hDotTrung;
    @JoinColumn(name = "makhay", referencedColumnName = "maso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HKhayAp hKhayAp;

    public HKhayApDotTrung() {
    }

    public HKhayApDotTrung(HKhayApDotTrungPK hKhayApDotTrungPK) {
        this.hKhayApDotTrungPK = hKhayApDotTrungPK;
    }

    public HKhayApDotTrung(HKhayApDotTrungPK hKhayApDotTrungPK, Date thoigianbatdau, int soluongdatchuan, int soluongkhongdat, boolean xoa) {
        this.hKhayApDotTrungPK = hKhayApDotTrungPK;
        this.thoigianbatdau = thoigianbatdau;
        this.soluongdatchuan = soluongdatchuan;
        this.soluongkhongdat = soluongkhongdat;
        this.xoa = xoa;
    }

    public HKhayApDotTrung(int makhay, int madot) {
        this.hKhayApDotTrungPK = new HKhayApDotTrungPK(makhay, madot);
    }

    public HKhayApDotTrungPK getHKhayApDotTrungPK() {
        return hKhayApDotTrungPK;
    }

    public void setHKhayApDotTrungPK(HKhayApDotTrungPK hKhayApDotTrungPK) {
        this.hKhayApDotTrungPK = hKhayApDotTrungPK;
    }

    public Date getThoigianbatdau() {
        return thoigianbatdau;
    }

    public void setThoigianbatdau(Date thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    public int getSoluongdatchuan() {
        return soluongdatchuan;
    }

    public void setSoluongdatchuan(int soluongdatchuan) {
        this.soluongdatchuan = soluongdatchuan;
    }

    public int getSoluongkhongdat() {
        return soluongkhongdat;
    }

    public void setSoluongkhongdat(int soluongkhongdat) {
        this.soluongkhongdat = soluongkhongdat;
    }

    public Integer getSoluonggacon() {
        return soluonggacon;
    }

    public void setSoluonggacon(Integer soluonggacon) {
        this.soluonggacon = soluonggacon;
    }

    public Date getThoigiancapnhat() {
        return thoigiancapnhat;
    }

    public void setThoigiancapnhat(Date thoigiancapnhat) {
        this.thoigiancapnhat = thoigiancapnhat;
    }

    public boolean getXoa() {
        return xoa;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
    }

    public HDotTrung getHDotTrung() {
        return hDotTrung;
    }

    public void setHDotTrung(HDotTrung hDotTrung) {
        this.hDotTrung = hDotTrung;
    }

    public HKhayAp getHKhayAp() {
        return hKhayAp;
    }

    public void setHKhayAp(HKhayAp hKhayAp) {
        this.hKhayAp = hKhayAp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hKhayApDotTrungPK != null ? hKhayApDotTrungPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKhayApDotTrung)) {
            return false;
        }
        HKhayApDotTrung other = (HKhayApDotTrung) object;
        if ((this.hKhayApDotTrungPK == null && other.hKhayApDotTrungPK != null) || (this.hKhayApDotTrungPK != null && !this.hKhayApDotTrungPK.equals(other.hKhayApDotTrungPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.HKhayApDotTrung[ hKhayApDotTrungPK=" + hKhayApDotTrungPK + " ]";
    }
    
}
