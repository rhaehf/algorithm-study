-- 중복을 허용하지 않는 컬럼에 DISTINCT를 적용시켜서 COUNT로 개수 세기
SELECT COUNT(DISTINCT NAME) count
FROM ANIMAL_INS
;