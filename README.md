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
 
 (동적쿼리를 생성하는데 queryDsl 라이브러리를 사용한 이유)<br>
 JPA에서 사용하는 Jpql이라는 문법은 문자열로 구성되어 있습니다.<br>
 동적쿼리를 사용할 시 Jpql문자열을 분기에 따라 조립해야 하는데<br>
 문자열이다 보니 오타가 날 확률이 높고 컴파일상에서 오류를 체크할 수 없을 뿐더러<br>
 코드의 가독성이 많이 떨어지는 단점이 있습니다.<br>
```
     public List<MemberTeamDTO> search(MemberSearchCondition condition) {
        return queryFactory
                .select(new QMemberTeamDTO(
                        member.id.as("memberId"),
                        member.username,
                        member.age,
                        team.id.as("teamId"),
                        team.teamName))
                .from(member)
                .leftJoin(member.team, team)
                .where(
                        usernameEq(condition.getUsername()),
                        teamNameEq(condition.getTeamName()),
                        ageGoe(condition.getAgeGoe()),
                        ageLoe(condition.getAgeLoe())
                )
                .fetch();
    }

```
```
    private BooleanExpression usernameEq(String username) {
        return StringUtils.hasText(username) ? member.username.eq(username) : null;
    }

    private BooleanExpression teamNameEq(String teamName) {
        return StringUtils.hasText(teamName) ? team.teamName.eq(teamName) : null;
    }

    private BooleanExpression ageGoe(Integer ageGoe) {
        return ageGoe != null ? member.age.goe(ageGoe) : null;
    }

    private BooleanExpression ageLoe(Integer ageLoe) {
        return ageLoe != null ? member.age.loe(ageLoe) : null;
    }

```
하지만 queryDsl을 사용하면 마치 sql을 사용하는 것처럼 가독성이 좋고<br>
심지어 자바 문법으로 되어있어 문법이 틀리면 컴파일상에서 오류를 잡을 수 있습니다.<br>
where문에 검색조건을 넣으면 동적으로 쿼리가 나가게 되는데<br>
그 이유가 null값은 그냥 무시하기 때문입니다.<br>
검색 조건을 위의 코드처럼 메서드로 만들어놓으면 재사용이 가능하다는 장점이 있습니다.<br>

## 예약 api
 예약도 여러개의 여행상품을 받을 수 있어야 하고 여행 상품도 여러개의 예약을 가질 수 있어야 하는 다대다 관계를
 중간에 매핑 테이블을 두어서 일대다 다대일 관계로 풀어서 해결했습니다.
 <br>
 https://quddhr9523.tistory.com/65

