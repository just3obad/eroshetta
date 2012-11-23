package eroshetta;

import eroshetta.Drugs;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-11-23T01:22:57")
@StaticMetamodel(SideEffects.class)
public class SideEffects_ { 

    public static volatile SingularAttribute<SideEffects, Integer> id;
    public static volatile SingularAttribute<SideEffects, String> description;
    public static volatile SingularAttribute<SideEffects, String> name;
    public static volatile SingularAttribute<SideEffects, Integer> type;
    public static volatile CollectionAttribute<SideEffects, Drugs> drugsCollection;

}