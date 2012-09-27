package eroshetta;

import eroshetta.Diagnoses;
import eroshetta.DrugTimes;
import eroshetta.Drugs;
import eroshetta.GenericNames;
import eroshetta.Patients;
import eroshetta.Prescriptions;
import eroshetta.SideEffects;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-09-16T22:07:09")
@StaticMetamodel(Drugs.class)
public class Drugs_ { 

    public static volatile CollectionAttribute<Drugs, GenericNames> genericNamesCollection;
    public static volatile CollectionAttribute<Drugs, Drugs> drugsCollection1;
    public static volatile CollectionAttribute<Drugs, Patients> patientsCollection;
    public static volatile SingularAttribute<Drugs, String> dosage;
    public static volatile SingularAttribute<Drugs, String> tradeName;
    public static volatile CollectionAttribute<Drugs, DrugTimes> drugTimesCollection;
    public static volatile CollectionAttribute<Drugs, Drugs> drugsCollection;
    public static volatile SingularAttribute<Drugs, Integer> id;
    public static volatile SingularAttribute<Drugs, String> routeOfElimination;
    public static volatile SingularAttribute<Drugs, BigDecimal> price;
    public static volatile CollectionAttribute<Drugs, SideEffects> sideEffectsCollection;
    public static volatile CollectionAttribute<Drugs, Prescriptions> prescriptionsCollection;
    public static volatile SingularAttribute<Drugs, String> foodInteractions;
    public static volatile SingularAttribute<Drugs, String> precautions;
    public static volatile SingularAttribute<Drugs, Integer> contraPregnant;
    public static volatile CollectionAttribute<Drugs, Diagnoses> diagnosesCollection;
    public static volatile SingularAttribute<Drugs, String> className;
    public static volatile SingularAttribute<Drugs, String> dosageForm;
    public static volatile SingularAttribute<Drugs, Integer> halfLife;

}