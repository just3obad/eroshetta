/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eroshetta;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mouaz
 */
@Entity
@Table(name = "DIAGNOSES", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnoses.findAll", query = "SELECT d FROM Diagnoses d"),
    @NamedQuery(name = "Diagnoses.findById", query = "SELECT d FROM Diagnoses d WHERE d.id = :id"),
    @NamedQuery(name = "Diagnoses.findByName", query = "SELECT d FROM Diagnoses d WHERE d.name = :name"),
    @NamedQuery(name = "Diagnoses.findByDescription", query = "SELECT d FROM Diagnoses d WHERE d.description = :description")})
public class Diagnoses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "NAME", length = 60)
    private String name;
    @Column(name = "DESCRIPTION", length = 120)
    private String description;
    @JoinTable(name = "PATIENT_HAS_DIAGNOSIS", joinColumns = {
        @JoinColumn(name = "DIAGNOSIS_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany
    private Collection<Patients> patientsCollection;
    @JoinTable(name = "DRUG_CONTRADICT_DIAGNOSIS", joinColumns = {
        @JoinColumn(name = "DIAGNOSIS_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany
    private Collection<Drugs> drugsCollection;

    public Diagnoses() {
    }

    public Diagnoses(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Patients> getPatientsCollection() {
        return patientsCollection;
    }

    public void setPatientsCollection(Collection<Patients> patientsCollection) {
        this.patientsCollection = patientsCollection;
    }

    @XmlTransient
    public Collection<Drugs> getDrugsCollection() {
        return drugsCollection;
    }

    public void setDrugsCollection(Collection<Drugs> drugsCollection) {
        this.drugsCollection = drugsCollection;
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
        if (!(object instanceof Diagnoses)) {
            return false;
        }
        Diagnoses other = (Diagnoses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.Diagnoses[ id=" + id + " ]";
    }
    
}
