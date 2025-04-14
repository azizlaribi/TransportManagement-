import model.Utilisateur;
import model.UtilisateurDAO;

public class TestConnexionUtilisateur {
    public static void main(String[] args) {
        Utilisateur u = UtilisateurDAO.verifierConnexion("ali@gmail.com", "azerty");

        if (u != null) {
            System.out.println("✅ Connexion réussie : " + u.getNom() + " (" + u.getRole() + ")");
        } else {
            System.out.println("❌ Email ou mot de passe incorrect.");
        }
    }
}
