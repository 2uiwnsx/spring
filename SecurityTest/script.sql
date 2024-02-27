CREATE TABLE tblMember (
    id VARCHAR2(50) PRIMARY KEY,
    pswd VARCHAR2(100) NOT NULL,
    name VARCHAR2(100) NOT NULL,
    regdate DATE DEFAULT SYSDATE NOT NULL,
    enabled CHAR(1) DEFAULT '1'
);

SELECT * FROM tblMember;

DROP TABLE tblMember;

CREATE TABLE tblAuth (
    id VARCHAR2(50) NOT NULL REFERENCES tblMember(id),
    auth VARCHAR2(50) NOT NULL
);

SELECT * FROM tblAuth;

DROP TABLE tblAuth;

COMMIT;
