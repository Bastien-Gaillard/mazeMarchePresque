package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.slashie.libjcsi.CSIColor;

/**
* Le niveau représente la carte d'un level du jeux. Elle contient
des cases qui sont les sprites de type mur par exemple
* Et listeENtite qui sont les objets / créatures qui se trouvent
dans le niveau
* @author coupr
*/
public class Niveau {
	private Map<Integer, Map> lignes = new HashMap<Integer, Map>();
	private ArrayList<Sprite> cases = new ArrayList<Sprite>(); 
	private int numNiveau;
	private Map<Integer , Integer> coordonnee = new HashMap<Integer ,Integer>();
	private List<String> visite =  new ArrayList<String>() ;
	public Niveau() {

		generationAuto();
	}
	//Pour ajouter un sprite dans le tableau des cases
	public void addCase(int x, int y, Sprite s) {
		cases.add(s);
		if(!lignes.containsKey(y)) {
			Map<Integer, Sprite> ligne = new HashMap<Integer, Sprite>();
			ligne.put(x, s);
			lignes.put(y, ligne);
		} else {
			Map<Integer, Sprite> ligne = lignes.get(y);
			ligne.put(x, s);
		}
	}
	
	public void generationAuto() {
		System.out.println("Override");
		for(int i=Main.minX;i<Main.maxX;i++) {
			for(int j = Main.minY; j < Main.maxY;j++){
				addCase(i, j, new Mur(i,j));
				
//				addCase(new Mur(Main.maxX-i-1,j));
			}
		}
}
	//Génération automatique d'un level avec des murs et des pommes aléatoire
//	public void generationAuto() {
//		//Mur de contour et sol de base
//		for(int i=Main.minX;i<Main.maxX-1;i++) {
//			addCase(new Mur(i,Main.minY));
//			addCase(new Mur(i,Main.maxY-1));
//		}
//		for(int j=Main.minY+1;j<Main.maxY-1;j++) {
//			addCase(new Mur(Main.minX,j));
//			addCase(new Mur(Main.maxX-1,j));
//		}
//		for(int i=Main.minX+1;i<Main.maxX-1;i++) {
//			for(int j=Main.minY+1;j<Main.maxY-1;j++) {
//				addCase(new Mur(i,j));
//			}
//		}
//	}
	public void setNumNiveau(int numNiveau) {
		this.numNiveau = numNiveau;
	}
	//lance l'affichage des Sprites
	public void display() {
		for(Integer y : lignes.keySet()) {
			Map<Integer, Sprite> ligne = lignes.get(y);
			for(Integer x : ligne.keySet()) {
				Sprite s = ligne.get(x);
				s.display();
			}
		}
	}
	public Mur depart() {
		Random r = new Random();
		int x = 0 + (int)(Math.random() * (((Main.maxX - 1) - 0) + 1));
		int y = 0 + (int)(Math.random() * (((Main.maxY - 1) - 0) + 1));
		Mur c = (Mur) ((lignes.get(y)).get(x));
		c.visite(true);
		c.setCouleur(CSIColor.BLACK);
		c.display();
		
		return c;
	}
	public void test() {
		//Mur c = this.depart(), 
				Mur c= (Mur) ((lignes.get(24)).get(79));
		Mur c2 = null;
		int x = c.getX();
		int y = c.getY();
		int x2 = c.getX();
		int y2 = c.getY();
		int fin = 1;

		c.visite(true);	
		c.setSolid(false);
		c.affiche();
		
		while(fin < Main.maxX * Main.maxY) {
			double r2 = Math.random();
			double r3 = Math.random();
			
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
//			System.out.println("x : " + x + "y : " + y);
//			System.out.println("x2 : " + x2 + "y2 : " + y2);
//			//System.out.println(c.getX() + " " + c.getY());
//			if(r2 < 0.5) {
//				x = x + 2;
//				x2 = x2 + 1;
//			} else {
//				x = x - 2;
//				x2 = x2 - 1;
//			}
//			if(r3 < 0.5) {
//				y = y + 2; 
//				y2 = y2 + 1;
//			} else {
//				y = y - 2;
//				y2 = y2 - 1;
//			}
//			if(x <= Main.minX ) {
//				x = Main.minX;
//			} else if( x >= Main.maxX) {
//				x = Main.maxX - 1;
//			}
//			
//			if(y <= Main.minY) {
//				y = Main.minY;
//			} else if(y >= Main.maxY) {
//				y = Main.maxY - 1;
//			}
//			
//			if(x2 <= Main.minX ) {
//				x2 = Main.minX ;
//			} else if( x2 >= Main.maxX) {
//				x2 = Main.maxX - 1;
//			} 
//			
//			if(y2 <= Main.minY) {
//				y2 = Main.minY;
//			} else if(y2 >= Main.maxY) {
//				y2 = Main.maxY - 1;
//			}
//
//			//c.setCouleur(CSIColor.GREEN);
//			//c.display();
//
//			c = (Mur) ((lignes.get(y)).get(x));
//
//			if(c.getVisite() == false) {
//				
//				c.visite(true);				
//
//				Mur c2 = (Mur) ((lignes.get(y2)).get(x2));
//				c2.setCouleur(CSIColor.BLACK);
//				c2.display();
//				//c2.visite(true);
//				fin = fin + 1;
//				
//			} 
//			System.out.println(fin);
			System.out.println(c);

			
			System.out.println(fin);
			if(r2 < 0.25) {
				x2 = x+1;

				x = x + 2;
			} else if( r2 < 0.5){
				x2 = x-1;

				x = x - 2;
	} else if(r2 < 0.75) {
		y2 = y-1;

				y = y + 2; 
	} else {
		y2 = y-1;

				y = y - 2;
	}
			if(x <= Main.minX ) {
				x = Main.minX;
			} else if( x >= Main.maxX) {
				x = Main.maxX - 1;
			}
			
			if(y <= Main.minY) {
				y = Main.minY;
			} else if(y >= Main.maxY) {
				y = Main.maxY - 1;
			}
			if(x2 <= Main.minX ) {
				x2 = Main.minX;
			} else if( x2 >= Main.maxX) {
				x2 = Main.maxX - 1;
			}
			
			if(y2 <= Main.minY) {
				y2 = Main.minY;
			} else if(y2 >= Main.maxY) {
				y2 = Main.maxY - 1;
			}
			
			c = (Mur) ((lignes.get(y)).get(x));
			c2 = (Mur) ((lignes.get(y2)).get(x2));
			
			if(c.getVisite() == false) {					
				c.visite(true);	
				c.setSolid(false);
				c2.setSolid(false);
				//c.setCouleur(CSIColor.BLACK);
				//c.display();
				fin = fin + 1;
				System.out.println(c);
			} else {
				System.out.println("D�ja visit�: "+c);
			}
			c.affiche();
			c2.affiche();
		System.out.println(c);
		}

	}
}