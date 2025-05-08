/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Autor;
import domain.MuzickaKompozicija;
import domain.MuzickiUrednik;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author PC
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperation()) {
                case Operation.ADD_AUTOR:
                    ServerController.getInstance().addAutor((Autor) request.getData());
                    break;
                case Operation.ADD_MUZICKA_KOMPOZICIJA:
                    ServerController.getInstance().addMuzickaKompozicija((MuzickaKompozicija) request.getData());
                    break;
                case Operation.DELETE_AUTOR:
                    ServerController.getInstance().deleteAutor((Autor) request.getData());
                    break;
                case Operation.DELETE_MUZICKA_KOMPOZICIJA:
                    ServerController.getInstance().deleteMuzickaKompozicija((MuzickaKompozicija) request.getData());
                    break;
                case Operation.UPDATE_AUTOR:
                    ServerController.getInstance().updateAutor((Autor) request.getData());
                    break;
                case Operation.UPDATE_MUZICKA_KOMPOZICIJA:
                    ServerController.getInstance().updateMuzickaKompozicija((MuzickaKompozicija) request.getData());
                    break;
                case Operation.GET_ALL_AUTOR:
                    response.setData(ServerController.getInstance().getAllAutor());
                    break;
                case Operation.GET_ALL_MUZICKI_UREDNIK:
                    response.setData(ServerController.getInstance().getAllMuzickiUrednik());
                    break;
                case Operation.GET_ALL_MUZICKA_KOMPOZICIJA:
                    response.setData(ServerController.getInstance().getAllMuzickaKompozicija());
                    break;
                case Operation.GET_ALL_ZANR:
                    response.setData(ServerController.getInstance().getAllZanr());
                    break;
                case Operation.GET_ALL_ULOGA:
                    response.setData(ServerController.getInstance().getAllUloga());
                    break;
                case Operation.GET_ALL_ULOGA_KOMPOZICIJE:
                    response.setData(ServerController.getInstance()
                            .getAllUlogaKompozicije((MuzickaKompozicija) request.getData()));
                    break;
                case Operation.LOGIN:
                    MuzickiUrednik muzickiUrednik = (MuzickiUrednik) request.getData();
                    MuzickiUrednik ulogovani = ServerController.getInstance().login(muzickiUrednik);
                    response.setData(ulogovani);
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

}
