package projeto_inventario.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projeto_inventario.DAO.DAO;
import projeto_inventario.dados.Produto;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Compra extends JFrame {

	private JPanel contentPane;
	private DAO dao = new DAO();
	private JTextField textField;
	private JTextField textField_1;
	private Produto produto = new Produto();
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compra frame = new Compra();
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
	public Compra() {
		setTitle("Compra");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 245, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(12, 12, 70, 15);
		contentPane.add(lblProduto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(116, 7, 105, 24);
		contentPane.add(comboBox);
		
		JLabel lblQuantidadeComprada = new JLabel("Quantidade");
		lblQuantidadeComprada.setBounds(12, 51, 99, 15);
		contentPane.add(lblQuantidadeComprada);
		
		textField = new JTextField();
		textField.setBounds(116, 51, 105, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				boolean check = true;
				
				//Checar se possui alguma letra na área de quantidade
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
					q = q + Integer.parseInt(textField.getText());
					dao.updateQuantidade(q, produto.getNome());
					textField_2.setVisible(true);
					textField_1.setVisible(false);
				}
				
			}
			
		});
		btnRegistrar.setBounds(58, 93, 117, 25);
		contentPane.add(btnRegistrar);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 72, 148, 19);
		textField_1.setForeground(new Color(240, 0, 0));
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 10));
		textField_1.setBorder(null);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBorder(null);
		textField_2.setVisible(false);
		textField_2.setText("Compra realizada");
		textField_2.setBounds(58, 118, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_1.setVisible(false);
		
		for(Produto p : dao.listarProdutos()) {
			comboBox.addItem(p.getNome());
		}
	}

}
