create or replace function erx.get_newrx_msg_id_func
(
  p_message_id in varchar2,
  p_begin_date in date default sysdate - 365, --one year
  p_end_date in date default sysdate 
) return varchar2 as 
v_newrx_message_id varchar2(35);
begin  
  select message_id into v_newrx_message_id from (select * from (select 
t.message_id,
t.rel_to_message_id
from inbound_ncpdp_msg t where received_date between p_begin_date and p_end_date 
union
select 
t.message_id,
t.rel_to_message_id
from outbound_ncpdp_msg t where received_date between p_begin_date and p_end_date ) results
CONNECT BY PRIOR results.message_id = results.rel_to_message_id
 START WITH
    results.message_id = p_message_id or results.rel_to_message_id = p_message_id
    union
 select * from (   select 
t.message_id,
t.rel_to_message_id
from inbound_ncpdp_msg t where received_date between p_begin_date and p_end_date 
union
select 
t.message_id,
t.rel_to_message_id
from outbound_ncpdp_msg t where received_date between p_begin_date and p_end_date ) results
CONNECT BY PRIOR results.rel_to_message_id = results.message_id
 START WITH
    results.message_id = p_message_id or results.rel_to_message_id = p_message_id)
    where rel_to_message_id is null;

  return v_newrx_message_id;
end get_newrx_msg_id_func;
/

CREATE OR REPLACE PUBLIC SYNONYM GET_NEWRX_MSG_ID_FUNC FOR ERX.GET_NEWRX_MSG_ID_FUNC;

GRANT EXECUTE ON ERX.GET_NEWRX_MSG_ID_FUNC TO ERX_UPDATE_ROLE;
