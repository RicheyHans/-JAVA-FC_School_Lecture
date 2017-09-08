
public class MemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = new Model();
		View view = new View();

		Control control = new Control(model, view);
		control.process();
	}
}
