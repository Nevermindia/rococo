-- Создание таблицы пользователей
CREATE TABLE IF NOT EXISTS `user` (
    id        BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    username  VARCHAR(50) UNIQUE NOT NULL,
    firstname VARCHAR(255),
    lastname  VARCHAR(255),
    avatar    LONGBLOB,
    INDEX (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Создание таблицы стран
CREATE TABLE IF NOT EXISTS `country` (
    id   BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    name VARCHAR(255) UNIQUE NOT NULL,
    INDEX (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Создание таблицы музеев
CREATE TABLE IF NOT EXISTS `museum` (
    id          BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    city        VARCHAR(255),
    photo       LONGBLOB,
    country_id  BINARY(16) NOT NULL,
    UNIQUE KEY (title, country_id),
    CONSTRAINT fk_museum_country FOREIGN KEY (country_id)
        REFERENCES `country` (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    INDEX (title),
    INDEX (country_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Создание таблицы художников
CREATE TABLE IF NOT EXISTS `artist` (
    id        BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    name      VARCHAR(255) UNIQUE NOT NULL,
    biography TEXT NOT NULL,
    photo     LONGBLOB,
    INDEX (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Создание таблицы картин
CREATE TABLE IF NOT EXISTS `painting` (
    id          BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    artist_id   BINARY(16) NOT NULL,
    museum_id   BINARY(16),
    content     LONGBLOB,
    CONSTRAINT fk_painting_artist FOREIGN KEY (artist_id)
        REFERENCES `artist` (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_painting_museum FOREIGN KEY (museum_id)
        REFERENCES `museum` (id) ON DELETE SET NULL ON UPDATE CASCADE,
    INDEX (title),
    INDEX (artist_id),
    INDEX (museum_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Очистка данных (если нужно)
TRUNCATE TABLE `painting`;
TRUNCATE TABLE `artist`;
TRUNCATE TABLE `museum`;
TRUNCATE TABLE `country`;
TRUNCATE TABLE `user`;

-- Вставка всех стран мира
INSERT INTO `country` (name) VALUES
('Австралия'), ('Австрия'), ('Азербайджан'), ('Албания'), ('Алжир'),
('Ангола'), ('Андорра'), ('Антигуа и Барбуда'), ('Аргентина'), ('Армения'),
('Афганистан'), ('Багамские Острова'), ('Бангладеш'), ('Барбадос'), ('Бахрейн'),
('Белиз'), ('Белоруссия'), ('Бельгия'), ('Бенин'), ('Болгария'),
('Боливия'), ('Босния и Герцеговина'), ('Ботсвана'), ('Бразилия'), ('Бруней'),
('Буркина-Фасо'), ('Бурунди'), ('Бутан'), ('Вануату'), ('Великобритания'),
('Венгрия'), ('Венесуэла'), ('Восточный Тимор'), ('Вьетнам'), ('Габон'),
('Республика Гаити'), ('Гайана'), ('Гамбия'), ('Гана'), ('Гватемала'),
('Гвинея'), ('Гвинея-Бисау'), ('Германия'), ('Гондурас'), ('Гренада'),
('Греция'), ('Грузия'), ('Дания'), ('Джибути'), ('Доминика'),
('Доминиканская Республика'), ('Египет'), ('Замбия'), ('Зимбабве'), ('Израиль'),
('Индия'), ('Индонезия'), ('Иордания'), ('Ирак'), ('Иран'),
('Ирландия'), ('Исландия'), ('Испания'), ('Италия'), ('Йемен'),
('Кабо-Верде'), ('Казахстан'), ('Камбоджа'), ('Камерун'), ('Канада'),
('Катар'), ('Кения'), ('Республика Кипр'), ('Киргизия'), ('Кирибати'),
('Китай'), ('Колумбия'), ('Коморы'), ('Республика Конго'), ('Демократическая Республика Конго'),
('Корейская Народно-Демократическая Республика'), ('Республика Корея'), ('Коста-Рика'), ('Кот-д’Ивуар'), ('Куба'),
('Кувейт'), ('Лаос'), ('Латвия'), ('Лесото'), ('Либерия'),
('Ливан'), ('Ливия'), ('Литва'), ('Лихтенштейн'), ('Люксембург'),
('Маврикий'), ('Мавритания'), ('Мадагаскар'), ('Малави'), ('Малайзия'),
('Мали'), ('Мальдивы'), ('Мальта'), ('Марокко'), ('Маршалловы Острова'),
('Мексика'), ('Федеративные Штаты Микронезии'), ('Мозамбик'), ('Молдавия'), ('Монако'),
('Монголия'), ('Мьянма'), ('Намибия'), ('Науру'), ('Непал'),
('Нигер'), ('Нигерия'), ('Нидерланды'), ('Никарагуа'), ('Новая Зеландия'),
('Норвегия'), ('Объединённые Арабские Эмираты'), ('Оман'), ('Пакистан'), ('Палау'),
('Панама'), ('Папуа — Новая Гвинея'), ('Парагвай'), ('Перу'), ('Польша'),
('Португалия'), ('Россия'), ('Руанда'), ('Румыния'), ('Сальвадор'),
('Самоа'), ('Сан-Марино'), ('Сан-Томе и Принсипи'), ('Саудовская Аравия'), ('Северная Македония'),
('Сейшельские Острова'), ('Сенегал'), ('Сент-Винсент и Гренадины'), ('Сент-Китс и Невис'), ('Сент-Люсия'),
('Сербия'), ('Сингапур'), ('Сирия'), ('Словакия'), ('Словения'),
('Соединённые Штаты Америки'), ('Соломоновы Острова'), ('Сомали'), ('Судан'), ('Суринам'),
('Сьерра-Леоне'), ('Таджикистан'), ('Таиланд'), ('Танзания'), ('Того'),
('Тонга'), ('Тринидад и Тобаго'), ('Тувалу'), ('Тунис'), ('Туркменистан'),
('Турция'), ('Уганда'), ('Узбекистан'), ('Украина'), ('Уругвай'),
('Фиджи'), ('Филиппины'), ('Финляндия'), ('Франция'), ('Хорватия'),
('Центральноафриканская Республика'), ('Чад'), ('Черногория'), ('Чехия'), ('Чили'),
('Швейцария'), ('Швеция'), ('Шри-Ланка'), ('Эквадор'), ('Экваториальная Гвинея'),
('Эритрея'), ('Эсватини'), ('Эстония'), ('Эфиопия'), ('Южно-Африканская Республика'),
('Южный Судан'), ('Ямайка'), ('Япония'), ('Ватикан'), ('Палестина');