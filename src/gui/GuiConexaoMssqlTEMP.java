package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import java.sql.*;
 
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 

/*
 * Classe para teste, TEMPORÁRIO
 */


public class GuiConexaoMssqlTEMP implements ActionListener
{
    // Declara componentes
    private JLabel ltitulo;
    private JLabel lbanco;
    private JLabel lusuario;
    private JLabel lsenha;
    private JTextField tbanco;
    private JTextField tusuario;
    private JPasswordField tsenha;
    private JButton botao;
    private JFrame menssagem;
 
    // Declara objetos de conexão
    private Connection conn;
    private Statement query;
 
    public Container criaPainel()
    {
        // Cria painel principal
        JPanel painel = new  JPanel();
        painel.setLayout(new BorderLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 
        // Cria componente titulo
        ltitulo = new JLabel("Microsoft SQL Server Express");
 
        painel.add(ltitulo, BorderLayout.PAGE_START);
 
        // Cria painel de usuario
        JPanel painelDados = new JPanel(new GridLayout(0, 2, 10, 10));
 
        // Cria componentes de usuario
        lbanco   = new JLabel("Banco de dados:");
        lusuario = new JLabel("Digite seu Usuario: ");
        lsenha   = new JLabel("Digite sua Senha: ");
        tbanco   = new JTextField();
        tusuario = new JTextField();
        tsenha   = new JPasswordField();
 
        // Define tamanho dos campos
        tusuario.setPreferredSize( new Dimension(120, 20));
        tsenha.setPreferredSize( new Dimension(120, 20));
 
        // Adiciona componentes no grid do painel
        painelDados.add(Box.createVerticalStrut(10));
        painelDados.add(Box.createVerticalStrut(10));
        painelDados.add(lbanco);
        painelDados.add(tbanco);
        painelDados.add(lusuario);
        painelDados.add(tusuario);
        painelDados.add(lsenha);
        painelDados.add(tsenha);
        painelDados.add(Box.createVerticalStrut(10));
        painelDados.add(Box.createVerticalStrut(10));
 
        // Cria botão
        botao = new JButton("Conectar");
        botao.addActionListener(this);
 
        // Adiciona componentes no painel principal
        painel.add(painelDados);
        painel.add(botao, BorderLayout.PAGE_END);
 
        return painel;
    }
 
    public static void criaGUI()
    {
        // Cria formulario
        JFrame formulario = new JFrame("MSSQL Express 2012");
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // cria classe da conexão
        GuiConexaoMssqlTEMP conectar = new GuiConexaoMssqlTEMP();
 
        // Define painel
        formulario.setContentPane(conectar.criaPainel());
        formulario.pack();
 
        // Mostra aplicação
        formulario.setVisible(true);
    }
 
    public void conectar(String banco, String login, String senha) {
        try
        {
            // Define Driver de conexão JDBC thin
            String URL =  "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=" + banco +
                          ";user=" + login + ";password="+senha;
 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL);                      
 
                    //Executa pedido SQL
            query = conn.createStatement();
            JOptionPane.showMessageDialog(menssagem, "Conexão Efetuada com sucesso!");
        } 
 
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(menssagem, "Erro na conexão!");
            ex.printStackTrace();
        }
    }
 
    public void actionPerformed(ActionEvent arg0)
    {
       // Verfica tamanho da senha
        char[] tamanho = tsenha.getPassword();
 
        if (tamanho.length == 0)
 
        {
            JOptionPane.showMessageDialog(menssagem, "Digite uma senha!");
        }
        else
        {
            // recupera senha do Java Password Field
            String psenha = new String(tsenha.getPassword());
 
            //Cria conexão
            GuiConexaoMssqlTEMP conecta= new GuiConexaoMssqlTEMP();
            conecta.conectar(tbanco.getText(), tusuario.getText() , psenha);
 
        }
 
    }
 
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
 
            public void run() {
 
                // Cria e exibe GUI
                criaGUI();
 
            }
        });      
 
    }
}