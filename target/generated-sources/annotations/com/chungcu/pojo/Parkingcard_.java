package com.chungcu.pojo;

import com.chungcu.pojo.Familymember;
import com.chungcu.pojo.Resident;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-28T14:46:39")
@StaticMetamodel(Parkingcard.class)
public class Parkingcard_ { 

    public static volatile SingularAttribute<Parkingcard, Familymember> familyMemberId;
    public static volatile SingularAttribute<Parkingcard, Resident> residentId;
    public static volatile SingularAttribute<Parkingcard, Integer> id;
    public static volatile SingularAttribute<Parkingcard, String> cardNumber;

}