
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
insert into accommodations (id, name, guests, cost, property_id) values ('ba3bb899-6e60-4d18-a2ed-11cca760578f', 'Suíte Luxo com Vista para o Mar', 4, 840.00, 'ba3bb899-6e60-4d18-a2ed-11cca760578f');
insert into accommodations (id, name, guests, cost, property_id) values ('c9c3b5a3-8e6f-4f1d-a63f-3fb35c3ff813', 'Suíte Presidencial', 2, 1500.00, 'c9c3b5a3-8e6f-4f1d-a63f-3fb35c3ff813');
insert into accommodations (id, name, guests, cost, property_id) values ('f14fda3a-ae5f-4645-9db8-6cfbce09c695', 'Suíte Executiva', 3, 1200.00, 'f14fda3a-ae5f-4645-9db8-6cfbce09c695');
insert into accommodations (id, name, guests, cost, property_id) values ('de8c0a3b-0cc8-4de4-a028-9da5a5690c64', 'Suíte Deluxe com Piscina Privativa', 2, 1300.00, 'de8c0a3b-0cc8-4de4-a028-9da5a5690c64');
insert into accommodations (id, name, guests, cost, property_id) values ('6d86e35f-2960-4eb3-8a87-5a19d75a03a8', 'Quarto Superior Vista Montanha', 2, 1100.00, '6d86e35f-2960-4eb3-8a87-5a19d75a03a8');
insert into accommodations (id, name, guests, cost, property_id) values ('b58699e0-9a57-4eb5-841a-6e4746dbaa19', 'Quarto Duplo Standard', 2, 950.00, 'b58699e0-9a57-4eb5-841a-6e4746dbaa19');
insert into accommodations (id, name, guests, cost, property_id) values ('76a6a08e-10f7-4874-8419-2246a84bb314', 'Quarto King com Varanda', 2, 1400.00, '76a6a08e-10f7-4874-8419-2246a84bb314');
insert into accommodations (id, name, guests, cost, property_id) values ('e62ff3ef-b7f8-44a6-b7a0-b046dcd2e331', 'Suíte Júnior com Vista para o Mar', 3, 1600.00, 'e62ff3ef-b7f8-44a6-b7a0-b046dcd2e331');
insert into accommodations (id, name, guests, cost, property_id) values ('1238328f-24ad-4e6a-b3ec-440c67a7a2f8', 'Quarto Standard Família', 2, 800.00, '1238328f-24ad-4e6a-b3ec-440c67a7a2f8');
insert into accommodations (id, name, guests, cost, property_id) values ('27f3de5d-41b2-4981-9138-df7c6d51d4b1', 'Suíte Premier com Hidromassagem', 2, 1350.00, '27f3de5d-41b2-4981-9138-df7c6d51d4b1');
