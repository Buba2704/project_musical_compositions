/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.autor;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Autor;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SODeleteAutor extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Autor)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Autor!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
