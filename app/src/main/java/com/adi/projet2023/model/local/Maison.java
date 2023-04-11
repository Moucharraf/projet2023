package com.adi.projet2023.model.local;

import com.adi.projet2023.model.user.UserModel;

import java.io.Serializable;
import java.util.List;

public class Maison extends Local implements Serializable {

    public Maison(){
    }

    public Maison(String nomMaison, String quartierMaison, String villeMaison){
        super(TypeLocal.MAISON, nomMaison, quartierMaison, villeMaison);
    }

    public String getNomMaison(){
        return super.getNomLocal();
    }

    public String getQuartierMaison(){
        return super.getQuartierLocal();
    }

    public String getVilleMaison(){
        return super.getVilleLocal();
    }

    public List<UserModel> getUsers(){
        return super.getLesUsers();
    }
}
