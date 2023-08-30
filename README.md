# 고투게더 리뉴얼 프로젝트
 여행상품 판매사이트인 고투게더 사이트에서 필요하다고 생각할만한 기능들을 UIUX 프론트엔드 백엔드 3팀이 회의를 통해 산출 한 뒤 적용시킨 리뉴얼 프로젝트 입니다.

# 프로젝트 기간
 2023-03-17 ~ 2023-04-10

# 프로젝트에서 사용된 기술 
<div align="center">
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/springsecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white">
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
<img src="https://img.shields.io/badge/postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white">
<img src="https://img.shields.io/badge/hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white">
<img src="https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white">
<img src="https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=redis&logoColor=white">
<br>
  </div>
  
# 협업툴
<div align="center">
<img src="https://img.shields.io/badge/slack-4A154B?style=for-the-badge&logo=slack&logoColor=white">
<img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<br>
</div>

# BE-조원
역할|이름|깃헙주소
---|---|---|
조장|이강훈|https://github.com/hoonii2
조원1|최병옥|https://github.com/ChoiByungok
조원2|차승준|https://github.com/Chaseungjun

# ERD
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FWkm0L%2Fbtr8jOqL5ra%2FbcvFjmZgZc1gDaE6n6yziK%2Fimg.png">

# 내가 맡은 기능
## 상품 검색 api 및 상품 상세정보 api
 상품 검색조건에 따라서 동적으로 SQL을 생성해야 하는상황에서 queryDsl 라이브러리를 사용하여 동적쿼리를 생성했습니다.
 https://github.com/ChoiByungok/Final_Project_BE_Fork/blob/develop/src/main/java/com/fc/final7/domain/product/repository/query/CategoryRepositoryImpl.java

## 예약 api
 예약도 여러개의 여행상품을 받을 수 있어야 하고 여행 상품도 여러개의 예약을 가질 수 있어야 하는 다대다 관계를
 중간에 매핑 테이블을 두어서 일대다 다대일 관계로 풀어서 해결했습니다.
 <br>
 https://quddhr9523.tistory.com/65

