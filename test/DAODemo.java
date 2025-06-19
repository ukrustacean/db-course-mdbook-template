import java.util.List;

public class DAODemo {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();

        System.out.println("== Додавання користувачів ==");
        userDAO.addUser(new User(0, "Іван", "ivan@example.com", null));
        userDAO.addUser(new User(0, "Олена", "olena@gmail.com", null));
        userDAO.addUser(new User(0, "Марія", "maria@gmail.com", null));

        System.out.println("\n== Всі користувачі ==");
        List<User> allUsers = userDAO.getAllUsers();
        for (User u : allUsers) {
            System.out.println(u);
        }

        System.out.println("\n== Пошук користувача з ID = 1 ==");
        User user = userDAO.getUserById(1);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("⚠️ Користувача з ID = 1 не знайдено.");
        }

        System.out.println("\n== Оновлення користувача з ID = 2 ==");
        User userToUpdate = userDAO.getUserById(2);
        if (userToUpdate != null) {
            userToUpdate.setName("Іван Оновлений");
            userDAO.updateUser(userToUpdate);
            System.out.println("✅ Оновлено: " + userToUpdate);
        } else {
            System.out.println("⚠️ Користувача з ID = 2 не знайдено.");
        }

        System.out.println("\n== Пошук по імені або email ==");
        List<User> filtered = ((UserDAOImpl) userDAO).findByNameOrEmail("Марія", "olena@gmail.com");
        for (User u : filtered) {
            System.out.println(u);
        }
    }
}
