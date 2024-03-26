package org.homework.dev_module8;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        ClientService clientService = new ClientService(database);

        FlywayMigration flywayMigration = new FlywayMigration(database);
        flywayMigration.flywayMigrate();

        System.out.println(clientService.create("Daniil"));
        System.out.println(clientService.getById(8));

        clientService.setName(8, "Alex");
        System.out.println(clientService.getById(8));

        clientService.deleteById(8);
        System.out.println(clientService.getById(8));

        System.out.println(clientService.listAll());
    }
}
