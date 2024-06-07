package com.chungcu.pojo;

import com.chungcu.pojo.Locker;
import com.chungcu.pojo.Resident;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-07T13:59:31")
@StaticMetamodel(Apartment.class)
public class Apartment_ { 

    public static volatile SetAttribute<Apartment, Resident> residentSet;
    public static volatile SingularAttribute<Apartment, Integer> id;
    public static volatile SingularAttribute<Apartment, Locker> locker;
    public static volatile SingularAttribute<Apartment, String> apartmentNumber;
    public static volatile SingularAttribute<Apartment, String> status;

}