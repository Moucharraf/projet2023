package com.adi.projet2023.model.local;

import java.io.Serializable;

public class Entreprise extends Local implements Serializable {

    public Entreprise(){
    }

    public Entreprise(String nomEntreprise, String quartierEntreprise, String villeEntreprise){
        super(TypeLocal.ENTREPRISE, nomEntreprise, quartierEntreprise, villeEntreprise);
    }

}
