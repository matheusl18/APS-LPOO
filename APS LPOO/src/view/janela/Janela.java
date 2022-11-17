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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.AcessoBancodeDados;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;

public class Janela extends JFrame implements ViewJFrame{

	private JPanel contentPane;
	private JTextField nameAuthorsField;
	private JTextField fnameAuthorsField;
	DefaultTableModel modelAuthors = new DefaultTableModel(new Object[] {"ID", "Nome", "Sobrenome"}, 0);
	DefaultTableModel modelsrcAuthors = new DefaultTableModel(new Object[] {"ID", "Nome", "Sobrenome"}, 0);
	DefaultTableModel modelPublishers = new DefaultTableModel(new Object[] {"ID", "Nome", "URL"}, 0);
	DefaultTableModel modelsrcPublishers = new DefaultTableModel(new Object[] {"ID", "Nome", "URL"}, 0);
	DefaultTableModel modelBooks = new DefaultTableModel(new Object[] {"Titulo", "Isbn", "Publisher_id", "Preço"}, 0);
	DefaultTableModel modelsrcBooks = new DefaultTableModel(new Object[] {"Titulo", "Isbn", "Publisher_id", "Preço"}, 0);
	DefaultComboBoxModel<Authors> boxAuthors = new DefaultComboBoxModel<Authors>();
	DefaultComboBoxModel<Publishers> boxPublishers = new DefaultComboBoxModel<Publishers>();
	DefaultComboBoxModel<Books> boxBooks = new DefaultComboBoxModel<Books>();
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
		subPanelAuthors.setBounds(0, 130, 702, 272);
		PanelAutores.add(subPanelAuthors);
		subPanelAuthors.setVisible(false);
		
		JPanel painelAddAutores = new JPanel();
		painelAddAutores.setBackground(new Color(240, 235, 227));
		subPanelAuthors.addTab("New tab", null, painelAddAutores, null);
		painelAddAutores.setLayout(null);
		
		JLabel nameAddAuthorsLabel = new JLabel("Nome :");
		nameAddAuthorsLabel.setBounds(10, 25, 87, 39);
		nameAddAuthorsLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		painelAddAutores.add(nameAddAuthorsLabel);
		
		JLabel fnameAddAuthorsLabel = new JLabel("Sobrenome :");
		fnameAddAuthorsLabel.setBounds(10, 86, 145, 39);
		fnameAddAuthorsLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		painelAddAutores.add(fnameAddAuthorsLabel);
		
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
		
