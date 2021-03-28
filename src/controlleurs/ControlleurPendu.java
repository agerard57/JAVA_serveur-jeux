package controlleurs;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import serveur.ImplPendu;
import serveur.InterfacePendu;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControlleurPendu implements Initializable {
	int erreur = 10;


	//definition des bouton et de l'affichage 
	@FXML
	private Label lblPendu;

	@FXML
	private Button a;

	@FXML
	private Button b;

	@FXML
	private Button c;

	@FXML
	private Button d;

	@FXML
	private Button e;

	@FXML
	private Button f;

	@FXML
	private Button g;

	@FXML
	private Button h;

	@FXML
	private Button i;

	@FXML
	private Button j;

	@FXML
	private Button k;

	@FXML
	private Button l;

	@FXML
	private Button m;

	@FXML
	private Button n;

	@FXML
	private Button o;

	@FXML
	private Button p;

	@FXML
	private Button q;

	@FXML
	private Button r;

	@FXML
	private Button s;

	@FXML
	private Button t;

	@FXML
	private Button u;

	@FXML
	private Button v;

	@FXML
	private Button w;

	@FXML
	private Button y;

	@FXML
	private Button x;

	@FXML
	private Button z;

	@FXML
	private Line erreur1;

	@FXML
	private Line erreur2;

	@FXML
	private Line erreur3;

	@FXML
	private Line erreur4;

	@FXML
	private Line erreur5;

	@FXML
	private Circle erreur6;

	@FXML
	private Line erreur7;

	@FXML
	private Line erreur8;

	@FXML
	private Line erreur9;

	@FXML
	private Line erreur10;

	@FXML
	private Line erreur11;

	@FXML
	private Button btn_nouveau;

	@FXML
	private Label lbl_mot;



	ArrayList<Line> listeErreur;

	ArrayList<Button> listButton;

	ArrayList<Image> listImage;

	InterfacePendu pendu;

	int idGame;

	//initialisation 
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		listImage = new ArrayList<Image>();
		for (int i = 0; i < 8; i++) 	
			try {
				pendu = (InterfacePendu) Naming.lookup("rmi://localhost:8001/pendu");
				idGame = pendu.nouveauPendu();

				//   lblAffichage.setText(pendu.motAffiche(idGame));
				//   imageAffichage.setImage(listImage.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
//on ajoute les traits dans la liste des erreurs
		listeErreur = new ArrayList<Line>();
		listeErreur.add(erreur1);
		listeErreur.add(erreur2);
		listeErreur.add(erreur3);
		listeErreur.add(erreur4);
		listeErreur.add(erreur5);
		listeErreur.add(erreur7);
		listeErreur.add(erreur8);
		listeErreur.add(erreur9);
		listeErreur.add(erreur10);
		listeErreur.add(erreur11);

//on ajoute tous les boutons, pour pouvoir les gérer en commun plus tard
		listButton = new ArrayList<Button>();

		listButton.add(a);
		listButton.add(b);
		listButton.add(c);
		listButton.add(d);
		listButton.add(e);
		listButton.add(f);
		listButton.add(g);
		listButton.add(h);
		listButton.add(i);
		listButton.add(j);
		listButton.add(k);
		listButton.add(l);
		listButton.add(m);
		listButton.add(n);
		listButton.add(o);
		listButton.add(p);
		listButton.add(q);
		listButton.add(r);
		listButton.add(t);
		listButton.add(s);
		listButton.add(t);
		listButton.add(u);
		listButton.add(v);
		listButton.add(w);
		listButton.add(x);
		listButton.add(y);
		listButton.add(z);

		//on gère l'erreur 6 a part, étant donné que ce n'est pas une ligne, elle ne peut pas faire partie de l'arraylist de lignes
		erreur6.setVisible(false);
		try {
			lbl_mot.setText(pendu.motAffiche(idGame)); //on affiche les traits pour pouvoir deviner le mot
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < 10; i++ ) {
			listeErreur.get(i).setVisible(false);//on n'affiche pas toutes les erreurs

		}

		btn_nouveau.setVisible(false);


		for (int i = 0; i < listButton.size(); i++) {
			listButton.get(i).setDisable(false); // on rend les boutons clickable 
		}
	}
//on regarde si c'est la fin, si oui on regarde le nombre d'erreurs
	public void laFin() {
		try {
			String mot;
			int essais;
			int i;

			i = 0;
			essais = pendu.NbEssais(idGame);
			mot = pendu.Mot(idGame);
			while (i < listButton.size()) {
				listButton.get(i).setDisable(true);
				i++;
			}
			if (essais >= erreur)
				//      lblFin.setText("Vous avez perdu. Le mot était : " + mot + ".");
				lblPendu.setText("perdu ! le mot était : " + mot);
			else {
				if (essais == 0)
					lblPendu.setText("Bravo ! Vous avez trouvé le mot du premier coup !");
				else
					lblPendu.setText("Vous avez trouvé le mot en " + essais + " erreur(s) !");
			}
			btn_nouveau.setVisible(true);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
//on actualise l'affichage, pour afficher les traits du pendu si la réponse était fausse
	public void actualiseAffichage() {
		try {
			if (pendu.NbEssais(idGame) > 0) {
				listeErreur.get(pendu.NbEssais(idGame) -1).setVisible(true);
				if (pendu.NbEssais(idGame) -1 == 5) {
					erreur6.setVisible(true);

				}
			}
			if (pendu.NbEssais(idGame) >= erreur) {
				laFin();
			}
			else 
				lbl_mot.setText(pendu.motAffiche(idGame));

		} catch (Exception e) {
			System.out.println(e);
		}
	}
//a chaque click sur une lettre, on appelle la fonction porposeLettre du serveur, et on actualise l'affichage
	public void lettreClick(char lettre) {
		try {
			pendu.proposeLettre(idGame, lettre);
			if (pendu.Fin(idGame)) {
				laFin();
			}
			actualiseAffichage();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
// le bouton nouvelle partie fait une nouvelle partie 
	public void nv_partie() {
		try {
			pendu.nouveauPendu(idGame);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		this.initialize(null, null);
	}


// ond définit les boutons de chaque clicks 
	@FXML
	void btnclic(ActionEvent event) {

	}
	public void clickA() {
		lettreClick('a');
		a.setDisable(true);
	}

	public void clickB() {
		lettreClick('b');
		b.setDisable(true);
	}
	public void clickC() {
		lettreClick('c');
		c.setDisable(true);
	}
	public void clickD() {
		lettreClick('d');
		d.setDisable(true);
	}
	public void clickE() {
		lettreClick('e');
		e.setDisable(true);
	}
	public void clickF() {
		lettreClick('f');
		f.setDisable(true);
	}
	public void clickG() {
		lettreClick('g');
		g.setDisable(true);
	}

	public void clickH() {
		lettreClick('h');
		h.setDisable(true);
	}

	public void clickI() {
		lettreClick('i');
		i.setDisable(true);
	}

	public void clickJ() {
		lettreClick('j');
		j.setDisable(true);
	}

	public void clickK() {
		lettreClick('k');
		k.setDisable(true);
	}

	public void clickL() {
		lettreClick('l');
		l.setDisable(true);
	}

	public void clickM() {
		lettreClick('m');
		m.setDisable(true);
	}

	public void clickN() {
		lettreClick('n');
		n.setDisable(true);
	}

	public void clickO() {
		lettreClick('o');
		o.setDisable(true);
	}

	public void clickP() {
		lettreClick('p');
		p.setDisable(true);
	}

	public void clickQ() {
		lettreClick('q');
		q.setDisable(true);
	}

	public void clickR() {
		lettreClick('r');
		r.setDisable(true);
	}

	public void clickS() {
		lettreClick('s');
		s.setDisable(true);
	}

	public void clickT() {
		lettreClick('t');
		t.setDisable(true);
	}

	public void clickU() {
		lettreClick('u');
		u.setDisable(true);
	}

	public void clickV() {
		lettreClick('v');
		v.setDisable(true);
	}

	public void clickW() {
		lettreClick('w');
		w.setDisable(true);
	}

	public void clickX() {
		lettreClick('x');
		x.setDisable(true);
	}

	public void clickY() {
		lettreClick('y');
		y.setDisable(true);
	}

	public void clickZ() {
		lettreClick('z');
		z.setDisable(true);
	}

}
