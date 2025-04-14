import java.sql.Connection;
import model.Database;

public class TestConnexion {
    public static void main(String[] args) {
        Connection conn = Database.getConnection();

        if (conn != null) {
            System.out.println("✅ Connexion à la base réussie !");
        } else {
            System.out.println("❌ Échec de la connexion.");
        }
    }
}
