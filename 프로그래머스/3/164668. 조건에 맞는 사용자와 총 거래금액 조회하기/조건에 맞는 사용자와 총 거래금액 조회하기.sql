-- 코드를 입력하세요
SELECT U.USER_ID, U.NICKNAME, sum(B.PRICE) as TOTAL_SALES
from USED_GOODS_BOARD as B join USED_GOODS_USER as U
on B.WRITER_ID = U.USER_ID
where B.STATUS = 'DONE'
group by B.WRITER_ID
having TOTAL_SALES >= 700000
order by TOTAL_SALES