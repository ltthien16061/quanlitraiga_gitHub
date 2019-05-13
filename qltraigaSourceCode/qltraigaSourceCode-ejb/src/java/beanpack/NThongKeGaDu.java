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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "NThongKeGaDu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NThongKeGaDu.findAll", query = "SELECT n FROM NThongKeGaDu n")
    , @NamedQuery(name = "NThongKeGaDu.findByMaso", query = "SELECT n FROM NThongKeGaDu n WHERE n.maso = :maso")
    , @NamedQuery(name = "NThongKeGaDu.findBySogadu", query = "SELECT n FROM NThongKeGaDu n WHERE n.sogadu = :sogadu")
    , @NamedQuery(name = "NThongKeGaDu.findByThoigiantk", query = "SELECT n FROM NThongKeGaDu n WHERE n.thoigiantk = :thoigiantk")})
public class NThongKeGaDu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
     //Custom by Thien
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maso")
    private Integer maso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sogadu")
    private int sogadu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigiantk")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigiantk;
    @JoinColumn(name = "manhomga", referencedColumnName = "manhom")
    @OneToOne(optional = false)
    private GNhomGa manhomga;

    public NThongKeGaDu() {
    }

    public NThongKeGaDu(Integer maso) {
        this.maso = maso;
    }

    public NThongKeGaDu(Integer maso, int sogadu, Date thoigiantk) {
        this.maso = maso;
        this.sogadu = sogadu;
        this.thoigiantk = thoigiantk;
    }

    public Integer getMaso() {
        return maso;
    }

    public void setMaso(Integer maso) {
        this.maso = maso;
    }

    public int getSogadu() {
        return sogadu;
    }

    public void setSogadu(int sogadu) {
        this.sogadu = sogadu;
    }

    public Date getThoigiantk() {
        return thoigiantk;
    }

    public void setThoigiantk(Date thoigiantk) {
        this.thoigiantk = thoigiantk;
    }

    public GNhomGa getManhomga() {
        return manhomga;
    }

    public void setManhomga(GNhomGa manhomga) {
        this.manhomga = manhomga;
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
        if (!(object instanceof NThongKeGaDu)) {
            return false;
        }
        NThongKeGaDu other = (NThongKeGaDu) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.NThongKeGaDu[ maso=" + maso + " ]";
    }
    
}
