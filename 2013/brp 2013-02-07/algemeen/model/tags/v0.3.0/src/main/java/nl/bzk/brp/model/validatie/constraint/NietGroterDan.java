/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.validatie.constraint;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import nl.bzk.brp.model.algemeen.stamgegeven.ber.SoortMelding;
import nl.bzk.brp.model.validatie.MeldingCode;
import nl.bzk.brp.model.validatie.validator.NietGroterDanValidator;

/**
 * Validatie annotatie voor het aangeven dat een veld waarde niet groter mag zijn dan de waarde van een ander veld.
 */
@Documented
@Constraint(validatedBy = NietGroterDanValidator.class)
@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NietGroterDan {

    /** De naam het betreffende veld. */
    String veld();

    /** De naam van het veld waar de waarde niet groter dan moet zijn. */
    String nietGroterDanVeld();

    /** Standaard validatie bericht. */
    String message() default "";

    /** Standaard validatie groep. */
    Class<?>[] groups() default { };

    /** Verplicht veld voor de validatie framework. */
    Class<? extends Payload>[] payload() default { };

    /** De bedrijfsregel code. */
    MeldingCode code();

    /** Regel effect BR (blocker). */
    SoortMelding soortMelding() default SoortMelding.FOUT;
}
