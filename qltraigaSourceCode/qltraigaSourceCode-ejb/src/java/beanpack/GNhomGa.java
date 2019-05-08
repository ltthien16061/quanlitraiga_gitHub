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
import javax.persistence.OneToOne;
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
@Table(name = "GNhomGa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GNhomGa.findAll", query = "SELECT g FROM GNhomGa g")
    , @NamedQuery(name = "GNhomGa.findByManhom", query = "SELECT g FROM GNhomGa g WHERE g.manhom = :manhom")
    , @NamedQuery(name = "GNhomGa.findBySoluongbandau", query = "SELECT g FROM GNhomGa g WHERE g.soluongbandau = :soluongbandau")
    , @NamedQuery(name = "GNhomGa.findBySoluonghientai", query = "SELECT g FROM GNhomGa g WHERE g.soluonghientai = :soluonghientai")
    , @NamedQuery(name = "GNhomGa.findByTinhtrang", query = "SELECT g FROM GNhomGa g WHERE g.tinhtrang = :tinhtrang")
    , @NamedQuery(name = "GNhomGa.findByThoigianchianhom", query = "SELECT g FROM GNhomGa g WHERE g.thoigianchianhom = :thoigianchianhom")
    , @NamedQuery(name = "GNhomGa.findByThoigiancapnhat", query = "SELECT g FROM GNhomGa g WHERE g.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "GNhomGa.findByXoa", query = "SELECT g FROM GNhomGa g WHERE g.xoa = :xoa")})
public class GNhomGa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "manhom")
    private String manhom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluongbandau")
    private int soluongbandau;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluonghientai")
    private int soluonghientai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tinhtrang")
    private boolean tinhtrang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigianchianhom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigianchianhom;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gNhomGa")
    private Collection<GDanGhep> gDanGhepCollection;
    @OneToMany(mappedBy = "manhom")
    private Collection<FThoiGianChoAn> fThoiGianChoAnCollection;
    @OneToMany(mappedBy = "manhom")
    private Collection<DThoiGianDungThuoc> dThoiGianDungThuocCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "manhomga")
    private NThongKeGaDu nThongKeGaDu;
    @JoinColumn(name = "madotnhap", referencedColumnName = "maso")
    @ManyToOne(optional = false)
    private GDotNhapGaGiong madotnhap;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manhomga")
    private Collection<GThongKeNhomGa> gThongKeNhomGaCollection;

    public GNhomGa() {
    }

    public GNhomGa(String manhom) {
        this.manhom = manhom;
    }

    public GNhomGa(String manhom, int soluongbandau, int soluonghientai, boolean tinhtrang, Date thoigianchianhom, boolean xoa) {
        this.manhom = manhom;
        this.soluongbandau = soluongbandau;
        this.soluonghientai = soluonghientai;
        this.tinhtrang = tinhtrang;
        this.thoigianchianhom = thoigianchianhom;
        this.xoa = xoa;
    }

    public String getManhom() {
        return manhom;
    }

    public void setManhom(String manhom) {
        this.manhom = manhom;
    }

    public int getSoluongbandau() {
        return soluongbandau;
    }

    public void setSoluongbandau(int soluongbandau) {
        this.soluongbandau = soluongbandau;
    }

    public int getSoluonghientai() {
        return soluonghientai;
    }

    public void setSoluonghientai(int soluonghientai) {
        this.soluonghientai = soluonghientai;
    }

    public boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public Date getThoigianchianhom() {
        return thoigianchianhom;
    }

    public void setThoigianchianhom(Date thoigianchianhom) {
        this.thoigianchianhom = thoigianchianhom;
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

    public NThongKeGaDu getNThongKeGaDu() {
        return nThongKeGaDu;
    }

    public void setNThongKeGaDu(NThongKeGaDu nThongKeGaDu) {
        this.nThongKeGaDu = nThongKeGaDu;
    }

    public GDotNhapGaGiong getMadotnhap() {
        return madotnhap;
    }

    public void setMadotnhap(GDotNhapGaGiong madotnhap) {
        this.madotnhap = madotnhap;
    }

    @XmlTransient
    public Collection<GThongKeNhomGa> getGThongKeNhomGaCollection() {
        return gThongKeNhomGaCollection;
    }

    public void setGThongKeNhomGaCollection(Collection<GThongKeNhomGa> gThongKeNhomGaCollection) {
        this.gThongKeNhomGaCollection = gThongKeNhomGaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manhom != null ? manhom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GNhomGa)) {
            return false;
        }
        GNhomGa other = (GNhomGa) object;
        if ((this.manhom == null && other.manhom != null) || (this.manhom != null && !this.manhom.equals(other.manhom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.GNhomGa[ manhom=" + manhom + " ]";
    }
    
}
