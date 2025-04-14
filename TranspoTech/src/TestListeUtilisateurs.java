import model.Utilisateur;
import model.UtilisateurDAO;
import java.util.List;

public class TestListeUtilisateurs {
    public static void main(String[] args) {
        List<Utilisateur> utilisateurs = UtilisateurDAO.getTousLesUtilisateurs();

        if (utilisateurs.isEmpty()) {
            System.out.println("❌ Aucun utilisateur trouvé.");
        } else {
            System.out.println("✅ Liste des utilisateurs :");
            for (Utilisateur u : utilisateurs) {
                System.out.println("- " + u.getNom() + " | " + u.getEmail() + " | " + u.getRole());
            }
        }
    }
}