		addButtonAuthors = new javax.swing.JButton();
		addButtonAuthors.setBackground(new Color(73, 83, 113));
		addButtonAuthors.setForeground(new Color(240, 235, 227));
		addButtonAuthors.setFont(new Font("David Libre", Font.PLAIN, 11));
		addButtonAuthors.setBounds(578, 155, 89, 23);
		addButtonAuthors.setText("Enviar");
		addButtonAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoAddActionPerformed(e);
			}
		});
		painelAddAutores.add(addButtonAuthors);
		
		JPanel painelGetAuthors = new JPanel();
		subPanelAuthors.addTab("New tab", null, painelGetAuthors, null);
		painelGetAuthors.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 677, 206);
		painelGetAuthors.add(scrollPane);
		
		
		tableGetAuthors = new JTable(modelAuthors);
		tableGetAuthors.setModel(modelAuthors);
		scrollPane.setViewportView(tableGetAuthors);
		
		JPanel painelSrcAuthors = new JPanel();
		subPanelAuthors.addTab("New tab", null, painelSrcAuthors, null);
		painelSrcAuthors.setLayout(null);
		
		nameSrcAuthorsField = new JTextField();
		nameSrcAuthorsField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeAddActionPerformed(e);
			}
		});
		nameSrcAuthorsField.setColumns(10);
		nameSrcAuthorsField.setBounds(124, 11, 407, 20);
		painelSrcAuthors.add(nameSrcAuthorsField);
		
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
		
		fnameSrcAuthorsField = new JTextField();
		fnameSrcAuthorsField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeAddActionPerformed(e);
			}
		});
		fnameSrcAuthorsField.setColumns(10);
		fnameSrcAuthorsField.setBounds(124, 35, 407, 20);
		painelSrcAuthors.add(fnameSrcAuthorsField);
		
		JLabel nameSrcAuthorsLabel = new JLabel("Nome :");
		nameSrcAuthorsLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 14));
		nameSrcAuthorsLabel.setBounds(10, 7, 62, 28);
		painelSrcAuthors.add(nameSrcAuthorsLabel);
		
		JLabel fnameSrcAuthorsLabel = new JLabel("Sobrenome :");
		fnameSrcAuthorsLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 14));
		fnameSrcAuthorsLabel.setBounds(10, 27, 82, 28);
		painelSrcAuthors.add(fnameSrcAuthorsLabel);
		
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
		
		JPanel painelUpdadeAuthors = new JPanel();
		subPanelAuthors.addTab("New tab", null, painelUpdadeAuthors, null);
		painelUpdadeAuthors.setLayout(null);
		
		comboBoxAuthors = new JComboBox();
		comboBoxAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Authors a = (Authors) comboBoxAuthors.getSelectedItem();
				updateNameAuthorsField.setText(String.valueOf(a.getNome()));
				updateFnameAuthorsField.setText(String.valueOf(a.getFname()));
				updateAuthorsField.setText(String.valueOf(a.getAuthors_id()));
			}
		});
		comboBoxAuthors.setModel(boxAuthors);
		comboBoxAuthors.setRenderer(new AuthorsRenderer());
		comboBoxAuthors.setBounds(110, 40, 443, 22);
		painelUpdadeAuthors.add(comboBoxAuthors);
		
		JLabel nameUpdateAuthorsLabel = new JLabel("Novo Nome :");
		nameUpdateAuthorsLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 15));
		nameUpdateAuthorsLabel.setBounds(10, 101, 110, 33);
		painelUpdadeAuthors.add(nameUpdateAuthorsLabel);
		
		updateNameAuthorsField = new JTextField();
		updateNameAuthorsField.setColumns(10);
		updateNameAuthorsField.setBounds(167, 107, 495, 20);
		painelUpdadeAuthors.add(updateNameAuthorsField);
		
		JLabel SobrenomeUpdateAuthors = new JLabel("Novo Sobrenome :");
		SobrenomeUpdateAuthors.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 15));
		SobrenomeUpdateAuthors.setBounds(10, 134, 125, 22);
		painelUpdadeAuthors.add(SobrenomeUpdateAuthors);
		
		updateFnameAuthorsField = new JTextField();
		updateFnameAuthorsField.setColumns(10);
		updateFnameAuthorsField.setBounds(167, 135, 495, 20);
		painelUpdadeAuthors.add(updateFnameAuthorsField);
		
		JLabel idUpdateAuthorsLabel = new JLabel("ID :");
		idUpdateAuthorsLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 15));
		idUpdateAuthorsLabel.setBounds(10, 74, 110, 33);
		painelUpdadeAuthors.add(idUpdateAuthorsLabel);
		
		updateAuthorsField = new JTextField();
		updateAuthorsField.setColumns(10);
		updateAuthorsField.setBounds(167, 80, 495, 20);
		painelUpdadeAuthors.add(updateAuthorsField);
		
		updateButtonAuthors = new javax.swing.JButton();
		updateButtonAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoUpdateActionPerformed(e);
			}
		});
		updateButtonAuthors.setText("Atualizar");
		updateButtonAuthors.setForeground(new Color(240, 235, 227));
		updateButtonAuthors.setFont(new Font("David Libre", Font.PLAIN, 11));
		updateButtonAuthors.setBackground(new Color(73, 83, 113));
		updateButtonAuthors.setBounds(573, 172, 89, 23);
		painelUpdadeAuthors.add(updateButtonAuthors);
		
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
		
		JButton srcAuthorsButton = new JButton();
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
		
		delAuthorsButton = new javax.swing.JButton();
		delAuthorsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelAuthors.setVisible(true);
				subPanelAuthors.setSelectedIndex(3);
				botaoGetActionPerformed(e);
			}
		});
		delAuthorsButton.setText("Deletar");
		delAuthorsButton.setForeground(new Color(240, 235, 227));
		delAuthorsButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		delAuthorsButton.setBackground(new Color(73, 83, 113));
		delAuthorsButton.setBounds(368, 83, 89, 23);
		PanelAutores.add(delAuthorsButton);
		
		updateAuthorsButton = new JButton();
		updateAuthorsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelAuthors.setVisible(true);
				subPanelAuthors.setSelectedIndex(4);
				botaoGetActionPerformed(e);
				
			}
		});
		updateAuthorsButton.setText("Atualizar");
		updateAuthorsButton.setForeground(new Color(240, 235, 227));
		updateAuthorsButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		updateAuthorsButton.setBackground(new Color(73, 83, 113));
		updateAuthorsButton.setBounds(484, 82, 89, 23);
		PanelAutores.add(updateAuthorsButton);
		
		JPanel PanelEditoras = new JPanel();
		PanelEditoras.setBackground(new Color(240, 235, 227));
		tabbedPane.addTab("New tab", null, PanelEditoras, null);
		PanelEditoras.setLayout(null);
		
		JLabel labelEditoras = new JLabel("Editoras");
		labelEditoras.setHorizontalAlignment(SwingConstants.CENTER);
		labelEditoras.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 40));
		labelEditoras.setBounds(230, 11, 204, 69);
		PanelEditoras.add(labelEditoras);
		
		JTabbedPane subPanelEditoras = new JTabbedPane(JTabbedPane.BOTTOM);
		subPanelEditoras.setBounds(0, 130, 702, 272);
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
		
		addButtonPublishers = new javax.swing.JButton();
		addButtonPublishers.setBackground(new Color(73, 83, 113));
		addButtonPublishers.setForeground(new Color(240, 235, 227));
		addButtonPublishers.setFont(new Font("David Libre", Font.PLAIN, 11));
		addButtonPublishers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoAddActionPerformed(e);
			}
		});
		addButtonPublishers.setText("Enviar");
		addButtonPublishers.setBounds(578, 136, 89, 23);
		painelAddEditoras.add(addButtonPublishers);
		
		JPanel painelGetEditoras = new JPanel();
		painelGetEditoras.setLayout(null);
		subPanelEditoras.addTab("New tab", null, painelGetEditoras, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 677, 209);
		painelGetEditoras.add(scrollPane_3);
		
		tableGetPublishers = new JTable(modelPublishers);
		tableGetPublishers.setModel(modelPublishers);
		scrollPane_3.setViewportView(tableGetPublishers);
		
		JPanel painelSrcEditoras = new JPanel();
		painelSrcEditoras.setLayout(null);
		subPanelEditoras.addTab("New tab", null, painelSrcEditoras, null);
		
		nameSrcPublishersField = new JTextField();
		nameSrcPublishersField.setColumns(10);
		nameSrcPublishersField.setBounds(124, 11, 407, 20);
		painelSrcEditoras.add(nameSrcPublishersField);
		
		srcButtonPublishers = new javax.swing.JButton();
		srcButtonPublishers.setText("Buscar");
		srcButtonPublishers.setForeground(new Color(240, 235, 227));
		srcButtonPublishers.setFont(new Font("David Libre", Font.PLAIN, 11));
		srcButtonPublishers.setBackground(new Color(73, 83, 113));
		srcButtonPublishers.setBounds(568, 10, 89, 23);
		painelSrcEditoras.add(srcButtonPublishers);
		
		JLabel nameSrcPublishersLabel = new JLabel("Nome :");
		nameSrcPublishersLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 14));
		nameSrcPublishersLabel.setBounds(10, 7, 62, 28);
		painelSrcEditoras.add(nameSrcPublishersLabel);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(20, 46, 637, 174);
		painelSrcEditoras.add(scrollPane_5);
		
		tableSrcPublishers = new JTable(modelsrcPublishers);
		tableSrcPublishers.setModel(modelsrcPublishers);
		scrollPane_5.setViewportView(tableSrcPublishers);
		
		JPanel painelDelEditoras = new JPanel();
		painelDelEditoras.setLayout(null);
		subPanelEditoras.addTab("New tab", null, painelDelEditoras, null);
		
		JLabel delPublishersLabel = new JLabel("Selecione o id de um dos autores abaixo para ser deletado");
		delPublishersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		delPublishersLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		delPublishersLabel.setBounds(10, 11, 666, 20);
		painelDelEditoras.add(delPublishersLabel);
		
		JLabel idPublishersLabel = new JLabel("Id :");
		idPublishersLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 15));
		idPublishersLabel.setBounds(10, 139, 36, 25);
		painelDelEditoras.add(idPublishersLabel);
		
		delPublishersField = new JTextField();
		delPublishersField.setColumns(10);
		delPublishersField.setBounds(43, 141, 633, 20);
		painelDelEditoras.add(delPublishersField);
		
		delButtonPublishers = new javax.swing.JButton();
		delButtonPublishers.setText("Deletar");
		delButtonPublishers.setForeground(new Color(240, 235, 227));
		delButtonPublishers.setFont(new Font("David Libre", Font.PLAIN, 11));
		delButtonPublishers.setBackground(new Color(73, 83, 113));
		delButtonPublishers.setBounds(587, 172, 89, 23);
		painelDelEditoras.add(delButtonPublishers);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 42, 666, 88);
		painelDelEditoras.add(scrollPane_6);
		
		tableDelPublishers = new JTable(modelPublishers);
		tableDelPublishers.setModel(modelPublishers);
		scrollPane_6.setViewportView(tableDelPublishers);
		
		JPanel painelUpdadeEditoras = new JPanel();
		painelUpdadeEditoras.setLayout(null);
		subPanelEditoras.addTab("New tab", null, painelUpdadeEditoras, null);
		
		comboBoxPublishers = new JComboBox();
		comboBoxPublishers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Publishers p = (Publishers) comboBoxPublishers.getSelectedItem();
				updateNamePublishersField.setText(String.valueOf(p.getNome()));
				updateUrlPublishersField.setText(String.valueOf(p.getURL()));
				updateIdPublishersField.setText(String.valueOf(p.getPublishers_id()));
			}
		});
		comboBoxPublishers.setModel(boxPublishers);
		comboBoxPublishers.setRenderer(new PublishersRenderer());
		comboBoxPublishers.setBounds(110, 40, 443, 22);
		painelUpdadeEditoras.add(comboBoxPublishers);
		
		JLabel nameUpdatePublishersLabel = new JLabel("Novo Nome :");
		nameUpdatePublishersLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 15));
		nameUpdatePublishersLabel.setBounds(10, 101, 110, 33);
		painelUpdadeEditoras.add(nameUpdatePublishersLabel);
		
		updateNamePublishersField = new JTextField();
		updateNamePublishersField.setColumns(10);
		updateNamePublishersField.setBounds(167, 107, 495, 20);
		painelUpdadeEditoras.add(updateNamePublishersField);
		
		JLabel urlUpdatePublishers = new JLabel("Novo URL :");
		urlUpdatePublishers.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 15));
		urlUpdatePublishers.setBounds(10, 134, 125, 22);
		painelUpdadeEditoras.add(urlUpdatePublishers);
		
		updateUrlPublishersField = new JTextField();
		updateUrlPublishersField.setColumns(10);
		updateUrlPublishersField.setBounds(167, 135, 495, 20);
		painelUpdadeEditoras.add(updateUrlPublishersField);
		
		JLabel idUpdatePublishersLabel = new JLabel("ID :");
		idUpdatePublishersLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 15));
		idUpdatePublishersLabel.setBounds(10, 74, 110, 33);
		painelUpdadeEditoras.add(idUpdatePublishersLabel);
		
		updateIdPublishersField = new JTextField();
		updateIdPublishersField.setColumns(10);
		updateIdPublishersField.setBounds(167, 80, 495, 20);
		painelUpdadeEditoras.add(updateIdPublishersField);
		
		updateButtonPublishers = new javax.swing.JButton();
		updateButtonPublishers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoUpdateActionPerformed(e);
			}
		});
		updateButtonPublishers.setText("Atualizar");
		updateButtonPublishers.setForeground(new Color(240, 235, 227));
		updateButtonPublishers.setFont(new Font("David Libre", Font.PLAIN, 11));
		updateButtonPublishers.setBackground(new Color(73, 83, 113));
		updateButtonPublishers.setBounds(573, 172, 89, 23);
		painelUpdadeEditoras.add(updateButtonPublishers);
		
		JButton addPublishersButton = new JButton("Adicionar");
		addPublishersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelEditoras.setVisible(true);
				subPanelEditoras.setSelectedIndex(0);
			}
		});
		addPublishersButton.setForeground(new Color(240, 235, 227));
		addPublishersButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		addPublishersButton.setBackground(new Color(73, 83, 113));
		addPublishersButton.setBounds(60, 78, 89, 23);
		PanelEditoras.add(addPublishersButton);
		
		getPublishersButton = new javax.swing.JButton();
		getPublishersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelEditoras.setVisible(true);
				subPanelEditoras.setSelectedIndex(1);
				botaoGetActionPerformed(e);
			}
		});
		getPublishersButton.setText("Listar");
		getPublishersButton.setForeground(new Color(240, 235, 227));
		getPublishersButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		getPublishersButton.setBackground(new Color(73, 83, 113));
		getPublishersButton.setBounds(170, 78, 89, 23);
		PanelEditoras.add(getPublishersButton);
		
		JButton srcPublishersButton = new JButton();
		srcPublishersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelEditoras.setVisible(true);
				subPanelEditoras.setSelectedIndex(2);
			}
		});
		srcPublishersButton.setText("Buscar");
		srcPublishersButton.setForeground(new Color(240, 235, 227));
		srcPublishersButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		srcPublishersButton.setBackground(new Color(73, 83, 113));
		srcPublishersButton.setBounds(285, 78, 89, 23);
		PanelEditoras.add(srcPublishersButton);
		
		delPublishersButton = new javax.swing.JButton();
		delPublishersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelEditoras.setVisible(true);
				subPanelEditoras.setSelectedIndex(3);
			}
		});
		delPublishersButton.setText("Deletar");
		delPublishersButton.setForeground(new Color(240, 235, 227));
		delPublishersButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		delPublishersButton.setBackground(new Color(73, 83, 113));
		delPublishersButton.setBounds(400, 78, 89, 23);
		PanelEditoras.add(delPublishersButton);
		
		updatePublishersButton = new javax.swing.JButton();
		updatePublishersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelEditoras.setVisible(true);
				subPanelEditoras.setSelectedIndex(4);
			}
		});
		updatePublishersButton.setText("Atualizar");
		updatePublishersButton.setForeground(new Color(240, 235, 227));
		updatePublishersButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		updatePublishersButton.setBackground(new Color(73, 83, 113));
		updatePublishersButton.setBounds(516, 77, 89, 23);
		PanelEditoras.add(updatePublishersButton);
		
		JPanel PanelLivros = new JPanel();
		PanelLivros.setBackground(new Color(240, 235, 227));
		tabbedPane.addTab("New tab", null, PanelLivros, null);
		PanelLivros.setLayout(null);
		
		JLabel labelLivros = new JLabel("Livros");
		labelLivros.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 40));
		labelLivros.setHorizontalAlignment(SwingConstants.CENTER);
		labelLivros.setBounds(217, 11, 204, 57);
		PanelLivros.add(labelLivros);
		
		JTabbedPane subPanelLivros = new JTabbedPane(JTabbedPane.BOTTOM);
		subPanelLivros.setBounds(0, 130, 702, 272);
		PanelLivros.add(subPanelLivros);
		subPanelLivros.setVisible(false);
		
		JPanel painelAddLivros = new JPanel();
		painelAddLivros.setBackground(new Color(240, 235, 227));
		painelAddLivros.setLayout(null);
		subPanelLivros.addTab("New tab", null, painelAddLivros, null);
		
		JLabel titleBooksLabel = new JLabel("Titulo :");
		titleBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		titleBooksLabel.setBounds(10, 5, 81, 28);
		painelAddLivros.add(titleBooksLabel);
		
		JLabel isbnBooksLabel = new JLabel("ISBN :");
		isbnBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		isbnBooksLabel.setBounds(10, 35, 64, 20);
		painelAddLivros.add(isbnBooksLabel);
		
		titleBooksField = new JTextField();
		titleBooksField.setColumns(10);
		titleBooksField.setBounds(137, 10, 495, 20);
		painelAddLivros.add(titleBooksField);
		
		isbnBooksField = new JTextField();
		isbnBooksField.setColumns(10);
		isbnBooksField.setBounds(137, 36, 495, 20);
		painelAddLivros.add(isbnBooksField);
		
		addButtonBooks = new javax.swing.JButton();
		addButtonBooks.setBackground(new Color(73, 83, 113));
		addButtonBooks.setForeground(new Color(240, 235, 227));
		addButtonBooks.setFont(new Font("David Libre", Font.PLAIN, 11));
		addButtonBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addButtonBooks.setText("Enviar");
		addButtonBooks.setBounds(598, 204, 89, 23);
		painelAddLivros.add(addButtonBooks);
		
		JLabel priceBooksLabel = new JLabel("Pre\u00E7o :");
		priceBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		priceBooksLabel.setBounds(10, 61, 73, 28);
		painelAddLivros.add(priceBooksLabel);
		
		priceBooksField = new JTextField();
		priceBooksField.setColumns(10);
		priceBooksField.setBounds(137, 66, 495, 20);
		painelAddLivros.add(priceBooksField);
		
		JLabel publisherBooksLabel = new JLabel("Editora :");
		publisherBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		publisherBooksLabel.setBounds(10, 90, 96, 31);
		painelAddLivros.add(publisherBooksLabel);
		
		JLabel authorsBooksLabel = new JLabel("Autores :");
		authorsBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		authorsBooksLabel.setBounds(10, 144, 96, 28);
		painelAddLivros.add(authorsBooksLabel);
		
		JLabel seqBooksLabel = new JLabel("Seq :");
		seqBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		seqBooksLabel.setBounds(10, 117, 96, 33);
		painelAddLivros.add(seqBooksLabel);
		
		seqBooksField = new JTextField();
		seqBooksField.setColumns(10);
		seqBooksField.setBounds(137, 124, 495, 20);
		painelAddLivros.add(seqBooksField);
		
		comboBoxEdiBooks = new JComboBox();
		comboBoxEdiBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Authors a = (Authors) comboBoxAuthors.getSelectedItem();
			}
		});
		comboBoxEdiBooks.setModel(boxPublishers);
		comboBoxEdiBooks.setRenderer(new PublishersRenderer());
		comboBoxEdiBooks.setBounds(137, 95, 486, 22);
		painelAddLivros.add(comboBoxEdiBooks);
		
		addButtonBooksAuthors = new JButton();
		addButtonBooksAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoAddActionPerformed(e);
			}
		});
		addButtonBooksAuthors.setText("Adicionar Autor");
		addButtonBooksAuthors.setForeground(new Color(240, 235, 227));
		addButtonBooksAuthors.setFont(new Font("David Libre", Font.PLAIN, 11));
		addButtonBooksAuthors.setBackground(new Color(73, 83, 113));
		addButtonBooksAuthors.setBounds(137, 149, 120, 23);
		painelAddLivros.add(addButtonBooksAuthors);
		
		JPanel painelGetLivros = new JPanel();
		painelGetLivros.setLayout(null);
		subPanelLivros.addTab("New tab", null, painelGetLivros, null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 11, 677, 207);
		painelGetLivros.add(scrollPane_4);
		
		tableGetBooks = new JTable(modelBooks);
		tableGetBooks.setModel(modelBooks);
		scrollPane_4.setViewportView(tableGetBooks);
		
		JPanel painelSrcLivros = new JPanel();
		painelSrcLivros.setLayout(null);
		subPanelLivros.addTab("New tab", null, painelSrcLivros, null);
		
		titleSrcBooksField = new JTextField();
		titleSrcBooksField.setColumns(10);
		titleSrcBooksField.setBounds(124, 11, 407, 20);
		painelSrcLivros.add(titleSrcBooksField);
		
		srcButtonBooks = new javax.swing.JButton();
		srcButtonBooks.setText("Buscar");
		srcButtonBooks.setForeground(new Color(240, 235, 227));
		srcButtonBooks.setFont(new Font("David Libre", Font.PLAIN, 11));
		srcButtonBooks.setBackground(new Color(73, 83, 113));
		srcButtonBooks.setBounds(568, 10, 89, 23);
		painelSrcLivros.add(srcButtonBooks);
		
		JLabel nameSrcBooksLabel = new JLabel("Titulo :");
		nameSrcBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 14));
		nameSrcBooksLabel.setBounds(10, 7, 62, 28);
		painelSrcLivros.add(nameSrcBooksLabel);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(10, 43, 647, 179);
		painelSrcLivros.add(scrollPane_8);
		
		tableSrcBooks = new JTable(modelsrcBooks);
		tableSrcBooks.setModel(modelsrcBooks);
		scrollPane_8.setViewportView(tableSrcBooks);
		
		JPanel painelDelLivros = new JPanel();
		painelDelLivros.setLayout(null);
		subPanelLivros.addTab("New tab", null, painelDelLivros, null);
		
		JLabel delBooksLabel = new JLabel("Selecione o isbn de um dos livros abaixo para ser deletado");
		delBooksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		delBooksLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		delBooksLabel.setBounds(10, 11, 666, 20);
		painelDelLivros.add(delBooksLabel);
		
		JLabel isbnDelBookssLabel = new JLabel("Isbn :");
		isbnDelBookssLabel.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 15));
		isbnDelBookssLabel.setBounds(10, 139, 45, 22);
		painelDelLivros.add(isbnDelBookssLabel);
		
		delBooksField = new JTextField();
		delBooksField.setColumns(10);
		delBooksField.setBounds(65, 141, 611, 20);
		painelDelLivros.add(delBooksField);
		
		delButtonBooks = new javax.swing.JButton();
		delButtonBooks.setText("Deletar");
		delButtonBooks.setForeground(new Color(240, 235, 227));
		delButtonBooks.setFont(new Font("David Libre", Font.PLAIN, 11));
		delButtonBooks.setBackground(new Color(73, 83, 113));
		delButtonBooks.setBounds(587, 172, 89, 23);
		painelDelLivros.add(delButtonBooks);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(10, 40, 666, 95);
		painelDelLivros.add(scrollPane_7);
		
		tableDelBooks = new JTable(modelBooks);
		tableDelBooks.setModel(modelBooks);
		scrollPane_7.setViewportView(tableDelBooks);
		
		JPanel painelUpdadeLivros = new JPanel();
		painelUpdadeLivros.setLayout(null);
		subPanelLivros.addTab("New tab", null, painelUpdadeLivros, null);
		
		updateButtonBooks = new javax.swing.JButton();
		updateButtonBooks.setText("Atualizar");
		updateButtonBooks.setForeground(new Color(240, 235, 227));
		updateButtonBooks.setFont(new Font("David Libre", Font.PLAIN, 11));
		updateButtonBooks.setBackground(new Color(73, 83, 113));
		updateButtonBooks.setBounds(573, 188, 89, 23);
		painelUpdadeLivros.add(updateButtonBooks);
		
		JLabel titleBooksLabel_1 = new JLabel("Titulo :");
		titleBooksLabel_1.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		titleBooksLabel_1.setBounds(20, 61, 81, 28);
		painelUpdadeLivros.add(titleBooksLabel_1);
		
		updateTitleBooksField = new JTextField();
		updateTitleBooksField.setColumns(10);
		updateTitleBooksField.setBounds(147, 66, 495, 20);
		painelUpdadeLivros.add(updateTitleBooksField);
		
		JLabel isbnBooksLabel_1 = new JLabel("ISBN :");
		isbnBooksLabel_1.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		isbnBooksLabel_1.setBounds(20, 91, 64, 20);
		painelUpdadeLivros.add(isbnBooksLabel_1);
		
		updateIsbnBooksField = new JTextField();
		updateIsbnBooksField.setColumns(10);
		updateIsbnBooksField.setBounds(147, 92, 495, 20);
		painelUpdadeLivros.add(updateIsbnBooksField);
		
		JLabel priceBooksLabel_1 = new JLabel("Pre\u00E7o :");
		priceBooksLabel_1.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		priceBooksLabel_1.setBounds(20, 117, 73, 28);
		painelUpdadeLivros.add(priceBooksLabel_1);
		
		updatePriceBooksField = new JTextField();
		updatePriceBooksField.setColumns(10);
		updatePriceBooksField.setBounds(147, 122, 495, 20);
		painelUpdadeLivros.add(updatePriceBooksField);
		
		JLabel publisherBooksLabel_1 = new JLabel("Editora :");
		publisherBooksLabel_1.setFont(new Font("David Libre", Font.BOLD | Font.ITALIC, 20));
		publisherBooksLabel_1.setBounds(20, 146, 96, 31);
		painelUpdadeLivros.add(publisherBooksLabel_1);
		
		updatePublishers_idBooksField = new JTextField();
		updatePublishers_idBooksField.setColumns(10);
		updatePublishers_idBooksField.setBounds(147, 152, 495, 20);
		painelUpdadeLivros.add(updatePublishers_idBooksField);
		
		comboBoxBooks = new JComboBox();
		comboBoxBooks.setModel(boxBooks);
		comboBoxBooks.setRenderer(new BooksRenderer());
		comboBoxBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Books b = (Books) comboBoxBooks.getSelectedItem();
				updateTitleBooksField.setText(String.valueOf(b.getTitle()));
				updateIsbnBooksField.setText(String.valueOf(b.getIsbn()));
				updatePriceBooksField.setText(String.valueOf(b.getPrice()));
				updatePublishers_idBooksField.setText(String.valueOf(b.getPublisher_id()));
				
			}
		});
		comboBoxBooks.setBounds(147, 22, 443, 22);
		painelUpdadeLivros.add(comboBoxBooks);
		
		addBooksButton = new javax.swing.JButton();
		addBooksButton.setText("Adicionar ");
		addBooksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelLivros.setVisible(true);
				subPanelLivros.setSelectedIndex(0);
				
			}
		});
		addBooksButton.setForeground(new Color(240, 235, 227));
		addBooksButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		addBooksButton.setBackground(new Color(73, 83, 113));
		addBooksButton.setBounds(53, 70, 89, 23);
		PanelLivros.add(addBooksButton);
		
		getBooksButton = new javax.swing.JButton();
		getBooksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelLivros.setVisible(true);
				subPanelLivros.setSelectedIndex(1);
				botaoGetActionPerformed(e);
			}
		});
		getBooksButton.setText("Listar");
		getBooksButton.setForeground(new Color(240, 235, 227));
		getBooksButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		getBooksButton.setBackground(new Color(73, 83, 113));
		getBooksButton.setBounds(163, 70, 89, 23);
		PanelLivros.add(getBooksButton);
		
		JButton srcBooksButton = new JButton();
		srcBooksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelLivros.setVisible(true);
				subPanelLivros.setSelectedIndex(2);
			}
		});
		srcBooksButton.setText("Buscar");
		srcBooksButton.setForeground(new Color(240, 235, 227));
		srcBooksButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		srcBooksButton.setBackground(new Color(73, 83, 113));
		srcBooksButton.setBounds(278, 70, 89, 23);
		PanelLivros.add(srcBooksButton);
		
		delBooksButton = new javax.swing.JButton();
		delBooksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelLivros.setVisible(true);
				subPanelLivros.setSelectedIndex(3);
			}
		});
		delBooksButton.setText("Deletar");
		delBooksButton.setForeground(new Color(240, 235, 227));
		delBooksButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		delBooksButton.setBackground(new Color(73, 83, 113));
		delBooksButton.setBounds(393, 70, 89, 23);
		PanelLivros.add(delBooksButton);
		
		updateBooksButton = new javax.swing.JButton();
		updateBooksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanelLivros.setVisible(true);
				subPanelLivros.setSelectedIndex(4);
			}
		});
		updateBooksButton.setText("Atualizar");
		updateBooksButton.setForeground(new Color(240, 235, 227));
		updateBooksButton.setFont(new Font("David Libre", Font.PLAIN, 11));
		updateBooksButton.setBackground(new Color(73, 83, 113));
		updateBooksButton.setBounds(509, 69, 89, 23);
		PanelLivros.add(updateBooksButton);
		
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
	
	private javax.swing.JButton addButtonAuthors;
	private javax.swing.JButton addButtonPublishers;
	private javax.swing.JButton addButtonBooks;
	private javax.swing.JButton addButtonBooksAuthors;
	private javax.swing.JButton getAuthorsButton;
	private javax.swing.JButton getPublishersButton;
	private javax.swing.JButton getBooksButton;
	private javax.swing.JButton delAuthorsButton;
	private javax.swing.JButton delPublishersButton;
	private javax.swing.JButton delBooksButton;
	private javax.swing.JButton updateAuthorsButton;
	private javax.swing.JButton updatePublishersButton;
	private javax.swing.JButton updateBooksButton;
	private javax.swing.JButton addBooksButton;
	private javax.swing.JButton srcButtonAuthors;
	private javax.swing.JButton srcButtonPublishers;
	private javax.swing.JButton srcButtonBooks;
	private javax.swing.JButton delButtonAuthors;
	private javax.swing.JButton delButtonPublishers;
	private javax.swing.JButton delButtonBooks;
	private javax.swing.JButton updateButtonAuthors;
	private javax.swing.JButton updateButtonPublishers;
	private javax.swing.JButton updateButtonBooks;
	private JTextField titleBooksField;
	private JTextField isbnBooksField;
	private JTextField namePublishersField;
	private JTextField urlPublishersField;
	private JTextField priceBooksField;
	private JTable tableGetAuthors;
	private JComboBox comboBoxAuthors;
	private JComboBox comboBoxEdiBooks;
	private JComboBox comboBoxAutBooks;
	private JComboBox comboBoxPublishers;
	private JComboBox comboBoxBooks;
	
	
	
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
	private void botaoUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeAddActionPerformed
        // TODO add your handling code here:
    }
	
	
	AcessoBancodeDados  ABD = new AcessoBancodeDados();
	private JTextField nameSrcAuthorsField;
	private JTable tableSrcAuthors;
	private JTextField fnameSrcAuthorsField;
	private JTable tableDelAuthors;
	private JTextField delAuthorsField;
	private JTextField updateNameAuthorsField;
	private JTextField updateFnameAuthorsField;
	private JTextField updateAuthorsField;
	private JTextField nameSrcPublishersField;
	private JTextField delPublishersField;
	private JTextField updateNamePublishersField;
	private JTextField updateUrlPublishersField;
	private JTextField updateIdPublishersField;
	private JTextField titleSrcBooksField;
	private JTextField delBooksField;
	private JTextField seqBooksField;
	private JTable tableGetPublishers;
	private JTable tableSrcPublishers;
	private JTable tableDelPublishers;
	private JTable tableDelBooks;
	private JTable tableSrcBooks;
	private JTable tableGetBooks;
	private JTextField updateTitleBooksField;
	private JTextField updateIsbnBooksField;
	private JTextField updatePriceBooksField;
	private JTextField updatePublishers_idBooksField;
	
	
	@Override
	public void addActionListarPublishers(ActionListener al) {
		getPublishersButton.addActionListener(al);
		delPublishersButton.addActionListener(al);
		
	}
	@Override
	public void addActionListarAuthors(ActionListener al) {
		getAuthorsButton.addActionListener(al);
		delAuthorsButton.addActionListener(al);
		
		
	}
	@Override
	public void addActionListarBooks(ActionListener al) {
		getBooksButton.addActionListener(al);
		delBooksButton.addActionListener(al);
		
	}
	@Override
	public void addActionListarBooksauthors(ActionListener al) {
		//getBooksauthorsButton.addActionListener(al);
		
	}
	@Override
	public void listarPublishers(List<Publishers> publishers) {
		modelPublishers.setRowCount(0);
		for(Publishers p: publishers) {
			modelPublishers.addRow(new Object[] {p.getPublishers_id(), p.getNome(), p.getURL()});
			System.out.println(p.getPublishers_id() +" " + p.getNome()+" " + p.getURL());
		}
		
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
		modelBooks.setRowCount(0);
		for(Books b: books) {
			modelBooks.addRow(new Object[] {b.getTitle(), b.getIsbn(), b.getPublisher_id(), b.getPrice()});
			System.out.println(b.getTitle() +" " + b.getIsbn()+" " + b.getPublisher_id()+" " + b.getPrice());
		}
		
	}

	@Override
	public void listarBooksauthors(List<Booksauthors> booksauthors) {
		//modelBooksauthors.setRowCount(0);
		//for(Booksauthors ba: booksauthors) {
			//modelBooksauthors.addRow(new Object[] {ba.getisbn(), ba.getauthor_id(), ba.getseq_no()});
			//System.out.println(ba.getisbn() +" " + ba.getauthor_id()+" " + ba.getseq_no());
		//}
		
	}
	
	
	@Override
	public void addActionAdicionarPublishers(ActionListener al) {
		addButtonPublishers.addActionListener(al);
		
	}
	@Override
    public void addActionAdicionarAuthors(ActionListener al) {
		addButtonAuthors.addActionListener(al);
    }
	@Override
	public void addActionAdicionarBooks(ActionListener al) {
		addButtonBooks.addActionListener(al);
		
	}
	@Override
	public void addActionAdicionarBooksauthors(ActionListener al) {
		addButtonBooksAuthors.addActionListener(al);
		
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
		Publishers p = (Publishers) comboBoxEdiBooks.getSelectedItem();
		String title = titleBooksField.getText();
		String isbn = isbnBooksField.getText();
		int id = p.getPublishers_id();
		double price = Double.parseDouble(priceBooksField.getText());
		
		return new Books(title, isbn, id, price);
	}
	@Override
	public Booksauthors addBooksauthors() {
		String isbn = isbnBooksField.getText();
		int seq = Integer.parseInt(seqBooksField.getText());
		comboBoxAutBooks = new JComboBox();
		comboBoxEdiBooks.setModel(boxAuthors);
		comboBoxEdiBooks.setRenderer(new AuthorsRenderer());
		int input;
		input = JOptionPane.showConfirmDialog(this, comboBoxEdiBooks, "Selecione o Author", JOptionPane.DEFAULT_OPTION);
		if(input == JOptionPane.OK_OPTION) {
			Authors a = (Authors) comboBoxAuthors.getSelectedItem();
			int id = a.getAuthors_id();
			return new Booksauthors(isbn, id, seq);

		}else {
			return null;
		}
		
	}
	
	
	
	@Override
	public void addActionDeletarPublishers(ActionListener al) {
		delButtonPublishers.addActionListener(al);
		
	}
	@Override
	public void addActionDeletarAuthors(ActionListener al) {
		delButtonAuthors.addActionListener(al);
		
	}
	@Override
	public void addActionDeletarBooks(ActionListener al) {
		delButtonBooks.addActionListener(al);
		
	}
	@Override
	public void addActionDeletarBooksauthors(ActionListener al) {
		//delButtonBooksauthors.addActionListener(al);
		
	}
	@Override
	public int delPublishers() {
		int id = Integer.parseInt(delPublishersField.getText());
		return id;
	}
	@Override
	public int delAuthors() {
		int id = Integer.parseInt(delAuthorsField.getText());
		return id;
	}
	@Override
	public String delBooks() {
		String isbn = delBooksField.getText();
		return isbn;
	}
	@Override
	public int delBooksauthors() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	@Override
	public void addActionUpdatePublishers(ActionListener al) {
		updateButtonPublishers.addActionListener(al);
		
	}
	@Override
	public void addActionUpdateAuthors(ActionListener al) {
		updateButtonAuthors.addActionListener(al);
		
	}
	@Override
	public void addActionUpdateBooks(ActionListener al) {
		updateButtonBooks.addActionListener(al);
		
	}
	@Override
	public void addActionUpdateBooksauthors(ActionListener al) {
		//updateButtonBooksauthors.addActionListener(al);
		
	}
	@Override
	public Publishers updatePublishers() {
		int id = Integer.parseInt(updateIdPublishersField.getText());
		String name = updateNamePublishersField.getText();
        String url = updateUrlPublishersField.getText();
        return new Publishers(id, name, url);
	}
	@Override
	public Authors updateAuthors() {
		int id = Integer.parseInt(updateAuthorsField.getText());
		String name = updateNameAuthorsField.getText();
        String fname = updateFnameAuthorsField.getText();
        return new Authors(id, name, fname);
	}
	@Override
	public Books updateBooks() {
		String title = updateTitleBooksField.getText();
		String isbn = updateIsbnBooksField.getText();
		int publishers_id = Integer.parseInt(updatePublishers_idBooksField.getText());
        double price = Double.parseDouble(updatePriceBooksField.getText());
        return new Books(title, isbn, publishers_id, price);
	}
	@Override
	public Booksauthors updateBooksauthors() {
		//String isbn = updateIsbnBooksField.getText();
		//int authors_id = Integer.parseInt(updateAuthors_idBooksField.getText());
		//int seq = Integer.parseInt(updateSeqBooksField.getText());
        //return new Booksauthors(isbn, authors_id, seq);
		return null;
	}
	
	
	
	@Override
	public void addActionBuscaPublishers(ActionListener al) {
		srcButtonPublishers.addActionListener(al);
		
	}
	@Override
	public void srcPublishers(List<Publishers> publishers) {
		modelsrcPublishers.setRowCount(0);
		for(Publishers p: publishers) {
			modelsrcPublishers.addRow(new Object[] {p.getPublishers_id(), p.getNome(), p.getURL()});
			System.out.println(p.getPublishers_id() +" " + p.getNome()+" " + p.getURL());
		}
		
	}
	@Override
	public String getKeyPublishersBusca() {
		return nameSrcPublishersField.getText();
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
		return nameSrcAuthorsField.getText();
		 
	}
	@Override
	public String getKeyFnameAuthorsBusca() {
		return fnameSrcAuthorsField.getText();
		
	}
	@Override
	public void addActionBuscaBooks(ActionListener al) {
		srcButtonBooks.addActionListener(al);
		
	}
	@Override
	public void srcBooks(List<Books> books) {
		modelsrcBooks.setRowCount(0);
		for(Books b: books) {
			modelsrcBooks.addRow(new Object[] {b.getTitle(), b.getIsbn(), b.getPublisher_id(), b.getPrice()});
			System.out.println(b.getTitle() +" " + b.getIsbn()+" " + b.getPublisher_id()+" " + b.getPrice());
		}
		
	}
	@Override
	public String getKeyBooksBusca() {
		return titleSrcBooksField.getText();
	}
	@Override
	public void addActionBuscaBooksauthors(ActionListener al) {
		//srcButtonBooksauthors.addActionListener(al);
		
	}
	@Override
	public void srcBooksauthors(List<Booksauthors> booksauthors) {
		//modelsrcBooksauthors.setRowCount(0);
		//for(Booksauthors ba: booksauthors) {
			//modelsrcBooksauthors.addRow(new Object[] {ba.getisbn(), ba.getauthor_id(), ba.getseq_no()});
		//	System.out.println(ba.getisbn() +" " + ba.getauthor_id()+" " + ba.getseq_no());
		//}
		
	}
	@Override
	public String getKeyBooksauthorsBusca() {
		return titleSrcBooksField.getText();
	}
	
	@Override
	public void addActionListarBoxAuthors(ActionListener al) {
		updateAuthorsButton.addActionListener(al);
		addButtonBooksAuthors.addActionListener(al);
		
	}
	@Override
	public void boxAuthors(List<Authors> authors) {
		for(Authors a: authors) {
			boxAuthors.addElement(a);
		}
	}
	
	private class AuthorsRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			if(value instanceof Authors) {
				Authors a = (Authors) value;
				value = a.getNome() +" "+ a.getFname();
			}
			return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		}
		
	}
	
	@Override
	public void addActionListarBoxPublishers(ActionListener al) {
		addBooksButton.addActionListener(al);
		updatePublishersButton.addActionListener(al);
		
		
	}
	@Override
	public void boxPublishers(List<Publishers> publishers) {
		for(Publishers p: publishers) {
			boxPublishers.addElement(p);
		}
	}
	
	private class PublishersRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			if(value instanceof Publishers) {
				Publishers p = (Publishers) value;
				value = p.getNome();
			}
			return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		}
		
	}

	@Override
	public void addActionListarBoxBooks(ActionListener al) {
		updateBooksButton.addActionListener(al);
		
	}
	@Override
	public void boxBooks(List<Books> books) {
		for(Books b: books) {
			boxBooks.addElement(b);
		}
	}
	private class BooksRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			if(value instanceof Books) {
				Books b = (Books) value;
				value = b.getTitle();
			}
			return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		}
		
	}
}
