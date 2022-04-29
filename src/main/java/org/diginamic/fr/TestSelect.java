package org.diginamic.fr;

import org.diginamic.fr.dao.FournisseurDao;

public class TestSelect {
    public static void main(String[] args) {
        FournisseurDao.getAllFournisseurs();

//        List<Fournisseur> maListe = FournisseurDao.getAllFournisseurs();
//        for (Fournisseur fo : maListe) {
//            System.out.println("Id:" + fo.getId() + " Nom: " + fo.getNom());
//        }
    }
}

