SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE O.ANIMAL_ID IS NOT NULL
-- ORDER BY (O.DATETIME - I.DATETIME) DESC -- 이것도 정답이 됨
ORDER BY TIMESTAMPDIFF(SECOND, I.DATETIME, O.DATETIME) DESC
LIMIT 2
;

-- ORDER BY TIMEDIFF(O.DATETIME, I.DATETIME) DESC
-- TIMEDIFF(나중날짜, 먼저날짜) : 시간(HH:MM:SS) 형태로 차이를 반환
-- TIMEDIFF로 정렬한다면 문자열 기준으로 비교하기 때문에, 시간이 100시간이 넘어가면 정렬 오류가 생길 수도 있다. 
-- '99:00:00' > '100:00:00' (문자열 비교 기준)