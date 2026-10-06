package com.example.article.model;

import java.util.ArrayList;

public class DaoArticle {
    private ArrayList<Article> Articles ;
    private static DaoArticle Instance ;
    private DaoArticle(){
        Articles=new ArrayList<>();
        Articles.add(new Article("A001","Ordinateur portable",899.99));
        Articles.add(new Article("A002","Souris sans fil",25.50));
        Articles.add(new Article("A003","Clavier mécanique",75.00));

    }
    public static DaoArticle getInstance(){
        if (Instance==null){
           Instance= new DaoArticle();
        }
        return Instance;
    }
    public ArrayList<Article> findAll(){
        return Articles;
    }
    public Article findByCode(String C){
        for (int i = 0 ; i<Articles.size();i++){
            if (Articles.get(i).getCode().equals(C))
                return Articles.get(i) ;
        }
        return null;

    }
    public void save(Article A){
        if (findByCode(A.getCode())==null){
        Articles.add(A);
        }
    }
    public void update(Article A){
        Article art_temp =findByCode(A.getCode());
        if (art_temp!=null){
        art_temp.setDesignation(A.getDesignation());
        art_temp.setPrix(A.getPrix());
        }
        else
            System.out.println("l'Article n'existe pas ");

    }
    public void delete(String C){
        Articles.remove(findByCode(C));
    }

}
