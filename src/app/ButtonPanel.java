package app;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {

	private JLabel labeTrans = new JLabel("Transparency: 1,00");;
	private JLabel labeStroke = new JLabel("Stroke: 10,00");;

	private Controller con;

	public ButtonPanel(Controller con) {

		this.con = con;

		this.add(makeButBox());
		this.add(makeSliderBox());
	}

	private Box makeSliderBox() {
		Box sliderBox = Box.createVerticalBox();

		sliderBox.add(labeTrans);
		sliderBox.add(makeSlider(true));

		sliderBox.add(labeStroke);
		sliderBox.add(makeSlider(false));
		
		return sliderBox;
	}

	private JSlider makeSlider(boolean trans) {

		JSlider out = new JSlider(1, 99, 99);

		ChangeListener ls = (trans) ? new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				if (e.getSource() == out) {

					Frame.currentTrans = (float) (out.getValue() * .01);

					labeTrans.setText("Transparency : " + String.format("%.1f", Frame.currentTrans));

				}

			}
		} : new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				if (e.getSource() == out) {

					Frame.currentStroke = (float) (out.getValue() * .10);

					labeStroke.setText("Stroke : " + String.format("%.2f", Frame.currentStroke));

				}

			}
		};

		out.addChangeListener(ls);
		return out;

	}

	private Box makeButBox() {
		Box buttonBox = Box.createHorizontalBox();
		
		buttonBox.add(makeIOBut("./src/download.png", true));
		buttonBox.add(makeIOBut("./src/upload.png", false));
		
		buttonBox.add(makeButton("./src/brush.png", 1, false));
		buttonBox.add(makeButton("./src/pen.png", 2, false));
		buttonBox.add(makeButton("./src/oval.png", 3, false));
		buttonBox.add(makeButton("./src/square.png", 4, false));

		buttonBox.add(makeButton("./src/paint-palette.png", 5, true));
		buttonBox.add(makeButton("./src/bucket.png", 6, true));
		
		return buttonBox;
	}

	private JButton makeButton(String path, int button, boolean color) {

		JButton but = basicButton(new JButton(), path);

		but.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (!color) {

					Frame.currentBut = button;

				} else {

					if (button == 5) {

						Frame.strokeColor = JColorChooser.showDialog(null, "Pick a Stroke", Color.BLACK);

					}
					if (button == 6) {

						Frame.fillColor = JColorChooser.showDialog(null, "Pick a Fill", Color.BLACK);

					}
				}

			}

		});
		return but;

	}

	private JButton makeIOBut(String path, boolean save) {

		JButton but = basicButton(new JButton(), path);

		ActionListener ls = (save) ? new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				con.saveImage();
			}
		} : new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				con.loadImage();
			}
		};

		but.addActionListener(ls);

		return but;
	}

	private JButton basicButton(JButton but, String icon) {
		Icon ico = new ImageIcon(icon);

		but.setMargin(new Insets(10, 10, 10, 10));
		but.setIcon(ico);
		but.setOpaque(false);
		but.setBackground(new Color(116, 143, 158));
		but.setBorderPainted(true);

		return but;
	}
}
