/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Autor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class TableModelAutori extends AbstractTableModel implements Runnable {

    private ArrayList<Autor> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Email", "Telefon"};
    private String parametar = "";

    public TableModelAutori() {
        try {
            lista = ClientController.getInstance().getAllAutor();
        } catch (Exception ex) {
            Logger.getLogger(TableModelAutori.class.getName()).log(Level.SEVERE, null, ex);
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
        Autor a = lista.get(row);

        switch (column) {
            case 0:
                return a.getAutorID();
            case 1:
                return a.getImeAutora();
            case 2:
                return a.getPrezimeAutora();
            case 3:
                return a.getEmail();
            case 4:
                return a.getTelefon();

            default:
                return null;
        }
    }

    public Autor getSelectedAutor(int row) {
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
            Logger.getLogger(TableModelAutori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllAutor();
            if (!parametar.equals("")) {
                ArrayList<Autor> novaLista = new ArrayList<>();
                for (Autor a : lista) {
                    if (a.getImeAutora().toLowerCase().contains(parametar.toLowerCase())
                            || a.getPrezimeAutora().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(a);
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
