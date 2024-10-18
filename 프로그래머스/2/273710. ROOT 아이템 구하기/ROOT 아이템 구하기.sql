-- 코드를 작성해주세요
select I.ITEM_ID, I.ITEM_NAME
from ITEM_TREE as T join ITEM_INFO as I
on T.ITEM_ID = I.ITEM_ID
where T.PARENT_ITEM_ID is null