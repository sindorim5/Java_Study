use world;

-- 1. 도시명 kabul이 속한 국가의 이름은?
SELECT a.code
	 , a.name
FROM country a join city b
WHERE a.Code = b.CountryCode AND b.Name = 'Kabul';

-- 2. 국가의 공식 언어 사용율이 100%인 국가의 정보를 출력하시오. 국가의 이름으로 오름차순으로 정렬한다. (8건)
SELECT c.name
	,  lang.Language
    ,  lang.Percentage
FROM countrylanguage lang join country c
ON c.code = lang.CountryCode
WHERE lang.Percentage = 100.0
	and lang.IsOfficial = "T"
ORDER BY c.name asc;

-- 3. 도시명 amsterdam에서 사용되는 주요 언어와 amsterdam이 속한 국가는?
SELECT city.name
	,  lang.language
    ,  country.name
FROM country join city
ON country.code = city.CountryCode
join countrylanguage lang
ON city.CountryCode = lang.CountryCode
WHERE city.name = "Amsterdam"
	and lang.IsOfficial = "T";

-- 4. 국가명이 united로 시작하는 국가의 정보와 수도의 이름, 인구를 함께 출력하시오.
-- 단, 수도 정보가 없다면 출력하지 않는다. (3건)
SELECT c.name
	,  city.ID as capital
    ,  city.name as 수도
    ,  city.Population as 수도인구
FROM city join country c
ON city.CountryCode = c.code
WHERE c.name like "United%"
	and c.Capital = city.ID;

-- 5. 국가명이 united로 시작하는 국가의 정보와 수도의 이름, 인구를 함께 출력하시오.
-- 단, 수도 정보가 없다면 수도 없음이라고 출력한다. (4건)
SELECT c.name
	,  city.ID as capital
    ,  IFNULL(city.name, "수도없음") as 수도
    ,  IFNULL(city.Population, "수도없음") as 수도인구
FROM country c left join city
ON city.id = c.Capital
WHERE c.name like "United%";

-- 6. 국가 코드 che의 공식 언어 중 가상 사용률이 높은 언어보다 사용율이 높은 공식언어를 사용하는 국가는 몇 곳인가?
SELECT COUNT(*) as "국가수"
FROM country c join countrylanguage lang
ON lang.CountryCode = c.code
WHERE lang.Percentage > (
							SELECT max(Percentage)
							FROM countrylanguage lang join country
							WHERE lang.CountryCode = "che"
								and lang.IsOfficial = "T"
						)
	and lang.IsOfficial = "T";

-- 7. 국가명 south korea의 공식 언어는?
SELECT lang.Language as "language"
FROM country c join countrylanguage lang
ON lang.CountryCode = c.code
WHERE c.Name = "south korea"
	and lang.IsOfficial = "T";

-- 8. 국가 이름이 bo로 시작하는 국가에 속한 도시의 개수를 출력하시오. (3건)	
SELECT c.name
	 , c.code
	 , count(city.name) as "도시개수"
FROM country c join city
on c.code = city.CountryCode
WHERE c.name like "bo%"
Group BY city.CountryCode;

-- 9. 국가 이름이 bo로 시작하는 국가에 속한 도시의 개수를 출력하시오. 도시가 없을 경우는 단독이라고 표시한다. (4건)
SELECT c.name
	 , c.Code
	 , IF(count(city.name) > 0 , count(city.name), "단독") as "도시개수"
FROM country c left join city
on c.code = city.CountryCode
WHERE c.name like "bo%"
Group BY city.CountryCode;

-- 10. 인구가 가장 많은 도시는 어디인가?
SELECT countryCode
	, name
    , population
FROM city
ORDER BY Population desc
limit 1;

-- 11. 가장 인구가 적은 도시의 이름, 인구수, 국가를 출력하시오.
SELECT c.name
	, city.CountryCode as "code"
    , city.name
    , city.population as "population"
FROM city join country c
on city.CountryCode = c.Code
ORDER BY Population asc
limit 1;

-- 12. KOR의 seoul보다 인구가 많은 도시들을 출력하시오.
SELECT countrycode
	,  name
    ,  population
FROM city
WHERE population > (
							SELECT population
							FROM city
							WHERE countrycode = 'KOR'
								and Name = 'Seoul'
						);

-- 13. San Miguel이라는 도시에 사는 사람들이 사용하는 공식 언어는?
SELECT city.CountryCode as "countrycode"
	,  lang.language
FROM city join countrylanguage lang
on city.CountryCode = lang.CountryCode
WHERE name = "San Miguel"
	and lang.IsOfficial = "T";

-- 14. 국가 코드와 해당 국가의 최대 인구수를 출력하시오. 국가 코드로 정렬한다. (232건)
SELECT countrycode
	,  MAX(population) as max_pop
FROM city
GROUP BY countrycode;

-- 15. 국가별롤 가장 인구가 많은 도시의 정보를 출력하시오. 국가 코드로 정렬한다. (232건)
SELECT countrycode
	,  name
    ,  MAX(population)
FROM city
GROUP BY countrycode
order by CountryCode asc;

-- 16. 국가 이름과 함께 국가별로 가장 인구가 많은 도시의 정보를 출력하시오. (239건)
SELECT c.code
	,  c.name
    ,  city.name
    ,  MAX(city.population) as "population"
FROM country c left join city
on city.ID = c.Capital
GROUP BY c.code;

-- 17. 위 쿼리의 내용이 자주 사용된다. 재사용을 위해 위 쿼리의 내용을 summary라는 이름의 view로 생성하시오.
create or replace view summary as
SELECT c.code as "code"
	,  c.Name as "co_name"
    ,  city.name as "ci_name"
    ,  MAX(city.population) as "population"
FROM country c left join city
on city.ID = c.Capital
GROUP BY c.code;

-- 18. summary에서 KOR의 대표도시를 조회하시오.
SELECT *
FROM summary
WHERE code = "KOR";
