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
@Table(name = "HNongHoGa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HNongHoGa.findAll", query = "SELECT h FROM HNongHoGa h")
    , @NamedQuery(name = "HNongHoGa.findByManongho", query = "SELECT h FROM HNongHoGa h WHERE h.manongho = :manongho")
    , @NamedQuery(name = "HNongHoGa.findByTinhtrang", query = "SELECT h FROM HNongHoGa h WHERE h.tinhtrang = :tinhtrang")
    , @NamedQuery(name = "HNongHoGa.findByThoigiancapnhat", query = "SELECT h FROM HNongHoGa h WHERE h.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "HNongHoGa.findByXoa", query = "SELECT h FROM HNongHoGa h WHERE h.xoa = :xoa")})
public class HNongHoGa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "manongho")
    private String manongho;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manongho")
    private Collection<HDotTrung> hDotTrungCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hNongHoGa")
    private Collection<GDanGhep> gDanGhepCollection;
    @OneToMany(mappedBy = "manongho")
    private Collection<FThoiGianChoAn> fThoiGianChoAnCollection;
    @OneToMany(mappedBy = "manongho")
    private Collection<DThoiGianDungThuoc> dThoiGianDungThuocCollection;

    public HNongHoGa() {
    }

    public HNongHoGa(String manongho) {
        this.manongho = manongho;
    }

    public HNongHoGa(String manongho, int tinhtrang, boolean xoa) {
        this.manongho = manongho;
        this.tinhtrang = tinhtrang;
        this.xoa = xoa;
    }

    public String getManongho() {
        return manongho;
    }

    public void setManongho(String manongho) {
        this.manongho = manongho;
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
    public Collection<HDotTrung> getHDotTrungCollection() {
        return hDotTrungCollection;
    }

    public void setHDotTrungCollection(Collection<HDotTrung> hDotTrungCollection) {
        this.hDotTrungCollection = hDotTrungCollection;
    }

    @XmlTransient
    public Collection<GDanGhep> getGDanGhepCollection() {
        return gDanGhepCollection;
    }

    public void setGDanGhepCollection(Collection<GDanGhep> gDanGhepCollection) {
        this.gDanGhepCollection = gDanGhepCollection;
    }

    @XmlTransient
    public Collection<FThoiGianChoAn> getFThoiGianChoAnCollection() {
        return fThoiGianChoAnCollection;
    }

    public void setFThoiGianChoAnCollection(Collection<FThoiGianChoAn> fThoiGianChoAnCollection) {
        this.fThoiGianChoAnCollection = fThoiGianChoAnCollection;
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
        hash += (manongho != null ? manongho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HNongHoGa)) {
            return false;
        }
        HNongHoGa other = (HNongHoGa) object;
        if ((this.manongho == null && other.manongho != null) || (this.manongho != null && !this.manongho.equals(other.manongho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.HNongHoGa[ manongho=" + manongho + " ]";
    }
    
}
