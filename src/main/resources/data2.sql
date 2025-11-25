INSERT INTO sexe (id_sexe, libelle) VALUES
('S-H', 'Homme'),
('S-F', 'Femme');
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

INSERT INTO statut (id_statut, libelle) VALUES
('STAT-DEM', 'Demandé'),
('STAT-APP', 'Approuvé'),
('STAT-REJ', 'Rejeté'),
('STAT-UTIL', 'Utilisé');

INSERT INTO salaire (id_salaire, id_poste, montant) VALUES
('SAL-SR', 'P-DEVSR', 3000000.00),
('SAL-RH', 'P-RH', 5000000.00),
('SAL-CM', 'P-CM', 1000000.00),
('SAL-JR', 'P-DEVJR', 800000.00);

-- Données pour Table: employe (30 employés)
INSERT INTO employe (id_employe, nom, prenom, date_naissance, mail, adresse, contact, id_sexe, image_path) VALUES
('EMP001', 'Dupont', 'Alice', '1990-05-15', 'alice.dupont@test.com', '10 Rue de la Paix, 75001 Paris', '0612345678', 'S-F', '/img/profil1.jpg'),
('EMP002', 'Martin', 'Benoit', '1985-11-20', 'benoit.martin@test.com', '25 Avenue des Champs, 69002 Lyon', '0798765432', 'S-H', '/img/profil2.jpg'),
('EMP003', 'Lefevre', 'Carla', '1998-08-01', 'carla.lefevre@test.com', '5 Boulevard Voltaire, 31000 Toulouse', '0655443322', 'S-F', '/img/profil3.jpg'),
('EMP004', 'Bernard', 'David', '1992-03-12', 'david.bernard@test.com', '15 Rue Victor Hugo, 13001 Marseille', '0677889900', 'S-H', '/img/profil4.jpg'),
('EMP005', 'Moreau', 'Elodie', '1988-07-25', 'elodie.moreau@test.com', '8 Place Bellecour, 69002 Lyon', '0611223344', 'S-F', '/img/profil5.jpg'),
('EMP006', 'Petit', 'Franck', '1995-12-03', 'franck.petit@test.com', '22 Cours Gambetta, 33000 Bordeaux', '0788990011', 'S-H', '/img/profil6.jpg'),
('EMP007', 'Roux', 'Gabrielle', '1993-09-18', 'gabrielle.roux@test.com', '3 Rue de la République, 59000 Lille', '0622334455', 'S-F', '/img/profil7.jpg'),
('EMP008', 'Garcia', 'Hugo', '1987-04-30', 'hugo.garcia@test.com', '17 Avenue Jean Jaurès, 31000 Toulouse', '0733445566', 'S-H', '/img/profil8.jpg'),
('EMP009', 'Fournier', 'Isabelle', '1991-06-22', 'isabelle.fournier@test.com', '9 Rue du Faubourg, 67000 Strasbourg', '0644556677', 'S-F', '/img/profil9.jpg'),
('EMP010', 'Leroy', 'Julien', '1989-01-14', 'julien.leroy@test.com', '12 Place de la Bourse, 44000 Nantes', '0755667788', 'S-H', '/img/profil10.jpg'),
('EMP011', 'Martinez', 'Karine', '1994-11-08', 'karine.martinez@test.com', '6 Boulevard de Strasbourg, 34000 Montpellier', '0688990011', 'S-F', '/img/profil11.jpg'),
('EMP012', 'Dubois', 'Lucas', '1996-02-27', 'lucas.dubois@test.com', '14 Rue de la Gare, 35000 Rennes', '0722334455', 'S-H', '/img/profil12.jpg'),
('EMP013', 'Blanc', 'Marie', '1986-10-05', 'marie.blanc@test.com', '21 Avenue Foch, 06000 Nice', '0633445566', 'S-F', '/img/profil13.jpg'),
('EMP014', 'Thomas', 'Nicolas', '1997-07-19', 'nicolas.thomas@test.com', '7 Rue Nationale, 37000 Tours', '0744556677', 'S-H', '/img/profil14.jpg'),
('EMP015', 'Robert', 'Olivia', '1990-03-08', 'olivia.robert@test.com', '18 Place du Capitole, 31000 Toulouse', '0655667788', 'S-F', '/img/profil15.jpg'),
('EMP016', 'Richard', 'Pierre', '1984-12-15', 'pierre.richard@test.com', '4 Cours Franklin Roosevelt, 69006 Lyon', '0766778899', 'S-H', '/img/profil16.jpg'),
('EMP017', 'Durand', 'Quentin', '1993-05-21', 'quentin.durand@test.com', '11 Rue de la Pompe, 75116 Paris', '0677889900', 'S-H', '/img/profil17.jpg'),
('EMP018', 'Simon', 'Rachel', '1988-08-11', 'rachel.simon@test.com', '26 Boulevard Haussmann, 75009 Paris', '0722998877', 'S-F', '/img/profil18.jpg'),
('EMP019', 'Laurent', 'Sébastien', '1995-04-03', 'sebastien.laurent@test.com', '13 Rue de Rivoli, 75004 Paris', '0633778855', 'S-H', '/img/profil19.jpg'),
('EMP020', 'Michel', 'Tiffany', '1992-09-26', 'tiffany.michel@test.com', '19 Place des Terreaux, 69001 Lyon', '0744889966', 'S-F', '/img/profil20.jpg'),
('EMP021', 'Girard', 'Ulysse', '1987-11-14', 'ulysse.girard@test.com', '2 Rue Sainte-Catherine, 33000 Bordeaux', '0655998877', 'S-H', '/img/profil21.jpg'),
('EMP022', 'Bonnet', 'Valérie', '1996-01-07', 'valerie.bonnet@test.com', '16 Cours de la Libération, 38000 Grenoble', '0766889977', 'S-F', '/img/profil22.jpg'),
('EMP023', 'Fabre', 'William', '1989-06-29', 'william.fabre@test.com', '23 Avenue de la République, 75011 Paris', '0622887766', 'S-H', '/img/profil23.jpg'),
('EMP024', 'Fernandez', 'Xavier', '1994-02-17', 'xavier.fernandez@test.com', '8 Rue de la Soif, 35000 Rennes', '0733998866', 'S-H', '/img/profil24.jpg'),
('EMP025', 'Lopez', 'Yasmine', '1991-10-23', 'yasmine.lopez@test.com', '5 Place Garibaldi, 06000 Nice', '0644778855', 'S-F', '/img/profil25.jpg'),
('EMP026', 'Sanchez', 'Zoé', '1998-12-09', 'zoe.sanchez@test.com', '14 Rue Paradis, 13006 Marseille', '0755889966', 'S-F', '/img/profil26.jpg'),
('EMP027', 'Perrin', 'Antoine', '1985-07-04', 'antoine.perrin@test.com', '27 Cours Emile Zola, 69100 Villeurbanne', '0666998877', 'S-H', '/img/profil27.jpg'),
('EMP028', 'Rousseau', 'Béatrice', '1993-03-31', 'beatrice.rousseau@test.com', '9 Quai des Chartrons, 33000 Bordeaux', '0777889966', 'S-F', '/img/profil28.jpg'),
('EMP029', 'Vincent', 'Cédric', '1990-08-12', 'cedric.vincent@test.com', '11 Rue de la Barre, 59000 Lille', '0688997744', 'S-H', '/img/profil29.jpg'),
('EMP030', 'Muller', 'Delphine', '1986-04-25', 'delphine.muller@test.com', '6 Avenue des Belges, 06000 Nice', '0744778899', 'S-F', '/img/profil30.jpg');

