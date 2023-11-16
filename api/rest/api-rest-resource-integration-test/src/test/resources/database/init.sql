BEGIN
CREATE TABLE tag
(
    id         NUMBER,
    uuid       VARCHAR2(255),
    name       VARCHAR2(255),
    is_Deleted char(1) DEFAULT '1',
    created_At TIMESTAMP,
    updated_At TIMESTAMP
);

CREATE SEQUENCE tag_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE id_Sequence START WITH 1 INCREMENT BY 1;
END;
/

create or replace PROCEDURE TEST_GET_TAG_BY_ID_PROC (
    tagId IN NUMBER,
    tags OUT SYS_REFCURSOR )
AS
BEGIN
OPEN tags FOR
SELECT *
FROM TAG
WHERE id = tagId;
END;
/

create or replace FUNCTION TEST_GET_TAG_BY_ID_FUNC(tagId IN NUMBER) RETURN SYS_REFCURSOR IS
    result_cursor SYS_REFCURSOR;
BEGIN
OPEN result_cursor FOR
SELECT * FROM TAG WHERE ID = tagId;

RETURN result_cursor;
END TEST_GET_TAG_BY_ID_FUNC;
/
