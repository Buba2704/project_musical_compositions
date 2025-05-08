/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.autor;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Autor;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOUpdateAutor extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Autor)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Autor!");
        }

        Autor a = (Autor) ado;

        ArrayList<Autor> autori = (ArrayList<Autor>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Autor autor : autori) {
            if (!autor.getAutorID().equals(a.getAutorID())) {
                if (autor.getEmail().equals(a.getEmail())) {
                    throw new Exception("Vec postoji autor s tim emailom!");
                }
                if (autor.getTelefon().equals(a.getTelefon())) {
                    throw new Exception("Vec postoji autor s tim telefonom!");
                }
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }

}
