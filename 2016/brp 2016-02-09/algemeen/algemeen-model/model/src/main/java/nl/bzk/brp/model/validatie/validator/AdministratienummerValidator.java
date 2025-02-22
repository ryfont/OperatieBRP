/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.validatie.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.AdministratienummerAttribuut;
import nl.bzk.brp.model.validatie.constraint.Administratienummer;
import org.apache.commons.lang.StringUtils;


/**
 * Administratienummer voorschrift.
 * <p/>
 * Als de cijfers van het A-nummer van links naar rechts worden aangegeven met a[0] t/m a[9], dan gelden de volgende condities: 1) a[0] <> 0 2) a[i] <>
 * a[i+1] 3) a[0]+a[1]+...+a[9] is deelbaar door 11 rest 0 of a[0]+a[1]+...+a[9] is deelbaar door 11 rest 5 4) (1*a[0])+(2*a[1])+(4*a[2])+...+(512*a[9]) is
 * deelbaar door 11
 *
 * @brp.bedrijfsregel BRAL0001
 */
public class AdministratienummerValidator implements
    ConstraintValidator<Administratienummer, AdministratienummerAttribuut>
{

    private static final int ANUMMER_LENGTE = 10;
    private static final int ELF            = 11;
    private static final int REST_NUL       = 0;
    private static final int REST_VIJF      = 5;

    @Override
    public void initialize(final Administratienummer constraintAnnotation) {
        // Niets om te initialiseren
    }

    @Override
    public boolean isValid(final AdministratienummerAttribuut aNummer, final ConstraintValidatorContext context) {
        return aNummer == null || aNummer.getWaarde() == null || isGeldigAnummer(aNummer);
    }

    /**
     * Controlleert of de waarde een geldige BSN nummer is.
     *
     * @param aNummer de bsn
     * @return true als het een geldige bsn
     */
    private boolean isGeldigAnummer(final AdministratienummerAttribuut aNummer) {
        final String waarde = aNummer.getWaarde().toString();

        return waarde.length() == ANUMMER_LENGTE && StringUtils.isNumeric(waarde) && voldoetAanRegel1(waarde)
            && voldoetAanRegel2(waarde) && voldoetAanRegel3(waarde) && voldoetAanRegel4(waarde);
    }

    /**
     * 1) a[0] <> 0.
     *
     * @param waarde de A-nummer
     * @return true als aan de regel voldoet
     */
    private boolean voldoetAanRegel1(final String waarde) {
        return Character.getNumericValue(waarde.charAt(0)) != 0;
    }

    /**
     * 2) a[i] <> a[i+1].
     *
     * @param waarde de A-nummer
     * @return true als aan de regel voldoet
     */
    private boolean voldoetAanRegel2(final String waarde) {
        boolean resultaat = true;

        for (int i = 0; i < waarde.length() - 1; i++) {
            if (Character.getNumericValue(waarde.charAt(i)) == Character.getNumericValue(waarde.charAt(i + 1))) {
                resultaat = false;
                break;
            }
        }

        return resultaat;
    }

    /**
     * 3) a[0]+a[1]+...+a[9] is deelbaar door 11 of a[0]+a[1]+...+a[9] deelbaar door 11 geeft rest 0 of rest 5.
     *
     * @param waarde de A-nummer
     * @return true als aan de regel voldoet
     */
    private boolean voldoetAanRegel3(final String waarde) {
        int som = 0;

        // a[0]+a[1]+...+a[9] is deelbaar door 11
        for (int i = 0; i < waarde.length(); i++) {
            som += Character.getNumericValue(waarde.charAt(i));
        }

        return som % ELF == REST_NUL || som % ELF == REST_VIJF;
    }

    /**
     * 4) (1*a[0])+(2*a[1])+(4*a[2])+...+(512*a[9]) is deelbaar door 11.
     *
     * @param waarde de A-nummer
     * @return true als aan de regel voldoet
     */
    private boolean voldoetAanRegel4(final String waarde) {
        int som = 0;
        int factor = 1;
        for (int i = 0; i < waarde.length(); i++) {
            som += Character.getNumericValue(waarde.charAt(i)) * factor;

            factor *= 2;
        }

        return som % ELF == REST_NUL;
    }
}
