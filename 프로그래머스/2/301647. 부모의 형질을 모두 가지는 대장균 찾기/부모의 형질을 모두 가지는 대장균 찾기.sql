SELECT A.ID, A.GENOTYPE, B.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA AS A INNER JOIN ECOLI_DATA AS B ON A.PARENT_ID = B.ID
-- 부모의 형질에도 =(포함되어 있다.) A인 자식의 형질과 B인 부모의 형질에 &(같은 부분이 있는 것이)
WHERE B.GENOTYPE = A.GENOTYPE & B.GENOTYPE
ORDER BY A.ID
;