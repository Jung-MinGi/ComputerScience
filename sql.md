* DISTINCT
  
  중복 행을 제거할 때 사용<BR>
  SELECT DISTINCT 열이름 FROM TABLE;
* WHERE절

  기본 형태 --> WHERE <열 이름> <비교연산자> <속성 값><BR>
  두 개 이상의 조건이 들어가는 경우 논리연산자(AND,OR,NOT)를 중간에 적어준다.

* 집계함수
    * COUNT()<BR>
      행의 개수를 센다<BR>
      SELECT COUNT() FROM TABLE;<BR>
      COUNT(DISTINCT)<BR>
      행의 개수를 센다 중복은 1개만 인정해준다. DISTINCT는 기본적으로 NULL도 제외시킴

* 출력하는 개수를 제한하는 LIMIT

  SELECT * FROM employees ORDER BY date LIMIT n

  주어진 결과값에서 상위 n개의 레코드만 보여줌



* LIke연산자

  문자열의 내용을 검색할 때 사용 가능

  select * from user where name LIKE  '김%'

  앞글자가 '김'으로 시작하는 모든 문자열이 올 수 있다/

* DATETIME에서 DATE로 형 변환

  date_format(DATETIME,'%Y-%m-%d')

  %y -- 두자리 연도 ex) 23

  %Y -- 네자리 연도 ex)2023
