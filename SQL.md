* DISTINCT
  
  중복 행을 제거할 때 사용<BR>
  SELECT DISTINCT 열이름 FROM TABLE;
* WHERE절

  기본 형태 --> WHERE <열 이름> <비교연산자> <속성 값><BR>
  두 개 이상의 조건이 들어가는 경우 논리연산자(AND,OR,NOT)를 중간에 적어준다.

* 집계함수
  보통 SELECT절이나 HAVING절에 사용한다.
    * COUNT()<BR>
      특정 열 값의 개수 또는 행의 개수 이때 중복 행의 개수를 반환한다.<BR>
      SELECT COUNT() FROM TABLE;<BR>
      COUNT(DISTINCT <열 이름>)<BR>
      중복을 무시해주고 NULL을 제외시킴
    * MAX()<BR>
      특정 열 값 중에서 최댓값
    * MIN()<BR>
      특정 열 값 중에서 최소값
    * SUM()<BR>
      특정 열 값의 합계
    * AVG()<BR>
      특정 열 값의 평균

* LIMIT
  
  SELECT * FROM employees ORDER BY date LIMIT n<BR>
  주어진 결과값에서 상위 n개의 행만 보여줌

* GROUP BY절<BR>
  테이블의 개별 행이 아닌 행 그룹에 대한 검색<BR>
  GROUP BY절 뒤에는 그룹을 분류하는 기준이 되는 열을 지정한다.<BR>
  GROUP BY절에서 그룹화 기준으로 사용된 열을 SELECT절에도 명시해줘야 검색 결과의 의미를 파악할 수 있다.<BR>
  HAVING절은 그룹에 대한 조건을 명세함으로써 질의 결과로 나타나는 그룹을 제한하는 역할을 한다.<BR>
 * WHERE,GROUP BY, HAVING 적용 순서

  > WHERE 절이 데이터를 먼저 필터링하고, GROUP BY 절은 필터링된 데이터를 그룹화하며, HAVING 절은 그룹화된 데이터에 조건을 적용한다.
* HAVING절<BR>
  그룹이 만족해야하는 제한 조건을 명세한다.<BR>
  GROUP BY절로 생성된 그룹중에서도 특정 조건을 만족하는 그룹으로 검색을 제한한다.<BR>
  WHERE절이 행을 구분한다면 HAVING절은 그룹자체를 거르는 거<BR>
  
* LIke연산자

  문자열의 내용을 검색할 때 사용 가능

  select * from user where name LIKE  '김%'

  앞글자가 '김'으로 시작하는 모든 문자열이 올 수 있다/

* DATETIME에서 DATE로 형 변환

  date_format(DATETIME,'%Y-%m-%d')

  %y -- 두자리 연도 ex) 23

  %Y -- 네자리 연도 ex)2023
