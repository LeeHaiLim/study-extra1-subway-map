# 기능 목록

## 역 관련
> ### 지하철 역 Controller ClassName : StationController
> - [ ] 역 등록 - #createStation()
> - [ ] 역 삭제 - #deleteStation()
> - [ ] 역 조회 - #getStations()
> ---
> ### 지하철 역 Service ClassName : StationService()
> - [x] 역 등록하는 기능 - #createStation()
>    - 예외처리
>        - [x] 중복되는 이름이 있는가 - #isUniqueName()
>        - [x] 역 이름이 2글자 이상인가 - #isValidNameLength()
> - [ ] 역 삭제 기능 - #deleteStationByName()
>    - 예외처리
>      -[ ] 노선에 등록되어 있는지 확인 - #isRegisteredInLine()
>      -[ ] 등록되어 있는 역인지 확인 - #isRegistered
> - [x] 역 조회하는 기능 - #getStations()
> ---
> ### 지하철 역 Repository ClassName : StationRepository
> - [x] 역 등록하는 기능 - #saveStation()
> - [x] 역 조회하는 기능 - #findAllStations()
> - [ ] 역 삭제 기능 - #deleteStationByName()
> -[x] 역 이름으로 조회 - #findByName()
--- 
## 노선
> ### 노선 Controller ClassName : LineController
> -[ ] 노선 등록 - #createLine()
>   -[ ] 상행 종점 입력받기 - #getLineStart()
>   -[ ] 하행 종점 입력받기 - #getLineEnd()
> -[ ] 노선 삭제 - #deleteLine()
> -[ ] 노선 조회 - #getLines()
> ---
> ### 노선 Service ClassName : LineService
> -[ ] 노선 등록하는 기능 - #createLine()
>    - 예외처리
>        - [ ] 중복되는 이름이 있는가 - #isUniqueName()
>        - [ ] 노선 이름이 2글자 이상인가 - #isValidNameLength()
> -[ ] 노선 삭제 기능 - #deleteLine()
> -[ ] 노선 조회 기능 - #getLines()
> ### 노선 Repository ClassName :  LineRepository
> - [ ] 노선 등록하는 기능 - #saveLine()
> - [ ] 노선 삭제하는 기능 - #deleteLineByName()
> - [ ] 노선 조회 기능 - #findAllLines()
> - [ ] 노선 이름으로 조회 #findByName()
---
## 구간
> ### 구간 Service ClassName : SectionService
> -[ ] 구간 등록 - #registerSection()
> -[ ] 구간 삭제 - #deleteSection()

### 사용자의 입력을 담당하는 클래스 ClassName : InputView
> -[ ] 번호 입력 받기 - #readInteger()
> -[ ] 이름 입력 받기 - #readName()

## 출력을 담당하는 클래스 ClassName : XXXOutputView
> ### 지하철 역 관련 출력을 담당하는 클래스 ClassName : StationOutputView
> -[ ] 역 관리 화면 출력 - #printManagingPage()
> -[ ] 기능 선택 문구 출력 - #AskFunction()
> -[ ] 역 등록 이름 입력 요청 문구 출력 - #askStationsName()
> -[ ] 역 등록 완료 메시지 - #printSuccessMessage()
> -[ ] 역 목록 출력 - #printStations()
> ---
> ### 노선 관련 출력을 담당하는 클래스 Class Name : LineOutputView
> -[ ] 노선 관리 화면 출력 - #printManageingPage()
> -[ ] 기능 선택 문구 출력 - #AskFunction()
> -[ ] 노선 등록 이름 요청 문구 출력 - #askLineName()
> -[ ] 상행 종점 이름 요청 문구 출력 - #askLineStart()
> -[ ] 하행 종점 이름 요청 문구 출력 - #askLineEnd()
> -[ ] 완료 메시지 - #printSuccessMessage()
> -[ ] 노선 목록 출력 - #printLines()
> ---
> ### 구간 관련 출력을 담당하는 클래스
> -[ ] 구간 관리 화면 출력 - #printManagingPage()
> -[ ] 기능 선택 문구 출력 - #AskFunction()
> -[ ] 순서 입력 요청 문구 출력 - #AskPosition()
> -[ ] 완료 메시지 - #printSuccess()
 


