# 지하철 노선도 미션
- 지하철 역과 노선을 관리하는 지하철 노선도 기능을 구현한다.

## 구현할 기능 목록

### 사용자 입력 클래스 -> InputView
- [ ] 메인 화면 번호를 입력받는 기능 - readMainMenu
- [ ] 역 관리 화면 번호를 입력받는 기능 - readStationMenu
- [ ] 노선 관리 화면 번호를 입력받는 기능 - readLineMenu
- [ ] 구간 관리 화면 번호를 입력받는 기능 - readSectionMenu
- [ ] 지하철 역 이름을 입력받는 기능 - readStationName
- [ ] 지하철 노선의 이름을 입력받는 기능 - readLineName
- [ ] 지하철 구간 순서를 입력받는 기능 - readSectionOrder

### 출력 클래스 -> OutputView
#### 메인 화면 관련 기능
- [ ] 역 목록 출력 - printStations
- [ ] 노선 목록 출력 - printLines
- [ ] 지하철 노선도 출력 - printSubwayMap

### 메인 관리 enum -> MainMenu
STATION_MANAGEMENT, LINE_MANAGEMENT, SECTION_MANAGEMENT, QUIT

### 역 관리 enum -> StationMenu
STATION_ADD, STATION_DELETE, STATION_LIST, BACK

### 노선 관리 enum -> LineMenu
LINE_ADD, LINE_DELETE, LINE_LIST, BACK

### 구간 관리 enum -> SectionMenu
SECTION_ADD, SECTION_DELETE, BACK

### 지하철 역 이름 클래스 -> StationName
- [x] 역 이름을 받아 역 이름 클래스를 반환하는 기능 - of
- [x] 지하철 역 이름 예외처리 validStationName
  - [x] 지하철 역 이름은 공백이 들어갈 수 없다. - validIncludeBlank
  - [x] 지하철 역 이름은 '역'으로 끝나야 한다. - validSuffixStationName
  - [x] 지하철 역 이름은 2글자 이상이어야 한다. - validStationNameLength

### 지하철 노선 이름 클래스 -> LineName
- [x] 노선 이름을 받아 역 이름 클래스를 반환하는 기능 - of
- [x] 지하철 역 이름 예외처리 validLineName  
  - [x] 지하철 노선 이름은 공백이 들어갈 수 없다. - validIncludeBlank
  - [x] 지하철 노선 이름은 '역'으로 끝나야 한다. - validSuffixLineName
  - [x] 지하철 노선 이름은 2글자 이상이어야 한다. - validLineNameLength

### 지하철 역 -> Station
- [x] 이름을 받아 역 객체를 생성하여 반환하는 기능 -> of

### 지하철 노선 -> Line
- [ ] 노선 이름을 받아 노선 객체를 생성하여 반환하는 기능 -> of
- [ ] 상행 종점역과 하행 종점역으로 초기화 하는 기능 -> initLine
- [ ] 지하철 노선의 지정된 순서에 역을 등록하는 기능 - addStationToLineByOrder
  - [ ] 이미 등록되어있는 역인지 확인하는 기능 - validStationDuplicate
  - [ ] 등록 가능한 순서인지 확인하는 기능 - validSectionIndex
- [ ] 특정 역이 노선에 속해있는지 확인하는 기능 - isStationBelongToLine
- [ ] 노선에 등록되어있는 역을 삭제하는 기능 - deleteStation
- [ ] 노선에 등록되어있는 역의 개수를 반환하는 기능 - numberOfStationsInLine
- [ ] 노선에 등록되어있는 역의 이름들을 반환하는 기능 - findStationNamesByLine

### 메인 메뉴 관련 기능 -> MainController

#### 역 관리 관련 기능 -> StationController
- [ ] 지하철 역을 등록하는 기능 실행 - runAddStation
- [ ] 지하철 역을 삭제하는 기능 실행 - runDeleteStation


#### 노선 관리 관련 기능 -> LineController
- [ ] 지하철 노선을 등록하는 기능 실행 - runAddLine
- [ ] 지하철 노선을 삭제하는 기능 실행 - runDeleteLine

#### 구간 관리 관련 기능 -> SectionController
- [ ] 지하철 노선을 등록하는 기능 실행 - runAddSection
- [ ] 지하철 노선을 삭제하는 기능 실행 - runDeleteSection

### 지하철 노선도 관련 기능 -> MapController
- [ ] 지하철 노선도를 출력하는 기능 실행 - start


### Service
#### 역 관리 관련 기능 -> StationService
- [ ] 지하철 역을 등록하는 기능 - addStation
- [ ] 지하철 역을 삭제하는 기능 - deleteStation
- [ ] 지하철역의 리스트를 조회하는 기능 - getStationNames

#### 노선 관리 관련 기능 -> LineService
- [ ] 지하철 노선을 등록하는 기능 addLine
- [ ] 지하철 노선을 삭제하는 기능 - deleteLine
- [ ] 지하철 노선의 리스트를 조회하는 기능 -getLineNames

#### 구간 관리 관련 기능 -> SectionService
- [ ] 지하철 구간을 등록하는 기능 addSection
- [ ] 지하철 구간을 삭제하는 기능 - deleteSection
- [ ] 지하철 노선에 2개 이상의 역이 있는지 확인하는 기능 - checkLineContainOverTwoStation

### 지하철 역 저장소 -> StationRepository
- [ ] 지하철 역 저장소에 등록하는 기능 - addStation
  - [ ] 존재하는 역인지 확인하는 기능 - isExistsStation
- [ ] 지하철 역을 저장소에서 삭제하는 기능 - deleteStation
- [ ] 등록된 역 리스트를 반환하는 기능 - getStationsName
- [ ] 역 이름으로 역 객체를 찾아 반환하는 기능 - findStationByName
- [ ] 초기 데이터로 세팅 - init

### 지하철 노선의 저장소 -> LineRepository
- [ ] 지하철 노선 저장소에 등록하는 기능 - addLine
  - [ ] 존재하는 노선인지 확인하는 기능 - isExistsLine
- [ ] 지하철 노선을 저장소에서 삭제하는 기능 - deleteLine
- [ ] 등록된 노선 리스트를 반환하는 기능 - getLineNames
- [ ] 노선 이름으로 노선 객체를 찾아 반환하는 기능 - findLineByName
- [ ] 등록된 모든 노선의 역들을 반환하는 기능 - getSubwayMap
- [ ] 노선에 속해있는 역인지 확인하는 기능 - isStationBelongToLine
- [ ] 초기 데이터로 세팅 - init