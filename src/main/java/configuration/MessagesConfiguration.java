package configuration;

public class MessagesConfiguration {

    public static final String LOST_INFORMATION = "Pudło. Niestety, nie trafiłeś w wylosowane liczby";
    public static final String WIN_INFORMATION = "Wygrałeś. Trafiłeś/aś we wszystkie wylosowane liczby";
    public static final String INTRODUCTION = "Witaj w grze Lotek. " +
            "\n Wpisz kolejno " + GameConfiguration.AMOUNT_OF_NUMBERS + " wytypowanych przez Ciebie liczb pomiędzy " + GameConfiguration.LOWEST_NUMBER + "-" + GameConfiguration.HIGHEST_NUMBER + "." +
            "\n Każdą wytypowaną liczbę zatwierdź ENTERem." +
            "\n Wciśnij ENTER aby rozpocząć grę.";
    public static final String GAME_ENTERED = "Powodzenia :)";
    public static final String PRINTED_DRAWN_NUMBERS = "- to wylosowane liczby";
    public static final String PRINTED_SELECTED_USER_NUMBERS = "- to Twoje wytypowane liczby";
    public static final String WRITE_NUMBER = "Podaj liczbę ";
    public static final String NUMBER_SELECTED_BEFORE = "Wytypowałeś już tę liczbę wcześniej. \nSpróbuj jeszcze raz";
    public static final String NUMBER_SELECTED_OUT_OF_RANGE = "Wytypowałeś liczbę spoza zakresu ";
    public static final String TRY_AGAIN = "\nSpróbuj jeszcze raz";
}
