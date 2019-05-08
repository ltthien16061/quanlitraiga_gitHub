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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Baotiso Laptop
 */
@Entity
@Table(name = "DLoaiBenh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DLoaiBenh.findAll", query = "SELECT d FROM DLoaiBenh d")
    , @NamedQuery(name = "DLoaiBenh.findByMaso", query = "SELECT d FROM DLoaiBenh d WHERE d.maso = :maso")
    , @NamedQuery(name = "DLoaiBenh.findByTen", query = "SELECT d FROM DLoaiBenh d WHERE d.ten = :ten")
    , @NamedQuery(name = "DLoaiBenh.findByMota", query = "SELECT d FROM DLoaiBenh d WHERE d.mota = :mota")
    , @NamedQuery(name = "DLoaiBenh.findByThoigiancapnhat", query = "SELECT d FROM DLoaiBenh d WHERE d.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "DLoaiBenh.findByXoa", query = "SELECT d FROM DLoaiBenh d WHERE d.xoa = :xoa")})
public class DLoaiBenh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "maso")
    private Integer maso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ten")
    private String ten;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "mota")
    private String mota;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mabenh")
    private Collection<DDonThuoc> dDonThuocCollection;

    public DLoaiBenh() {
    }

    public DLoaiBenh(Integer maso) {
        this.maso = maso;
    }

    public DLoaiBenh(Integer maso, String ten, String mota, boolean xoa) {
        this.maso = maso;
        this.ten = ten;
        this.mota = mota;
        this.xoa = xoa;
    }

    public Integer getMaso() {
        return maso;
    }

    public void setMaso(Integer maso) {
        this.maso = maso;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
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
    public Collection<DDonThuoc> getDDonThuocCollection() {
        return dDonThuocCollection;
    }

    public void setDDonThuocCollection(Collection<DDonThuoc> dDonThuocCollection) {
        this.dDonThuocCollection = dDonThuocCollection;
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
        if (!(object instanceof DLoaiBenh)) {
            return false;
        }
        DLoaiBenh other = (DLoaiBenh) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.DLoaiBenh[ maso=" + maso + " ]";
    }
    
}
