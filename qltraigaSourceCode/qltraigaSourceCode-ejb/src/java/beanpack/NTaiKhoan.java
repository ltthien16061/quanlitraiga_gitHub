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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Baotiso Laptop
 */
@Entity
@Table(name = "NTaiKhoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NTaiKhoan.findAll", query = "SELECT n FROM NTaiKhoan n")
    , @NamedQuery(name = "NTaiKhoan.findByMaso", query = "SELECT n FROM NTaiKhoan n WHERE n.maso = :maso")
    , @NamedQuery(name = "NTaiKhoan.findByTentk", query = "SELECT n FROM NTaiKhoan n WHERE n.tentk = :tentk")
    , @NamedQuery(name = "NTaiKhoan.findByMatkhau", query = "SELECT n FROM NTaiKhoan n WHERE n.matkhau = :matkhau")})
public class NTaiKhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "maso")
    private Integer maso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tentk")
    private String tentk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "matkhau")
    private String matkhau;

    public NTaiKhoan() {
    }

    public NTaiKhoan(Integer maso) {
        this.maso = maso;
    }

    public NTaiKhoan(Integer maso, String tentk, String matkhau) {
        this.maso = maso;
        this.tentk = tentk;
        this.matkhau = matkhau;
    }

    public Integer getMaso() {
        return maso;
    }

    public void setMaso(Integer maso) {
        this.maso = maso;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
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
        if (!(object instanceof NTaiKhoan)) {
            return false;
        }
        NTaiKhoan other = (NTaiKhoan) object;
        if ((this.maso == null && other.maso != null) || (this.maso != null && !this.maso.equals(other.maso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.NTaiKhoan[ maso=" + maso + " ]";
    }
    
}
