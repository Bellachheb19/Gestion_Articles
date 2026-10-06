package com.example.article;
import com.example.article.model.DaoArticle;
import com.example.article.model.Article;

public class Test {

    public static void main(String[] args) {

        DaoArticle dao = DaoArticle.getInstance();

        // 1. Tester findAll()
        System.out.println("=== Liste initiale ===");
        System.out.println(dao.findAll());

        // 2. Tester findByCode()
        System.out.println("\n=== Recherche AOO1 ===");
        System.out.println(dao.findByCode("AOO1"));

        // 3. Tester save()
        System.out.println("\n=== Ajout d'un article ===");
        Article nouveau = new Article("AOO4", "Ecran", 250.00);
        dao.save(nouveau);
        System.out.println(dao.findAll());

        // 4. Tester update()
        System.out.println("\n=== Modification AOO4 ===");
        Article modification =
                new Article("AOO4", "Ecran 27 pouces", 320.00);

        dao.update(modification);
        System.out.println(dao.findByCode("AOO4"));

        // 5. Tester delete()
        System.out.println("\n=== Suppression AOO4 ===");
        dao.delete("AOO4");
        System.out.println(dao.findAll());

        // 6. Tester un article inexistant
        System.out.println("\n=== Recherche article inexistant ===");
        System.out.println(dao.findByCode("A999"));
    }
}