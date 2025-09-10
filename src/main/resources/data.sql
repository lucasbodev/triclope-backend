-- Insertion de données de test pour les utilisateurs
INSERT INTO TRICLOPE_USER (id, first_name, last_name) VALUES 
('550e8400-e29b-41d4-a716-446655440001', 'Lucas', 'Bodet'),
('550e8400-e29b-41d4-a716-446655440002', 'Noe', 'Colbach'),
('550e8400-e29b-41d4-a716-446655440003', 'John', 'Doe'),
('550e8400-e29b-41d4-a716-446655440004', 'Jane', 'Smith');

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