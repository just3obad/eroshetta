/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eroshetta;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "PATIENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patients.findAll", query = "SELECT p FROM Patients p"),
    @NamedQuery(name = "Patients.findById", query = "SELECT p FROM Patients p WHERE p.id = :id"),
    @NamedQuery(name = "Patients.findByName", query = "SELECT p FROM Patients p WHERE p.name = :name"),
    @NamedQuery(name = "Patients.findByBirthDate", query = "SELECT p FROM Patients p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "Patients.findByIsPregnant", query = "SELECT p FROM Patients p WHERE p.isPregnant = :isPregnant"),
    @NamedQuery(name = "Patients.findByMaritalStatus", query = "SELECT p FROM Patients p WHERE p.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "Patients.findByNextVisit", query = "SELECT p FROM Patients p WHERE p.nextVisit = :nextVisit"),
    @NamedQuery(name = "Patients.findByWeight", query = "SELECT p FROM Patients p WHERE p.weight = :weight"),
    @NamedQuery(name = "Patients.findByHeight", query = "SELECT p FROM Patients p WHERE p.height = :height"),
    @NamedQuery(name = "Patients.findByBmi", query = "SELECT p FROM Patients p WHERE p.bmi = :bmi"),
    @NamedQuery(name = "Patients.findByGender", query = "SELECT p FROM Patients p WHERE p.gender = :gender")})
public class Patients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "IS_PREGNANT")
    private Integer isPregnant;
    @Column(name = "MARITAL_STATUS")
    private Integer maritalStatus;
    @Column(name = "NEXT_VISIT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextVisit;
    @Column(name = "WEIGHT")
    private Integer weight;
    @Column(name = "HEIGHT")
    private Integer height;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BMI")
    private BigDecimal bmi;
    @Column(name = "GENDER")
    private Character gender;
    @ManyToMany(mappedBy = "patientsCollection")
    private Collection<Diagnoses> diagnosesCollection;
    @ManyToMany(mappedBy = "patientsCollection")
    private Collection<Drugs> drugsCollection;
    @OneToMany(mappedBy = "patientId")
    private Collection<Prescriptions> prescriptionsCollection;

    public Patients() {
    }

    public Patients(Integer id) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getIsPregnant() {
        return isPregnant;
    }

    public void setIsPregnant(Integer isPregnant) {
        this.isPregnant = isPregnant;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Date getNextVisit() {
        return nextVisit;
    }

    public void setNextVisit(Date nextVisit) {
        this.nextVisit = nextVisit;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public BigDecimal getBmi() {
        return bmi;
    }

    public void setBmi(BigDecimal bmi) {
        this.bmi = bmi;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    @XmlTransient
    public Collection<Diagnoses> getDiagnosesCollection() {
        return diagnosesCollection;
    }

    public void setDiagnosesCollection(Collection<Diagnoses> diagnosesCollection) {
        this.diagnosesCollection = diagnosesCollection;
    }

    @XmlTransient
    public Collection<Drugs> getDrugsCollection() {
        return drugsCollection;
    }

    public void setDrugsCollection(Collection<Drugs> drugsCollection) {
        this.drugsCollection = drugsCollection;
    }

    @XmlTransient
    public Collection<Prescriptions> getPrescriptionsCollection() {
        return prescriptionsCollection;
    }

    public void setPrescriptionsCollection(Collection<Prescriptions> prescriptionsCollection) {
        this.prescriptionsCollection = prescriptionsCollection;
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
        if (!(object instanceof Patients)) {
            return false;
        }
        Patients other = (Patients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.Patients[ id=" + id + " ]";
    }
    
}
