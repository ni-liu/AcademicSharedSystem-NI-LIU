create PROCEDURE PRO_USER_ROLE_CASCADE_ADMIN(
	tmp_pk_id IN ASS_USER.PK_ID%TYPE ,
    tmp_pwd IN ASS_USER.PASSWORD%TYPE ,
    tmp_role IN ASS_USER.ROLE%TYPE ,
    tmp_nickname IN ASS_USER.NICKNAME%TYPE ,
    tmp_name IN ASS_STUDENT.NAME%TYPE 
)
AS
BEGIN
	IF tmp_role = 1 THEN	--teacher
		INSERT INTO ASS_USER(PK_ID,PASSWORD,ROLE,NICKNAME)
			VALUES(tmp_pk_id,tmp_pwd,tmp_role,tmp_nickname);
		INSERT INTO ASS_TEACHER(PK_ID,NAME)
			VALUES(tmp_pk_id,tmp_name);
	ELSE 
		INSERT INTO ASS_USER(PK_ID,PASSWORD,ROLE,NICKNAME)
			VALUES(tmp_pk_id,tmp_pwd,tmp_role,tmp_nickname);
		INSERT INTO ASS_ADMIN(PK_ID,NAME)
			VALUES(tmp_pk_id,tmp_name);
	END IF;
	COMMIT;
END PRO_USER_ROLE_CASCADE_ADMIN;
/

