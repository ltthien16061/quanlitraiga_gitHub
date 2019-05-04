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

/**
 *
 * @author Baotiso Laptop
 */
@Embeddable
public class HKhayApDotTrungPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "makhay")
    private int makhay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "madot")
    private int madot;

    public HKhayApDotTrungPK() {
    }

    public HKhayApDotTrungPK(int makhay, int madot) {
        this.makhay = makhay;
        this.madot = madot;
    }

    public int getMakhay() {
        return makhay;
    }

    public void setMakhay(int makhay) {
        this.makhay = makhay;
    }

    public int getMadot() {
        return madot;
    }

    public void setMadot(int madot) {
        this.madot = madot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) makhay;
        hash += (int) madot;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKhayApDotTrungPK)) {
            return false;
        }
        HKhayApDotTrungPK other = (HKhayApDotTrungPK) object;
        if (this.makhay != other.makhay) {
            return false;
        }
        if (this.madot != other.madot) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanpack.HKhayApDotTrungPK[ makhay=" + makhay + ", madot=" + madot + " ]";
    }
    
}
