# 기록에 2022-10-16사이에 값이 하나라도 있다면 대여중으로 나오는 것
SELECT C.CAR_ID , 
        IF((
            SELECT COUNT(*)
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE CAR_ID = C.CAR_ID
                AND "2022-10-16" BETWEEN DATE_FORMAT(START_DATE,"%Y-%m-%d") AND DATE_FORMAT(END_DATE,"%Y-%m-%d")
        ) > 0
            ,"대여중","대여 가능") AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY C
GROUP BY C.CAR_ID
ORDER BY C.CAR_ID DESC;