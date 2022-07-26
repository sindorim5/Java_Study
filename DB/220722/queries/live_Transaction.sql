drop table if exists tc_test;

use ssafydb;

create table tc_test
(val varchar(10) );

select * from tc_test;

-----------------------------------------
start transaction;

insert into tc_test
values ('a');

insert into tc_test
values ('b');

insert into tc_test
values ('c');

rollback;

select * from tc_test;

-----------------------------------------
start transaction;

insert into tc_test
values ('a');

insert into tc_test
values ('b');

insert into tc_test
values ('c');

commit;

select * from tc_test;

-----------------------------------------

truncate tc_test;

select * from tc_test;

-----------------------------------------
start transaction;

insert into tc_test
values ('a');

insert into tc_test
values ('b');

insert into tc_test
values ('c');

savepoint f1;

select * from tc_test;

insert into tc_test
values ('d');

insert into tc_test
values ('e');

insert into tc_test
values ('f');

select * from tc_test;

rollback to f1;

select * from tc_test;

commit;

select * from tc_test;


drop table tc_test;

