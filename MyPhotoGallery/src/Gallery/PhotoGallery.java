package Gallery;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class PhotoGallery extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JTextField input;
	private JPanel panel;
	private WindowListener listener;
	private static List<ImageIcon> list = new ArrayList<>();
	private int currentIndex;
	private static File dir; //= new File("C:\\OOP\\MyPhotoGallery\\Images");
	static final String[] EXTENSTIONS = new String[] {"jpg", "png"};
	static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

		@Override
		public boolean accept(File dir, String name) {
			for (String ext : EXTENSTIONS) {
				if (name.endsWith(ext)) {
					return true;
				}
			}
			return false;
		}
		
	};
	
	public PhotoGallery() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700,400,700,700);
		panel = (JPanel) getContentPane();

		listener = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int response = JOptionPane.showConfirmDialog(panel, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (response == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else if (response == JOptionPane.NO_OPTION) {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
			
		};
		addWindowListener(listener);
		
		JButton load = new JButton("Load!");
		JToggleButton previous = new JToggleButton("<");
		JToggleButton next = new JToggleButton(">");
		
		input = new JTextField();

		JPanel northPanel = new JPanel();
		northPanel.add(load, BorderLayout.WEST);
		northPanel.add(input, BorderLayout.EAST);
		input.setColumns(10);
		
		panel.add(northPanel, BorderLayout.NORTH);
		
		JPanel southPanel = new JPanel();
		southPanel.add(previous, BorderLayout.WEST);
		southPanel.add(next, BorderLayout.EAST);
		
		panel.add(southPanel, BorderLayout.SOUTH);
		
		load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Runnable task = () -> {
					dir = new File(input.getText());
					
					if(!list.isEmpty()) {
						panel.remove(label);
						panel.revalidate();
					}
					
					loadImages();
					currentIndex = 0;
			
					label = new JLabel((ImageIcon) list.get(currentIndex));
					panel.add(label, BorderLayout.CENTER);
					panel.revalidate();
				};
				
				new Thread(task).start();
			}
		});

		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentIndex > 0 && currentIndex < list.size()) {
					--currentIndex; //trenutni za jedan manje
					panel.remove(label);
					label = new JLabel((ImageIcon) list.get(currentIndex));
					panel.add(label, BorderLayout.CENTER);
					panel.revalidate();
					previous.setSelected(false);
				} 
				if (currentIndex == 0) {
					previous.setEnabled(false);
				}
				if (currentIndex == list.size()-2) {
					next.setEnabled(true);
				}
			}
		});
	
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentIndex >= 0 && currentIndex < list.size() -1) {
					++currentIndex; //trenutni za jedan vise
					panel.remove(label);
					label = new JLabel((ImageIcon) list.get(currentIndex));
					panel.add(label, BorderLayout.CENTER);
					panel.revalidate();
					next.setSelected(false);
				} 
				if (currentIndex == 1) {
					previous.setEnabled(true);
				}
				if (currentIndex >= list.size()-1) {
					next.setEnabled(false);
				}
			}
		});
		
	}	

	public static void loadImages() {
		if (dir.isDirectory()) {
			for (File f : dir.listFiles(IMAGE_FILTER)) {
				try {
					list.add(new ImageIcon(ImageIO.read(f)));
				} catch (IOException e) {
					System.out.println("Cannot load images.");
					System.exit(0);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			PhotoGallery gallery = new PhotoGallery();
			gallery.setExtendedState(MAXIMIZED_BOTH);
			gallery.setVisible(true);
		});

	}

}
