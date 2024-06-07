/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ptdzu
 */
@Entity
@Table(name = "familymember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familymember.findAll", query = "SELECT f FROM Familymember f"),
    @NamedQuery(name = "Familymember.findById", query = "SELECT f FROM Familymember f WHERE f.id = :id"),
    @NamedQuery(name = "Familymember.findByName", query = "SELECT f FROM Familymember f WHERE f.name = :name")})
public class Familymember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "resident_id", referencedColumnName = "id")
    @ManyToOne
    private Resident residentId;
    @OneToMany(mappedBy = "familyMemberId")
    private Set<Parkingcard> parkingcardSet;

    public Familymember() {
    }

    public Familymember(Integer id) {
        this.id = id;
    }

    public Familymember(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Resident getResidentId() {
        return residentId;
    }

    public void setResidentId(Resident residentId) {
        this.residentId = residentId;
    }

    @XmlTransient
    public Set<Parkingcard> getParkingcardSet() {
        return parkingcardSet;
    }

    public void setParkingcardSet(Set<Parkingcard> parkingcardSet) {
        this.parkingcardSet = parkingcardSet;
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
        if (!(object instanceof Familymember)) {
            return false;
        }
        Familymember other = (Familymember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chungcu.pojo.Familymember[ id=" + id + " ]";
    }
    
}
