package com.chungcu.pojo;

import com.chungcu.pojo.Resident;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-12T15:40:39")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, Date> createdAt;
    public static volatile SingularAttribute<Feedback, Resident> residentId;
    public static volatile SingularAttribute<Feedback, Integer> id;
    public static volatile SingularAttribute<Feedback, String> content;
    public static volatile SingularAttribute<Feedback, String> status;

}