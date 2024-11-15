INSERT INTO address (location, street) VALUES
                                           (1, '123 Rue de Paris'),
                                           (2, '456 Avenue de Lyon'),
                                           (3, '789 Boulevard de Marseille');

INSERT INTO users (name, surname, username, email, age, rating, city, password, address_id) VALUES
                                                                                                ('Alice', 'M', 'alice0394', 'alice@example.com', 25, 4.5, 'Paris', 'password123', 1),
                                                                                                ('Bob', 'O', 'bob0939', 'bob@example.com', 30, 4.0, 'Lyon', 'password456', 2),
                                                                                                ('Charlie', 'D', 'charlie0E99', 'charlie@example.com', 28, 3.8, 'Marseille', 'password789', 3);

INSERT INTO interest (name) VALUES
                                ('Music'),
                                ('Sports'),
                                ('Cooking');

INSERT INTO users_interest (users_id, interests_id) VALUES
                                                        (1, 1),
                                                        (1, 2),
                                                        (2, 3),
                                                        (3, 1);

INSERT INTO party_type (name, description) VALUES
                                               ('Jeux de Société', 'Soirée où les participants jouent à des jeux de société classiques.'),
                                               ('Soirée Quiz', 'Soirée où des groupes saffrontent autour de questions de culture générale.');

INSERT INTO party (name, date_party, capacity, is_paid, price, party_type_id, organizer_id, address_id, is_published) VALUES
('Alice Birthday Bash', "2024-12-01", 50, true, 20.0, 1, 1, 1, false),
('Five', "2024-12-01", 50, true, 20.0, 1, 1, 1, true),
('Escape Game', "2024-12-01", 50, false, 20.0, 1, 1, 1, true),
('Rock Concert', "2024-12-15", 200, true, 50.0, 2, 2, 2, true);

INSERT INTO party_participants (party_id, participant_id) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO participation_request (status, users_id, party_id) VALUES
('Pending', 1, 2),
('Accepted', 2, 1);

INSERT INTO message (content, date_send, party_id, users_id) VALUES
('Excited for the party!', '2024-11-01', 1, 1),
('Can I bring a friend?', '2024-11-05', 2, 2);

INSERT INTO notification (message, is_read, users_id) VALUES
('Your participation request has been accepted.', false, 1),
('Reminder: The dinner is tomorrow!', false, 3);
