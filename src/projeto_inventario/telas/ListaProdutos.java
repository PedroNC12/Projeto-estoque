package projeto_inventario.telas;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projeto_inventario.DAO.DAO;
import projeto_inventario.dados.Produto;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ListaProdutos extends JFrame {

	private JPanel contentPane;
	//Objeto de modelo para a tabela
	private DefaultTableModel modelo = new DefaultTableModel();
	//Criar a tabela
	private JTable tabela = new JTable(modelo);
	//Criar um ScrollPane para inserir a tabela
	private JScrollPane scrollPane = new JScrollPane(tabela);
	//Objeto da classe de acesso a dados
			DAO dao = new DAO();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaProdutos frame = new ListaProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Classe para criar uma tabela com as informações do banco
	public static void criarTabela() {
		JOptionPane.showMessageDialog(null, "teste");
	}

	/**
	 * Create the frame.
	 */
	public ListaProdutos() { 
		setTitle("Estoque");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 527, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmVendas = new JMenuItem("Venda");
		mntmVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vendas frame = new Vendas();
				frame.setVisible(true);
			}
		});
		menuBar.add(mntmVendas);
		
		JMenuItem mntmInserir = new JMenuItem("Inserir");
		mntmInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertProduto frame = new InsertProduto();
				frame.setVisible(true);
				
			}
		});
		
		JMenuItem mntmCompra = new JMenuItem("Compra");
		mntmCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compra frame = new Compra();
				frame.setVisible(true);
			}
		});
		menuBar.add(mntmCompra);
		menuBar.add(mntmInserir);
		
		JMenuItem mntmDeletar = new JMenuItem("Deletar");
		mntmDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto"));
				
				dao.deleteProduto(id);
			}
		});
		menuBar.add(mntmDeletar);
		
		JMenuItem mntmAtualizar = new JMenuItem("Atualizar");
		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.setNumRows(0);
				//Recuperar os dados do banco e adicioná-los ao modelo
				for(Produto p : dao.listarProdutos()) {
					modelo.addRow(new Object[] {p.getId(), p.getNome(), p.getQuantidade()});
				}
				
			}
		});
		menuBar.add(mntmAtualizar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
				
		//Adicionar as colunas ao modelo
		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Quantidade");
		
		//Recuperar os dados do banco e adicioná-los ao modelo
		for(Produto p : dao.listarProdutos()) {
			modelo.addRow(new Object[] {p.getId(), p.getNome(), p.getQuantidade()});
		}
		contentPane.setLayout(null);
		scrollPane.setBounds(37, 10, 453, 403);
		
		contentPane.add(scrollPane);
		
		
	}
}
