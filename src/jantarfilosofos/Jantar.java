package JantarFilosofos;

/*
O JANTAR DOS FILÓSOFOS - PROBLEMA DE SINCRONIZAÇÃO EM SISTEMAS OPERACIONAIS
Um dos problemas clássicos sobre a sincronização na comunicação entre processos e threads em Sistemas Operacionais.

Cinco filósofos estão sentados em uma mesa redonda para jantar. Cada filósofo tem um prato com espaguete à sua frente. 
Cada prato possui um garfo para pegar o espaguete. O espaguete está muito escorregadio e, para que um filósofo consiga comer, 
será necessário utilizar dois garfos. 

*/

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JantarFilosofos.filosofo;
import JantarFilosofos.garfos;
import java.awt.Toolkit;
import java.awt.Color;

public class Jantar extends JFrame {
	private static final long serialVersionUID = 8531554653309568273L;
	private Image fundo,arist,descar,pitagor,socrat,plat,mes;
	private filosofo f0, f1, f2, f3, f4;
	public garfos fork;	
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jantar frame = new Jantar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void paint(Graphics g){
		Graphics2D graficos = (Graphics2D) g;
		
		graficos.drawImage(fundo,0,0,null);
		graficos.drawImage(mes, 90, 230, null);
	
		graficos.drawImage(arist, 210, 125, null);
		graficos.drawImage(plat, 15, 295, null);			
		graficos.drawImage(socrat, 340, 495, null);
		graficos.drawImage(pitagor, 405, 295, null);
		graficos.drawImage(descar, 90, 490, null);
			
	}	
	
	public void jantar_WindowDestroy(Object target) {
		System.exit(0);
	}

	public void SetInfo(int chave, int estado) {
		
		if (chave == 0) {
			
			if (estado == 0) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\aristoteles.png");		
				arist = ref.getImage();
				
			} else if (estado == 1) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\aristoteles2.png");		
				arist = ref.getImage();
				
			} else if (estado == 2) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\aristoteles1.png");		
				arist = ref.getImage();				
			}
		} else if (chave == 1) {
			if (estado == 0) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\platao.png");		
				plat = ref.getImage();
			
			} else if (estado == 1) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\platao2.png");		
				plat = ref.getImage();
			

			} else if (estado == 2) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\platao1.png");		
				plat = ref.getImage();
			
			}
		} else if (chave == 2) {
			
			if (estado == 0) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\descartes.png");		
				descar = ref.getImage();
				
			} else if (estado == 1) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\descartes2.png");		
				descar = ref.getImage();
				
			} else if (estado == 2) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\descartes1.png");		
				descar = ref.getImage();
			}
		} else if (chave == 3) {
			if (estado == 0) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\socrates.png");		
				socrat = ref.getImage();
			
			} else if (estado == 1) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\socrates2.png");		
				socrat = ref.getImage();
			
			} else if (estado == 2) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\socrates1.png");		
				socrat = ref.getImage();
			
			}
			
		} else if (chave == 4) {

			if (estado == 0) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\pitagoras.png");		
				pitagor = ref.getImage();
			
			} else if (estado == 1) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\pitagoras2.png");		
				pitagor = ref.getImage();
			
			} else if (estado == 2) {
				ImageIcon ref = new ImageIcon("src\\Imagens\\pitagoras1.png");		
				pitagor = ref.getImage();
			
			}
		}
		
		repaint();
	}	
	
	/**
	 * Create the frame.
	 */
	
	public Jantar() {
		setTitle("Jantar dos Fil\u00F3sofos -> Trabalho de Sistemas Distribuídos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Jantar.class.getResource("/Imagens/Icon.png")));
			
		ImageIcon ref = new ImageIcon("src\\Imagens\\fundo.png");		
		fundo = ref.getImage();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		ref = new ImageIcon("src\\Imagens\\mesa.png");		
		
		fork = new garfos(); 
		f0 = new filosofo(0, this); 
		f1 = new filosofo(1, this);
		f2 = new filosofo(2, this);
		f3 = new filosofo(3, this);
		f4 = new filosofo(4, this);
		
		f0.start();
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		
		
			
	}
	
	public void start() {
	}

	public void stop() {
	}

	public void destroy() {
	}
}
