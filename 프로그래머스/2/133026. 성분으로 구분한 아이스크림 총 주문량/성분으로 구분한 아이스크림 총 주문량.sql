-- 코드를 입력하세요
SELECT I.INGREDIENT_TYPE, sum(F.TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF as F, ICECREAM_INFO as I
where I.FLAVOR = F.FLAVOR
group by I.INGREDIENT_TYPE
order by TOTAL_ORDER