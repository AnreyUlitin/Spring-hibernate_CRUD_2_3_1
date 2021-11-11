package website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import website.model.User;
import website.service.UserService;
import javax.annotation.PostConstruct;

@Component
public class UserData {

    @Autowired
    private final UserService userService;


    public UserData(UserService userService) {
        this.userService = userService;
    }
    @PostConstruct
    public void userInit() {
       User user1 = new User();
       user1.setName("Name1");
        user1.setLastName("LastName1");
        user1.setEmail("name1lastname1@mail.ru");
        user1.setPhoneNumber("87456211399");
        userService.addUser(user1);

        User user2 = new User();
        user2.setName("Name2");
        user2.setLastName("LastName2");
        user2.setEmail("name2lastname2@mail.ru");
        user2.setPhoneNumber("849995632178");
        userService.addUser(user2);

        User user3 = new User();
        user3.setName("Name3");
        user3.setLastName("LastName3");
        user3.setEmail("name3lastname3@mail.ru");
        user3.setPhoneNumber("89165467923");
        userService.addUser(user3);
    }

}
