/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.binding;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Assert;
import org.xml.sax.SAXException;


/**
 *
 */
public abstract class AbstractBindingIntegratieTest<T> {

    protected static final String NAMESPACE_BRP = "http://www.bzk.nl/brp/brp0200";

    /**
     * Retourneert de class van het object dat gemarshalled en geunmarshalled moet worden.
     *
     * @return de class van het object dat gemarshalled en geunmarshalled moet worden.
     */
    protected abstract Class<T> getBindingClass();

    /**
     * Valideert de opgegeven output XML tegen het schema. Middels assertions ({@link org.junit.Assert#fail(String)})
     * worden
     * eventuele fouten aan de unit testing framework doorgegeven.
     *
     * @param xml de output xml die gevalideerd moet worden.
     */
    protected void valideerTegenSchema(final String xml) {
        try {
            final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema =
                    factory.newSchema(new StreamSource(new File(AbstractBindingUitIntegratieTest.class.getResource(
                            "/xsd/BRP0200/" + getSchemaBestand()).toURI())));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(xml)));
        } catch (SAXException | IOException | URISyntaxException e) {
            Assert.fail(e.getMessage());
        }
    }

    protected abstract String getSchemaBestand();
}
