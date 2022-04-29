package org.diginamic.fr;

import org.diginamic.fr.dao.FournisseurDao;
import org.diginamic.fr.entities.Fournisseur;

public class TestInsertion {
    public static void main(String[] args) {
        Fournisseur fo = new Fournisseur(4, "La Maison de la Peinture");
        FournisseurDao.addFournisseur(fo);
        FournisseurDao.getAllFournisseurs();
    }
}
