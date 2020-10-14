

import java.sql.SQLException;

public class Application {

	public static void main(String[] args) {
		DAL dal = new DAL();
		View view = new View();
		view.setVisible(true);
		Controller controller = new Controller(view, dal);

		
	}

}
