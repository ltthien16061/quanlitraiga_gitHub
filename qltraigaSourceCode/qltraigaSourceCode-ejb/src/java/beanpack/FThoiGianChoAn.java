/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanpack;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Baotiso Laptop
 */
@Entity
@Table(name = "FThoiGianChoAn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FThoiGianChoAn.findAll", query = "SELECT f FROM FThoiGianChoAn f")
    , @NamedQuery(name = "FThoiGianChoAn.findByMaso", query = "SELECT f FROM FThoiGianChoAn f WHERE f.maso = :maso")
    , @NamedQuery(name = "FThoiGianChoAn.findByThoidiem", query = "SELECT f FROM FThoiGianChoAn f WHERE f.thoidiem = :thoidiem")
    , @NamedQuery(name = "FThoiGianChoAn.findByKhauphan", query = "SELECT f FROM FThoiGianChoAn f WHERE f.khauphan = :khauphan")
    , @NamedQuery(name = "FThoiGianChoAn.findByThoigiancapnhat", query = "SELECT f FROM FThoiGianChoAn f WHERE f.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "FThoiGianChoAn.findByXoa", query = "SELECT f FROM FThoiGianChoAn f WHERE f.xoa = :xoa")})
public class FThoiGianChoAn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //Custom by Thien
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maso")
    private Integer maso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoidiem")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoidiem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "khauphan")
    private int khauphan;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @JoinColumn(name = "macongthuc", referencedColumnName = "maso")
    @ManyToOne(optional = false)
    private FCongThuc macongthuc;
    @JoinColumn(name = "manhom", referencedColumnName = "manhom")
    @ManyToOne
    private GNhomGa manhom;
    @JoinColumn(name = "manongho", referencedColumnName = "manongho")
    @ManyToOne
    private HNongHoGa manongho;

    public FThoiGianChoAn() {
    }

    public FThoiGianChoAn(Integer maso) {
        this.maso = maso;
    }

    public FThoiGianChoAn(Integer maso,Date thoidiem, int khauphan, boolean xoa) {
        this.maso = maso;
        this.thoidiem = thoidiem;
        this.khauphan = khauphan;
        this.xoa = xoa;
    }
    public Integer getMaso() {
        return maso;
    }

    public void setMaso(Integer maso) {
        this.maso = maso;
    }

    public Date getThoidiem() {
        return thoidiem;
    }

    public void setThoidiem(Date thoidiem) {
        this.thoidiem = thoidiem;
    }

    public int getKhauphan() {
        return khauphan;
    }

    public void setKhauphan(int khauphan) {
        this.khauphan = khauphan;
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

    public FCongThuc getMacongthuc() {
        return macongthuc;
    }

    public void setMacongthuc(FCongThuc macongthuc) {
        this.macongthuc = macongthuc;
    }

    public GNhomGa getManhom() {
        return manhom;
    }

    public void setManhom(GNhomGa manhom) {
        this.manhom = manhom;
    }

    public HNongHoGa getManongho() {
        return manongho;
    }

    public void setManongho(HNongHoGa manongho) {
        this.manongho = manongho;
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
        if (!(object instanceof FThoiGianChoAn)) {
            return false;
        }
        FThoiGianChoAn other = (FThoiGianChoAn) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.FThoiGianChoAn[ maso=" + maso + " ]";
    }
    
}
