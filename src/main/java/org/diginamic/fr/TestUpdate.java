package org.diginamic.fr;

import org.diginamic.fr.dao.FournisseurDao;
import org.diginamic.fr.entities.Fournisseur;

public class TestUpdate {
    public static void main(String[] args) {
        Fournisseur fo = new Fournisseur(4, "La Maison des Peintures");
        FournisseurDao.updateFournisseur(fo);
        FournisseurDao.getAllFournisseurs();
    }
}
