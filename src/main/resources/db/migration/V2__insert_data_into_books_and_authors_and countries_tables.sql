INSERT INTO countries (name, continent)
VALUES
    ('USA', 'North America'),
    ('United Kingdom', 'Europe'),
    ('Macedonia', 'Europe');

INSERT INTO authors (name, surname, country_id, created_at, updated_at)
VALUES
    ('Robert', 'Martin', (SELECT id FROM countries WHERE name = 'USA'), NOW(), NOW()),
    ('J.K.', 'Rowling', (SELECT id FROM countries WHERE name = 'United Kingdom'), NOW(), NOW()),
    ('Petre', 'Andreevski', (SELECT id FROM countries WHERE name = 'Macedonia'), NOW(), NOW());

INSERT INTO books (name, category, state, rented, author_id, created_at, updated_at)
VALUES
    ('Harry Potter 1', 'FANTASY', 'GOOD', FALSE,
     (SELECT id FROM authors WHERE surname = 'Rowling'), NOW(), NOW()),

    ('Clean Code', 'CLASSICS', 'GOOD', FALSE,
     (SELECT id FROM authors WHERE surname = 'Martin'), NOW(), NOW()),

    ('Pirej', 'NOVEL', 'GOOD', FALSE,
     (SELECT id FROM authors WHERE surname = 'Andreevski'), NOW(), NOW()),

    ('Spring in Action', 'CLASSICS', 'BAD', TRUE,
     (SELECT id FROM authors WHERE surname = 'Martin'), NOW(), NOW());