package edu.fzu.cjp.tools;

import javax.swing.ImageIcon;

public class ImgManager {
	public static ImageIcon count[]=new ImageIcon[9];
	public static ImageIcon ds[]=new ImageIcon[11];
	public static ImageIcon faces[]=new ImageIcon[10];
	public static ImageIcon flag[]=new ImageIcon[7];
	public static ImageIcon flagDown[]=new ImageIcon[2];
	public static ImageIcon icon=new ImageIcon("./imges/icon.gif");
	static {
		for (int i = 0; i < count.length; i++) {
			count[i]=new ImageIcon("./imges/"+i+".gif");
		}
		for (int i = 0; i < ds.length; i++) {
			ds[i]=new ImageIcon("./imges/"+"d"+i+".gif");
		}
		for (int i = 0; i < faces.length; i++) {
			faces[i]=new ImageIcon("./imges/"+"face"+i+".gif");
		}
		for (int i = 0; i < flag.length; i++) {
			flag[i]=new ImageIcon("./imges/"+"fg"+i+".gif");
		}
		for (int i = 0; i < flagDown.length; i++) {
			flagDown[i]=new ImageIcon("./imges/"+"fgd"+i+".gif");
		}
	}
	
}
