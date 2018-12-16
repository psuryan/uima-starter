# UIMA application example
Sample [UIMA](https://uima.apache.org/) application with [Gradle](https://gradle.org/) build. The famous [RoomNumberAnnotator](https://uima.apache.org/doc-uima-annotator.html) example from UIMA documentation is used. The project has the following structure 

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

## Running the example
1. Clone the repository to your local machine `git clone https://github.com/psuryan/uima-starter`
2. Set your `$GRADLE_HOME` and make sure that `$GRADLE_HOME/bin` is in the `$PATH`
3. Change your current working directory to `uima-starter`
4. Build the code: `gradle clean build`
5. Run the sample application `gradle runApp`. Your output would look something like the following 
```err
<uima.tcas.DocumentAnnotation:0>
Location        Capacity        Wall Phone Ext.
Classroom Style
  HAW J2-B34    Seats 12        tieline 863-3130
  HAW J2-N07    Seats 24        tieline 863-3210
  YKT 20-001    Seats 36        tieline 862-4304
  YKT 20-051    Seats 18        tieline 862-4307</uima.tcas.DocumentAnnotation:242>
<com.psuryan.uima_starter.model.RoomNumber:167>20-001</com.psuryan.uima_starter.model.RoomNumber:173>
<com.psuryan.uima_starter.model.RoomNumber:208>20-051</com.psuryan.uima_starter.model.RoomNumber:214>
```
