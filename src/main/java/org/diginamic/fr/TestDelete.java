package org.diginamic.fr;

import org.diginamic.fr.dao.FournisseurDao;

public class TestDelete {
    public static void main(String[] args) {
        FournisseurDao.deleteFournisseur(4);
        FournisseurDao.getAllFournisseurs();
    }
}
