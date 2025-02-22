/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.mutatielevering.jmx;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.support.MetricType;
import org.springframework.stereotype.Component;

/**
 */
@Component
@ManagedResource(
    objectName = "nl.bzk.brp:name=MutatieLevering",
    description = "Metriek mbt MutatieLevering")
public class MutatieLeveringInfoBean {


    private static final int DUIZEND = 1000;
    private Long start;

    /**
     * Atomic (optimistisch) tellertje aantal afnemer berichten
     */
    private final AtomicInteger afnemerBericht = new AtomicInteger();

    /**
     * Atomic (optimistisch) tellertje voor aantal handelingen
     */
    private final AtomicInteger aantalHandelingen = new AtomicInteger();

    /**
     * Atomic (optimistisch) tellertje voor de totale doorlooptijd voor
     * het verwerken van handelingen
     */
    private final AtomicLong handelingenTijd = new AtomicLong();

    /**
     * Geeft het afnemer bericht.
     *
     * @return afnemer bericht
     */
    @ManagedMetric(category = "metrieken", displayName = "Aantal berichten dat geplaatst is op afnemer queues",
        description = "Aantal berichten dat geplaatst is op afnemer queues",
        metricType = MetricType.COUNTER, unit = "berichten")
    public int getAfnemerBericht() {
        return afnemerBericht.get();
    }

    /**
     * Geeft het aantal handelingen.
     *
     * @return het aantal handelingen
     */
    @ManagedMetric(category = "metrieken", displayName = "Aantal handelingen",
        description = "Aantal handelingen",
        metricType = MetricType.COUNTER, unit = "berichten")
    public int getAantal() {
        return aantalHandelingen.get();
    }

    /**
     * Geeft gemiddelde tijd per handeling.
     *
     * @return gemiddelde tijd per handeling
     */
    @ManagedMetric(category = "metrieken", displayName = "Gemiddelde doorlooptijd per handeling",
        description = "Gemiddelde doorlooptijd per handeling",
        metricType = MetricType.GAUGE, unit = "berichten")
    public int getGemiddeldeTijdPerHandeling() {
        return (int) (handelingenTijd.get() / aantalHandelingen.get());
    }

    /**
     * Geeft aantal handelingen per seconde.
     *
     * @return aantal handelingen per seconde
     */
    @ManagedMetric(category = "metrieken", displayName = "Aantal handelingen per seconde systeemtijd",
        description = "Aantal handelingen per seconde",
        metricType = MetricType.GAUGE, unit = "berichten")
    public double getHandelingenPerSeconde() {
        final long looptijd = System.currentTimeMillis() - start;
        return ((double) aantalHandelingen.get() / looptijd) * DUIZEND;
    }

    /**
     * Geeft aantal afnemer berichten per seconde.
     *
     * @return aantal afnemer berichten per seconde
     */
    @ManagedMetric(category = "metrieken", displayName = "Aantal afnemerberichten per seconde systeemtijd",
        description = "Aantal afnemerberichten per seconde",
        metricType = MetricType.GAUGE, unit = "berichten")
    public double getAfnemerBerichtenPerSeconde() {
        final long looptijd = System.currentTimeMillis() - start;
        return ((double) afnemerBericht.get() / looptijd) * DUIZEND;
    }

    /**
     * Increment aantal geleverde berichten.
     */
    public void incrementAfnemerBericht() {
        afnemerBericht.incrementAndGet();
    }

    /**
     * Increment handeling.
     *
     * @param duur duur
     */
    public void incrementHandeling(final long duur) {
        if (start == null) {
            start = System.currentTimeMillis();
        }
        aantalHandelingen.incrementAndGet();
        handelingenTijd.addAndGet(duur);
    }
}
