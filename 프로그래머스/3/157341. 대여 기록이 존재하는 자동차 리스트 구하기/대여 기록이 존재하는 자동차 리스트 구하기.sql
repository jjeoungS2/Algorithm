-- 코드를 입력하세요
SELECT distinct(R.CAR_ID)
from CAR_RENTAL_COMPANY_CAR as R join CAR_RENTAL_COMPANY_RENTAL_HISTORY as H
on R.CAR_ID = H.CAR_ID
where MONTH(H.START_DATE) = 10 and R.CAR_TYPE = '세단'
order by R.CAR_ID desc