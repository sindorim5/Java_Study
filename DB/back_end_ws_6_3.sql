SELECT @@autocommit;
set autocommit=false;

-- 1. country에서 전체 자료의 수와 독립 연도가 있는 자료의 수를 각각 출력하시오.
SELECT count(Code) as "전체"
    , (    SELECT count(IndepYear)
        FROM country
        WHERE IndepYear is not null
        ) as "독립 연도 보유"
FROM country;

-- 2. country에서 기대 수명의 합계, 평균, 최대, 최소를 출력하시오. 평균은 소수점 2자리로 반욜림한다.
SELECT SUM(LifeExpectancy) as "합계"
    ,  round(avg(LifeExpectancy), 2) as "평균"
    ,  MAX(LifeExpectancy) as "최대"
    ,  MIN(LifeExpectancy) as "최소"
FROM country;

-- 3. country에서 continent 별 국가의 개수와 인구의 합을 구하시오. 국가 수로 정렬 처리한다. (7건)
SELECT DISTINCT continent
    , count(code) as `국가 수`
    , SUM(Population) as `인구 합`
FROM country
GROUP BY Continent
ORDER BY `국가 수` desc;

-- 4. country에서 대륙별 국가 표면적의 합을 구하시오. 면적의 합을 내림차순으로 정렬하고 상위 3건만 출력한다.
SELECT DISTINCT continent
    , SUM(SurfaceArea) as `표면적 합`
FROM country
GROUP BY Continent
ORDER BY `표면적 합` desc
LIMIT 3;

-- 5. country에서 대륙별로 인구가 50,000,000 이상인 나라의 gnp 총 합을 구하시오. 합으로 오름차순 정렬한다. (5건)
SELECT DISTINCT continent
    , SUM(GNP)    as `gnp 합`
FROM country
WHERE Population > 50000000
GROUP BY Continent
ORDER BY `gnp 합` asc;

-- 6. country에서 대륙별로 인구가 50,000,000 이상인 나라의 gnp 총 합을 구하시오.
-- 이때 gnp의 합이 5,000,000 이상인 것만 구하시오.
SELECT continent
    , SUM(GNP)    as `gnp 합`
FROM country
WHERE Population > 50000000
GROUP BY continent
HAVING SUM(GNP) > 5000000
ORDER BY `gnp 합` asc;

-- 7. country에서 연도별로 10개 이상의 나라가 독립한 해는 언제인가?
SELECT DISTINCT indepyear
    , COUNT(indepYear) as `독립 국가 수`
FROM country
GROUP BY indepYear
HAVING COUNT(indepYear) > 10;

-- 8. country에서 국가별로 gnp와 함께 전세계 평균 gnp, 대륙 형균 gnp를 출력하시오. (239건)
SELECT co.continent
    ,  co.name
    ,  co.gnp
    , (
        SELECT avg(gnp)
        FROM country
        ) as `전세계 평균`
    , temp.temp_avg as `대륙 평균`
FROM country co join (
                    SELECT co.Continent as temp_con
                        , avg(gnp) as temp_avg
                    FROM country co
                    GROUP BY Continent
                    ) as temp
on co.continent = temp.temp_con
ORDER BY co.continent;

-- 9. countrylanguage에 countrycode='AAA', language='외계어', isOfficial='F', percentage=10을 추가하시오.
-- 값을 추가할 수 없는 이유를 생각하고 필요한 부분을 수정해서 다시 추가하시오.

-- INSERT INTO countrylanguage
-- (countrycode, language, isOfficial, percentage)
-- VALUES('AAA', '외계어', 'F', 10);

-- Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails
-- (`world`.`countrylanguage`, CONSTRAINT `countryLanguage_ibfk_1`
-- FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`))

-- DDL: FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`)
/* countrylanguage.CountryCode는 country.Code를 참조한다. countrylanguage 값만 새로 생기고 country 값은 생기지 않으니
 데이터의 무결성이 깨지게 된다. 이러한 두 테이블 사이의 관계를 외래키 제약조건이라 한다. */
 
-- 외래키 제약조건 무시
-- SET foreign_key_checks =0;
 
-- country에 값을 먼저 추가
INSERT INTO country
(Code, Name, Continent, Region, Population, LocalName, GovernmentForm, Code2)
VALUES ('AAA', 'BBB', 'Asia', 'DDD', 999, 'EEE', 'FFF', 'GG');
 -- countrylanguage에 값 추가