-- Données pour Table: doc_employe (Tous les documents dans /docs/)
INSERT INTO doc_employe (id_doc_employe, id_employe, image_path) VALUES
('DOC001-CV', 'EMP001', '/docs/cv_emp001.pdf'),
('DOC001-ID', 'EMP001', '/docs/id_emp001.jpg'),
('DOC001-CONT', 'EMP001', '/docs/contrat_emp001.pdf'),
('DOC002-CV', 'EMP002', '/docs/cv_emp002.pdf'),
('DOC002-ID', 'EMP002', '/docs/id_emp002.jpg'),
('DOC003-CV', 'EMP003', '/docs/cv_emp003.pdf'),
('DOC004-CV', 'EMP004', '/docs/cv_emp004.pdf'),
('DOC004-DIP', 'EMP004', '/docs/diplome_emp004.pdf'),
('DOC005-CV', 'EMP005', '/docs/cv_emp005.pdf'),
('DOC005-ID', 'EMP005', '/docs/id_emp005.jpg'),
('DOC006-CV', 'EMP006', '/docs/cv_emp006.pdf'),
('DOC007-CV', 'EMP007', '/docs/cv_emp007.pdf'),
('DOC007-CONT', 'EMP007', '/docs/contrat_emp007.pdf'),
('DOC008-CV', 'EMP008', '/docs/cv_emp008.pdf'),
('DOC009-CV', 'EMP009', '/docs/cv_emp009.pdf'),
('DOC010-CV', 'EMP010', '/docs/cv_emp010.pdf'),
('DOC010-ID', 'EMP010', '/docs/id_emp010.jpg'),
('DOC011-CV', 'EMP011', '/docs/cv_emp011.pdf'),
('DOC012-CV', 'EMP012', '/docs/cv_emp012.pdf'),
('DOC013-CV', 'EMP013', '/docs/cv_emp013.pdf'),
('DOC014-CV', 'EMP014', '/docs/cv_emp014.pdf'),
('DOC015-CV', 'EMP015', '/docs/cv_emp015.pdf'),
('DOC016-CV', 'EMP016', '/docs/cv_emp016.pdf'),
('DOC017-CV', 'EMP017', '/docs/cv_emp017.pdf'),
('DOC018-CV', 'EMP018', '/docs/cv_emp018.pdf'),
('DOC019-CV', 'EMP019', '/docs/cv_emp019.pdf'),
('DOC020-CV', 'EMP020', '/docs/cv_emp020.pdf');

