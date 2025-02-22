/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.moderniseringgba.migratie.synchronisatie.domein.brp.kern.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Parser geoptimaliseerd voor het opvragen van een enum o.b.v. een id of code.
 * 
 * @param <E>
 *            Het concrete enumeratie-type.
 */
public class EnumParser<E extends Enumeratie> {
    private final Map<Integer, E> enumaratiesOpId;
    private final Map<String, E> enumaratiesOpCode;
    /**
     * Foutmelding inclusief verwijzing naar de juiste enum-class.
     */
    private final String foutmelding;

    /**
     * Maakt een concrete enumparser aan voor het meegegeven enumeratietype.
     * 
     * @param clazz
     *            Het enumeratietype
     */
    public EnumParser(final Class<E> clazz) {
        enumaratiesOpId = maakIndexVanEnumeratieOpId(clazz);
        enumaratiesOpCode = maakIndexVanEnumeratieOpCode(clazz);
        foutmelding = "Geen enumeratiewaarde van het type " + clazz.getName() + " voor %s %s";
    }

    private Map<Integer, E> maakIndexVanEnumeratieOpId(final Class<E> clazz) {
        final Map<Integer, E> result = new HashMap<Integer, E>();
        for (final E sge : clazz.getEnumConstants()) {
            result.put(sge.getId(), sge);
        }
        return result;
    }

    private Map<String, E> maakIndexVanEnumeratieOpCode(final Class<E> clazz) {
        final Map<String, E> result = new HashMap<String, E>();
        for (final E sge : clazz.getEnumConstants()) {
            if (sge.heeftCode()) {
                result.put(sge.getCode(), sge);
            }
        }
        return result;
    }

    /**
     * Geeft een enumeratiewaarde van type {@link E} terug o.b.v. het database-ID.
     * 
     * @param id
     *            het database-id van de enumeratie. Mag null zijn, in dat geval wordt ook null geretourneerd.
     * @return Een enumeratiewaarde van type {@link E}, of null.
     * @throws IllegalArgumentException
     *             als de enumeratiewaarde met bijbehorend id niet gevonden kon worden.
     */
    public final E parseId(final Integer id) {
        if (id == null) {
            return null;
        }
        final E result = enumaratiesOpId.get(id);
        if (result == null) {
            throw new IllegalArgumentException(String.format(foutmelding, "id", id));
        }
        return result;
    }

    /**
     * Geeft een enumeratiewaarde van type {@link E} terug o.b.v. de code.
     * 
     * @param code
     *            De functionele code van de enumeratie. Mag null zijn, in dat geval wordt ook null geretourneerd.
     * 
     * @return Een enumeratiewaarde van type {@link E}, of null als het argument code null is
     * @throws IllegalArgumentException
     *             als de enumeratiewaarde met bijbehorende code niet gevonden kon worden.
     */
    public final E parseCode(final String code) {
        if (code == null) {
            return null;
        }
        final E result = enumaratiesOpCode.get(code);
        if (result == null) {
            throw new IllegalArgumentException(String.format(foutmelding, "code", code));
        }
        return result;
    }
}
