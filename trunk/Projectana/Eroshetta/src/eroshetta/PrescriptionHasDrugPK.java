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
public class PrescriptionHasDrugPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PRESCRIPTION_ID")
    private int prescriptionId;
    @Basic(optional = false)
    @Column(name = "DRUG_ID")
    private int drugId;

    public PrescriptionHasDrugPK() {
    }

    public PrescriptionHasDrugPK(int prescriptionId, int drugId) {
        this.prescriptionId = prescriptionId;
        this.drugId = drugId;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prescriptionId;
        hash += (int) drugId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrescriptionHasDrugPK)) {
            return false;
        }
        PrescriptionHasDrugPK other = (PrescriptionHasDrugPK) object;
        if (this.prescriptionId != other.prescriptionId) {
            return false;
        }
        if (this.drugId != other.drugId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.PrescriptionHasDrugPK[ prescriptionId=" + prescriptionId + ", drugId=" + drugId + " ]";
    }
    
}
