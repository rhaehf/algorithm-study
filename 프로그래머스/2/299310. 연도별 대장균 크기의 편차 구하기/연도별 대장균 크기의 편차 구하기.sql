SELECT SIZE_YEAR AS YEAR, (MAX_SIZE - E.SIZE_OF_COLONY) AS YEAR_DEV, E.ID
FROM ECOLI_DATA AS E JOIN (
                            SELECT YEAR(DIFFERENTIATION_DATE) AS SIZE_YEAR, MAX(SIZE_OF_COLONY) AS MAX_SIZE
                            FROM ECOLI_DATA
                            GROUP BY YEAR(DIFFERENTIATION_DATE)
                          ) AS SIZE_DATA ON YEAR(E.DIFFERENTIATION_DATE) = SIZE_YEAR
ORDER BY 1, 2
;