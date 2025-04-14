import model.Utilisateur;
import model.UtilisateurDAO;

public class TestAjoutUtilisateur {
    public static void main(String[] args) {
        Utilisateur u = new Utilisateur(1, "Ali", "ali@gmail.com", "azerty", "passager");

        boolean ok = UtilisateurDAO.ajouterUtilisateur(u);
        if (ok) {
            System.out.println("✅ Utilisateur ajouté avec succès !");
        } else {
            System.out.println("❌ Échec de l'ajout.");
        }
    }
}
