/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanpack;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Baotiso Laptop
 */
@Entity
@Table(name = "HKhayAp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKhayAp.findAll", query = "SELECT h FROM HKhayAp h")
    , @NamedQuery(name = "HKhayAp.findByMaso", query = "SELECT h FROM HKhayAp h WHERE h.maso = :maso")
    , @NamedQuery(name = "HKhayAp.findBySucchua", query = "SELECT h FROM HKhayAp h WHERE h.succhua = :succhua")
    , @NamedQuery(name = "HKhayAp.findByTinhtrang", query = "SELECT h FROM HKhayAp h WHERE h.tinhtrang = :tinhtrang")
    , @NamedQuery(name = "HKhayAp.findByThoigiancapnhat", query = "SELECT h FROM HKhayAp h WHERE h.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "HKhayAp.findByXoa", query = "SELECT h FROM HKhayAp h WHERE h.xoa = :xoa")})
public class HKhayAp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "maso")
    private Integer maso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "succhua")
    private int succhua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tinhtrang")
    private int tinhtrang;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hKhayAp")
    private Collection<HKhayApDotTrung> hKhayApDotTrungCollection;

    public HKhayAp() {
    }

    public HKhayAp(Integer maso) {
        this.maso = maso;
    }

    public HKhayAp(Integer maso, int succhua, int tinhtrang, boolean xoa) {
        this.maso = maso;
        this.succhua = succhua;
        this.tinhtrang = tinhtrang;
        this.xoa = xoa;
    }

    public Integer getMaso() {
        return maso;
    }

    public void setMaso(Integer maso) {
        this.maso = maso;
    }

    public int getSucchua() {
        return succhua;
    }

    public void setSucchua(int succhua) {
        this.succhua = succhua;
    }

    public int getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
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

    @XmlTransient
    public Collection<HKhayApDotTrung> getHKhayApDotTrungCollection() {
        return hKhayApDotTrungCollection;
    }

    public void setHKhayApDotTrungCollection(Collection<HKhayApDotTrung> hKhayApDotTrungCollection) {
        this.hKhayApDotTrungCollection = hKhayApDotTrungCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maso != null ? maso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKhayAp)) {
            return false;
        }
        HKhayAp other = (HKhayAp) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.HKhayAp[ maso=" + maso + " ]";
    }
    
}
