# Java Backend – Tydzień 2

**Poziom:** podstawowy+  
**Data:** 3 listopada 2026  
**Czas:** 90–120 minut łącznie

W pierwszym tygodniu stworzyłeś klasy `Product`, `CartItem` i `ShoppingCart`, ćwicząc enkapsulację, walidację oraz `ArrayList`. Teraz przechodzimy do interfejsów, polimorfizmu i kolekcji `Map` oraz `Set`.

Oba zadania wykonaj w JDK 25, bez Spring Boot i bez zewnętrznych bibliotek. Nie musisz jeszcze stosować Stream API.

## Zadanie 1. System płatności sklepu internetowego

**Tematy:** Interfejsy · Polimorfizm · OOP  
**Czas:** 45–60 min

**Cel:** Zbuduj moduł obsługujący różne sposoby płatności za zamówienia w sklepie internetowym.

### Wymagania

1. Utwórz interfejs `PaymentMethod` z metodą `boolean pay(double amount)`.
2. Utwórz dwie implementacje:
   - `CardPayment` – przechowuje dostępne saldo karty.
   - `BlikPayment` – przechowuje dostępne saldo konta oraz sześciocyfrowy kod BLIK.
3. W obu klasach metoda `pay()` powinna sprawdzić, czy kwota jest dodatnia i czy dostępne saldo wystarcza na płatność.
4. Poprawna płatność pomniejsza saldo i zwraca `true`. Brak środków powoduje zwrócenie `false`, bez zmiany salda.
5. Niepoprawna kwota (zero lub liczba ujemna) powoduje `IllegalArgumentException`.
6. W `BlikPayment` sprawdź poprawność kodu BLIK w konstruktorze. Kod musi składać się z dokładnie sześciu cyfr, również gdy zaczyna się od zera.
7. Utwórz klasę `PaymentProcessor`, której metoda `processPayment(PaymentMethod method, double amount)` obsługuje dowolną implementację interfejsu.

### Przykładowe dane testowe

| Metoda | Saldo początkowe | Płatność | Wynik |
| --- | --- | --- | --- |
| Karta | 500 zł | 200 zł | `true`, saldo 300 zł |
| Karta | 300 zł | 400 zł | `false`, saldo 300 zł |
| BLIK `012345` | 250 zł | 100 zł | `true`, saldo 150 zł |
| BLIK `123` | 250 zł | — | Błąd konstruktora |
| Karta | 500 zł | -20 zł | `IllegalArgumentException` |

### Kryteria poprawności

- [ ] Interfejs `PaymentMethod` jest zaimplementowany przez obie klasy.
- [ ] `PaymentProcessor` nie musi znać konkretnego typu płatności.
- [ ] Udana płatność prawidłowo zmniejsza saldo.
- [ ] Nieudana płatność nie zmienia salda.
- [ ] Niepoprawne kwoty i kody BLIK są odrzucane.

**0 z 5 kryteriów spełnionych**

> **Wskazówka**  
> Interfejs określa, co można zrobić, ale nie narzuca, jak to zrobić. Zastanów się, dlaczego `PaymentProcessor` powinien przyjmować `PaymentMethod`, a nie osobno `CardPayment` i `BlikPayment`.
>
> Kod BLIK najlepiej przechowywać jako `String`, nie `int`.

## Zadanie 2. System rezerwacji sal konferencyjnych

**Tematy:** HashMap · HashSet · Logika biznesowa  
**Czas:** 45–60 min

**Cel:** Stwórz prosty system zarządzania rezerwacjami sal w firmie, który uniemożliwia podwójną rezerwację tej samej sali w danym terminie.

### Wymagania

1. Utwórz klasę `MeetingRoom` z polami `id`, `name` i `capacity`.
2. Utwórz klasę `ReservationSystem` z kolekcjami:
   - `Map<Integer, MeetingRoom>` do przechowywania sal według identyfikatora.
   - `Map<Integer, Set<LocalDate>>` do przechowywania zajętych dat dla każdej sali.
3. Zaimplementuj `addRoom(MeetingRoom room)` – dodaje salę; duplikat ID jest niedozwolony.
4. Zaimplementuj `reserveRoom(int roomId, LocalDate date)` – rezerwuje salę na cały dzień i zwraca `true`, jeśli termin był wolny, albo `false`, jeśli był zajęty.
5. Zaimplementuj `cancelReservation(int roomId, LocalDate date)` – usuwa rezerwację i zwraca informację, czy istniała.
6. Zaimplementuj `isAvailable(int roomId, LocalDate date)` – sprawdza dostępność sali.
7. Próba użycia nieistniejącego ID sali albo daty `null` powinna powodować `IllegalArgumentException`. Sala musi mieć dodatnią pojemność.

Dla uproszczenia przyjmij, że rezerwacje są całodniowe, a daty przeszłe są dozwolone w danych testowych.

### Przykładowe dane testowe

**Dostępne sale**

| ID | Nazwa | Pojemność |
| --- | --- | --- |
| 1 | Sala A | 10 osób |
| 2 | Sala B | 20 osób |

**Operacje rezerwacji**

| Operacja | Oczekiwany wynik |
| --- | --- |
| Sala 1, 2026-11-10 | `true` |
| Sala 1, 2026-11-10 ponownie | `false` |
| Sala 2, 2026-11-10 | `true` |
| Anuluj salę 1, 2026-11-10 | `true` |
| Sprawdź salę 1, 2026-11-10 | `true` – dostępna |
| Rezerwuj salę 99 | `IllegalArgumentException` |

### Kryteria poprawności

- [ ] Sale przechowywane są w `Map` według ID.
- [ ] Zajęte daty przechowywane są w `Set`.
- [ ] Nie można dwukrotnie zarezerwować tej samej sali na ten sam dzień.
- [ ] Dwie różne sale mogą być zarezerwowane na ten sam dzień.
- [ ] Anulowanie zwalnia termin, a błędne ID i `null` są obsługiwane.

**5 z 5 kryteriów spełnionych**

> **Wskazówka**  
> `Set.add(element)` zwraca `true`, jeżeli element został dodany, oraz `false`, jeżeli już istniał. Ta właściwość może uprościć implementację rezerwacji.
>
> Przy pracy z `Map` przyjrzyj się metodom `get()`, `containsKey()` i `computeIfAbsent()`.

## Czego nauczysz się w tym tygodniu?

Pierwsze zadanie pokaże Ci, jak projektować kod otwarty na nowe implementacje, np. dodanie w przyszłości `PayPalPayment` bez przepisywania procesora płatności. Drugie nauczy Cię dobierania struktur danych do konkretnych problemów biznesowych.

Po wykonaniu obu zadań prześlij mi klasy do code review. Sprawdzę logikę, przypadki brzegowe, enkapsulację i sposób wykorzystania interfejsów oraz kolekcji. Nie musisz pisać wszystkiego idealnie za pierwszym razem — ważne, żebyś potrafił samodzielnie uzasadnić swoje decyzje projektowe.

W następnym tygodniu zwiększymy trudność, przechodząc do Generics i własnych wyjątków, nadal na przykładach aplikacji biznesowych.
