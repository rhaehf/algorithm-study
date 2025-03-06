-- 서브쿼리에는 alias를 무조건 작성해줘야 에러가 안난다.
SELECT ID, CASE
                WHEN RANK_COLONY <= 0.25 THEN 'CRITICAL'
                WHEN RANK_COLONY <= 0.5 THEN 'HIGH'
                WHEN RANK_COLONY <= 0.75 THEN 'MEDIUM'
                ELSE 'LOW'
            END COLONY_NAME
FROM (
      SELECT ID, PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) RANK_COLONY
      FROM ECOLI_DATA
     ) RNAK_TABLE
ORDER BY ID
;
