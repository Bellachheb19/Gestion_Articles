package com.example.article.model;

public class Article {
    private String Code ;
    private String designation;
    private Double prix ;

    public Article (String C , String D , Double P) {
        this.Code=C;
        this.designation=D;
        this.prix=P;
    }

    public String getCode() {
        return Code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
@Override
public String toString(){
        return "Article {"+Code+","+designation+","+prix+"DH }";

}
}
