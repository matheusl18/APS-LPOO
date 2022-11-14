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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.AcessoBancodeDados;
import javax.swing.table.TableModel;

public class Janela extends JFrame implements ViewJFrame{

	private JPanel contentPane;
	private JTextField nameAuthorsField;
	private JTextField fnameAuthorsField;
	DefaultTableModel modelAuthors = new DefaultTableModel(new Object[] {"ID", "Nome", "Sobrenome"}, 0);
	DefaultTableModel modelsrcAuthors = new DefaultTableModel(new Object[] {"ID", "Nome", "Sobrenome"}, 0);

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
		subPanelAuthors.setBounds(0, 130, 702, 234);
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
		sentButtonAuthors.setBounds(578, 155, 89, 23);
		sentButtonAuthors.setText("Enviar");
		sentButtonAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoAddActionPerformed(e);
			}
		});
		painelAddAutores.add(sentButtonAuthors);
		
		JPanel painelGetAuthors = new JPanel();
		subPanelAuthors.addTab("New tab", null, painelGetAuthors, null);
		painelGetAuthors.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 677, 184);
		painelGetAuthors.add(scrollPane);
		
		
		tableGetAuthors = new JTable(modelAuthors);
		tableGetAuthors.setModel(modelAuthors);
		scrollPane.setViewportView(tableGetAuthors);
		
		JPanel painelSrcAuthors = new JPanel();
		subPanelAuthors.addTab("New tab", null, painelSrcAuthors, null);
		painelSrcAuthors.setLayout(null);
		
		srcAuthorsNameField = new JTextField();
		srcAuthorsNameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeAddActionPerformed(e);
			}
		});
		srcAuthorsNameField.setColumns(10);
		srcAuthorsNameField.setBounds(124, 11, 407, 20);
		painelSrcAuthors.add(srcAuthorsNameField);
		
		srcButtonAuthors = new javax.swing.JButton();
		srcButtonAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoSrcActionPerformed(e);
			}
		});
		srcButtonAuthors.setText("Buscar");
		srcButtonAuthors.setForeground(new Color(240, 235, 227));
		srcButtonAuthors.setFont(new Font("David Libre", Font.PLAIN, 11));
		srcButtonAuthors.setBackground(new Color(73, 83, 113));
		srcButtonAuthors.setBounds(568, 10, 89, 23);
		painelSrcAuthors.add(srcButtonAuthors);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 66, 666, 129);
		painelSrcAuthors.add(scrollPane_1);
		
		tableSrcAuthors = new JTable(modelsrcAuthors);
		tableSrcAuthors.setModel(modelsrcAuthors);
		scrollPane_1.setViewportView(tableSrcAuthors);
		
		srcAuthorsFnameField = new JTextField();
		srcAuthorsFnameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeAddActionPerformed(e);
			}
		});
		srcAuthorsFnameField.setColumns(10);
		srcAuthorsFnameField.setBounds(124, 35, 407, 20);
		painelSrcAuthors.add(srcAuthorsFnameField);
		
		JLabel nameAuthorsLabel_1 = new JLabel("Nome :");
		nameAuthorsLabel_1.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 14));
		nameAuthorsLabel_1.setBounds(10, 7, 62, 28);
		painelSrcAuthors.add(nameAuthorsLabel_1);
		
		JLabel nameAuthorsLabel_1_1 = new JLabel("Sobrenome :");
		nameAuthorsLabel_1_1.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 14));
		nameAuthorsLabel_1_1.setBounds(10, 27, 82, 28);
		painelSrcAuthors.add(nameAuthorsLabel_1_1);
		
		JPanel painelDelAuthors = new JPanel();
		subPanelAuthors.addTab("New tab", null, painelDelAuthors, null);
		painelDelAuthors.setLayout(null);
		
		JLabel delAuthorsLabel = new JLabel("Selecione o id de um dos autores abaixo para ser deletado");
		delAuthorsLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		delAuthorsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		delAuthorsLabel.setBounds(10, 11, 666, 20);
		painelDelAuthors.add(delAuthorsLabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 43, 666, 80);
		painelDelAuthors.add(scrollPane_2);
		
		tableDelAuthors = new JTable(modelAuthors);
		tableDelAuthors.setModel(modelAuthors);
		scrollPane_2.setViewportView(tableDelAuthors);
		
		JLabel idAuthorsLabel = new JLabel("Id :");
		idAuthorsLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 15));
		idAuthorsLabel.setBounds(10, 139, 36, 25);
		painelDelAuthors.add(idAuthorsLabel);
		
		delAuthorsField = new JTextField();
		delAuthorsField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeAddActionPerformed(e);
			}
		});
		delAuthorsField.setColumns(10);
		delAuthorsField.setBounds(43, 141, 633, 20);
		painelDelAuthors.add(delAuthorsField);
		
		delButtonAuthors = new javax.swing.JButton();
		delButtonAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoDelActionPerformed(e);
			}
		});
		delButtonAuthors.setText("Deletar");
		delButtonAuthors.setForeground(new Color(240, 235, 227));
		delButtonAuthors.setFont(new Font("David Libre", Font.PLAIN, 11));
		delButtonAuthors.setBackground(new Color(73, 83, 113));
		delButtonAuthors.setBounds(587, 172, 89, 23);
		painelDelAuthors.add(delButtonAuthors);
		
		JPanel panel_4 = new JPanel();
		subPanelAuthors.addTab("New tab", null, panel_4, null);
		
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
		
		addAuthorsButton.setBounds(28, 83, 89, 23);
		PanelAutores.add(addAuthorsButton);
		
		getAuthorsButton = new javax.swing.JButton();
		getAuthorsButton.setText("Listar");
		getAuthorsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelAuthors.setVisible(true);
				subPanelAuthors.setSelectedIndex(1);
				botaoGetActionPerformed(e);
			}
		});
		getAuthorsButton.setForeground(new Color(240, 235, 227));
		getAuthorsButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		getAuthorsButton.setBackground(new Color(73, 83, 113));
		getAuthorsButton.setBounds(138, 83, 89, 23);
		PanelAutores.add(getAuthorsButton);
		
		srcAuthorsButton = new javax.swing.JButton();
		srcAuthorsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelAuthors.setVisible(true);
				subPanelAuthors.setSelectedIndex(2);
			}
		});
		srcAuthorsButton.setText("Buscar");
		srcAuthorsButton.setForeground(new Color(240, 235, 227));
		srcAuthorsButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		srcAuthorsButton.setBackground(new Color(73, 83, 113));
		srcAuthorsButton.setBounds(253, 83, 89, 23);
		PanelAutores.add(srcAuthorsButton);
		
		JButton delAuthorsButton = new JButton();
		delAuthorsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelAuthors.setVisible(true);
				subPanelAuthors.setSelectedIndex(3);
			}
		});
		delAuthorsButton.setText("Deletar");
		delAuthorsButton.setForeground(new Color(240, 235, 227));
		delAuthorsButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		delAuthorsButton.setBackground(new Color(73, 83, 113));
		delAuthorsButton.setBounds(368, 83, 89, 23);
		PanelAutores.add(delAuthorsButton);
		
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
		subPanelEditoras.setVisible(false);
		
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
		subPanelLivros.setVisible(false);
		
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
	private javax.swing.JButton getAuthorsButton;
	private javax.swing.JButton srcAuthorsButton;
	private javax.swing.JButton srcButtonAuthors;
	private javax.swing.JButton delButtonAuthors;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField namePublishersField;
	private JTextField urlPublishersField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable tableGetAuthors;
	
	
	
	private void nomeAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeAddActionPerformed
        // TODO add your handling code here:
    }
	private void botaoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAddActionPerformed
        // TODO add your handling code here:
    }
	private void botaoGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeAddActionPerformed
        // TODO add your handling code here:
    }
	private void botaoSrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeAddActionPerformed
        // TODO add your handling code here:
    }
	private void botaoDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeAddActionPerformed
        // TODO add your handling code here:
    }
	
	
	AcessoBancodeDados  ABD = new AcessoBancodeDados();
	private JTextField srcAuthorsNameField;
	private JTable tableSrcAuthors;
	private JTextField srcAuthorsFnameField;
	private JTable tableDelAuthors;
	private JTextField delAuthorsField;

	@Override
	public void listarPublishers(List<Publishers> publishers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarAuthors(List<Authors> authors) {
		modelAuthors.setRowCount(0);
		for(Authors a: authors) {
			modelAuthors.addRow(new Object[] {a.getAuthors_id(), a.getNome(), a.getFname()});
			System.out.println(a.getAuthors_id() +" " + a.getNome()+" " + a.getFname());
		}
		
	}

	@Override
	public void listarBooks(List<Books> books) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarBooksauthors(List<Booksauthors> booksauthors) {
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
		 return 0;
	}
	@Override
	public int delAuthors() {
		int id = Integer.parseInt(delAuthorsField.getText());
		 return id;
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
		delButtonAuthors.addActionListener(al);
		
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
	@Override
	public void addActionListarPublishers(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addActionListarAuthors(ActionListener al) {
		getAuthorsButton.addActionListener(al);
		
	}
	@Override
	public void addActionListarBooks(ActionListener al) {
	
		
	}
	@Override
	public void addActionListarBooksauthors(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addActionBuscaPublishers(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void srcPublishers(List<Publishers> publishers) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getKeyPublishersBusca() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addActionBuscaAuthors(ActionListener al) {
		srcButtonAuthors.addActionListener(al);
		
	}
	@Override
	public void srcAuthors(List<Authors> authors) {
		modelsrcAuthors.setRowCount(0);
		for(Authors a: authors) {
			modelsrcAuthors.addRow(new Object[] {a.getAuthors_id(), a.getNome(), a.getFname()});
			System.out.println(a.getAuthors_id() +" " + a.getNome()+" " + a.getFname());
		}
		
	}
	@Override
	public String getKeyNameAuthorsBusca() {
		return srcAuthorsNameField.getText();
		 
	}
	@Override
	public String getKeyFnameAuthorsBusca() {
		return srcAuthorsFnameField.getText();
		
	}
	@Override
	public void addActionBuscaBooks(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void srcBooks(List<Books> books) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getKeyBooksBusca() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addActionBuscaBooksauthors(ActionListener al) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void srcBooksauthors(List<Booksauthors> booksauthors) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getKeyBooksauthorsBusca() {
		// TODO Auto-generated method stub
		return null;
	}
}
