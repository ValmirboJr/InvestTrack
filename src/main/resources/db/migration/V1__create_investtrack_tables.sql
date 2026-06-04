CREATE TABLE cliente (
    id CHAR(36) NOT NULL,
    nome VARCHAR(120) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    email VARCHAR(180) NOT NULL,
    data_cadastro DATETIME NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uk_cliente_cpf (cpf),
    UNIQUE KEY uk_cliente_email (email)
);

CREATE TABLE portfolio (
    id CHAR(36) NOT NULL,
    cliente_id CHAR(36) NOT NULL,
    nome VARCHAR(120) NOT NULL,
    descricao VARCHAR(255),
    criado_em DATETIME NOT NULL,
    atualizado_em DATETIME NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_portfolio_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);

CREATE TABLE operacao (
    id CHAR(36) NOT NULL,
    portfolio_id CHAR(36) NOT NULL,
    ticker VARCHAR(16) NOT NULL,
    tipo ENUM('COMPRA', 'VENDA') NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(19, 6) NOT NULL,
    data_operacao DATE NOT NULL,
    criado_em DATETIME NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_operacao_portfolio FOREIGN KEY (portfolio_id) REFERENCES portfolio (id)
);

CREATE TABLE posicao (
    id CHAR(36) NOT NULL,
    portfolio_id CHAR(36) NOT NULL,
    ticker VARCHAR(16) NOT NULL,
    quantidade INT NOT NULL,
    preco_medio DECIMAL(19, 6) NOT NULL,
    classe_ativo ENUM('ACAO', 'FII', 'BDR', 'ETF', 'RENDA_FIXA', 'CRIPTO') NOT NULL,
    atualizado_em DATETIME NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_posicao_portfolio FOREIGN KEY (portfolio_id) REFERENCES portfolio (id)
);

CREATE TABLE apuracao_ir (
    id CHAR(36) NOT NULL,
    portfolio_id CHAR(36) NOT NULL,
    competencia VARCHAR(7) NOT NULL,
    resultado_swing_trade DECIMAL(19, 6) NOT NULL,
    resultado_day_trade DECIMAL(19, 6) NOT NULL,
    ir_devido DECIMAL(19, 6) NOT NULL,
    status ENUM('ISENTO', 'DEVIDO') NOT NULL,
    criado_em DATETIME NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_apuracao_ir_portfolio FOREIGN KEY (portfolio_id) REFERENCES portfolio (id)
);
