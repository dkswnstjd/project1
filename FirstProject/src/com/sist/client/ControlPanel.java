package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class ControlPanel extends JPanel{
	CardLayout card=new CardLayout();
	talingListForm lf=new talingListForm();
	talingDetailForm df=new talingDetailForm();
	
	ClientMainFrame c;
	
	public ControlPanel(ClientMainFrame c)
	{
		this.c=c;
		setLayout(card);
		add("DF",df);
		add("LF",lf);
	}
}