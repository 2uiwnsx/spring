CREATE TABLE tblCode (
    seq NUMBER PRIMARY KEY,
    subject VARCHAR2(1000) NOT NULL,
    code VARCHAR2(2000) NOT NULL,
    language VARCHAR2(100) NOT NULL,
    regdate DATE DEFAULT SYSDATE NOT NULL
);

CREATE SEQUENCE codeSeq;

SELECT * FROM tblCode;

DROP SEQUENCE codeSeq;

DROP TABLE tblCode;

COMMIT;
