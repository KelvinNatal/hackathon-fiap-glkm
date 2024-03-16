
-- Database seeding for PROPERTIES
insert into properties (id, name, address, city, district, state, country) values ('ba3bb899-6e60-4d18-a2ed-11cca760578f', 'Ipanema Beach', 'Rua da Praia, 123', 'Rio de Janeiro', 'Copacabana', 'RJ', 'Brasil');
insert into properties (id, name, address, city, district, state, country) values ('c9c3b5a3-8e6f-4f1d-a63f-3fb35c3ff813', 'Copacabana Palace', 'Avenida Central, 456', 'Rio de Janeiro', 'Centro', 'RJ', 'Brasil');
insert into properties (id, name, address, city, district, state, country) values ('f14fda3a-ae5f-4645-9db8-6cfbce09c695', 'Marriott Marquis', 'Rua das Montanhas, 789', 'São Paulo', 'Serra', 'SP', 'Brasil');
insert into properties (id, name, address, city, district, state, country) values ('de8c0a3b-0cc8-4de4-a028-9da5a5690c64', 'Sheraton Rio Hotel & Resort', 'Avenida Luxo, 1010', 'Rio de Janeiro', 'Barra da Tijuca', 'RJ', 'Brasil');
insert into properties (id, name, address, city, district, state, country) values ('6d86e35f-2960-4eb3-8a87-5a19d75a03a8', 'Hilton Barra Rio de Janeiro', 'Estrada da Roça, 222', 'Campinas', 'Zona Rural', 'SP', 'Brasil');
insert into properties (id, name, address, city, district, state, country) values ('b58699e0-9a57-4eb5-841a-6e4746dbaa19', 'Windsor Marapendi', 'Avenida Beira-Mar, 1234', 'Fortaleza', 'Praia de Iracema', 'CE', 'Brasil');
insert into properties (id, name, address, city, district, state, country) values ('76a6a08e-10f7-4874-8419-2246a84bb314', 'Grand Hyatt Rio de Janeiro', 'Rua dos Nobres, 567', 'Salvador', 'Barra', 'BA', 'Brasil');
insert into properties (id, name, address, city, district, state, country) values ('e62ff3ef-b7f8-44a6-b7a0-b046dcd2e331', 'Fairmont Copacabana', 'Estrada das Flores, 789', 'Curitiba', 'Zona Rural', 'PR', 'Brasil');
insert into properties (id, name, address, city, district, state, country) values ('1238328f-24ad-4e6a-b3ec-440c67a7a2f8', 'Novotel Rio de Janeiro Parque Olímpico', 'Rua das Ruínas, 101', 'Porto Alegre', 'Centro Histórico', 'RS', 'Brasil');
insert into properties (id, name, address, city, district, state, country) values ('27f3de5d-41b2-4981-9138-df7c6d51d4b1', 'Royal Tulip Rio de Janeiro', 'Rua das Tulipas, 456', 'Rio de Janeiro', 'Ipanema', 'RJ', 'Brasil');

