/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.voisc.spd.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import nl.bzk.migratiebrp.voisc.spd.constants.MessagesCodes;
import nl.bzk.migratiebrp.voisc.spd.exception.ConnectionException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementation of the X509TrustManager. The main responsibility of this class is that an other than the "default"
 * TrustStore can be used.
 */
public class VoiscTrustManager implements X509TrustManager {

    private static final Log LOGGER = LogFactory.getLog(VoiscTrustManager.class);
    private final X509TrustManager sunX509TrustManager;

    /**
     * Constructor.
     * 
     * @param trustStore
     *            is String with path + filename of the TrustStore file (jks)
     */
    VoiscTrustManager(final File trustStore) {
        final TrustManagerFactory tmf;
        try {
            final KeyStore ks = KeyStore.getInstance("JKS");
            try (FileInputStream trustStoreInputStream = new FileInputStream(trustStore)) {
                ks.load(trustStoreInputStream, null);
            }
            tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ks);
            sunX509TrustManager = (X509TrustManager) tmf.getTrustManagers()[0];
        } catch (final
            NoSuchAlgorithmException
            | CertificateException
            | KeyStoreException
            | IOException e)
        {
            throw new ConnectionException(MessagesCodes.ERRMSG_VOSPG_SSL_CONNECTION_ERROR, null, e);
        }
    }

    /**
     * Given the partial or complete certificate chain provided by the peer, build a certificate path to a trusted root
     * and return if it can be validated and is trusted for server SSL authentication based on the authentication type.
     * 
     * @param chain
     *            X509 Certificate chain
     * @param authType
     *            Autorisatie type
     */
    @Override
    public final void checkServerTrusted(final X509Certificate[] chain, final String authType) {
        LOGGER.debug("checkServerTrusted: authType: " + authType);
        try {
            sunX509TrustManager.checkServerTrusted(chain, authType);
        } catch (final CertificateException excep) {
            // do any special handling, such as popping up dialog boxes, prompting the user, etc.
            throw new ConnectionException(MessagesCodes.ERRMSG_VOSPG_SSL_CONNECTION_ERROR, null, excep);
        }
    }

    /**
     * Return an array of certificate authority certificates which are trusted for authenticating peers.
     * 
     * @return een array met geaccepteerde uitgevers van certificaten
     */
    @Override
    public final X509Certificate[] getAcceptedIssuers() {
        return sunX509TrustManager.getAcceptedIssuers();
    }

    /**
     * Given the partial or complete certificate chain provided by the peer, build a certificate path to a trusted root
     * and return if it can be validated and is trusted for client SSL authentication based on the authentication type.
     * 
     * @param chain
     *            X509 Certificate ketting
     * @param authType
     *            Autorisatie type
     * 
     */
    @Override
    public final void checkClientTrusted(final X509Certificate[] chain, final String authType) {
        LOGGER.info("checkClientTrusted: " + authType);
    }
}
