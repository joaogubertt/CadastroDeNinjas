-- V3: Migrations para remover coluna nome_missoes que foi adicionada erroneamente

ALTER TABLE TB_MISSOES
DROP COLUMN NOME_MISSOES;