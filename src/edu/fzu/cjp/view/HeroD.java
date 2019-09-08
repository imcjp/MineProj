package edu.fzu.cjp.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import edu.fzu.cjp.mine.Hero;
import edu.fzu.cjp.tools.ImgManager;

public class HeroD extends JDialog {

	SortedSet<Hero> set = null;
	JTextArea jta1=new JTextArea();
	JButton jb1=new JButton("÷ÿ÷√");
	JButton jb2=new JButton("»∑∂®");
	int grade=0;
	public HeroD(JFrame jf,int grade) {
		// TODO Auto-generated constructor stub
		super(jf, "…®¿◊”¢–€∞Ê", true);
		this.grade=grade;
		try {
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(
						new FileInputStream("data/hero"+grade));
				set = (SortedSet<Hero>) ois.readObject();
			} catch (EOFException ee) {
				// TODO Auto-generated catch block
				set=new TreeSet<Hero>();
			} catch (ClassNotFoundException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}finally{
				if(ois!=null) ois.close();
			}
			String s;
			java.util.Iterator<Hero> iset=set.iterator();
			if(iset.hasNext()){
				Hero hr=iset.next();
				jta1.append(""+hr);
			}
			while(iset.hasNext()){
				Hero hr=iset.next();
				jta1.append("\n"+hr);
			}
			jb1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					jta1.setText("");
					HeroD.this.pack();
					HeroD.this.validate();
					set.clear();
					try {
						ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("data/hero"+HeroD.this.grade));
						oos.writeObject(set);
						oos.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jb2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					HeroD.this.dispose();
				}
			});
			this.add(jta1);
			Box box1=Box.createHorizontalBox();
			Border border1 = BorderFactory.createEmptyBorder(10, 10, 0, 10);
			Border border2 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
			box1.setBorder(border1);
			box1.add(Box.createHorizontalGlue());
			box1.add(jb1);
			box1.add(Box.createHorizontalGlue());
			box1.add(jb2);
			box1.add(Box.createHorizontalGlue());
			((JPanel)this.getContentPane()).setBorder(border2);
			this.add(box1,BorderLayout.SOUTH);
			this.setLocationRelativeTo(jf);
			this.pack();
			this.setVisible(true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
