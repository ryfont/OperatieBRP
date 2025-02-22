/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.bevraging.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import javax.inject.Inject;

import nl.bzk.brp.bevraging.app.ContextParameterNames;
import nl.bzk.brp.bevraging.app.support.PersoonIdentificatie;
import nl.bzk.brp.bevraging.app.support.PersoonsLijst;
import nl.bzk.brp.bevraging.dataaccess.PersoonsLijstService;
import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Bevraag de database met behulp van JPA.
 */
@Service
public class BevraagPersoonVolledigDirectStap extends AbstractAsynchroonStap {

    private static final Logger LOGGER = LoggerFactory.getLogger(BevraagPersoonVolledigDirectStap.class);

    @Inject
    private PersoonsLijstService persoonsLijstService;

    @Override
    @Transactional
    public boolean doExecute(final Context context) throws Exception {
        List<PersoonIdentificatie> persoonIdentificaties = (List) context.get(ContextParameterNames.BSNLIJST);
        List<Future<BevraagInfo>> futures = new ArrayList<Future<BevraagInfo>>(persoonIdentificaties.size());

        for (PersoonIdentificatie identificatie : persoonIdentificaties) {
            futures.add(this.taskExecutor.submit(new BevraagDB(identificatie)));
        }

        List<BevraagInfo> results = new ArrayList<BevraagInfo>(persoonIdentificaties.size());
        for (Future<BevraagInfo> future : futures) {
            BevraagInfo info = future.get();
            results.add(info);
            LOGGER.info("Gevraagd BSN '{}' in {} ms", info.getTaskName(), info.getTimeMillis());
        }

        // opslaan resultaten
        context.put(ContextParameterNames.TASK_INFO_LIJST, results);

        return CONTINUE_PROCESSING;
    }

    /**
     * Bevraag de database.
     */
    class BevraagDB implements Callable<BevraagInfo> {
        private PersoonIdentificatie ident;

        /**
         * Constructor.
         * @param identificatie om de DB mee te bevragen
         */
        public BevraagDB(final PersoonIdentificatie identificatie) {
            this.ident = identificatie;
        }

        @Override
        public BevraagInfo call() {
            boolean success = true;
            long startTimeMillis = System.currentTimeMillis();

            try {
                PersoonsLijst lijst = persoonsLijstService.findPersoonVolledigLijst(ident.getId());
            } catch (Exception e) {
                success = false;
                LOGGER.error("Fout in uitvoeren BevraagPersoonVolledigDirectStap.", e);
            }

            long duration = System.currentTimeMillis() - startTimeMillis;
            return new BevraagInfo(ident.toString(), (success ? "OK" : "FAIL"), duration);
        }
    }
}
