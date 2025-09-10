-- Insertion de données de test pour les utilisateurs business
INSERT INTO TRICLOPE_USER (id, first_name, last_name, email) VALUES 
('550e8400-e29b-41d4-a716-446655440001', 'Lucas', 'Bodet', 'lucas.bodet@example.com'),
('550e8400-e29b-41d4-a716-446655440002', 'Noe', 'Colbach', 'noe.colbach@example.com'),
('550e8400-e29b-41d4-a716-446655440003', 'John', 'Doe', 'john.doe@example.com'),
('550e8400-e29b-41d4-a716-446655440004', 'Jane', 'Smith', 'jane.smith@example.com');

-- Insertion de données de test pour l'authentification
-- Mot de passe pour tous les utilisateurs : "password"
-- Hash BCrypt généré avec BCryptPasswordEncoder pour "password"
INSERT INTO AUTH_USER (id, username, password, role, enabled, triclope_user_id) VALUES 
('650e8400-e29b-41d4-a716-446655440001', 'lucas', '$2a$10$CwTycUXWue0Thq9StjUM0uBUcAsqx4Hllls2FkEqRBUtzHyi.jjS6', 'ADMIN', true, '550e8400-e29b-41d4-a716-446655440001'),
('650e8400-e29b-41d4-a716-446655440002', 'noe', '$2a$10$CwTycUXWue0Thq9StjUM0uBUcAsqx4Hllls2FkEqRBUtzHyi.jjS6', 'USER', true, '550e8400-e29b-41d4-a716-446655440002'),
('650e8400-e29b-41d4-a716-446655440003', 'john', '$2a$10$CwTycUXWue0Thq9StjUM0uBUcAsqx4Hllls2FkEqRBUtzHyi.jjS6', 'USER', true, '550e8400-e29b-41d4-a716-446655440003'),
('650e8400-e29b-41d4-a716-446655440004', 'jane', '$2a$10$CwTycUXWue0Thq9StjUM0uBUcAsqx4Hllls2FkEqRBUtzHyi.jjS6', 'USER', true, '550e8400-e29b-41d4-a716-446655440004');

-- Insertion de données de test pour les triclopes
INSERT INTO TRI_CLOPE (id, name, creation_date, created_by) VALUES 
('550e8400-e29b-41d4-a716-446655440101', 'Triclope Test 1', '2025-01-01 10:00:00', '550e8400-e29b-41d4-a716-446655440001'),
('550e8400-e29b-41d4-a716-446655440102', 'Triclope Test 2', '2025-01-02 11:00:00', '550e8400-e29b-41d4-a716-446655440002');

-- Association des utilisateurs aux triclopes (table de jointure)
INSERT INTO triclope_members (triclope_id, user_id) VALUES 
('550e8400-e29b-41d4-a716-446655440101', '550e8400-e29b-41d4-a716-446655440001'),
('550e8400-e29b-41d4-a716-446655440101', '550e8400-e29b-41d4-a716-446655440002'),
('550e8400-e29b-41d4-a716-446655440101', '550e8400-e29b-41d4-a716-446655440003'),
('550e8400-e29b-41d4-a716-446655440102', '550e8400-e29b-41d4-a716-446655440002'),
('550e8400-e29b-41d4-a716-446655440102', '550e8400-e29b-41d4-a716-446655440004');