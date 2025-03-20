-- 별칭 적을때 따옴표를 안쓰거나 큰따옴표를 써야함 (작음따옴표는 문자열로 인식함)
SELECT MCDP_CD 진료과코드, COUNT(*) 5월예약건수
FROM APPOINTMENT
WHERE APNT_YMD LIKE '2022-05%'
GROUP BY MCDP_CD
ORDER BY 5월예약건수, 진료과코드
;