import com.splitwise.model.User;
import com.splitwise.service.ExpenseManager;
import com.splitwise.split.EqualSplit;
import com.splitwise.split.SplitType;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        User u1 = new User("1", "A", "a@mail.com");
        User u2 = new User("2", "B", "b@mail.com");
        User u3 = new User("3", "C", "c@mail.com");

        ExpenseManager manager = new ExpenseManager();

        manager.addExpense(
                u1,
                300,
                Arrays.asList(
                        new EqualSplit(u1),
                        new EqualSplit(u2),
                        new EqualSplit(u3)
                ),
                SplitType.EQUAL
        );

        manager.showBalances();

    }
}