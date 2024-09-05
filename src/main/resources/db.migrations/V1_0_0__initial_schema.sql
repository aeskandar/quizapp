CREATE TABLE question (
    id              serial PRIMARY KEY,
    category        varchar(20),
    difficulty      varchar(10),
    option1         varchar(120),
    option2         varchar(120),
    option3         varchar(120),
    question_text   varchar(150),
    correct_answer  varchar(120)
);

--TODO: integerate flyway to manage database migrations