INSERT INTO countrylanguage
(countrycode, language, isOfficial, percentage)
VALUES('AAA', '외계어', 'T', 10);

select * from country;

-- 10. countrylanguage에 countrycode='ABW', language='Dutch', isOfficial='F', percentage=10을 추가하시오.
-- 값을 추가할 수 없는 이유를 생각하고 필요한 부분을 수정해서 다시 추가하시오.
-- Error Code: 1062. Duplicate entry 'ABW' for key 'country.PRIMARY'
/* country.code가 PRIMARY KEY로 country의 유일한 값이어야 하는데 이미 등록되어있다.
	countrycode='ABW'를 다른 값으로 등록한다. */

-- country에 값을 먼저 추가
INSERT INTO country
(Code, Name, Continent, Region, Population, LocalName, GovernmentForm, Code2)
VALUES ('ABZ', 'CCC', 'Europe', 'DDD', 9999, 'ABW', 'HHH', 'II');
 -- countrylanguage에 값 추가
INSERT INTO countrylanguage
(countrycode, language, isOfficial, percentage)
VALUES('ABZ', 'Dutch', 'F', 10);

-- 11. country에 다음 자료를 추가하시오 # Code='TCODE', Region='TRegion', Code2='TC'
-- INSERT INTO country
-- (Code, Region, Code2)
-- VALUES ('TCODE', 'TRegion', 'TC');

-- Error Code: 1406. Data too long for column 'Code' at row 1
-- Code char(3)으로 3글자까지 된다. NOT NULL인 값들이 비어있다.

INSERT INTO country
(Code, Name, Continent, Region, Population, LocalName, GovernmentForm, Code2)
VALUES ('TCO', 'CCC', 'Asia', 'TRegion', 99999, 'TCO', 'GovForm', 'TC');

-- 12. city에서 id가 2331인 자료의 인구를 10% 증가시킨후 조회하시오.
UPDATE city
SET Population = Population * 1.1;

select id, name, population from city where id = 2331;

-- 13. country에서 code가 'USA'인 자료를 삭제하시오.
/*
DELETE FROM country
WHERE code = 'USA';

-- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails
-- (`world`.`city`, CONSTRAINT `city_ibfk_1` FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`))
-- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails 
-- (`world`.`countrylanguage`, CONSTRAINT `countryLanguage_ibfk_1` FOREIGN KEY (`CountryCode`) REFERENCES `country` (`Code`))

-- 참조 중인 데이터가 있기 때문에 데이터를 삭제할 수 없다. child 데이터들을 모두 지우고 나서 시도한다.

DELETE FROM city WHERE countrycode = 'USA';

DELETE FROM countrylanguage WHERE countrycode = 'USA';

DELETE FROM country WHERE code = 'USA';
*/

-- 14. 이제까지의 DML 작업을 모두 되돌리기 위해 rollback 처리하시오.
ROLLBACK;

-- 15. ssafydb라는 이름으로 새로운 schema를 생성하시오.
DROP DATABASE IF EXISTS ssafydb;
CREATE schema ssafydb default character set utf8;

-- 16. 만약 user라는 테이블이 존재한다면 삭제하시오.
use ssafydb;
DROP TABLE IF EXISTS user;

-- 17. ssafydb에 다음 조건을 만족하는 테이블을 생성하시오.
CREATE TABLE user
(
		id VARCHAR(50) NOT NULL DEFAULT ''
    ,	name VARCHAR(100) NOT NULL DEFAULT '익명'
    ,	pass VARCHAR(100) NOT NULL DEFAULT ''
    ,	PRIMARY KEY(id)
);

-- 18. user 테이블에 다음의 자료를 추가하시오.
INSERT INTO user (id, name, pass)
VALUES ('ssafy', '김싸피', '1234');

INSERT INTO user (id, name, pass)
VALUES ('hong', '홍싸피', '5678');

INSERT INTO user (id, name, pass)
VALUES ('test', '테스트', 'test');

-- 19. id가 test인 계정의 pass를 id@pass형태로 변경하고 조회하시오.
UPDATE user
SET name='test', pass='test@테스트'
WHERE id = 'test';

select * from user where id = 'test';

-- 20. id가 test인 계정의 자료를 삭제하고 조회하시오.
DELETE FROM user
WHERE id = 'test';

select * from user;

-- 21. 현재까지의 내용을 영구 저장하기 위해서 commit 처리하시오.
COMMIT;