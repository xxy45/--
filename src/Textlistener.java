import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Textlistener implements DocumentListener{

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO �Զ����ɵķ������
		String data = DateChooser.showDate1.getText();
		DateChooser.showDate2.setText(data);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	

}
