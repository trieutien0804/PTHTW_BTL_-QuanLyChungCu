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
import javax.persistence.Lob;
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
 * @author tien
 */
@Entity
@Table(name = "surveyquestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surveyquestion.findAll", query = "SELECT s FROM Surveyquestion s"),
    @NamedQuery(name = "Surveyquestion.findById", query = "SELECT s FROM Surveyquestion s WHERE s.id = :id"),
    @NamedQuery(name = "Surveyquestion.findByType", query = "SELECT s FROM Surveyquestion s WHERE s.type = :type")})
public class Surveyquestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "surveyQuestionId")
    private Set<Surveyanswer> surveyanswerSet;
    @JoinColumn(name = "survey_id", referencedColumnName = "id")
    @ManyToOne
    private Survey surveyId;

    public Surveyquestion() {
    }

    public Surveyquestion(Integer id) {
        this.id = id;
    }

    public Surveyquestion(Integer id, String content, String type) {
        this.id = id;
        this.content = content;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Set<Surveyanswer> getSurveyanswerSet() {
        return surveyanswerSet;
    }

    public void setSurveyanswerSet(Set<Surveyanswer> surveyanswerSet) {
        this.surveyanswerSet = surveyanswerSet;
    }

    public Survey getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Survey surveyId) {
        this.surveyId = surveyId;
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
        if (!(object instanceof Surveyquestion)) {
            return false;
        }
        Surveyquestion other = (Surveyquestion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chungcu.pojo.Surveyquestion[ id=" + id + " ]";
    }
    
}
