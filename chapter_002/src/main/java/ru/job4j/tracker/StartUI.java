package ru.job4j.tracker;

/**Класс реализующий работу с tracker.
 * В консоли предлагаем пользователю меню для работы с tracker.
 * В зависимости от выбора пользователя проводим изменения, дополнения, просмотры в tracker.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.09.2018
 *@version 0.1
 */
public class StartUI {
    private static final String ADD = "0";
    private static final String ALL = "1";
    private static final String EDIT = "2";
    private static final String DEL = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Работа с меню.
     */
    public void play() {
        boolean exit = false;
        while (!exit) {
            menu();
            String answer = this.input.ask("Enter the number: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (ALL.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DEL.equals(answer)) {
                this.deleteItem();
            } else if (FINDID.equals(answer)) {
                this.findId();
            } else if (FINDNAME.equals(answer)) {
                this.findName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Создание новой заявки.
     */
    private void createItem() {
        System.out.println("========== Add new item ==========");
        String name = this.input.ask("Enter name: ");
        String description = this.input.ask("Enter description: ");
        long create = System.currentTimeMillis();
        Item item = new Item(name, description, create);
        this.tracker.add(item);
        System.out.println("===== New item with id: " + item.getId() + " =====");
    }

    /**
     * Показ всех заявок.
     */
    private void showAll() {
        System.out.println("========== All items =========");
        for (Item item : this.tracker.findAll()) {
            System.out.println("Name: " + item.getName()
                            + " Description: " + item.getDescription()
                            + " Id " + item.getId()
                    );
        }
        System.out.println("==============================");
    }

    /**
     * Редактирование заявки по id.
     */
    private void editItem() {
        System.out.println("========== Edit item =========");
        String id = this.input.ask("Enter id: ");
        String name = this.input.ask("Enter name: ");
        String description = this.input.ask("Enter description: ");
        long create = System.currentTimeMillis();
        Item item = new Item(name, description, create);
        this.tracker.replace(id, item);
        System.out.println("==============================");
    }

    /**
     * Удаление заявки по id.
     */
    private void deleteItem() {
        System.out.println("======== Delete item =========");
        String id = this.input.ask("Enter id: ");
        this.tracker.delete(id);
        System.out.println("==============================");
    }

    /**
     * Поиск заявки по id.
     */
    private void findId() {
        System.out.println("====== Find item by Id =======");
        String id = this.input.ask("Enter id: ");
        Item result = this.tracker.findById(id);
        if (result != null) {
            System.out.println("Item found:\n\r" + "Name: " + result.getName()
                    + " Description: " + result.getDescription()
                    + " Id " + result.getId()
            );
        }
        System.out.println("==============================");
    }

    /**
     * Поиск заявок по имени.
     */
    private void findName() {
        System.out.println("====  Find items with name ====");
        String name = this.input.ask("Enter name: ");
        for (Item item : this.tracker.findByName(name)) {
            System.out.println("Name: " + item.getName()
                    + " Description: " + item.getDescription()
                    + " Id " + item.getId()
            );
        }
        System.out.println("==============================");
    }

    /**
     * Вывод меню на консоль.
     */
    private void menu() {
        String[] menuList = {
                "0. Add new Item", "1. Show all items", "2. Edit item",
                "3. Delete item", "4. Find item by Id", "5. Find items by name",
                "6. Exit Program", "Select:"
        };
        for (String index : menuList) {
            System.out.println(index);
        }
    }

    /**
     * Запуск программы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).play();
    }
}