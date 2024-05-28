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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tien
 */
@Entity
@Table(name = "surveyanswer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surveyanswer.findAll", query = "SELECT s FROM Surveyanswer s"),
    @NamedQuery(name = "Surveyanswer.findById", query = "SELECT s FROM Surveyanswer s WHERE s.id = :id")})
public class Surveyanswer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "answer")
    private String answer;
    @JoinColumn(name = "resident_id", referencedColumnName = "id")
    @ManyToOne
    private Resident residentId;
    @JoinColumn(name = "survey_question_id", referencedColumnName = "id")
    @ManyToOne
    private Surveyquestion surveyQuestionId;

    public Surveyanswer() {
    }

    public Surveyanswer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Resident getResidentId() {
        return residentId;
    }

    public void setResidentId(Resident residentId) {
        this.residentId = residentId;
    }

    public Surveyquestion getSurveyQuestionId() {
        return surveyQuestionId;
    }

    public void setSurveyQuestionId(Surveyquestion surveyQuestionId) {
        this.surveyQuestionId = surveyQuestionId;
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
        if (!(object instanceof Surveyanswer)) {
            return false;
        }
        Surveyanswer other = (Surveyanswer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chungcu.pojo.Surveyanswer[ id=" + id + " ]";
    }
    
}
