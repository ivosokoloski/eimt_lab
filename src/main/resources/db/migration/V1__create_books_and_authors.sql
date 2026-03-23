CREATE TABLE countries (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    continent VARCHAR(255)
);

CREATE TABLE authors (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    country_id BIGINT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_author_country 
        FOREIGN KEY (country_id) 
        REFERENCES countries(id)
);

CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    rented BOOLEAN NOT NULL DEFAULT FALSE,
    author_id BIGINT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_book_author 
        FOREIGN KEY (author_id) 
        REFERENCES authors(id)
);