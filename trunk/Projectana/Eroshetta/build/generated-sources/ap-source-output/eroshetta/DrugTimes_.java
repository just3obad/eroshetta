package eroshetta;

import eroshetta.DrugTimesPK;
import eroshetta.Drugs;
import eroshetta.Prescriptions;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-11-23T01:22:57")
@StaticMetamodel(DrugTimes.class)
public class DrugTimes_ { 

    public static volatile SingularAttribute<DrugTimes, Drugs> drugs;
    public static volatile SingularAttribute<DrugTimes, DrugTimesPK> drugTimesPK;
    public static volatile SingularAttribute<DrugTimes, String> drugDuration;
    public static volatile SingularAttribute<DrugTimes, Prescriptions> prescriptions;
    public static volatile SingularAttribute<DrugTimes, String> drugTime;

}