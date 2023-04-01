package projeto_inventario.telas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import projeto_inventario.DAO.DAO;
import projeto_inventario.dados.Produto;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertProduto extends JFrame {

	private JPanel contentPane;
	private JLabel lblNomeDoProduto;
	private JTextField textField;
	private JLabel lblQuantidade;
	private JTextField textField_1;
	private DAO dao = new DAO();
	private Produto produto = new Produto();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertProduto frame = new InsertProduto();
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
	public InsertProduto() {
		setTitle("Inserir produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 294, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNomeDoProduto = new JLabel("Nome do Produto");
		lblNomeDoProduto.setBounds(12, 12, 123, 15);
		contentPane.add(lblNomeDoProduto);
		
		textField = new JTextField();
		textField.setBounds(153, 10, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(12, 39, 90, 15);
		contentPane.add(lblQuantidade);
		
		textField_1 = new JTextField();
		textField_1.setBounds(153, 37, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quantidade = textField_1.getText();
				//Boolean para checar se os dados estão de acordo para enviar para o banco
				boolean check = true;
				
				textField_3.setVisible(false);
				textField_4.setVisible(false);
				
				//Checar se a quantidade possui apenas números
				for(int i = 0; i<quantidade.length(); i++) {
					char c = quantidade.charAt(i);
					
					
					switch(c) {
					case '0':
						break;
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
					default:
						check = false;
						textField_2.setText("*Apenas números permitidos");
						textField_4.setVisible(true);
					}
				}
				
				//Checar se algum dos valores não está preenchido
				if(textField.getText().isBlank()) {
					textField_2.setVisible(true);
					textField_2.setText("*Campo obrigatório");
					textField_3.setVisible(true);
					check = false;
				}
				if(quantidade.isBlank()) {
					textField_2.setVisible(true);
					textField_2.setText("*Campo obrigatório");
					textField_4.setVisible(true);
					check = false;
				}
				//checar se no banco já possui um item com o mesmo nome
				if(dao.visualizarProduto(textField.getText()).getNome()!=null&&check==true) {
					textField_2.setVisible(true);
					textField_2.setText("Nome deve ser exclusivo");
					check = false;
				}
				
				//Inserir o produto no banco desde que esteja tudo certo
				if(check==true){
				//Pegar o nome e a quantidade a serem adicionadas ao banco
				produto.setNome(textField.getText());
				produto.setQuantidade(Integer.parseInt(textField_1.getText()));
				
				dao.insert(produto);
				textField_2.setVisible(true);
				textField_2.setText("Sucesso");
				textField_3.setVisible(false);
				textField_4.setVisible(false);
				}
				
				
			}
		});
		btnSalvar.setBounds(12, 70, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setVisible(false);
				textField_3.setVisible(false);
				textField_4.setVisible(false);
			}
		});
		btnCancelar.setBounds(153, 70, 117, 25);
		contentPane.add(btnCancelar);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBorder(null);
		textField_2.setVisible(false);
		textField_2.setBounds(57, 98, 186, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(137, 10, 16, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		textField_3.setBorder(null);
		textField_3.setVisible(false);
		textField_3.setForeground(new Color(240, 0, 0));
		textField_3.setText("*");
		
		textField_4 = new JTextField();
		textField_4.setBounds(137, 37, 16, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		textField_4.setBorder(null);
		textField_4.setVisible(false);
		textField_4.setForeground(new Color(240, 0, 0));
		textField_4.setText("*");
	}
}
