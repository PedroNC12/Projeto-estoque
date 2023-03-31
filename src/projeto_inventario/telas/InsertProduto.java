package projeto_inventario.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 294, 141);
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
				produto.setNome(textField.getText());
				produto.setQuantidade(Integer.parseInt(textField_1.getText()));
				
				dao.insert(produto);
			}
		});
		btnSalvar.setBounds(12, 70, 117, 25);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnCancelar.setBounds(153, 70, 117, 25);
		contentPane.add(btnCancelar);
	}
}
