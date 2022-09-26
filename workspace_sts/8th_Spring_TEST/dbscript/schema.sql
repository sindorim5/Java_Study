drop database if exists springtest;
create database springtest;

use springtest;

create table region(
    rcode char(20) primary key,	-- 지역 코드
    rname varchar(20) not null  -- 지역 명
);

create table country_status(
    seq    int primary key auto_increment,  -- auto increment
    cname varchar(30) not null unique,      -- 국가 명, unique
    population int not null,                -- 인구 수
    rcode char(20),                         -- 지역 코드
    constraint fk_country foreign key(rcode) references region(rcode)
);

insert into region values 
('eu','유럽'), ('na','북아메리카'), ('sa','남아메리카'), ('as','아시아'), ('af','아프리카'), ('oc','오세아니아')
;

insert into country_status (cname, population, rcode) values 
('브라질', 213993441, 'sa'),
('영국', 67326569, 'eu'),
('미국', 331893745, 'na'), 
('인도', 1393409033, 'as'),
('중국', 1412360000, 'as'),
('러시아', 143446060, 'eu'),
('프랑스', 67499343, 'eu'),
('튀르키예', 85042736, 'eu'),
('이란', 85028760, 'as'),
('아르헨티나', 45808747, 'sa'),
('콜롬비아', 51265841, 'sa'), 
('남아프리카공화국', 60041996, 'af'), 
('호주', 25739256, 'oc'),    -- 뉴질랜드와 동일값
('뉴질랜드', 25739256, 'oc')  -- 호주와 동일값
;

commit;

select * from country_status;
