/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.beheer.webapp.controllers.stamgegevens.conv;

import javax.inject.Named;

import nl.bzk.brp.beheer.webapp.configuratie.ControllerConstants;
import nl.bzk.brp.beheer.webapp.controllers.AbstractReadWriteController;
import nl.bzk.brp.beheer.webapp.repository.ReadWriteRepository;
import nl.bzk.brp.model.beheer.conv.ConversieRedenBeeindigenNationaliteit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConversieSoortNLReisdocument controller.
 */
@RestController
@RequestMapping(value = ControllerConstants.CONVERSIE_REDEN_BEEINDIGEN_NATIONALITEIT_URI)
public final class ConversieRedenBeeindigenNationaliteitController extends AbstractReadWriteController<ConversieRedenBeeindigenNationaliteit, Integer> {

    /**
     * Constructor.
     *
     * @param repository repository
     */
    @Autowired
    protected ConversieRedenBeeindigenNationaliteitController(
            @Named("conversieRedenBeeindigenNationaliteitRepository") final ReadWriteRepository<ConversieRedenBeeindigenNationaliteit, Integer> repository)
    {
        super(repository);
    }

}
