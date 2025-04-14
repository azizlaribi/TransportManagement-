import model.Utilisateur;
import model.UtilisateurDAO;

public class TestModifierUtilisateur {
    public static void main(String[] args) {
        Utilisateur u = new Utilisateur(2, "NouveauNom", "nouveau@mail.com", "newpass", "admin");
        boolean ok = UtilisateurDAO.modifierUtilisateur(u);

        if (ok) {
            System.out.println("✅ Utilisateur modifié !");
        } else {
            System.out.println("❌ Échec de la modification.");
        }
    }
}
