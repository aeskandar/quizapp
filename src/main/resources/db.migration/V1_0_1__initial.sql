CREATE SEQUENCE IF NOT EXISTS question_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS quiz_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE question
(
    id             INTEGER NOT NULL,
    question_text  VARCHAR(255),
    correct_answer VARCHAR(255),
    category       VARCHAR(255),
    difficulty     VARCHAR(255),
    option1        VARCHAR(255),
    option2        VARCHAR(255),
    option3        VARCHAR(255),
    CONSTRAINT pk_question PRIMARY KEY (id)
);

CREATE TABLE quiz
(
    id    INTEGER NOT NULL,
    title VARCHAR(255),
    CONSTRAINT pk_quiz PRIMARY KEY (id)
);

CREATE TABLE quiz_questions
(
    quiz_id      INTEGER NOT NULL,
    questions_id INTEGER NOT NULL
);

ALTER TABLE quiz_questions
    ADD CONSTRAINT fk_quique_on_question_dao FOREIGN KEY (questions_id) REFERENCES question (id);

ALTER TABLE quiz_questions
    ADD CONSTRAINT fk_quique_on_quiz_dao FOREIGN KEY (quiz_id) REFERENCES quiz (id);