-- Database seeding for ACCOMMODATIONS
insert into accommodations (id, name, guests, cost, property_id) values ('1e77837e-70e0-46bb-b7ee-f1daec8e01f8', 'Suíte Luxo com Vista para o Mar', 4, 840.00, 'ba3bb899-6e60-4d18-a2ed-11cca760578f');
insert into accommodations (id, name, guests, cost, property_id) values ('dc9f7021-372e-432a-a6ba-688e5c0656a5', 'Suíte Presidencial', 2, 1500.00, 'c9c3b5a3-8e6f-4f1d-a63f-3fb35c3ff813');
insert into accommodations (id, name, guests, cost, property_id) values ('b80ebf23-a593-429c-95a5-b894ae72f260', 'Suíte Executiva', 3, 1200.00, 'f14fda3a-ae5f-4645-9db8-6cfbce09c695');
insert into accommodations (id, name, guests, cost, property_id) values ('82792006-a87a-4908-a117-d7cb9c5f1a69', 'Suíte Deluxe com Piscina Privativa', 2, 1300.00, 'de8c0a3b-0cc8-4de4-a028-9da5a5690c64');
insert into accommodations (id, name, guests, cost, property_id) values ('de9284d3-2894-4404-b44c-58438e497010', 'Quarto Superior Vista Montanha', 2, 1100.00, '6d86e35f-2960-4eb3-8a87-5a19d75a03a8');
insert into accommodations (id, name, guests, cost, property_id) values ('1bda7a82-c519-4e3f-9e69-7767d1e26fd9', 'Quarto Duplo Standard', 2, 950.00, 'b58699e0-9a57-4eb5-841a-6e4746dbaa19');
insert into accommodations (id, name, guests, cost, property_id) values ('98a2eba2-c462-41d5-be4d-b39fac5e8063', 'Quarto King com Varanda', 2, 1400.00, '76a6a08e-10f7-4874-8419-2246a84bb314');
insert into accommodations (id, name, guests, cost, property_id) values ('11dbe50b-8884-401e-a21f-38a506d7dcba', 'Suíte Júnior com Vista para o Mar', 3, 1600.00, 'e62ff3ef-b7f8-44a6-b7a0-b046dcd2e331');
insert into accommodations (id, name, guests, cost, property_id) values ('7c6f1955-4503-4679-9606-cf3b4a84ecb0', 'Quarto Standard Família', 2, 800.00, '1238328f-24ad-4e6a-b3ec-440c67a7a2f8');
insert into accommodations (id, name, guests, cost, property_id) values ('6e4863c4-6bec-4ae9-9839-6930daf042f4', 'Suíte Premier com Hidromassagem', 2, 1350.00, '27f3de5d-41b2-4981-9138-df7c6d51d4b1');

-- Clients
insert into clients (id, cpf, passport, origin_country, name, birth_date, address, telephone, email) values ('d0c8b50f-50a6-4d17-81e8-f68a5d77715c', '630.945.880-93', NULL, 'Brasil', 'João Silva', '1990-05-15', 'Rua A, 123', '11987654321', 'joao@example.com');
insert into clients (id, cpf, passport, origin_country, name, birth_date, address, telephone, email) values ('7bbff14e-8d2e-4a76-8d89-82aee9970c10', '98765432100', NULL, 'Brasil', 'Maria Souza', '1985-10-20', 'Avenida B, 456', '11912345678', 'maria@example.com');
insert into clients (id, cpf, passport, origin_country, name, birth_date, address, telephone, email) values ('9f3a02c1-cbc5-4e13-a7d0-4e9a7839d1cd', '11122233300', NULL, 'Brasil', 'Pedro Santos', '1978-07-03', 'Rua C, 789', '11954321987', 'pedro@example.com');
insert into clients (id, cpf, passport, origin_country, name, birth_date, address, telephone, email) values ('6d7950bc-038f-4d3f-ae1a-2e31ef7a8a14', '44455566600', NULL, 'Brasil', 'Ana Oliveira', '1995-12-12', 'Avenida D, 321', '11967890123', 'ana@example.com');
insert into clients (id, cpf, passport, origin_country, name, birth_date, address, telephone, email) values ('ac6480bf-6015-402f-8206-13f6f7b44aef', '77788899900', NULL, 'Brasil', 'Luiz Costa', '1980-03-25', 'Rua E, 567', '11913579246', 'luiz@example.com');
insert into clients (id, cpf, passport, origin_country, name, birth_date, address, telephone, email) values ('eae46060-73f8-4e02-8599-0c9cc8b1b9d1', '00011122233', NULL, 'Brasil', 'Carla Lima', '1972-08-18', 'Avenida F, 987', '11924680135', 'carla@example.com');
insert into clients (id, cpf, passport, origin_country, name, birth_date, address, telephone, email) values ('54a36705-1176-4264-9c88-72b6014bb0cf', '99988877700', NULL, 'Brasil', 'Mariana Rodrigues', '1987-04-30', 'Rua G, 753', '11911112222', 'mariana@example.com');
insert into clients (id, cpf, passport, origin_country, name, birth_date, address, telephone, email) values ('fb6d352b-35d7-45e3-a45f-6b5a0c72ff85', '22233344400', NULL, 'Brasil', 'Fernando Almeida', '1993-09-08', 'Avenida H, 159', '11933334444', 'fernando@example.com');
insert into clients (id, cpf, passport, origin_country, name, birth_date, address, telephone, email) values ('9e2a4bb4-2a35-4b82-8e33-4f1c20774852', '33344455500', NULL, 'Brasil', 'Camila Pereira', '1983-11-22', 'Rua I, 369', '11955556666', 'camila@example.com');
insert into clients (id, cpf, passport, origin_country, name, birth_date, address, telephone, email) values ('3bc41d7c-47fc-4e5f-8e84-fb2c86264870', '55566677700', NULL, 'Brasil', 'Ricardo Oliveira', '1975-06-05', 'Avenida J, 753', '11977778888', 'ricardo@example.com');

