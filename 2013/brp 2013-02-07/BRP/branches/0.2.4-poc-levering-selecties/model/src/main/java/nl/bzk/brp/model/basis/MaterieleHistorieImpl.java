/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.basis;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import nl.bzk.brp.model.attribuuttype.Datum;
import nl.bzk.brp.model.attribuuttype.DatumTijd;
import nl.bzk.brp.model.objecttype.operationeel.ActieModel;
import nl.bzk.brp.util.ExternalReaderService;
import nl.bzk.brp.util.ExternalWriterService;


/**
 * Deze class bevat velden voor Materiele en Formele Historie.
 *
 */
@Embeddable
@Access(AccessType.FIELD)
public class MaterieleHistorieImpl extends FormeleHistorieImpl implements MaterieleHistorie, Externalizable {

    @AttributeOverride(name = "waarde", column = @Column(name = "dataanvgel"))
    @JsonProperty
    private Datum      datumAanvangGeldigheid;

    @AttributeOverride(name = "waarde", column = @Column(name = "dateindegel"))
    @JsonProperty
    private Datum      datumEindeGeldigheid;

    @ManyToOne
    @JoinColumn(name = "actieaanpgel")
    @JsonProperty
    private ActieModel actieAanpassingGeldigheid;

    /**
     * Default constructor.
     */
    public MaterieleHistorieImpl() {

    }

    /**
     * Copy constructor.
     *
     * @param historie MaterieleHistorieImpl
     */
    public MaterieleHistorieImpl(final MaterieleHistorieImpl historie) {
        super(historie);
        datumAanvangGeldigheid = historie.getDatumAanvangGeldigheid();
        datumEindeGeldigheid = historie.getDatumEindeGeldigheid();
        actieAanpassingGeldigheid = historie.getActieAanpassingGeldigheid();
    }

    @Override
    public Datum getDatumAanvangGeldigheid() {
        return datumAanvangGeldigheid;
    }

    @Override
    public void setDatumAanvangGeldigheid(final Datum datum) {
        datumAanvangGeldigheid = datum;

    }

    @Override
    public Datum getDatumEindeGeldigheid() {
        return datumEindeGeldigheid;
    }

    @Override
    public void setDatumEindeGeldigheid(final Datum datum) {
        datumEindeGeldigheid = datum;
    }

    @Override
    public ActieModel getActieAanpassingGeldigheid() {
        return actieAanpassingGeldigheid;
    }

    @Override
    public void setActieAanpassingGeldigheid(final ActieModel actie) {
        actieAanpassingGeldigheid = actie;
    }

    @Override
    public MaterieleHistorie kopieer() {
        return new MaterieleHistorieImpl(this);
    }

	@Override
	public void writeExternal(final ObjectOutput out) throws IOException {
		ExternalWriterService.schrijfNullableObject(out, getActieAanpassingGeldigheid());
		ExternalWriterService.schrijfNullableObject(out, getActieInhoud());
		ExternalWriterService.schrijfNullableObject(out, getActieVerval());
		out.writeObject(getDatumAanvangGeldigheid() != null ? getDatumAanvangGeldigheid().getWaarde() : null);
		out.writeObject(getDatumEindeGeldigheid() != null ? getDatumEindeGeldigheid().getWaarde() : null);
		out.writeObject(getDatumTijdRegistratie() != null ? getDatumTijdRegistratie().getWaarde().getTime() : null);
		out.writeObject(getDatumTijdVerval() != null ? getDatumTijdVerval().getWaarde().getTime() : null);
	}

	@Override
	public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
		setActieAanpassingGeldigheid((ActieModel) ExternalReaderService.leesNullableObject(in, ActieModel.class));
		setActieInhoud((ActieModel) ExternalReaderService.leesNullableObject(in, ActieModel.class));
		setActieVerval((ActieModel) ExternalReaderService.leesNullableObject(in, ActieModel.class));

		setDatumAanvangGeldigheid((Datum) ExternalReaderService.leesWaarde(in, Datum.class));
		setDatumEindeGeldigheid((Datum) ExternalReaderService.leesWaarde(in, Datum.class));
		setDatumTijdRegistratie((DatumTijd) ExternalReaderService.leesWaarde(in, DatumTijd.class));
		setDatumTijdVerval((DatumTijd) ExternalReaderService.leesWaarde(in, DatumTijd.class));
	}

}
