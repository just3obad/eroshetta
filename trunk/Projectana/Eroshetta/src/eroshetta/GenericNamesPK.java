/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eroshetta;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Administrator
 */
@Embeddable
public class GenericNamesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DRUG_ID")
    private int drugId;
    @Basic(optional = false)
    @Column(name = "GENERIC_NAME")
    private String genericName;

    public GenericNamesPK() {
    }

    public GenericNamesPK(int drugId, String genericName) {
        this.drugId = drugId;
        this.genericName = genericName;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) drugId;
        hash += (genericName != null ? genericName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenericNamesPK)) {
            return false;
        }
        GenericNamesPK other = (GenericNamesPK) object;
        if (this.drugId != other.drugId) {
            return false;
        }
        if ((this.genericName == null && other.genericName != null) || (this.genericName != null && !this.genericName.equals(other.genericName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.GenericNamesPK[ drugId=" + drugId + ", genericName=" + genericName + " ]";
    }
    
}
