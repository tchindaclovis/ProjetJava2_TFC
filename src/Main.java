import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialisez la connexion à la base de données
            DBconnection db = new DBconnection();
            db.initialize("jdbc:postgresql://localhost:5432/bibliotheque_tchinda", "postgres", "7777");

            FichierMenus.menuChoice();

            // Fermez la connexion à la fin
            DBconnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
