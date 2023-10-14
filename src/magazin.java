public class magazin {
    int id;
    String adress;
    int capacite_magazin;
    private static int dernierID = 0;
    Produit[] produits;
    final int MAX_CAPA = 50;
    int nombreDeProduits;
    private int nombreEmployes;
    private Employe[] employes;
    private static final int MAX_EMPLOYES = 20;
    private String nom;


    magazin(int id, String adress, int capacite_magazin,String nom) {
        this.id = id;
        this.adress = adress;
        this.capacite_magazin = capacite_magazin;
        this.produits = new Produit[MAX_CAPA];
        this.nombreEmployes = 0;
        this.nom = nom;
        this.employes = new Employe[MAX_EMPLOYES];
        this.id = ++dernierID;

    }

    public boolean addProducts(Produit produit) {
        if (!chercherProduit(produit) && nombreDeProduits < capacite_magazin) {
            produits[nombreDeProduits] = produit;
            nombreDeProduits++;
            return true;
        }
        return false;
    }

    public boolean supprimerProduit(Produit produit) {
        for (int i = 0; i < nombreDeProduits; i++) {
            if (produits[i].comparer(produit)) {

                for (int j = i; j < nombreDeProduits - 1; j++) {
                    produits[j] = produits[j + 1];
                }
                produits[nombreDeProduits - 1] = null;
                nombreDeProduits--;
                return true;
            }
        }
        return false;
    }


    public static magazin magasinAvecPlusDeProduits(magazin magasin1, magazin magasin2) {
        if (magasin1.getNombreTotalProduits() > magasin2.getNombreTotalProduits()) {
            return magasin1;
        } else {
            return magasin2;
        }
    }

    public boolean chercherProduit(Produit produit) {
        for (int i = 0; i < nombreDeProduits; i++) {
            if (produits[i].comparer(produit)) {
                return true;
            }
        }
        return false;
    }


    public int getNombreTotalProduits() {
        return nombreDeProduits;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("ID du magasin : ").append(this.id).append("\n");
        str.append("Adresse du magasin : ").append(this.adress).append("\n");
        str.append("Capacité du magasin : ").append(this.capacite_magazin).append("\n");
        str.append("Liste des produits du magasin :\n");

        for (int i = 0; i < this.capacite_magazin; i++) {
            if (this.produits[i] != null) {
                str.append("Nom du produit : ").append(this.produits[i].getLibelle()).append("\n");
                str.append("Prix du produit : ").append(this.produits[i].getPrix()).append("\n");
            }
        }

        return str.toString();

    }
    public void afficherCaracteristiques() {
        System.out.println("ID du magasin : " + this.id);
        System.out.println("Adresse du magasin : " + this.adress);
        System.out.println("Capacité du magasin : " + this.capacite_magazin);
        System.out.println("Liste des produits du magasin :");

        for (int i = 0; i < this.capacite_magazin; i++) {
            if (this.produits[i] != null) {
                System.out.println("Nom du produit : " + this.produits[i].getMarque());
                System.out.println("Prix du produit : " + this.produits[i].getPrix());
            }
        }

    }
    public void ajouterEmploye(Employe employe) {
        if (nombreEmployes < MAX_EMPLOYES) {
            employes[nombreEmployes] = employe;
            nombreEmployes++;

        } else {
            System.out.println("Le nombre maximum d'employés est atteint pour ce magasin.");
        }


}

    public void calculerSalairesEmployes() {
        System.out.println("Calcul des salaires des employés pour le magasin " + nom + ":");
        for (int i = 0; i < nombreEmployes; i++) {
            Employe employe = employes[i];
            double salaire = 0.0; // Initialise le salaire à 0 par défaut

            // Calcul du salaire en fonction du type d'employé
            if (employe instanceof Caissier) {
                Caissier caissier = (Caissier) employe;
                salaire = caissier.calculerSalaire();
            } else if (employe instanceof Vendeur) {
                Vendeur vendeur = (Vendeur) employe;
                salaire = vendeur.calculerSalaire();
            } else if (employe instanceof Responsable) {
                Responsable responsable = (Responsable) employe;
                salaire = responsable.calculerSalaire();
            }

            System.out.println("Identifiant : " + employe.getId());
            System.out.println("Nom : " + employe.getNom());
            System.out.println("Salaire : " + salaire + " DT");
            System.out.println(); // Ligne vide pour la clarté
        }
    }


    public void afficherCaracteristiquesEmployes() {
        System.out.println("Liste des employés du magasin " + this.nom + ":");
        for (int i = 0; i < nombreEmployes; i++) {
            Employe employe = employes[i];
            System.out.println("Identifiant : " + employe.getId());
            System.out.println("Nom : " + employe.getNom());
            System.out.println("Adresse : " + employe.getAdresse());

            // Afficher les caractéristiques spécifiques à chaque type d'employé
            if (employe instanceof Caissier) {
                Caissier caissier = (Caissier) employe;
                System.out.println("Type : Caissier");
                System.out.println("Numéro de Caisse : " + caissier.getNumeroDeCaisse());
            } else if (employe instanceof Vendeur) {
                Vendeur vendeur = (Vendeur) employe;
                System.out.println("Type : Vendeur");
                System.out.println("Taux de Vente : " + vendeur.getTauxDeVente() + "%");
            } else if (employe instanceof Responsable) {
                Responsable responsable = (Responsable) employe;
                System.out.println("Type : Responsable");
                System.out.println("Prime : " + responsable.getPrime() + " DT");
            }
            System.out.println(); // Ligne vide pour la clarté
        }
    }

}