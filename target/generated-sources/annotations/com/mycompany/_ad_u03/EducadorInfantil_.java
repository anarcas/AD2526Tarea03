package com.mycompany._ad_u03;

import com.mycompany._ad_u03.Guarderia;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-01-19T20:47:56", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(EducadorInfantil.class)
public class EducadorInfantil_ { 

    public static volatile SingularAttribute<EducadorInfantil, String> apellidos;
    public static volatile SingularAttribute<EducadorInfantil, Date> fechaAlta;
    public static volatile SingularAttribute<EducadorInfantil, Guarderia> codigoGuarderia;
    public static volatile SingularAttribute<EducadorInfantil, Date> fechaNacimiento;
    public static volatile SingularAttribute<EducadorInfantil, Float> salario;
    public static volatile SingularAttribute<EducadorInfantil, String> nombre;
    public static volatile SingularAttribute<EducadorInfantil, String> dni;

}