-- Données pour Table: contrat (Mélange CDI, CDD et Apprentissage avec dates de fin)
INSERT INTO contrat (id_contrat, id_employe, id_type_contrat, date_debut, date_fin, duree) VALUES
('CONTR001', 'EMP001', 'TCO-CDI', '2018-01-01', NULL, NULL),
('CONTR002', 'EMP002', 'TCO-CDD', '2023-03-01', '2024-02-29', 12),
('CONTR003', 'EMP003', 'TCO-CDI', '2024-06-01', NULL, NULL),
('CONTR004', 'EMP004', 'TCO-CDD', '2024-01-15', '2024-07-14', 6),
('CONTR005', 'EMP005', 'TCO-CDI', '2020-09-01', NULL, NULL),
('CONTR006', 'EMP006', 'TCO-APPR', '2024-09-01', '2025-02-28', 6),
('CONTR007', 'EMP007', 'TCO-CDI', '2019-03-15', NULL, NULL),
('CONTR008', 'EMP008', 'TCO-CDD', '2023-11-01', '2024-10-31', 12),
('CONTR009', 'EMP009', 'TCO-CDI', '2022-05-01', NULL, NULL),
('CONTR010', 'EMP010', 'TCO-APPR', '2024-10-01', '2025-03-31', 6),
('CONTR011', 'EMP011', 'TCO-CDI', '2021-07-01', NULL, NULL),
('CONTR012', 'EMP012', 'TCO-CDD', '2024-02-01', '2025-01-31', 12),
('CONTR013', 'EMP013', 'TCO-CDI', '2017-11-01', NULL, NULL),
('CONTR014', 'EMP014', 'TCO-CDD', '2023-12-01', '2024-11-30', 12),
('CONTR015', 'EMP015', 'TCO-CDI', '2023-08-01', NULL, NULL),
('CONTR016', 'EMP016', 'TCO-APPR', '2024-08-15', '2025-02-14', 6),
('CONTR017', 'EMP017', 'TCO-CDI', '2020-01-15', NULL, NULL),
('CONTR018', 'EMP018', 'TCO-CDD', '2024-03-01', '2025-02-28', 12),
('CONTR019', 'EMP019', 'TCO-CDI', '2021-12-01', NULL, NULL),
('CONTR020', 'EMP020', 'TCO-CDD', '2023-09-01', '2024-08-31', 12),
('CONTR021', 'EMP021', 'TCO-CDI', '2019-06-01', NULL, NULL),
('CONTR022', 'EMP022', 'TCO-APPR', '2024-07-01', '2024-12-31', 6),
('CONTR023', 'EMP023', 'TCO-CDI', '2022-02-01', NULL, NULL),
('CONTR024', 'EMP024', 'TCO-CDD', '2024-04-01', '2025-03-31', 12),
('CONTR025', 'EMP025', 'TCO-CDI', '2020-11-01', NULL, NULL),
('CONTR026', 'EMP026', 'TCO-APPR', '2024-05-15', '2024-11-14', 6),
('CONTR027', 'EMP027', 'TCO-CDI', '2018-08-01', NULL, NULL),
('CONTR028', 'EMP028', 'TCO-CDD', '2023-10-01', '2024-09-30', 12),
('CONTR029', 'EMP029', 'TCO-CDI', '2021-03-01', NULL, NULL),
('CONTR030', 'EMP030', 'TCO-CDD', '2024-01-01', '2024-12-31', 12);

