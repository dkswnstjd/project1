package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class talingMenuForm extends JPanel {
	JButton b1,b2,b3,b4,b5,b6,b7;
	//초기화 (버튼) ==> 
	public talingMenuForm()
	{
		//setBackground(Color.orange);
		b1=new JButton("홈");
		b2=new JButton("과외");
		b3=new JButton("음악");
		b4=new JButton("맛집");
		b5=new JButton(" ");
		b6=new JButton(" ");
		b7=new JButton("종료");
		
		setLayout(new GridLayout(7,1,5,5));
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
	}

}
