/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.login;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.MuzickiUrednik;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOLogin extends AbstractSO {
    
    MuzickiUrednik muzickiUrednik;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof MuzickiUrednik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase MuzickiUrednik!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        MuzickiUrednik mu = (MuzickiUrednik) ado;

        ArrayList<MuzickiUrednik> muzickiUrednici
                = (ArrayList<MuzickiUrednik>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (MuzickiUrednik muzickiUrednik : muzickiUrednici) {
            if (muzickiUrednik.getUsername().equals(mu.getUsername())
                    && muzickiUrednik.getPassword().equals(mu.getPassword())) {
                this.muzickiUrednik = muzickiUrednik;
                return;
            }
        }

        throw new Exception("Ne postoji muzicki urednik sa tim kredencijalima.");
        
    }

    public MuzickiUrednik getMuzickiUrednik() {
        return muzickiUrednik;
    }
    
    

}
