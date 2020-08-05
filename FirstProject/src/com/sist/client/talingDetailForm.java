package com.sist.client;

import javax.swing.*;
import com.sist.data.talingManager;
import com.sist.data.talingVO;
import java.awt.*;
import java.net.URL;
import java.util.*;

public class talingDetailForm extends JPanel {
	JLabel poster=new JLabel();
	JLabel la1=new JLabel("",JLabel.LEFT);
	JLabel[] la=new JLabel[4]; 
	JTextPane ta=new JTextPane();
	JButton b1,b2;
	public talingDetailForm()
	{
		setLayout(null);
		poster.setBounds(10, 15, 350, 400);
		add(poster);
		la1.setBounds(365,15, 500, 45);
		la1.setFont(new Font("굴림체",Font.BOLD,45));
		add(la1);
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(3,1,5,5));
		String[] str= {"튜터","가격","시간","장소"};
		for(int i=0;i<3;i++)
		{
			la[i]=new JLabel(str[i]);
			la[i].setFont(new Font("굴림체",Font.BOLD,30));
			p.add(la[i]);
			
		}
		p.setBounds(365, 80, 500, 300);
		add(p);
		
		ta.setEditable(false);//영화내용창안에 내용입력 불가-비활성화 :편집불가
		JScrollPane js=new JScrollPane(ta);
		js.setBounds(10, 420, 700, 130);
		add(js);
		
		b1=new JButton("신청하기");
		b2=new JButton("목록");
		b1.setBackground(Color.red);
		b2.setBackground(Color.green);
		JPanel p2=new JPanel();
		p2.add(b1);
		p2.add(b2);
		p2.setBounds(365, 385, 200, 35);
		add(p2);
	}
	public void detailPrint(int lno)
	{
		talingManager m=new talingManager();
		talingVO vo=m.talingDetailData(lno);
		la1.setText("튜터:"+vo.getName());
		
		  try 
		  { 
			  URL url=new URL(vo.getImage()); 
			  Image img=ClientMainFrame.getImage(new ImageIcon(url), poster.getWidth(), poster.getHeight()); 
			  poster.setIcon(new ImageIcon(img)); 
		  }catch(Exception ex) {}
		 
		
			la[0].setText("장소:"+vo.getSpot());
			la[1].setText("가격:"+vo.getPrice());
			la[2].setText("시간:"+vo.getTime());
		
		ta.setText(vo.getInfo());
	}
}
