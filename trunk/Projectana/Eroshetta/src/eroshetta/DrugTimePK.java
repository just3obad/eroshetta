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
 * @author Mouaz
 */
@Embeddable
public class DrugTimePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PATIENT_ID", nullable = false)
    private int patientId;
    @Basic(optional = false)
    @Column(name = "PRESCRIPTION_ID", nullable = false)
    private int prescriptionId;
    @Basic(optional = false)
    @Column(name = "DRUG_ID", nullable = false)
    private int drugId;

    public DrugTimePK() {
    }

    public DrugTimePK(int patientId, int prescriptionId, int drugId) {
        this.patientId = patientId;
        this.prescriptionId = prescriptionId;
        this.drugId = drugId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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
        hash += (int) patientId;
        hash += (int) prescriptionId;
        hash += (int) drugId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrugTimePK)) {
            return false;
        }
        DrugTimePK other = (DrugTimePK) object;
        if (this.patientId != other.patientId) {
            return false;
        }
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
        return "eroshetta.DrugTimePK[ patientId=" + patientId + ", prescriptionId=" + prescriptionId + ", drugId=" + drugId + " ]";
    }
    
}
