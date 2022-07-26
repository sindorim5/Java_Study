use world;

-- 3. country table에서 code가 KOR인 자료를 조회
SELECT code, name, continent, region
FROM country 
WHERE Code = 'KOR';

-- 4. country에서 gnp 변동량(gnp-gnpold)이 양수인 국가에 대해 gnp 변동량의 오름차순으로 정렬하시오. 115건
SELECT code, name, gnp, gnpold, (gnp - gnpold) as 'gnp 변동량'
FROM country 
WHERE (GNP - GNPOld) > 0 
ORDER BY (GNP - GNPOld) ASC;

-- 5. country table에서 continent를 중복 없이 조회하시오. continent의 길이로 정렬한다. 7건
SELECT DISTINCT Continent
FROM country
ORDER BY length(Continent);

-- 6. country에서 asia 대륙에 속하는 국가들의 정보를 아래와 같이 출력하시오. name으로 정렬한다. 51건
SELECT concat(name, '은 ', region, '에 속하며 인구는 ', Population, '명이다.') as '정보'
FROM country
WHERE Continent = 'Asia'
ORDER BY name asc;

-- 7. country에서 독립년도에 대한 기록이 없고 인구가 10000 이상인 국가의 정모를 인구의 오름차순으로 출력하시오. 29건
SELECT name, Continent, gnp, Population
FROM country
WHERE IndepYear is NULL && Population >= 10000
ORDER BY Population asc;

-- 8. country에서 인구가 1억 <= x <= 2억인 나라를 인구 기준으로 내림차순 정렬해서 상위 3개만 출력하시오.
SELECT code, name, Population
FROM country
WHERE Population between 100000000 and 200000000
ORDER BY Population desc
LIMIT 0,3;

-- 9. country에서 800, 1810, 1811, 1901, 1901에 독립한 나라를 독립년 기준으로 오름차순 출력하시오.
-- 단, 독립년이 같다면 code를 기준으로 내림차순 한다. 7건
SELECT code, name, indepyear
FROM country
WHERE indepyear = 800
	  or indepyear = 1810
      or indepyear = 1811
	  or indepyear = 1901
ORDER BY indepyear asc, code desc;

-- 10. country에서 region에 asia가 들어가고 name의 두 번째 글자가 'o'인 정보를 출력하시오. 4건
SELECT code, name, region
FROM country
WHERE region like '%asia' and name like '_o%';

-- 11. '홍길동'과 'hong'의 글자 길이를 각각 출력하시오.
SELECT char_length('홍길동') '한글', char_length('hong') '영문'
FROM dual;

-- 12. country에서 governmentform 에 republic이 들어있고 name의 길이가 10 이상인 자료를
-- name 길이의 내림차순으로 상위 10개만 출력하시오. 10건
SELECT code, name, Governmentform
FROM country
WHERE GovernmentForm like '%Republic%' and char_length(name) >= 10
ORDER BY char_length(name) desc
LIMIT 0,10;

-- 13. country에서 code가 모음으로 시작하는 나라의 정보를 출력하시오. 이때 name의 오름차순으로 정렬하고 3번부터 3개만 출력한다.
SELECT code, name
FROM country
WHERE code like 'a%'
	or code like 'e%'
	or code like 'i%'
	or code like 'o%'
	or code like 'u%'
ORDER BY name asc
LIMIT 2, 3;

-- 14. country에서 name을 맨 앞과 맨 뒤에 2글자를 제외하고 나머지는 *로 처리해서 출력하시오. 239건
SELECT name
	, CONCAT(CONCAT(SUBSTR(name, 1, 2),repeat('*', char_length(name) - 4)),SUBSTR(name, -2, 2)) as guess
FROM country;

-- 15. country에서 region 을 중복없이 가져오는데 공백을 _로 대체하시오. region의 길이로 정렬한다. 25건
SELECT DISTINCT replace(region, ' ', '_') as '지역들'
FROM country
ORDER BY char_length(region) desc;

-- 16. country에서 인구가 1억 이상인 국가들의 1인당 점유면적을 반올림해서 소숫점 3자리로 표현하시오. 1인당 점유면적의 오름차순으로 정렬한다. 10건
SELECT name, SurfaceArea, Population, round((SurfaceArea/Population), 3) as '1인당 점유 면적'
FROM country
WHERE Population >= 100000000
ORDER BY (SurfaceArea/Population) asc;

-- 17. 현재 날짜와 올해가 몇 일이 지났는지, 100일 후는 몇일인지 출력하시오.
SELECT curdate() as '오늘'
	, DATEDIFF(curdate(), '2022-01-01') as '올해 지난 날'
    , date_add(curdate(), interval 100 day) as '100일 후'
FROM dual;

-- 18. country에서 asia에 있는 나라 중 희망 수명이 있는 경우에 기대 수명이 80 초과면 장수국가, 60 초과면 일반국가, 그렇기 않으면 단명국가라고 표현하시오.
-- 기대 수명으로 정렬한다. 51건
SELECT name
	, continent
    , LifeExpectancy
    , if (LifeExpectancy > 80, '장수국가', if (LifeExpectancy > 60, '일반국가', '단명국가')) as '구분' 
FROM country
WHERE Continent = 'Asia' && LifeExpectancy is NOT NULL
ORDER BY LifeExpectancy asc;

-- 19. country에서 (gnp-gnpold)를 gnp 향상이라고 표현하시오. 단 gnpold가 없는 경우 신규라고 출력하고 name으로 정렬한다. 239건
SELECT name
	, gnp
	, gnpold
    , if (ISNULL(gnpold), '신규', gnp-gnpold) as 'gnp 향상'
FROM country
ORDER BY name asc;

-- 20. 2020년 어린이 날이 평일이면 행복, 토요일 또는 일요일이면 불행이라고 출력하시오
SELECT weekday('2020-05-05')
	, if (weekday('2020-05-05'), '행복', '불행') as '행복여부'
FROM dual;