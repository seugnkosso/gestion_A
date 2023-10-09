package com.kosso;

import java.util.Scanner;

import com.kosso.entities.ArticleConfection;
import com.kosso.entities.Categorie;
import com.kosso.repositories.ITables;
import com.kosso.repositories.bd.ArticleConfectionBd;
import com.kosso.repositories.bd.CategorieBd;
import com.kosso.repositories.list.TableArticleConfections;
import com.kosso.repositories.list.TableCategories;
import com.kosso.services.ArticleConfectionServiceImpl;
import com.kosso.services.CategorieServiceImpl;

public class App {
    public static void main(String[] args) {
        // couplage faible
        ITables<Categorie> categoriRep = new CategorieBd();
        CategorieServiceImpl categorieService = new CategorieServiceImpl(categoriRep);
        ITables<ArticleConfection> articleConfRep = new ArticleConfectionBd();
        ArticleConfectionServiceImpl articleConfService = new ArticleConfectionServiceImpl(articleConfRep);

        try (Scanner sc = new Scanner(System.in)) {
            int choix;
            do {

                System.out.println("1 => ajouter categori");
                System.out.println("2 => lister categori");
                System.out.println("3 => ajouter article confection");
                System.out.println("4 => lister article confection");
                System.out.println("9 => quitter");

                choix = sc.nextInt();
                sc.nextLine();
                switch (choix) {
                    case 1:
                        System.out.println("entrer le libellé");
                        Categorie categorie = new Categorie(sc.nextLine());
                        categorieService.add(categorie);
                        break;
                    case 2:
                        categorieService.getAll().forEach(System.out::println);
                        System.out.println("1 => supprimer");
                        System.out.println("2 => continuer");
                        int choixDelete = sc.nextInt();
                        sc.nextLine();
                        if (choixDelete == 1) {
                            System.out.println("entrer l'id du categorie");
                            int id = sc.nextInt();
                            sc.nextLine();
                            if (categorieService.index(id) != -1) {
                                categorieService.remove(id);
                            } else {
                                System.out.println("l'objet n'existe pas");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("entrer le libellé");
                        String libelle = sc.nextLine();
                        System.out.println("entrer le prix");
                        double prix = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("entrer le qte");
                        int qte = sc.nextInt();
                        sc.nextLine();
                        ArticleConfection articleConf = new ArticleConfection(libelle, prix, qte);
                        articleConfService.add(articleConf);
                        break;
                    case 4:
                        articleConfService.getAll().forEach(System.out::println);
                        System.out.println("1 => supprimer");
                        System.out.println("2 => continuer");
                        choixDelete = sc.nextInt();
                        sc.nextLine();
                        if (choixDelete == 1) {
                            System.out.println("entrer l'id de l'article");
                            int id = sc.nextInt();
                            sc.nextLine();
                            if (articleConfService.index(id) != -1) {
                                articleConfService.remove(id);
                            } else {
                                System.out.println("l'objet n'existe pas");
                            }
                        }
                        break;
                }
            } while (choix != 9);
        }
    }
}
