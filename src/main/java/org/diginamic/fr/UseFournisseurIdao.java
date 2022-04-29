package org.diginamic.fr;

import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.impl.FournisseurIdao;
import org.diginamic.fr.entities.Fournisseur;

public class UseFournisseurIdao {
    public static void main(String[] args) {
        try {
            FournisseurIdao foi = new FournisseurIdao();

            System.out.println("\nListe des fournisseurs");
            getAllFournisseurs(foi);

            addFournisseur(foi, new Fournisseur(4, "La Maison de la Peinture"));
            System.out.println("\nListe des fournisseurs après ajout");
            getAllFournisseurs(foi);

            updateFournisseur(foi, new Fournisseur(4, "La Maison des Peintures"));
            System.out.println("\nListe des fournisseurs après update");
            getAllFournisseurs(foi);

            deleteFournisseur(foi, new Fournisseur(4, ""));
            System.out.println("\nListe des fournisseurs après suppression");
            getAllFournisseurs(foi);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * methode qui gére un objet de type Idao<Fournisseur>
     */
    public static void getAllFournisseurs(Idao<Fournisseur> obj) {
        obj.getAll().forEach(fo -> System.out.println(fo.getNom()));
    }

    public static void addFournisseur(Idao<Fournisseur> obj, Fournisseur fo) {
        obj.insert(fo);
    }

    public static void updateFournisseur(Idao<Fournisseur> obj, Fournisseur fo) {
        obj.update(null, fo);
    }

    public static void deleteFournisseur(Idao<Fournisseur> obj, Fournisseur fo) {
        obj.delete(fo);
    }
}