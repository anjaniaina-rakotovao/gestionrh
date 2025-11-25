-- Données pour Table: sexe
INSERT INTO sexe (id_sexe, libelle) VALUES
('S-H', 'Homme'),
('S-F', 'Femme');

---
-- Données pour Table: type_contrat
INSERT INTO type_contrat (id_type_contrat, libelle, duree_max) VALUES
('TCO-CDI', 'Contrat à Durée Indéterminée', NULL),
('TCO-CDD', 'Contrat à Durée Déterminée', 36),
('TCO-APPR', 'Contrat d''Apprentissage', 24);

---
-- Données pour Table: type_conge
INSERT INTO type_conge (id_type_conge, libelle, duree_max) VALUES
('TCG-ANN', 'Congé Annuel Payé', 30),
('TCG-MAL', 'Congé Maladie', 15),
('TCG-MAT', 'Congé Maternité', 112);

---
-- Données pour Table: domaine
INSERT INTO domaine (id_domaine, libelle) VALUES
('D-INFO', 'Informatique et Développement'),
('D-ADM', 'Administration et RH'),
('D-COM', 'Commercial et Ventes');

---
-- Données pour Table: poste
INSERT INTO poste (id_poste, libelle, id_domaine) VALUES
('P-DEVSR', 'Développeur Senior', 'D-INFO'),
('P-RH', 'Chargé de Ressources Humaines', 'D-ADM'),
('P-CM', 'Commercial Manager', 'D-COM'),
('P-DEVJR', 'Développeur Junior', 'D-INFO');

---
-- Données pour Table: salaire (Échelle salariale par poste)
INSERT INTO salaire (id_salaire, id_poste, montant) VALUES
('SAL-SR', 'P-DEVSR', 60000.00),
('SAL-RH', 'P-RH', 45000.00),
('SAL-CM', 'P-CM', 55000.00),
('SAL-JR', 'P-DEVJR', 35000.00);

---
-- Données pour Table: employe
INSERT INTO employe (id_employe, nom, prenom, date_naissance, mail, adresse, contact, id_sexe, image_path) VALUES
('EMP001', 'Dupont', 'Alice', '1990-05-15', 'alice.dupont@test.com', '10 Rue de la Paix, 75001 Paris', '0612345678', 'S-F', '/img/p-alice.jpg'),
('EMP002', 'Martin', 'Benoit', '1985-11-20', 'benoit.martin@test.com', '25 Avenue des Champs, 69002 Lyon', '0798765432', 'S-H', '/img/p-benoit.jpg'),
('EMP003', 'Lefevre', 'Carla', '1998-08-01', 'carla.lefevre@test.com', '5 Boulevard Voltaire, 31000 Toulouse', '0655443322', 'S-F', '/img/p-carla.jpg');

---
-- Données pour Table: doc_employe
INSERT INTO doc_employe (id_doc_employe, id_employe, image_path) VALUES
('DOC001-C', 'EMP001', '/docs/EMP001/CV.pdf'),
('DOC001-ID', 'EMP001', '/docs/EMP001/ID.jpg'),
('DOC002-C', 'EMP002', '/docs/EMP002/CV.pdf');

---
-- Données pour Table: contrat
INSERT INTO contrat (id_contrat, id_employe, id_type_contrat, date_debut, date_fin, duree) VALUES
('CONTR001', 'EMP001', 'TCO-CDI', '2018-01-01', NULL, NULL),
('CONTR002', 'EMP002', 'TCO-CDD', '2023-03-01', '2024-02-29', 12),
('CONTR003', 'EMP003', 'TCO-CDI', '2024-06-01', NULL, NULL);

---
-- Données pour Table: employe_poste
INSERT INTO employe_poste (id_employe_poste, id_employe, id_poste, date_debut, date_fin) VALUES
('EP001', 'EMP001', 'P-DEVSR', '2018-01-01', NULL),
('EP002', 'EMP002', 'P-RH', '2023-03-01', NULL),
('EP003', 'EMP003', 'P-DEVJR', '2024-06-01', NULL);

---
-- Données pour Table: histo_mouvement (Exemple pour un jour donné)
INSERT INTO histo_mouvement (id_hist_mouvement, id_employe, retard, heure_sup, pauses, absence, date) VALUES
('HM-20241112-1', 'EMP001', 5, 0, 60, 0, '2024-11-12'), -- Alice a eu 5 min de retard
('HM-20241112-2', 'EMP002', 0, 2, 45, 0, '2024-11-12'), -- Benoit a fait 2h sup
('HM-20241112-3', 'EMP003', 0, 0, 60, 0, '2024-11-12');

---
-- Données pour Table: presence (Exemple d'une journée de travail)
INSERT INTO presence (id_presence, id_employe, mouvement, date) VALUES
('PRES-001-IN', 'EMP001', 'Entrée', '2024-11-13 09:05:00'),
('PRES-001-OUT', 'EMP001', 'Sortie', '2024-11-13 18:05:00'),
('PRES-002-IN', 'EMP002', 'Entrée', '2024-11-13 08:58:00'),
('PRES-002-OUT', 'EMP002', 'Sortie', '2024-11-13 18:30:00');

---
-- Données pour Table: conge
INSERT INTO conge (id_conge, id_employe, id_type_conge, date_debut, date_fin) VALUES
('CONG-001', 'EMP001', 'TCG-ANN', '2024-12-23', '2024-12-31'), -- Alice demande des congés annuels
('CONG-002', 'EMP002', 'TCG-MAL', '2024-11-05', '2024-11-05'); -- Benoit a été malade 1 jour

---
-- Données pour Table: statut
INSERT INTO statut (id_statut, libelle) VALUES
('STAT-DEM', 'Demandé'),
('STAT-APP', 'Approuvé'),
('STAT-REJ', 'Rejeté'),
('STAT-UTIL', 'Utilisé');

---
-- Données pour Table: statut_conge
INSERT INTO statut_conge (id_statut_conge, id_conge, date_statut, id_statut) VALUES
('STCG-001-1', 'CONG-001', '2024-10-15', 'STAT-DEM'),
('STCG-001-2', 'CONG-001', '2024-10-18', 'STAT-APP'),
('STCG-002-1', 'CONG-002', '2024-11-05', 'STAT-UTIL');

---
-- Données pour Table: histo_salaire (Paie des employés pour le mois dernier)
INSERT INTO histo_salaire (id_histo_salaire, id_employe, mois, annee, montant_net) VALUES
('HSAL-001-1024', 'EMP001', 10, 2024, 4500.00), -- Alice
('HSAL-002-1024', 'EMP002', 10, 2024, 3375.00); -- Benoit