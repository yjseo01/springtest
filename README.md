# Chapter 05. 스프링 시큐리티와 OAuth 2.0으로 로그인 기능 구현하기

스프링 시큐리티

- 막강한 인증(Authentication)과 인가(Authorization) 기능을 가진 프레임워크
- 스프링 기반 애플리케이션에서는 보안을 위한 표준

spring-security-oauth2-autoconfigure 라이브러리 대신 Spring Sequrity Oauth2 Client 라이브러리 사용

- spring-security-oauth 프로젝트는 유지 상태로 결정, 신규 기능은 새 oauth2 라이브러리에서만 지원
- 스프링 부트 용 라이브러리(starter) 출시
- 기존에 사용하던 방식은 확장 포인트가 적절하게 오픈 되어 있지 않아 직접 상속하거나 오버라이딩 해야 하고 신규 라이브러리의 경우 확장 포인트를 고려해서 설계된 상태

스프링 부트 1.5 방식에서는 url 주소를 모두 명시해야 하지만, 2.0 방식에서는 client 인증 정보만 입력하면 됨

1.5버전에서 직접 입력했던 값들은 2.0버전으로 오면서 모두 enum으로 대체됨
