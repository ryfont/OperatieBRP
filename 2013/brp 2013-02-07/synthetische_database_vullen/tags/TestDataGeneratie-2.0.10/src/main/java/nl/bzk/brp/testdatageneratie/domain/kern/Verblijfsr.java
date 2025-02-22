/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;

import nl.bzk.brp.testdatageneratie.dataaccess.Cacheable;



/**
 * Verblijfsr generated by hbm2java
 */
public class Verblijfsr  implements Cacheable<Short> {


     private short id;
     private String oms;
     private short   code;
     private Integer dataanvgel;
     private Integer dateindegel;

    public Verblijfsr() {
    }

    public short getId() {
        return this.id;
    }

    public void setId(short id) {
        this.id = id;
    }
    public String getOms() {
        return this.oms;
    }

    public void setOms(String oms) {
        this.oms = oms;
    }
    public Integer getDataanvgel() {
        return this.dataanvgel;
    }

    public void setDataanvgel(Integer dataanvgel) {
        this.dataanvgel = dataanvgel;
    }
    public Integer getDateindegel() {
        return this.dateindegel;
    }

    public void setDateindegel(Integer dateindegel) {
        this.dateindegel = dateindegel;
    }

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }

    @Override
    public Short getKey() {
        return this.code;
    }

}


