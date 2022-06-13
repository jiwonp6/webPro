-- ?Öå?ù¥Î∏?/?ãú???ä§ drop & create
-- CUSTOMER ?Öå?ù¥Î∏?
DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER(
    cID VARCHAR2(50) PRIMARY KEY,
    cPW VARCHAR2(50) NOT NULL,
    cNAME VARCHAR2(50) NOT NULL,
    cTEL VARCHAR2(50) NOT NULL,
    cEMAIL VARCHAR2(50),
    cADDRESS VARCHAR2(250),
    cGENDER VARCHAR2(10) NOT NULL,
    cBIRTH DATE NOT NULL,
    cRDATE DATE DEFAULT SYSDATE
);
-- BOOK ?Öå?ù¥Î∏? & ?ãú???ä§
DROP TABLE BOOK;
DROP SEQUENCE BOOK_SEQ;
CREATE SEQUENCE BOOK_SEQ
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
CREATE TABLE BOOK(
    bID NUMBER(5) PRIMARY KEY,  -- Ï±ÖÎ≤à?ò∏
    bTITLE VARCHAR2(100) NOT NULL,   -- Ï±ÖÏ†úÎ™?
    bPRICE NUMBER(7) NOT NULL,  -- Ï±ÖÍ?Í≤? 
    bIMAGE1 VARCHAR2(30),    -- Ï±? ???ëú ?ù¥ÎØ∏Ï?(Ï≤®Î??ïà?ï†Í≤ΩÏö∞ : noImg.png)
    bIMAGE2 VARCHAR2(30),    -- Ï±? Î∂?Í∞? ?ù¥ÎØ∏Ï?(Ï≤®Î??ïà?ï†Í≤ΩÏö∞ : NOTHING.JPG)
    bCONTENT VARCHAR2(4000),    -- Ï±? ?Ñ§Î™?(?ïúÍ∏? 1,333Í∏??ûê ?ù¥?Ç¥)
    bDISCOUNT NUMBER(3) NOT NULL,    -- ?ï†?ù∏?ú®(0~100% ?ù¥?Ç¥) Ïß??õê?ù¥?äî Î∞îÎ≥¥?ã§ Ïß??õê?ù¥?äî Î™ΩÏ¥ù?ù¥?ã§ ?ù¥Îß?.G1G1
    bRDATE DATE DEFAULT SYSDATE     -- Ï±? ?ì±Î°ùÏùº
);
select * from book;
select * from customer;
-- FILEBOARD ?Öå?ù¥Î∏? & ?ãú???ä§
DROP SEQUENCE FILEBOARD_SEQ;
CREATE SEQUENCE FILEBOARD_SEQ
    MAXVALUE 9999999
    NOCACHE
    NOCYCLE;
DROP TABLE FILEBOARD;
CREATE TABLE FILEBOARD(
    fNUM NUMBER(7) PRIMARY KEY, -- Í∏?Î≤àÌò∏
    cID VARCHAR2(50) REFERENCES CUSTOMER(cID),  -- ?ûë?Ñ±?ûê ID
    fSUBJECT VARCHAR2(250) NOT NULL,    -- Í∏? ?†úÎ™?
    fCONTENT VARCHAR2(4000),    -- Î≥∏Î¨∏
    fFILENAME VARCHAR2(50), -- Ï≤®Î??åå?ùºÎ™?
    fPW VARCHAR2(50) NOT NULL,  -- ÎπÑÎ≤à
    fHIT NUMBER(7) DEFAULT 0 NOT NULL,    -- Ï°∞Ìöå?àò
    fREF NUMBER(7) NOT NULL,    -- Í∏? Í∑∏Î£π
    fRE_STEP NUMBER(7) NOT NULL,    -- Í∑∏Î£π?Ç¥ Ï∂úÎ†•?àú?Ñú
    fRE_LEVEL NUMBER(7) NOT NULL,   -- ?ì§?ó¨?ì∞Í∏? ?†ï?èÑ
    fIP VARCHAR2(50) NOT NULL,  -- Í∏??ì¥ Ïª¥Ìì®?Ñ∞ IP
    fRDATE DATE DEFAULT SYSDATE NOT NULL-- Í∏? ?ì±Î°? ?ãú?†ê
);
COMMIT;