För att spela spelet:
 1. Klona projektet till din dator
 2. Öppna en terminal och ställ dig i projektets root
 3. Skriv in: ./mvnw spring-boot:run
 4. Öppna en webbläsare och klistra in url:
 http://localhost:8080/arcade/playBoxes/[ggr som spelet ska spelas]/[namn på tävlande]
 ex på url:
 http://localhost:8080/arcade/playBoxes/500/Jessica
 5. Gör refresh i webbläsaren för att köra igen

Förvaltning:
Ska det gå att spela några andra spel är det bara att lägga till en ny tjänst i GameRestController,
skapa en ny tjänst för att spela det nya spelet.
