-- 코드를 입력하세요
SELECT F.FLAVOR
-- , TOTAL_ORDER + JULY_TOTAL_ORDER TOTAL
FROM FIRST_HALF F
    INNER JOIN (SELECT FLAVOR, sum(TOTAL_ORDER) AS JULY_TOTAL_ORDER
                FROM JULY
                GROUP BY FLAVOR) J
    ON F.FLAVOR = J.FLAVOR
ORDER BY TOTAL_ORDER + JULY_TOTAL_ORDER DESC
LIMIT 3
;