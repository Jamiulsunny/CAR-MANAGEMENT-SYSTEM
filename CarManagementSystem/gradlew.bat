@echo off
REM Simple gradlew.bat stub: uses local gradle if present.
where gradle >nul 2>nul
IF %ERRORLEVEL% EQU 0 (
  gradle %*
) ELSE (
  echo gradle not found. Please install Gradle or run with an IDE that provides Gradle support.
  exit /b 1
)
