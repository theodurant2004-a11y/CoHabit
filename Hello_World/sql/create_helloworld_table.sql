CREATE TABLE HELLOWORLD (
                            id_HelloWorld NUMBER PRIMARY KEY,
                            text VARCHAR2(255) NOT NULL
);

CREATE SEQUENCE seq_helloworld START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_helloworld_id
BEFORE INSERT ON HELLOWORLD
FOR EACH ROW
BEGIN
    IF :NEW.id_HelloWorld IS NULL THEN
SELECT seq_helloworld.NEXTVAL INTO :NEW.id_HelloWorld FROM dual;
END IF;
END;
/

COMMIT;