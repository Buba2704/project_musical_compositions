/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ulogaKompozicije;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.UlogaKompozicije;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOGetAllUlogaKompozicije extends AbstractSO {

    private ArrayList<UlogaKompozicije> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof UlogaKompozicije)) {
            throw new Exception("Prosledjeni objekat nije instanca klase UlogaKompozicije!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> ulogeKompozicije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<UlogaKompozicije>) (ArrayList<?>) ulogeKompozicije;
    }

    public ArrayList<UlogaKompozicije> getLista() {
        return lista;
    }

}
