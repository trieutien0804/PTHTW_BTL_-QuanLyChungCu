package com.chungcu.pojo;

import com.chungcu.pojo.Resident;
import com.chungcu.pojo.Surveyquestion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-27T19:41:38")
@StaticMetamodel(Surveyanswer.class)
public class Surveyanswer_ { 

    public static volatile SingularAttribute<Surveyanswer, Surveyquestion> surveyQuestionId;
    public static volatile SingularAttribute<Surveyanswer, String> answer;
    public static volatile SingularAttribute<Surveyanswer, Resident> residentId;
    public static volatile SingularAttribute<Surveyanswer, Integer> id;

}