/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Autor;
import domain.MuzickaKompozicija;
import domain.MuzickiUrednik;
import domain.Uloga;
import domain.UlogaKompozicije;
import domain.Zanr;
import java.util.ArrayList;
import so.autor.SOAddAutor;
import so.autor.SODeleteAutor;
import so.autor.SOGetAllAutor;
import so.autor.SOUpdateAutor;
import so.muzickiUrednik.SOGetAllMuzickiUrednik;
import so.login.SOLogin;
import so.muzickaKompozicija.SOAddMuzickaKompozicija;
import so.muzickaKompozicija.SODeleteMuzickaKompozicija;
import so.muzickaKompozicija.SOGetAllMuzickaKompozicija;
import so.muzickaKompozicija.SOUpdateMuzickaKompozicija;
import so.uloga.SOGetAllUloga;
import so.ulogaKompozicije.SOGetAllUlogaKompozicije;
import so.zanr.SOGetAllZanr;

/**
 *
 * @author PC
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public MuzickiUrednik login(MuzickiUrednik muzickiUrednik) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(muzickiUrednik);
        return so.getMuzickiUrednik();
    }

    public void addAutor(Autor autor) throws Exception {
        (new SOAddAutor()).templateExecute(autor);
    }
    
    public void addMuzickaKompozicija(MuzickaKompozicija muzickaKompozicija) throws Exception {
        (new SOAddMuzickaKompozicija()).templateExecute(muzickaKompozicija);
    }

    public void deleteAutor(Autor autor) throws Exception {
        (new SODeleteAutor()).templateExecute(autor);
    }

    public void deleteMuzickaKompozicija(MuzickaKompozicija muzickaKompozicija) throws Exception {
        (new SODeleteMuzickaKompozicija()).templateExecute(muzickaKompozicija);
    }

    public void updateAutor(Autor autor) throws Exception {
        (new SOUpdateAutor()).templateExecute(autor);
    }

    public void updateMuzickaKompozicija(MuzickaKompozicija muzickaKompozicija) throws Exception {
        (new SOUpdateMuzickaKompozicija()).templateExecute(muzickaKompozicija);
    }

    public ArrayList<MuzickiUrednik> getAllMuzickiUrednik() throws Exception {
        SOGetAllMuzickiUrednik so = new SOGetAllMuzickiUrednik();
        so.templateExecute(new MuzickiUrednik());
        return so.getLista();
    }

    public ArrayList<Autor> getAllAutor() throws Exception {
        SOGetAllAutor so = new SOGetAllAutor();
        so.templateExecute(new Autor());
        return so.getLista();
    }

    public ArrayList<MuzickaKompozicija> getAllMuzickaKompozicija() throws Exception {
        SOGetAllMuzickaKompozicija so = new SOGetAllMuzickaKompozicija();
        so.templateExecute(new MuzickaKompozicija());
        return so.getLista();
    }

    public ArrayList<Uloga> getAllUloga() throws Exception {
        SOGetAllUloga so = new SOGetAllUloga();
        so.templateExecute(new Uloga());
        return so.getLista();
    }

    public ArrayList<UlogaKompozicije> getAllUlogaKompozicije(MuzickaKompozicija mk) throws Exception {
        SOGetAllUlogaKompozicije so = new SOGetAllUlogaKompozicije();
        
        UlogaKompozicije uk = new UlogaKompozicije();
        uk.setMuzickaKompozicija(mk);
        
        so.templateExecute(uk);
        return so.getLista();
    }

    public ArrayList<Zanr> getAllZanr() throws Exception {
        SOGetAllZanr so = new SOGetAllZanr();
        so.templateExecute(new Zanr());
        return so.getLista();
    }

}
