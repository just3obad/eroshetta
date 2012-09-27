package eroshetta;

import eroshetta.Drugs;
import eroshetta.GenericNamesPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-09-16T22:07:09")
@StaticMetamodel(GenericNames.class)
public class GenericNames_ { 

    public static volatile SingularAttribute<GenericNames, String> concentration;
    public static volatile SingularAttribute<GenericNames, GenericNamesPK> genericNamesPK;
    public static volatile SingularAttribute<GenericNames, Drugs> drugs;

}