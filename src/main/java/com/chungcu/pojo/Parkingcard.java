/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.pojo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ptdzu
 */
@Entity
@Table(name = "parkingcard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parkingcard.findAll", query = "SELECT p FROM Parkingcard p"),
    @NamedQuery(name = "Parkingcard.findById", query = "SELECT p FROM Parkingcard p WHERE p.id = :id"),
    @NamedQuery(name = "Parkingcard.findByCardNumber", query = "SELECT p FROM Parkingcard p WHERE p.cardNumber = :cardNumber")})
public class Parkingcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "card_number")
    private String cardNumber;
    @JoinColumn(name = "family_member_id", referencedColumnName = "id")
    @ManyToOne
    private Familymember familyMemberId;
    @JoinColumn(name = "resident_id", referencedColumnName = "id")
    @ManyToOne
    private Resident residentId;

    public Parkingcard() {
    }

    public Parkingcard(Integer id) {
        this.id = id;
    }

    public Parkingcard(Integer id, String cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Familymember getFamilyMemberId() {
        return familyMemberId;
    }

    public void setFamilyMemberId(Familymember familyMemberId) {
        this.familyMemberId = familyMemberId;
    }

    public Resident getResidentId() {
        return residentId;
    }

    public void setResidentId(Resident residentId) {
        this.residentId = residentId;
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
        if (!(object instanceof Parkingcard)) {
            return false;
        }
        Parkingcard other = (Parkingcard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chungcu.pojo.Parkingcard[ id=" + id + " ]";
    }
    
}
