/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.validatie.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import nl.bzk.brp.model.algemeen.stamgegeven.ber.SoortMelding;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.DatabaseObjectKern;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.Regel;
import nl.bzk.brp.model.validatie.validator.LengteValidator;


/**
 * De lengte van de string moet tussen de gespecificeerde waarde zitten.
 */
@Documented
@Constraint(validatedBy = LengteValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Lengte {

    /**
     * @return size the element must be higher or equal to
     */
    int min() default 0;

    /**
     * @return size the element must be lower or equal to
     */
    int max() default Integer.MAX_VALUE;

    /**
     * Standaard validatie bericht.
     */
    String message() default "";

    /**
     * Standaard validatie groep.
     */
    Class<?>[] groups() default { };

    /**
     * Verplicht veld voor de validatie framework.
     */
    Class<? extends Payload>[] payload() default { };

    /**
     * De bedrijfsregel code.
     */
    Regel code();

    /**
     * Standaard regel effect BR (blocker).
     */
    SoortMelding soortMelding() default SoortMelding.FOUT;

    /**
     * Database meta id waarop de constraint van toepassing is.
     */
    DatabaseObjectKern dbObject();
}
