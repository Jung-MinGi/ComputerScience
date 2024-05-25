<h2>springmvc</h2>

* 스프링 웹 프로젝트 디렉토리 구조
  - src/main/resources/META-INF/spring 폴더에는 rootApplicationContext.xml파일이 존재한다.
    > rootApplicationContext.xml이란 모든 서블릿이 공유하는 빈과 웹 어플리케이션 필터 정의가 들어있다.
    > rootApplicationContext.xml는 스프링의 contextLoaderListener에 의해 로드된다.
  - src/main/resources/WEB-INF/spring 폴더에는 webApplicationContext.xml파일이 존재한다.
    > 이 파일안에 컨트롤러, 뷰 리졸버, 예외 리졸버 등을 정의하고 rootApplicationContext에 존재하는 빈에 접근가능하다.
