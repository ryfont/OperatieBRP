/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.bevraging.business.dto;

import nl.bzk.brp.bevraging.domein.Partij;
import nl.bzk.brp.bevraging.domein.aut.AuthenticatieMiddel;
import nl.bzk.brp.bevraging.domein.lev.Abonnement;
import org.springframework.transaction.TransactionStatus;


/**
 * De context rond een BRP bericht. Deze context bevat additionele (niet bericht-type
 * specifieke) informatie zoals afzender, abonnement, bericht id etc.
 */
public class BerichtContext {

    private Long                partijId;
    private Long                abonnementId;
    private Long                authenticatieMiddelId;
    // TODO: tim - Domein objecten horen niet in een DTO; dit is NIET goed !!
    private Partij              partij;
    private Abonnement          abonnement;
    private AuthenticatieMiddel authenticatieMiddel;

    private Long                ingaandBerichtId;
    private Long                uitgaandBerichtId;
    private TransactionStatus   businessTransactionStatus;

    /**
     * Retourneert het id van de partij die het bericht heeft verstuurd.
     *
     * @return het id van de partij.
     */
    public Long getPartijId() {
        return partijId;
    }

    /**
     * Zet het id van de partij die het bericht heeft verstuurd.
     *
     * @param partijId het id van de partij.
     */
    public void setPartijId(final Long partijId) {
        this.partijId = partijId;
    }

    /**
     * Retourneert de partij die het bericht uitvoert.
     *
     * @return de partij die het bericht uitvoert.
     */
    public Partij getPartij() {
        return partij;
    }

    /**
     * Zet de partij die het bericht uitvoert.
     *
     * @param partij de partij die het bericht uitvoert.
     */
    public void setPartij(final Partij partij) {
        this.partij = partij;
    }

    /**
     * Retourneert het id van het abonnement conform welke het bericht wordt uitgevoerd.
     *
     * @return het id van het abonnement.
     */
    public Long getAbonnementId() {
        return abonnementId;
    }

    /**
     * Zet het id van het abonnement conform welke het bericht wordt uitgevoerd.
     *
     * @param abonnementId het id van het abonnement.
     */
    public void setAbonnementId(final Long abonnementId) {
        this.abonnementId = abonnementId;
    }

    /**
     * Retourneert het abonnement waaronder het bericht wordt uitgevoerd.
     *
     * @return het abonnement waaronder het bericht wordt uitgevoerd.
     */
    public Abonnement getAbonnement() {
        return abonnement;
    }

    /**
     * Zet het abonnement waaronder het bericht wordt uitgevoerd.
     *
     * @param abonnement het abonnement waaronder het bericht wordt uitgevoerd.
     */
    public void setAbonnement(final Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    /**
     * Retourneert het id van het authenticatie middel waarmee de partij zich voor het bericht heeft geautenticeerd.
     *
     * @return het id van het authenticatie middel.
     */
    public Long getAuthenticatieMiddelId() {
        return authenticatieMiddelId;
    }

    /**
     * Zet het id van het authenticatie middel waarmee de partij zich voor het bericht heeft geautenticeerd.
     *
     * @param authenticatieMiddelId het id van het authenticatie middel.
     */
    public void setAuthenticatieMiddelId(final Long authenticatieMiddelId) {
        this.authenticatieMiddelId = authenticatieMiddelId;
    }

    /**
     * Retourneert het authenticatie middel waarmee de partij zich voor het bericht heeft geautenticeerd.
     *
     * @return het authenticatie middel waarmee de partij zich voor het bericht heeft geautenticeerd.
     */
    public AuthenticatieMiddel getAuthenticatieMiddel() {
        return authenticatieMiddel;
    }

    /**
     * Zet het authenticatie middel waarmee de partij zich voor het bericht heeft geautenticeerd.
     *
     * @param authenticatieMiddel het authenticatie middel waarmee de partij zich voor het bericht heeft geautenticeerd.
     */
    public void setAuthenticatieMiddel(final AuthenticatieMiddel authenticatieMiddel) {
        this.authenticatieMiddel = authenticatieMiddel;
    }

    /**
     * Retourneert het id van het ingaande bericht.
     *
     * @return het id van het bericht.
     */
    public Long getIngaandBerichtId() {
        return ingaandBerichtId;
    }

    /**
     * Zet het id van het ingaande bericht.
     *
     * @param ingaandBerichtId het id van het bericht.
     */
    public void setIngaandBerichtId(final Long ingaandBerichtId) {
        this.ingaandBerichtId = ingaandBerichtId;
    }

    /**
     * Retourneert het id van het uitgaande bericht.
     *
     * @return het id van het bericht.
     */
    public Long getUitgaandBerichtId() {
        return uitgaandBerichtId;
    }

    /**
     * Zet het id van het uitgaande bericht.
     *
     * @param uitgaandBerichtId het id van het bericht.
     */
    public void setUitgaandBerichtId(final Long uitgaandBerichtId) {
        this.uitgaandBerichtId = uitgaandBerichtId;
    }

    /**
     * De transactie waar we personen e.d. mee selecteren en muteren
     *
     * @return de transactie
     */
    public TransactionStatus getBusinessTransactionStatus() {
        return businessTransactionStatus;
    }

    /**
     * De transactie waar we personen e.d. mee selecteren en muteren
     *
     * @param businessTransactionStatus de transactie
     */
    public void setBusinessTransactionStatus(final TransactionStatus businessTransactionStatus) {
        this.businessTransactionStatus = businessTransactionStatus;
    }

    /**
     * Verwijdert de businesstransactie uit het object.
     */

    public void clearBusinessTransactionStatus() {
        if (businessTransactionStatus != null && !businessTransactionStatus.isCompleted()) {
            throw new IllegalArgumentException(
                    "De businesstransactie mag niet ge-cleared worden als hij niet completed is");
        }
        businessTransactionStatus = null;
    }

}
