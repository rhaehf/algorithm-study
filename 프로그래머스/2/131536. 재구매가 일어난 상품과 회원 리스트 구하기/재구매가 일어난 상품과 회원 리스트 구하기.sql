-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY PRODUCT_ID, USER_ID
HAVING COUNT(USER_ID) >= 2
ORDER BY USER_ID ASC, PRODUCT_ID DESC;