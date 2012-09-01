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
 * @author Mouaz
 */
@Entity
@Table(name = "DRUG_TIME", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DrugTime.findAll", query = "SELECT d FROM DrugTime d"),
    @NamedQuery(name = "DrugTime.findByPatientId", query = "SELECT d FROM DrugTime d WHERE d.drugTimePK.patientId = :patientId"),
    @NamedQuery(name = "DrugTime.findByPrescriptionId", query = "SELECT d FROM DrugTime d WHERE d.drugTimePK.prescriptionId = :prescriptionId"),
    @NamedQuery(name = "DrugTime.findByDrugId", query = "SELECT d FROM DrugTime d WHERE d.drugTimePK.drugId = :drugId"),
    @NamedQuery(name = "DrugTime.findByDrugTime", query = "SELECT d FROM DrugTime d WHERE d.drugTime = :drugTime")})
public class DrugTime implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DrugTimePK drugTimePK;
    @Column(name = "DRUG_TIME", length = 40)
    private String drugTime;
    @JoinColumn(name = "PRESCRIPTION_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prescriptions prescriptions;
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Patients patients;
    @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Drugs drugs;

    public DrugTime() {
    }

    public DrugTime(DrugTimePK drugTimePK) {
        this.drugTimePK = drugTimePK;
    }

    public DrugTime(int patientId, int prescriptionId, int drugId) {
        this.drugTimePK = new DrugTimePK(patientId, prescriptionId, drugId);
    }

    public DrugTimePK getDrugTimePK() {
        return drugTimePK;
    }

    public void setDrugTimePK(DrugTimePK drugTimePK) {
        this.drugTimePK = drugTimePK;
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

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
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
        hash += (drugTimePK != null ? drugTimePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrugTime)) {
            return false;
        }
        DrugTime other = (DrugTime) object;
        if ((this.drugTimePK == null && other.drugTimePK != null) || (this.drugTimePK != null && !this.drugTimePK.equals(other.drugTimePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.DrugTime[ drugTimePK=" + drugTimePK + " ]";
    }
    
}
