package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TopMenu extends JPanel {

	public TopMenu() {
		JMenuItem i1;
		JMenuBar mb = new JMenuBar();
		i1 = makeItem("Save");
		mb.add(i1);
		this.add(mb);
	}

	private JMenuItem makeItem(String text) {
		JMenuItem item = new JMenuItem(text);

		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Controller.saveImage();
			}
		});

		return item;
	}

}
