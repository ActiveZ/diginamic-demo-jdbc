package org.diginamic.fr;

import org.diginamic.fr.entities.Article;
import org.diginamic.fr.entities.Fournisseur;
import org.diginamic.fr.impl.ArticleIdao;
import org.diginamic.fr.impl.FournisseurIdao;

public class TestJdbcArticles {
    public static void main(String[] args) {
        try {
            FournisseurIdao foi = new FournisseurIdao();
            ArticleIdao ar = new ArticleIdao();

            System.out.println("\nListe des fournisseurs initiale");
            UseFournisseurIdao.getAllFournisseurs(foi);

            // ajout du fournisseur peinture
            UseFournisseurIdao.addFournisseur(foi, new Fournisseur(4, "La Maison de la Peinture"));
            System.out.println("\nListe des fournisseurs après ajout d'un fournisseur 'Maison de la peinture'");
            UseFournisseurIdao.getAllFournisseurs(foi);

            System.out.println("\nListe des articles initiale");
            UseArticleIdao.getAllArticles(ar);

            // ajout des 4 articles peinture
            UseArticleIdao.addArticle(ar, new Article(11, "P01", "Peinture blanche 1L", 12.5, 4));
            UseArticleIdao.addArticle(ar, new Article(12, "P02", "Peinture rouge mate 1L", 15.5, 4));
            UseArticleIdao.addArticle(ar, new Article(13, "P03", "Peinture noire Laquée 1L",17.8 , 4));
            UseArticleIdao.addArticle(ar, new Article(14, "P04", "Peinture bleue mate 1L", 15.5, 4));
            System.out.println("\nListe des articles après ajout de 4 articles peinture");
            UseArticleIdao.getAllArticles(ar);

            // diminution du prix de toutes les peintures mates de 25%
            System.out.println("\n" + UseArticleIdao.changePrix(-25) + " articles ont changé de prix");
            System.out.println("\nListe des articles après modification du prix des peintures mates");
            UseArticleIdao.getAllArticles(ar);

            // moyenne des prix des articles
            System.out.println("\nMoyenne des prix des articles: " + UseArticleIdao.moyennePrix());


            // suppression des 4 articles peinture
            UseArticleIdao.deleteArticle(ar, new Article(11, "", "", 0, 0));
            UseArticleIdao.deleteArticle(ar, new Article(12, "", "", 0, 0));
            UseArticleIdao.deleteArticle(ar, new Article(13, "", "", 0, 0));
            UseArticleIdao.deleteArticle(ar, new Article(14, "", "", 0, 0));
            System.out.println("\nListe des articles après suppression des 4 articles peinture");
            UseArticleIdao.getAllArticles(ar);

            // suppression du fournisseur peinture
            UseFournisseurIdao.deleteFournisseur(foi, new Fournisseur(4, ""));
            System.out.println("\nListe des fournisseurs après suppression");
            UseFournisseurIdao.getAllFournisseurs(foi);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
