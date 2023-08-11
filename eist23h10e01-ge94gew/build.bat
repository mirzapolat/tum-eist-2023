@REM # Compile the project

call ./gradlew clean build

@REM # Build the image

call docker build -t eist-ngrok .

@REM # Fire up the containers

call docker compose up -d