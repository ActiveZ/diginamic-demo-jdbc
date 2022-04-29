package org.diginamic.fr.impl;

import org.diginamic.fr.ConnexionJDBC;
import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.entities.Fournisseur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FournisseurIdao implements Idao<Fournisseur> {

    private Connection conn = null;

    public FournisseurIdao() throws Exception {
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
    public List<Fournisseur> getAll() {
        List<Fournisseur> listFournisseurs = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT ID,NOM FROM fournisseur");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Fournisseur fo = new Fournisseur(rs.getInt("ID"),
                        rs.getString("NOM"));
                listFournisseurs.add(fo);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return listFournisseurs;
    }

    @Override
    public void insert(Fournisseur fo) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO fournisseur (id, nom) VALUES (?,?)");
            stmt.setInt(1, fo.getId());
            stmt.setString(2, fo.getNom());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public int update(Fournisseur oldFo, Fournisseur newFo) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE fournisseur SET nom=? WHERE id=?");
            stmt.setString(1, newFo.getNom());
            stmt.setInt(2, newFo.getId());
            return stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean delete(Fournisseur fo) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM fournisseur WHERE id=?");
            stmt.setInt(1, fo.getId());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
