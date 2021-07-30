import java.util.ArrayList;


public class ObserverTester {

	public static void main(String[] args) {
		ArrayList<Double> data = new ArrayList<Double>();

		data.add(new Double(33.0));
		data.add(new Double(44.0));
		data.add(new Double(22.0));
		data.add(new Double(22.0));

		DataModel model = new DataModel(data);

		TextFrame frame = new TextFrame(model);

		BarFrame barFrame = new BarFrame(model);

		model.attach(barFrame);
		model.attach(frame);
	}
}