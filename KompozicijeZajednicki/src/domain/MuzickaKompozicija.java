/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class MuzickaKompozicija extends AbstractDomainObject {

    private Long muzickaKompozicijaID;
    private String nazivKompozicije;
    private int godinaNastanka;
    private int duzinaTrajanjaSekundi;
    private Zanr zanr;
    private MuzickiUrednik muzickiUrednik;
    private ArrayList<UlogaKompozicije> ulogeKompozicije;

    public MuzickaKompozicija(Long muzickaKompozicijaID, String nazivKompozicije, int godinaNastanka, int duzinaTrajanjaSekundi, Zanr zanr, MuzickiUrednik muzickiUrednik, ArrayList<UlogaKompozicije> ulogeKompozicije) {
        this.muzickaKompozicijaID = muzickaKompozicijaID;
        this.nazivKompozicije = nazivKompozicije;
        this.godinaNastanka = godinaNastanka;
        this.duzinaTrajanjaSekundi = duzinaTrajanjaSekundi;
        this.zanr = zanr;
        this.muzickiUrednik = muzickiUrednik;
        this.ulogeKompozicije = ulogeKompozicije;
    }

    public MuzickaKompozicija() {
    }

    @Override
    public String nazivTabele() {
        return " muzickaKompozicija ";
    }

    @Override
    public String alijas() {
        return " mk ";
    }

    @Override
    public String join() {
        return " JOIN ZANR Z ON (Z.ZANRID = MK.ZANRID) "
                + "JOIN MUZICKIUREDNIK MU ON (MU.MUZICKIUREDNIKID = MK.MUZICKIUREDNIKID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            MuzickiUrednik mu = new MuzickiUrednik(rs.getLong("MuzickiUrednikID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Zanr z = new Zanr(rs.getLong("ZanrID"),
                    rs.getString("NazivZanra"));

            MuzickaKompozicija mk = new MuzickaKompozicija(rs.getLong("muzickaKompozicijaID"),
                    rs.getString("nazivKompozicije"), rs.getInt("godinaNastanka"),
                    rs.getInt("duzinaTrajanjaSekundi"), z, mu, null);

            lista.add(mk);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (nazivKompozicije, godinaNastanka, duzinaTrajanjaSekundi, zanrID, muzickiUrednikID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " muzickaKompozicijaID = " + muzickaKompozicijaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivKompozicije + "', " + godinaNastanka + ", "
                + duzinaTrajanjaSekundi + ", " + zanr.getZanrID() + ", "
                + muzickiUrednik.getMuzickiUrednikID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " nazivKompozicije = '" + nazivKompozicije + "', "
                + "godinaNastanka = " + godinaNastanka + ", "
                + "duzinaTrajanjaSekundi = " + duzinaTrajanjaSekundi + ", "
                + "zanrID = " + zanr.getZanrID() + " ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getMuzickaKompozicijaID() {
        return muzickaKompozicijaID;
    }

    public void setMuzickaKompozicijaID(Long muzickaKompozicijaID) {
        this.muzickaKompozicijaID = muzickaKompozicijaID;
    }

    public String getNazivKompozicije() {
        return nazivKompozicije;
    }

    public void setNazivKompozicije(String nazivKompozicije) {
        this.nazivKompozicije = nazivKompozicije;
    }

    public int getGodinaNastanka() {
        return godinaNastanka;
    }

    public void setGodinaNastanka(int godinaNastanka) {
        this.godinaNastanka = godinaNastanka;
    }

    public int getDuzinaTrajanjaSekundi() {
        return duzinaTrajanjaSekundi;
    }

    public void setDuzinaTrajanjaSekundi(int duzinaTrajanjaSekundi) {
        this.duzinaTrajanjaSekundi = duzinaTrajanjaSekundi;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public MuzickiUrednik getMuzickiUrednik() {
        return muzickiUrednik;
    }

    public void setMuzickiUrednik(MuzickiUrednik muzickiUrednik) {
        this.muzickiUrednik = muzickiUrednik;
    }

    public ArrayList<UlogaKompozicije> getUlogeKompozicije() {
        return ulogeKompozicije;
    }

    public void setUlogeKompozicije(ArrayList<UlogaKompozicije> ulogeKompozicije) {
        this.ulogeKompozicije = ulogeKompozicije;
    }

}
