package com.amigoscode.user;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserFileDataAccessService implements UserDAO {
    @Override
    public List<User> getUsers() {
        File file = new File("src/main/java/com/amigoscode/users.csv");
//        File file = new File(getClass().getClassLoader().getResource("users.csv").getPath());

        /*
            Size 4 because I know there are 4 entries in src/users.csv
            If you add more rows in the file update the size of the initial array too
        */
        List<User> users = new ArrayList<>();

        // read example
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] split = scanner.nextLine().split(",");
                users.add(new User(UUID.fromString(split[0]), split[1]));
            }
            return users;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
