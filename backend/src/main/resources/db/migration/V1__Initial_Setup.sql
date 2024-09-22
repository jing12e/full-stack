CREATE TABLE customer(
                         id Serial PRIMARY KEY,
                         name Text NOT NULL ,
                         email Text NOT NULL ,
                         age INT NOT NULL
);

ALTER TABLE customer
    ADD CONSTRAINT customer_email_unique UNIQUE (email);
