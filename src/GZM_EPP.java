import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GZM_EPP extends javax.swing.JFrame {

    //Flag para la actualización
    private static int CarFlaAct = 0;
    //Comando activo al clickear boton
    /*
    1. Adicionar
    2. Modificar
    3. Eliminar
    4. Inactivar
    5. Reactivar */
    private static int comandoActivo = 1; 
    //Conexion con la DB
    private Conexion conexion = new Conexion();
    private Connection conn = conexion.conn;
    
    public GZM_EPP() {
        getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        initComponents();
        llenarTablaCargo();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codField = new javax.swing.JTextField();
        desField = new javax.swing.JTextField();
        estRegField = new javax.swing.JTextField();
        advertenciaLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCargo = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnInactivar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnReactivar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Tabla EPPs");
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("EPP");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(229, 229, 229));

        jLabel3.setText("Codigo:");

        jLabel4.setText("Nombre");

        jLabel5.setText("Estado Registro:");

        codField.setEditable(false);

        desField.setEditable(false);

        estRegField.setEditable(false);
        estRegField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        estRegField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        estRegField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        advertenciaLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        
        JLabel Marca = new JLabel("CODIGO Marca: ");
        
        lblNewLabel = new JLabel("Stock:");
        
        stockField = new JTextField();
        stockField.setEditable(false);
        stockField.setHorizontalAlignment(SwingConstants.CENTER);
        stockField.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        marcaField = new JTextField();
        marcaField.setHorizontalAlignment(SwingConstants.CENTER);
        marcaField.setFont(new Font("Segoe UI", Font.BOLD, 12));
        marcaField.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel3)
        				.addComponent(jLabel5)
        				.addComponent(lblNewLabel)
        				.addComponent(jLabel4)
        				.addComponent(Marca))
        			.addGap(37)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(estRegField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(codField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(advertenciaLabel))
        				.addComponent(desField, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
        				.addComponent(stockField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(marcaField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(9)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(codField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(advertenciaLabel))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(desField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel)
        				.addComponent(stockField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Marca)
        				.addComponent(marcaField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(estRegField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        jPanel2.setLayout(jPanel2Layout);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Registro de EPPs");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        				.addComponent(jLabel2))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(jLabel2)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(229, 229, 229));

        tablaCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCargo.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tablaCargo);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tabla_EPP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnInactivar.setText("Inactivar");
        btnInactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInactivarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnReactivar.setText("Reactivar");
        btnReactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReactivarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInactivar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReactivar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInactivar)
                    .addComponent(btnReactivar)
                    .addComponent(btnActualizar)
                    .addComponent(btnSalir))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(jLabel1)
        					.addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        codField.setText("");
        desField.setText("");
        marcaField.setText("");
        stockField.setText("");
        estRegField.setText(""); 
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {        
            esperar(10000);
            dispose();
            }
        });
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        codField.setText("");
        desField.setText("");
        stockField.setText("");
        marcaField.setText("");
        
        estRegField.setText(""); 
        switch(comandoActivo) {
            case 1 -> btnAdicionar.setEnabled(false);
            case 2 -> btnModificar.setEnabled(false);
            case 3 -> btnEliminar.setEnabled(false);
            case 4 -> btnInactivar.setEnabled(false);
            case 5 -> btnReactivar.setEnabled(false);           
        }
        if(comandoActivo==0) {
            btnAdicionar.setEnabled(true);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnInactivar.setEnabled(true);
            btnReactivar.setEnabled(true);           
        }
        desactivarFields();
        comandoActivo = 0;
        //Cambiamos el flag a 0
        CarFlaAct = 0;
    }//GEN-LAST:event_btnCancelarActionPerformed
  

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        codField.setText("");
        desField.setText("");
        stockField.setText("");
        marcaField.setText("");
        
        estRegField.setText("A");
        
        
        codField.setEditable(true);
        desField.setEditable(true);
        stockField.setEditable(true);
        marcaField.setEditable(true);
        estRegField.setEditable(false);
        
        btnActualizar.setEnabled(true);
        codField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verLongitudCod();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verLongitudCod();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verLongitudCod();
            }
            
        });
        
        //Flag Activada
        CarFlaAct = 1;
        //Reconociendo comando
        comandoActivo = 1;
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(CarFlaAct == 1) {
            String codigo = codField.getText();
            String descripcion = desField.getText();
            String estadoRegistro = estRegField.getText();
           String marca= marcaField.getText();
           String stock=stockField.getText();
            try {
                PreparedStatement stmt;
                switch(comandoActivo) {      
                    case 1 -> { 
                        stmt = conn.prepareStatement("INSERT INTO GZM_EPP (EppCod, EppNom, EppSto, MarCod, EstRegCod) VALUES (?,?, ?, ?,?)");
                        stmt.setString(1, codigo);
                        stmt.setString(2, descripcion);
                        stmt.setString(3, stock);
                        stmt.setString(4, marca);
                        stmt.setString(5, estadoRegistro);
                    }
                    case 2 -> { 
                        stmt = conn.prepareStatement("UPDATE GZM_EPP SET EppNom = ? WHERE EppCod = ?");
                        stmt.setString(1, descripcion);
                        stmt.setString(2, codigo);
                    }
                    
                    case 3->{
                    	 stmt = conn.prepareStatement("UPDATE GZM_EPP SET EppSto = ? WHERE EppCod = ?");
                    	 stmt.setString(3, stock);
                         stmt.setString(2, codigo);
                    }
                    
                    case 4->{
                   	 stmt = conn.prepareStatement("UPDATE GZM_EPP SET MarCod = ? WHERE EppCod = ?");
                   	 stmt.setString(4, marca);
                     stmt.setString(2, codigo);
                   }
                    default -> {
                        stmt = conn.prepareStatement("UPDATE GZM_EPP SET EstRegCod = ? WHERE EppCod = ?");
                        stmt.setString(1, estadoRegistro);
                        stmt.setString(2, codigo);
                    }
                }
                
                //Ejecutar inserciones o actualizaciones
                stmt.executeUpdate();
                
            }catch(SQLException e) {
                System.out.println("Error: "+e);
            }
            llenarTablaCargo();
            CarFlaAct = 0;
            desactivarFields();
            comandoActivo = 0;
            codField.setText("");
            desField.setText("");
            stockField.setText("");
            marcaField.setText("");
            estRegField.setText("");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int filaSeleccionada = tablaCargo.getSelectedRow();
        if(filaSeleccionada != -1) {
            comandoActivo = 2;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosField(filaSeleccionada);
            codField.setEditable(false);
            String estReg = estRegField.getText();
            desField.setEditable(true);
            if(estReg.equals("I" )||estReg.equals("*"))
                btnActualizar.setEnabled(false);
            else
                btnActualizar.setEnabled(true);
            estRegField.setEditable(false);
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tablaCargo.getSelectedRow();
        btnActualizar.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 3;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosField(filaSeleccionada);
            estRegField.setText("*");            
            desactivarFields();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnInactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInactivarActionPerformed
        int filaSeleccionada = tablaCargo.getSelectedRow();
        btnActualizar.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 4;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosField(filaSeleccionada);
            estRegField.setText("I");
            desactivarFields();
        }
    }//GEN-LAST:event_btnInactivarActionPerformed

    private void btnReactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReactivarActionPerformed
        int filaSeleccionada = tablaCargo.getSelectedRow();
        btnActualizar.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 5;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosField(filaSeleccionada);
            estRegField.setText("A");
            desactivarFields();
            
        }
    }//GEN-LAST:event_btnReactivarActionPerformed

    private void verLongitudCod(){
        int longitud = codField.getText().length();
        if(longitud > 3) {
            advertenciaLabel.setText("*Demasiados Caracteres*");
            btnActualizar.setEnabled(false);
        } else {
            advertenciaLabel.setText("");
            btnActualizar.setEnabled(true);
        }
    }
    
    private void cargarDatosField(int fila) {
        String codigo = (String) modelo.getValueAt(fila, 0);
        String descripcion = (String) modelo.getValueAt(fila, 1);
        String stock = (String) modelo.getValueAt(fila, 2);
        String marca = (String) modelo.getValueAt(fila, 3);
        String estReg = (String) modelo.getValueAt(fila, 4);
        codField.setText(codigo);
        desField.setText(descripcion);
        stockField.setText(stock);
        marcaField.setText(marca);
        estRegField.setText(estReg);
        
    }
    
    private void desactivarFields() {
        codField.setEditable(false);
        desField.setEditable(false);
        marcaField.setEditable(false);
        stockField.setEditable(false);
        estRegField.setEditable(false);
    }
    private void llenarTablaCargo() {        
        modelo.setColumnIdentifiers(new Object[]{"Codigo", "Nombre","Stock","Marca", "Estado Registro"});
        modelo.setRowCount(0);
        try {
            //Consulta de selección 
        	//NSERT INTO GZM_EPP (EppCod, EppNom, EppSto, MarCod, EstRegCod) 
            Statement statement = conn.createStatement();
            String consulta = "SELECT EppCod,EppNom, EppSto, MarCod, EstRegCod FROM GZM_EPP WHERE EstRegCod NOT IN ('*')";
            ResultSet rs = statement.executeQuery(consulta);
            
            //Agregando los datos
            while(rs.next()) {
                modelo.addRow(new Object[]{rs.getString("EppCod"), rs.getString("EppNom"), rs.getString("EppSto"), rs.getString("MarCod"), rs.getString("EstRegCod")});
            }
            //Asigna Modelo a tabla
            tablaCargo.setModel(modelo);
            
            
        }catch(SQLException e) {
            System.out.println("Error: "+e);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advertenciaLabel;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInactivar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReactivar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField codField;
    private javax.swing.JTextField desField;
    private javax.swing.JTextField estRegField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCargo;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modelo = new DefaultTableModel();
    private JLabel lblNewLabel;
    private JTextField stockField;
    private JTextField marcaField;
    
    private void esperar(int time) {
        for(int i=0; i<time; i++)
            System.out.println(i+1);
    }
}
