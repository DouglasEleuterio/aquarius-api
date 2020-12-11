use aquarius;
-- drop database aquarius;
INSERT INTO
    aquarius.aluno
(cpf, data_nascimento, cuidado_especial, nome, tipo_cuidado, email)
VALUES
('035.557.591-40', '1990-09-24', 0, 'Douglas Eleutério Ferreira', 'N/A','douglas.versato@gmail.com');

INSERT INTO aquarius.estado (nome) VALUES ('Goiás'), ('Minas Gerais'), ('São Paulo');

INSERT INTO aquarius.cidade (nome, estado_id) VALUES ('Goiânia',1), ('Uberlândia', 2), ('Ribeirão Preto',3);

INSERT INTO aquarius.endereco
(logradouro, numero, complemento, bairro, cep, cidade_id, aluno_id)
values
('Rua Jose de Deus', '258', '', 'Centro','76958123',1,(SELECT (id) FROM aluno WHERE aluno.nome LIKE '%Douglas%'));

INSERT INTO telefone(aluno_id, telefones) VALUES (
     (SELECT(id) from aluno WHERE aluno.nome LIKE '%Douglas%'),'985606521');

INSERT INTO aquarius.pagamento
( data_vencimento, forma_pagamento, valor, pago, aluno_id)
VALUES
('2020-12-19', 'DINHEIRO', 135.00, 0,1), ('2021-01-05', 'BOLETO', 110.00, 1, (SELECT (id) FROM aluno WHERE aluno.nome LIKE 'Douglas%'));


INSERT INTO aquarius.atestado
(data_inicio, data_fim, aluno_id)
VALUES
('2020-05-27', '2020-08-27',(SELECT (id) FROM aluno WHERE aluno.nome LIKE 'Douglas%'));







INSERT INTO aquarius.modalidade (id, nome) VALUES (1, 'HIDROGINASTICA'), (2, 'NATAÇÃO INFANTIL');



INSERT INTO aquarius.professor(nome, data_nascimento, cpf) VALUES ('Douglas', '1992-12-16','999.999.99-88');
