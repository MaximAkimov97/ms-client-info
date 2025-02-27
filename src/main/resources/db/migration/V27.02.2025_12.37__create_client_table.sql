CREATE TABLE client_info (
    id BIGSERIAL PRIMARY KEY,           -- Уникальный идентификатор (автоинкрементный)
    first_name VARCHAR(255),           -- Имя
    last_name VARCHAR(255),            -- Фамилия
    phone VARCHAR(20)                  -- Номер телефона
);