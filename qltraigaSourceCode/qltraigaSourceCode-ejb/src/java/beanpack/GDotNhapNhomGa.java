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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "GDotNhapNhomGa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GDotNhapNhomGa.findAll", query = "SELECT g FROM GDotNhapNhomGa g")
    , @NamedQuery(name = "GDotNhapNhomGa.findByMadotnhap", query = "SELECT g FROM GDotNhapNhomGa g WHERE g.gDotNhapNhomGaPK.madotnhap = :madotnhap")
    , @NamedQuery(name = "GDotNhapNhomGa.findByManhomga", query = "SELECT g FROM GDotNhapNhomGa g WHERE g.gDotNhapNhomGaPK.manhomga = :manhomga")
    , @NamedQuery(name = "GDotNhapNhomGa.findBySoluong", query = "SELECT g FROM GDotNhapNhomGa g WHERE g.soluong = :soluong")
    , @NamedQuery(name = "GDotNhapNhomGa.findByThoigianghep", query = "SELECT g FROM GDotNhapNhomGa g WHERE g.thoigianghep = :thoigianghep")})
public class GDotNhapNhomGa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GDotNhapNhomGaPK gDotNhapNhomGaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluong")
    private int soluong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigianghep")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigianghep;
    @JoinColumn(name = "madotnhap", referencedColumnName = "maso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GDotNhapGaGiong gDotNhapGaGiong;
    @JoinColumn(name = "manhomga", referencedColumnName = "manhom", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GNhomGa gNhomGa;

    public GDotNhapNhomGa() {
    }

    public GDotNhapNhomGa(GDotNhapNhomGaPK gDotNhapNhomGaPK) {
        this.gDotNhapNhomGaPK = gDotNhapNhomGaPK;
    }

    public GDotNhapNhomGa(GDotNhapNhomGaPK gDotNhapNhomGaPK, int soluong, Date thoigianghep) {
        this.gDotNhapNhomGaPK = gDotNhapNhomGaPK;
        this.soluong = soluong;
        this.thoigianghep = thoigianghep;
    }

    public GDotNhapNhomGa(int madotnhap, String manhomga) {
        this.gDotNhapNhomGaPK = new GDotNhapNhomGaPK(madotnhap, manhomga);
    }

    public GDotNhapNhomGaPK getGDotNhapNhomGaPK() {
        return gDotNhapNhomGaPK;
    }

    public void setGDotNhapNhomGaPK(GDotNhapNhomGaPK gDotNhapNhomGaPK) {
        this.gDotNhapNhomGaPK = gDotNhapNhomGaPK;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getThoigianghep() {
        return thoigianghep;
    }

    public void setThoigianghep(Date thoigianghep) {
        this.thoigianghep = thoigianghep;
    }

    public GDotNhapGaGiong getGDotNhapGaGiong() {
        return gDotNhapGaGiong;
    }

    public void setGDotNhapGaGiong(GDotNhapGaGiong gDotNhapGaGiong) {
        this.gDotNhapGaGiong = gDotNhapGaGiong;
    }

    public GNhomGa getGNhomGa() {
        return gNhomGa;
    }

    public void setGNhomGa(GNhomGa gNhomGa) {
        this.gNhomGa = gNhomGa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gDotNhapNhomGaPK != null ? gDotNhapNhomGaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GDotNhapNhomGa)) {
            return false;
        }
        GDotNhapNhomGa other = (GDotNhapNhomGa) object;
        if ((this.gDotNhapNhomGaPK == null && other.gDotNhapNhomGaPK != null) || (this.gDotNhapNhomGaPK != null && !this.gDotNhapNhomGaPK.equals(other.gDotNhapNhomGaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.GDotNhapNhomGa[ gDotNhapNhomGaPK=" + gDotNhapNhomGaPK + " ]";
    }
    
}
