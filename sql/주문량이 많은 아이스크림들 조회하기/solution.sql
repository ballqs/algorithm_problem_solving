SELECT FLAVOR
FROM (
    SELECT DISTINCT FLAVOR
    FROM FIRST_HALF FH
) F
ORDER BY (SELECT SUM(TOTAL_ORDER) FROM FIRST_HALF WHERE FLAVOR = F.FLAVOR) + 
        (SELECT SUM(TOTAL_ORDER) FROM JULY WHERE FLAVOR = F.FLAVOR) DESC
LIMIT 3;