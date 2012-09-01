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
@Table(name = "GENERIC_NAMES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenericNames.findAll", query = "SELECT g FROM GenericNames g"),
    @NamedQuery(name = "GenericNames.findByDrugId", query = "SELECT g FROM GenericNames g WHERE g.drugId = :drugId"),
    @NamedQuery(name = "GenericNames.findByGenericName", query = "SELECT g FROM GenericNames g WHERE g.genericName = :genericName"),
    @NamedQuery(name = "GenericNames.findByConcentration", query = "SELECT g FROM GenericNames g WHERE g.concentration = :concentration")})
public class GenericNames implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DRUG_ID")
    private Integer drugId;
    @Column(name = "GENERIC_NAME")
    private String genericName;
    @Column(name = "CONCENTRATION")
    private String concentration;
    @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Drugs drugs;

    public GenericNames() {
    }

    public GenericNames(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
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
        hash += (drugId != null ? drugId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenericNames)) {
            return false;
        }
        GenericNames other = (GenericNames) object;
        if ((this.drugId == null && other.drugId != null) || (this.drugId != null && !this.drugId.equals(other.drugId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.GenericNames[ drugId=" + drugId + " ]";
    }
    
}
