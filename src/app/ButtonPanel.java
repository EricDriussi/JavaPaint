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

	JSlider transSlider = new JSlider(1, 99, 99);
	JSlider strokeSlider = new JSlider(1, 99, 99);

	JLabel labe = new JLabel("Transparency: 1,00");;
	JLabel labeStroke = new JLabel("Stroke: 10,00");;

	Box buttonBox = Box.createHorizontalBox();
	Box transBox = Box.createVerticalBox();
	Controller con;

	public ButtonPanel(Controller con) {

		this.con = con;

		buttonBox.add(makeIOBut("./src/download.png", true));
		buttonBox.add(makeIOBut("./src/upload.png", false));
		buttonBox.add(makeButton("./src/brush.png", 1, false));
		buttonBox.add(makeButton("./src/pen.png", 2, false));
		buttonBox.add(makeButton("./src/oval.png", 3, false));
		buttonBox.add(makeButton("./src/square.png", 4, false));

		buttonBox.add(makeButton("./src/paint-palette.png", 5, true));
		buttonBox.add(makeButton("./src/bucket.png", 6, true));

		transSlider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {

				if (e.getSource() == transSlider) {

					Frame.transparency = (float) (transSlider.getValue() * .01);

					labe.setText("Transparency : " + String.format("%.1f", Frame.transparency));

				}

			}
		});

		strokeSlider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {

				if (e.getSource() == strokeSlider) {

					Frame.stroke = (float) (strokeSlider.getValue() * .10);

					labeStroke.setText("Stroke : " + String.format("%.2f", Frame.stroke));

				}

			}
		});

		transBox.add(labe);
		transBox.add(transSlider);

		transBox.add(labeStroke);
		transBox.add(strokeSlider);

		this.add(buttonBox);

		this.add(transBox);
	}

	private JButton makeButton(String path, int button, boolean color) {

		JButton but = new JButton();
		Icon ico = new ImageIcon(path);

		but.setIcon(ico);
		but.setMargin(new Insets(10, 10, 10, 10));
		but.setOpaque(false);
		but.setBackground(new Color(116, 143, 158));
		but.setBorderPainted(true);
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

		JButton but = new JButton();
		Icon ico = new ImageIcon(path);

		but.setMargin(new Insets(10, 10, 10, 10));
		but.setIcon(ico);
		but.setOpaque(false);
		but.setBackground(new Color(116, 143, 158));
		but.setBorderPainted(true);
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
}
