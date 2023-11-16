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

-- Create function to get all tags
-- create OR REPLACE FUNCTION TEST_GET_TAG_BY_ID_FUNC(P_ID IN NUMBER)
--     return sys_refcursor AS cursor_out sys_refcursor;
-- BEGIN
-- OPEN cursor_out FOR
-- SELECT *
-- FROM TAG tag
-- WHERE tag.ID = P_ID;
-- RETURN cursor_out;
-- 
-- END;
-- End get all tags function

-- create FUNCTION TEST_GET_TAG_BY_ID_FUNC(P_ID IN NUMBER)
--     return sys_refcursor AS cursor_out sys_refcursor;
-- BEGIN
-- OPEN cursor_out FOR
-- SELECT *
-- FROM TAG tag
-- WHERE tag.ID = P_ID;
-- RETURN cursor_out;
-- 
-- END;
-- /

