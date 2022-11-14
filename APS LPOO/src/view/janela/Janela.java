package view.janela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Authors;
import entidades.Books;
import entidades.Booksauthors;
import entidades.Publishers;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Color;

public class Janela extends JFrame implements ViewJFrame{

	private JPanel contentPane;
	private JTextField nameAuthorsField;
	private JTextField fnameAuthorsField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setBackground(new Color(240, 235, 227));
		tabbedPane.setBounds(0, 47, 775, 369);
		contentPane.add(tabbedPane);
		
		JPanel PanelAutores = new JPanel();
		PanelAutores.setBackground(new Color(240, 235, 227));
		tabbedPane.addTab("New tab", null, PanelAutores, null);
		PanelAutores.setLayout(null);
		
		JLabel labelAutores = new JLabel("Autores");
		labelAutores.setHorizontalAlignment(SwingConstants.CENTER);
		labelAutores.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 40));
		labelAutores.setBounds(213, 11, 204, 67);
		PanelAutores.add(labelAutores);
		
		
		JTabbedPane subPanelAuthors = new JTabbedPane(JTabbedPane.BOTTOM);
		subPanelAuthors.setBounds(0, 192, 702, 198);
		PanelAutores.add(subPanelAuthors);
		subPanelAuthors.setVisible(false);
		
		JPanel painelAddAutores = new JPanel();
		painelAddAutores.setBackground(new Color(240, 235, 227));
		subPanelAuthors.addTab("New tab", null, painelAddAutores, null);
		painelAddAutores.setLayout(null);
		
		JLabel nameAuthorsLabel = new JLabel("Nome :");
		nameAuthorsLabel.setBounds(10, 25, 87, 39);
		nameAuthorsLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		painelAddAutores.add(nameAuthorsLabel);
		
		JLabel lblSobrenome = new JLabel("Sobrenome :");
		lblSobrenome.setBounds(10, 86, 145, 39);
		lblSobrenome.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		painelAddAutores.add(lblSobrenome);
		
		nameAuthorsField = new JTextField();
		nameAuthorsField.setBounds(167, 38, 495, 20);
		nameAuthorsField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeAddActionPerformed(e);
			}
		});
		painelAddAutores.add(nameAuthorsField);
		nameAuthorsField.setColumns(10);
		
		fnameAuthorsField = new JTextField();
		fnameAuthorsField.setBounds(167, 99, 495, 20);
		fnameAuthorsField.setColumns(10);
		painelAddAutores.add(fnameAuthorsField);
		
		sentButtonAuthors = new javax.swing.JButton();
		sentButtonAuthors.setBackground(new Color(73, 83, 113));
		sentButtonAuthors.setForeground(new Color(240, 235, 227));
		sentButtonAuthors.setFont(new Font("David Libre", Font.PLAIN, 11));
		sentButtonAuthors.setBounds(578, 136, 89, 23);
		sentButtonAuthors.setText("Enviar");
		sentButtonAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoAddActionPerformed(e);
			}
		});
		painelAddAutores.add(sentButtonAuthors);
		
		JScrollPane scrollPane = new JScrollPane();
		subPanelAuthors.addTab("New tab", null, scrollPane, null);
		
		JLabel lblNewLabel = new JLabel("Selecione os autores que voc\u00EA dejesa excluir");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton addAuthorsButton = new JButton("Adicionar");
		addAuthorsButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		addAuthorsButton.setForeground(new Color(240, 235, 227));
		addAuthorsButton.setBackground(new Color(73, 83, 113));
		addAuthorsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelAuthors.setVisible(true);
				subPanelAuthors.setSelectedIndex(0);
			}
		});
		
		addAuthorsButton.setBounds(29, 124, 89, 23);
		PanelAutores.add(addAuthorsButton);
		
		JPanel PanelEditoras = new JPanel();
		PanelEditoras.setBackground(new Color(240, 235, 227));
		tabbedPane.addTab("New tab", null, PanelEditoras, null);
		PanelEditoras.setLayout(null);
		
		JLabel labelEditoras = new JLabel("Editoras");
		labelEditoras.setHorizontalAlignment(SwingConstants.CENTER);
		labelEditoras.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 40));
		labelEditoras.setBounds(230, 11, 204, 100);
		PanelEditoras.add(labelEditoras);
		
		JTabbedPane subPanelEditoras = new JTabbedPane(JTabbedPane.BOTTOM);
		subPanelEditoras.setBounds(0, 192, 702, 198);
		PanelEditoras.add(subPanelEditoras);
		
		JPanel painelAddEditoras = new JPanel();
		painelAddEditoras.setBackground(new Color(240, 235, 227));
		painelAddEditoras.setLayout(null);
		subPanelEditoras.addTab("New tab", null, painelAddEditoras, null);
		
		JLabel namePublishersLabel = new JLabel("Nome :");
		namePublishersLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		namePublishersLabel.setBounds(10, 25, 87, 39);
		painelAddEditoras.add(namePublishersLabel);
		
		JLabel URLPublishersLabel = new JLabel("URL :");
		URLPublishersLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		URLPublishersLabel.setBounds(10, 86, 145, 39);
		painelAddEditoras.add(URLPublishersLabel);
		
		namePublishersField = new JTextField();
		namePublishersField.setColumns(10);
		namePublishersField.setBounds(167, 38, 495, 20);
		painelAddEditoras.add(namePublishersField);
		
		urlPublishersField = new JTextField();
		urlPublishersField.setColumns(10);
		urlPublishersField.setBounds(167, 99, 495, 20);
		painelAddEditoras.add(urlPublishersField);
		
		sentButtonPublishers = new javax.swing.JButton();
		sentButtonPublishers.setBackground(new Color(73, 83, 113));
		sentButtonPublishers.setForeground(new Color(240, 235, 227));
		sentButtonPublishers.setFont(new Font("David Libre", Font.PLAIN, 11));
		sentButtonPublishers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoAddActionPerformed(e);
			}
		});
		sentButtonPublishers.setText("Enviar");
		sentButtonPublishers.setBounds(578, 136, 89, 23);
		painelAddEditoras.add(sentButtonPublishers);
		
		JPanel PanelLivros = new JPanel();
		PanelLivros.setBackground(new Color(240, 235, 227));
		tabbedPane.addTab("New tab", null, PanelLivros, null);
		PanelLivros.setLayout(null);
		
		JLabel labelLivros = new JLabel("Livros");
		labelLivros.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 40));
		labelLivros.setHorizontalAlignment(SwingConstants.CENTER);
		labelLivros.setBounds(217, 11, 204, 57);
		PanelLivros.add(labelLivros);
		
		JButton buttonAutores_1 = new JButton("Autores");
		buttonAutores_1.setBackground(new Color(73, 83, 113));
		buttonAutores_1.setForeground(new Color(240, 235, 227));
		buttonAutores_1.setFont(new Font("David Libre", Font.PLAIN, 11));
		buttonAutores_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		buttonAutores_1.setBounds(52, 61, 89, 23);
		PanelLivros.add(buttonAutores_1);
		
		JTabbedPane subPanelLivros = new JTabbedPane(JTabbedPane.BOTTOM);
		subPanelLivros.setBounds(0, 106, 702, 284);
		PanelLivros.add(subPanelLivros);
		
		JPanel painelAddLivros = new JPanel();
		painelAddLivros.setBackground(new Color(240, 235, 227));
		painelAddLivros.setLayout(null);
		subPanelLivros.addTab("New tab", null, painelAddLivros, null);
		
		JLabel titleBooksLabel = new JLabel("Titulo :");
		titleBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		titleBooksLabel.setBounds(10, 25, 87, 39);
		painelAddLivros.add(titleBooksLabel);
		
		JLabel isbnBooksLabel = new JLabel("ISBN :");
		isbnBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		isbnBooksLabel.setBounds(10, 56, 145, 39);
		painelAddLivros.add(isbnBooksLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(137, 38, 495, 20);
		painelAddLivros.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 69, 495, 20);
		painelAddLivros.add(textField_1);
		
		JButton sentButtonBooks = new JButton();
		sentButtonBooks.setBackground(new Color(73, 83, 113));
		sentButtonBooks.setForeground(new Color(240, 235, 227));
		sentButtonBooks.setFont(new Font("David Libre", Font.PLAIN, 11));
		sentButtonBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sentButtonBooks.setText("Enviar");
		sentButtonBooks.setBounds(576, 196, 89, 23);
		painelAddLivros.add(sentButtonBooks);
		
		JLabel priceBooksLabel = new JLabel("Pre\u00E7o :");
		priceBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		priceBooksLabel.setBounds(10, 87, 145, 39);
		painelAddLivros.add(priceBooksLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 100, 495, 20);
		painelAddLivros.add(textField_2);
		
		JLabel publisherBooksLabel = new JLabel("Editora :");
		publisherBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		publisherBooksLabel.setBounds(10, 120, 145, 39);
		painelAddLivros.add(publisherBooksLabel);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(137, 131, 495, 20);
		painelAddLivros.add(textField_3);
		
		JLabel authorsBooksLabel = new JLabel("Autores :");
		authorsBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		authorsBooksLabel.setBounds(10, 152, 145, 39);
		painelAddLivros.add(authorsBooksLabel);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(137, 165, 495, 20);
		painelAddLivros.add(textField_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 235, 227));
		panel.setBounds(0, 0, 692, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton buttonAutores = new JButton("Autores");
		buttonAutores.setFont(new Font("David Libre", Font.PLAIN, 11));
		buttonAutores.setForeground(new Color(240, 235, 227));
		buttonAutores.setBackground(new Color(73, 83, 113));
		buttonAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		buttonAutores.setBounds(56, 24, 89, 23);
		panel.add(buttonAutores);
		
		JButton buttonEditoras = new JButton("Editoras");
		buttonEditoras.setFont(new Font("David Libre", Font.PLAIN, 11));
		buttonEditoras.setForeground(new Color(240, 235, 227));
		buttonEditoras.setBackground(new Color(73, 83, 113));
		buttonEditoras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		buttonEditoras.setBounds(276, 24, 89, 23);
		panel.add(buttonEditoras);
		
		JButton buttonLivros = new JButton("Livros");
		buttonLivros.setFont(new Font("David Libre", Font.PLAIN, 11));
		buttonLivros.setForeground(new Color(240, 235, 227));
		buttonLivros.setBackground(new Color(73, 83, 113));
		buttonLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		buttonLivros.setBounds(539, 24, 89, 23);
		panel.add(buttonLivros);
		
	}
	
	private javax.swing.JButton sentButtonAuthors;
	private javax.swing.JButton sentButtonPublishers;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField namePublishersField;
	private JTextField urlPublishersField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	
	private void nomeAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeAddActionPerformed
        // TODO add your handling code here:
    }
	private void botaoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAddActionPerformed
        // TODO add your handling code here:
    }
	
	
	

	@Override
	public void listarPublishers(Publishers publishers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarAuthors(Authors authors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarBooks(Books books) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarBooksauthors(Booksauthors booksauthors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Publishers addPublishers() {
		String name = namePublishersField.getText();
        String url = urlPublishersField.getText();
		return new Publishers(0, name, url);
	}
	@Override
    public Authors addAuthors() {
        String name = nameAuthorsField.getText();
        String fname = fnameAuthorsField.getText();
        return new Authors(0, name, fname);
    }
	@Override
	public Books addBooks() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Booksauthors addBooksauthors() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void addActionAdicionarPublishers(ActionListener al) {
		sentButtonPublishers.addActionListener(al);
		
	}
	@Override
    public void addActionAdicionarAuthors(ActionListener al) {
		sentButtonAuthors.addActionListener(al);
    }
	@Override
	public void addActionAdicionarBooks(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addActionAdicionarBooksauthors(ActionListener al) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delPublishers() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delAuthors() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String delBooks() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delBooksauthors() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void addActionDeletarPublishers(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addActionDeletarAuthors(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addActionDeletarBooks(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addActionDeletarBooksauthors(ActionListener al) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String updateString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double updateDouble() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Publishers updatePublishers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Authors updateAuthors() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Books updateBooks() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Booksauthors updateBooksauthors() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void addActionUpdatePublishers(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addActionUpdateAuthors(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addActionUpdateBooks(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addActionUpdateBooksauthors(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
}
