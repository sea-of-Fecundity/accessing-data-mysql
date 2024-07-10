# 프로젝트 소개
spring과 DB연결 하는 방법을 실습하는 프로젝트 입니다.

# 연결하는 방법
간단한 프로젝트이므로 ddl-auto는 update로 설정했다. url에 맞는 값과 username, password, 사용하는 Driver 종류를 입력하면 된다. 

주의점) password는 ' ' 로 감싸줘야 error가 발생하지 않는다.
~~~ java
spring:
  jpa:
    hibernate:
      ddl-auto: update
  datasource:
    url: jdbc:mariadb://localhost:3306/testsecurity
    username: testsecurity
    password: '0000'
    driver-class-name: org.mariadb.jdbc.Driver
~~~

# 테스트 코드 바로가기
[MainControllerTest](src/test/java/com/example/accessingdatamysql/controller/MainControllerTest.java)

