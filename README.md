# ua.tickets
Stack: Java, Gradle, Selenide, JUnit, Allure, HTMLTemplate. And based on Element Object pattern

Example of using Element Object with Selenide, Allure for booking ticket on tickets.ua site

1. Go to https://yadi.sk/d/ONWPb01QyCNcR
2. Download it and unzip to local disk C:
3. Go to Environment Variables
4. Create variables same as in file "variables.txt"
5. Open file "variables.txt"
6. Run following commands:

  `gradlew wrapper`
  
  `gradlew test`
  
  For open Allure report:
  
  `gradlew openReport`
