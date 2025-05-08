/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.muzickaKompozicija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.MuzickaKompozicija;
import domain.UlogaKompozicije;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOUpdateMuzickaKompozicija extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof MuzickaKompozicija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase MuzickaKompozicija!");
        }

        MuzickaKompozicija mk = (MuzickaKompozicija) ado;

        ArrayList<MuzickaKompozicija> muzickeKompozicije
                = (ArrayList<MuzickaKompozicija>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (MuzickaKompozicija muzickaKompozicija : muzickeKompozicije) {
            if (!muzickaKompozicija.getMuzickaKompozicijaID().equals(mk.getMuzickaKompozicijaID())) {
                if (muzickaKompozicija.getNazivKompozicije().equals(mk.getNazivKompozicije())) {
                    throw new Exception("Vec postoji muzicka kompozicija s tim nazivom!");
                }
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
        DBBroker.getInstance().update(ado);
        
        MuzickaKompozicija mk = (MuzickaKompozicija) ado;

        DBBroker.getInstance().delete(mk.getUlogeKompozicije().get(0));
        
        for (UlogaKompozicije ulogaKompozicije : mk.getUlogeKompozicije()) {
            DBBroker.getInstance().insert(ulogaKompozicije);
        }
        
    }

}
