![image](https://github.com/Jung-MinGi/ComputerScience/assets/118701129/a34a5f15-49a7-4198-95f6-81f35717b2f3)<h2>servlet</h2>

Servlet API는 서버에서 구현되도록 고안된 표준화된 API입니다.서블릿은 클라이언트로부터 요청을 받고 응답을 클라이언트에 반환할 수 있는 클래스입니다.<br> 실제로 서블릿은 Java에서 클라이언트-서버 아키텍처를 만드는 데 쓰인다. 즉, 클라이언트의 요청과 응답에 대한 전처리,후처리 담당함.
![image](https://github.com/Jung-MinGi/ComputerScience/assets/118701129/6042ad7b-0842-48e0-90f6-fecec96da43b)

출처 김영한 스프링MVC1편<br>
위 그림에서 녹색부분을 제외한 모든 부분을 서블릿 컨테이너가 담당한다.
![image](https://github.com/Jung-MinGi/ComputerScience/assets/118701129/f702467a-7e1d-4264-b468-9668f56c5fa0)
서블릿 컨테이너가 소켓을 열고 http메세지를 받아들여 파싱해주고 이를 HttpServleRequest객체로 만들어 request에 적절한 서블릿에세 파라미터로 넘겨준다.<br>
이후 개발자는 해당 요청을 처리하고 HttpServleResponse객체에 값을 담아주면 컨테이너가 다시 후처리후 client로 넘겨준다.
