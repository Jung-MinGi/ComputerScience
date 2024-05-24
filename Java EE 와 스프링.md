<h2>Java EE</h2>

> 애플리케이션을 개발/실행하기 위한 기술과 환경을 제공하며 서블릿, JSP, EJB, JDBC, JNDI, JMX, JTA 등의 알려진 기술을 포함하고 있습니다.
> Java EE가 오라클레서 이클립스 재단으로 이관되며 공식 명칭이 Jakarta EE로 변경
- 웹 어플리케이션 서버(WAS): Java EE의 기술을 구현해논것
- Web Container(servlet Container): servlet&Jsp의 기능을 가진다. 웹 클라이언트의 http요청을 받고 servlet의 생명주기는 관리하며 jsp,filter등을 지원한다. Java에서는 http요청을 servlet을 통해 처리하기 때문에 servlet Container라고도 부른다
* 아파치 톰켓: Java EE에서 모두 구현한것이 WAS인데, 톰캣은 WebContainer만 구현하고 있기때문에 온전한 WAS는 아니다.
<h2>Java EE --> spring 대체</h2>

EJB종속성에서 벗어나고자 Java EE가 나오게 되었는데, 결국 Java EE에도 종속되어버리게 됨.<br>
그래서 POJO방식(특정 클래스를 상속하거나 인터페이스를 구현하지 않은 가벼운 객체)를 원하게됨<br>
Java EE를 개선해서 나오게 된게 Spring이다.

![image](https://github.com/Jung-MinGi/ComputerScience/assets/118701129/c3b158cb-7d7d-4ec9-89d8-40fb56debe31)



위 그림처럼 Java EE의 WebContainer는 톰켓이 EJB Container부분은 스프링이 대체하게 되었다.<br>
스프링은 POJO 방식의 프로그래밍을 지향하며 비침투적인 기술(IoC/DI, AOP, PSA)을 지향한다.

-
* Java 웹 프로그래밍을 한다는 의미:
  *  java언어로 웹 어플리케이션을 만든다는 의미
  *  내가 만든 웹 어플리케이션이 돌아갈 was가 필요하다는 의미.
  *  즉 내게 필요한 was는 java EE스펙에서 servlet/jsp스펙을 구현한 was가 필요하다는 의미
  *  그게 아파치 톰켓이고 그래서 was를 서블릿컨테이너라고 부른다(jsp도 결국 servlet)
  *  그 컨테이너 안에서 내가 스프링으로 만든 웹 어플리케이션이 동작한다는 말
  *  WAS는 여러개의 웹 어플리케이션을 실행할 수 있다

 * 서블릿(http서블릿을 상속받은 클래스)
 ```
httpservlet란 http메세지를 처리해주는 클래스 
 ```
  * jsp도 특수한 형태의 서블릿이다.
- 포워드
  - 서블릿에서 만든 결과값을 jsp로 보내는 것
  ```
  1. /plus?x=10&y=10이라는 request가 was로 옴
  2. /plus라고 맵핑되어있는 서블리을 톰겟이 실행함
  3. 이때 같이 넘어온 쿼리 스틍링에서 값을 만듦
  4. 이 결과값을 jsp로 **포워딩**함
  5. index.jsp가 클라이언트에게 전해짐
  6. 그러나 여전히 클라이언트의 주소창에는 /plus?x=10&y=10이 적혀있음 jsp가 사용되었는지 알 수 없음
  7. 포워딩은 같은 서버안에서 이루어지는 동작을 말함
  ```
<h2>Spring</h2>
자바 엔터프라이즈 에플리케이션 개발을 도와주는 프레임워크며 스프링을 사용하면 독립실행 자바 에플리케이션, 웹 애플리케이션,애플릿등 다양한 유형의 자바 애플리케이션을 개발할 수 있다.<br>

- 스프링 모듈
  - [핵심컨테이너](https://github.com/Jung-MinGi/ComputerScience/blob/master/%ED%95%B5%EC%8B%AC%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88.md)
  - 웹
  - 테스트
  - 데이터 접근/통합
  - 메시징
  - AOP와계측 





 

- References
  - https://colour-my-memories-blue.tistory.com/14
  - https://www.samsungsds.com/kr/insights/java_jakarta.html
