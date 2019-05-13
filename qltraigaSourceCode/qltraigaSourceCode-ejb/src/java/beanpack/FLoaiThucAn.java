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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Baotiso Laptop
 */
@Entity
@Table(name = "FLoaiThucAn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FLoaiThucAn.findAll", query = "SELECT f FROM FLoaiThucAn f")
    , @NamedQuery(name = "FLoaiThucAn.findByMaso", query = "SELECT f FROM FLoaiThucAn f WHERE f.maso = :maso")
    , @NamedQuery(name = "FLoaiThucAn.findByTenloai", query = "SELECT f FROM FLoaiThucAn f WHERE f.tenloai = :tenloai")
    , @NamedQuery(name = "FLoaiThucAn.findByThoigiancapnhat", query = "SELECT f FROM FLoaiThucAn f WHERE f.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "FLoaiThucAn.findByXoa", query = "SELECT f FROM FLoaiThucAn f WHERE f.xoa = :xoa")})
public class FLoaiThucAn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //Custom by Thien
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maso")
    private Integer maso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "tenloai")
    private String tenloai;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maloai")
    private Collection<FThucAn> fThucAnCollection;

    public FLoaiThucAn() {
    }

    public FLoaiThucAn(Integer maso) {
        this.maso = maso;
    }

    public FLoaiThucAn(Integer maso, String tenloai, boolean xoa) {
        this.maso = maso;
        this.tenloai = tenloai;
        this.xoa = xoa;
    }

    public Integer getMaso() {
        return maso;
    }

    public void setMaso(Integer maso) {
        this.maso = maso;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
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
    public Collection<FThucAn> getFThucAnCollection() {
        return fThucAnCollection;
    }

    public void setFThucAnCollection(Collection<FThucAn> fThucAnCollection) {
        this.fThucAnCollection = fThucAnCollection;
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
        if (!(object instanceof FLoaiThucAn)) {
            return false;
        }
        FLoaiThucAn other = (FLoaiThucAn) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.FLoaiThucAn[ maso=" + maso + " ]";
    }
    
}
