/* Projeto Teste para Conversor de Tamanho de Fontes
 * Vers�o 1.0 Desktop 
 * @author Fábio César Schmidt
 * Criado em: 24/08/2014
 * Última Atualização: 09/11/2014
 */

package FonteConvertor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class sConvertor extends JFrame implements ActionListener,
		WindowListener {

	private JLabel Ltext1;
	private JTextField jtf_pixel;
	private JLabel Ltext2;
	private JSeparator separator1;
	private JLabel Ltext3;
	private JComboBox comboBox;
	private JLabel Ltext4;
	private JTextField jtf_value;
	private JLabel Ltext5;
	private JSeparator separator2;
	private JLabel Lresult;
	private JButton btnConveter;
	private JButton btnClean;
	private JMenuBar menuBar;
	private String pixelString = "16";

	/*
	 * Cria um Array de String que armazena as opções que serão chamdas no
	 * JComboBox
	 */
	String[] boxString = { "", "Pixel to EM", "Pixel to %", "Pixel to PT",
			"EM to Pixel", "EM to PT" };

	public sConvertor() {

		super("Convert to Pixel");// Define o Titulo para a moldura
		// this.setBounds(300, 150, 340, 430);//Define o Tamanho da Janela e a posição dela na Tela
		setSize(330, 350);// Define o tamanho da Janela
		// setLocation(300, 150);//Define a posição da Janela na Tela
		this.setResizable(false);// Se false impede que a janela seja redimensionada
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Fecha a mémoria quando a janela for fechada						
		this.setLocationRelativeTo(null);// Centraliza a Janela a tela

		// JMENU
		//menuBar = new JMenuBar();
		//menuBar.add(new JMenu("Menu"));
		//menuBar.add(new JMenu("Reposit�rio"));

		/*
		 * JLABEL Obs: SwingConstants.CENTER (alinha o conteúdo no centro).
		 */
		Ltext1 = new JLabel("1. Enter a base pixel size");
		Ltext2 = new JLabel("2.Convert");
		Ltext3 = new JLabel("Options");
		Ltext4 = new JLabel("Enter Value");
		Ltext5 = new JLabel("3.Result");
		Lresult = new JLabel("", SwingConstants.CENTER);

		// JTEXTFIELD
		jtf_pixel = new JTextField(pixelString);// recebe uma String, valor
												// padrão dos navegadores
		jtf_value = new JTextField();

		// JSEPARATOR
		separator1 = new JSeparator();
		separator2 = new JSeparator();

		// JCOMBOBOX
		comboBox = new JComboBox(boxString);// recebe o array de String

		// JBUTTON
		btnConveter = new JButton("Convert");// Botão Converte
		btnClean = new JButton("Clean");// Botão Limpar

		/* POSIÇÃO DOS COMPONENTES NA TELA */
		Ltext1.setBounds(85, 30, 150, 30);
		jtf_pixel.setBounds(130, 60, 60, 30);
		Ltext2.setBounds(125, 90, 70, 30);
		separator1.setBounds(1, 118, 335, 2);
		Ltext3.setBounds(10, 113, 70, 30);
		comboBox.setBounds(10, 140, 120, 30);
		Ltext4.setBounds(190, 113, 70, 30);
		jtf_value.setBounds(190, 140, 120, 30);
		Ltext5.setBounds(140, 170, 70, 30);
		separator2.setBounds(1, 195, 335, 2);
		Lresult.setBounds(0, 200, 335, 30);
		btnConveter.setBounds(30, 270, 100, 30);
		btnClean.setBounds(200, 270, 100, 30);
		//menuBar.setBounds(0, 0, 340, 30);

		/* Adiciona os Componentes na Tela */
		this.setLayout(null);// desativa o gerenciador de Layout
		this.add(Ltext1);
		this.add(jtf_pixel);
		this.add(Ltext2);
		this.add(separator1);
		this.add(Ltext3);
		this.add(comboBox);
		this.add(Ltext4);
		this.add(jtf_value);
		this.add(Ltext5);
		this.add(separator2);
		this.add(Lresult);
		this.add(btnConveter);
		this.add(btnClean);
		//this.add(menuBar);

		this.getContentPane().setLayout(null);// Seta o layout na tela
		this.addWindowListener(this);

		/* REGISTROS QUE IRÃO SOFRER AUTERAÇÕES */
		this.getContentPane().add(Lresult);
		this.getContentPane().add(jtf_pixel);
		this.getContentPane().add(jtf_value);
		this.getContentPane().add(comboBox);
		this.getContentPane().add(btnConveter);
		this.getContentPane().add(btnClean);
		//this.getContentPane().add(menuBar);

		btnConveter.addActionListener(this);
		btnClean.addActionListener(this);
		jtf_value.addActionListener(this);
		comboBox.addActionListener(this);

		/* EVENTO DO BOT�O DE CONVERS�O */
		btnConveter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {

				for (int i = -1; i <= 5; i++) {
					int numBase = Integer.parseInt(pixelString);
					// double numBase = 16;//número base para o calculo
					double value = 0;// recebe o valor digitado pelo usuário
					double result;// recebe o resultado do calculo

					// numBase = Double.parseDouble(pixel.getText());
					// value = Double.parseDouble(jtf_value.getText());
					try {
						numBase = Integer.parseInt(jtf_pixel.getText());
						value = Double.parseDouble(jtf_value.getText());
					} catch (Exception e) {
					}

					switch (comboBox.getSelectedIndex()) {
					case 0:
						JOptionPane.showMessageDialog(null,
								"Escolha o tipo de convers�o",
								Lresult.getText() + "Escolha uma op��o",
								JOptionPane.ERROR_MESSAGE);
						break;
					case 1:// Converte Pixel em EM
						if (value <= 0) {
							JOptionPane.showMessageDialog(null, "Digite um valor",
									Lresult.getText() + "Digite ",
									JOptionPane.ERROR_MESSAGE);
						} else if (numBase < 16) {// OBS.:tratar essa opção de
													// outra maneira
							Lresult.setText("O valor minino aceito de 16 pixel");
				
						} else {
							result = value / numBase;
							Lresult.setText(+result + " em");
						}
						break;
					case 2:// Converte Pixel em %
						if (value <= 0) {
							Lresult.setText("Digite um valor v�lido para ser convertido");
						} else {
							result = (value / numBase) * 100;
							Lresult.setText(result + " %");
						}
						break;
					case 3:// Converte Pixel em Points PT
						if (value <= 0) {
							Lresult.setText("Digite um valor v�lido para ser convertido");
						} else {
							double pt1 = 72;
							double pixel2 = 96;
							result = value * (pt1 / pixel2);
							Lresult.setText(result + " pt");
						}
						break;
					case 4:// Converte EM em Pixel
						if (value < 0.5) {
							Lresult.setText("Digite um valor v�lido para ser convertido");
						} else {
							result = value * numBase;
							Lresult.setText(result + " pixel");
						}
						break;
					case 5:// Converte EM em Points PT
						if (value < 0.5) {
							Lresult.setText("Digite um valor v�lido para ser convertido");
						} else {
							result = value * 100;
							Lresult.setText(result + " pt");
						}
						break;
					}
				}
			}
		});

		/* Ao Clicar no Botão ele limpa os campos definidos para serem limpos */
		btnClean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				// Limpa os campos Texto
				jtf_pixel.setText(pixelString);// limpa e retorna com o valor
												// pr�-definido
				jtf_value.setText("");
				Lresult.setText("");
			}
		});

		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent we) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent we) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent we) {
		int resp = JOptionPane.showConfirmDialog(null,
				"Deseja encerrar a aplica��o?", "Convert to Pixel",
				JOptionPane.YES_NO_OPTION, JOptionPane.NO_OPTION);
	}

	@Override
	public void windowDeactivated(WindowEvent we) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent we) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent we) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent we) {
		// TODO Auto-generated method stub

	}
}
