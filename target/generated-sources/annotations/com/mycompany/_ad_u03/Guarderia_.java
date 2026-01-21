package com.mycompany._ad_u03;

import com.mycompany._ad_u03.EducadorInfantil;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-01-19T20:47:56", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Guarderia.class)
public class Guarderia_ { 

    public static volatile CollectionAttribute<Guarderia, EducadorInfantil> educadorInfantilCollection;
    public static volatile SingularAttribute<Guarderia, String> codigo;
    public static volatile SingularAttribute<Guarderia, Float> presupuesto;
    public static volatile SingularAttribute<Guarderia, String> nombre;
    public static volatile SingularAttribute<Guarderia, Integer> capacidad;

}