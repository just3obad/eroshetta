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
@Table(name = "FOODS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foods.findAll", query = "SELECT f FROM Foods f"),
    @NamedQuery(name = "Foods.findById", query = "SELECT f FROM Foods f WHERE f.id = :id"),
    @NamedQuery(name = "Foods.findByName", query = "SELECT f FROM Foods f WHERE f.name = :name")})
public class Foods implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany(mappedBy = "foodsCollection")
    private Collection<Drugs> drugsCollection;

    public Foods() {
    }

    public Foods(Integer id) {
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
        if (!(object instanceof Foods)) {
            return false;
        }
        Foods other = (Foods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.Foods[ id=" + id + " ]";
    }
    
}
