/*
Música:
-> https://www.youtube.com/watch?v=dXfHn5CtH7U
-> https://www.youtube.com/watch?v=svqRPa42zt4
-> https://www.youtube.com/watch?v=CPUKGFVrQvE
-> https://www.youtube.com/watch?v=IPLk4xJjOaI
*/

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Font;

import java.io.File;
import java.util.HashMap;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Map;

//--------------------------

public class Animacion{

	Map <String, Clip> musica = new HashMap<>();
	public static void main(String args[]) {
		try{
			Animacion musica = new Animacion(); //---------------->
		JFrame frame = new JFrame("Animación: ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,530);
		frame.getContentPane().setBackground( Color.WHITE );
		frame.setLayout(null);


		//--------------- font -----------------------------
		Font fn = new Font("SansSerif", Font.PLAIN, 8);
		Font h = new Font("Helvetica", Font.BOLD, 11);

		ImageIcon fondo = new ImageIcon(Animacion.class.getResource("/consola.png"));

		JLabel myLabel = new JLabel(fondo);
		myLabel.setSize(377,480);
		frame.add(myLabel);

	//---------------- Texto ---------------------

		JTextArea t1 = new JTextArea("     \u0F3A Seleccione un instrumento \u0F3B   ");

			t1.setBounds(84,285,200,20);
			t1.setFont(h);
			t1.setEditable(false);
			myLabel.add(t1);

	//----------------botones---------------------

		JButton btn[] = new JButton[4];
		ButtonGroup grpBtn = new ButtonGroup();

		JPanel panelBTN = new JPanel();
		panelBTN.setLayout(new GridLayout(2,2)); //3 x 2
		panelBTN.setBounds(78,306,208,70);
		panelBTN.setFont(fn);
		panelBTN.setBackground(Color.WHITE);

		String [] opciones = {"Piano", "Guitarra", "Tambor", "Bloque Musical"};
		for (int i=0; i<4; i++){
			btn[i] = new JButton(opciones[i]);
		  btn[i].setBackground(Color.WHITE);
      btn[i].setForeground(Color.decode("#e64b62"));//0ffa3b1
			btn[i].setFont(new Font("Arial", Font.PLAIN, 11));
			grpBtn.add(btn[i]);
			panelBTN.add(btn[i]);
			btn[i].setLayout(null);
		}
		myLabel.add(panelBTN);

		JButton btnDetener = new JButton("Detener");
		btnDetener.setBounds(110,386,90,30);
		btnDetener.setBackground(Color.WHITE);
		btnDetener.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnDetener.setForeground(Color.decode("#a72b3e"));//0ffa3b1
		myLabel.add(btnDetener);

		ImageIcon volum = new ImageIcon(Animacion.class.getResource("/volumen.png"));
		ImageIcon mute = new ImageIcon(Animacion.class.getResource("/mute.png"));
		JLabel imVol = new JLabel(mute);
		imVol.setBounds(204,383,35,35);
		myLabel.add(imVol);


	  //--------------GIFS-----------------------
		  ImageIcon base = new ImageIcon(Animacion.class.getResource("/Base.gif"));
			JLabel labelGif = new JLabel(base);
			labelGif.setBounds(74,50,217,152);
			frame.add(labelGif);

			ImageIcon piano = new ImageIcon(Animacion.class.getResource("/piano.gif"));
			ImageIcon guitarra = new ImageIcon(Animacion.class.getResource("/guitarra.gif"));
			ImageIcon tambor = new ImageIcon(Animacion.class.getResource("/tambor.gif"));
			ImageIcon box = new ImageIcon(Animacion.class.getResource("/box.gif"));

			frame.setResizable(false);

		//--------------ActionListener-----------------------
			btn[0].addActionListener(new ActionListener() {
			 @Override
					public void actionPerformed(ActionEvent e) {
						labelGif.setIcon((piano));
						imVol.setIcon(volum);
						musica.activarSonido("piano_Zelda.wav");
						musica.stop("Pigstep_NoteBlock.wav");
						musica.stop("tamb_Zelda.wav");
						musica.stop("guit_GerudoValley_Zelda.wav");
					}
			});

			btn[1].addActionListener(new ActionListener() {
			 @Override
					public void actionPerformed(ActionEvent e) {
						labelGif.setIcon((guitarra));
						imVol.setIcon(volum);
						musica.activarSonido("guit_GerudoValley_Zelda.wav");
						musica.stop("Pigstep_NoteBlock.wav");
						musica.stop("piano_Zelda.wav");
						musica.stop("tamb_Zelda.wav");

					}
			});

			btn[2].addActionListener(new ActionListener() {
			 @Override
					public void actionPerformed(ActionEvent e) {
						labelGif.setIcon((tambor));
						imVol.setIcon(volum);
						musica.activarSonido("tamb_Zelda.wav");
						musica.stop("Pigstep_NoteBlock.wav");
						musica.stop("piano_Zelda.wav");
						musica.stop("guit_GerudoValley_Zelda.wav");
					}
			});

			btn[3].addActionListener(new ActionListener() {
			 @Override
					public void actionPerformed(ActionEvent e) {
					  labelGif.setIcon((box));
						imVol.setIcon(volum);
						musica.activarSonido("Pigstep_NoteBlock.wav");
						musica.stop("piano_Zelda.wav");
						musica.stop("tamb_Zelda.wav");
						musica.stop("guit_GerudoValley_Zelda.wav");
					}
			});

			btnDetener.addActionListener(new ActionListener() {//--->
			 @Override
					public void actionPerformed(ActionEvent e) {
						labelGif.setIcon((base));
						imVol.setIcon(mute);
						musica.stop("Pigstep_NoteBlock.wav");
						musica.stop("piano_Zelda.wav");
						musica.stop("tamb_Zelda.wav");
						musica.stop("guit_GerudoValley_Zelda.wav");
					}
			});
			frame.setVisible(true);

				}catch(Exception e) {
						e.printStackTrace();
				}

		}

			public void activarSonido(String audioNombre){
	        Clip clip = musica.get(audioNombre);
	        clip.setFramePosition(0);
	        clip.start();
					clip.loop(Clip.LOOP_CONTINUOUSLY);
	    }

			public void stop(String audioNombre){
					Clip clip = musica.get(audioNombre);
					clip.stop();
			}

			public Animacion() { //Música
					audioOnda("piano_Zelda.wav");
					audioOnda("Pigstep_NoteBlock.wav");
					audioOnda("tamb_Zelda.wav");
					audioOnda("guit_GerudoValley_Zelda.wav");
			}

			public void audioOnda(String audioNombre){
					try {
							// AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audioNombre).getAbsoluteFile()); --> ERROR
							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(audioNombre));
							Clip clip = AudioSystem.getClip();
							clip.open(audioInputStream);
							musica.put(audioNombre, clip);
					} catch(Exception e) {
							e.printStackTrace();
					}
			}
}
