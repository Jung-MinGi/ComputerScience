<h2>뷰(view)</h2>

사용자의 요구에 따라 컬럼값을 새로 정의하여 만든 새로운 테이블이다<br>
보통 보안상의 이유로 쓰이며 애플리케이션 단에서 view를 참조할 경우 의존성이 약해져 코드 개선이 수월하다.

* 뷰의 장점
  * 보안에 도움이 된다.<br>
    외부에서 특정 테이블의 컬럼값을 요구하는 경우 나머지 속성값들이 노출될 수 밖에 없는데<br> 이때 해당 테이블의 뷰를 생성해 주면 이러한 문제가 쉽게 해결된다.
  * 복잡한 쿼리를 단순화시켜준다<br>
    복잡한 쿼리를 자주 사용해야 할 경우 매번 쿼리를 사용하지않고<br>
    쿼리에 대한 결과값을 뷰로 만들어 놓으면 편리하다.


![image](https://github.com/Jung-MinGi/ComputerScience/assets/118701129/26219504-7591-43b1-b2d9-8cffbe14c4e9)

* 위 테이블에서 성별이 남자인 뷰 생성해보기
```
create view v_emplMan
as select * from employee where gender = 'M';


create vs (create or replace view) 차이점
전자는  기본에 뷰가 있으면 오류가 발생하지만 후자는 기존에 뷰가 있어도 덮었쓰는 효과를 내기 때문에 오류 발생x
```
![image](https://github.com/Jung-MinGi/ComputerScience/assets/118701129/9b6189be-21f0-44e0-b6c9-d28489647a4d)


* 뷰 수정(칼럼 한국어로 바꾸기)
```
alter view v_emplMan
as select emp_no as '직원번호', birth_date as '생년월일', first_name as '성', last_name as '이름'
, gender as '성별', hire_date as '고용일' from employee where gender = 'M';
```
![image](https://github.com/Jung-MinGi/ComputerScience/assets/118701129/61a50880-2e67-42f4-8175-994c2e90fda6)

* 뷰 데이터 입력
```
insert into employees(emp_no,birth_date,first_name,last_name,gender,hire_date) values (1,'1997-04-11','jung','mingi','M','2001-04-11');
```
![image](https://github.com/Jung-MinGi/ComputerScience/assets/118701129/43d16179-8e59-49e8-ad70-510827c5b65e)

뷰에 데이터를 삽입할땐 뷰가 참조하는 원래 테이블에 데이터를 삽입해주면 된다.

