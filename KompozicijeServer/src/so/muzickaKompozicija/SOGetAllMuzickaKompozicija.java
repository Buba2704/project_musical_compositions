/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.muzickaKompozicija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.MuzickaKompozicija;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOGetAllMuzickaKompozicija extends AbstractSO {

    private ArrayList<MuzickaKompozicija> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof MuzickaKompozicija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase MuzickaKompozicija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> kompozicije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<MuzickaKompozicija>) (ArrayList<?>) kompozicije;
    }

    public ArrayList<MuzickaKompozicija> getLista() {
        return lista;
    }

}
