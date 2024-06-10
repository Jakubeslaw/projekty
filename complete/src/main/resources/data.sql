CREATE TABLE IF NOT EXISTS currencyrate (
                                             id INT AUTO_INCREMENT PRIMARY KEY,
                                             currencyfrom VARCHAR(10) NOT NULL,
    currencyto VARCHAR(10) NOT NULL,
    rate DECIMAL(10, 4) NOT NULL
    );

INSERT INTO currencyrate (currencyfrom, currencyto, rate) VALUES ('USD', 'USD', 1.0);
INSERT INTO currencyrate (currencyfrom, currencyto, rate) VALUES ('USD', 'EUR', 0.85);
INSERT INTO currencyrate (currencyfrom, currencyto, rate) VALUES ('USD', 'GBP', 0.75);

COMMIT;