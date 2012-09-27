package eroshetta;

import eroshetta.DrugTimes;
import eroshetta.Drugs;
import eroshetta.Patients;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-09-16T22:07:09")
@StaticMetamodel(Prescriptions.class)
public class Prescriptions_ { 

    public static volatile SingularAttribute<Prescriptions, Integer> id;
    public static volatile SingularAttribute<Prescriptions, Patients> patientId;
    public static volatile SingularAttribute<Prescriptions, Date> date;
    public static volatile SingularAttribute<Prescriptions, String> notes;
    public static volatile CollectionAttribute<Prescriptions, DrugTimes> drugTimesCollection;
    public static volatile CollectionAttribute<Prescriptions, Drugs> drugsCollection;

}