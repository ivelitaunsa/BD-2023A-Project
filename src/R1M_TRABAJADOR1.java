import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class R1M_TRABAJADOR1 extends JFrame {
	private JPanel contentPane;
	private JTextField Text_Codigo;
	private JTextField Text_Nombre;
	private JTextField Text_DNI;
	private JTable table;
	private JComboBox comboEstado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					R1M_TRABAJADOR1 frame = new R1M_TRABAJADOR1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public R1M_TRABAJADOR1() {
		setResizable(false);
		setTitle("Registro Trabajador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(415, 43, 367, 218);
		contentPane.add(table);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalir.setBounds(707, 354, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnActualizar.setBounds(608, 354, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnReactivar = new JButton("Reactivar");
		btnReactivar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnReactivar.setBounds(509, 354, 89, 23);
		contentPane.add(btnReactivar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(707, 309, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnInactivar = new JButton("Inactivar");
		btnInactivar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnInactivar.setBounds(410, 354, 89, 23);
		contentPane.add(btnInactivar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEliminar.setBounds(608, 309, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModificar.setBounds(509, 309, 89, 23);
		contentPane.add(btnModificar);
		
		comboEstado = new JComboBox();
		comboEstado.setBounds(140, 259, 41, 22);
		contentPane.add(comboEstado);
		
		JComboBox comboGenero = new JComboBox();
		comboGenero.setBounds(140, 228, 158, 22);
		contentPane.add(comboGenero);
		
		JComboBox comboDepartamento = new JComboBox();
		comboDepartamento.setBounds(140, 197, 158, 22);
		contentPane.add(comboDepartamento);
		
		JComboBox comboCargo = new JComboBox();
		comboCargo.setBounds(140, 166, 158, 22);
		contentPane.add(comboCargo);
		
		JComboBox comboRango = new JComboBox();
		comboRango.setBounds(140, 135, 158, 22);
		contentPane.add(comboRango);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGenero.setBounds(29, 228, 63, 20);
		contentPane.add(lblGenero);
		
		Text_DNI = new JTextField();
		Text_DNI.setBounds(140, 105, 158, 20);
		contentPane.add(Text_DNI);
		Text_DNI.setColumns(10);
		
		Text_Nombre = new JTextField();
		Text_Nombre.setBounds(140, 74, 158, 20);
		contentPane.add(Text_Nombre);
		Text_Nombre.setColumns(10);
		
		Text_Codigo = new JTextField();
		Text_Codigo.setBounds(140, 43, 158, 20);
		contentPane.add(Text_Codigo);
		Text_Codigo.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDepartamento.setBounds(29, 197, 110, 20);
		contentPane.add(lblDepartamento);
		
		JLabel lblRango = new JLabel("Rango");
		lblRango.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRango.setBounds(29, 135, 63, 20);
		contentPane.add(lblRango);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setBounds(410, 309, 89, 23);
		contentPane.add(btnAdicionar);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCargo.setBounds(29, 166, 63, 20);
		contentPane.add(lblCargo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEstado.setBounds(29, 259, 63, 20);
		contentPane.add(lblEstado);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDni.setBounds(29, 104, 63, 20);
		contentPane.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNombre.setBounds(29, 73, 63, 20);
		contentPane.add(lblNombre);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCodigo.setBounds(29, 42, 63, 20);
		contentPane.add(lblCodigo);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(240, 240, 240));
		editorPane.setForeground(new Color(192, 192, 192));
		editorPane.setBounds(16, 30, 362, 368);
		contentPane.add(editorPane);
		
		JEditorPane EditorPane_1 = new JEditorPane();
		EditorPane_1.setFont(new Font("Arial", Font.PLAIN, 11));
		EditorPane_1.setText("Registro de Trabajador Cabecera");
		EditorPane_1.setEditable(false);
		EditorPane_1.setBackground(new Color(192, 192, 192));
		EditorPane_1.setBounds(10, 11, 379, 398);
		contentPane.add(EditorPane_1);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setForeground(Color.LIGHT_GRAY);
		editorPane_2.setBackground(UIManager.getColor("Button.background"));
		editorPane_2.setBounds(410, 30, 379, 239);
		contentPane.add(editorPane_2);
		
		JEditorPane dtrpnTablaTrabajadorCabecera = new JEditorPane();
		dtrpnTablaTrabajadorCabecera.setText("Tabla Trabajador Cabecera");
		dtrpnTablaTrabajadorCabecera.setFont(new Font("Arial", Font.PLAIN, 11));
		dtrpnTablaTrabajadorCabecera.setBackground(Color.LIGHT_GRAY);
		dtrpnTablaTrabajadorCabecera.setBounds(399, 11, 403, 270);
		dtrpnTablaTrabajadorCabecera.setEditable(false);
		contentPane.add(dtrpnTablaTrabajadorCabecera);
		
		JEditorPane dtrpnTablaTrabajadorCabecera_1 = new JEditorPane();
		dtrpnTablaTrabajadorCabecera_1.setFont(new Font("Arial", Font.PLAIN, 11));
		dtrpnTablaTrabajadorCabecera_1.setBackground(Color.LIGHT_GRAY);
		dtrpnTablaTrabajadorCabecera_1.setBounds(399, 292, 403, 117);
		contentPane.add(dtrpnTablaTrabajadorCabecera_1);
		
	}
	


    
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
