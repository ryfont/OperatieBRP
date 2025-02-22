/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.pocmotor.model.operationeel.gen.tabel;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import nl.bzk.brp.pocmotor.model.basis.impl.AbstractMaterieleEnFormeleHisTabel;
import nl.bzk.brp.pocmotor.model.gedeeld.usr.attribuuttype.His_BetrokkenheidOuderID;
import nl.bzk.brp.pocmotor.model.gedeeld.usr.attribuuttype.Ja;
import nl.bzk.brp.pocmotor.model.operationeel.usr.tabel.Betrokkenheid;


/**
 * His Betrokkenheid Ouder

 * Generated Abstract Class
  */
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractHis_BetrokkenheidOuder extends AbstractMaterieleEnFormeleHisTabel {

   @Transient
   protected His_BetrokkenheidOuderID id;

   @ManyToOne
   @JoinColumn(name = "Betr")
   protected Betrokkenheid betrokkenheid;

   @AttributeOverride(name = "waarde", column = @Column(name = "IndOuder"))
   protected Ja indicatieOuder;


   @Id
   @SequenceGenerator(name = "seq_His_BetrOuder", sequenceName = "Kern.seq_His_BetrOuder")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_His_BetrOuder")
   @Access(AccessType.PROPERTY)
   public Long getId() {
      if (id != null) {
         return id.getWaarde();
      }
      return null;
   }

   public void setId(final Long value) {
      if (id == null) {
          id = new His_BetrokkenheidOuderID();
      }
      id.setWaarde(value);
   }

   public Betrokkenheid getBetrokkenheid() {
      return betrokkenheid;
   }

   public void setBetrokkenheid(final Betrokkenheid betrokkenheid) {
      this.betrokkenheid = betrokkenheid;
   }

   public Ja getIndicatieOuder() {
      return indicatieOuder;
   }

   public void setIndicatieOuder(final Ja indicatieOuder) {
      this.indicatieOuder = indicatieOuder;
   }



}
