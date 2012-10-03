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
@Table(name = "DRUG_TIMES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DrugTimes.findAll", query = "SELECT d FROM DrugTimes d"),
    @NamedQuery(name = "DrugTimes.findByPrescriptionId", query = "SELECT d FROM DrugTimes d WHERE d.drugTimesPK.prescriptionId = :prescriptionId"),
    @NamedQuery(name = "DrugTimes.findByDrugDuration", query = "SELECT d FROM DrugTimes d WHERE d.drugDuration = :drugDuration"),
    @NamedQuery(name = "DrugTimes.findByDrugId", query = "SELECT d FROM DrugTimes d WHERE d.drugTimesPK.drugId = :drugId"),
    @NamedQuery(name = "DrugTimes.findByDrugTime", query = "SELECT d FROM DrugTimes d WHERE d.drugTime = :drugTime")})
public class DrugTimes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DrugTimesPK drugTimesPK;
    @Column(name = "DRUG_TIME")
    private String drugTime;
    @Column(name = "DRUG_DURATION")
    private String drugDuration;
    @JoinColumn(name = "PRESCRIPTION_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prescriptions prescriptions;
    @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Drugs drugs;

    public DrugTimes() {
    }

    public DrugTimes(DrugTimesPK drugTimesPK) {
        this.drugTimesPK = drugTimesPK;
    }

    public DrugTimes(int prescriptionId, int drugId) {
        this.drugTimesPK = new DrugTimesPK(prescriptionId, drugId);
    }

    public DrugTimesPK getDrugTimesPK() {
        return drugTimesPK;
    }

    public void setDrugTimesPK(DrugTimesPK drugTimesPK) {
        this.drugTimesPK = drugTimesPK;
    }

    public String getDrugTime() {
        return drugTime;
    }

    public void setDrugTime(String drugTime) {
        this.drugTime = drugTime;
    }
    public String getDrugDuration() {
        return drugDuration;
    }

    public void setDrugDuration(String drugDuration) {
        this.drugDuration = drugDuration ;
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
        hash += (drugTimesPK != null ? drugTimesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrugTimes)) {
            return false;
        }
        DrugTimes other = (DrugTimes) object;
        if ((this.drugTimesPK == null && other.drugTimesPK != null) || (this.drugTimesPK != null && !this.drugTimesPK.equals(other.drugTimesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.DrugTimes[ drugTimesPK=" + drugTimesPK + " ]";
    }
    
}
