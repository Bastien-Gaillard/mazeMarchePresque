package main;

import java.util.Properties;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

public class Main {
	public static int minX=0,minY=0,maxX=80,maxY=25;
	public static ConsoleSystemInterface csi;
	public static void main(String... arg) {
		Boolean rejouer = true;

			Properties parametres = new Properties();
			parametres.setProperty("fontSize","18");
			parametres.setProperty("font", "SansSerif");
			//Création et initialisation de la console
			csi = new WSwingConsoleInterface("MaFenetre", parametres);
			csi.cls();
			Niveau n = new Niveau1();
			n.display();
			csi.saveBuffer();
			
			n.test();
	}
}