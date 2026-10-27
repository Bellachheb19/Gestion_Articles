package com.example.article.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @Column(name = "code", nullable = false, length = 20)
    private String code;

    @Column(name = "designation")
    private String designation;

    @Column(name = "prix")
    private double prix;

    public Article() {
    }

    public Article(String code, String designation, double prix) {
        this.code = code;
        this.designation = designation;
        this.prix = prix;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "Article{" +
                "code='" + code + '\'' +
                ", designation='" + designation + '\'' +
                ", prix=" + prix +
                '}';
    }
}