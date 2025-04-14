import model.UtilisateurDAO;

public class TestSupprimerUtilisateur {
    public static void main(String[] args) {
        boolean ok = UtilisateurDAO.supprimerUtilisateur(1); // teste avec un id qui existe

        if (ok) {
            System.out.println("✅ Utilisateur supprimé avec succès !");
        } else {
            System.out.println("❌ Suppression échouée ou ID inexistant.");
        }
    }
}
