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
@Table(name = "HDotTrung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HDotTrung.findAll", query = "SELECT h FROM HDotTrung h")
    , @NamedQuery(name = "HDotTrung.findByMaso", query = "SELECT h FROM HDotTrung h WHERE h.maso = :maso")
    , @NamedQuery(name = "HDotTrung.findByThoidiemthuhoach", query = "SELECT h FROM HDotTrung h WHERE h.thoidiemthuhoach = :thoidiemthuhoach")
    , @NamedQuery(name = "HDotTrung.findBySoluong", query = "SELECT h FROM HDotTrung h WHERE h.soluong = :soluong")
    , @NamedQuery(name = "HDotTrung.findByThoigiancapnhat", query = "SELECT h FROM HDotTrung h WHERE h.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "HDotTrung.findByXoa", query = "SELECT h FROM HDotTrung h WHERE h.xoa = :xoa")})
public class HDotTrung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maso")
    private Integer maso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoidiemthuhoach")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoidiemthuhoach;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluong")
    private int soluong;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @JoinColumn(name = "manongho", referencedColumnName = "manongho")
    @ManyToOne(optional = false)
    private HNongHoGa manongho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hDotTrung")
    private Collection<HKhayApDotTrung> hKhayApDotTrungCollection;

    public HDotTrung() {
    }

    public HDotTrung(Integer maso) {
        this.maso = maso;
    }

    public HDotTrung(Integer maso, Date thoidiemthuhoach, int soluong, boolean xoa) {
        this.maso = maso;
        this.thoidiemthuhoach = thoidiemthuhoach;
        this.soluong = soluong;
        this.xoa = xoa;
    }

    public Integer getMaso() {
        return maso;
    }

    public void setMaso(Integer maso) {
        this.maso = maso;
    }

    public Date getThoidiemthuhoach() {
        return thoidiemthuhoach;
    }

    public void setThoidiemthuhoach(Date thoidiemthuhoach) {
        this.thoidiemthuhoach = thoidiemthuhoach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
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

    public HNongHoGa getManongho() {
        return manongho;
    }

    public void setManongho(HNongHoGa manongho) {
        this.manongho = manongho;
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
        if (!(object instanceof HDotTrung)) {
            return false;
        }
        HDotTrung other = (HDotTrung) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.HDotTrung[ maso=" + maso + " ]";
    }
    
}
