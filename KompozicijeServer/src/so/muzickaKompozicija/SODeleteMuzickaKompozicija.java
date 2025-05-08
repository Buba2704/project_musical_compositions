/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.muzickaKompozicija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.MuzickaKompozicija;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SODeleteMuzickaKompozicija extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof MuzickaKompozicija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase MuzickaKompozicija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