-- Extra Services
insert into extra_services (id, name, cost) values ('3eeb8b80-93af-4d11-819d-95f122da0b00', 'Limpeza diária', 50.00);
insert into extra_services (id, name, cost) values ('8bb6df90-fd5c-4fb3-90f2-7a013e1fbc58', 'Café da manhã', 20.00);
insert into extra_services (id, name, cost) values ('ef8d1d21-7d0b-438f-b9c7-cf1a7f9b5e8b', 'Serviço de lavanderia', 30.00);
insert into extra_services (id, name, cost) values ('7c2deed6-b86c-4ae4-b335-895c166c1e8f', 'Estacionamento', 15.00);
insert into extra_services (id, name, cost) values ('86e02c7b-f2d1-4642-bec0-08f42b2d9dd1', 'Wi-Fi', 10.00);
insert into extra_services (id, name, cost) values ('53b72a92-b2ff-4762-bf5d-8496304f24a4', 'TV a cabo', 20.00);
insert into extra_services (id, name, cost) values ('c356d0a7-0a9a-44a2-b19a-2a41b47d2fa5', 'Serviço de quarto', 40.00);
insert into extra_services (id, name, cost) values ('12a4a585-bf34-4850-8649-6e3a10778185', 'Acesso à piscina', 25.00);
insert into extra_services (id, name, cost) values ('b22d5b54-f13c-4f5d-80d6-7c8f5ff1a7e9', 'Academia', 30.00);
insert into extra_services (id, name, cost) values ('e6961ef5-4d5e-4b10-b26c-c16a6d67dca8', 'Spa', 50.00);

-- Additionals
insert into additionals (id, name, cost) values ('3eeb8b80-93af-4d11-819d-95f122da0b00', 'Toalhas extras', 5.00);
insert into additionals (id, name, cost) values ('8bb6df90-fd5c-4fb3-90f2-7a013e1fbc58', 'Roupão de banho', 10.00);
insert into additionals (id, name, cost) values ('ef8d1d21-7d0b-438f-b9c7-cf1a7f9b5e8b', 'Cama extra', 20.00);
insert into additionals (id, name, cost) values ('7c2deed6-b86c-4ae4-b335-895c166c1e8f', 'Berço', 15.00);
insert into additionals (id, name, cost) values ('86e02c7b-f2d1-4642-bec0-08f42b2d9dd1', 'Serviço de babá', 30.00);
insert into additionals (id, name, cost) values ('53b72a92-b2ff-4762-bf5d-8496304f24a4', 'Serviço de despertar', 5.00);
insert into additionals (id, name, cost) values ('c356d0a7-0a9a-44a2-b19a-2a41b47d2fa5', 'Kit de higiene', 8.00);
insert into additionals (id, name, cost) values ('12a4a585-bf34-4850-8649-6e3a10778185', 'Cafeteira', 12.00);
insert into additionals (id, name, cost) values ('b22d5b54-f13c-4f5d-80d6-7c8f5ff1a7e9', 'Secador de cabelo', 7.00);
insert into additionals (id, name, cost) values ('e6961ef5-4d5e-4b10-b26c-c16a6d67dca8', 'Ferro de passar', 8.00);
