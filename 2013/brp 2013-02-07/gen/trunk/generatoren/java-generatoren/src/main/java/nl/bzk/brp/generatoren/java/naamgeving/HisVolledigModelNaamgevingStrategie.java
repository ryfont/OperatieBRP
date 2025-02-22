/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.generatoren.java.naamgeving;

import nl.bzk.brp.generatoren.java.util.GeneratiePackage;
import nl.bzk.brp.metaregister.model.Groep;
import nl.bzk.brp.metaregister.model.ObjectType;
import nl.bzk.brp.metaregister.model.Tuple;

/**
 * Naamgeving strategie voor het model dat gegenereerd wordt voor his volledig.
 */
public class HisVolledigModelNaamgevingStrategie extends AbstractModelSpecifiekeNaamgevingStrategie {

    @Override
    protected GeneratiePackage getModelSpecifiekePackageVoorObjectTypes() {
        return GeneratiePackage.OBJECTTYPE_HISVOLLEDIG_PACKAGE;
    }

    @Override
    protected GeneratiePackage getModelSpecifiekePackageVoorGroepen() {
        throw new UnsupportedOperationException("Het his volledig model kent geen klassen voor groepen.");
    }

    @Override
    protected GeneratiePackage getModelSpecifiekePackageVoorTuples() {
        throw new UnsupportedOperationException("Het his volledig model kent geen klassen voor tuples.");
    }

    @Override
    protected PrefixSuffix getModelSpecifiekePrefixSuffixVoorObjectType(final ObjectType element) {
        return new PrefixSuffix("", "HisVolledig");
    }

    @Override
    protected PrefixSuffix getModelSpecifiekePrefixSuffixVoorGroep(final Groep element) {
        throw new UnsupportedOperationException("Het his volledig model kent geen klassen voor groepen.");
    }

    @Override
    protected PrefixSuffix getModelSpecifiekePrefixSuffixVoorTuple(final Tuple element) {
        throw new UnsupportedOperationException("Het his volledig model kent geen klassen voor tuples.");
    }

}
