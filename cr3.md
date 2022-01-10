1. W klasie SelectUserNumbers
   1. ifTypedNumberSelectedBefore(typedNumber) nie if, a is ;)
   2. numbershandler/selector/UserNumbersSelector.java:45 nie musi istnieć jeśli używasz Seta (sprawdzasz czy set sie nie zapełnił. 
      Set nie przechowuje duplikatów). Wtedy nie potrzebujesz flagi ifAddSelectedNumber
   3. boolean ifTypedNumberIsOutOfRange(int typedNumber, int LOWEST_NUMBER, int HIGHEST_NUMBER) - nazwy argumentów metod zawsze piszemy camelCase
      tylko stałe w Javie robimy CAPSEM
   4. sprobuj zastosowac odwrocenie zaleznosci w dla klasy InputReceiver, teraz klasa SelectUserNumbers za bardzo zalezy od implementacji InputReceiverScanner, 
      co jesli chciałbym napisac teraz nową implementację interfejsu InputReceiver? Muszę zmieniać wnętrze klasy SelectUserNumbers, żeby podmienić implementacje.
      tak samo dla MessagesPrinter
2. zdecydowanie za duzo pakietów :) niepotrzebnie zaciemnia (mala aplikacja). Raczej nie nazywamy pakietów welcomer, resulter. 
klasa albo będzie Serwisem (wykonuje operacje np. Printer) albo danymi (PrintResult), a pakiet mógłby się nazywać print, configuration, input. 
Pakiet nazwij bardziej domenowo i tam wrzucaj wszystkie klasy. To jest punkt startowy -> pakiet sie nazywa "input" do niego wrzucasz wszystko co zwiazane z inputem
np. zamiast numbershandler to pakiet o nazwie "numbers" ale jest to już za bardzo granularne pakietowanie. myślę, że jak przejdziemy do Springa to łatwiej to będzie wytłumaczyć
3. testy
   1. trzymaj konwencje
   2. __?
   3. nazwa metody na starcie testu co to za konwencja? troche nieczytelna
   4. numbershandler/selector/UserNumbersSelectorTests.java:44 tak nie powinno być (DI)
   5. //  when
      //  then 
      nie musisz pisać
   6. (LN + 1), (LN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN + 6) mocno zaciemnia input jaki ma byc zwrocony
   7. nie trzeba moockować inputreceiver jesli napiszesz implementacje testową (pomoże w tym DI)
   8. spróbujemy napisać DSL'a dla given i assertów, żeby łatwiej sie czytało
