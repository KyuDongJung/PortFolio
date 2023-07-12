<div align="center">
![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=250&section=header&text=Kyu&nbsp;Dong&nbsp;Jung&fontSize=90)
</div>
# PortFolio

<div align="center"><h2>Final Project</h2></div>

<div align="center">
<h2>Camp with Us</h2>
</div>
### 프로젝트 설명
- 캠핑장 검색 및 예약 웹사이트

### 개발 목적
- 꾸준히 늘어나는 캠핑 수요에 따라 쉽고 빠른 캠핑장 검색 및 예약을 돕는 사이트 개발

### 전체 기능
- 캠핑장 검색기능(고캠핑 Api이용)
- 캠핑장 예약 및 결제
- 회원 가입 및 로그인 기능(일반 및 소셜(구글, 네이버, 카카오)) - 일반회원, 관리자 회원
- 회원정보 수정, 탈퇴
- 게시글 작성, 수정, 삭제(여행지 추천 게시판, 캠핑 나눔 게시판, 자유게시판, 공지사항, 문의사항)
- 리뷰 작성, 수정, 삭제
- 캠핑장 정보조회(상세정보, 지도/위치, 날씨, 리뷰)
- 캠핑장 예약정보 작성 페이지(달력, 인원선택, 예약자 정보작성)
- 캠핑장 예약 결제(무통장, 카드결제 선택)
- 캠핑장 예약확인(예약, 예약대기, 취소)
- 추천 캠핑장


### 내가 맡은 역할
- 기상청 Api와 OpenWeather Api를 이용한 날씨정보 제작
  JavaScript에서 getJson 이용 중기, 단기예보 및 OpenWeather 날씨데이터 사용
  
- 예약정보입력 페이지
  달력 제작 및 달력 날짜 선택 기능, 날짜 계산 기능(시작 날짜와 종료 날짜 선택시 x박x일 로 자동계산)
  인원 선택 및 예약자 정보 자동입력(로그인 Session의 정보 가져오기)
  
- 선택한 숙박일수와 인원 선택에 따른 가격 계산
  선택한 월이 성수기(6, 7, 8월) or 비수기 에 따라 Ajax이용 DB에 저장된 성수기, 비수기 가격을 달리 가져옴
  선택한 인원을 LocalStorage에 담아 선택한 박 수와 함께 가격계산
  
- 예약정보 확인 페이지 및 결제방식 선택
  예약정보 입력후 예약하기 버튼 클릭시 form태그를 이용 정보확인 페이지로 넘겨줌
  - 넘겨주는 데이터 => 예약자 정보, 예약인원, 결제가격
  결제 방식(무통장 입금, 카드 결제) 선택
  무통장 입금 선택 시 cash결제 및 예약 대기 상태로 DB에 삽입
  카드결제 선택 시 card결제 및 예약 완료 상태로 DB에 삽입

- 결제 방식에 따른 예약상태 구분 및 관리자 로그인 시 예약 확정 기능
  관리자 계정으로 접속 시 모든 회원의 예약현황 조회 가능
  카드결제로 예약 완료된 내역은 예약으로 표시 및 취소가능
  무통장 입금으로 예약 대기 내역은 예약대기로 표시 및 최소가능
  입금 확인 시 예약 대기 내역을 예약 확정으로 전환 가능 => 취소및 예약 확정버튼 클릭시 DB에 업데이트.
  
<div align="center">
    	<h3>Tech Stack</h3>
	<h4>Languages</h4>
	<img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Java&logoColor=white" />
	<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=HTML5&logoColor=white" />
	<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=CSS3&logoColor=white" />
	<img src="https://img.shields.io/badge/javascript-F7DF1E?style=flat&logo=javascript&logoColor=white" />
	<img src="https://img.shields.io/badge/jQuery-0769AD?style=flat&logo=jquery&logoColor=white" />
</div>
<div align="center">
	<h4>DB</h4>
    <img src="https://img.shields.io/badge/Oracle SQL-F80000?style=flat&logo=oracle&logoColor=white" />
</div>
<div align="center">
 	<h4>Tools & Was</h4>
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=spring&logoColor=white" />
    <img src="https://img.shields.io/badge/eclipseIDE-2C2255?style=flat&logo=eclipseide&logoColor=white" />
    <img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat&logo=visualstudiocode&logoColor=white" />
    <img src="https://img.shields.io/badge/Tomcat-F8DC75?style=flat&logo=apachetomcat&logoColor=white" />
</div>
<div align="center">
	<h4>Collaborations</h4>
    <img src="https://img.shields.io/badge/amazon AWS-232F3E?style=flat&logo=amazonaws&logoColor=white"/>
    <img src="https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white" />
	<img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white" />
</div>


![Footer](https://capsule-render.vercel.app/api?type=waving&color=auto&height=200&section=footer)
  
