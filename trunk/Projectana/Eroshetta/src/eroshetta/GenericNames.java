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
@Table(name = "GENERIC_NAMES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenericNames.findAll", query = "SELECT g FROM GenericNames g"),
    @NamedQuery(name = "GenericNames.findByDrugId", query = "SELECT g FROM GenericNames g WHERE g.genericNamesPK.drugId = :drugId"),
    @NamedQuery(name = "GenericNames.findByGenericName", query = "SELECT g FROM GenericNames g WHERE g.genericNamesPK.genericName = :genericName"),
    @NamedQuery(name = "GenericNames.findByConcentration", query = "SELECT g FROM GenericNames g WHERE g.concentration = :concentration")})
public class GenericNames implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GenericNamesPK genericNamesPK;
    @Column(name = "CONCENTRATION")
    private String concentration;
    @JoinColumn(name = "DRUG_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Drugs drugs;

    public GenericNames() {
    }

    public GenericNames(GenericNamesPK genericNamesPK) {
        this.genericNamesPK = genericNamesPK;
    }

    public GenericNames(int drugId, String genericName) {
        this.genericNamesPK = new GenericNamesPK(drugId, genericName);
    }

    public GenericNamesPK getGenericNamesPK() {
        return genericNamesPK;
    }

    public void setGenericNamesPK(GenericNamesPK genericNamesPK) {
        this.genericNamesPK = genericNamesPK;
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
        hash += (genericNamesPK != null ? genericNamesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenericNames)) {
            return false;
        }
        GenericNames other = (GenericNames) object;
        if ((this.genericNamesPK == null && other.genericNamesPK != null) || (this.genericNamesPK != null && !this.genericNamesPK.equals(other.genericNamesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.GenericNames[ genericNamesPK=" + genericNamesPK + " ]";
    }
    
}
