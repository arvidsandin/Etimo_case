import java.util.HashMap;

public class UserInterface{
    static Store store = new Store();
    static HashMap<String, Command> commands = new HashMap<>();
    static boolean isrunning = true;
    public static void main(String[] args) {
        initCommands();

        while(isrunning){
            String input = "";
            while(input.length() == 0){
                System.out.print(">");
                input = System.console().readLine();
            }
            String commandString = getCommand(input);
            if (commands.containsKey(commandString)) {
                Command command = commands.get(commandString);
                command.run(input.substring(1));
                continue;
            }
            System.out.println("Okänt kommando. Tillgängliga kommandon är:");
            System.out.println("SX: Sälj X antal, t.ex. \"S5\" eller \"S12\"");
            System.out.println("IX: Inleverera X antal, t.ex. \"I5\" eller \"I12\"");
            System.out.println("L: Visa aktuellt lager");
            System.out.println("A: Avsluta programmet");
        }
    }

    private static String getCommand(String input){
        return input.substring(0, 1);
    }

    private static void sell(String input) {
        try {
            int number = Integer.parseInt(input); 
            int inventory = store.sell(number);
            System.out.println("Sålde " + number + " från lagret. Det finns nu " + inventory + " i lagret.");
        } catch (NumberFormatException e) {
            System.out.println("Vänligen skriv endast siffror efter \"S\" för att sälja från lagret.");
        }catch (EmptyInventoryException e) {
            System.out.println("Du försökte sälja fler än vad som finns på lagret. Det finns endast " + store.getInventory() + " st.");
        }
    }

    private static void deliver(String input) {
        try {
            int number = Integer.parseInt(input); 
            int inventory = store.procure(number);
            System.out.println("Inlevererade " + number + " till lagret. Det finns nu " + inventory + " i lagret.");
        } catch (NumberFormatException e) {
            System.out.println("Vänligen skriv endast siffror efter \"I\" för att sälja från lagret.");
        }
    }

    private static void showInventory() {
        System.out.println("Det finns " + store.getInventory() + " på lagret.");
    }


    private static void initCommands(){
        commands.put("S", new Command() {
            @Override
            public void run(String input) {
                sell(input);
            }
        });
        commands.put("I", new Command() {
            @Override
            public void run(String input) {
                deliver(input);
            }
        });
        commands.put("L", new Command() {
            @Override
            public void run(String input) {
                showInventory();
            }
        });
        commands.put("A", new Command() {
            @Override
            public void run(String input) {
                isrunning = false;
            }
        });
    }
}


