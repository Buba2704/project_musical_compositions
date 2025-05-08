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
public class UlogaKompozicije extends AbstractDomainObject {

    private MuzickaKompozicija muzickaKompozicija;
    private int rbUloge;
    private String komentar;
    private Uloga uloga;
    private Autor autor;

    public UlogaKompozicije(MuzickaKompozicija muzickaKompozicija, int rbUloge, String komentar, Uloga uloga, Autor autor) {
        this.muzickaKompozicija = muzickaKompozicija;
        this.rbUloge = rbUloge;
        this.komentar = komentar;
        this.uloga = uloga;
        this.autor = autor;
    }

    public UlogaKompozicije() {
    }

    @Override
    public String nazivTabele() {
        return " ulogaKompozicije ";
    }

    @Override
    public String alijas() {
        return " uk ";
    }

    @Override
    public String join() {
        return " JOIN MUZICKAKOMPOZICIJA MK USING (MUZICKAKOMPOZICIJAID) "
                + "JOIN ULOGA U USING (ULOGAID) "
                + "JOIN AUTOR A USING (AUTORID) "
                + "JOIN ZANR Z ON (Z.ZANRID = MK.ZANRID) "
                + "JOIN MUZICKIUREDNIK MU ON (MU.MUZICKIUREDNIKID = MK.MUZICKIUREDNIKID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            MuzickiUrednik mu = new MuzickiUrednik(rs.getLong("MuzickiUrednikID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Uloga u = new Uloga(rs.getLong("UlogaID"),
                    rs.getString("NazivUloge"), rs.getString("Opis"));

            Autor a = new Autor(rs.getLong("autorID"),
                    rs.getString("imeAutora"), rs.getString("PrezimeAutorа"),
                    rs.getString("email"), rs.getString("telefon"));

            Zanr z = new Zanr(rs.getLong("ZanrID"),
                    rs.getString("NazivZanra"));

            MuzickaKompozicija mk = new MuzickaKompozicija(rs.getLong("muzickaKompozicijaID"),
                    rs.getString("nazivKompozicije"), rs.getInt("godinaNastanka"),
                    rs.getInt("duzinaTrajanjaSekundi"), z, mu, null);

            UlogaKompozicije uk = new UlogaKompozicije(mk, rs.getInt("rbUloge"),
                    rs.getString("komentar"), u, a);

            lista.add(uk);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (muzickaKompozicijaID, rbUloge, komentar, ulogaID, autorID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " muzickaKompozicijaID = " + muzickaKompozicija.getMuzickaKompozicijaID();
    }

    @Override
    public String vrednostiZaInsert() {
        return muzickaKompozicija.getMuzickaKompozicijaID() + ", " + rbUloge + ", "
                + "'" + komentar + "', " + uloga.getUlogaID() + ", " + autor.getAutorID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE MK.MUZICKAKOMPOZICIJAID = " + muzickaKompozicija.getMuzickaKompozicijaID();
    }

    public MuzickaKompozicija getMuzickaKompozicija() {
        return muzickaKompozicija;
    }

    public void setMuzickaKompozicija(MuzickaKompozicija muzickaKompozicija) {
        this.muzickaKompozicija = muzickaKompozicija;
    }

    public int getRbUloge() {
        return rbUloge;
    }

    public void setRbUloge(int rbUloge) {
        this.rbUloge = rbUloge;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}
