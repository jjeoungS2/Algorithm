-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from FISH_INFO as I join FISH_NAME_INFO as N
on I.FISH_TYPE = N.FISH_TYPE
where N.FISH_NAME = 'BASS' or N.FISH_NAME = 'SNAPPER'
