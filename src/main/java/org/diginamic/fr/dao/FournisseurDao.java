package org.diginamic.fr.dao;

import org.diginamic.fr.ConnexionJDBC;
import org.diginamic.fr.entities.Fournisseur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Permet de lire en JDBC la table fournisseur
 * et d'avoir les méthodes CRUD
 * et d'obtenir des objets de type Fournisseur
 */
public class FournisseurDao {
    /**
     * @return liste des fournisseurs de la db
     */
    public static List<Fournisseur> getAllFournisseurs() {
        Connection connection = null;
        List<Fournisseur> listeFournisseurs = new ArrayList<>();

        try {
            connection = ConnexionJDBC.getConnection();
            //java.sql a importer
            Statement stmt = connection.createStatement();
            ResultSet curseur = stmt.executeQuery("SELECT * FROM fournisseur");
            while (curseur.next()) {
                /**
                 * Je veux récupérer la colonne ID et la colonne Nom de ma table
                 * la stocker dans un objet de type Fournisseur
                 * et la mettre dans notre Liste
                 */
                Fournisseur fo = new Fournisseur(curseur.getInt("id"), curseur.getString("nom"));
                listeFournisseurs.add(fo);
            }
            curseur.close();
            stmt.close();
            for (Fournisseur fo : listeFournisseurs) {
                System.out.println("Id:" + fo.getId() + " Nom: " + fo.getNom());
            }
        } catch (Exception ex) {
            System.err.println((ex.getMessage()));
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return listeFournisseurs;
    }

    /**
     * @param fo
     */
    public static void addFournisseur(Fournisseur fo) {
        Connection connection = null;
        Statement stmt = null;

        try {
            connection = ConnexionJDBC.getConnection();
            stmt = connection.createStatement();
            stmt.executeQuery("INSERT INTO fournisseur (id, nom) VALUES ('4', 'La Maison de la Peinture')");
        } catch (Exception ex) {
            System.err.println((ex.getMessage()));
        } finally {
            try {
                if (connection != null) connection.close();
                if (stmt != null) stmt.close();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    /**
     * @param fo
     */
    public static void updateFournisseur(Fournisseur fo) {
        Connection connection = null;
        Statement stmt = null;

        try {
            connection = ConnexionJDBC.getConnection();
            stmt = connection.createStatement();
            stmt.executeQuery("UPDATE fournisseur SET nom='La Maison des Peintures' WHERE id=4");
        } catch (Exception ex) {
            System.err.println((ex.getMessage()));
        } finally {
            try {
                if (connection != null) connection.close();
                if (stmt != null) stmt.close();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    /**
     * @param id
     */
    public static void deleteFournisseur(Integer id) {
        Connection connection = null;
        Statement stmt = null;

        try {
            connection = ConnexionJDBC.getConnection();
            stmt = connection.createStatement();
            stmt.executeQuery("DELETE FROM fournisseur WHERE id=4");
        } catch (Exception ex) {
            System.err.println((ex.getMessage()));
        } finally {
            try {
                if (connection != null) connection.close();
                if (stmt != null) stmt.close();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
