/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eroshetta;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mouaz
 */
@Entity
@Table(name = "DRUGS", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drugs.findAll", query = "SELECT d FROM Drugs d"),
    @NamedQuery(name = "Drugs.findById", query = "SELECT d FROM Drugs d WHERE d.id = :id"),
    @NamedQuery(name = "Drugs.findByClassName", query = "SELECT d FROM Drugs d WHERE d.className = :className"),
    @NamedQuery(name = "Drugs.findByTradeName", query = "SELECT d FROM Drugs d WHERE d.tradeName = :tradeName"),
    @NamedQuery(name = "Drugs.findByGenericName", query = "SELECT d FROM Drugs d WHERE d.genericName = :genericName"),
    @NamedQuery(name = "Drugs.findByDosage", query = "SELECT d FROM Drugs d WHERE d.dosage = :dosage"),
    @NamedQuery(name = "Drugs.findByPrice", query = "SELECT d FROM Drugs d WHERE d.price = :price"),
    @NamedQuery(name = "Drugs.findByContraPregnant", query = "SELECT d FROM Drugs d WHERE d.contraPregnant = :contraPregnant"),
    @NamedQuery(name = "Drugs.findByContraMarital", query = "SELECT d FROM Drugs d WHERE d.contraMarital = :contraMarital"),
    @NamedQuery(name = "Drugs.findByContraBmi", query = "SELECT d FROM Drugs d WHERE d.contraBmi = :contraBmi"),
    @NamedQuery(name = "Drugs.findByContraAge", query = "SELECT d FROM Drugs d WHERE d.contraAge = :contraAge"),
    @NamedQuery(name = "Drugs.findByContraGender", query = "SELECT d FROM Drugs d WHERE d.contraGender = :contraGender")})
public class Drugs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "CLASS_NAME", length = 50)
    private String className;
    @Column(name = "TRADE_NAME", length = 50)
    private String tradeName;
    @Column(name = "GENERIC_NAME", length = 50)
    private String genericName;
    @Column(name = "DOSAGE", length = 30)
    private String dosage;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE", precision = 6, scale = 2)
    private BigDecimal price;
    @Column(name = "CONTRA_PREGNANT")
    private Integer contraPregnant;
    @Column(name = "CONTRA_MARITAL")
    private Integer contraMarital;
    @Column(name = "CONTRA_BMI")
    private Integer contraBmi;
    @Column(name = "CONTRA_AGE")
    private Integer contraAge;
    @Column(name = "CONTRA_GENDER")
    private Integer contraGender;
    @JoinTable(name = "DRUG_CONTRADICT_DRUG", joinColumns = {
        @JoinColumn(name = "DRUG_ID2", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "DRUG_ID1", referencedColumnName = "ID", nullable = false)})
    @ManyToMany
    private Collection<Drugs> drugsCollection;
    @ManyToMany(mappedBy = "drugsCollection")
    private Collection<Drugs> drugsCollection1;
    @JoinTable(name = "PRESCRIPTION_HAS_DRUG", joinColumns = {
        @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "PRESCRIPTION_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany
    private Collection<Prescriptions> prescriptionsCollection;
    @ManyToMany(mappedBy = "drugsCollection")
    private Collection<Diagnoses> diagnosesCollection;
    @JoinTable(name = "PATIENT_CURRENT_MEDICATION", joinColumns = {
        @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany
    private Collection<Patients> patientsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drugs")
    private Collection<DrugTime> drugTimeCollection;

    public Drugs() {
    }

    public Drugs(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getContraPregnant() {
        return contraPregnant;
    }

    public void setContraPregnant(Integer contraPregnant) {
        this.contraPregnant = contraPregnant;
    }

    public Integer getContraMarital() {
        return contraMarital;
    }

    public void setContraMarital(Integer contraMarital) {
        this.contraMarital = contraMarital;
    }

    public Integer getContraBmi() {
        return contraBmi;
    }

    public void setContraBmi(Integer contraBmi) {
        this.contraBmi = contraBmi;
    }

    public Integer getContraAge() {
        return contraAge;
    }

    public void setContraAge(Integer contraAge) {
        this.contraAge = contraAge;
    }

    public Integer getContraGender() {
        return contraGender;
    }

    public void setContraGender(Integer contraGender) {
        this.contraGender = contraGender;
    }

    @XmlTransient
    public Collection<Drugs> getDrugsCollection() {
        return drugsCollection;
    }

    public void setDrugsCollection(Collection<Drugs> drugsCollection) {
        this.drugsCollection = drugsCollection;
    }

    @XmlTransient
    public Collection<Drugs> getDrugsCollection1() {
        return drugsCollection1;
    }

    public void setDrugsCollection1(Collection<Drugs> drugsCollection1) {
        this.drugsCollection1 = drugsCollection1;
    }

    @XmlTransient
    public Collection<Prescriptions> getPrescriptionsCollection() {
        return prescriptionsCollection;
    }

    public void setPrescriptionsCollection(Collection<Prescriptions> prescriptionsCollection) {
        this.prescriptionsCollection = prescriptionsCollection;
    }

    @XmlTransient
    public Collection<Diagnoses> getDiagnosesCollection() {
        return diagnosesCollection;
    }

    public void setDiagnosesCollection(Collection<Diagnoses> diagnosesCollection) {
        this.diagnosesCollection = diagnosesCollection;
    }

    @XmlTransient
    public Collection<Patients> getPatientsCollection() {
        return patientsCollection;
    }

    public void setPatientsCollection(Collection<Patients> patientsCollection) {
        this.patientsCollection = patientsCollection;
    }

    @XmlTransient
    public Collection<DrugTime> getDrugTimeCollection() {
        return drugTimeCollection;
    }

    public void setDrugTimeCollection(Collection<DrugTime> drugTimeCollection) {
        this.drugTimeCollection = drugTimeCollection;
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
        if (!(object instanceof Drugs)) {
            return false;
        }
        Drugs other = (Drugs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.Drugs[ id=" + id + " ]";
    }
    
}
