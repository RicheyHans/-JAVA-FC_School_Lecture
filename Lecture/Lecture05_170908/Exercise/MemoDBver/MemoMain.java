
public class MemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModelWithDB model = new ModelWithDB();
		View view = new View();

		Control control = new Control(model, view);
		control.process();
	}

}
