/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Assert;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * XML Utility class voor unit tests.
 */
public final class XmlUtils {

    /**
     * Deze static variabele kunnen we gebruiken omdat onze unit testen niet multitreading zijn.
     * Dit versnelt het testen, omdat ze niet elke keer aangemaakt hoeven worden.
     */
    private static final DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
    private static DocumentBuilder        documentBuilder = null;
    private static final TransformerFactory     factory         = TransformerFactory.newInstance();
    private static Transformer            transformer     = null;
    private static XPath                  xpath           = null;
    private static final boolean                useNamespace    = true;

    private static final NamespaceContext nsCtx = new NamespaceContext() {
        private final String prefixBrp = "brp";
        private final String uriBrp = "http://www.bzk.nl/brp/brp0200";

        @SuppressWarnings("rawtypes")
        @Override
        public Iterator getPrefixes(final String namespaceURI) {
            return Arrays.asList(prefixBrp).iterator();
        }

        @Override
        public String getPrefix(final String namespaceURI) {
            return prefixBrp;
        }

        @Override
        public String getNamespaceURI(final String prefix) {
            return uriBrp;
        }
    };


    /**
     *  private constructor, omdat het om een final class gaat.
     */
    private XmlUtils() {

    }

    private static void initXpath() {
        if (null == xpath) {
            xpath = XPathFactory.newInstance().newXPath();
            if (useNamespace) {
                xpath.setNamespaceContext(nsCtx);
            }
        }
    }

    /**
     * Deze methode converteert een DOMtree object naar een XML string, zodat
     * dit menselijk leesbaar wordt en eventueel later naar een echte DOM
     * document geconverteerd kan worden.
     *
     * @param node de "root node"
     * @return een XML string of null als er iets fout gaat.
     * @throws javax.xml.transform.TransformerException transformatie exceptie
     */
    public static String toXmlString(final Node node) throws TransformerException {
        if (null == transformer) {
            transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        }
        final Source source = new DOMSource(node);
        final StringWriter stringWriter = new StringWriter();
        final Result result = new StreamResult(stringWriter);
        transformer.transform(source, result);

        return stringWriter.getBuffer().toString();
    }

    /**
     * Deze methode converteert een SOAPMessage object naar een XML string, zodat dit menselijk leesbaar wordt.
     * Letop dat dit niet ge-indent (geformatteerd is).
     *
     * @param msg de SOAPMsg bericht
     * @return de string respresentatie (of null value als msg is null)
     * @throws java.io.IOException als iets fout gaat
     * @throws javax.xml.soap.SOAPException als iets fout gaat
     */
    public static String toXmlString(final SOAPMessage msg) throws IOException, SOAPException {
        String soapMsgAsXml = null;
        if (msg != null) {
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            msg.writeTo(out);
            soapMsgAsXml = new String(out.toByteArray());
            out.close();
        }
        return soapMsgAsXml;
    }

    /**
     * Maakt een DOM Document object gebaseerd opeen xml string
     *
     * @param xmlString de xml string
     * @return het Document
     * @throws javax.xml.parsers.ParserConfigurationException in geval val misconfiguratie
     * @throws org.xml.sax.SAXException in geval van geen geldige xml
     * @throws java.io.IOException IO string buffer fouten
     */
    public static Document bouwDocument(final String xmlString) throws ParserConfigurationException, SAXException,
        IOException
    {
        if (null == documentBuilder) {
            documentFactory.setNamespaceAware(true);
            documentBuilder = documentFactory.newDocumentBuilder();
        }
        return documentBuilder.parse(new InputSource(new StringReader(xmlString)));
    }

    public static Document bouwDocumentVanBestand(final String berichtBestand) throws ParserConfigurationException,
        SAXException, IOException
    {
        final InputStream is = XmlUtils.class.getResourceAsStream(berichtBestand);
        if (null == is) {
            throw new IOException("Can't find file " + berichtBestand);
        }
        return documentBuilder.parse(is);
    }

    public static Document bouwDocumentVanBestand(final InputStream is) throws ParserConfigurationException,
        SAXException, IOException
    {
        return documentBuilder.parse(is);
    }

    /**
     * Geeft de string representatie van een element (plus alle onderliggende elementen)
     *
     * @param xpathExpression de xpath expressie
     * @param document het DOM Document
     * @return de text, lege string als het pad niet bestaat.
     * @throws javax.xml.xpath.XPathExpressionException ongeldige expressie.
     */
    public static String getNodeWaarde(final String xpathExpression, final Document document)
        throws XPathExpressionException
    {
        initXpath();
        return (String) xpath.evaluate(xpathExpression, document, XPathConstants.STRING);
    }

