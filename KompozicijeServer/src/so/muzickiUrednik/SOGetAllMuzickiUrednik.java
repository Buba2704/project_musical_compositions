/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.muzickiUrednik;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.MuzickiUrednik;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOGetAllMuzickiUrednik extends AbstractSO {

    private ArrayList<MuzickiUrednik> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof MuzickiUrednik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase MuzickiUrednik!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> muzickiUrednici = DBBroker.getInstance().select(ado);
        lista = (ArrayList<MuzickiUrednik>) (ArrayList<?>) muzickiUrednici;
    }

    public ArrayList<MuzickiUrednik> getLista() {
        return lista;
    }

}
