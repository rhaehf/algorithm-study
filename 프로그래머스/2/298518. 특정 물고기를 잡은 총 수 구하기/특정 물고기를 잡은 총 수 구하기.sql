SELECT COUNT(*) FISH_COUNT
FROM FISH_INFO I JOIN FISH_NAME_INFO N USING (FISH_TYPE)
WHERE FISH_NAME IN ('BASS', 'SNAPPER')
-- WHERE FISH_TYPE IN (0, 1); 이 안되는 이유 : 
-- 문제에서 제공된 예제일 뿐, 일반적인 문제 조건에서는 FISH_NAME_INFO 테이블에서 이 값을 확인해야 함.
-- 하드코딩된 FISH_TYPE 값(0, 1)만 사용할 경우 유연성이 부족함.
;