package minigames;

public class Main {

    public static void main(String[] args) {
        DrawNumbers drawNumbers = new DrawNumbers("Lotek",
                "Gracz typuje 6 liczb, następuje losowanie 6 liczb i sprawdzenie czy gracz trafił.");

        System.out.println("Witaj w aplikacji Mini Gry.");
        System.out.println("Poniżej wyświetlona jest lista gier.");
        //kod wyświetlający listę gier do wyboru

        //gramy od razu w Lotka
        drawNumbers.operateGame();
    }
}
