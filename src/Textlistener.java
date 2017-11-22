import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Textlistener implements DocumentListener{

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO 自动生成的方法存根
		String data = DateChooser.showDate1.getText();
		DateChooser.showDate2.setText(data);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO 自动生成的方法存根
		
	}
	

}
