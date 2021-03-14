package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.util.Scanner;

import Modeles.ServJeux;
import javafx.application.Application;
import javafx.stage.Stage;


public abstract class Serveur{

	public static void main (String[] argv){
		try {
			int port = 8000;
			LocateRegistry.createRegistry(port);
			Naming.rebind(("rmi://127.0.0.1:"+port+"/jeux"), new ServJeux());
			System.out.println("Le serveur de jeux est prêt");
		} catch (Exception e) {
			System.out.println("Le serveur de jeux n'a pas pu démarrer :" + e);
		}
	}

}
	
