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
 * @author Administrator
 */
@Entity
@Table(name = "SIDE_EFFECTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SideEffects.findAll", query = "SELECT s FROM SideEffects s"),
    @NamedQuery(name = "SideEffects.findById", query = "SELECT s FROM SideEffects s WHERE s.id = :id"),
    @NamedQuery(name = "SideEffects.findByName", query = "SELECT s FROM SideEffects s WHERE s.name = :name"),
    @NamedQuery(name = "SideEffects.findByDescription", query = "SELECT s FROM SideEffects s WHERE s.description = :description"),
    @NamedQuery(name = "SideEffects.findByType", query = "SELECT s FROM SideEffects s WHERE s.type = :type")})
public class SideEffects implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TYPE")
    private Integer type;
    @ManyToMany(mappedBy = "sideEffectsCollection")
    private Collection<Drugs> drugsCollection;

    public SideEffects() {
    }

    public SideEffects(Integer id) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        if (!(object instanceof SideEffects)) {
            return false;
        }
        SideEffects other = (SideEffects) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eroshetta.SideEffects[ id=" + id + " ]";
    }
    
}
