package com.sist.client;


import javax.swing.*;
import java.awt.*;//color,layout
import java.awt.event.*;// interface

public class ClientMainFrame extends JFrame implements ActionListener, MouseListener {
	// ������ ũ�� ���� => �����ڿ��� ��� ==> 291p
	JLabel title=new JLabel("������",JLabel.CENTER);
	talingMenuForm mf=new talingMenuForm();
	ChatForm cf=new ChatForm();
	talingDetailForm df=new talingDetailForm();
	ControlPanel cp;
	
	public ClientMainFrame()
	{
		cp=new ControlPanel(this);
		title.setFont(new Font("����ü",Font.BOLD,55));
		title.setOpaque(true);
		setLayout(null); 
		title.setBounds(10, 15, 1570, 100);
		//�߰� => add()
		add(title);
		//�޴� ��ġ
		mf.setBounds(10, 120, 100, 300);
		add(mf);
		//ä����
		cf.setBounds(115, 760, 1465, 200);
		add(cf);
		//���ȭ��
		cp.setBounds(115, 120, 1465, 635);
		add(cp);
		setSize(1600, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//X��ư Ŭ���� ����
		
		mf.b1.addActionListener(this);
		mf.b2.addActionListener(this);
		
		cp.df.b2.addActionListener(this);//������� ���±��
		
		cp.lf.b1.addActionListener(this);
		cp.lf.b2.addActionListener(this);
		cp.lf.b3.addActionListener(this);
		cp.lf.b4.addActionListener(this);
		cp.lf.b5.addActionListener(this);
		cp.lf.b6.addActionListener(this);
		cp.lf.tf.addActionListener(this);
		
		//����
				mf.b7.addActionListener(this);
				
				//ä��
				cf.tf.addActionListener(this);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new ClientMainFrame();
		//�����ڴ� ȣ��ÿ� �ݵ�� => new ������()
		 UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
		 new ClientMainFrame();
	}
	public static Image getImage(ImageIcon ii,int w,int h)//ȭ���� ����ϴ� ����� �ٸ� â������ ����ϱ⿡ static
    {
    	Image dimg = ii.getImage().getScaledInstance(w, h,
    	        Image.SCALE_SMOOTH);
    	return dimg;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==mf.b1)
		{
			cp.card.show(cp, "DF");
		}
		else if(e.getSource()==mf.b2)
		{
			cp.card.show(cp, "LF");
		}
		else if(e.getSource()==cp.df.b2)
		{
			cp.card.show(cp, "FF");
		}
		else if(e.getSource()==cp.lf.b1)
		{
			cp.lf.talingAllDate(1);
		}
		else if(e.getSource()==cp.lf.b2)
		{
			cp.lf.talingAllDate(2);
		}
		else if(e.getSource()==cp.lf.b3)
		{
			cp.lf.talingAllDate(3);
		}
		else if(e.getSource()==cp.lf.b4)
		{
			cp.lf.talingAllDate(4);
		}
		else if(e.getSource()==cp.lf.b5)
		{
			cp.lf.talingAllDate(5);
		}
		else if(e.getSource()==cp.lf.b6 || e.getSource()==cp.lf.tf)
		{
			//1. �Էµ� �� �б�
			String ss=cp.lf.tf.getText();
			if(ss.length()<1)
			{
				JOptionPane.showMessageDialog(this, "�˻�� �Է��ϼ���");
				cp.lf.tf.requestFocus();
				return;//�޼ҵ� ����
			}
			cp.lf.talingFindData(ss);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
