Car Management System (Java Swing) - Gradle project

Requirements:
- Java 17+
- Gradle (if you want to use the included gradlew stubs they require a local gradle installation).
  -> Recommended: open the project in IntelliJ/VS Code and run via Gradle tool or use 'gradle run'.

How to run:
1) With Gradle installed:
   ./gradlew run     (on Linux/Mac)
   gradlew.bat run   (on Windows)

2) Or from an IDE:
   - Import the project as a Gradle project.
   - Run the application (main class: com.cms.Main)

Files of interest:
- src/main/java/com/cms/... (Java source)
- src/main/resources/db/init.sql  (DB schema)
- cms.db  (created automatically at runtime in the project working dir)

Notes:
- The project includes placeholder car images under src/main/resources/images.
- If you prefer a full Gradle wrapper, you can generate it using 'gradle wrapper' on your machine; the provided gradlew and gradlew.bat are simple stubs that call local 'gradle'.
