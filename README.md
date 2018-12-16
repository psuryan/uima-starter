# uima-starter
Sample UIMA based application with Gradle build. The famous "RoomNumberAnnotator" example from UIMA is used. The project has the following structure 

```
src
├── main
│   ├── descriptors
│   │   ├── ae
│   │   │   └── RoomNumberAnnotator.xml
│   │   └── type_system
│   │       └── RoomNumber_BuildingTypeSystem.xml
│   ├── java
│   │   └── com
│   │       └── psuryan
│   │           └── uima_starter
│   │               ├── ae
│   │               │   └── RoomNumberAnnotator.java
│   │               ├── driver
│   │               │   └── UimaInProcessDriver.java
│   │               └── model
│   │                   ├── RoomNumber.java
│   │                   └── RoomNumber_Type.java
│   └── resources
└── test
    ├── java
    └── resources
build.gradle
gradle.properties
README.md
```
