package com.chungcu.pojo;

import com.chungcu.pojo.Parkingcard;
import com.chungcu.pojo.Resident;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-28T14:46:39")
@StaticMetamodel(Familymember.class)
public class Familymember_ { 

    public static volatile SingularAttribute<Familymember, String> name;
    public static volatile SingularAttribute<Familymember, Resident> residentId;
    public static volatile SingularAttribute<Familymember, Integer> id;
    public static volatile SetAttribute<Familymember, Parkingcard> parkingcardSet;

}