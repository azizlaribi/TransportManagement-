import model.Utilisateur;
import model.UtilisateurDAO;

public class TestGetUtilisateur {
    public static void main(String[] args) {
        Utilisateur u = UtilisateurDAO.getUtilisateurParId(1); // teste avec un ID existant

        if (u != null) {
            System.out.println("✅ Utilisateur trouvé : " + u.getNom() + ", " + u.getEmail());
        } else {
            System.out.println("❌ Utilisateur non trouvé.");
        }
    }
}
