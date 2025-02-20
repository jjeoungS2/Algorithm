-- 코드를 입력하세요
SELECT CATEGORY, sum(SALES) as TOTAL_SALES
from BOOK as B join BOOK_SALES as BS
on B.BOOK_ID = BS.BOOK_ID
where BS.SALES_DATE like "2022-01%"
group by B.CATEGORY
order by B.CATEGORY