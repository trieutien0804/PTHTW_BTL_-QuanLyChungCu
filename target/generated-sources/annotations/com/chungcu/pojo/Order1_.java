package com.chungcu.pojo;

import com.chungcu.pojo.Locker;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-13T01:49:06")
@StaticMetamodel(Order1.class)
public class Order1_ { 

    public static volatile SingularAttribute<Order1, Date> createdAt;
    public static volatile SingularAttribute<Order1, Locker> lockerId;
    public static volatile SingularAttribute<Order1, String> description;
    public static volatile SingularAttribute<Order1, Integer> id;
    public static volatile SingularAttribute<Order1, String> status;

}