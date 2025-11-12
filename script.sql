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
    libelle VARCHAR(100)
);

-- Table: soc_employeur
CREATE TABLE soc_employeur (
    id_soc_employeur VARCHAR(50) PRIMARY KEY,
    libelle VARCHAR(100),
    image_path VARCHAR(255)
);

-- Table: employe
CREATE TABLE employe (
    id_employe VARCHAR(50) PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    mail VARCHAR(100),
    adresse VARCHAR(255),
    id_soc_employeur VARCHAR(50),
    image_path VARCHAR(255),
    FOREIGN KEY (id_soc_employeur) REFERENCES soc_employeur(id_soc_employeur)
);

-- Table: employe_contrat
CREATE TABLE employe_contrat (
    id_contrat VARCHAR(50) PRIMARY KEY,
    id_employe VARCHAR(50),
    id_type_contrat VARCHAR(50),
    date_debut DATE,
    date_fin DATE,
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

-- Table: poste_domaine
CREATE TABLE poste_domaine (
    id_poste VARCHAR(50),
    id_domaine VARCHAR(50),
    PRIMARY KEY (id_poste, id_domaine),
    FOREIGN KEY (id_poste) REFERENCES poste(id_poste),
    FOREIGN KEY (id_domaine) REFERENCES domaine(id_domaine)
);

-- Table: hist_mouvement
CREATE TABLE hist_mouvement (
    id_hist_mouvement VARCHAR(50) PRIMARY KEY,
    id_employe VARCHAR(50),
    id_poste VARCHAR(50),
    date DATE,
    heure TIME,
    statut VARCHAR(50),
    mouvement VARCHAR(50),
    motif_mouvement VARCHAR(100),
    FOREIGN KEY (id_employe) REFERENCES employe(id_employe),
    FOREIGN KEY (id_poste) REFERENCES poste(id_poste)
);

-- Table: presence_absence
CREATE TABLE presence_absence (
    id_presence VARCHAR(50) PRIMARY KEY,
    id_employe VARCHAR(50),
    statut VARCHAR(50), -- ex: Présent, Absent, En retard
    date DATE,
    heure TIME,
    motif_mouvement VARCHAR(100), -- Pour lier à hist_mouvement si nécessaire
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

-- Table: statut_conge
CREATE TABLE statut_conge (
    id_statut_conge VARCHAR(50) PRIMARY KEY,
    id_conge VARCHAR(50),
    date DATE,
    statut VARCHAR(50), -- ex: Demandé, Approuvé, Rejeté
    FOREIGN KEY (id_conge) REFERENCES conge(id_conge)
);

-- Table: hist_salaire
CREATE TABLE hist_salaire (
    id_hist_salaire VARCHAR(50) PRIMARY KEY,
    id_employe VARCHAR(50),
    mois INT,
    annee INT,
    montant_net DECIMAL(10, 2), -- Utilisation de DECIMAL pour les montants d'argent
    FOREIGN KEY (id_employe) REFERENCES employe(id_employe)
);

-- Table: note_salaire
CREATE TABLE note_salaire (
    id_note VARCHAR(50) PRIMARY KEY,
    id_salaire VARCHAR(50), -- Probablement id_hist_salaire
    id_conge VARCHAR(50), -- Si la note concerne un congé particulier (sans solde, etc.)
    date DATE,
    statut VARCHAR(50),
    montant DECIMAL(10, 2),
    FOREIGN KEY (id_salaire) REFERENCES hist_salaire(id_hist_salaire),
    FOREIGN KEY (id_conge) REFERENCES conge(id_conge)
);


CREATE TABLE conge_solde (
    id_conge_solde VARCHAR(50) PRIMARY KEY,
    id_employe VARCHAR(50),
    id_type_conge VARCHAR(50),
    solde INT, -- Solde en jours ou heures
    annee INT,
    FOREIGN KEY (id_employe) REFERENCES employe(id_employe),
    FOREIGN KEY (id_type_conge) REFERENCES type_conge(id_type_conge)
);