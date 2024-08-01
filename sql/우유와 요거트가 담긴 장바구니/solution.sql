SELECT DISTINCT CP.CART_ID
FROM CART_PRODUCTS CP
WHERE (
        SELECT COUNT(*)
        FROM CART_PRODUCTS
        WHERE CART_ID = CP.CART_ID
            AND NAME = "Milk"
    ) > 0
    AND (
        SELECT COUNT(*)
        FROM CART_PRODUCTS
        WHERE CART_ID = CP.CART_ID
            AND NAME = "Yogurt"
    ) > 0;