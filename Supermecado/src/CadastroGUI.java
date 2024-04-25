import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CadastroGUI extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton produtoButton, clienteButton, funcionarioButton, fornecedorButton, pedidoButton;

    public CadastroGUI() {
        setTitle("Cadastro");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        produtoButton = new JButton("Cadastrar Produto");
        clienteButton = new JButton("Cadastrar Cliente");
        funcionarioButton = new JButton("Cadastrar Funcionário");
        fornecedorButton = new JButton("Cadastrar Fornecedor");
        pedidoButton = new JButton("Cadastrar Pedido");

        produtoButton.addActionListener(this);
        clienteButton.addActionListener(this);
        funcionarioButton.addActionListener(this);
        fornecedorButton.addActionListener(this);
        pedidoButton.addActionListener(this);

        panel.add(produtoButton);
        panel.add(clienteButton);
        panel.add(funcionarioButton);
        panel.add(fornecedorButton);
        panel.add(pedidoButton);

        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton) e.getSource()).getText();
        switch (buttonText) {
            case "Cadastrar Produto":
                cadastrarProduto();
                break;
            case "Cadastrar Cliente":
                cadastrarCliente();
                break;
            case "Cadastrar Funcionário":
                cadastrarFuncionario();
                break;
            case "Cadastrar Fornecedor":
                cadastrarFornecedor();
                break;
            case "Cadastrar Pedido":
                cadastrarPedido();
                break;
        }
    }

    public void cadastrarProduto() {
        Produto produto = new Produto();
        JOptionPane.showMessageDialog(this, "Cadastro de Produto");
        produto.nome = JOptionPane.showInputDialog(this, "Digite o nome do produto:");
        produto.preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite o preço do produto:"));
        produto.descricao = JOptionPane.showInputDialog(this, "Digite a descrição do produto:");
        produto.categoria = JOptionPane.showInputDialog(this, "Digite a categoria do produto:");
        produto.quantidadeEstoque = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite a quantidade em estoque do produto:"));

        mostrarDados(produto);
    }

    public void cadastrarCliente() {
        Cliente cliente = new Cliente();
        JOptionPane.showMessageDialog(this, "Cadastro de Cliente");
        cliente.nome = JOptionPane.showInputDialog(this, "Digite o nome do cliente:");
        cliente.telefone = JOptionPane.showInputDialog(this, "Digite o número de telefone do cliente:");
        cliente.endereco = JOptionPane.showInputDialog(this, "Digite o endereço do cliente:");
        cliente.cpf = JOptionPane.showInputDialog(this, "Digite o CPF do cliente:");
        cliente.email = JOptionPane.showInputDialog(this, "Digite o e-mail do cliente:");

        mostrarDados(cliente);
    }

    public void cadastrarFuncionario() {
        Funcionario funcionario = new Funcionario();
        JOptionPane.showMessageDialog(this, "Cadastro de Funcionário");
        funcionario.nome = JOptionPane.showInputDialog(this, "Digite o nome do funcionário:");
        funcionario.cargo = JOptionPane.showInputDialog(this, "Digite o cargo do funcionário:");
        funcionario.salario = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite o salário do funcionário:"));
        funcionario.codigoFuncionario = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o código do funcionário:"));
        funcionario.telefone = JOptionPane.showInputDialog(this, "Digite o telefone do funcionário:");

        mostrarDados(funcionario);
    }

    public void cadastrarFornecedor() {
        Fornecedor fornecedor = new Fornecedor();
        JOptionPane.showMessageDialog(this, "Cadastro de Fornecedor");
        fornecedor.nome = JOptionPane.showInputDialog(this, "Digite o nome do fornecedor:");
        fornecedor.endereco = JOptionPane.showInputDialog(this, "Digite o endereço do fornecedor:");
        fornecedor.telefone = JOptionPane.showInputDialog(this, "Digite o telefone do fornecedor:");
        fornecedor.categoriaProdutos = JOptionPane.showInputDialog(this, "Digite a categoria de produtos fornecidos:");
        fornecedor.cnpj = JOptionPane.showInputDialog(this, "Digite o CNPJ do fornecedor:");

        mostrarDados(fornecedor);
    }

    public void cadastrarPedido() {
        Pedido pedido = new Pedido();
        JOptionPane.showMessageDialog(this, "Cadastro de Pedido");
        pedido.numeroPedido = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o número do pedido:"));
        pedido.dataPedido = JOptionPane.showInputDialog(this, "Digite a data do pedido:");
        pedido.clienteComprador = JOptionPane.showInputDialog(this, "Digite o nome do cliente comprador:");
        pedido.totalPedido = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite o total do pedido:"));
        pedido.quantidadeProdutos = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite a quantidade de produtos do pedido:"));

        mostrarDados(pedido);
    }

    public void mostrarDados(Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        for (java.lang.reflect.Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                stringBuilder.append(field.getName()).append(": ").append(field.get(obj)).append("\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(this, "Dados cadastrados:\n" + stringBuilder.toString());
    }

    public static void main(String[] args) {
        new CadastroGUI();
    }
}
