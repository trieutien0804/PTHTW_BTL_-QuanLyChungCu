package com.chungcu.pojo;

import com.chungcu.pojo.Surveyquestion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-27T21:19:39")
@StaticMetamodel(Survey.class)
public class Survey_ { 

    public static volatile SingularAttribute<Survey, Date> createdAt;
    public static volatile SingularAttribute<Survey, String> description;
    public static volatile SetAttribute<Survey, Surveyquestion> surveyquestionSet;
    public static volatile SingularAttribute<Survey, Integer> id;
    public static volatile SingularAttribute<Survey, String> title;

}