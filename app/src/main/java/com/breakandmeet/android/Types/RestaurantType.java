package com.breakandmeet.android.Types;

/**
 * Created by adrien on 15/11/2015.
 */
public class RestaurantType {

    public static final String[] fake_villes = {"Lille", "Lens", "London", "Paris", "Lille"};
    public static final String[] fake_noms = {"Adrien Chapelet", "Xavier Vlaminck", "Pascal Yim", "Armand Toguyeni"};
    public static final String[] fake_types = {"Quartier Gourmet", "La dinette", "La Petite Cour", "Comptoir 44"};

    public int id;
    public String ville;
    public String nom;
    public int capacite;
    public int[] avail;
    public String[] lang;
    public String[] circuits;
    public double note;

    public RestaurantType (int id, String ville,String nom, int capacite,int[] avail,String[] lang, String[] circuits,double note) {
        this.id=id;
        this.ville=ville;
        this.nom=nom;
        this.capacite=capacite;
        this.avail=avail;
        this.lang=lang;
        this.circuits=circuits;
        this.note=note;
    }

}
