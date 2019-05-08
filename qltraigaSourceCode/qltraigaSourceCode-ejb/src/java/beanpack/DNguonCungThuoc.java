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
@Table(name = "DNguonCungThuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DNguonCungThuoc.findAll", query = "SELECT d FROM DNguonCungThuoc d")
    , @NamedQuery(name = "DNguonCungThuoc.findByMaso", query = "SELECT d FROM DNguonCungThuoc d WHERE d.maso = :maso")
    , @NamedQuery(name = "DNguonCungThuoc.findByTen", query = "SELECT d FROM DNguonCungThuoc d WHERE d.ten = :ten")
    , @NamedQuery(name = "DNguonCungThuoc.findByDiachi", query = "SELECT d FROM DNguonCungThuoc d WHERE d.diachi = :diachi")
    , @NamedQuery(name = "DNguonCungThuoc.findByThoigiancapnhat", query = "SELECT d FROM DNguonCungThuoc d WHERE d.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "DNguonCungThuoc.findByXoa", query = "SELECT d FROM DNguonCungThuoc d WHERE d.xoa = :xoa")})
public class DNguonCungThuoc implements Serializable {

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
    @Size(min = 1, max = 250)
    @Column(name = "diachi")
    private String diachi;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manguoncung")
    private Collection<DThuoc> dThuocCollection;

    public DNguonCungThuoc() {
    }

    public DNguonCungThuoc(Integer maso) {
        this.maso = maso;
    }

    public DNguonCungThuoc(Integer maso, String ten, String diachi, boolean xoa) {
        this.maso = maso;
        this.ten = ten;
        this.diachi = diachi;
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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
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
    public Collection<DThuoc> getDThuocCollection() {
        return dThuocCollection;
    }

    public void setDThuocCollection(Collection<DThuoc> dThuocCollection) {
        this.dThuocCollection = dThuocCollection;
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
        if (!(object instanceof DNguonCungThuoc)) {
            return false;
        }
        DNguonCungThuoc other = (DNguonCungThuoc) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.DNguonCungThuoc[ maso=" + maso + " ]";
    }
    
}
