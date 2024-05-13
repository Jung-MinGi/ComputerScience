* JOIN<br>
  검색을 위해 참조해야할 테이블이 여러 개일 경우 조인 조건을 사용하여 검색문을 작성한다.<br>
  * outer join(외부조인)<br>
    조인 조건식에서 동일한 값이 없는 행도 반환할 때 사용된다.
     * LEFT OUTER JOIN [관련문제보러가기](https://school.programmers.co.kr/learn/courses/30/lessons/59044)<br>
       왼쪽 테이블의 모든 행을 반환시켜준다<br>
       왼쪽 테이블에서 값이 있지만 오른쪽 테이블에 없는 경우 NULL값으로 채워놓음<br>
       ```
        select
        I.ANIMAL_ID AS 'A테이블 ID',
        IFNULL(O.ANIMAL_ID,'NULL') AS 'B테이블 ID'
        from ANIMAL_INS I LEFT OUTER JOIN ANIMAL_OUTS O
        ON I.ANIMAL_ID = O.ANIMAL_ID
       ```
        ![image](https://github.com/Jung-MinGi/ComputerScience/assets/118701129/696564c6-333a-44b3-adc6-97abfe425d5f)
        
     * RIGHT OUTER JOIN
     * J
     * FULL OUTER JOIN
