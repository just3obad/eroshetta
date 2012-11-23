package eroshetta;

import eroshetta.Drugs;
import eroshetta.Patients;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-11-23T01:22:57")
@StaticMetamodel(Diagnoses.class)
public class Diagnoses_ { 

    public static volatile SingularAttribute<Diagnoses, Integer> id;
    public static volatile SingularAttribute<Diagnoses, String> description;
    public static volatile SingularAttribute<Diagnoses, String> name;
    public static volatile CollectionAttribute<Diagnoses, Patients> patientsCollection;
    public static volatile CollectionAttribute<Diagnoses, Drugs> drugsCollection;

}