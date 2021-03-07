För att spela spelet:
 1. Klona projektet till din dator (måste ha Maven 3.2, och Java 1.8)
 2. Öppna en terminal och ställ dig i projektets root och skriv in: ./mvnw spring-boot:run
 eller öppna projektet i Intellij och kör ArcadeApplication
 4. Öppna en webbläsare och klistra in url:
 http://localhost:8080/arcade/playBoxesBothWays/[ggr som spelet ska spelas]/[namn på tävlande]
 ex på url:
 http://localhost:8080/arcade/playBoxesBothWays/500/Jessica
 5. Gör refresh i webbläsaren för att köra igen
 6. http://localhost:8080/arcade/playBoxesBothWays/result för att få alla resultat som finns i db

1. docker-compose up
2. Open browser:
 a. To play: http://localhost:8080/arcade/playBoxesBothWays/500/[your name]
 b. To get result: http://localhost:8080/arcade/playBoxesBothWays/result
