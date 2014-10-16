package game48;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class  jlabel extends Label{
	int jishu;

	public jlabel() {
		this.setBackground(Color .GRAY );
		this.setText("");
		this.setAlignment(Label.CENTER);
		jishu = 0;
	}
	
	public void setcolor() {
		if (jishu == 0) {
			this.setText("");
			this.setBackground(Color.GRAY  );
		}
		else {
			switch (jishu) {
			case 2:
				this.setText(""+jishu);
				this.setBackground(Color.LIGHT_GRAY  );
				break;
			case 4:
				this.setText(""+jishu);
				this.setBackground(Color.orange );
				break;
			case 8:
				this.setText(""+jishu);
				this.setBackground(Color.magenta );
				break;
			case 16:
				this.setText(""+jishu);
				this.setBackground(Color.red );
				break;
			case 32:
				this.setText(""+jishu);
				this .setBackground(Color.yellow );
				break;
			case 64:
				this.setText(""+jishu);
				this.setBackground(Color.green );
				break;
			case 128:
				this.setText(""+jishu);
				this.setBackground(Color.BLACK);
				break;
			case 256:
				this.setText(""+jishu);
				this.setBackground(Color .blue);
				break;
			case 512:
				this.setText(""+jishu);
				this.setBackground(Color.CYAN);
				break;
			case 1024:
				this.setText(""+jishu);
				this.setBackground(Color.GRAY);
				break;
			case 2048:
				this.setText(""+jishu);
				this.setBackground(Color.pink);
				break;
			}
		}
		
	}

	public void setjishu(int jishu){
		this.jishu = jishu;
		this.setcolor();
	}
	
}
class jfame extends JFrame implements KeyListener,ActionListener {

	 jlabel jl[][]= new jlabel [4][4];
	 JPanel jp2 = new JPanel(new GridLayout(4,4,3,3));
	 JPanel jp1 = new JPanel(new GridLayout(1,1));
	 Label la = new Label("2048");
	 Random r = new Random();
	
	 JDialog dialog = new JDialog();
		JLabel label=new JLabel("你赢了，重新开始？");
		JButton button = new JButton("ok");
	 int temp ;
	 int [] temponel =new  int [4];
	 //int tempjishu;
	 public void newkuai() {
		 int count=0;
		 for (int i = 0; i < 4; i++) {
			 for (int j = 0; j < 4; j++) {
				 if(jl[i][j].jishu==0)
					{
					count++;		
				}
			}
			
		}
		 if(count==0){
			 //失败
			 //dialog.setVisible(true);
		 }
		 else{
			this.temp = r.nextInt(count);
		 for (int i = 0; i < 4; i++) {
			 for (int j = 0; j < 4; j++) {
				
				 
				// this.temp = this.temp+1;
				if(jl[i][j].jishu==0)
				{
				 if(this.temp --==0){
					 jl[i][j].setjishu(2);
				 }
				}
				
			}
		
	}
		 }
		 }
	 public void win() {
		 for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (jl[i][j].jishu==2048){
					
					dialog.setVisible(true);
				}
			}
		}
		 
		
	}
	 public boolean move (){
		int a=0;
		for (int i = 0; i <4; i++) {
			int tempi = i;
			a++;
			
			if (this.temponel[i]==0) {
				for (int j = i+1; j < 4; j++) {
					if (this.temponel[j]!=0) {
						
						this.temponel[i]=this.temponel[j];
						this.temponel[j]=0;
						i= tempi-1;
						break;
					}
				}
				
			}
			else {
				
				for (int j= i +1;j<4; j++){
					
					if (this.temponel[j]==this.temponel[i]) {
						this.temponel[i]= this.temponel[i]*2;
						this.temponel[j]=0;
						i=tempi-1;
						break;
					}
					else {
						if(this.temponel[j]!=0)
							break;
					}
				}
			}
			
		}
		System.out.print(a+"a");
		if(a<5){
			return false;
		}
		else
		return true;
	 }
	 public void up(){

		 int a=0;
		 for (int i = 0; i < 4; i++) {
			 
			 for (int j = 0; j < 4; j++) 
			 {	 
				 this.temponel[j]=jl[j][i].jishu;	
			}
			if (this.move()){
				a++;
			}
			 for (int j = 0; j <4; j++) {
				
				 jl[j][i].setjishu(this.temponel[j]);
			
			}
		
			}
		 
		 if (a>0)
		 this.newkuai();
		 win();
	 }
	public void  down(){
		 	 int a=0;
		 for (int i = 0; i < 4; i++) {
			 
			 for (int j = 0; j < 4; j++) 
			 {	 
				 this.temponel[j]=jl[3-j][i].jishu;	
			}
			if (this.move()){
				a++;
			}
			 for (int j = 0; j <4; j++) {
				
				 jl[3-j][i].setjishu(this.temponel[j]);
			
			}
		
			}
		 
		 if (a>0)
		 this.newkuai();
		 win();
	 }
	 public void  left() {
		 int a=0;
		 for (int i = 0; i < 4; i++) {
			 
			 for (int j = 0; j < 4; j++) 
			 {	 
				 this.temponel[j]=jl[i][j].jishu;	
			}
			if (this.move()){
				a++;
			}
			 for (int j = 0; j <4; j++) {
				
				 jl[i][j].setjishu(this.temponel[j]);
			
			}
		
			}
		 
		 if (a>0)
		 this.newkuai(); 
		 win();
	}
	 public void right() {
	 	 int a=0;
		 for (int i = 0; i < 4; i++) {
			 
			 for (int j = 0; j < 4; j++) 
			 {	 
				 this.temponel[j]=jl[i][3-j].jishu;	
			}
			if (this.move()){
				a++;
			}
			 for (int j = 0; j <4; j++) {
				
				 jl[i][3-j].setjishu(this.temponel[j]);
			
			}
		
			}
		 
		 if (a>0)
		 this.newkuai();
		 win();
	}
	 public jfame() {
		 super.setTitle("2048");
		 super.setResizable(false);
		 super.setBounds(80,80,300,300);
		 this.jp1.add(la);
		
		super.setLayout(new BorderLayout(5,5));
		 
		 super.add(jp1,BorderLayout.NORTH);
		 
		 for (int i = 0; i <4; i++) {
			 for (int j = 0; j < 4; j++) {
				
			
			 jl[i][j]= new jlabel();
			this.jp2.add(jl[i][j]);
			}
		}
		 addKeyListener(this);
		 super.add(jp2 );
		 super.setVisible(true);
		 super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		
		 this.newkuai();
		 dialog.setLayout(new GridLayout(2,1));
			dialog.add(label);
			dialog.add(button);
			
			button.addActionListener(this);
			dialog.setSize(200,100);
			dialog.setLocation(200, 200);
			dialog.setVisible(false);
			
		}
		// TODO Auto-generated constructor stub

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			down();
			break;
		case KeyEvent.VK_UP:
			up(); 	
			break;
		case KeyEvent.VK_LEFT:
	left();
			
			break;
		case KeyEvent.VK_RIGHT:
		right();
			break;
		default:
			break;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==button)
		{
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					this.jl[i][j].setjishu(0);
				}
			}
			
			this.newkuai();
		}
		
	}
	
	
}

public class game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new jfame();
	}

}
