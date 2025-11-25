CREATE DATABASE rhgestion;
use rhgestion;
-- Table: type_contrat
CREATE TABLE type_contrat (
    id_type_contrat VARCHAR(50) PRIMARY KEY,
    libelle VARCHAR(100),
    duree_max INT
);

-- Table: type_conge
CREATE TABLE type_conge (
    id_type_conge VARCHAR(50) PRIMARY KEY,
    libelle VARCHAR(100),
    duree_max INT
);

-- Table: domaine
CREATE TABLE domaine (
    id_domaine VARCHAR(50) PRIMARY KEY,
    libelle VARCHAR(100)
);

-- Table: poste
CREATE TABLE poste (
    id_poste VARCHAR(50) PRIMARY KEY,
    libelle VARCHAR(100),
    id_domaine VARCHAR(50),
    FOREIGN KEY (id_domaine) REFERENCES domaine(id_domaine)
);

-- Table: sexe
CREATE TABLE sexe(
    id_sexe VARCHAR(50) PRIMARY KEY,
    libelle VARCHAR(50)
);

-- Table: employe
CREATE TABLE employe (
    id_employe VARCHAR(50) PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    date_naissance DATE,
    mail VARCHAR(100),
    adresse VARCHAR(255),
    contact VARCHAR(255),
    id_sexe VARCHAR(50),
    image_path VARCHAR(255),
    FOREIGN KEY (id_sexe) REFERENCES sexe(id_sexe)
);

-- Table: doc_employe (CORRIGÉ - "soc_employeur" → "doc_employe")
CREATE TABLE doc_employe (
    id_doc_employe VARCHAR(50) PRIMARY KEY,
    id_employe VARCHAR(50),
    image_path VARCHAR(255),
    FOREIGN KEY (id_employe) REFERENCES employe(id_employe)
);

-- Table: contrat (CORRIGÉ - ajout id_type_contrat)
CREATE TABLE contrat (
    id_contrat VARCHAR(50) PRIMARY KEY,
    id_employe VARCHAR(50),
    id_type_contrat VARCHAR(50),
    date_debut DATE,
    date_fin DATE,
    duree INT,
    FOREIGN KEY (id_employe) REFERENCES employe(id_employe),
    FOREIGN KEY (id_type_contrat) REFERENCES type_contrat(id_type_contrat)
);

-- Table: employe_poste
CREATE TABLE employe_poste (
    id_employe_poste VARCHAR(50) PRIMARY KEY,
    id_employe VARCHAR(50),
    id_poste VARCHAR(50),
    date_debut DATE,
    date_fin DATE,
    FOREIGN KEY (id_employe) REFERENCES employe(id_employe),
    FOREIGN KEY (id_poste) REFERENCES poste(id_poste)
);

-- Table: histo_mouvement
CREATE TABLE histo_mouvement (
    id_hist_mouvement VARCHAR(50) PRIMARY KEY,
    id_employe VARCHAR(50),
    retard INT,
    heure_sup INT,
    pauses INT,
    absence INT,
    date DATE,
    FOREIGN KEY (id_employe) REFERENCES employe(id_employe)
);

-- Table: presence
CREATE TABLE presence (
    id_presence VARCHAR(50) PRIMARY KEY,
    id_employe VARCHAR(50),
    mouvement VARCHAR(50), 
    date DATETIME,
    FOREIGN KEY (id_employe) REFERENCES employe(id_employe)
);

-- Table: conge
CREATE TABLE conge (
    id_conge VARCHAR(50) PRIMARY KEY,
    id_employe VARCHAR(50),
    id_type_conge VARCHAR(50),
    date_debut DATE,
    date_fin DATE,
    FOREIGN KEY (id_employe) REFERENCES employe(id_employe),
    FOREIGN KEY (id_type_conge) REFERENCES type_conge(id_type_conge)
);

-- Table: statut
CREATE TABLE statut (
    id_statut VARCHAR(50) PRIMARY KEY,
    libelle VARCHAR(50)
);

-- Table: statut_conge (CORRIGÉ - ajout clé étrangère vers statut)
CREATE TABLE statut_conge (
    id_statut_conge VARCHAR(50) PRIMARY KEY,
    id_conge VARCHAR(50),
    date_statut DATE,
    id_statut VARCHAR(50), 
    FOREIGN KEY (id_conge) REFERENCES conge(id_conge),
    FOREIGN KEY (id_statut) REFERENCES statut(id_statut)
);

-- Table: salaire (GARDÉ tel quel)
CREATE TABLE salaire (
    id_salaire VARCHAR(50) PRIMARY KEY,
    id_poste VARCHAR(50),
    montant DECIMAL(10, 2),
    FOREIGN KEY (id_poste) REFERENCES poste(id_poste)
);

-- Table: histo_salaire (GARDÉ tel quel)
CREATE TABLE histo_salaire (
    
    id_histo_salaire VARCHAR(50) PRIMARY KEY,
    id_employe VARCHAR(50),
    mois INT,
    annee INT,
    montant_net DECIMAL(10, 2),
    FOREIGN KEY (id_employe) REFERENCES employe(id_employe)
);