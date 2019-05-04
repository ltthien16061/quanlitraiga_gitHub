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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DDonThuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DDonThuoc.findAll", query = "SELECT d FROM DDonThuoc d")
    , @NamedQuery(name = "DDonThuoc.findByMaso", query = "SELECT d FROM DDonThuoc d WHERE d.maso = :maso")
    , @NamedQuery(name = "DDonThuoc.findByTen", query = "SELECT d FROM DDonThuoc d WHERE d.ten = :ten")
    , @NamedQuery(name = "DDonThuoc.findByMota", query = "SELECT d FROM DDonThuoc d WHERE d.mota = :mota")
    , @NamedQuery(name = "DDonThuoc.findByThoigiancapnhat", query = "SELECT d FROM DDonThuoc d WHERE d.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "DDonThuoc.findByXoa", query = "SELECT d FROM DDonThuoc d WHERE d.xoa = :xoa")})
public class DDonThuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "maso")
    private Integer maso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ten")
    private String ten;
    @Size(max = 2147483647)
    @Column(name = "mota")
    private String mota;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @JoinColumn(name = "mabenh", referencedColumnName = "maso")
    @ManyToOne(optional = false)
    private DLoaiBenh mabenh;
    @JoinColumn(name = "mathuoc", referencedColumnName = "maso")
    @ManyToOne(optional = false)
    private DThuoc mathuoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "madonthuoc")
    private Collection<DThoiGianDungThuoc> dThoiGianDungThuocCollection;

    public DDonThuoc() {
    }

    public DDonThuoc(Integer maso) {
        this.maso = maso;
    }

    public DDonThuoc(Integer maso, String ten, boolean xoa) {
        this.maso = maso;
        this.ten = ten;
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

    public DLoaiBenh getMabenh() {
        return mabenh;
    }

    public void setMabenh(DLoaiBenh mabenh) {
        this.mabenh = mabenh;
    }

    public DThuoc getMathuoc() {
        return mathuoc;
    }

    public void setMathuoc(DThuoc mathuoc) {
        this.mathuoc = mathuoc;
    }

    @XmlTransient
    public Collection<DThoiGianDungThuoc> getDThoiGianDungThuocCollection() {
        return dThoiGianDungThuocCollection;
    }

    public void setDThoiGianDungThuocCollection(Collection<DThoiGianDungThuoc> dThoiGianDungThuocCollection) {
        this.dThoiGianDungThuocCollection = dThoiGianDungThuocCollection;
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
        if (!(object instanceof DDonThuoc)) {
            return false;
        }
        DDonThuoc other = (DDonThuoc) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.DDonThuoc[ maso=" + maso + " ]";
    }
    
}
