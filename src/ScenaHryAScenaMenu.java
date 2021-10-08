import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class ScenaHryAScenaMenu {

    // Konstruktory
    CernyHracAI cerny_hrac_AI = new CernyHracAI();
    BilyHracAI bily_hrac_AI = new BilyHracAI();
    CernyHracAIObtiznost2 cerny_hrac_AI_obtiznost2 = new CernyHracAIObtiznost2();
    BilyHracAIObtiznost2 bily_hrac_AI_obtiznost2 = new BilyHracAIObtiznost2();

    // AI
    private String AI = "";
    private String obtiznost_AI = "Lehká";

    // Scena menu
    private final Group vzhled_okna_menu = new Group();
    private final Scene scena_menu = new Scene(vzhled_okna_menu, Color.rgb(50, 40, 60));

    // Scena hry
    private final Group vzhled_okna_hry = new Group();
    private final Scene scena_hry = new Scene(vzhled_okna_hry, Color.rgb(54, 46, 64));

    // Tlacitko a Text Hrat znovu
    public static Text text_hrat_znovu = new Text();
    public static Button tlacitko_hrat_znovu = new Button();

    
    private void nastaveniHerniSceny(){
        // Vytvoření čtvercového pole
        int ctverec_x = 0;
        int ctverec_y = 0;
        boolean vybarveno = false;
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        vybarveno = true;
                    } else {
                        vybarveno = false;
                    }
                } else if (i % 2 != 0) {
                    if (j % 2 == 0) {
                        vybarveno = false;
                    } else {
                        vybarveno = true;
                    }
                }
                Rectangle ctverec = new Rectangle();
                ctverec.setStroke(Color.BLACK);
                ctverec.setFill(Color.ROSYBROWN);
                ctverec.setStrokeWidth(3);
                if (!vybarveno) {
                    ctverec.setFill(Color.LIMEGREEN);
                }
                ctverec.setWidth(64);
                ctverec.setHeight(64);
                ctverec.setX(ctverec_x);
                ctverec.setY(ctverec_y);
                vzhled_okna_hry.getChildren().add(ctverec);

                ctverec_x += 64;
            }
            ctverec_y += 64;
            ctverec_x = 0;
        }

        // Chat tlacitko na otevírání a zavírání okna
        ImageView chat_tlacitko = new ImageView("chat_oteviraci_sipka_doleva.png");
        chat_tlacitko.setX(480);
        chat_tlacitko.setY(240);

        // Chat okno
        ImageView chat_okno = new ImageView("pozadi_menu.png");
        chat_okno.setX(510);
        chat_okno.setY(0);
        chat_okno.setOpacity(0.4);
        chat_okno.setVisible(false);
        vzhled_okna_hry.getChildren().add(chat_okno);

        // Otevírání a zavírání chat okna
        chat_tlacitko.setOnMouseClicked(mouseEvent -> {
            if (!chat_okno.isVisible()) {
                chat_okno.setVisible(true);
                chat_tlacitko.setImage(new Image("chat_oteviraci_sipka_doprava.png"));
                Main.novy_hlavni_okno_aplikace.setWidth(Main.novy_hlavni_okno_aplikace.getWidth() + 340);
            }
            else if (chat_okno.isVisible()){
                chat_okno.setVisible(false);
                chat_tlacitko.setImage(new Image("chat_oteviraci_sipka_doleva.png"));
                Main.novy_hlavni_okno_aplikace.setWidth(Main.novy_hlavni_okno_aplikace.getWidth() - 340);
            }
        });
        vzhled_okna_hry.getChildren().add(chat_tlacitko);

        // Přidání figurek na scenu
        pridani_bilych_figurek();
        pridani_cernych_figurek();

        // Nastavení pohybu figurek pro hráče
        BilyHrac.nastaveni_pohybu_figurek(vzhled_okna_hry);
        CernyHrac.nastaveni_pohybu_figurek(vzhled_okna_hry);

        // Tlacitko Hrát znovu
        tlacitko_hrat_znovu.setLayoutX(160);
        tlacitko_hrat_znovu.setLayoutY(225);
        tlacitko_hrat_znovu.setMinWidth(180);
        tlacitko_hrat_znovu.setMinHeight(60);
        tlacitko_hrat_znovu.setOpacity(0.5);
        tlacitko_hrat_znovu.setVisible(false);
        vzhled_okna_hry.getChildren().add(tlacitko_hrat_znovu);

        // Text Hrát znovu
        text_hrat_znovu.setX(165);
        text_hrat_znovu.setY(265);
        text_hrat_znovu.setText("Hrát znovu");
        text_hrat_znovu.setFont(Font.font("Verdana", 30));
        text_hrat_znovu.setTextAlignment(TextAlignment.CENTER);
        text_hrat_znovu.setFill(Color.BLACK);
        text_hrat_znovu.setVisible(false);
        vzhled_okna_hry.getChildren().add(text_hrat_znovu);

        // Resetovani pro novou hru
        text_hrat_znovu.setOnMouseClicked(mouseEvent -> {
            // Pojištění kdyby hráč nevypl chat okno než začne novou hru
            Main.novy_hlavni_okno_aplikace.setWidth(525);
            Main.novy_hlavni_okno_aplikace.setHeight(550);
            chat_okno.setVisible(false);
            chat_tlacitko.setImage(new Image("chat_oteviraci_sipka_doleva.png"));

            // Resetování základních funkcí hry
            PohybyFigurky.ctvercove_pole_pro_figurky = new int[8][8];
            PohybyFigurky.figurka_zakliknuta = false;
            PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna_hry);
            PohybyFigurky.pomocny_ctverce.clear();
            PohybyFigurky.cislo_a_figurka.clear();
            PohybyFigurky.je_bily_hrac_na_rade = true;
            PohybyFigurky.je_cerny_hrac_na_rade = false;
            PohybyFigurky.vsechny_bile_ctverce_pro_mat.clear();
            PohybyFigurky.vsechny_cerne_ctverce_pro_mat.clear();
            PohybyFigurky.pohybove_ctverce_bileho_krale.clear();
            PohybyFigurky.pohybove_ctverce_cerneho_krale.clear();
            PohybyFigurky.je_sach_mat = false;

            // Resetování záznamů hry v chat okně
            PohybyFigurky.Y_pozice_zaznamu = 15;
            PohybyFigurky.pocet_zaznamu = 0;
            for (Text zaznam_k_odstraneni : PohybyFigurky.zaznamy_o_pohybu_figurek){
                vzhled_okna_hry.getChildren().remove(zaznam_k_odstraneni);
            }
            PohybyFigurky.zaznamy_o_pohybu_figurek.clear();

            resetovani_figurek(); // Vrátí figurky do zakladniho šachoveho postavení
            tlacitko_hrat_znovu.setVisible(false);
            text_hrat_znovu.setVisible(false);
        });

        // Hraní AI
        Timer casovac = new Timer();
        casovac.schedule(new TimerTask() {
            public void run() {
                // Spuštění nového vlákna procesoru
                Platform.runLater(() -> {
                    if (AI.equals("cerny_hrac") && obtiznost_AI.equals("Lehká")) {
                        cerny_hrac_AI.pohyb_AI_figurek(vzhled_okna_hry);
                    }
                    if (AI.equals("cerny_hrac") && obtiznost_AI.equals("Těžká")) {
                        cerny_hrac_AI_obtiznost2.pohyb_AI_figurek(vzhled_okna_hry);
                    }
                    if (AI.equals("bily_hrac") && obtiznost_AI.equals("Lehká")){
                        bily_hrac_AI.pohyb_AI_figurek(vzhled_okna_hry);
                    }
                    if (AI.equals("bily_hrac") && obtiznost_AI.equals("Těžká")){
                        bily_hrac_AI_obtiznost2.pohyb_AI_figurek(vzhled_okna_hry);
                    }

                });
            }
        }, 0, 50);
    }


    public Scene nastaveniMenuSceny(){
        // Nastaveni herní scény
        nastaveniHerniSceny();

        // Pozadi menu
        ImageView pozadi_menu = new ImageView("pozadi_menu.png");
        pozadi_menu.setX(0);
        pozadi_menu.setY(0);
        pozadi_menu.setOpacity(0.5);
        vzhled_okna_menu.getChildren().add(pozadi_menu);

        // Tlačítko pro hraní za bílého hráče
        Button tlacitko_bily_hrac = new Button();
        tlacitko_bily_hrac.setLayoutX(180);
        tlacitko_bily_hrac.setLayoutY(150);
        tlacitko_bily_hrac.setMinWidth(60);
        tlacitko_bily_hrac.setText("Bílý hráč");
        tlacitko_bily_hrac.setTextFill(Color.WHITE);
        tlacitko_bily_hrac.setBackground(Background.EMPTY);
        tlacitko_bily_hrac.setFont(Font.font("Verdana", 30));
        vzhled_okna_menu.getChildren().add(tlacitko_bily_hrac);

        tlacitko_bily_hrac.setOnMouseClicked(mouseEvent -> {
            Main.novy_hlavni_okno_aplikace.setScene(scena_hry);
            AI = "cerny_hrac";
            PohybyFigurky.hraje_hrac = true;
            PohybyFigurky.hraje_AI = false;
            PohybyFigurky.je_bily_hrac_na_rade = true;
            PohybyFigurky.je_cerny_hrac_na_rade = false;
        });

        // Tlačítko pro hraní za černého hráče
        Button tlacitko_cerny_hrac = new Button();
        tlacitko_cerny_hrac.setLayoutX(170);
        tlacitko_cerny_hrac.setLayoutY(250);
        tlacitko_cerny_hrac.setMinWidth(60);
        tlacitko_cerny_hrac.setText("Černý hráč");
        tlacitko_cerny_hrac.setTextFill(Color.BLACK);
        tlacitko_cerny_hrac.setBackground(Background.EMPTY);
        tlacitko_cerny_hrac.setFont(Font.font("Verdana", 30));
        vzhled_okna_menu.getChildren().add(tlacitko_cerny_hrac);

        tlacitko_cerny_hrac.setOnMouseClicked(mouseEvent -> {
            Main.novy_hlavni_okno_aplikace.setScene(scena_hry);
            AI = "bily_hrac";
            PohybyFigurky.hraje_hrac = false;
            PohybyFigurky.hraje_AI = true;
            PohybyFigurky.je_bily_hrac_na_rade = true;
            PohybyFigurky.je_cerny_hrac_na_rade = false;
        });

        // Vyber obtiznosti AI
        Rectangle cara = new Rectangle();
        cara.setWidth(100);
        cara.setHeight(15);
        cara.setFill(Color.TRANSPARENT);
        cara.setStroke(Color.BLACK);
        cara.setStrokeWidth(3);
        cara.setX(350);
        cara.setY(400);
        vzhled_okna_menu.getChildren().add(cara);

        // Text obtiznost AI
        Text text_obtiznost_AI = new Text();
        text_obtiznost_AI.setText("Obtížnost AI: " + obtiznost_AI);
        text_obtiznost_AI.setX(290);
        text_obtiznost_AI.setY(380);
        text_obtiznost_AI.setFill(Color.WHITE);
        text_obtiznost_AI.setFont(Font.font("Verdana", 20));
        vzhled_okna_menu.getChildren().add(text_obtiznost_AI);

        // První stupeň (ze zakladu zapnuto)
        Circle prvni_stupen = new Circle();
        prvni_stupen.setLayoutX(360);
        prvni_stupen.setLayoutY(406);
        prvni_stupen.setRadius(8);
        prvni_stupen.setStrokeWidth(3);
        prvni_stupen.setFill(Color.WHITE);
        prvni_stupen.setStroke(Color.WHITE);

        vzhled_okna_menu.getChildren().add(prvni_stupen);

        // Druhý stupeň
        Circle druhy_stupen = new Circle();
        druhy_stupen.setLayoutX(439);
        druhy_stupen.setLayoutY(406);
        druhy_stupen.setRadius(8);
        druhy_stupen.setStrokeWidth(3);
        druhy_stupen.setFill(Color.TRANSPARENT);
        druhy_stupen.setStroke(Color.WHITE);
        vzhled_okna_menu.getChildren().add(druhy_stupen);

        // Přepínání stupňů obtížnosti
        prvni_stupen.setOnMouseClicked(mouseEvent -> {
            if (prvni_stupen.getFill() == Color.TRANSPARENT){
                obtiznost_AI = "Lehká";
                prvni_stupen.setFill(Color.WHITE);
                druhy_stupen.setFill(Color.TRANSPARENT);
                text_obtiznost_AI.setText("Obtížnost AI: " + obtiznost_AI);
            }
        });
        druhy_stupen.setOnMouseClicked(mouseEvent -> {
            if (druhy_stupen.getFill() == Color.TRANSPARENT){
                obtiznost_AI = "Těžká";
                druhy_stupen.setFill(Color.WHITE);
                prvni_stupen.setFill(Color.TRANSPARENT);
                text_obtiznost_AI.setText("Obtížnost AI: " + obtiznost_AI);
            }
        });

        return scena_menu;
    }

    private void nastaveni_figurek_a_pridani_na_sachovnici(ImageView figurka, int ctverec_x, int ctverec_y, Group vzhled_okna) {
        figurka.setX(ctverec_x);
        figurka.setY(ctverec_y);
        vzhled_okna.getChildren().add(figurka);
    }
    private void pridani_bilych_figurek() {
        // Pridani figurek na scenu
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bila_vez1, 0, 0, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_kun1, 64, 0, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_strelec1, 64 * 2, 0, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_kral, 64 * 3, 0, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bila_kralovna, 64 * 4, 0, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_strelec2, 64 * 5, 0, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_kun2, 64 * 6, 0, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bila_vez2, 64 * 7, 0, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_pesak1, 0, 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_pesak2, 64, 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_pesak3, 64 * 2, 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_pesak4, 64 * 3, 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_pesak5, 64 * 4, 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_pesak6, 64 * 5, 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_pesak7, 64 * 6, 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(BilyHrac.bily_pesak8, 64 * 7, 64, vzhled_okna_hry);

        // Nastavení pozice figurek v čtvercovem poli a v hashmapu
        PohybyFigurky.ctvercove_pole_pro_figurky[0][0] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[0][1] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[0][2] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[0][3] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[0][4] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[0][5] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[0][6] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[0][7] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[1][0] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[1][1] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[1][2] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[1][3] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[1][4] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[1][5] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[1][6] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[1][7] = 1;
        PohybyFigurky.cislo_a_figurka.put("bila00", BilyHrac.bila_vez1);
        PohybyFigurky.cislo_a_figurka.put("bila01", BilyHrac.bily_kun1);
        PohybyFigurky.cislo_a_figurka.put("bila02", BilyHrac.bily_strelec1);
        PohybyFigurky.cislo_a_figurka.put("bila04", BilyHrac.bila_kralovna);
        PohybyFigurky.cislo_a_figurka.put("bila05", BilyHrac.bily_strelec2);
        PohybyFigurky.cislo_a_figurka.put("bila06", BilyHrac.bily_kun2);
        PohybyFigurky.cislo_a_figurka.put("bila07", BilyHrac.bila_vez2);
        PohybyFigurky.cislo_a_figurka.put("bila10", BilyHrac.bily_pesak1);
        PohybyFigurky.cislo_a_figurka.put("bila11", BilyHrac.bily_pesak2);
        PohybyFigurky.cislo_a_figurka.put("bila12", BilyHrac.bily_pesak3);
        PohybyFigurky.cislo_a_figurka.put("bila13", BilyHrac.bily_pesak4);
        PohybyFigurky.cislo_a_figurka.put("bila14", BilyHrac.bily_pesak5);
        PohybyFigurky.cislo_a_figurka.put("bila15", BilyHrac.bily_pesak6);
        PohybyFigurky.cislo_a_figurka.put("bila16", BilyHrac.bily_pesak7);
        PohybyFigurky.cislo_a_figurka.put("bila17", BilyHrac.bily_pesak8);
    }
    private void pridani_cernych_figurek() {
        // Pridani cernych figurek na scenu
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerna_vez1, 0, 7 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_kun1, 64, 7 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_strelec1, 64 * 2, 7 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_kral, 64 * 3, 7 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerna_kralovna, 64 * 4, 7 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_strelec2, 64 * 5, 7 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_kun2, 64 * 6, 7 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerna_vez2, 64 * 7, 7 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_pesak1, 0, 6 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_pesak2, 64, 6 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_pesak3, 64 * 2, 6 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_pesak4, 64 * 3, 6 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_pesak5, 64 * 4, 6 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_pesak6, 64 * 5, 6 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_pesak7, 64 * 6, 6 * 64, vzhled_okna_hry);
        nastaveni_figurek_a_pridani_na_sachovnici(CernyHrac.cerny_pesak8, 64 * 7, 6 * 64, vzhled_okna_hry);

        // Nastavení pozic v čtvercovem poli a hashmapu
        PohybyFigurky.ctvercove_pole_pro_figurky[7][0] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[7][1] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[7][2] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[7][3] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[7][4] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[7][5] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[7][6] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[7][7] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[6][0] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[6][1] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[6][2] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[6][3] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[6][4] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[6][5] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[6][6] = 1;
        PohybyFigurky.ctvercove_pole_pro_figurky[6][7] = 1;
        PohybyFigurky.cislo_a_figurka.put("cerna70", CernyHrac.cerna_vez1);
        PohybyFigurky.cislo_a_figurka.put("cerna71", CernyHrac.cerny_kun1);
        PohybyFigurky.cislo_a_figurka.put("cerna72", CernyHrac.cerny_strelec1);
        PohybyFigurky.cislo_a_figurka.put("cerna74", CernyHrac.cerna_kralovna);
        PohybyFigurky.cislo_a_figurka.put("cerna75", CernyHrac.cerny_strelec2);
        PohybyFigurky.cislo_a_figurka.put("cerna76", CernyHrac.cerny_kun2);
        PohybyFigurky.cislo_a_figurka.put("cerna77", CernyHrac.cerna_vez2);
        PohybyFigurky.cislo_a_figurka.put("cerna60", CernyHrac.cerny_pesak1);
        PohybyFigurky.cislo_a_figurka.put("cerna61", CernyHrac.cerny_pesak2);
        PohybyFigurky.cislo_a_figurka.put("cerna62", CernyHrac.cerny_pesak3);
        PohybyFigurky.cislo_a_figurka.put("cerna63", CernyHrac.cerny_pesak4);
        PohybyFigurky.cislo_a_figurka.put("cerna64", CernyHrac.cerny_pesak5);
        PohybyFigurky.cislo_a_figurka.put("cerna65", CernyHrac.cerny_pesak6);
        PohybyFigurky.cislo_a_figurka.put("cerna66", CernyHrac.cerny_pesak7);
        PohybyFigurky.cislo_a_figurka.put("cerna67", CernyHrac.cerny_pesak8);
    }
    private void resetovani_figurek(){
        // Odstranění bílých figurek ze sceny
        vzhled_okna_hry.getChildren().remove(BilyHrac.bila_vez1);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_kun1);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_strelec1);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_kral);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bila_kralovna);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_strelec2);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_kun2);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bila_vez2);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_pesak1);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_pesak2);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_pesak3);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_pesak4);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_pesak5);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_pesak6);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_pesak7);
        vzhled_okna_hry.getChildren().remove(BilyHrac.bily_pesak8);

        // Přidání bílých figurek na scenu
        pridani_bilych_figurek();

        // Resetovani figurek ktere jsou na sachovnici
        BilyHrac.bila_vez1_na_sachovnici = true;
        BilyHrac.bily_kun1_na_sachovnici = true;
        BilyHrac.bily_strelec1_na_sachovnici = true;
        BilyHrac.bily_kral_na_sachovnici = true;
        BilyHrac.bila_kralovna_na_sachovnici = true;
        BilyHrac.bily_strelec2_na_sachovnici = true;
        BilyHrac.bily_kun2_na_sachovnici = true;
        BilyHrac.bila_vez2_na_sachovnici = true;

        BilyHrac.bily_pesak1_na_sachovnici = true;
        BilyHrac.bily_pesak2_na_sachovnici = true;
        BilyHrac.bily_pesak3_na_sachovnici = true;
        BilyHrac.bily_pesak4_na_sachovnici = true;
        BilyHrac.bily_pesak5_na_sachovnici = true;
        BilyHrac.bily_pesak6_na_sachovnici = true;
        BilyHrac.bily_pesak7_na_sachovnici = true;
        BilyHrac.bily_pesak8_na_sachovnici = true;

        // Odstranění černých figurek ze sceny
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerna_vez1);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_kun1);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_strelec1);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_kral);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerna_kralovna);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_strelec2);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_kun2);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerna_vez2);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_pesak1);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_pesak2);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_pesak3);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_pesak4);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_pesak5);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_pesak6);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_pesak7);
        vzhled_okna_hry.getChildren().remove(CernyHrac.cerny_pesak8);

        // Přidání černých figurek na scenu
        pridani_cernych_figurek();

        // Resetovani figurek ktere jsou na sachovnici
        CernyHrac.cerna_vez1_na_sachovnici = true;
        CernyHrac.cerny_kun1_na_sachovnici = true;
        CernyHrac.cerny_strelec1_na_sachovnici = true;
        CernyHrac.cerny_kral_na_sachovnici = true;
        CernyHrac.cerna_kralovna_na_sachovnici = true;
        CernyHrac.cerny_strelec2_na_sachovnici = true;
        CernyHrac.cerny_kun2_na_sachovnici = true;
        CernyHrac.cerna_vez2_na_sachovnici = true;

        CernyHrac.cerny_pesak1_na_sachovnici = true;
        CernyHrac.cerny_pesak2_na_sachovnici = true;
        CernyHrac.cerny_pesak3_na_sachovnici = true;
        CernyHrac.cerny_pesak4_na_sachovnici = true;
        CernyHrac.cerny_pesak5_na_sachovnici = true;
        CernyHrac.cerny_pesak6_na_sachovnici = true;
        CernyHrac.cerny_pesak7_na_sachovnici = true;
        CernyHrac.cerny_pesak8_na_sachovnici = true;

        Main.novy_hlavni_okno_aplikace.setScene(scena_menu);
    }
    
}
