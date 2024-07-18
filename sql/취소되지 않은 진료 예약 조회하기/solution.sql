SELECT A.APNT_NO , P.PT_NAME , P.PT_NO , D.MCDP_CD , D.DR_NAME , A.APNT_YMD
FROM APPOINTMENT A
    LEFT JOIN PATIENT P ON(P.PT_NO = A.PT_NO)
    LEFT JOIN DOCTOR D ON(D.DR_ID = A.MDDR_ID)
WHERE DATE_FORMAT(A.APNT_YMD , "%Y-%m-%d") = "2022-04-13"
    AND A.APNT_CNCL_YN = "N"
ORDER BY A.APNT_YMD ASC;