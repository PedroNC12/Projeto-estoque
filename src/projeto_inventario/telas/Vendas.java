package projeto_inventario.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projeto_inventario.DAO.DAO;
import projeto_inventario.dados.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Vendas extends JFrame {

	private JPanel contentPane;
	private DAO dao = new DAO();
	private Produto produto = new Produto();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendas frame = new Vendas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vendas() {
		setTitle("Venda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProdutoVendido = new JLabel("Produto vendido");
		lblProdutoVendido.setBounds(12, 12, 128, 15);
		contentPane.add(lblProdutoVendido);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(187, 12, 105, 24);
		contentPane.add(comboBox);
		
		JLabel lblQuantidadeVendida = new JLabel("Quantidade");
		lblQuantidadeVendida.setBounds(12, 59, 142, 15);
		contentPane.add(lblQuantidadeVendida);
		
		textField = new JTextField();
		textField.setBounds(187, 59, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				boolean check = true;
				
				for(int i = 0; i<text.length(); i++) {
					char c = text.charAt(i);
					switch(c) {
					case '1':
						break;
					case '2':
						break;
					case '3':
						break;
					case '4':
						break;
					case '5':
						break;
					case '6':
						break;
					case '7':
						break;
					case '8':
						break;
					case '9':
						break;
					case '0':
						break;
					default:
						textField_1.setText("*Apenas números permitidos");
						textField_1.setVisible(true);
						check=false;
						i = text.length();
					}
				}if(text.isBlank()) {
					textField_1.setText("*Este campo é obrigatório");
					textField_1.setVisible(true);
				}else if(check==true) {
					produto = dao.visualizarProduto(comboBox.getSelectedItem().toString());
					int q = produto.getQuantidade();
					q = q - Integer.parseInt(textField.getText());
					dao.updateQuantidade(q, produto.getNome());
					textField_2.setVisible(true);
					textField_1.setVisible(false);
				}
				
			}
		});
		btnRegistrar.setBounds(90, 99, 117, 25);
		contentPane.add(btnRegistrar);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(240, 0, 0));
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 10));
		textField_1.setBounds(174, 78, 148, 19);
		textField_1.setBorder(null);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBorder(null);
		textField_2.setVisible(false);
		textField_2.setText("Venda realizada");
		textField_2.setBounds(93, 124, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_1.setVisible(false);
		
		for(Produto p : dao.listarProdutos()) {
			comboBox.addItem(p.getNome());
		}
		
		/*
		 * produto = dao.visualizarProduto(comboBox.getSelectedItem().toString());
					int q = produto.getQuantidade();
					q = q - Integer.parseInt(textField.getText());
					dao.updateQuantidade(q, produto.getNome());
		 */
		
	}
}
