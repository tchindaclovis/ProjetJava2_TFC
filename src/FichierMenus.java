import java.util.Scanner;
import java.sql.SQLException;

public class FichierMenus {


    // Menus de notre application
    public FichierMenus() throws SQLException {
    }

    static void menuChoice() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("BIENVENUE DANS NOTRE BIBLIOTHEQUE\n");
        System.out.println("Veuillez choisir une option en entrant un nombre entre 1 et 4: \n");
        System.out.println("1 : Gestion des livres");
        System.out.println("2 : Gestion des membres");
        System.out.println("3 : Gestion des Emprunts et pénélités");
        System.out.println("4 : quitter\n");
        System.out.println("Votre choix s'il vous plait: ");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                generiqueMenuHead("livres");
                int choice1 = scanner.nextInt();
                switch (choice1) {
                    case 0:
                        menuChoice();
                    break;

                    case 1:
                        LivreDAO.displayLivres(); //déclenche la méthode displayElem(ResultSet set)
                        generiqueMenuHead("livres");
                        choice1 = scanner.nextInt();
                        optionDeSortieLivres(scanner, choice1);
                    break;

                    case 2:
                        LivreDAO.menuAddDelModLivres();
                    break;

                    case 3:
                        LivreDAO.menuDeRechercheLivres();
                    break;

                    case 4:
                        end();
                        System.exit(0);
                    break;

                    default:
                        System.out.println("choix invalide... retour au menu");
                        System.out.println("Votre choix: ");
                        choice1 = scanner.nextInt();
                }
            break;

            case 2:
                generiqueMenuHead("membres");
                int choice2 = scanner.nextInt();
                switch (choice2) {
                    case 0:
                        menuChoice();
                    break;

                    case 1:
                        MembreDAO.displayMembres();
                        generiqueMenuHead("membres");
                        choice2 = scanner.nextInt();
                        optionDeSortieMembres(scanner, choice2);
                    break;

                    case 2:
                        MembreDAO.menuAddDelModMembres();
                    break;

                    case 3:
                        MembreDAO.menuDeRechercheMembres();
                    break;

                    default:
                        System.out.println("choix invalide... retour au menu");
                        System.out.println("Votre choix: ");
                        choice2 = scanner.nextInt();
                }
            break;

            case 3:
                EmpruntDAO.menuEmpruntPenalite();
            break;

            case 4:
                end();
                System.exit(0);
            break;