    /**
     * Geeft de waarde van een attribuut uit een node. Indien de opgegeven expressie meer dan een enkele node
     * vindt, dan zal zal van de eerste node de attribuutwaarde worden geretourneerd. Indien er geen node of het
     * attribuut niet op de node kan worden gevonden, dan zal er <code>null</code> worden geretourneerd.
     *
     * @param xpathExpression de xpath expressie
     * @param attribuutNaam de naam van het attribuut (inclusief namespace prefix opgeven)
     * @param document het DOM Document
     * @return de waarde van het attribuut.
     * @throws javax.xml.xpath.XPathExpressionException ongeldige expressie.
     */
    public static String getAttribuutWaarde(final String xpathExpression, final String attribuutNaam,
        final Document document) throws XPathExpressionException
    {
        String attribuutWaarde = null;

        initXpath();
        final NodeList nodes = (NodeList) xpath.evaluate(xpathExpression, document, XPathConstants.NODESET);
        if (nodes.getLength() > 0) {
            final Node attribuutNode = nodes.item(0).getAttributes().getNamedItem(attribuutNaam);
            if (attribuutNode != null) {
                attribuutWaarde = attribuutNode.getNodeValue();
            }
        }
        return attribuutWaarde;
    }

    /**
     * Geeft het aantal noden dat voldoet aan de xpath expressie.
     *
     * @param xpathExpression de xpath expressie
     * @param document het DOM document
     * @return het aantal nodes (0 als niet gevonden)
     * @throws javax.xml.xpath.XPathExpressionException exceptie
     */
    public static Integer getNodeCount(final String xpathExpression, final Document document)
        throws XPathExpressionException
    {
        initXpath();
        return ((NodeList) xpath.evaluate(xpathExpression, document, XPathConstants.NODESET)).getLength();
    }

    /**
     * Test of een node bestaat.
     *
     * @param nodePath de xpath expressie
     * @param document het DOM document
     * @return true als de node bestaat, false anders.
     * @throws javax.xml.xpath.XPathExpressionException
     */
    public static boolean isNodeAanwezig(final String nodePath, final Document document)
        throws XPathExpressionException
    {
        initXpath();
        final Object o = xpath.evaluate(nodePath, document, XPathConstants.NODE);
        return (null != o);
    }

    /**
     * Valideert de opgegeven output XML tegen het schema. Middels assertions ({@link org.junit.Assert#fail(String)})
     * worden eventuele fouten aan de unit testing framework doorgegeven.
     *
     * @param outputXml de output xml die gevalideerd moet worden.
     * @param schemaBestand de relatieve locatie (classpath) + bestandsnaam van de xsd.
     */
    public static void valideerOutputTegenSchema(final String outputXml, final String schemaBestand) {
        try {
            final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            final Schema schema = schemaFactory.newSchema(XmlUtils.class.getResource("/xsd/BRP0200/" + schemaBestand).toURI().toURL());
            final Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(outputXml)));
        } catch (SAXException | IOException | URISyntaxException e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Vervang de waarde van een DOM attribuut in een Document. Dit gebruiken we om objectSleutels in te vullen
     * in de integratie testen van bijhouding.
     * @param attribuutNodeXPathExpressie xpath naar attribuut in de DOM
     * @param nieuweWaarde de nieuwe waarde.
     * @param document de DOM
     */
    public static void vervangAttribuutWaarde(final String attribuutNodeXPathExpressie, final String nieuweWaarde,
                                       final Document document)
    {
        try {
            initXpath();
            final XPathExpression expressie = xpath.compile(attribuutNodeXPathExpressie);
            final Object resultaatNode = expressie.evaluate(document, XPathConstants.NODE);
            if (!(resultaatNode instanceof Attr)) {
                throw new IllegalArgumentException("De XPath expressie wijst niet naar een objectSleutel attribuut,"
                                                           + " controleer de expressie: "
                                                           + attribuutNodeXPathExpressie);
            } else {
                final Attr attribuut = (Attr) resultaatNode;
                attribuut.setValue(nieuweWaarde);
            }
        } catch (final XPathExpressionException e) {
            throw new IllegalArgumentException("De XPath expressie klopt niet,"
                                                       + " controleer de expressie: "
                                                       + attribuutNodeXPathExpressie);

        }

    }

}
