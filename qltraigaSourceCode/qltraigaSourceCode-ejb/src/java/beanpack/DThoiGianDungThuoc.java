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
@Table(name = "DThoiGianDungThuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DThoiGianDungThuoc.findAll", query = "SELECT d FROM DThoiGianDungThuoc d")
    , @NamedQuery(name = "DThoiGianDungThuoc.findByThoidiem", query = "SELECT d FROM DThoiGianDungThuoc d WHERE d.thoidiem = :thoidiem")
    , @NamedQuery(name = "DThoiGianDungThuoc.findBySoluongga", query = "SELECT d FROM DThoiGianDungThuoc d WHERE d.soluongga = :soluongga")
    , @NamedQuery(name = "DThoiGianDungThuoc.findByThoigiancapnhat", query = "SELECT d FROM DThoiGianDungThuoc d WHERE d.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "DThoiGianDungThuoc.findByXoa", query = "SELECT d FROM DThoiGianDungThuoc d WHERE d.xoa = :xoa")})
public class DThoiGianDungThuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoidiem")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoidiem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluongga")
    private int soluongga;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @JoinColumn(name = "madonthuoc", referencedColumnName = "maso")
    @ManyToOne(optional = false)
    private DDonThuoc madonthuoc;
    @JoinColumn(name = "manhom", referencedColumnName = "manhom")
    @ManyToOne
    private GNhomGa manhom;
    @JoinColumn(name = "manongho", referencedColumnName = "manongho")
    @ManyToOne
    private HNongHoGa manongho;

    public DThoiGianDungThuoc() {
    }

    public DThoiGianDungThuoc(Date thoidiem) {
        this.thoidiem = thoidiem;
    }

    public DThoiGianDungThuoc(Date thoidiem, int soluongga, boolean xoa) {
        this.thoidiem = thoidiem;
        this.soluongga = soluongga;
        this.xoa = xoa;
    }

    public Date getThoidiem() {
        return thoidiem;
    }

    public void setThoidiem(Date thoidiem) {
        this.thoidiem = thoidiem;
    }

    public int getSoluongga() {
        return soluongga;
    }

    public void setSoluongga(int soluongga) {
        this.soluongga = soluongga;
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

    public DDonThuoc getMadonthuoc() {
        return madonthuoc;
    }

    public void setMadonthuoc(DDonThuoc madonthuoc) {
        this.madonthuoc = madonthuoc;
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
        hash += (thoidiem != null ? thoidiem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DThoiGianDungThuoc)) {
            return false;
        }
        DThoiGianDungThuoc other = (DThoiGianDungThuoc) object;
        if ((this.thoidiem == null && other.thoidiem != null) || (this.thoidiem != null && !this.thoidiem.equals(other.thoidiem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.DThoiGianDungThuoc[ thoidiem=" + thoidiem + " ]";
    }
    
}
