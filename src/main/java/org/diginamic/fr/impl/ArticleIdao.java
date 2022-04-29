package org.diginamic.fr.impl;

import org.diginamic.fr.ConnexionJDBC;
import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.entities.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleIdao implements Idao<Article> {
    private Connection conn = null;

    public ArticleIdao() throws Exception {
        conn = ConnexionJDBC.getConnection();
    }

    public void close() throws Exception {
        if (conn != null && conn.isClosed() == false) {
            conn.close();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        close();
    }

    @Override
    public List<Article> getAll() {
        List<Article> listArticles = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM article");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Article art = new Article(rs.getInt("ID"),
                        rs.getString("ref"),
                        rs.getString("designation"),
                        rs.getDouble("prix"),
                        rs.getInt("id_fou"));
                listArticles.add(art);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return listArticles;
    }

    @Override
    public void insert(Article data) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO article (id, ref, designation, prix, id_fou) VALUES (?,?,?,?,?)");
            stmt.setInt(1, data.getId());
            stmt.setString(2, data.getRef());
            stmt.setString(3, data.getDesignation());
            stmt.setDouble(4, data.getPrix());
            stmt.setInt(5, data.getIdFou());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public int update(Article ancienData, Article newArt) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE article SET ref=?, designation=?, prix=?, id_fou=? WHERE id=?");
            stmt.setString(1, newArt.getRef());
            stmt.setString(2, newArt.getDesignation());
            stmt.setDouble(3, newArt.getPrix());
            stmt.setInt(4, newArt.getIdFou());
            stmt.setInt(5, newArt.getId());
            return stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean delete(Article data) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM article WHERE id=?");
            stmt.setInt(1, data.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
