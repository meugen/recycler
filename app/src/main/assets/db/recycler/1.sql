CREATE TABLE mccmnc (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  type VARCHAR(20) NOT NULL,
  country_name VARCHAR(100) NOT NULL,
  country_code VARCHAR(10) NOT NULL,
  mcc VARCHAR(5) NOT NULL,
  mnc VARCHAR(5) NOT NULL,
  brand VARCHAR(50) NOT NULL,
  operator VARCHAR(50) NOT NULL,
  status VARCHAR(20) NOT NULL,
  bands VARCHAR(100) NOT NULL,
  notes VARCHAR(100) NOT NULL);

CREATE INDEX mccmnc_country_name_idx ON mccmnc (country_name);
CREATE INDEX mccmnc_country_code_idx ON mccmnc (country_code);
CREATE INDEX mccmnc_operator_idx ON mccmnc (operator);
CREATE INDEX mccmnc_brand_idx ON mccmnc (brand);