package com.chungcu.pojo;

import com.chungcu.pojo.Order1;
import com.chungcu.pojo.Resident;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-09T14:34:22")
@StaticMetamodel(Locker.class)
public class Locker_ { 

    public static volatile SingularAttribute<Locker, String> lockerNumber;
    public static volatile SetAttribute<Locker, Order1> order1Set;
    public static volatile SingularAttribute<Locker, Resident> residentId;
    public static volatile SingularAttribute<Locker, Integer> id;

}