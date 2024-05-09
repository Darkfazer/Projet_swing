### Conception Des données UML - Class Diagram
![Untitled diagram-2024-05-09-221007](https://github.com/Darkfazer/Projet_swing/assets/95308949/96727e9d-a54f-4618-8886-3509c2856d16)


```mermaid
classDiagram
    class Utilisateur {
        +int id
        +string username
        +string type
        +string password
    }
    class Employeur {
        +int id
        +string nom
        +string adresse
        +decimal tele
        +date dateDebut
        +string post
        +int idtache
        +decimal salaire
        +int idProjet
    }
    class Maconnerie {
        +int id
        +int idresponsable
        +int Nbrempl
        +string echancier
        +int etatdavanc
        +date dateDebut
        +date dateFin
        +decimal charges
        +decimal depances
        +string remarque
        +string structure
        +string nomTache
        +int idprojet
    }
    class Produits {
        +int id
        +string nomProduit
        +string type
        +int idtache
        +int idprojet
        +int quantite
        +decimal prix_total
        +string description
    }
    class Projets {
        +int idProjet
        +string nomProjet
        +string adresseProjet
        +string client
        +string chefProjet
        +date dateDebut
        +date dateFin
        +decimal budget
        +string echancier
        +string typeProjet
        +string taches
        +string imagePlan
        +int etatavacement
    }
    Utilisateur "1" -- "1..*" Employeur
    Employeur "1" -- "1..*" Maconnerie
    Employeur "1" -- "1..*" Produits
    Employeur "1" -- "1..*" Projets
Conception Des données UML - Use Case Diagram
![Untitled diagram-2024-05-09-223143](https://github.com/Darkfazer/Projet_swing/assets/95308949/3a9852e3-4ae3-4a83-b09e-6b0867be3147)

graph TD;
    Utilisateur --> Gérer_Utilisateur;
    Employeur --> Gérer_Employeur;
    Employeur --> Gérer_Maçonnerie;
    Employeur --> Gérer_Produits;
    Employeur --> Gérer_Projets;

    subgraph "Projet Management System"
        Gérer_Utilisateur("Gérer Utilisateur") --> Gérer_Utilisateur_Details{" "}
        Gérer_Employeur("Gérer Employeur") --> Gérer_Employeur_Details{" "}
        Gérer_Maçonnerie("Gérer Maçonnerie") --> Gérer_Maçonnerie_Details{" "}
        Gérer_Produits("Gérer Produits") --> Gérer_Produits_Details{" "}
        Gérer_Projets("Gérer Projets") --> Gérer_Projets_Details{" "}
    end
