package com.chungcu.pojo;

import com.chungcu.pojo.Survey;
import com.chungcu.pojo.Surveyanswer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-12T21:44:28")
@StaticMetamodel(Surveyquestion.class)
public class Surveyquestion_ { 

    public static volatile SetAttribute<Surveyquestion, Surveyanswer> surveyanswerSet;
    public static volatile SingularAttribute<Surveyquestion, Survey> surveyId;
    public static volatile SingularAttribute<Surveyquestion, Integer> id;
    public static volatile SingularAttribute<Surveyquestion, String> content;

}