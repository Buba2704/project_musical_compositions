/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.MuzickaKompozicija;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class TableModelMuzickeKompozicije extends AbstractTableModel implements Runnable {

    private ArrayList<MuzickaKompozicija> lista;
    private String[] kolone = {"ID", "Naziv", "Godina nastanka", "Duzina trajanja"};
    private String parametar = "";

    public TableModelMuzickeKompozicije() {
        try {
            lista = ClientController.getInstance().getAllMuzickaKompozicija();
        } catch (Exception ex) {
            Logger.getLogger(TableModelMuzickeKompozicije.class.getName()).log(Level.SEVERE, null, ex);
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
        MuzickaKompozicija mk = lista.get(row);

        switch (column) {
            case 0:
                return mk.getMuzickaKompozicijaID();
            case 1:
                return mk.getNazivKompozicije();
            case 2:
                return mk.getGodinaNastanka();
            case 3:
                return mk.getDuzinaTrajanjaSekundi() + "s";

            default:
                return null;
        }
    }

    public MuzickaKompozicija getSelectedMuzickaKompozicija(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelMuzickeKompozicije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllMuzickaKompozicija();
            if (!parametar.equals("")) {
                ArrayList<MuzickaKompozicija> novaLista = new ArrayList<>();
                for (MuzickaKompozicija mk : lista) {
                    if (mk.getNazivKompozicije().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(mk);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
