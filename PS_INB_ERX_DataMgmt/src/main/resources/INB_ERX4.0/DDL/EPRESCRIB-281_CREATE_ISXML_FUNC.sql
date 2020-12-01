CREATE OR REPLACE FUNCTION erx.isXML_FUNC(xml CLOB)
RETURN NUMBER
AS
    xmldata XMLTYPE;
BEGIN
    xmldata := XMLTYPE(xml);
    return 1;
EXCEPTION
    when others then
    return 0;
END;

/

CREATE OR REPLACE PUBLIC SYNONYM isXML_FUNC for erx.isXML_FUNC;

GRANT EXECUTE ON erx.isXML_FUNC to erx_update_role;


