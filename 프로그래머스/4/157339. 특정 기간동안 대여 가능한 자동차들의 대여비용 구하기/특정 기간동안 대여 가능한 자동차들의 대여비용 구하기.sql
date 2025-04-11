SELECT C.CAR_ID, C.CAR_TYPE, ROUND(C.DAILY_FEE * 30 * (1 - (DISCOUNT_RATE / 100))) AS FEE
FROM (SELECT * 
      FROM CAR_RENTAL_COMPANY_CAR 
      WHERE CAR_TYPE IN ('세단', 'SUV')) C -- 자동차 종류가 세단과 SUV인 것만
        JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H ON C.CAR_ID = H.CAR_ID -- CAR_ID기준으로
        JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON C.CAR_TYPE = P.CAR_TYPE -- CAR_TYPE기준으로
WHERE C.CAR_ID NOT IN ( 
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-12-01'        
) AND P.DURATION_TYPE like '30%' -- 그리고 대여 기간이 30일 이상인 것을 검색해야하므로
GROUP BY C.CAR_ID -- 자동차 ID 기준으로 그룹화하여
-- select 절에 있는 집계함수 컬럼을 사용하기 위해 having 절에 작성함
HAVING FEE BETWEEN 500000 AND 2000000 -- 30일간의 대여 금액이 50만원 200만원 미만인 자동차 
ORDER BY FEE DESC, CAR_TYPE, CAR_ID DESC
;