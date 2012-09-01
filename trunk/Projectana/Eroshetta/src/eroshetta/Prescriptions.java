/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eroshetta;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mouaz
 */
@Entity
@Table(name = "PRESCRIPTIONS", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescriptions.findAll", query = "SELECT p FROM Prescriptions p"),
    @NamedQuery(name = "Prescriptions.findById", query = "SELECT p FROM Prescriptions p WHERE p.id = :id"),
    @NamedQuery(name = "Prescriptions.findByDate", query = "SELECT p FROM Prescriptions p WHERE p.date = :date"),
    @NamedQuery(name = "Prescriptions.findByNotes", query = "SELECT p FROM Prescriptions p WHERE p.notes = :notes")})
public class Prescriptions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "NOTES", length = 100)
    private String notes;
    @ManyToMany(mappedBy = "prescriptionsCollection")
    private Collection<Drugs> drugsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prescriptions")
    private Collection<DrugTime> drugTimeCollection;
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Patients patientId;

    public Prescriptions() {
    }

    public Prescriptions(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @XmlTransient
    public Collection<Drugs> getDrugsCollection() {
        return drugsCollection;
    }

    public void setDrugsCollection(Collection<Drugs> drugsCollection) {
        this.drugsCollection = drugsCollection;
    }

    @XmlTransient
    public Collection<DrugTime> getDrugTimeCollection() {
        return drugTimeCollection;
    }

    public void setDrugTimeCollection(Collection<DrugTime> drugTimeCollection) {
        this.drugTimeCollection = drugTimeCollection;
    }

    public Patients getPatientId() {
        return patientId;
    }

    public void setPatientId(Patients patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescriptions)) {
            return false;
        }
        Prescriptions other = (Prescriptions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.Prescriptions[ id=" + id + " ]";
    }
    
}
