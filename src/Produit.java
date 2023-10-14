import java.util.Date;
public class Produit {
    int id;
    String libelle,marque;
    float prix;
    Date dateExp;
    static int nbrproduits;

    Produit(){

    }
    Produit(int id,String libelle,String marque)
        {this.id=id;
        this.libelle=libelle;
        this.marque=marque;
        }
    Produit(int id,String libelle,String marque,float prix)
    {   this.id=id;
        this.libelle=libelle;
        this.marque=marque;
        this.prix=prix;
        nbrproduits++;
   }
    Produit(int id,String libelle,String marque,Date dateExp)
    {   this.id=id;
        this.libelle=libelle;
        this.marque=marque;

        this.dateExp= dateExp;
        }

    void afficher()
    {
        System.out.println("L'id:" +id);
        System.out.println("Libelle:" +libelle);
        System.out.println("marque:" +marque);
        System.out.println("prix:" +prix);
        System.out.println("date:" +dateExp);

        }
    public void setLibelle(String libelle)
    {this.libelle=libelle;}

    public String getLibelle() {
        return libelle;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getPrix() {
        return prix;
    }

    public void setMarque(String vitalait) {
        this.marque = marque;
    }

    public String getMarque(){
        return marque;
    }

    public void setDateExpiration(Date dateExp) {
        this.dateExp = dateExp;
    }

   public boolean comparer(Produit autreProduit) {
        return this.id == autreProduit.id && this.libelle.equals(autreProduit.libelle) && this.prix == autreProduit.prix;
    }

    public static boolean comparer(Produit p1,Produit p2)
    {
        return p1.id==p2.id &&p1.prix ==p2.prix &&p1.libelle.equals(p2.libelle);
    }





}


