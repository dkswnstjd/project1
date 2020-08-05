package com.sist.client;


import javax.swing.*;
import java.awt.*;//color,layout
import java.awt.event.*;// interface

public class ClientMainFrame extends JFrame implements ActionListener, MouseListener {
	// 윈도우 크기 결정 => 생성자에서 사용 ==> 291p
	JLabel title=new JLabel("레몬마켓",JLabel.CENTER);
	talingMenuForm mf=new talingMenuForm();
	ChatForm cf=new ChatForm();
	talingDetailForm df=new talingDetailForm();
	ControlPanel cp;
	
	public ClientMainFrame()
	{
		cp=new ControlPanel(this);
		title.setFont(new Font("굴림체",Font.BOLD,55));
		title.setOpaque(true);
		setLayout(null); 
		title.setBounds(10, 15, 1570, 100);
		//추가 => add()
		add(title);
		//메뉴 배치
		mf.setBounds(10, 120, 100, 300);
		add(mf);
		//채팅폼
		cf.setBounds(115, 760, 1465, 200);
		add(cf);
		//출력화면
		cp.setBounds(115, 120, 1465, 635);
		add(cp);
		setSize(1600, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//X버튼 클릭시 종료
		
		mf.b1.addActionListener(this);
		mf.b2.addActionListener(this);
		
		cp.df.b2.addActionListener(this);//목록으로 가는기능
		
		cp.lf.b1.addActionListener(this);
		cp.lf.b2.addActionListener(this);
		cp.lf.b3.addActionListener(this);
		cp.lf.b4.addActionListener(this);
		cp.lf.b5.addActionListener(this);
		cp.lf.b6.addActionListener(this);
		cp.lf.tf.addActionListener(this);
		
		//종료
				mf.b7.addActionListener(this);
				
				//채팅
				cf.tf.addActionListener(this);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new ClientMainFrame();
		//생성자는 호출시에 반드시 => new 생성자()
		 UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
		 new ClientMainFrame();
	}
	public static Image getImage(ImageIcon ii,int w,int h)//화면을 축소하는 기능은 다른 창에서도 써야하기에 static
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
			//1. 입력된 값 읽기
			String ss=cp.lf.tf.getText();
			if(ss.length()<1)
			{
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				cp.lf.tf.requestFocus();
				return;//메소드 종료
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
