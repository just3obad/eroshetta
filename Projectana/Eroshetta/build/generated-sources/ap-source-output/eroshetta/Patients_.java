package eroshetta;

import eroshetta.Diagnoses;
import eroshetta.Drugs;
import eroshetta.Prescriptions;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-09-16T22:07:09")
@StaticMetamodel(Patients.class)
public class Patients_ { 

    public static volatile SingularAttribute<Patients, Integer> weight;
    public static volatile SingularAttribute<Patients, BigDecimal> bmi;
    public static volatile SingularAttribute<Patients, Integer> isPregnant;
    public static volatile SingularAttribute<Patients, Integer> maritalStatus;
    public static volatile CollectionAttribute<Patients, Drugs> drugsCollection;
    public static volatile SingularAttribute<Patients, Date> nextVisit;
    public static volatile SingularAttribute<Patients, Integer> id;
    public static volatile SingularAttribute<Patients, Integer> height;
    public static volatile CollectionAttribute<Patients, Prescriptions> prescriptionsCollection;
    public static volatile SingularAttribute<Patients, String> name;
    public static volatile SingularAttribute<Patients, Character> gender;
    public static volatile CollectionAttribute<Patients, Diagnoses> diagnosesCollection;
    public static volatile SingularAttribute<Patients, Date> birthDate;

}