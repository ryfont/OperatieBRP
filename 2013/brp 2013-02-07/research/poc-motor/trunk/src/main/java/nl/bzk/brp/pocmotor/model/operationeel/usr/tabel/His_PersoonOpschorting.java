/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.pocmotor.model.operationeel.usr.tabel;

import javax.persistence.Entity;
import javax.persistence.Table;

import nl.bzk.brp.pocmotor.model.operationeel.gen.tabel.AbstractHis_PersoonOpschorting;

/**
 * His Persoon Opschorting
  */
@Entity(name = "His_PersoonOpschortingOperationeel")
@Table(schema = "Kern", name = "His_PersOpschorting")
public class His_PersoonOpschorting extends AbstractHis_PersoonOpschorting {

}
