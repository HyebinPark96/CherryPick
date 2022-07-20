# [CherryPick] 
## SpringBoot Project (2022.07.11 ~ 진행중)
### 팀원 : 김서하, 박혜빈, 최효빈
### 사용스택 : HTML, CSS, JavaScript, jQuery, Ajax, MySQL, MyBatis, Spring Boot
### 주제 : 부산 전포동 대상 카페추천
### 상세기능
1. 회원 기능
- Spring Security 사용으로 인증 및 권한부여
- bcryptpasswordencoder 로 패스워드 암호화
- Ajax 비동기 통신을 이용한 회원가입 및 회원정보 수정 
- 북마크 / 리스트 커스터마이징
- SmartEditor 를 이용한 포토리뷰 작성
- 리뷰 데이터를 활용해 카페별 평균 웨이팅 시간 제공
2. 사업자 기능
- 신규 사업장 추가 및 수정
3. 관리자 기능
- 사업자 승인 / 미승인 관리
- 회원 및 사업장 관리
- 리뷰 관리
4. 기타 기능
- ErrorController 인터페이스를 구현하여 에러페이지 커스터마이징 및 HTTP status code별 설정
