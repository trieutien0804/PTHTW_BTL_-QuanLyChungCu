package com.chungcu.pojo;

import com.chungcu.pojo.Apartment;
import com.chungcu.pojo.Bill;
import com.chungcu.pojo.Familymember;
import com.chungcu.pojo.Feedback;
import com.chungcu.pojo.Locker;
import com.chungcu.pojo.Parkingcard;
import com.chungcu.pojo.Surveyanswer;
import com.chungcu.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-11T11:38:54")
@StaticMetamodel(Resident.class)
public class Resident_ { 

    public static volatile SetAttribute<Resident, Surveyanswer> surveyanswerSet;
    public static volatile SetAttribute<Resident, Feedback> feedbackSet;
    public static volatile SetAttribute<Resident, Bill> billSet;
    public static volatile SetAttribute<Resident, Familymember> familymemberSet;
    public static volatile SingularAttribute<Resident, Short> isActive;
    public static volatile SingularAttribute<Resident, User> userId;
    public static volatile SetAttribute<Resident, Locker> lockerSet;
    public static volatile SingularAttribute<Resident, String> phoneNumber;
    public static volatile SingularAttribute<Resident, String> name;
    public static volatile SingularAttribute<Resident, Integer> id;
    public static volatile SingularAttribute<Resident, String> email;
    public static volatile SetAttribute<Resident, Parkingcard> parkingcardSet;
    public static volatile SingularAttribute<Resident, Apartment> apartmentId;

}