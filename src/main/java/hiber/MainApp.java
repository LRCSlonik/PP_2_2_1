package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Vlad", "Ivanov", "VIvanov@gmail.com");
      User user2 = new User("Ivan", "Petrov", "IPetrov@gmail.com");
      User user3 = new User("Jon", "Malek", "JMalek@gmail.com");
      User user4 = new User("Roman", "Sidorov", "RSidorov@gmail.com");

      Car bmv = new Car("BMW",5);
      Car audi = new Car("Audi",4);
      Car mercedes = new Car("Mercedes",3);
      Car honda = new Car("Honda",2);


      userService.add(user1.setCar(bmv).setUser(user1));
      userService.add(user2.setCar(audi).setUser(user2));
      userService.add(user3.setCar(mercedes).setUser(user3));
      userService.add(user4.setCar(honda).setUser(user4));

      for (User user : userService.listUsers()) {
         System.out.printf("%s %s\n", user, user.getCar());
      }

      context.close();
   }
}
