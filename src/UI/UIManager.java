package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import principal.Point;
import principal.MapManager;
import principal.Nodo;

public class UIManager extends javax.swing.JFrame implements MouseListener,  Observer {
	 
	 private MapManager map=new MapManager();
	 private Hashtable<JLabel,Nodo<Point>> hash=new Hashtable<JLabel,Nodo<Point>>();
	 Image ciudad = Toolkit.getDefaultToolkit().getImage("C:\\ciudad.png");
	 
	 public UIManager() throws IOException {
		/*this.setSize(WIDTH, HEIGHT);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		this.setLocationRelativeTo(null);*/
		
		JButton iniciar=new JButton("Iniciar");
		iniciar.setBounds(50,50,100,25);
		
		this.add(iniciar);
		
		
		/*JLabel foto = new JLabel(new ImageIcon(ciudad));
		foto.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.getContentPane().add(foto);*/
		
		pack();
		
		addMouseListener(this); 
		this.setLayout(null);
		setVisible(true);
		  
	 
		iniciar.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
		    iniciarsimulacion();
		  } 
		});
	 
	 }
	 
	@Override
	public void mouseClicked(MouseEvent e){
		// TODO Auto-generated method stub
		map.agregarPunto(e.getX(), e.getY());
		
	}
	
	
	public void paint(Graphics g)  
	{  
		 super.repaint(); 
		 g.drawImage(ciudad,100,100,this.getWidth(),this.getHeight(),null);
		 
		 for(Nodo<Point> nodo:  map.getGrafo().getNodos()) {
			 int x1=nodo.getValue().getX();
			 int y1=nodo.getValue().getY();
			 g.setColor(Color.BLUE);
			 g.fillOval(x1-30, y1-30, 40, 40);
			 
			 
			for(int i=0;i<nodo.getArcos().size();i++) {
				 
				 int x2=nodo.getArcos().get(i).getDestiny().getValue().getX();
				 int y2=nodo.getArcos().get(i).getDestiny().getValue().getY();
				 
				 //if(!nodo.getArcos().get(i).getDestiny().isVisitada()) {
				 g.drawLine(x1, y1, x2, y2);
				 //}
				 //nodo.getArcos().get(i).getDestiny().setVisitada(true);
				
			 }			 
		 }
	}  
	  
	
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
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
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		Nodo<Point> nodo= (Nodo<Point>) arg1;
		JLabel label=new JLabel("");
		label.setBounds(nodo.getValue().getX()-15, nodo.getValue().getY()-15,30,30);
		label.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		    	  me.getSource();
		      }
		});
	
		// metemos en el hash label, nodo
		hash.put(label, nodo);
		this.add(label);
		this.repaint();
		
	}
	
	public void iniciarsimulacion() {}
	
	public static void main(String[] args) throws Exception {
	      new UIManager();
	}
}
