package org.diginamic.fr;

import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.entities.Article;
import org.diginamic.fr.impl.ArticleIdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UseArticleIdao {
    public static void main(String[] args) {
        try {
            ArticleIdao ar = new ArticleIdao();

            System.out.println("\nListe des articles");
            getAllArticles(ar);

            addArticle(ar, new Article(44, "4444", "4444", 44, 1));
            System.out.println("\nListe des articles après ajout");
            getAllArticles(ar);

            updateArticle(ar, new Article(44, "555", "55", 55, 1));
            System.out.println("\nListe des articles après update");
            getAllArticles(ar);

            deleteArticle(ar, new Article(44, "", "", 0, 0));
            System.out.println("\nListe des articles après suppression");
            getAllArticles(ar);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * methode qui gére un objet de type Idao<Article>
     */
    public static void getAllArticles(Idao<Article> obj) {
        obj.getAll().forEach(a -> System.out.println(a.getId() + " " + a.getRef() + " " + a.getDesignation() + " " + a.getPrix() + " " + a.getIdFou()));
    }

    public static void addArticle(Idao<Article> obj, Article ar) {
        obj.insert(ar);
    }

    public static void updateArticle(Idao<Article> obj, Article ar) {
        obj.update(null, ar);
    }

    public static void deleteArticle(Idao<Article> obj, Article ar) {
        obj.delete(ar);
    }

    public static int changePrix(double pourcent) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnexionJDBC.getConnection();
            stmt = conn.prepareStatement("UPDATE article SET prix=prix*? WHERE designation LIKE '%mate%'");
            stmt.setDouble(1, 1 + pourcent / 100);
            return stmt.executeUpdate(); // retourne le nb de lignes modifiées
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return 0;
    }

    public static double moyennePrix() {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnexionJDBC.getConnection();
            stmt = conn.prepareStatement("SELECT AVG(prix) AS moy FROM article");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getDouble("moy");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return 0;
    }
}
