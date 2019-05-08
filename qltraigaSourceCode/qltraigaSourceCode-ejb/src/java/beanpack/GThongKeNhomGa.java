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
@Table(name = "GThongKeNhomGa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GThongKeNhomGa.findAll", query = "SELECT g FROM GThongKeNhomGa g")
    , @NamedQuery(name = "GThongKeNhomGa.findByThoidiemtk", query = "SELECT g FROM GThongKeNhomGa g WHERE g.thoidiemtk = :thoidiemtk")
    , @NamedQuery(name = "GThongKeNhomGa.findBySoluonggachet", query = "SELECT g FROM GThongKeNhomGa g WHERE g.soluonggachet = :soluonggachet")
    , @NamedQuery(name = "GThongKeNhomGa.findBySoluongconlai", query = "SELECT g FROM GThongKeNhomGa g WHERE g.soluongconlai = :soluongconlai")
    , @NamedQuery(name = "GThongKeNhomGa.findByThoigianxoa", query = "SELECT g FROM GThongKeNhomGa g WHERE g.thoigianxoa = :thoigianxoa")
    , @NamedQuery(name = "GThongKeNhomGa.findByXoa", query = "SELECT g FROM GThongKeNhomGa g WHERE g.xoa = :xoa")})
public class GThongKeNhomGa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoidiemtk")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoidiemtk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluonggachet")
    private int soluonggachet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluongconlai")
    private int soluongconlai;
    @Column(name = "thoigianxoa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigianxoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xoa")
    private boolean xoa;
    @JoinColumn(name = "manhomga", referencedColumnName = "manhom")
    @ManyToOne(optional = false)
    private GNhomGa manhomga;

    public GThongKeNhomGa() {
    }

    public GThongKeNhomGa(Date thoidiemtk) {
        this.thoidiemtk = thoidiemtk;
    }

    public GThongKeNhomGa(Date thoidiemtk, int soluonggachet, int soluongconlai, boolean xoa) {
        this.thoidiemtk = thoidiemtk;
        this.soluonggachet = soluonggachet;
        this.soluongconlai = soluongconlai;
        this.xoa = xoa;
    }

    public Date getThoidiemtk() {
        return thoidiemtk;
    }

    public void setThoidiemtk(Date thoidiemtk) {
        this.thoidiemtk = thoidiemtk;
    }

    public int getSoluonggachet() {
        return soluonggachet;
    }

    public void setSoluonggachet(int soluonggachet) {
        this.soluonggachet = soluonggachet;
    }

    public int getSoluongconlai() {
        return soluongconlai;
    }

    public void setSoluongconlai(int soluongconlai) {
        this.soluongconlai = soluongconlai;
    }

    public Date getThoigianxoa() {
        return thoigianxoa;
    }

    public void setThoigianxoa(Date thoigianxoa) {
        this.thoigianxoa = thoigianxoa;
    }

    public boolean getXoa() {
        return xoa;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
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
        hash += (thoidiemtk != null ? thoidiemtk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GThongKeNhomGa)) {
            return false;
        }
        GThongKeNhomGa other = (GThongKeNhomGa) object;
        if ((this.thoidiemtk == null && other.thoidiemtk != null) || (this.thoidiemtk != null && !this.thoidiemtk.equals(other.thoidiemtk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.GThongKeNhomGa[ thoidiemtk=" + thoidiemtk + " ]";
    }
    
}
