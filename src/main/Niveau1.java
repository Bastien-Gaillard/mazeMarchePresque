package main;
import java.util.Random;

import main.Main;
import main.Main;
import main.Mur;
/**
* Classe de repr�sentation du niveau 1, la fonction de
generationAuto est surcharg� pour g�n�rer un level sp�cifique
* Avec un nombre de pommes d�termin�
* @author coupr
*/
public class Niveau1 extends Niveau {
	public Niveau1() {
		super();
		setNumNiveau(1);
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
}