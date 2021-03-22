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
import serveur.InterfacePendu;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControlleurPendu implements Initializable {

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
    void btnclic(ActionEvent event) {

    }

    ArrayList<Button> listButton;

    ArrayList<Image> listImage;

    InterfacePendu pendu;

    int idGame;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listImage = new ArrayList<Image>();

        for (int i = 0; i < 8; i++)
            listImage.add(new Image("client/jeux/pendu/image/" + i + ".png"));

        try {
            pendu = (InterfacePendu) Naming.lookup("rmi://localhost:8000/pendu");
            idGame = pendu.nouveauPendu();

         //   lblAffichage.setText(pendu.motAffiche(idGame));
         //   imageAffichage.setImage(listImage.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        listButton.add(t);
        listButton.add(s);
        listButton.add(t);
        listButton.add(u);
        listButton.add(v);
        listButton.add(w);
        listButton.add(x);
        listButton.add(y);
        listButton.add(z);

        btn_nouveau.setVisible(false);
       
        //lblFin.setText("");

        for (int i = 0; i < listButton.size(); i++) {
            listButton.get(i).setDisable(false);
        }
    }

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
            }}
         /*   if (essais >= 7)
                lblFin.setText("Vous avez perdu. Le mot était : " + mot + ".");
            else {
                if (essais == 0)
                    lblFin.setText("Bravo ! Vous avez trouvé le mot du premier coup !");
                else
                    lblFin.setText("Vous avez trouvé le mot en " + essais + " essais.");
            }
            btn_nouveau.setVisible(true);
        }*/ catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actualiseAffichage() {
        try {
            if (pendu.NbEssais(idGame) >= 7) {
                laFin();
            }
      //      lblAffichage.setText(pendu.motAffiche(idGame));
          //  imageAffichage.setImage(listImage.get(pendu.NbEssais(idGame)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void lettreClick(char lettre) {
        try {
            listButton.get((int) lettre - (int) 'a').setDisable(true);
            pendu.proposeLettre(idGame, lettre);
            if (pendu.Fin(idGame)) {
                laFin();
            }
            actualiseAffichage();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void clickA() {
        lettreClick('a');
    }
    @FXML
    public void clickB() {
        lettreClick('b');
    }
    @FXML
    public void clickC() {
        lettreClick('c');
    }
    @FXML
    public void lcickD() {
        lettreClick('d');
    }
    @FXML
    public void clickE() {
        lettreClick('e');
    }
    @FXML
    public void clickF() {
        lettreClick('f');
    }
    @FXML
    public void clickG() {
        lettreClick('g');
    }
    @FXML
    public void clickH() {
        lettreClick('h');
    }
    @FXML
    public void clickI() {
        lettreClick('i');
    }
    @FXML
    public void clickJ() {
        lettreClick('j');
    }
    @FXML
    public void clickK() {
        lettreClick('k');
    }
    @FXML
    public void clickL() {
        lettreClick('l');
    }
    @FXML
    public void clickM() {
        lettreClick('m');
    }
    @FXML
    public void clickN() {
        lettreClick('n');
    }
    @FXML
    public void clickO() {
        lettreClick('o');
    }
    @FXML
    public void clickP() {
        lettreClick('p');
    }
    @FXML
    public void clickQ() {
        lettreClick('q');
    }
    @FXML
    public void clickR() {
        lettreClick('r');
    }
    @FXML
    public void clickS() {
        lettreClick('s');
    }
    @FXML
    public void clickT() {
        lettreClick('t');
    }
    @FXML
    public void clickU() {
        lettreClick('u');
    }
    @FXML
    public void clickV() {
        lettreClick('v');
    }
    @FXML
    public void clickW() {
        lettreClick('w');
    }
    @FXML
    public void clickX() {
        lettreClick('x');
    }
    @FXML
    public void clickY() {
        lettreClick('y');
    }
    @FXML
    public void clickZ() {
        lettreClick('z');
    }
    

}
