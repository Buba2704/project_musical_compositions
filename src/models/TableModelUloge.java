/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Autor;
import domain.MuzickaKompozicija;
import domain.Uloga;
import domain.UlogaKompozicije;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class TableModelUloge extends AbstractTableModel {

    private ArrayList<UlogaKompozicije> lista;
    private String[] kolone = {"Rb", "Autor", "Uloga", "Komentar"};
    private int rb = 0;

    public TableModelUloge() {
        lista = new ArrayList<>();
    }

    public TableModelUloge(MuzickaKompozicija mk) {
        try {
            lista = ClientController.getInstance().getAllUlogaKompozicije(mk);
        } catch (Exception ex) {
            Logger.getLogger(TableModelUloge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        UlogaKompozicije uk = lista.get(row);

        switch (column) {
            case 0:
                return uk.getRbUloge();
            case 1:
                return uk.getAutor();
            case 2:
                return uk.getUloga();
            case 3:
                return uk.getKomentar();

            default:
                return null;
        }
    }

    public void dodajUlogu(UlogaKompozicije uk) {
        rb = lista.size();
        uk.setRbUloge(++rb);
        lista.add(uk);
        fireTableDataChanged();
    }

    public void obrisiUlogu(int row) {
        lista.remove(row);

        rb = 0;
        for (UlogaKompozicije ulogaKompozicije : lista) {
            ulogaKompozicije.setRbUloge(++rb);
        }

        fireTableDataChanged();
    }

    public boolean postojiUloga(Uloga u, Autor a) {
        for (UlogaKompozicije ulogaKompozicije : lista) {
            if (ulogaKompozicije.getUloga().getUlogaID().equals(u.getUlogaID())
                    && ulogaKompozicije.getAutor().getAutorID().equals(a.getAutorID())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<UlogaKompozicije> getLista() {
        return lista;
    }

    public boolean postojeSveUloge(ArrayList<Uloga> uloge) {

        ArrayList<Uloga> listaUlogaUTabeli = new ArrayList<>();

        for (UlogaKompozicije ulogaKompozicije : lista) {
            listaUlogaUTabeli.add(ulogaKompozicije.getUloga());
        }

        for (Uloga uloga : uloge) {
            if (!listaUlogaUTabeli.contains(uloga)) {
                return false;
            }
        }

        return true;
    }

}
