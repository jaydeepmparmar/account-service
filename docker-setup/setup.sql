create TABLE IF NOT EXISTS accounts (
    accountId INT GENERATED ALWAYS AS IDENTITY,
    customerId VARCHAR(255) NOT NULL,
    country VARCHAR(255),
    balanceList jsonb,
    PRIMARY KEY(accountId)
);

create TABLE IF NOT EXISTS transactions (
    transactionId INT GENERATED ALWAYS AS IDENTITY,
    accountId INT,
    direction VARCHAR(5),
    amount INTEGER,
    currency VARCHAR(5),
    description VARCHAR(255) NOT NULL,
    PRIMARY KEY(transactionId),
    CONSTRAINT fk_account
        FOREIGN KEY(accountId)
    	    REFERENCES accounts(accountId)
);
