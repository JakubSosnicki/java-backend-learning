# Java Backend – Tydzień 1

**Poziom:** podstawowy  
**Data:** 27 października 2026  
**Łączny czas:** 60–120 minut

W tym tygodniu zaczynamy od programowania obiektowego (OOP) i podstaw kolekcji. Zbudujesz dwa niewielkie moduły systemów biznesowych, podobne do tych, które później mogą stanowić podstawę aplikacji Spring Boot.

## Zadanie 1. System zarządzania magazynem

**Tematy:** OOP, konstruktory, enkapsulacja  
**Czas:** 30–45 min

**Cel:** Stwórz aplikację konsolową pozwalającą zarządzać stanem magazynowym pojedynczego produktu.

### Wymagania

1. Utwórz klasę `Product` z prywatnymi polami `id`, `name`, `price`, `quantity`.
2. Dodaj konstruktor inicjalizujący wszystkie pola.
3. Utwórz metodę `addStock(int amount)` zwiększającą ilość towaru.
4. Utwórz metodę `removeStock(int amount)` zmniejszającą ilość, ale tylko wtedy, gdy jest wystarczający zapas.
5. Dodaj metodę `getInventoryValue()` zwracającą wartość zapasu (cena × ilość).
6. Nadpisz `toString()`, aby czytelnie wyświetlać produkt.
7. Zadbaj, aby cena i ilość nie mogły przyjmować wartości ujemnych, a operacje magazynowe wymagały dodatniej liczby sztuk. Dla niepoprawnych operacji rzuć `IllegalArgumentException`.

### Przykładowe dane testowe

**Produkt początkowy:**

| Pole | Wartość |
| --- | --- |
| ID | 101 |
| Nazwa | Klawiatura |
| Cena | 150,00 zł |
| Ilość | 10 szt. |

| Operacja | Oczekiwany stan / wynik |
| --- | --- |
| Początkowy | 10 szt. |
| `addStock(5)` | 15 szt. |
| `removeStock(3)` | 12 szt. |
| `removeStock(20)` | Błąd, pozostaje 12 szt. |
| `getInventoryValue()` | 1800 zł |

### Kryteria poprawności

- [ ] Pola klasy są prywatne i dostępne przez odpowiednie metody.
- [ ] Dodawanie i odejmowanie stanów działa poprawnie.
- [ ] Nie można uzyskać ujemnego stanu magazynowego.
- [ ] Niepoprawne dane powodują wyjątek bez zmiany stanu produktu.
- [ ] Wartość magazynowa jest prawidłowo obliczana.

**0/5 spełnionych kryteriów**

> **Wskazówka:** W metodzie `removeStock()` najpierw sprawdź, czy operacja jest dozwolona, a dopiero później zmieniaj wartość `quantity`. Dzięki temu błędna operacja nie zmieni stanu obiektu.

## Zadanie 2. Koszyk sklepu internetowego

**Tematy:** OOP, ArrayList, iteracja  
**Czas:** 45–60 min

**Cel:** Zbuduj prosty koszyk zakupowy, który przechowuje produkty, oblicza wartość zamówienia i pozwala usuwać produkty.

### Wymagania

1. Utwórz klasę `CartItem` z polami `productName`, `unitPrice`, `quantity`.
2. Utwórz klasę `ShoppingCart`, która przechowuje produkty w `ArrayList<CartItem>`.
3. Dodaj metodę `addItem(CartItem item)` dodającą pozycję do koszyka.
4. Dodaj metodę `removeItem(String productName)` usuwającą pozycję o podanej nazwie.
5. Dodaj metodę `calculateTotal()` zwracającą łączną wartość koszyka.
6. Dodaj metodę `printCart()` wyświetlającą produkty i ich wartości.
7. Zabezpiecz aplikację przed ujemną ceną, zerową lub ujemną ilością i dodaniem `null`. Przyjmij, że nazwy produktów są unikalne, a próba dodania duplikatu powoduje `IllegalArgumentException`.

### Przykładowe dane testowe

| Produkt | Cena | Ilość | Wartość |
| --- | ---: | ---: | ---: |
| Mysz | 80 zł | 2 | 160 zł |
| Klawiatura | 150 zł | 1 | 150 zł |
| Monitor | 900 zł | 1 | 900 zł |
| **Razem** | | | **1210 zł** |

Po wykonaniu `removeItem("Klawiatura")` wartość koszyka powinna wynosić **1060 zł**.

Dodatkowo sprawdź przypadki: pusty koszyk (suma 0 zł), usunięcie nieistniejącego produktu (bez zmiany koszyka) oraz próba dodania produktu z ilością `-2` (błąd).

### Kryteria poprawności

- [ ] Produkty są przechowywane w ArrayList.
- [ ] Można dodawać i usuwać produkty.
- [ ] Suma uwzględnia cenę jednostkową i ilość każdej pozycji.
- [ ] Pusty koszyk i usuwanie nieistniejącego produktu działają poprawnie.
- [ ] Nie można dodać niepoprawnej ani zduplikowanej pozycji.

**0/5 spełnionych kryteriów**

> **Wskazówka:** W `calculateTotal()` użyj pętli `for-each` i zmiennej sumującej. Przy usuwaniu produktu możesz wykorzystać `removeIf()`. Nie potrzebujesz jeszcze Stream API.

## Jak pracować z zadaniami?

Użyj Java 17 lub 21 i dowolnego IDE, np. IntelliJ IDEA. Każde zadanie wykonaj w osobnym projekcie konsolowym. Do testowania na razie wystarczy metoda `main()`.

Gdy ukończysz zadania, prześlij mi kod. Sprawdzę go pod kątem poprawności, OOP, czytelności i dobrych praktyk. W kolejnych tygodniach będziemy rozwijać te umiejętności, przechodząc do bardziej złożonych kolekcji, interfejsów, Generics i obsługi wyjątków, a następnie do Spring Boot.
