package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaBicicleta extends JFrame {
    //Labels
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblTamaño;
    private JLabel lblColor;
    private JLabel lblTipo;
    private JLabel lblUrl;

    private JLabel lblNewNombre;
    private JLabel lblNewTamaño;
    private JLabel lblNewColor;
    private JLabel lblNewTipo;
    private JLabel lblNewUrl;

    //Texto
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtTamaño;
    private JTextField txtColor;
    private JTextField txtTipo;
    private JTextField txtUrl;

    private JTextField txtNewNombre;
    private JTextField txtNewTamaño;
    private JTextField txtNewColor;
    private JTextField txtNewTipo;
    private JTextField txtNewUrl;

    //Botones

    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnActualizar;
    private JButton btnBorrar;

    //Tabla
    private JTable tblBicicleta;
    private JScrollPane scrollPane;
    private GridLayout layout;

    //Paneles
    private JPanel panel1;// formulario
    private JPanel panel2;// tabla
    private JPanel panel3; // imagen
    private JPanel panel4; // editar

    private JLabel imagenBicicleta;

    public VentanaBicicleta(String title) throws HeadlessException {
        super(title);
        this.setSize(950,950);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);
        //panel
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(234, 109, 165));

        lblId = new JLabel("Id: ");
        lblNombre = new JLabel("Nombre: ");
        lblTamaño = new JLabel("Tamaño: ");
        lblColor = new JLabel("Color: ");
        lblTipo = new JLabel("Tipo: ");
        lblUrl = new JLabel("Url: ");

        txtId = new JTextField(5);

        txtId.setText("0");
        txtId.setEnabled(false);

        txtNombre = new JTextField(30);
        txtTamaño = new JTextField(30);
        txtColor = new JTextField(20);
        txtTipo = new JTextField(20);
        txtUrl = new JTextField(30);

        btnAgregar = new JButton("Agregar");

        panel1.add(lblId);
        panel1.add(txtId);

        panel1.add(lblNombre);
        panel1.add(txtNombre);

        panel1.add(lblTamaño);
        panel1.add(txtTamaño);

        panel1.add(lblColor);
        panel1.add(txtColor);

        panel1.add(lblTipo);
        panel1.add(txtTipo);

        panel1.add(lblUrl);
        panel1.add(txtUrl);

        panel1.add(btnAgregar);



        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(162, 116, 250));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblBicicleta = new JTable();
        scrollPane = new JScrollPane(tblBicicleta);
        panel2.add(scrollPane);


        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(236, 159, 241, 255));
        imagenBicicleta = new JLabel("Imagen de la bicicleta");
        panel3.add(imagenBicicleta);



        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(151, 238, 202));


        lblNewNombre = new JLabel("Bicicleta nueva: ");
        lblNewTamaño = new JLabel("Tamaño de la bicicleta: ");
        lblNewColor = new JLabel("Color de la bicicleta: ");
        lblNewTipo= new JLabel("Tamaño de la bicicleta: ");
        lblNewUrl = new JLabel("Imagen de la bicicleta: ");



        txtNewNombre = new JTextField(25);
        txtNewTamaño = new JTextField(20);
        txtNewColor = new JTextField(20);
        txtNewTipo = new JTextField(20);
        txtNewUrl = new JTextField(40);

        btnActualizar = new JButton("Actualizar");
        btnBorrar = new JButton("Borrar");

        panel4.add(btnBorrar);

        panel4.add(lblNewNombre);
        panel4.add(txtNewNombre);
        panel4.add(lblNewTamaño);
        panel4.add(txtNewTamaño);
        panel4.add(lblNewColor);
        panel4.add(txtNewColor);
        panel4.add(lblNewTipo);
        panel4.add(txtNewTipo);
        panel4.add(lblNewUrl);
        panel4.add(txtNewUrl);

        panel4.add(btnActualizar);


        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblTamaño() {
        return lblTamaño;
    }

    public void setLblTamaño(JLabel lblTamaño) {
        this.lblTamaño = lblTamaño;
    }

    public JLabel getLblAltura() {
        return lblColor;
    }

    public void setLblColor(JLabel lblColor) {
        this.lblColor = lblColor;
    }

    public JLabel getLblTipo() {
        return lblTipo;
    }

    public void setLblTipo(JLabel lblTipo) {
        this.lblTipo = lblTipo;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtTamaño() {
        return txtTamaño;
    }

    public void setTxtTamaño(JTextField txtTamaño) {
        this.txtTamaño = txtTamaño;
    }

    public JTextField getTxtColor() {
        return txtColor;
    }

    public void setTxtColor(JTextField txtColor) {
        this.txtColor = txtColor;
    }

    public JTextField getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(JTextField txtTipo) {
        this.txtTipo = txtTipo;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JTable getTblBicicleta() {
        return tblBicicleta;
    }

    public void setTblBicicleta(JTable tblBicicleta) {
        this.tblBicicleta = tblBicicleta;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JLabel getLblColor() {
        return lblColor;
    }

    public JLabel getLblNewUrl() {
        return lblNewUrl;
    }

    public void setLblNewUrl(JLabel lblNewUrl) {
        this.lblNewUrl = lblNewUrl;
    }

    public JTextField getTxtNewTamaño() {
        return txtNewTamaño;
    }

    public void setTxtNewTamaño(JTextField txtNewTamaño) {
        this.txtNewTamaño = txtNewTamaño;
    }

    public JTextField getTxtNewColor() {
        return txtNewColor;
    }

    public void setTxtNewColor(JTextField txtNewColor) {
        this.txtNewColor = txtNewColor;
    }

    public JTextField getTxtNewTipo() {
        return txtNewTipo;
    }

    public void setTxtNewTipo(JTextField txtNewTipo) {
        this.txtNewTipo = txtNewTipo;
    }

    public JTextField getTxtNewUrl() {
        return txtNewUrl;
    }

    public void setTxtNewUrl(JTextField txtNewUrl) {
        this.txtNewUrl = txtNewUrl;
    }

    public JLabel getImagenBicicleta() {
        return imagenBicicleta;
    }

    public void setImagenBicicleta(JLabel imagenBicicleta) {
        this.imagenBicicleta = imagenBicicleta;
    }


    public void limpiar(){
        txtNombre.setText("");
        txtTamaño.setText("");
        txtColor.setText("");
        txtTipo.setText("");
        txtUrl.setText("");
    }

    public Component getBtnBorrar() {
        return null;
    }

    public Component getBtnActualizar() {
        return null;
    }

    public AbstractButton getTxtNewNombre() {
        return null;
    }
}