            default:
                System.out.println("choix invalide... retour au menu principal");
                menuChoice();
        }
    }

    public static void optionDeSortieLivres(Scanner scanner, int choice1) throws SQLException {
        switch (choice1){
            case 0:
                menuChoice();
            break;

            case 1:
                LivreDAO.displayLivres(); //déclenche la méthode displayElem(ResultSet set)
                generiqueMenuHead("livres");
                choice1 = scanner.nextInt();
                optionDeSortieLivres(scanner, choice1);
            break;

            case 2:
                LivreDAO.menuAddDelModLivres();
            break;

            case 3:
                LivreDAO.menuDeRechercheLivres();
            break;

            default:
                System.out.println("choix invalide... retour au menu");
                System.out.println("Votre choix: ");
                choice1 = scanner.nextInt();
        }
    }

    public static void optionDeSortieMembres(Scanner scanner, int choice2) throws SQLException {
        switch (choice2){
            case 0:
                menuChoice();
                break;

            case 1:
                MembreDAO.displayMembres(); //déclenche la méthode displayElem(ResultSet set)
                generiqueMenuHead("membres");
                choice2 = scanner.nextInt();
                optionDeSortieMembres(scanner, choice2);
                break;

            case 2:
                MembreDAO.menuAddDelModMembres();
                break;

            case 3:
                MembreDAO.menuDeRechercheMembres();
                break;

            default:
                System.out.println("choix invalide... retour au menu");
                System.out.println("Votre choix: ");
                choice2 = scanner.nextInt();
        }
    }


    public static void optionDeSortieTypeEmprunts(Scanner scanner, int choice1) throws SQLException {
        switch (choice1){
            case 0:
                menuChoice();
            break;

            case 1:
                System.out.println("Liste de toutes les emprunts RETOURNES\n :");
                EmpruntDAO.displayEmpruntRetourne();
                genrequeMenuBodyEmprunts();
                choice1 = scanner.nextInt();
                optionDeSortieTypeEmprunts(scanner,choice1);
            break;

            case 2:
                System.out.println("Liste de toutes les emprunts ENCOURS\n :");
                EmpruntDAO.displayEmpruntEncours();
                genrequeMenuBodyEmprunts();
                choice1 = scanner.nextInt();
                optionDeSortieTypeEmprunts(scanner,choice1);
            break;

            case 3:
                EmpruntDAO.menuEmpruntPenalite() ;
            break;

            default:
            break;
        }
    }

    // Méthode pour gérer la navigation post-mise à jour
    static void postUpdateNavigation() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVoulez-vous retourner au menu principal ? :");
            System.out.println("0 : retour au menu de Gestion de livres");
            System.out.println("1 : Retour au menu principal");
            System.out.println("2 : Quitter\n");
            System.out.println("Votre choix s'il vous plait: ");
            String choice = scanner.nextLine();

            if (choice.equals("0")) {

                generiqueMenuHead("livres");
                int choice1 = scanner.nextInt();
                switch (choice1) {
                    case 0:
                        menuChoice();
                        break;

                    case 1:
                        LivreDAO.displayLivres(); //déclenche la méthode displayElem(ResultSet set)
                        genrequeMenuBody("livres");
                        choice1 = scanner.nextInt();
                        optionDeSortieLivres(scanner, choice1);
                        break;

                    case 2:
                        LivreDAO.menuAddDelModLivres();
                        break;

                    case 3:
                        LivreDAO.menuDeRechercheLivres();
                        break;

                    default:
                        System.out.println("choix invalide... retour au menu");
                        System.out.println("Votre choix: ");
                        choice1 = scanner.nextInt();
                }
                break; // Sort de la boucle après le retour au menu de Gestion de livres

            } else if (choice.equals("1")) {
                menuChoice();
                break; // Sort de la boucle après le retour au menu
            } else if (choice.equals("2")) {
                System.out.println("Merci d'avoir utilisé notre application...");
                System.exit(0); // Quitte l'application
            } else {
                System.out.println("Choix invalide. Veuillez entrer '0' '1' ou '2'.");
            }
        }
    }

    static void end() {
        System.out.println("merci d'avoir utilisé notre application A BIENTOT ");
    }

    //Génération du menu de gestion d'un élément Livre ou Membre
    public static void generiqueMenuHead(String elem) {
       // System.out.println("Voici la liste de tous les " +elem+ " de notre biliothèque \n");
        System.out.println("Bienvenue dans le Menu de Gestion de " + elem);
        System.out.println("0 : retour au menu Principal");
        System.out.println("1 : Afficher la liste des " + elem);
        System.out.println("2 : Ajouter / modifier / supprimer un " + elem);
        System.out.println("3 : Rechercher un " + elem);
        System.out.println("4 : quitter");
        System.out.print("Votre choix s'il vous plait: ");
    }

    public static void genrequeMenuBody(String elem) {
        System.out.println("Voici la liste des tous les " +elem+ " de notre biliothèque \n");
        System.out.println("0 : retour au menu de Gestion de " +elem);
        System.out.println("1 : retour au menu Principal");
        System.out.println("2 : quitter\n");
        System.out.println("Votre choix s'il vous plait: ");
    }

    public static void genrequeMenuHeadEmprunts() {
        // menu de tête des emprunts
        System.out.println("Bienvenue dans le menu de gestion des emprunts et pénalités");
        System.out.println("0. retour au menu Principal");
        System.out.println("1. Afficher la liste des emprunts");
        System.out.println("2. Ajouter un emprunt");
        System.out.println("3. Retourner un emprunt");
        System.out.println("4. calculer et Afficher la liste pénalites");
        System.out.println("5. Quitter");
        System.out.println("votre choix : ");
    }

    public static void genrequeMenuBodyEmprunts() {
        // menu de pieds des emprunts
        System.out.println("\n0 : Retour au menu Principal");
        System.out.println("1 : Afficher les emprunts RETOURNES");
        System.out.println("2 : Afficher les emprunts ENCOURS");
        System.out.println("3 : Retour au menu de gestion des emprunts et pénalités");
        System.out.println("votre choix : ");
    }
}
