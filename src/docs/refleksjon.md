
# Refleksjon rundt prosjektet 

I dette prosjektet har jeg fått brukt flere sentrale deler av pensum. En viktig del av prosjektet er bruken av klasser og innkapsling. Jeg har laget klassene Expense og BudgetManager, hvor hver klasse har ansvar for sin egen tilstand og funksjonalitet. For eksempel lagrer Expense informasjon om en enkelt utgift, mens BudgetManager håndterer en samling av utgifter og utfører beregninger som total bruk og resterende budsjett. Dette viser tydelig hvordan objekter kan representere data og samtidig inneholde relevant logikk. 

I tillegg er applikasjonen bygget opp rundt flere klasser med andre ansvarsområder, som for eksempel FileHandler og BudgetApp. 

Jeg har også brukt interface gjennom implementasjonen av Comparable i Expense-klassen. Dette gjør det mulig å sortere utgifter basert på beløp. I tillegg har jeg laget en egen comparator klasse, ExpenseComparatorByName, for å sortere alfabetisk. Dette viser hvordan man kan bruke ulike strategier for sammenlikning og sortering, og hvordan interfaces kan bidra til en mer fleksibel kode. 

FileHandler klassen håndterer lesing og skriving til fil. Her konverteres objekter manuelt til tekstformat og tilbke igjen, noe som gir en bedre forståelse for hvordan data kan lagres og hentes uten bruk av innebygde serialiseringsverktøy. Denne klassen er separert fra de andre klassene, noe som gjør koden mer strukturert og lettere å vedlikeholde. 

Når det gjelder andre deler av pensum, som arv, er dette ikke brukt direkte i prosjektet. En mulig utvidelse kunne vært å lage en superklasse, for eksempel en generell Transaction-klasse som både inntekter og utgifter kunne arves fra. Dette hadde gjort koden mer utvidbart. 

Koden er strukturert etter Model-View-Controller-prinsippet. Modellene består av klassen Expense og BudgetManager, som håndterer data og logikk. View er implementert med JavaFX gjennom FXML-filen, som definerer brukergrensesnittet. BudgetApp fungerer som startpunktet for applikasjonen. Controlleren fungerer som et bindeledd mellom disse, og håndterer brukerinput og oppdaterer modellen og viewet. Selv om strukturen følger MVC-prinsippet, er det noen svakheter. Blant annet at noe logikk kunne vært enda tydeligere plassert i modellene i stedet for i controlleren. Likevel er hovedideen bak MVC godt ivaretatt. 

Testingen har vært en viktig del av prosessen. Jeg har skrevet enhetstester for viktige metoder i BudgetManager, som å legge til utgifter, beregne total bruk og resterende budsjett. I tillegg har jeg laget en test for filhåndtering, hvor jeg tester at utgifter kan lagres og lastes fra fil korrekt. Jeg har valgt å teste både normale tilfeller og noen spesielle tilfeller, som tom liste og ugyldige verdier. Jeg har ikke testet GUI delen av programmet, da dette ikke var et krav. I stedet har jeg fokusert på å teste logikken i modellen, siden det er dette jeg har fokusert på. 

Gjennom prosjektet har jeg fått en bedre forståelse av hvordan man bygger opp en større applikasjon med flere deler som samarbeider. Dette har jeg aldri gjort før. Spesielt har jeg lært mer om hvordan man strukturere kode, håndterer data, og skriver tester for å sikre at programmet fungerer som forventet.  



## Bruk av KI

I arbeidet med dette prosjektet har jeg brukt KI som et hjelpemiddel for å forstå konsepter og få veiledning underveis. KI har ikke blitt brukt til å generere hele løsninger, men heller som støtte for å forklare ting jeg syntes var vanskelig, som for eksempel filhåndtering, testing og bruk av interfaces.

Jeg har hovedsakelig brukt KI til å stille spørsmål når jeg sto fast, og til å få eksempler på hvordan ulike deler kunne implementeres. Deretter har jeg selv tilpasset og skrevet koden slik at jeg forstår hva som skjer. KI har derfor fungert mer som en læringsressurs enn som en direkte løsning på oppgavene.

Jeg har ikke prøvd mange ulike modeller, men brukt én modell gjennom hele prosjektet. Bruken av KI har i stor grad vært tidsbesparende, men også nyttig for å få en dypere forståelse av pensum. Spesielt i deler som filhåndtering og testing, hvor jeg i utgangspunktet hadde ekstremt lite erfaring, har KI vært til stor hjelp.

Gjennom prosjektet har jeg blitt mer bevisst på hvordan KI kan brukes som et verktøy i læring. Jeg ser at det kan være svært nyttig for å forklare konsepter og gi retning, men at det fortsatt er viktig å forstå og skrive koden selv for å lære mest mulig. 

## DIAGRAM

![Diagram](image.png)
Ingen spesielle antakelser. Expense klassen står i sentrum og har relasjoner med alle andre klasser. 
