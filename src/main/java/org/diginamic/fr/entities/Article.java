package org.diginamic.fr.entities;

/**
 * Description de la table Fournisseur par une classe utilisée en manuel avec JDBC
 */
public class Article {
    private Integer id;
    private String ref;
    private String designation;
    private double prix;
    private Integer idFou;

    public Article(Integer id, String ref, String designation, double prix, Integer idFou) {
        this.id = id;
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
        this.idFou = idFou;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Integer getIdFou() {
        return idFou;
    }

    public void setIdFou(Integer idFou) {
        this.idFou = idFou;
    }
}
