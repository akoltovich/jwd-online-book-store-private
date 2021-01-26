import com.epam.jwd_online_book_store.domain.User;
import com.epam.jwd_online_book_store.dto.UserDTO;
import com.epam.jwd_online_book_store.exception.UserException;
import com.epam.jwd_online_book_store.service.AdminService;
import com.epam.jwd_online_book_store.service.UserService;

public class Main {
    public static void main(String[] args) {
//        BookCRUD crud = new BookCRUDImpl();
//        crud.create(new Book("Some", "Auth", 22.5, 2, "horror", null));
//        for (Book book : crud.findAll()) {
//            System.out.println(book.toString());
//        }
//        crud.update(4,new Book("Scary", "Author", 255.5, 4, "drama", "Hello"));
//        System.out.println(crud.findById(4));
//        UserDAO crud = new UserDAOImpl();
//        User user = new User("nadya.s@t-v.by", "fdawr1Qq", "ffss", "dsff", 1);
//        if (UserValidator.isValid(user)) {
//            crud.create(user);
//        } else {
//            System.out.println("Nope");
//        }
//        System.out.println(crud.findById(1).toString());
//        for (User user : crud.findAll()) {
//            System.out.println(user.toString());
//            crud.update(1,new User("login23", "password23", "leha23", "kolt23", 2));
//        BookOrderCRUD crudOrder = new BookOrderCRUDImpl();
//        crudOrder.create(new BookOrder(new Date(2010,10,10),3,1,
//                new Date(2020,10,10),"Completed"));
//        crudOrder.update(4,new BookOrder(new Date(2010,12,12),3,1,
//                new Date(2020,12,12),"Failed"));
//        UserService service = UserService.getInstance();
//        User user = service.registration(new UserDTO("login23@mama.ru", "password23", "leha", "kolt", 2,false));
//        UserService userService = UserService.getInstance();
//        try {
//            User user = userService.registration(new UserDTO("nadya@xdfhcdgfh.xcbfd", "password23", "leha", "kolt", 2,false));
//        } catch (UserException e) {
//            e.printStackTrace();
//        }
//        AdminService adminService = AdminService.getInstance();
//        UserDTO userD = null;
//        try {
//            userD = adminService.getUserByLogin("nadya.s@t-v.by");
//        } catch (UserException e) {
//            e.printStackTrace();
//        }
//        System.out.println(userD.toString());
    }
}