-- Données pour Table: employe_poste (Avec changements de poste et dates de fin)
INSERT INTO employe_poste (id_employe_poste, id_employe, id_poste, date_debut, date_fin) VALUES
-- EMP001 a changé de poste 2 fois
('EP001-1', 'EMP001', 'P-DEVJR', '2018-01-01', '2020-12-31'),
('EP001-2', 'EMP001', 'P-DEVSR', '2021-01-01', NULL),

-- EMP002 a changé de poste
('EP002-1', 'EMP002', 'P-RH', '2023-03-01', '2024-02-29'),

-- EMP003 en poste actuel
('EP003-1', 'EMP003', 'P-DEVJR', '2024-06-01', NULL),

-- EMP004 a eu 2 postes différents
('EP004-1', 'EMP004', 'P-DEVJR', '2024-01-15', '2024-04-14'),
('EP004-2', 'EMP004', 'P-DEVSR', '2024-04-15', '2024-07-14'),

-- EMP005 en poste stable
('EP005-1', 'EMP005', 'P-CM', '2020-09-01', NULL),

-- EMP006 en apprentissage
('EP006-1', 'EMP006', 'P-DEVJR', '2024-09-01', '2025-02-28'),

-- EMP007 a évolué
('EP007-1', 'EMP007', 'P-RH', '2019-03-15', '2022-06-30'),
('EP007-2', 'EMP007', 'P-CM', '2022-07-01', NULL),

-- EMP008 en CDD
('EP008-1', 'EMP008', 'P-RH', '2023-11-01', '2024-10-31'),

-- EMP009 stable
('EP009-1', 'EMP009', 'P-DEVSR', '2022-05-01', NULL),

-- EMP010 apprenti
('EP010-1', 'EMP010', 'P-DEVJR', '2024-10-01', '2025-03-31'),

-- Continuer avec les autres employés...
('EP011-1', 'EMP011', 'P-CM', '2021-07-01', NULL),
('EP012-1', 'EMP012', 'P-RH', '2024-02-01', '2025-01-31'),
('EP013-1', 'EMP013', 'P-DEVSR', '2017-11-01', NULL),
('EP014-1', 'EMP014', 'P-DEVJR', '2023-12-01', '2024-11-30'),
('EP015-1', 'EMP015', 'P-CM', '2023-08-01', NULL),
('EP016-1', 'EMP016', 'P-DEVJR', '2024-08-15', '2025-02-14'),
('EP017-1', 'EMP017', 'P-DEVSR', '2020-01-15', NULL),
('EP018-1', 'EMP018', 'P-RH', '2024-03-01', '2025-02-28'),
('EP019-1', 'EMP019', 'P-CM', '2021-12-01', NULL),
('EP020-1', 'EMP020', 'P-DEVJR', '2023-09-01', '2024-08-31'),
('EP021-1', 'EMP021', 'P-DEVSR', '2019-06-01', NULL),
('EP022-1', 'EMP022', 'P-DEVJR', '2024-07-01', '2024-12-31'),
('EP023-1', 'EMP023', 'P-CM', '2022-02-01', NULL),
('EP024-1', 'EMP024', 'P-RH', '2024-04-01', '2025-03-31'),
('EP025-1', 'EMP025', 'P-DEVSR', '2020-11-01', NULL),
('EP026-1', 'EMP026', 'P-DEVJR', '2024-05-15', '2024-11-14'),
('EP027-1', 'EMP027', 'P-CM', '2018-08-01', NULL),
('EP028-1', 'EMP028', 'P-RH', '2023-10-01', '2024-09-30'),
('EP029-1', 'EMP029', 'P-DEVSR', '2021-03-01', NULL),
('EP030-1', 'EMP030', 'P-DEVJR', '2024-01-01', '2024-12-31');

