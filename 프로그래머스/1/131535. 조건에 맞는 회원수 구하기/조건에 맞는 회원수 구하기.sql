-- 코드를 입력하세요
SELECT count(*) as USERS
FROM USER_INFO
WHERE YEAR(JOINED) = 2021 AND AGE between 20 and 29;