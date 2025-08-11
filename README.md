## ✅ 1. SQL 데이터베이스 설정

### 1-1. MySQL 서버 실행
### 1-2. 데이터베이스 생성
`CREATE DATABASE gangwon14_db;`
### 1-3. SQL 덤프 파일 불러오기
1. `gangwon14_db`에 접속
2. 프로젝트에 제공된 SQL 덤프 파일(`.sql`)을 실행
#### 예시 (터미널에서 실행 시):
`mysql -u [사용자명] -p gangwon14_db < path/to/dumpfile.sql`

또는 MySQL Workbench 등을 이용해 `.sql` 파일을 수동으로 실행 (제일 간편)

---

## ⚙️ 2. `application.properties` 설정
`src/main/resources/application.properties` 파일 설정

`spring.datasource.url=jdbc:mysql://localhost:3306/gangwon14_db?useSSL=false&serverTimezone=Asia/Seoul spring.datasource.username=YOUR_USERNAME   # ← 실제 사용자명 입력 spring.datasource.password=YOUR_PASSWORD   # ← 실제 비밀번호 입력`

> 💡 _MySQL 사용자 이름과 비밀번호는 본인 PC 환경에 맞게 수정

---

## 🚀 3. 프로젝트 실행

### 방법 1. IntelliJ IDEA 사용 시
1. `Bikenav-backend` 프로젝트를 IntelliJ로 연다다
2. `BikenavBackendApplication` 또는 `Application` 클래스를 실행
3. 콘솔에 **Spring Boot 로고**와 함께 포트 8080으로 서버가 기동되면 성공
    

### 방법 2. Gradle 사용 시 (터미널)
`./gradlew bootRun`

또는 Windows 환경에서는:

`gradlew.bat bootRun`

---

## 🧪 4. 테스트 가능한 API 목록

---

### 📍 4.1 코스 목록 조회

-  **Endpoint**: `/api/course/list`
- **Method**: `GET`
- **Query Parameters (Optional)**:
    - `type`: string ("walk" | "bike")
     ※ **기존 `"자전거"`, `"산책"` 대신 `"walk"`, `"bike"`로 변경**
    - `diff`: string ("상(1)" | "중(2)" | "하(3)")
    - `recommended`: boolean
- **Response**:
  ```json
  {
	"success": true,
	"data": [
	{
      "course_id": number,
      "title": "string",
      "dist_km": number,
      "time": number,
      "image": "string",      // thumbnail_url → "image" 로 변경
      "diff": number,
      "recommended": true
      "type" : "string"  // "walk" | "bike"
    }
   ]
  }
```

---

### 📍 4.2 코스 상세 정보 조회

- **Endpoint**: `/api/course/{courseId}`
- **Method**: `GET`
- **Response**:
  ```json
  {
  "success": true,
  "data": {
    "course_id": number,
    "title": "string",
    "dist_km": number,
    "time": number,
    "path": [                       // 좌표 배열, 위도 경도 2개 이상
      { "lat": number, "lng": number }
    ],
    "diff": number,                // 난이도 (1: 상, 2: 중, 3: 하)
    "type": "walk" | "bike",      // 앱과 일치하도록 명확히 지정
    "description": "string",
    "images": [
      {
        "url": "string",
        "is_main": boolean
      }
    ],
    "tags": ["string"],

    // 추가: 관광 포인트 리스트 (이름만 또는 더 상세 가능)
    "tourist_spots": [
      "string",
      "string"
    ],

    // 추가: 주변 상권 리스트 (상권명 배열)
    "nearby_businesses": [
      "string",
      "string"
    ]
  },
  "message": "코스 상세 정보 조회 성공"
}
```

### 📍 4.3 POI 조회 (상권조회)

- **Endpoint**: `/api/course/{courseId}/pois`
- **Method**: GET
- **Query Parameters (Optional)**:
	- `category`: string (`biz(상권), util(편의시설), tourist(관광지)`)
- **Response**:
  ```json
  {
  "success": true,
  "data": {
    "pois": [
      {
        "id": number,
        "name": "string",
        "type": "biz" | "util" | "tourist",
        "point": {
          "lat": number,
          "lng": number
        },
        "explanation": "string"
      }
    ]
  },
  "message": "코스 주변 POI 조회 성공"
}
  ``` 

### 📍 4.4 상권 상세 조회

- **Endpoint**: `/api/course/{courseId}/pois/{place_id}'
- **Method**: `GET`
- **Response**:
  ```json
{
  "success": true,
  "data": {
    "place_id": number,
    "name": "string",
    "type": "string",
    "addr": "string",
    "hour": "string",
    "rate": number,
    "tel" : "string",
    "tag" : [
    {"tag": "string"}
    ], 
    "images": [
      {
        "url": "string",
        "is_main": boolean
      }
    ]
  },
  "message": "상권 상세 정보 조회 성공"
}
  ``` 

---

## 🧩 참고 사항

- 서버 기본 포트는 **8080**
- API 테스트는 **Postman**, **REST Client**, 또는 브라우저(`GET` 요청만 가능)에서 직접 가능