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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author PC
 */
public class ClientController {

    private static ClientController instance;

    public ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public MuzickiUrednik login(MuzickiUrednik muzickiUrednik) throws Exception {
        return (MuzickiUrednik) sendRequest(Operation.LOGIN, muzickiUrednik);
    }

    public void addAutor(Autor autor) throws Exception {
        sendRequest(Operation.ADD_AUTOR, autor);
    }

    public void addMuzickaKompozicija(MuzickaKompozicija muzickaKompozicija) throws Exception {
        sendRequest(Operation.ADD_MUZICKA_KOMPOZICIJA, muzickaKompozicija);
    }

    public void deleteAutor(Autor autor) throws Exception {
        sendRequest(Operation.DELETE_AUTOR, autor);
    }

    public void deleteMuzickaKompozicija(MuzickaKompozicija muzickaKompozicija) throws Exception {
        sendRequest(Operation.DELETE_MUZICKA_KOMPOZICIJA, muzickaKompozicija);
    }

    public void updateAutor(Autor autor) throws Exception {
        sendRequest(Operation.UPDATE_AUTOR, autor);
    }

    public void updateMuzickaKompozicija(MuzickaKompozicija muzickaKompozicija) throws Exception {
        sendRequest(Operation.UPDATE_MUZICKA_KOMPOZICIJA, muzickaKompozicija);
    }

    public ArrayList<Autor> getAllAutor() throws Exception {
        return (ArrayList<Autor>) sendRequest(Operation.GET_ALL_AUTOR, null);
    }

    public ArrayList<MuzickaKompozicija> getAllMuzickaKompozicija() throws Exception {
        return (ArrayList<MuzickaKompozicija>) sendRequest(Operation.GET_ALL_MUZICKA_KOMPOZICIJA, null);
    }

    public ArrayList<MuzickiUrednik> getAllMuzickiUrednik() throws Exception {
        return (ArrayList<MuzickiUrednik>) sendRequest(Operation.GET_ALL_MUZICKI_UREDNIK, null);
    }

    public ArrayList<Zanr> getAllZanr() throws Exception {
        return (ArrayList<Zanr>) sendRequest(Operation.GET_ALL_ZANR, null);
    }

    public ArrayList<Uloga> getAllUloga() throws Exception {
        return (ArrayList<Uloga>) sendRequest(Operation.GET_ALL_ULOGA, null);
    }

    public ArrayList<UlogaKompozicije> getAllUlogaKompozicije(MuzickaKompozicija mk) throws Exception {
        return (ArrayList<UlogaKompozicije>) sendRequest(Operation.GET_ALL_ULOGA_KOMPOZICIJE, mk);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }
}
