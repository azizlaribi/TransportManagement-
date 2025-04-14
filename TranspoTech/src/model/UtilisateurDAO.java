package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {
    
    public static boolean ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateurs (id, nom, email, mot_de_passe, role) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, utilisateur.getId());
            stmt.setString(2, utilisateur.getNom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMotDePasse());
            stmt.setString(5, utilisateur.getRole());

            int lignes = stmt.executeUpdate();
            return lignes > 0;

        } catch (SQLException e) {
            System.out.println("Erreur ajout utilisateur : " + e.getMessage());
            return false;
        }
    }
    public static Utilisateur verifierConnexion(String email, String motDePasse) {
    String sql = "SELECT * FROM utilisateurs WHERE email = ? AND mot_de_passe = ?";
    
    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, email);
        stmt.setString(2, motDePasse);
        
        var rs = stmt.executeQuery();
        
        if (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String role = rs.getString("role");

            // On retourne un objet Utilisateur rempli avec les données
            return new Utilisateur(id, nom, email, motDePasse, role);
        } else {
            return null; // pas trouvé
        }
        
    } catch (SQLException e) {
        System.out.println("Erreur connexion utilisateur : " + e.getMessage());
        return null;
    }
}
    public static Utilisateur getUtilisateurParId(int id) {
    String sql = "SELECT * FROM utilisateurs WHERE id = ?";
    
    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, id); // on remplace le ? par la vraie valeur
        
        var rs = stmt.executeQuery(); // on exécute la requête
        
        if (rs.next()) {
            // Si un utilisateur trouvé, on récupère ses données
            String nom = rs.getString("nom");
            String email = rs.getString("email");
            String motDePasse = rs.getString("mot_de_passe");
            String role = rs.getString("role");
            
            // on retourne un objet Utilisateur construit avec ces données
            return new Utilisateur(id, nom, email, motDePasse, role);
        } else {
            return null; // Aucun utilisateur trouvé avec cet ID
        }
        
    } catch (Exception e) {
        System.out.println("Erreur getUtilisateurParId : " + e.getMessage());
        return null;
    }
}
public static Utilisateur getUtilisateurParEmail(String email) {
    String sql = "SELECT * FROM utilisateurs WHERE email = ?";
    
    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, email);  // Remplacer le "?" par la vraie adresse

        var rs = stmt.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String motDePasse = rs.getString("mot_de_passe");
            String role = rs.getString("role");

            return new Utilisateur(id, nom, email, motDePasse, role);
        } else {
            return null; // utilisateur non trouvé
        }

    } catch (Exception e) {
        System.out.println("Erreur getUtilisateurParEmail : " + e.getMessage());
        return null;
    }
}
public static List<Utilisateur> getTousLesUtilisateurs() {
    List<Utilisateur> liste = new ArrayList<>();
    String sql = "SELECT * FROM utilisateurs";
    
    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         var rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String email = rs.getString("email");
            String motDePasse = rs.getString("mot_de_passe");
            String role = rs.getString("role");

            Utilisateur u = new Utilisateur(id, nom, email, motDePasse, role);
            liste.add(u);  // ajouter à la liste
        }

    } catch (Exception e) {
        System.out.println("Erreur getTousLesUtilisateurs : " + e.getMessage());
    }

    return liste;
}
public static boolean supprimerUtilisateur(int id) {
    String sql = "DELETE FROM utilisateurs WHERE id = ?";

    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        int lignes = stmt.executeUpdate(); // renvoie combien de lignes supprimées

        return lignes > 0;

    } catch (Exception e) {
        System.out.println("Erreur supprimerUtilisateur : " + e.getMessage());
        return false;
    }
}
public static boolean modifierUtilisateur(Utilisateur utilisateur) {
    String sql = "UPDATE utilisateurs SET nom = ?, email = ?, mot_de_passe = ?, role = ? WHERE id = ?";

    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, utilisateur.getNom());
        stmt.setString(2, utilisateur.getEmail());
        stmt.setString(3, utilisateur.getMotDePasse());
        stmt.setString(4, utilisateur.getRole());
        stmt.setInt(5, utilisateur.getId());

        int lignes = stmt.executeUpdate();
        return lignes > 0;

    } catch (Exception e) {
        System.out.println("Erreur modifierUtilisateur : " + e.getMessage());
        return false;
    }
}

}
