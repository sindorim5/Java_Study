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
    , COUNT(indepYear)
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