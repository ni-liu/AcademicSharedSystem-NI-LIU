create PROCEDURE PRO_USER_ROLE_CASCADE (
    tmp_pk_id IN ASS_USER.PK_ID%TYPE ,
    tmp_pwd IN ASS_USER.PASSWORD%TYPE ,
    tmp_role IN ASS_USER.ROLE%TYPE ,
    tmp_nickname IN ASS_USER.NICKNAME%TYPE ,
    tmp_name IN ASS_STUDENT.NAME%TYPE ,
    tmp_major IN ASS_STUDENT.MAJOR_ID%TYPE
)
AS
begin 
    INSERT INTO ASS_USER(PK_ID,PASSWORD,ROLE,NICKNAME)
        VALUES(tmp_pk_id,tmp_pwd,tmp_role,tmp_nickname);
    INSERT INTO ASS_STUDENT(PK_ID,NAME,MAJOR_ID)
        VALUES(tmp_pk_id,tmp_name,tmp_major);
    COMMIT;
end PRO_USER_ROLE_CASCADE;
/

