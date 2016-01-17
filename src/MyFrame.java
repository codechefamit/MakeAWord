import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;
import javax.swing.Timer;

import java.awt.event.KeyAdapter;
public class MyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String conset,vowset;
	private char array[]=null;
	private JButton btn1,btn2,btn3,btn4,btn5,btn6;
	private JButton btnStart;
	private JList <String>list2,list3;
	private DefaultListModel<String> listModel2,listModel3,listModel4,listModel5,listModel6,listAllModel;
	private JFormattedTextField formattedTextField;
	private SpellCheck sc;
	private String arr,del;
	private int point;
	private JLabel lblPoints,lblTime;
	private JButton btnStop,btnSeeAll;
	private Timer timer;
	private int time;
	private StartAction sa;
	private JLabel lblLetters;
	private JLabel lblLetter;
	private JScrollPane scrollPane_1;
	private JLabel lblLetter_1;
	private JScrollPane scrollPane_2;
	private JList<String> list4;
	private JLabel lblLetter_2;
	private JScrollPane scrollPane_3;
	private JList<String> list5;
	private JLabel lblLetter_3;
	private JScrollPane scrollPane_4;
	private JList<String> list6;
	private JLabel lbl2letter;
	private JLabel lbl3letter;
	private JLabel lbl4letter;
	private JLabel lbl5letter;
	private JLabel lbl6letter;
	private int l2,l3,l4,l5,l6;
	private JScrollPane scrollPane_5;
	private JList <String>listAll;
	private JLabel lblSeeWhatYou;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setTitle("Word Power by Amit Kothiyal");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setSize(650,430);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMakeAWord = new JLabel("Word Power");
		lblMakeAWord.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMakeAWord.setBounds(226, 11, 200, 33);
		contentPane.add(lblMakeAWord);
		point=0;
		listModel2=new DefaultListModel<String>();
		listModel3=new DefaultListModel<String>();
		listModel4=new DefaultListModel<String>();
		listModel5=new DefaultListModel<String>();
		listModel6=new DefaultListModel<String>();
		listAllModel=new DefaultListModel<String>();
		conset="bcdfghjklmnpqrstvwxyz";
		vowset="aeiou";
		del=null;
		sc=new SpellCheck();
		time=60;
		l2=l3=l4=l5=l6=0;
		
		btn1 = new JButton();
		btn1.setForeground(Color.BLACK);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn1.setBackground(new Color(255, 250, 205));
		btn1.setBounds(42, 125, 50, 50);
		btn1.setFocusable(false);
		contentPane.add(btn1);
		
		btn2 = new JButton();
		btn2.setForeground(Color.BLACK);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn2.setBackground(new Color(255, 250, 205));
		btn2.setBounds(103, 125, 50, 50);
		btn2.setFocusable(false);
		contentPane.add(btn2);
		
		btn3 = new JButton();
		btn3.setForeground(Color.BLACK);
		btn3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn3.setBackground(new Color(255, 250, 205));
		btn3.setBounds(163, 125, 50, 50);
		btn3.setFocusable(false);
		contentPane.add(btn3);
		
		btn4 = new JButton();
		btn4.setForeground(Color.BLACK);
		btn4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn4.setBackground(new Color(255, 250, 205));
		btn4.setBounds(163, 186, 50, 50);
		btn4.setFocusable(false);
		contentPane.add(btn4);
		
		btn5 = new JButton();
		btn5.setForeground(Color.BLACK);
		btn5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn5.setBackground(new Color(255, 250, 205));
		btn5.setBounds(42, 186, 50, 50);
		btn5.setFocusable(false);
		contentPane.add(btn5);
		
		btn6 = new JButton();
		btn6.setForeground(Color.BLACK);
		btn6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn6.setBackground(new Color(255, 250, 205));
		btn6.setBounds(103, 186, 50, 50);
		btn6.setFocusable(false);
		contentPane.add(btn6);
		
		sa=new StartAction();
		btnStart = new JButton("Start");
		btnStart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent event) {
				char c=event.getKeyChar();
				if(c==KeyEvent.VK_ENTER){
					sa.actionPerformed(null);
				}
					
			}
		});
		btnStart.addActionListener(sa);
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStart.setBounds(24, 73, 91, 33);
		btnStart.setFocusCycleRoot(true);
		contentPane.add(btnStart);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 100, 50, 100);
		scrollPane.setAutoscrolls(true);
		contentPane.add(scrollPane);
		scrollPane.setFocusable(false);
		list2 = new JList<String>(listModel2);
		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list2.setFont(new Font("Tahoma", Font.BOLD, 16));
		list2.setAutoscrolls(true);
		scrollPane.setViewportView(list2);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String txt=formattedTextField.getText();
				if(sc.check(txt) && txt.length()!=1){
					if(txt.length()==2 && !listModel2.contains(txt)){
						listModel2.addElement(txt);
						list2.ensureIndexIsVisible(listModel2.getSize()-1);
						point=point+(txt.length()*2);
					}
					if(txt.length()==3 && !listModel3.contains(txt)){
						listModel3.addElement(txt);
						list3.ensureIndexIsVisible(listModel3.getSize()-1);
						point=point+(txt.length()*3);
					}
					if(txt.length()==4 && !listModel4.contains(txt)){
						listModel4.addElement(txt);
						list4.ensureIndexIsVisible(listModel4.getSize()-1);
						point=point+(txt.length()*4);
					}
					if(txt.length()==5 && !listModel5.contains(txt)){
						listModel5.addElement(txt);
						list5.ensureIndexIsVisible(listModel5.getSize()-1);
						point=point+(txt.length()*5);
					}
					if(txt.length()==6 && !listModel6.contains(txt)){
						listModel6.addElement(txt);
						list6.ensureIndexIsVisible(listModel6.getSize()-1);
						point=point+(txt.length()*6);
					}
					lblPoints.setText("Points:"+point);
					formattedTextField.setText(null);
					arr=new String(array);
					del=null;
				}
				else
				{
					Toolkit.getDefaultToolkit().beep();
					formattedTextField.setText(null);
					arr=new String(array);
					del=null;
				}
			}
		});
		formattedTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				char c=event.getKeyChar();
				if(arr.indexOf(c)==-1 && c!=KeyEvent.VK_BACK_SPACE){
					event.consume();
				}
				else if(c==KeyEvent.VK_BACK_SPACE){
					char d=del.charAt(del.length()-1);
					arr=arr+d;
					del=del.replace(new Character(d).toString(), "");
				}
				else{
					del=del+c;
					arr=arr.replaceFirst(new Character(c).toString(), "");
				}
			}
			
			public void keyReleased(KeyEvent event) {
				char c=event.getKeyChar();
				if(timer.isRunning())
				{
					if(c==KeyEvent.VK_SPACE)
					{
						shuffle(array);
						btn1.setText(new Character(array[0]).toString().toUpperCase());
						btn2.setText(new Character(array[1]).toString().toUpperCase());
						btn3.setText(new Character(array[2]).toString().toUpperCase());
						btn4.setText(new Character(array[3]).toString().toUpperCase());
						btn5.setText(new Character(array[4]).toString().toUpperCase());
						btn6.setText(new Character(array[5]).toString().toUpperCase());
					}
				}
			}
			
		});
		formattedTextField.setEditable(false);
		formattedTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		formattedTextField.setBounds(20, 257, 231, 40);
		contentPane.add(formattedTextField);
		
		lblPoints = new JLabel("Points :");
		lblPoints.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPoints.setBounds(308, 354, 130, 27);
		contentPane.add(lblPoints);
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				timer.stop();
				lblTime.setText("Time Left : 60 sec's");
				btnStart.setEnabled(true);
				btnStop.setEnabled(false);
			}
		});
		btnStop.setEnabled(false);
		btnStop.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStop.setBounds(136, 73, 91, 33);
		contentPane.add(btnStop);
		
		
		
		lblTime = new JLabel("Time Left : 60 sec's");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTime.setBounds(52, 308, 175, 27);
		contentPane.add(lblTime);
		
		JLabel lblHitSpacebarTo = new JLabel("Hit Spacebar to shuffle words.");
		lblHitSpacebarTo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHitSpacebarTo.setBounds(10, 362, 272, 27);
		contentPane.add(lblHitSpacebarTo);
		
		lblLetters = new JLabel("2 letter");
		lblLetters.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLetters.setBounds(300, 73, 50, 27);
		contentPane.add(lblLetters);
		
		lblLetter = new JLabel("3 letter");
		lblLetter.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLetter.setBounds(360, 73, 50, 27);
		contentPane.add(lblLetter);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(360, 100, 50, 100);
		contentPane.add(scrollPane_1);
		list3 = new JList<String>();
		list3 = new JList<String>(listModel3);
		list3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list3.setFont(new Font("Tahoma", Font.BOLD, 16));
		list3.setAutoscrolls(true);
		scrollPane_1.setViewportView(list3);
		
		lblLetter_1 = new JLabel("4 letter");
		lblLetter_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLetter_1.setBounds(420, 73, 50, 27);
		contentPane.add(lblLetter_1);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(420, 100, 60, 100);
		contentPane.add(scrollPane_2);
		
		list4 = new JList<String>();
		list4 = new JList<String>(listModel4);
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list4.setFont(new Font("Tahoma", Font.BOLD, 16));
		list4.setAutoscrolls(true);
		scrollPane_2.setViewportView(list4);
		
		lblLetter_2 = new JLabel("5 letter");
		lblLetter_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLetter_2.setBounds(490, 73, 50, 27);
		contentPane.add(lblLetter_2);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(490, 100, 60, 100);
		contentPane.add(scrollPane_3);
		
		list5 = new JList<String>();
		list5 = new JList<String>(listModel5);
		list5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list5.setFont(new Font("Tahoma", Font.BOLD, 16));
		list5.setAutoscrolls(true);
		scrollPane_3.setViewportView(list5);
		
		lblLetter_3 = new JLabel("6 letter");
		lblLetter_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblLetter_3.setBounds(560, 73, 50, 27);
		contentPane.add(lblLetter_3);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(560, 100, 60, 100);
		contentPane.add(scrollPane_4);
		
		list6 = new JList<String>();
		list6 = new JList<String>(listModel6);
		list6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list6.setFont(new Font("Tahoma", Font.BOLD, 16));
		list6.setAutoscrolls(true);
		scrollPane_4.setViewportView(list6);
		
		lbl2letter = new JLabel("");
		lbl2letter.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl2letter.setBounds(300, 199, 40, 27);
		contentPane.add(lbl2letter);
		
		lbl3letter = new JLabel("");
		lbl3letter.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl3letter.setBounds(360, 199, 40, 27);
		contentPane.add(lbl3letter);
		
		lbl4letter = new JLabel("");
		lbl4letter.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl4letter.setBounds(425, 199, 40, 27);
		contentPane.add(lbl4letter);
		
		lbl5letter = new JLabel("");
		lbl5letter.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl5letter.setBounds(495, 199, 40, 27);
		contentPane.add(lbl5letter);
		
		lbl6letter = new JLabel("");
		lbl6letter.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl6letter.setBounds(565, 199, 40, 27);
		contentPane.add(lbl6letter);
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(540, 230, 80, 120);
		contentPane.add(scrollPane_5);
		
		listAll = new JList<String>();
		listAll = new JList<String>(listAllModel);
		listAll.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAll.setFont(new Font("Tahoma", Font.BOLD, 16));
		listAll.setAutoscrolls(true);
		scrollPane_5.setViewportView(listAll);
		
		btnSeeAll = new JButton("See All Words");
		btnSeeAll.setEnabled(false);
		btnSeeAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				for(int k=2;k<=arr.length();k++)
			    	combinations(arr,k,"");
			}
		});
		btnSeeAll.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSeeAll.setFocusCycleRoot(true);
		btnSeeAll.setBounds(393, 275, 140, 33);
		contentPane.add(btnSeeAll);
		
		lblSeeWhatYou = new JLabel("See What You Missed:");
		lblSeeWhatYou.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSeeWhatYou.setBounds(368, 237, 165, 27);
		contentPane.add(lblSeeWhatYou);
		
		JLabel lblCopyrightcAmit = new JLabel("Developed By : Amit Kothiyal | Copyright (C), All rights reserved");
		lblCopyrightcAmit.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblCopyrightcAmit.setBounds(350, 0, 284, 27);
		contentPane.add(lblCopyrightcAmit);
		
		int delay=1000;
		timer=new Timer(delay,new ActionListener(){
			
			public void actionPerformed(ActionEvent event) {
				if(time==00){
					lblTime.setText("Time Left : 60 sec's");
					formattedTextField.setEditable(false);
					formattedTextField.setText(null);
					btnStart.setEnabled(true);
					btnStop.setEnabled(false);
					btnStart.requestFocus();
					btnSeeAll.setEnabled(true);
					timer.stop();
				}
				else{
				time--;
				lblTime.setText("Time Left : "+time+" sec's");
				}
			}
			
		});
	}
	
	void initArray(){
		array=new char[6];
		Random r=new Random();
		int i=0;
		for(i=0;i<=2;i++)
			array[i]=vowset.charAt(r.nextInt(vowset.length()));
		for(;i<=5;i++)
			array[i]=conset.charAt(r.nextInt(conset.length()));
		//shuffle
		shuffle(array);
	}
	
	void shuffle(char array[]){
		Random r=new Random();
		for (int i1 = array.length - 1; i1 > 0; i1--)
	    {
	      int index = r.nextInt(i1 + 1);
	      // Simple swap
	      char a = array[index];
	      array[index] = array[i1];
	      array[i1] = a;
	    }
	}
	
	class StartAction implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			btnSeeAll.setEnabled(false);
			formattedTextField.setEditable(true);
			formattedTextField.setText(null);
			del=null;
			listAllModel.clear();
			l2=l3=l4=l5=l6=0;
			initArray();
			point=0;
			time=60;
			arr=new String(array);
			for(int k=2;k<=arr.length();k++)
		    	combinations(arr,k,"");
			
			for(int i=0;i<listAllModel.getSize();i++)
			{
				String s=listAllModel.getElementAt(i);
				if(s.length()==2)
					l2++;
				else if(s.length()==3)
					l3++;
				else if(s.length()==4)
					l4++;
				else if(s.length()==5)
					l5++;
				else if(s.length()==6)
					l6++;
			}
			
			lbl2letter.setText(new Integer(l2).toString());
			lbl3letter.setText(new Integer(l3).toString());
			lbl4letter.setText(new Integer(l4).toString());
			lbl5letter.setText(new Integer(l5).toString());
			lbl6letter.setText(new Integer(l6).toString());
			
			listModel2.clear();
			listModel3.clear();
			listModel4.clear();
			listModel5.clear();
			listModel6.clear();
			listAllModel.clear();
			lblPoints.setText("Points:");
			btn1.setText(new Character(array[0]).toString().toUpperCase());
			btn2.setText(new Character(array[1]).toString().toUpperCase());
			btn3.setText(new Character(array[2]).toString().toUpperCase());
			btn4.setText(new Character(array[3]).toString().toUpperCase());
			btn5.setText(new Character(array[4]).toString().toUpperCase());
			btn6.setText(new Character(array[5]).toString().toUpperCase());
			btnStart.setEnabled(false);
			btnStop.setEnabled(true);
			formattedTextField.requestFocus();
			timer.start();
		}
	}
	
	void combinations(String str, int k, String output) {
    	if(k==0){
    	if(sc.check(output)){
    		if(!listAllModel.contains(output)){
    			listAllModel.addElement(output);
    		}
    	}
    	}

    	for(int i = 0; i< str.length();i++){

    	combinations(str.substring(0, i)+str.substring(i+1),k-1,output+str.charAt(i));

    	}

   }
}
