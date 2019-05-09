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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "GDotNhapGaGiong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GDotNhapGaGiong.findAll", query = "SELECT g FROM GDotNhapGaGiong g")
    , @NamedQuery(name = "GDotNhapGaGiong.findByMaso", query = "SELECT g FROM GDotNhapGaGiong g WHERE g.maso = :maso")
    , @NamedQuery(name = "GDotNhapGaGiong.findByDotuoi", query = "SELECT g FROM GDotNhapGaGiong g WHERE g.dotuoi = :dotuoi")
    , @NamedQuery(name = "GDotNhapGaGiong.findBySoluongnhap", query = "SELECT g FROM GDotNhapGaGiong g WHERE g.soluongnhap = :soluongnhap")
    , @NamedQuery(name = "GDotNhapGaGiong.findBySoluongconlai", query = "SELECT g FROM GDotNhapGaGiong g WHERE g.soluongconlai = :soluongconlai")
    , @NamedQuery(name = "GDotNhapGaGiong.findByThoigiannhap", query = "SELECT g FROM GDotNhapGaGiong g WHERE g.thoigiannhap = :thoigiannhap")
    , @NamedQuery(name = "GDotNhapGaGiong.findByThoigiancapnhat", query = "SELECT g FROM GDotNhapGaGiong g WHERE g.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "GDotNhapGaGiong.findByXoa", query = "SELECT g FROM GDotNhapGaGiong g WHERE g.xoa = :xoa")})
public class GDotNhapGaGiong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //Custom by Thien
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maso")
    private Integer maso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dotuoi")
    private int dotuoi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluongnhap")
    private int soluongnhap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluongconlai")
    private int soluongconlai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigiannhap")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiannhap;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @JoinColumn(name = "masocc", referencedColumnName = "maso")
    @ManyToOne(optional = false)
    private GNhaCungCap masocc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "madotnhap")
    private Collection<GNhomGa> gNhomGaCollection;

    public GDotNhapGaGiong() {
    }

    public GDotNhapGaGiong(Integer maso) {
        this.maso = maso;
    }

    public GDotNhapGaGiong(Integer maso, int dotuoi, int soluongnhap, int soluongconlai, Date thoigiannhap, boolean xoa) {
        this.maso = maso;
        this.dotuoi = dotuoi;
        this.soluongnhap = soluongnhap;
        this.soluongconlai = soluongconlai;
        this.thoigiannhap = thoigiannhap;
        this.xoa = xoa;
    }

    public Integer getMaso() {
        return maso;
    }

    public void setMaso(Integer maso) {
        this.maso = maso;
    }

    public int getDotuoi() {
        return dotuoi;
    }

    public void setDotuoi(int dotuoi) {
        this.dotuoi = dotuoi;
    }

    public int getSoluongnhap() {
        return soluongnhap;
    }

    public void setSoluongnhap(int soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    public int getSoluongconlai() {
        return soluongconlai;
    }

    public void setSoluongconlai(int soluongconlai) {
        this.soluongconlai = soluongconlai;
    }

    public Date getThoigiannhap() {
        return thoigiannhap;
    }

    public void setThoigiannhap(Date thoigiannhap) {
        this.thoigiannhap = thoigiannhap;
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

    public GNhaCungCap getMasocc() {
        return masocc;
    }

    public void setMasocc(GNhaCungCap masocc) {
        this.masocc = masocc;
    }

    @XmlTransient
    public Collection<GNhomGa> getGNhomGaCollection() {
        return gNhomGaCollection;
    }

    public void setGNhomGaCollection(Collection<GNhomGa> gNhomGaCollection) {
        this.gNhomGaCollection = gNhomGaCollection;
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
        if (!(object instanceof GDotNhapGaGiong)) {
            return false;
        }
        GDotNhapGaGiong other = (GDotNhapGaGiong) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.GDotNhapGaGiong[ maso=" + maso + " ]";
    }
    
}
