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
@Table(name = "GDanGhep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GDanGhep.findAll", query = "SELECT g FROM GDanGhep g")
    , @NamedQuery(name = "GDanGhep.findByManhomga", query = "SELECT g FROM GDanGhep g WHERE g.gDanGhepPK.manhomga = :manhomga")
    , @NamedQuery(name = "GDanGhep.findByManongho", query = "SELECT g FROM GDanGhep g WHERE g.gDanGhepPK.manongho = :manongho")
    , @NamedQuery(name = "GDanGhep.findByThoidiemghep", query = "SELECT g FROM GDanGhep g WHERE g.thoidiemghep = :thoidiemghep")
    , @NamedQuery(name = "GDanGhep.findByThoigiancapnhat", query = "SELECT g FROM GDanGhep g WHERE g.thoigiancapnhat = :thoigiancapnhat")
    , @NamedQuery(name = "GDanGhep.findByXoa", query = "SELECT g FROM GDanGhep g WHERE g.xoa = :xoa")})
public class GDanGhep implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GDanGhepPK gDanGhepPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoidiemghep")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoidiemghep;
    @Column(name = "thoigiancapnhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiancapnhat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @JoinColumn(name = "manhomga", referencedColumnName = "manhom", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GNhomGa gNhomGa;
    @JoinColumn(name = "manongho", referencedColumnName = "manongho", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HNongHoGa hNongHoGa;

    public GDanGhep() {
    }

    public GDanGhep(GDanGhepPK gDanGhepPK) {
        this.gDanGhepPK = gDanGhepPK;
    }

    public GDanGhep(GDanGhepPK gDanGhepPK, Date thoidiemghep, boolean xoa) {
        this.gDanGhepPK = gDanGhepPK;
        this.thoidiemghep = thoidiemghep;
        this.xoa = xoa;
    }

    public GDanGhep(String manhomga, String manongho) {
        this.gDanGhepPK = new GDanGhepPK(manhomga, manongho);
    }

    public GDanGhepPK getGDanGhepPK() {
        return gDanGhepPK;
    }

    public void setGDanGhepPK(GDanGhepPK gDanGhepPK) {
        this.gDanGhepPK = gDanGhepPK;
    }

    public Date getThoidiemghep() {
        return thoidiemghep;
    }

    public void setThoidiemghep(Date thoidiemghep) {
        this.thoidiemghep = thoidiemghep;
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

    public GNhomGa getGNhomGa() {
        return gNhomGa;
    }

    public void setGNhomGa(GNhomGa gNhomGa) {
        this.gNhomGa = gNhomGa;
    }

    public HNongHoGa getHNongHoGa() {
        return hNongHoGa;
    }

    public void setHNongHoGa(HNongHoGa hNongHoGa) {
        this.hNongHoGa = hNongHoGa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gDanGhepPK != null ? gDanGhepPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GDanGhep)) {
            return false;
        }
        GDanGhep other = (GDanGhep) object;
        if ((this.gDanGhepPK == null && other.gDanGhepPK != null) || (this.gDanGhepPK != null && !this.gDanGhepPK.equals(other.gDanGhepPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.GDanGhep[ gDanGhepPK=" + gDanGhepPK + " ]";
    }
    
}
