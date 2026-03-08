@echo off
setlocal
echo ==========================================
echo   AbleAssist: Build, Install, and Launch
echo ==========================================

:: Add your local platform-tools to PATH for adb access
set "PATH=%PATH%;C:\Users\Administrator\Projects\AbleAssist\platform-tools-latest-windows\platform-tools"

:: Set JAVA_HOME to your specific JDK 21 installation path
set "JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-21.0.6.7-hotspot"
set "PATH=%JAVA_HOME%\bin;%PATH%"

echo [System] Using JDK at "%JAVA_HOME%"
java -version

:: Check for local.properties
if not exist "local.properties" (
    echo [ERROR] Android SDK not found. 
    echo Please create 'local.properties' and set sdk.dir=C:\\Users\\Administrator\\AppData\\Local\\Android\\Sdk
    pause
    exit /b 1
)

:: 1. Build and Install the Debug APK
echo [Step 1/3] Building and installing APK for module :app...
cmd /c gradlew.bat :app:installDebug

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo [ERROR] Build failed.
    pause
    exit /b %ERRORLEVEL%
)

:: 2. Launch the MainActivity
echo [Step 2/3] Launching AbleAssist...
adb shell am start -n "com.ableassist/com.ableassist.ui.MainActivity"

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo [ERROR] Failed to launch the app.
    pause
    exit /b %ERRORLEVEL%
)

echo [Step 3/3] Done! The app is now running.
pause
