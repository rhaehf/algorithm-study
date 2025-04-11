-- 별칭은 그냥 쓰기 또는 "" / 문자열은 ''
-- PM2.5 의 . 처럼 특수 문자를 포함한 경우 오류가 날 수 있음
SELECT YEAR(YM) YEAR, ROUND(AVG(PM_VAL1), 2) PM10, ROUND(AVG(PM_VAL2), 2) "PM2.5"
FROM AIR_POLLUTION
WHERE LOCATION2 = '수원' 
GROUP BY YEAR(YM)
ORDER BY YEAR
;