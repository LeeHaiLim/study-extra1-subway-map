# 지하철 노선도 미션
- 지하철 역과 노선을 관리하는 지하철 노선도 기능을 구현한다.

## 구현할 기능 목록

### 사용자 입력 클래스 -> InputView
- [ ] 원하는 기능을 입력받는 기능 - readServiceNumber
- [ ] 지하철 역의 이름을 입력받는 기능 - readStationName
- [ ] 지하철 노선의 이름을 입력받는 기능 - readLineName
- [ ] 지하철 노선의 상행 종점을 입력받는 기능 - readFirstStationName
- [ ] 지하철 노선의 하행 종점을 입력받는 기능 - readLastStationName
- [ ] 지하철 구간 추가 순서를 입력받는 기능 - readSectionOrder

### 출력 클래스 -> OutputView
#### 메인 화면 관련 기능
- [ ] 메인 화면 안내 문구 출력 - printMainMenu

#### 역 관리 관련 기능
- [ ] 역 등록 안내 문구 출력 `[INFO] 지하철 역이 등록되었습니다.` - printAddStationMessage
- [ ] 역 삭제 안내 문구 출력 `[INFO] 지하철 역이 삭제되었습니다.` - printDeleteStationMessage
- [ ] 역 목록 출력 - printStations
- 
- #### 노선 관리 관련 기능
- [ ] 노선 등록 안내 문구 출력 `[INFO] 지하철 노선이 등록되었습니다.` - printAddLineMessage
- [ ] 노선 삭제 안내 문구 출력 `[INFO] 지하철 노선이 삭제되었습니다.` - printDeleteLineMessage
- [ ] 노선 목록 출력 - printLines

#### 구간 관리 관련 기능
- [ ] 구간 등록 안내 문구 출력 `[INFO] 구간이 등록되었습니다.` - printAddSectionMessage
- [ ] 구간 삭제 안내 문구 출력 `[INFO] 구간이 삭제되었습니다.` - printDeleteSectionMessage

### 서비스 관리 인터페이스 -> MenuManagement
- [x] 존재하는 서비스의 번호인지 확인하는 기능 - isExistsServiceNumber

### 메인 관리 enum -> MainManagement
STATION_MANAGEMENT, LINE_MANAGEMENT, SECTION_MANAGEMENT, QUIT, NONE

### 역 관리 enum -> StationManagement
STATION_ADD, STATION_DELETE, STATION_LIST, BACK, NONE

### 노선 관리 enum -> LineManagement
LINE_ADD, LINE_DELETE, LINE_LIST, BACK, NONE

### 구간 관리 enum -> SectionManagement
SECTION_ADD, SECTION_DELETE, BACK, NONE

### 지하철 역 이름 클래스 -> StationName
- [x] 역 이름을 받아 역 이름 클래스를 반환하는 기능 - of
- [x] 지하철 역 이름 예외처리 validStationName
  - [x] 지하철 역 이름은 공백이 들어갈 수 없다. - validIncludeBlank
  - [x] 지하철 역 이름은 '역'으로 끝나야 한다. - validSuffixStationName
  - [x] 지하철 역 이름은 2글자 이상이어야 한다. - validStationNameLength

### 지하철 노선 이름 클래스 -> LineName
- [ ] 노선 이름을 받아 역 이름 클래스를 반환하는 기능 - of
- [ ] 지하철 노선의 이름은 2글자 이상이어야 한다. - validLineNameLength

### 지하철 역 -> Station
- [ ] 이름을 받아 역 객체를 생성하여 반환하는 기능 -> of
- [ ] 지나는 노선을 등록하는 기능 - addLineBelongToStation### 지하철 역 -> Station

### 지하철 노선 -> Line
- [ ] 노선 이름을 받아 노선 객체를 생성하여 반환하는 기능 -> of
- [ ] 지하철 노선의 지정된 순서에 역을 등록하는 기능 - addStationToLineByOrder

### 지하철 역 관련 기능 -> StationController
- [ ] 지하철 역을 등록하는 기능 - addStation
- [ ] 지하철 역을 삭제하는 기능 - deleteStation
  - [ ] 존재하는 역인지 확인하는 기능 - isExistsStation
  - [ ] 노선에 등록된 역인지 확인하는 기능 - isStationBelongToLine
- [ ] 지하철 역의 목록을 조회하는 기능 - showStations

### 지하철 노선 관련 기능 -> LineController
- [ ] 지하철 노선을 등록하는 기능 - addLine
  - [ ] 지하철 노선의 이름은 중복될 수 없다. - validLineNameDuplicate
  - [ ] 상행 종점과 하행 종점이 존재하는지 확인하는 기능 - isExistsStation
- [ ] 지하철 노선을 삭제하는 기능 - deleteLineByName
- [ ] 지하철 노선의 목록을 조회하는 기능 - showLines

### 지하철 구간 관련 기능 -> SectionController
#### 지하철 구간 추가 기능 (노선에 역을 추가하는 기능)
- [ ] 노선에 역을 추가하는 기능 - addStationInLine

#### 지하철 구간 삭제 기능
- [ ] 노선에 포함된 역이 두 개 이하인지 확인하는 기능 - isLineHas
  - [ ] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다. - validNumberOfStation

### 지하철 노선에 등록된 역 조회 기능
- [ ] 노선의 상행 종점부터 하행 종점까지 연결된 순서대로 역 목록을 조회하는 기능 - showStationBelongToLine()


### 지하철 역 저장소 -> StationRepository
- [ ] 지하철 역 저장소에 등록하는 기능 - addStation
- [ ] 존재하는 역인지 확인하는 기능 - isExistsStation
- [ ] 지하철 역을 저장소에서 삭제하는 기능 - deleteStationByName
- [ ] 노선에 등록된 지하철 역을 저장속에서 삭제하는 기능 - deleteBelongToLineStationByName
- [ ] 등록된 역 이름 리스트를 반환하는 기능 - getStationNames

### 지하철 노선의 저장소 -> LineRepository
- [ ] 지하철 노선 저장소에 등록하는 기능 - addLine
- [ ] 지하철 노선을 저장소에서 삭제하는 기능 - deleteLineByName
- [ ] 존재하는 노선인지 확인하는 기능 - isExistsLine
- [ ] 노선에 포함된 역의 갯수를 반환하는 기능 - findNumberOfStation
- [ ] 등록된 노선 이름 리스트를 반환하는 기능 - getLineNames
- [ ] 등록된 노선에 속한 역 이름을 반환하는 기능 - getLineAndStations
- [ ] 지하철 노선의 지정된 순서에 역을 등록하는 기능 - addStationToLineByOrder

<br>

### 초기 설정
- 프로그램 시작 시 역, 노선 등 필요한 정보를 미리 셋팅할 수 있다.

> 아래의 사전 등록 정보로 반드시 초기 설정을 하기

```
 1. 지하철역으로 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역이 등록되어 있다.
 2. 지하철 노선으로 2호선, 3호선, 신분당선이 등록되어 있다.
 3. 노선에 역이 아래와 같이 등록되어 있다.(왼쪽 끝이 상행 종점)
   - 2호선: 교대역 - 강남역 - 역삼역
   - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
   - 신분당선: 강남역 - 양재역 - 양재시민의숲역
 ```