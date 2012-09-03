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
@Table(name = "DRUGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drugs.findAll", query = "SELECT d FROM Drugs d"),
    @NamedQuery(name = "Drugs.findById", query = "SELECT d FROM Drugs d WHERE d.id = :id"),
    @NamedQuery(name = "Drugs.findByClassName", query = "SELECT d FROM Drugs d WHERE d.className = :className"),
    @NamedQuery(name = "Drugs.findByTradeName", query = "SELECT d FROM Drugs d WHERE d.tradeName = :tradeName"),
    @NamedQuery(name = "Drugs.findByDosage", query = "SELECT d FROM Drugs d WHERE d.dosage = :dosage"),
    @NamedQuery(name = "Drugs.findByDosageForm", query = "SELECT d FROM Drugs d WHERE d.dosageForm = :dosageForm"),
    @NamedQuery(name = "Drugs.findByPrice", query = "SELECT d FROM Drugs d WHERE d.price = :price"),
    @NamedQuery(name = "Drugs.findByRouteOfElimination", query = "SELECT d FROM Drugs d WHERE d.routeOfElimination = :routeOfElimination"),
    @NamedQuery(name = "Drugs.findByPrecautions", query = "SELECT d FROM Drugs d WHERE d.precautions = :precautions"),
    @NamedQuery(name = "Drugs.findByHalfLife", query = "SELECT d FROM Drugs d WHERE d.halfLife = :halfLife"),
    @NamedQuery(name = "Drugs.findByContraPregnant", query = "SELECT d FROM Drugs d WHERE d.contraPregnant = :contraPregnant"),
    @NamedQuery(name = "Drugs.findByContraBmi", query = "SELECT d FROM Drugs d WHERE d.contraBmi = :contraBmi"),
    @NamedQuery(name = "Drugs.findByContraAge", query = "SELECT d FROM Drugs d WHERE d.contraAge = :contraAge")})
public class Drugs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CLASS_NAME")
    private String className;
    @Column(name = "TRADE_NAME")
    private String tradeName;
    @Column(name = "DOSAGE")
    private String dosage;
    @Column(name = "DOSAGE_FORM")
    private String dosageForm;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "ROUTE_OF_ELIMINATION")
    private String routeOfElimination;
    @Column(name = "PRECAUTIONS")
    private String precautions;
    @Column(name = "HALF_LIFE")
    private Integer halfLife;
    @Column(name = "CONTRA_PREGNANT")
    private Integer contraPregnant;
    @Column(name = "CONTRA_BMI")
    private Integer contraBmi;
    @Column(name = "CONTRA_AGE")
    private Integer contraAge;
    @JoinTable(name = "DRUG_CONTRADICT_DRUG", joinColumns = {
        @JoinColumn(name = "DRUG_ID2", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "DRUG_ID1", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Drugs> drugsCollection;
    @ManyToMany(mappedBy = "drugsCollection")
    private Collection<Drugs> drugsCollection1;
    @JoinTable(name = "PRESCRIPTION_HAS_DRUG", joinColumns = {
        @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PRESCRIPTION_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Prescriptions> prescriptionsCollection;
    @JoinTable(name = "DRUG_INTERACT_FOOD", joinColumns = {
        @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "FOOD_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Foods> foodsCollection;
    @JoinTable(name = "DRUG_HAS_SIDEEFFECT", joinColumns = {
        @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SIDE_EFFECT_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<SideEffects> sideEffectsCollection;
    @ManyToMany(mappedBy = "drugsCollection")
    private Collection<Diagnoses> diagnosesCollection;
    @JoinTable(name = "PATIENT_CURRENT_MEDICATION", joinColumns = {
        @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Patients> patientsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "drugs")
    private GenericNames genericNames;
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

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRouteOfElimination() {
        return routeOfElimination;
    }

    public void setRouteOfElimination(String routeOfElimination) {
        this.routeOfElimination = routeOfElimination;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public Integer getHalfLife() {
        return halfLife;
    }

    public void setHalfLife(Integer halfLife) {
        this.halfLife = halfLife;
    }

    public Integer getContraPregnant() {
        return contraPregnant;
    }

    public void setContraPregnant(Integer contraPregnant) {
        this.contraPregnant = contraPregnant;
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
    public Collection<Foods> getFoodsCollection() {
        return foodsCollection;
    }

    public void setFoodsCollection(Collection<Foods> foodsCollection) {
        this.foodsCollection = foodsCollection;
    }

    @XmlTransient
    public Collection<SideEffects> getSideEffectsCollection() {
        return sideEffectsCollection;
    }

    public void setSideEffectsCollection(Collection<SideEffects> sideEffectsCollection) {
        this.sideEffectsCollection = sideEffectsCollection;
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

    public GenericNames getGenericNames() {
        return genericNames;
    }

    public void setGenericNames(GenericNames genericNames) {
        this.genericNames = genericNames;
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
        return "eroshetta.Drugs[ id=" + id + " ]" + this.tradeName + this.className;
    }
    
    
}
