import java.util.Date;
import java.text.SimpleDateFormat;
public class Main {
    public static void main(String[] args) {
        Produit p1 = new Produit();
        Produit p2 = new Produit(1021, "Lait", "Delice");
        Produit p3 = new Produit(2510, "yaourt", "vitalait");
        Produit p4 = new Produit(3250, "Tomate", "Sicam", 1.2f);
        Produit p5 = new Produit(3879, "channel", "esprit",new Date());
        p1.afficher();
        System.out.println("*******************");
        p2.afficher();
        System.out.println("*******************");
        p3.afficher();
        System.out.println("*******************");
        p4.afficher();
        System.out.println("*******************");
        p5.afficher();
        // Modification du prix du produit lait
        p1.setPrix(7F);
        System.out.println("*******************");
        System.out.println("Produit lait modifié :");
        p1.afficher();

        // Compléter les informations manquantes
        p2.setMarque("Vitalait");
        p3.setPrix(1.2f);
        System.out.println("*******************");
        // Affichage des produits modifiés
        System.out.println("Produits modifiés :");
        p1.afficher();
        System.out.println("*******************");
        p2.afficher();
        System.out.println("*******************");
        p3.afficher();
        System.out.println("***********************************************");

        System.out.println("Affichage des produits créés à l'aide de toString() :");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = dateFormat.parse("01/01/2024");
            Date date2 = dateFormat.parse("01/02/2024");
            Date date3 = dateFormat.parse("01/03/2024");

            p1.setDateExpiration(date1);
            p2.setDateExpiration(date2);
            p3.setDateExpiration(date3);
            System.out.println("***********************************************");
            System.out.println("Dates d'expiration ajoutées aux produits existants :");
            p1.afficher();
            System.out.println("*******************");
            p2.afficher();
            System.out.println("*******************");
            p3.afficher();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("***********************************************");
        magazin magasin = new magazin(1, "123 Rue du Magasin", 50,"monoprix");
        magazin magasin1=new magazin(2,"rue des orangers",40,"generale");
        magasin.addProducts(p1);
        magasin.addProducts(p2);
        magasin.addProducts(p3);
        magasin.addProducts(p4);
        magasin.addProducts(p5);
        System.out.println("Caracteristique magasin 1 :");
        magasin.afficherCaracteristiques();
        magasin1.addProducts(p1);
        magasin1.addProducts(p2);
        magasin1.addProducts(p3);
        System.out.println("***********************************************");
        System.out.println("Caracteristique magasin 2 :");
        magasin1.afficherCaracteristiques();
        System.out.println("***********************************************");
        int nombreTotalProduits = magasin.getNombreTotalProduits();
        System.out.println("Nombre total de produits dans le magasin : " + nombreTotalProduits);
        magasin.supprimerProduit(p5);
        System.out.println("Nombre total de produits après suppression : " + magasin.getNombreTotalProduits());
        System.out.println(magasin.chercherProduit(p5));
        System.out.println("***********************************************");
        System.out.println("Magazin avec le plus de produits est :");
        System.out.println(magazin.magasinAvecPlusDeProduits(magasin,magasin1));
        // Création des employés pour le premier magasin
        Caissier caissier1 = new Caissier(1, "Alice", "Adresse1", 200, 1);
        Vendeur vendeur1 = new Vendeur(2, "Bob", "Adresse2", 160, 5);
        Responsable responsable1 = new Responsable(3, "Charlie", "Adresse3", 180.0);

        // Création des employés pour le deuxième magasin
        Caissier caissier2 = new Caissier(4, "David", "Adresse4", 220, 2);
        Vendeur vendeur2 = new Vendeur(5, "Eve", "Adresse5", 150, 7);
        Vendeur vendeur3 = new Vendeur(6, "Frank", "Adresse6", 170, 4);
        Responsable responsable2 = new Responsable(7, "Grace", "Adresse7", 190.0);

        // Ajout des employés aux magasins
        magasin1.ajouterEmploye(caissier1);
        magasin1.ajouterEmploye(vendeur1);
        magasin1.ajouterEmploye(responsable1);

        magasin.ajouterEmploye(caissier2);
        magasin.ajouterEmploye(vendeur2);
        magasin.ajouterEmploye(vendeur3);
        magasin.ajouterEmploye(responsable2);
// Affichage des caractéristiques des employés
        System.out.println("***********************************************");
        System.out.println("Caractéristiques des employés du premier magasin:");
        magasin.afficherCaracteristiquesEmployes();
        System.out.println("***********************************************");
        System.out.println("\nCaractéristiques des employés du deuxième magasin:");
        magasin1.afficherCaracteristiquesEmployes();
        System.out.println("***********************************************");
        System.out.println("\nSalaires des employés du premier magasin:");
        magasin.calculerSalairesEmployes();
        System.out.println("***********************************************");
        System.out.println("\nSalaires des employés du deuxième magasin:");
        magasin1.calculerSalairesEmployes();


    }
}