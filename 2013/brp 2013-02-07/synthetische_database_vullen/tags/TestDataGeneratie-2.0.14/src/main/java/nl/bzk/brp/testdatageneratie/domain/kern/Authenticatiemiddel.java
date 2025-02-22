/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 21-dec-2012 11:50:17 by Hibernate Tools 3.2.4.GA



/**
 * Authenticatiemiddel generated by hbm2java
 */
public class Authenticatiemiddel  implements java.io.Serializable {


     private Integer id;
     private Partij partij;
     private Functie functie;
     private Rol rol;
     private Certificaat certificaatByCertificaattbvssl;
     private Certificaat certificaatByCertificaattbvondertekening;
     private String ipadres;
     private String authenticatiemiddelstatushis = StatusHis.A.name();

    public Authenticatiemiddel() {
    }


    public Authenticatiemiddel(Partij partij, String authenticatiemiddelstatushis) {
        this.partij = partij;
        this.authenticatiemiddelstatushis = authenticatiemiddelstatushis;
    }
    public Authenticatiemiddel(Partij partij, Functie functie, Rol rol, Certificaat certificaatByCertificaattbvssl, Certificaat certificaatByCertificaattbvondertekening, String ipadres, String authenticatiemiddelstatushis) {
       this.partij = partij;
       this.functie = functie;
       this.rol = rol;
       this.certificaatByCertificaattbvssl = certificaatByCertificaattbvssl;
       this.certificaatByCertificaattbvondertekening = certificaatByCertificaattbvondertekening;
       this.ipadres = ipadres;
       this.authenticatiemiddelstatushis = authenticatiemiddelstatushis;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Partij getPartij() {
        return this.partij;
    }

    public void setPartij(Partij partij) {
        this.partij = partij;
    }
    public Functie getFunctie() {
        return this.functie;
    }

    public void setFunctie(Functie functie) {
        this.functie = functie;
    }
    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public Certificaat getCertificaatByCertificaattbvssl() {
        return this.certificaatByCertificaattbvssl;
    }

    public void setCertificaatByCertificaattbvssl(Certificaat certificaatByCertificaattbvssl) {
        this.certificaatByCertificaattbvssl = certificaatByCertificaattbvssl;
    }
    public Certificaat getCertificaatByCertificaattbvondertekening() {
        return this.certificaatByCertificaattbvondertekening;
    }

    public void setCertificaatByCertificaattbvondertekening(Certificaat certificaatByCertificaattbvondertekening) {
        this.certificaatByCertificaattbvondertekening = certificaatByCertificaattbvondertekening;
    }
    public String getIpadres() {
        return this.ipadres;
    }

    public void setIpadres(String ipadres) {
        this.ipadres = ipadres;
    }
    public String getAuthenticatiemiddelstatushis() {
        return this.authenticatiemiddelstatushis;
    }

    public void setAuthenticatiemiddelstatushis(String authenticatiemiddelstatushis) {
        this.authenticatiemiddelstatushis = authenticatiemiddelstatushis;
    }




}