-- Données pour Table: histo_mouvement (Sur plusieurs jours)
INSERT INTO histo_mouvement (id_hist_mouvement, id_employe, retard, heure_sup, pauses, absence, date) VALUES
('HM-20241112-1', 'EMP001', 5, 0, 60, 0, '2024-11-12'),
('HM-20241112-2', 'EMP002', 0, 2, 45, 0, '2024-11-12'),
('HM-20241112-3', 'EMP003', 0, 0, 60, 0, '2024-11-12'),
('HM-20241113-1', 'EMP001', 0, 1, 55, 0, '2024-11-13'),
('HM-20241113-2', 'EMP004', 10, 0, 50, 0, '2024-11-13'),
('HM-20241113-3', 'EMP005', 0, 3, 60, 0, '2024-11-13'),
('HM-20241114-1', 'EMP006', 0, 0, 45, 1, '2024-11-14'),
('HM-20241114-2', 'EMP007', 5, 2, 60, 0, '2024-11-14'),
('HM-20241114-3', 'EMP008', 0, 0, 40, 0, '2024-11-14');

-- Données pour Table: presence (Sur plusieurs jours)
INSERT INTO presence (id_presence, id_employe, mouvement, date) VALUES
('PRES-20241112-001', 'EMP001', 'Entrée', '2024-11-12 09:05:00'),
('PRES-20241112-002', 'EMP001', 'Sortie', '2024-11-12 18:05:00'),
('PRES-20241112-003', 'EMP002', 'Entrée', '2024-11-12 08:58:00'),
('PRES-20241112-004', 'EMP002', 'Sortie', '2024-11-12 18:30:00'),
('PRES-20241113-001', 'EMP001', 'Entrée', '2024-11-13 08:55:00'),
('PRES-20241113-002', 'EMP001', 'Sortie', '2024-11-13 18:10:00'),
('PRES-20241113-003', 'EMP004', 'Entrée', '2024-11-13 09:10:00'),
('PRES-20241113-004', 'EMP004', 'Sortie', '2024-11-13 17:55:00');

-- Données pour Table: conge (Plusieurs types de congés)
INSERT INTO conge (id_conge, id_employe, id_type_conge, date_debut, date_fin) VALUES
('CONG-001', 'EMP001', 'TCG-ANN', '2024-12-23', '2024-12-31'),
('CONG-002', 'EMP002', 'TCG-MAL', '2024-11-05', '2024-11-05'),
('CONG-003', 'EMP005', 'TCG-ANN', '2024-08-01', '2024-08-15'),
('CONG-004', 'EMP007', 'TCG-MAT', '2024-09-01', '2024-12-21'),
('CONG-005', 'EMP012', 'TCG-MAL', '2024-11-10', '2024-11-12'),
('CONG-006', 'EMP015', 'TCG-ANN', '2024-07-15', '2024-07-30');

-- Données pour Table: statut_conge
INSERT INTO statut_conge (id_statut_conge, id_conge, date_statut, id_statut) VALUES
('STCG-001-1', 'CONG-001', '2024-10-15', 'STAT-DEM'),
('STCG-001-2', 'CONG-001', '2024-10-18', 'STAT-APP'),
('STCG-002-1', 'CONG-002', '2024-11-05', 'STAT-UTIL'),
('STCG-003-1', 'CONG-003', '2024-06-20', 'STAT-DEM'),
('STCG-003-2', 'CONG-003', '2024-06-25', 'STAT-APP'),
('STCG-004-1', 'CONG-004', '2024-08-15', 'STAT-APP'),
('STCG-005-1', 'CONG-005', '2024-11-09', 'STAT-DEM'),
('STCG-006-1', 'CONG-006', '2024-06-01', 'STAT-APP');

-- Données pour Table: histo_salaire (Paie sur plusieurs mois)
INSERT INTO histo_salaire (id_histo_salaire, id_employe, mois, annee, montant_net) VALUES
('HSAL-001-1024', 'EMP001', 10, 2024, 4500.00),
('HSAL-002-1024', 'EMP002', 10, 2024, 3375.00),
('HSAL-003-1024', 'EMP003', 10, 2024, 2916.67),
('HSAL-004-1024', 'EMP004', 10, 2024, 2916.67),
('HSAL-005-1024', 'EMP005', 10, 2024, 4166.67),
('HSAL-006-1024', 'EMP006', 10, 2024, 1583.33),
('HSAL-007-1024', 'EMP007', 10, 2024, 4166.67),
('HSAL-008-1024', 'EMP008', 10, 2024, 2812.50),
('HSAL-009-1024', 'EMP009', 10, 2024, 4500.00),
('HSAL-010-1024', 'EMP010', 10, 2024, 1583.33);