/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.basis;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;


/**
 * Basis klasse voor alle objecttypen, zowel dynamische als statische.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
abstract class AbstractObjectType implements ObjectType {

}
