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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOAddMuzickaKompozicija extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof MuzickaKompozicija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase MuzickaKompozicija!");
        }

        MuzickaKompozicija mk = (MuzickaKompozicija) ado;

        ArrayList<MuzickaKompozicija> muzickeKompozicije
                = (ArrayList<MuzickaKompozicija>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (MuzickaKompozicija muzickaKompozicija : muzickeKompozicije) {
            if (muzickaKompozicija.getNazivKompozicije().equals(mk.getNazivKompozicije())) {
                throw new Exception("Vec postoji muzicka kompozicija s tim nazivom!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long muzickaKompozicijaID = tableKeys.getLong(1);

        MuzickaKompozicija mk = (MuzickaKompozicija) ado;
        mk.setMuzickaKompozicijaID(muzickaKompozicijaID);

        for (UlogaKompozicije ulogaKompozicije : mk.getUlogeKompozicije()) {
            ulogaKompozicije.setMuzickaKompozicija(mk);
            DBBroker.getInstance().insert(ulogaKompozicije);
        }

    }

}
