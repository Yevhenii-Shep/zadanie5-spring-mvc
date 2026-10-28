# Staffbook – Zadanie 5 (Spring Boot MVC CRUD)

Spring Boot MVC aplikácia nad tabuľkou `employee`, ktorá umožňuje:

- zobrazenie všetkých zamestnancov (`GET /employees`)
- detail jedného zamestnanca (`GET /employees/{id}`)
- pridanie nového zamestnanca (`GET /employees/create`, `POST /employees`)
- úpravu existujúceho zamestnanca (`GET /employees/{id}/edit`, `POST /employees/{id}`)
- odstránenie zamestnanca (`POST /employees/{id}/delete`)

## Architektúra

Trojvrstvová architektúra podľa seminára:

| Vrstva | Trieda / súbor |
| --- | --- |
| Prezentačná | `controller/EmployeeController`, `controller/HomeController`, šablóny `templates/employees/list.html`, `view.html`, `form.html` |
| Aplikačná | `service/EmployeeService` |
| Dátová | `repository/EmployeeRepository`, entita `entity/Employee` |

## Hodnoty z properties súboru

V `src/main/resources/application.properties`:

- `employee.job-titles` – 12 pracovných pozícií pre **drop-down list** (`job_title`)
- `employee.employment-types` – typy úväzku pre **radio buttony** (`full_time`):
  `Full-time`, `Part-time`, `Contract`, `Intern/Trainee`

Controller ich načíta cez `@Value` a vloží do Modelu, šablóna `form.html` ich dynamicky vykreslí cez `th:each`.
Stĺpec `full_time` je `TINYINT`, preto sa v DB ukladá číselný kľúč (`1` = Full-time, `0` = Part-time, `2` = Contract, `3` = Intern/Trainee).

## Navyše

- validácia vstupov (Jakarta Validation) s chybovými hláškami vo formulári
- kontrola, že pozícia a typ úväzku sú z povolených hodnôt
- vlastný dizajn, vlastný potvrdzovací dialóg pri mazaní, vyhľadávanie v zozname
- flash správy po pridaní / úprave / odstránení, stránka 404

## Spustenie

1. V XAMPP spustite MySQL a importujte `database/employee_directory.sql` (phpMyAdmin → Import).
2. Spustite aplikáciu: `./mvnw spring-boot:run`
3. Otvorte <http://localhost:8080>

Ak port 8080 používa Apache z XAMPP, spustite aplikáciu na inom porte:
`./mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8081`
