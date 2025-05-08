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
public class Autor extends AbstractDomainObject {
    
    private Long autorID;
    private String imeAutora;
    private String prezimeAutora;
    private String email;
    private String telefon;

    @Override
    public String toString() {
        return imeAutora + " " + prezimeAutora;
    }

    public Autor(Long autorID, String imeAutora, String prezimeAutora, String email, String telefon) {
        this.autorID = autorID;
        this.imeAutora = imeAutora;
        this.prezimeAutora = prezimeAutora;
        this.email = email;
        this.telefon = telefon;
    }

    public Autor() {
    }
    
    @Override
    public String nazivTabele() {
        return " autor ";
    }

    @Override
    public String alijas() {
        return " a ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Autor a = new Autor(rs.getLong("autorID"),
                    rs.getString("imeAutora"), rs.getString("PrezimeAutorа"),
                    rs.getString("email"), rs.getString("telefon"));

            lista.add(a);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (imeAutora, PrezimeAutorа, email, telefon) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " autorID = " + autorID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imeAutora + "', '" + prezimeAutora + "', "
                + "'" + email + "', '" + telefon + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "email = '" + email + "', telefon = '" + telefon + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getAutorID() {
        return autorID;
    }

    public void setAutorID(Long autorID) {
        this.autorID = autorID;
    }

    public String getImeAutora() {
        return imeAutora;
    }

    public void setImeAutora(String imeAutora) {
        this.imeAutora = imeAutora;
    }

    public String getPrezimeAutora() {
        return prezimeAutora;
    }

    public void setPrezimeAutora(String prezimeAutora) {
        this.prezimeAutora = prezimeAutora;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
}
