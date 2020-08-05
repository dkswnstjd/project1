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
	DefaultTableModel model; // like ���Ϲ��� top100
	talingDetailForm tdf=new talingDetailForm();
	
			public talingListForm()
			{
				setLayout(null);// FlowLayout 1�ڷ� ��ġ�ϴµ� null�� ���̸� �̰� ���� �ʰ� ���� ��ġ�ϰڴ�=> ��������ǹ�ġ
				b1=new JButton("�α����");
				b2=new JButton("�����μ���");
				b3=new JButton("�Ĺ���������");
				b4=new JButton("��Ƽ����");
				b5=new JButton("�������");
				b6=new JButton("�˻�");
				tf=new JTextField(20);
				JPanel p=new JPanel();
				p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(tf);p.add(b6);
				// ������� �ڵ��ؾ��� tf�� ���������� ���� ��ġ��
				p.setBounds(10, 25, 900, 35);
				add(p);
				String[] col= {"��ȣ","Ʃ��","�̸�","���","����","���"};
				Object[][] row=new Object[0][5];//�̹��� ���ϵ� ����� �Ǳ� ������ string�� �ƴ� object��
				
				//DefaultTableModel => �������̵��� �޼ҵ尡 �ִ� (�͸��� Ŭ���� => ����Ŭ����)
				/*
				 *       ���� Ŭ���� => ������,��Ʈ��ũ
				 *       =======
				 *       class A
				 *       {
				 *             O   P  C  V  B
				 *             class B{  ==> aŬ������ ���Ŭ������
				 *             }
				 *       }
				 */
				model=new DefaultTableModel(row,col) {

					//������ �Ұ���
					@Override
					public boolean isCellEditable(int row, int column) {
						// TODO Auto-generated method stub
						return false;
					}
					//�̹��� ÷��
					@Override
					public Class<?> getColumnClass(int columnIndex) {
						// TODO Auto-generated method stub
						return getValueAt(0, columnIndex).getClass();
					}
					
				};
				
				table=new JTable(model);
				table.setRowHeight(35);
				JScrollPane js=new JScrollPane(table);
				// ������ ��������� ���̺� ����� ��� ���� ����ȴ�
				
				
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
				//������ ������ ����,���� ��Ű�� �ȿ����� �����پ��������� �ٸ���� import�ؾ���
				talingManager m=new talingManager();
				ArrayList<talingVO> list=m.talingAllData(cno);
				
				// ���̺� �ѹ� �����
				// ���������� ����� 
				for(int i=model.getRowCount()-1;i>=0;i--)
				{
					model.removeRow(i);
				}
				
				
				//������ ���
				/*
				 *     java.io,net ==> checkexception �ݵ�� ����ó��
				 */
				for(talingVO vo:list)
				{
					try
					{
						URL url=new URL(vo.getImage());//�̹����� �������� �����ͼ� http
						Image img=ClientMainFrame.getImage(new ImageIcon(url), 50, 50);//����Ѵ�
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
				//������ ������ ����,���� ��Ű�� �ȿ����� �����پ��������� �ٸ���� import�ؾ���
				talingManager m=new talingManager();
				ArrayList<talingVO> list=m.movieFindData(ss);
				
				// ���̺� �ѹ� �����
				// ���������� ����� 
				for(int i=model.getRowCount()-1;i>=0;i--)
				{
					model.removeRow(i);
				}
				
				
				//������ ���
				/*
				 *     java.io,net ==> checkexception �ݵ�� ����ó��
				 */
				for(talingVO vo:list)
				{
					try
					{
						URL url=new URL(vo.getImage());//�̹����� �������� �����ͼ� http
						Image img=ClientMainFrame.getImage(new ImageIcon(url), 50, 50);//����Ѵ�
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
