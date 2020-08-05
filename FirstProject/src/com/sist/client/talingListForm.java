package com.sist.client;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import com.sist.data.*;
import javax.swing.*;
import javax.swing.table.*;
import java.net.*;

public class talingListForm extends JPanel implements MouseListener {
	JButton b1,b2,b3,b4,b5,b6;
	JTextField tf;
	JTable table;
	DefaultTableModel model; // like 지니뮤직 top100
	talingDetailForm tdf=new talingDetailForm();
	
			public talingListForm()
			{
				setLayout(null);// FlowLayout 1자로 배치하는데 null을 붙이면 이걸 쓰지 않고 직접 배치하겠다=> 사용자정의배치
				b1=new JButton("인기수업");
				b2=new JButton("디자인수업");
				b3=new JButton("식무역량수업");
				b4=new JButton("뷰티수업");
				b5=new JButton("영상수업");
				b6=new JButton("검색");
				tf=new JTextField(20);
				JPanel p=new JPanel();
				p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(tf);p.add(b6);
				// 순서대로 코딩해야함 tf를 임의적으로 먼저 배치함
				p.setBounds(10, 25, 900, 35);
				add(p);
				String[] col= {"번호","튜터","이름","장소","가격","장소"};
				Object[][] row=new Object[0][5];//이미지 파일도 너허야 되기 때문에 string이 아닌 object로
				
				//DefaultTableModel => 오버라이딩할 메소드가 있다 (익명의 클래스 => 내부클래스)
				/*
				 *       내부 클래스 => 쓰레드,네트워크
				 *       =======
				 *       class A
				 *       {
				 *             O   P  C  V  B
				 *             class B{  ==> a클래스의 멤버클래스다
				 *             }
				 *       }
				 */
				model=new DefaultTableModel(row,col) {

					//편집이 불가능
					@Override
					public boolean isCellEditable(int row, int column) {
						// TODO Auto-generated method stub
						return false;
					}
					//이미지 첨부
					@Override
					public Class<?> getColumnClass(int columnIndex) {
						// TODO Auto-generated method stub
						return getValueAt(0, columnIndex).getClass();
					}
					
				};
				
				table=new JTable(model);
				table.setRowHeight(35);
				JScrollPane js=new JScrollPane(table);
				// 위에서 여기까지가 테이블 만드는 방법 갖다 쓰면된다
				
				
				js.setBounds(10, 70, 700, 550);
				add(js);
				
				tdf.setBounds(715, 70, 800, 650);
				add(tdf);
				talingAllDate(1);
				tdf.detailPrint(1);
				
				table.addMouseListener(this);
				
			}
			public void talingAllDate(int cno)
			{
				//데이터 가지고 오기,같은 패키지 안에서는 가져다쓸수있지만 다를경우 import해야함
				talingManager m=new talingManager();
				ArrayList<talingVO> list=m.talingAllData(cno);
				
				// 테이블 한번 지우기
				// 마지막부터 지운다 
				for(int i=model.getRowCount()-1;i>=0;i--)
				{
					model.removeRow(i);
				}
				
				
				//데이터 출력
				/*
				 *     java.io,net ==> checkexception 반드시 예외처리
				 */
				for(talingVO vo:list)
				{
					try
					{
						URL url=new URL(vo.getImage());//이미지를 다음에서 가져와서 http
						Image img=ClientMainFrame.getImage(new ImageIcon(url), 50, 50);//축소한다
						Object[] data= {
							vo.getLno(),
							new ImageIcon(img),
							vo.getTitle(),
							vo.getName(),
							vo.getPrice(),
							vo.getSpot()
					};
					model.addRow(data);
					}catch(Exception ex) {ex.printStackTrace();}
				}
			}
			public void talingFindData(String ss)
			{
				//데이터 가지고 오기,같은 패키지 안에서는 가져다쓸수있지만 다를경우 import해야함
				talingManager m=new talingManager();
				ArrayList<talingVO> list=m.movieFindData(ss);
				
				// 테이블 한번 지우기
				// 마지막부터 지운다 
				for(int i=model.getRowCount()-1;i>=0;i--)
				{
					model.removeRow(i);
				}
				
				
				//데이터 출력
				/*
				 *     java.io,net ==> checkexception 반드시 예외처리
				 */
				for(talingVO vo:list)
				{
					try
					{
						URL url=new URL(vo.getImage());//이미지를 다음에서 가져와서 http
						Image img=ClientMainFrame.getImage(new ImageIcon(url), 50, 50);//축소한다
						Object[] data= {
							vo.getLno(),
							new ImageIcon(img),
							vo.getTitle(),
							vo.getName(),
							vo.getPrice(),
							vo.getSpot()
					};
					model.addRow(data);
					}catch(Exception ex) {ex.printStackTrace();}
				}
			
			
			
		}
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if(e.getSource()==table)
					{
						if(e.getClickCount()==2)
						{
							int row=table.getSelectedRow();
							String mno=model.getValueAt(row, 0).toString();
							tdf.detailPrint(Integer.parseInt(mno));
						}
					}
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
