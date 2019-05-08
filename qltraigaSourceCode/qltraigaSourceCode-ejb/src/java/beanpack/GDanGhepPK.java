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
public class GDanGhepPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "manhomga")
    private String manhomga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "manongho")
    private String manongho;

    public GDanGhepPK() {
    }

    public GDanGhepPK(String manhomga, String manongho) {
        this.manhomga = manhomga;
        this.manongho = manongho;
    }

    public String getManhomga() {
        return manhomga;
    }

    public void setManhomga(String manhomga) {
        this.manhomga = manhomga;
    }

    public String getManongho() {
        return manongho;
    }

    public void setManongho(String manongho) {
        this.manongho = manongho;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manhomga != null ? manhomga.hashCode() : 0);
        hash += (manongho != null ? manongho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GDanGhepPK)) {
            return false;
        }
        GDanGhepPK other = (GDanGhepPK) object;
        if ((this.manhomga == null && other.manhomga != null) || (this.manhomga != null && !this.manhomga.equals(other.manhomga))) {
            return false;
        }
        if ((this.manongho == null && other.manongho != null) || (this.manongho != null && !this.manongho.equals(other.manongho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.GDanGhepPK[ manhomga=" + manhomga + ", manongho=" + manongho + " ]";
    }
    
}
