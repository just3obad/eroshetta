package eroshetta;

import eroshetta.Drugs;
import eroshetta.PrescriptionHasDrugPK;
import eroshetta.Prescriptions;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-11-23T01:22:57")
@StaticMetamodel(PrescriptionHasDrug.class)
public class PrescriptionHasDrug_ { 

    public static volatile SingularAttribute<PrescriptionHasDrug, Drugs> drugs;
    public static volatile SingularAttribute<PrescriptionHasDrug, PrescriptionHasDrugPK> prescriptionHasDrugPK;
    public static volatile SingularAttribute<PrescriptionHasDrug, Prescriptions> prescriptions;
    public static volatile SingularAttribute<PrescriptionHasDrug, String> drugTime;

}