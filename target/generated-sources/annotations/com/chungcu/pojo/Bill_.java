package com.chungcu.pojo;

import com.chungcu.pojo.Resident;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-11T00:12:03")
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, Date> createdAt;
    public static volatile SingularAttribute<Bill, BigDecimal> amount;
    public static volatile SingularAttribute<Bill, Date> dueDate;
    public static volatile SingularAttribute<Bill, String> paymentMethod;
    public static volatile SingularAttribute<Bill, Resident> residentId;
    public static volatile SingularAttribute<Bill, Integer> id;
    public static volatile SingularAttribute<Bill, String> type;
    public static volatile SingularAttribute<Bill, String> paymentStatus;

}