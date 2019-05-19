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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Baotiso Laptop
 */
@Entity
@Table(name = "FCongThuc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FCongThuc.findAll", query = "SELECT f FROM FCongThuc f")
    , @NamedQuery(name = "FCongThuc.findByMaso", query = "SELECT f FROM FCongThuc f WHERE f.maso = :maso")
    , @NamedQuery(name = "FCongThuc.findBySlthucan", query = "SELECT f FROM FCongThuc f WHERE f.slthucan = :slthucan")
    , @NamedQuery(name = "FCongThuc.findBySlvitamin", query = "SELECT f FROM FCongThuc f WHERE f.slvitamin = :slvitamin")
    , @NamedQuery(name = "FCongThuc.findByMota", query = "SELECT f FROM FCongThuc f WHERE f.mota = :mota")
    , @NamedQuery(name = "FCongThuc.findByThoigiancapnhat", query = "SELECT f FROM FCongThuc f WHERE f.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "FCongThuc.findByXoa", query = "SELECT f FROM FCongThuc f WHERE f.xoa = :xoa")})
public class FCongThuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id  
    //Custom by Thien
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maso")
    private Integer maso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "slthucan")
    private int slthucan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "slvitamin")
    private int slvitamin;
    @Size(max = 250)
    @Column(name = "mota")
    private String mota;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @JoinColumn(name = "mathucan", referencedColumnName = "maso")
    @ManyToOne(optional = false)
    private FThucAn mathucan;
    @JoinColumn(name = "mavitamin", referencedColumnName = "maso")
    @ManyToOne(optional = false)
    private FVitamin mavitamin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "macongthuc")
    private Collection<FThoiGianChoAn> fThoiGianChoAnCollection;

    public FCongThuc() {
    }

    public FCongThuc(Integer maso) {
        this.maso = maso;
    }

    public FCongThuc(Integer maso, int slthucan, int slvitamin, boolean xoa) {
        this.maso = maso;
        this.slthucan = slthucan;
        this.slvitamin = slvitamin;
        this.xoa = xoa;
    }

    public Integer getMaso() {
        return maso;
    }

    public void setMaso(Integer maso) {
        this.maso = maso;
    }

    public int getSlthucan() {
        return slthucan;
    }

    public void setSlthucan(int slthucan) {
        this.slthucan = slthucan;
    }

    public int getSlvitamin() {
        return slvitamin;
    }

    public void setSlvitamin(int slvitamin) {
        this.slvitamin = slvitamin;
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

    public FThucAn getMathucan() {
        return mathucan;
    }

    public void setMathucan(FThucAn mathucan) {
        this.mathucan = mathucan;
    }

    public FVitamin getMavitamin() {
        return mavitamin;
    }

    public void setMavitamin(FVitamin mavitamin) {
        this.mavitamin = mavitamin;
    }

    @XmlTransient
    public Collection<FThoiGianChoAn> getFThoiGianChoAnCollection() {
        return fThoiGianChoAnCollection;
    }

    public void setFThoiGianChoAnCollection(Collection<FThoiGianChoAn> fThoiGianChoAnCollection) {
        this.fThoiGianChoAnCollection = fThoiGianChoAnCollection;
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
        if (!(object instanceof FCongThuc)) {
            return false;
        }
        FCongThuc other = (FCongThuc) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.FCongThuc[ maso=" + maso + " ]";
    }
    
}
