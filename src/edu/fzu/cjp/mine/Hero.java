package edu.fzu.cjp.mine;

import java.io.Serializable;

public class Hero implements Comparable<Hero>,Serializable{
	private static final long serialVersionUID = -7420008323216911323L;
	public String name;
	public int time;
	public Hero(String name,int time) {
		// TODO Auto-generated constructor stub
		this.name =name;
		this.time=time;
	}
	@Override
	public int compareTo(Hero o) {
		// TODO Auto-generated method stub
		if(time<o.time){
			return -1;
		}else {
			return 1;
		}
	}
	public String toString(){
		return "名字是："+name+";\t\t分数是："+time+";\t\t";
	}
}
