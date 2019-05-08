/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanpack;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Baotiso Laptop
 */
@Entity
@Table(name = "NCaiDat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NCaiDat.findAll", query = "SELECT n FROM NCaiDat n")
    , @NamedQuery(name = "NCaiDat.findByMaso", query = "SELECT n FROM NCaiDat n WHERE n.maso = :maso")
    , @NamedQuery(name = "NCaiDat.findByGiagacon", query = "SELECT n FROM NCaiDat n WHERE n.giagacon = :giagacon")
    , @NamedQuery(name = "NCaiDat.findByGiagadu", query = "SELECT n FROM NCaiDat n WHERE n.giagadu = :giagadu")
    , @NamedQuery(name = "NCaiDat.findByGiatrung", query = "SELECT n FROM NCaiDat n WHERE n.giatrung = :giatrung")})
public class NCaiDat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "maso")
    private Integer maso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "giagacon")
    private int giagacon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "giagadu")
    private int giagadu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "giatrung")
    private int giatrung;

    public NCaiDat() {
    }

    public NCaiDat(Integer maso) {
        this.maso = maso;
    }

    public NCaiDat(Integer maso, int giagacon, int giagadu, int giatrung) {
        this.maso = maso;
        this.giagacon = giagacon;
        this.giagadu = giagadu;
        this.giatrung = giatrung;
    }

    public Integer getMaso() {
        return maso;
    }

    public void setMaso(Integer maso) {
        this.maso = maso;
    }

    public int getGiagacon() {
        return giagacon;
    }

    public void setGiagacon(int giagacon) {
        this.giagacon = giagacon;
    }

    public int getGiagadu() {
        return giagadu;
    }

    public void setGiagadu(int giagadu) {
        this.giagadu = giagadu;
    }

    public int getGiatrung() {
        return giatrung;
    }

    public void setGiatrung(int giatrung) {
        this.giatrung = giatrung;
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
        if (!(object instanceof NCaiDat)) {
            return false;
        }
        NCaiDat other = (NCaiDat) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.NCaiDat[ maso=" + maso + " ]";
    }
    
}
