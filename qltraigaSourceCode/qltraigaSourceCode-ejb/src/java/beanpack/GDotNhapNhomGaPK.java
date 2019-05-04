/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanpack;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Baotiso Laptop
 */
@Embeddable
public class GDotNhapNhomGaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "madotnhap")
    private int madotnhap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "manhomga")
    private String manhomga;

    public GDotNhapNhomGaPK() {
    }

    public GDotNhapNhomGaPK(int madotnhap, String manhomga) {
        this.madotnhap = madotnhap;
        this.manhomga = manhomga;
    }

    public int getMadotnhap() {
        return madotnhap;
    }

    public void setMadotnhap(int madotnhap) {
        this.madotnhap = madotnhap;
    }

    public String getManhomga() {
        return manhomga;
    }

    public void setManhomga(String manhomga) {
        this.manhomga = manhomga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) madotnhap;
        hash += (manhomga != null ? manhomga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GDotNhapNhomGaPK)) {
            return false;
        }
        GDotNhapNhomGaPK other = (GDotNhapNhomGaPK) object;
        if (this.madotnhap != other.madotnhap) {
            return false;
        }
        if ((this.manhomga == null && other.manhomga != null) || (this.manhomga != null && !this.manhomga.equals(other.manhomga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.GDotNhapNhomGaPK[ madotnhap=" + madotnhap + ", manhomga=" + manhomga + " ]";
    }
    
}
