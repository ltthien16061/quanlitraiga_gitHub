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
@Table(name = "FThucAn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FThucAn.findAll", query = "SELECT f FROM FThucAn f")
    , @NamedQuery(name = "FThucAn.findByMaso", query = "SELECT f FROM FThucAn f WHERE f.maso = :maso")
    , @NamedQuery(name = "FThucAn.findByTen", query = "SELECT f FROM FThucAn f WHERE f.ten = :ten")
    , @NamedQuery(name = "FThucAn.findByGia", query = "SELECT f FROM FThucAn f WHERE f.gia = :gia")
    , @NamedQuery(name = "FThucAn.findByNgaymua", query = "SELECT f FROM FThucAn f WHERE f.ngaymua = :ngaymua")
    , @NamedQuery(name = "FThucAn.findByThoigiancapnhat", query = "SELECT f FROM FThucAn f WHERE f.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "FThucAn.findByXoa", query = "SELECT f FROM FThucAn f WHERE f.xoa = :xoa")})
public class FThucAn implements Serializable {

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
    @Column(name = "gia")
    private int gia;
    @Column(name = "ngaymua")
    @Temporal(TemporalType.DATE)
    private Date ngaymua;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mathucan")
    private Collection<FCongThuc> fCongThucCollection;
    @JoinColumn(name = "maloai", referencedColumnName = "maso")
    @ManyToOne(optional = false)
    private FLoaiThucAn maloai;

    public FThucAn() {
    }

    public FThucAn(Integer maso) {
        this.maso = maso;
    }

    public FThucAn(Integer maso, String ten, int gia, boolean xoa) {
        this.maso = maso;
        this.ten = ten;
        this.gia = gia;
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

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public Date getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(Date ngaymua) {
        this.ngaymua = ngaymua;
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
    public Collection<FCongThuc> getFCongThucCollection() {
        return fCongThucCollection;
    }

    public void setFCongThucCollection(Collection<FCongThuc> fCongThucCollection) {
        this.fCongThucCollection = fCongThucCollection;
    }

    public FLoaiThucAn getMaloai() {
        return maloai;
    }

    public void setMaloai(FLoaiThucAn maloai) {
        this.maloai = maloai;
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
        if (!(object instanceof FThucAn)) {
            return false;
        }
        FThucAn other = (FThucAn) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.FThucAn[ maso=" + maso + " ]";
    }
    
}
