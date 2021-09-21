package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroInterface extends JFrame {

	private JPanel contentPane;
	private CadastroCliente jif;
	private CadastroFuncionario jif2;
	private JInternalProduto jif3;
	private JInternalCategoria jif4;
	private JInternalContato jif5;
	private JInternalVenda jif6;
	private JInternalItemVenda jif7;
	private JInternalProdutoList jif8;
	private JInternalCategoriaList jif9;
	private JInternalClienteList jif10;
	private JInternalContatoList jif11;
	private JInternalFuncionarioList jif12;
	private JInternalVendaList jif13;
	private JInternalItemVendaList jif14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroInterface frame = new CadastroInterface();
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
	public CadastroInterface() {
		setTitle("Cadastro de pessoas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mnCadastros.add(mntmCliente);
		
		JMenuItem mntmFuncionrio = new JMenuItem("Funcion\u00E1rio");
		mnCadastros.add(mntmFuncionrio);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mnCadastros.add(mntmProduto);
		
		JMenuItem mntmCategoria = new JMenuItem("Categoria");
		mnCadastros.add(mntmCategoria);
		
		JMenuItem mntmContato = new JMenuItem("Contato");
		mnCadastros.add(mntmContato);
		
		JMenuItem mntmVenda = new JMenuItem("Venda");
		mnCadastros.add(mntmVenda);
		
		JMenuItem mntmItemvenda = new JMenuItem("ItemVenda");
		mnCadastros.add(mntmItemvenda);
		
		JMenu mnRelatrio = new JMenu("Relat\u00F3rio");
		menuBar.add(mnRelatrio);
		
		JMenu mnListagem = new JMenu("Listagem");
		menuBar.add(mnListagem);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mnListagem.add(mntmProdutos);
		
		JMenuItem mntmCategorias = new JMenuItem("Categorias");
		mnListagem.add(mntmCategorias);
		
		JMenuItem mntmCliente_1 = new JMenuItem("Clientes");
		mnListagem.add(mntmCliente_1);
		
		JMenuItem mntmContato_1 = new JMenuItem("Contatos");
		mnListagem.add(mntmContato_1);
		
		JMenuItem mntmFuncionrios = new JMenuItem("Funcion\u00E1rios");
		mnListagem.add(mntmFuncionrios);
		
		JMenuItem mntmVenda_1 = new JMenuItem("Venda");
		mnListagem.add(mntmVenda_1);
		
		JMenuItem mntmItemvenda_1 = new JMenuItem("ItemVenda");
		mnListagem.add(mntmItemvenda_1);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		mntmItemvenda_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInternalItemVendaList(desktopPane);
			}
		});
		
		mntmVenda_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInternalFrameVendaList(desktopPane);
			}
		});
		
		mntmFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInternalFrameFuncionarioList(desktopPane);
			}
		});
		
		mntmContato_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInternalFrameContatoList(desktopPane);
			}
		});
		
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInternalFrameClienteList(desktopPane);
			}
		});
		
		mntmCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInternalFrameCategoriaList(desktopPane);
			}
		});
		
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openInternalFrameProdutoList(desktopPane);
			}
		});
		
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInternalFrameProduto(desktopPane);
			}
		});
		
		mntmCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInternalFrameCategoria(desktopPane);
			}
		});
		
		mntmContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInternalFrameContato(desktopPane);
			}
		});
		
		mntmVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInternalFrameVenda(desktopPane);
			}
		});
		
		mntmItemvenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openInternalFrameItemVenda(desktopPane);
			}
		});
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Cadastrar cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openInternalFrameCliente(desktopPane);
			}
		});
		btnNewButton.setIcon(new ImageIcon(CadastroInterface.class.getResource("/icones/Person-32.png")));
		toolBar.add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openInternalFrameFuncionario(desktopPane);
			}
		});
		button.setToolTipText("Cadastrar funcion\u00E1rio");
		button.setIcon(new ImageIcon(CadastroInterface.class.getResource("/icones/Business Man Blue_32.png")));
		toolBar.add(button);
		
		JButton btnCadastrarProduto = new JButton("Cadastrar produto");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openInternalFrameProduto(desktopPane);
			}
		});
		toolBar.add(btnCadastrarProduto);
		
	}
	
	protected void openInternalItemVendaList(JDesktopPane jdp) {
		if(jif14 == null) {
			jif14 = new JInternalItemVendaList();
			jdp.add(jif14);
		}
		
	}

	public void openInternalFrameVendaList(JDesktopPane jdp) {
		if(jif13 == null) {
			jif13 = new JInternalVendaList();
			jdp.add(jif13);
		}
	}

	public void openInternalFrameCliente(JDesktopPane jdp) {
		if(jif == null) {
			jif = new CadastroCliente();
			jdp.add(jif);
		}
	}
	
	public void openInternalFrameFuncionario(JDesktopPane jdp) {
		if(jif2 == null) {
			jif2 = new CadastroFuncionario();
			jdp.add(jif2);
		}
	}
	
	public void openInternalFrameProduto(JDesktopPane jdp) {
		if(jif3 == null) {
			jif3 = new JInternalProduto();
			jdp.add(jif3);
		}
	}
	
	public void openInternalFrameCategoria(JDesktopPane jdp) {
		if(jif4 == null) {
			jif4 = new JInternalCategoria();
			jdp.add(jif4);
		}
	}
	
	public void openInternalFrameContato(JDesktopPane jdp) {
		if(jif5 == null) {
			jif5 = new JInternalContato();
			jdp.add(jif5);
		}
	}	
	
	public void openInternalFrameVenda(JDesktopPane jdp) {
		if(jif6 == null) {
			jif6 = new JInternalVenda();
			jdp.add(jif6);
		}
	}
	
	public void openInternalFrameItemVenda(JDesktopPane jdp) {
		if(jif7 == null) {
			jif7 = new JInternalItemVenda();
			jdp.add(jif7);
		}
	}
	
	public void openInternalFrameProdutoList(JDesktopPane jdp) {
		if(jif8 == null) {
			jif8 = new JInternalProdutoList();
			jdp.add(jif8);
		}
	}
	
	public void openInternalFrameCategoriaList(JDesktopPane jdp) {
		if(jif9 == null) {
			jif9 = new JInternalCategoriaList();
			jdp.add(jif9);
		}
	}
	
	public void openInternalFrameClienteList(JDesktopPane jdp) {
		if(jif10 == null) {
			jif10 = new JInternalClienteList();
			jdp.add(jif10);
		}
	}
	
	public void openInternalFrameContatoList(JDesktopPane jdp) {
		if(jif11 == null) {
			jif11 = new JInternalContatoList();
			jdp.add(jif11);
		}
	}
	
	public void openInternalFrameFuncionarioList(JDesktopPane jdp) {
		if(jif12 == null) {
			jif12 = new JInternalFuncionarioList();
			jdp.add(jif12);
		}
	}
}