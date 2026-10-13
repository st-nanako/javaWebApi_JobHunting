-- 応募種別
CREATE TABLE application_type (
    type_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- 選考状況
CREATE TABLE selection_status (
    status_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- ビジネスモデル
CREATE TABLE business_type (
   business_id SERIAL PRIMARY KEY,
   name VARCHAR(100) NOT NULL
);

--職種
CREATE TABLE positions_available (
    position_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- 企業
CREATE TABLE companies (
   company_id SERIAL PRIMARY KEY,
   name VARCHAR(100) NOT NULL,
   business_id INTEGER NOT NULL,
   position_id INTEGER NOT NULL,
   company_url VARCHAR(255),
   memo VARCHAR(255),
   FOREIGN KEY (business_id) REFERENCES business_type(business_id) ON DELETE CASCADE,
   FOREIGN KEY (position_id) REFERENCES positions_available(position_id) ON DELETE CASCADE
);

-- 応募
CREATE TABLE applications (
    application_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    company_id INTEGER NOT NULL,
    application_date DATE,
    type_id INTEGER NOT NULL,
    status_id INTEGER NOT NULL,
    schedule_start_date DATE,
    schedule_end_date DATE,
    memo VARCHAR(255),
    FOREIGN KEY (company_id) REFERENCES companies(company_id) ON DELETE CASCADE,
    FOREIGN KEY (type_id) REFERENCES application_type(type_id) ON DELETE CASCADE,
    FOREIGN KEY (status_id) REFERENCES selection_status(status_id) ON DELETE CASCADE
);
