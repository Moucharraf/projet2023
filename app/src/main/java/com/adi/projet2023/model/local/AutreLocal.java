package com.adi.projet2023.model.local;

import java.io.Serializable;

public class AutreLocal extends Local implements Serializable {

    public AutreLocal(){}

    public AutreLocal(String nomLocal, String quartierLocal, String villeLocal){
        super(TypeLocal.AUTRE, nomLocal, quartierLocal, villeLocal);
    }
}
