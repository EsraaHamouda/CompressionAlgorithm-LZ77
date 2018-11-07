import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class LZ77ComperssionTechnique {

	private JFrame frame;
	Main m = new Main();
	Vector<Tag> t = new Vector<Tag>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LZ77ComperssionTechnique window = new LZ77ComperssionTechnique();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LZ77ComperssionTechnique() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 483, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTextArea txtInput = new JTextArea();
		txtInput.setBounds(10, 92, 429, 75);
		frame.getContentPane().add(txtInput);
		
		JLabel lblNewLabel = new JLabel("LZ77 Compression Technique");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(80, 11, 239, 59);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Text:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 52, 79, 34);
		frame.getContentPane().add(lblNewLabel_1);
	final	JTextPane txtOutput = new JTextPane();
		txtOutput.setBounds(10, 212, 429, 147);
		frame.getContentPane().add(txtOutput);
		JButton btnCompress = new JButton("Compress Text");
		btnCompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inputString = txtInput.getText();
			
				
				String x = "";
				t = m.CompressionLZ77(inputString);
				for (int i = 0; i < t.size(); i++) {
					x +=t.get(i).toString();
					x+="\n";
				}
				txtOutput.setText(x);
				
			}
		});
		btnCompress.setBounds(10, 178, 429, 23);
		frame.getContentPane().add(btnCompress);
		
		final JTextArea txtDecompress = new JTextArea();
		txtDecompress.setBounds(10, 413, 429, 117);
		frame.getContentPane().add(txtDecompress);
		
		JButton btnDecompress = new JButton("Decompress Tags");
		btnDecompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(t.size()!=0)
				{
					String res = m.DecompressLZ77(t);
					txtDecompress.setText(res);
				}
			}
		});
		btnDecompress.setBounds(10, 378, 429, 23);
		frame.getContentPane().add(btnDecompress);
		
		
		
		//	jScrollPane.setToolTipText("1111111111111111111111111111111111111111111111111111111111111111111111111111");
		//jScrollPane.setVisible(true);
//		JTextArea txttemp = new JTextArea();
//		txttemp.setBounds(167, 63, 165, 38);
//		frame.getContentPane().add(txttemp);
//		//txttemp.setText("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111555555555");
		//JScrollPane jScrollPane = new JScrollPane(txttemp);
	//	jScrollPane.add(txttemp,null);
		
		
		
		
	}
}
