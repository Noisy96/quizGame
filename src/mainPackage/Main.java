package mainPackage;

import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.addPropertyChangeListener(new PropertyChangeListener() {
						@Override
						public void propertyChange(PropertyChangeEvent arg0) {
							System.out.println(arg0.getPropertyName());
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
