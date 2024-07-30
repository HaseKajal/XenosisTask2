
 import java.util.ArrayList;
import java.util.Scanner;

// Main game class
public class SimpleGame {
    public static void main(String[] args) {
        GameWorld gameWorld = new GameWorld();
        gameWorld.startGame();
    }
}

// Player class
class Player {
    String name;
    int health;
    int score;
    ArrayList<Item> inventory;

    Player(String name) {
        this.name = name;
        this.health = 100;
        this.score = 0;
        this.inventory = new ArrayList<>();
    }

    void addItem(Item item) {
        inventory.add(item);
        System.out.println(item.name + " added to inventory.");
    }

    void displayInventory() {
        System.out.println("Inventory:");
        for (Item item : inventory) {
            System.out.println(item.name);
        }
    }
}

// Enemy class
class Enemy {
    String name;
    int health;

    Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }
}

// Item class
class Item {
    String name;

    Item(String name) {
        this.name = name;
    }
}

// GameWorld class
class GameWorld {
    Player player;
    ArrayList<Enemy> enemies;
    ArrayList<Item> items;
    Scanner scanner;

    GameWorld() {
        scanner = new Scanner(System.in);
        enemies = new ArrayList<>();
        items = new ArrayList<>();
        initializeWorld();
    }

    void initializeWorld() {
        enemies.add(new Enemy("Goblin", 30));
        enemies.add(new Enemy("Orc", 50));
        items.add(new Item("Health Potion"));
        items.add(new Item("Sword"));
    }

    void startGame() {
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        System.out.println("Welcome to the game, " + player.name + "!");

        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("Choose an action: move, fight, inventory, quit");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "move":
                    move();
                    break;
                case "fight":
                    fight();
                    break;
                case "inventory":
                    player.displayInventory();
                    break;
                case "quit":
                    gameRunning = false;
                    System.out.println("Thank you for playing!");
                    break;
                default:
                    System.out.println("Invalid action. Try again.");
            }

            if (player.health <= 0) {
                System.out.println("You have died. Game Over.");
                gameRunning = false;
            }
        }
    }

    void move() {
        System.out.println("You moved to a new location.");
        if (Math.random() < 0.5) {
            findItem();
        }
    }

    void findItem() {
        if (!items.isEmpty()) {
            Item item = items.remove(0);
            player.addItem(item);
        } else {
            System.out.println("No items found.");
        }
    }

    void fight() {
        if (!enemies.isEmpty()) {
            Enemy enemy = enemies.remove(0);
            System.out.println("You encountered a " + enemy.name + "!");

            while (enemy.health > 0 && player.health > 0) {
                System.out.println("Choose an action: attack, flee");
                String action = scanner.nextLine().toLowerCase();

                if (action.equals("attack")) {
                    enemy.health -= 10;
                    player.health -= 5;
                    System.out.println("You attacked the " + enemy.name + "!");
                    System.out.println(enemy.name + " health: " + enemy.health);
                    System.out.println("Your health: " + player.health);
                } else if (action.equals("flee")) {
                    System.out.println("You fled from the " + enemy.name + ".");
                    enemies.add(enemy);
                    break;
                } else {
                    System.out.println("Invalid action. Try again.");
                }
            }

            if (enemy.health <= 0) {
                System.out.println("You defeated the " + enemy.name + "!");
                player.score += 10;
                System.out.println("Your score: " + player.score);
            }
        } else {
            System.out.println("No enemies to fight.");
        }
    }
}
