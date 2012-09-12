/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eroshetta;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "PRESCRIPTION_HAS_DRUG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrescriptionHasDrug.findAll", query = "SELECT p FROM PrescriptionHasDrug p"),
    @NamedQuery(name = "PrescriptionHasDrug.findByPrescriptionId", query = "SELECT p FROM PrescriptionHasDrug p WHERE p.prescriptionHasDrugPK.prescriptionId = :prescriptionId"),
    @NamedQuery(name = "PrescriptionHasDrug.findByDrugId", query = "SELECT p FROM PrescriptionHasDrug p WHERE p.prescriptionHasDrugPK.drugId = :drugId"),
    @NamedQuery(name = "PrescriptionHasDrug.findByDrugTime", query = "SELECT p FROM PrescriptionHasDrug p WHERE p.drugTime = :drugTime")})
public class PrescriptionHasDrug implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrescriptionHasDrugPK prescriptionHasDrugPK;
    @Column(name = "DRUG_TIME")
    private String drugTime;
    @JoinColumn(name = "PRESCRIPTION_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prescriptions prescriptions;
    @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Drugs drugs;

    public PrescriptionHasDrug() {
    }

    public PrescriptionHasDrug(PrescriptionHasDrugPK prescriptionHasDrugPK) {
        this.prescriptionHasDrugPK = prescriptionHasDrugPK;
    }

    public PrescriptionHasDrug(int prescriptionId, int drugId) {
        this.prescriptionHasDrugPK = new PrescriptionHasDrugPK(prescriptionId, drugId);
    }

    public PrescriptionHasDrugPK getPrescriptionHasDrugPK() {
        return prescriptionHasDrugPK;
    }

    public void setPrescriptionHasDrugPK(PrescriptionHasDrugPK prescriptionHasDrugPK) {
        this.prescriptionHasDrugPK = prescriptionHasDrugPK;
    }

    public String getDrugTime() {
        return drugTime;
    }

    public void setDrugTime(String drugTime) {
        this.drugTime = drugTime;
    }

    public Prescriptions getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Prescriptions prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Drugs getDrugs() {
        return drugs;
    }

    public void setDrugs(Drugs drugs) {
        this.drugs = drugs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prescriptionHasDrugPK != null ? prescriptionHasDrugPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrescriptionHasDrug)) {
            return false;
        }
        PrescriptionHasDrug other = (PrescriptionHasDrug) object;
        if ((this.prescriptionHasDrugPK == null && other.prescriptionHasDrugPK != null) || (this.prescriptionHasDrugPK != null && !this.prescriptionHasDrugPK.equals(other.prescriptionHasDrugPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.PrescriptionHasDrug[ prescriptionHasDrugPK=" + prescriptionHasDrugPK + " ]";
    }
    
}
