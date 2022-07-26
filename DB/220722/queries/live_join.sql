-- 사번이 100인 사원의 사번, 이름, 급여, 부서이름
select employee_id, first_name, salary, department_id
from employees
where employee_id = 100;

select department_name
from departments
where department_id = 90;

-- 0. 일반적인 방법
select employee_id, first_name, salary, department_name
from employees, departments
where employees.department_id = departments.department_id
and employee_id = 100;

-- 1. alias 만들기도 가능, 양쪽 테이블에 명확하게 어떤 column인지 알려줘야 함.
select a.employee_id, a.first_name, a.salary, b.department_name
from employees a, departments b
where a.department_id = b.department_id
and employee_id = 100;

-- 2. 표준적인 방법
select employee_id, first_name, salary, department_name
from employees e inner join departments d
on e.employee_id.department_id = d.departments.department_id
where employees_id = 100;

-- 사번이 100인 사원의 사번, 이름, 급여, 부서이름
select employee_id, first_name, salary, department_id, department_name
from employees, departments
where employees.department_id = departments.department_id
and employee_id = 100;

select employee_id, first_name, salary, employees.department_id, department_name
from employees, departments
where employees.department_id = departments.department_id
and employee_id = 100;

-- alias 사용
select e.employee_id, e.first_name, e.salary, e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id
and e.employee_id = 100;

-- inner join
select e.employee_id, e.first_name, e.salary, e.department_id, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id
where e.employee_id = 100;

-- using
select e.employee_id, e.first_name, e.salary, e.department_id, d.department_name
from employees e join departments d
using (department_id)
where e.employee_id = 100;

-- natural join
select e.employee_id, e.first_name, e.salary, e.department_id, d.department_name
from employees e natural join departments d
where e.employee_id = 100;

-- 부서번호가 10인 부서의 부서번호, 부서이름, 도시
select d.department_id, d.department_name, l.city
from departments d natural join locations l
-- using(department_id)
where d.department_id = 10;


-- 회사에 근무하는 모든 사원의 사번, 이름, 부서이름
-- 회사에 근무하는 사원수 
-- 107명
select count(employee_id)
from employees;

-- 회사에 근무하는 모든 사원의 사번, 이름, 부서이름
-- 106명 >> 문제 발생..
select e.employee_id, e.first_name, d.department_name
from employees e join departments d
using (department_id);

-- 부서가 없는(부서번호가 null) 사원 검색
select employee_id, first_name, department_id
from employees
where department_id is null;

-- 해결
select e.employee_id, e.first_name, d.department_name
from employees e left outer join departments d
using (department_id);
-- on e.department_id = d.department_id


-- 회사에 존재하는 모든 부서의 부서이름과 부서에서 근무하는 사원의 사번, 이름
-- 회사의 부서수 >> 27
select count(department_id)
from departments;

-- 사원이 근무하는 부서수 >> 11
select count(distinct department_id)
from employees;

-- 사원이 없는 부서의 정보는 출력이 안됨.
select d.department_name, e.employee_id, e.first_name
from employees e join departments d
using (department_id);

-- 해결
select d.department_name, e.employee_id, e.first_name
from employees e right outer join departments d
using (department_id);

-- self join
-- 모든 사원의 사번, 이름, 매니저사번, 매니저이름
select e.employee_id, e.first_name, m.employee_id, m.first_name
from employees e inner join employees m
on e.manager_id = m.employee_id;

select * from employees
where manager_id is null;

-- None-Equi join
-- 모든 사원의 사번, 이름, 급여, 급여등급
select e.employee_id, e.first_name, e.salary, s.grade
from employees e join salgrades s
where e.salary >= s.losal
and e.salary <= s.hisal;

select e.employee_id, e.first_name, e.salary, s.grade
from employees e join salgrades s
where e.salary between s.losal
and s.hisal;


-- 사번이 101인 사원의 근무 이력.
-- 사번, 이름, 부서이름, 직급이름, 시작일, 종료일

select e.employee_id "사번"
	, concat(e.first_name, " ", e.last_name) "이름"
	, d.department_name "부서이름"
    , d.department_id "부서"
    , j.job_title "직급이름"
    , date_format(h.start_date, '%y.%m.%d') "시작일"
    , date_format(h.end_date, '%y-%m-%d') "종료일"
from employees e inner join job_history h
on e.employee_id = h.employee_id
join departments d
on d.department_id = h.department_id
join jobs j
on h.job_id = j.job_id
where e.employee_id = 101;

select e.employee_id "사번"
	, concat(e.first_name, " ", e.last_name) "이름"
	, d.department_name "부서이름"
    , d.department_id "부서"
    , j.job_title "직급이름"
    , date_format(h.start_date, '%y.%m.%d') "시작일"
    , date_format(h.end_date, '%y-%m-%d') "종료일"
from employees e, departments d, jobs j, job_history h
where
	e.department_id = d.department_id
    and e.employee_id = h.employee_id
    and e.job_id = j.job_id
    and e.employee_id = '101';