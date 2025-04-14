import model.Utilisateur;
import model.UtilisateurDAO;

public class TestGetUtilisateurParEmail {
    public static void main(String[] args) {
        Utilisateur u = UtilisateurDAO.getUtilisateurParEmail("ali@gmail.com");

        if (u != null) {
            System.out.println("✅ Utilisateur trouvé : " + u.getNom() + ", rôle : " + u.getRole());
        } else {
            System.out.println("❌ Aucun utilisateur trouvé avec cet email.");
        }
    }
}
