/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author PC
 */
public interface Operation {

    public static final int LOGIN = 0;

    public static final int GET_ALL_MUZICKI_UREDNIK = 1;

    public static final int ADD_AUTOR = 2;
    public static final int DELETE_AUTOR = 3;
    public static final int UPDATE_AUTOR = 4;
    public static final int GET_ALL_AUTOR = 5;

    public static final int ADD_MUZICKA_KOMPOZICIJA = 6;
    public static final int DELETE_MUZICKA_KOMPOZICIJA = 7;
    public static final int UPDATE_MUZICKA_KOMPOZICIJA = 8;
    public static final int GET_ALL_MUZICKA_KOMPOZICIJA = 9;

    public static final int GET_ALL_ULOGA_KOMPOZICIJE = 10;

    public static final int GET_ALL_ULOGA = 11;
    
    public static final int GET_ALL_ZANR = 12;

}
