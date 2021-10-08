import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.*;

public class PohybyFigurky {

    // Řádek a sloupec figurky
    private static int radek_figurky = 0;
    private static int sloupec_figurky = 0;

    // Ctvercove pole pro figurky
    public static int[][] ctvercove_pole_pro_figurky = new int[8][8];

    // Figurka zakliknuta
    public static boolean figurka_zakliknuta = false;

    // List pomocnych ctverecku ktere ukazuji možný pohyb figurky pro hrace
    public static final ArrayList<Rectangle> pomocny_ctverce = new ArrayList<>();

    // Zjištění jestli je figurka na určité pozici v čtvercovem poli
    public static final HashMap<String, ImageView> cislo_a_figurka = new HashMap<>();

    // Informace o HRÁČI a AI
    public static boolean hraje_hrac;
    public static boolean hraje_AI;
    public static boolean je_bily_hrac_na_rade;
    public static boolean je_cerny_hrac_na_rade;
    public static final ArrayList<Text> zaznamy_o_pohybu_figurek = new ArrayList<>();
    public static int Y_pozice_zaznamu = 15;
    public static int pocet_zaznamu = 0;

    // Čtverce určující jestli je šach mat
    public static final ArrayList<Rectangle> vsechny_bile_ctverce_pro_mat = new ArrayList<>();
    public static final ArrayList<Rectangle> vsechny_cerne_ctverce_pro_mat = new ArrayList<>();
    public static final ArrayList<Rectangle> pohybove_ctverce_bileho_krale = new ArrayList<>();
    public static final ArrayList<Rectangle> pohybove_ctverce_cerneho_krale = new ArrayList<>();
    public static boolean je_sach_mat = false;


    // Řádek a sloupec figurky
    public static int getRadek_figurky() {
        return radek_figurky;
    }
    public static void setRadek_figurky(int radek_figurky) {
        PohybyFigurky.radek_figurky = radek_figurky;
    }
    public static int getSloupec_figurky() {
        return sloupec_figurky;
    }
    public static void setSloupec_figurky(int sloupec_figurky) {
        PohybyFigurky.sloupec_figurky = sloupec_figurky;
    }


    // Pomocne čtverce které ukazují hráči možný pohyb figurky
    public static void nastaveni_parametru_pomocneho_ctverce(Rectangle ctverec){
        ctverec.setWidth(64);
        ctverec.setHeight(64);
        ctverec.setFill(Color.DARKRED);
        ctverec.setOpacity(0.5);
    }
    public static void smazani_pomocnych_ctvercu(Group vzhled_okna){
        for (Rectangle ctverec : pomocny_ctverce){
            vzhled_okna.getChildren().remove(ctverec);
        }
        pomocny_ctverce.clear();
    }


    // Odstranění figurek ze šachovnice
    public static void odstraneni_figurek_ze_sachovnice_bily_hrac(Group vzhled_okna, Rectangle ctverec){
        // Přidání figurky k odstranění do listu
        ArrayList<ImageView> figurka_k_odstraneni = new ArrayList<>();
        figurka_k_odstraneni.add(cislo_a_figurka.get("cerna" + (Integer.toString((int) (ctverec.getY() / 64)) + (int) (ctverec.getX() / 64))));

        // Odstranění figurky ze sceny a hashmapu
        vzhled_okna.getChildren().remove(cislo_a_figurka.get("cerna" + (Integer.toString((int) (ctverec.getY() / 64)) + (int) (ctverec.getX() / 64))));
        cislo_a_figurka.remove("cerna" + (Integer.toString((int) (ctverec.getY() / 64)) + (int) ctverec.getX() / 64));

        // Nastavení jestli je figurka na šachovem poli
        for (ImageView figurka : figurka_k_odstraneni){
            if (figurka == CernyHrac.cerna_vez1){
                CernyHrac.cerna_vez1_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerny_kun1){
                CernyHrac.cerny_kun1_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerny_strelec1){
                CernyHrac.cerny_strelec1_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerny_kral){
                CernyHrac.cerny_kral_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerna_kralovna){
                CernyHrac.cerna_kralovna_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerny_strelec2){
                CernyHrac.cerny_strelec2_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerny_kun2){
                CernyHrac.cerny_kun2_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerna_vez2){
                CernyHrac.cerna_vez2_na_sachovnici = false;
            }

            if (figurka == CernyHrac.cerny_pesak1){
                CernyHrac.cerny_pesak1_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerny_pesak2){
                CernyHrac.cerny_pesak2_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerny_pesak3){
                CernyHrac.cerny_pesak3_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerny_pesak4){
                CernyHrac.cerny_pesak4_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerny_pesak5){
                CernyHrac.cerny_pesak5_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerny_pesak6){
                CernyHrac.cerny_pesak6_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerny_pesak7){
                CernyHrac.cerny_pesak7_na_sachovnici = false;
            }
            if (figurka == CernyHrac.cerny_pesak8){
                CernyHrac.cerny_pesak8_na_sachovnici = false;
            }
        }
        figurka_k_odstraneni.clear();
    }
    public static void odstraneni_figurek_ze_sachovnice_cerny_hrac(Group vzhled_okna, Rectangle ctverec){
        // Přidání figurky k odstranění do listu
        ArrayList<ImageView> figurka_k_odstraneni = new ArrayList<>();
        figurka_k_odstraneni.add(cislo_a_figurka.get("bila" + (Integer.toString((int) (ctverec.getY() / 64)) + (int) (ctverec.getX() / 64))));

        // Odstranění figurky ze sceny a hashmapu
        vzhled_okna.getChildren().remove(cislo_a_figurka.get("bila" + (Integer.toString((int) (ctverec.getY() / 64)) + (int) (ctverec.getX() / 64))));
        cislo_a_figurka.remove("bila" + (Integer.toString((int) (ctverec.getY() / 64)) + (int) ctverec.getX() / 64));

        // Nastavení jestli je figurka na šachovem poli
        for (ImageView figurka : figurka_k_odstraneni){
            if (figurka == BilyHrac.bila_vez1){
                BilyHrac.bila_vez1_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bily_kun1){
                BilyHrac.bily_kun1_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bily_strelec1){
                BilyHrac.bily_strelec1_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bily_kral){
                BilyHrac.bily_kral_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bila_kralovna){
                BilyHrac.bila_kralovna_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bily_strelec2){
                BilyHrac.bily_strelec2_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bily_kun2){
                BilyHrac.bily_kun2_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bila_vez2){
                BilyHrac.bila_vez2_na_sachovnici = false;
            }

            if (figurka == BilyHrac.bily_pesak1){
                BilyHrac.bily_pesak1_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bily_pesak2){
                BilyHrac.bily_pesak2_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bily_pesak3){
                BilyHrac.bily_pesak3_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bily_pesak4){
                BilyHrac.bily_pesak4_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bily_pesak5){
                BilyHrac.bily_pesak5_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bily_pesak6){
                BilyHrac.bily_pesak6_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bily_pesak7){
                BilyHrac.bily_pesak7_na_sachovnici = false;
            }
            if (figurka == BilyHrac.bily_pesak8){
                BilyHrac.bily_pesak8_na_sachovnici = false;
            }
        }
        figurka_k_odstraneni.clear();
    }

    // Přidání záznamu o pohybu figurky a sach matu do chatu a do listu
    public static void pridani_zaznamu_o_pohybu_figurky_do_chatu_bily_hrac(String figurka, int radek, int sloupec, Group vzhled_okna){
        Text zaznam = new Text();
        zaznam.setText("Bílý hráč --> " + figurka + " na řádek " + radek + " a sloupec " + sloupec);
        zaznam.setFill(Color.WHITE);
        zaznam.setFont(Font.font("Verdana", 15));
        zaznam.setX(515);
        zaznam.setY(Y_pozice_zaznamu);
        Y_pozice_zaznamu += 15;
        zaznamy_o_pohybu_figurek.add(zaznam);
        vzhled_okna.getChildren().add(zaznam);
        pocet_zaznamu++;
        for (int i = 0; i <= zaznamy_o_pohybu_figurek.size(); i++){
            if (pocet_zaznamu % 32 == 0){
                for (Text text_zaznam : zaznamy_o_pohybu_figurek){
                    vzhled_okna.getChildren().remove(text_zaznam);
                }
                Y_pozice_zaznamu = 15;
                pocet_zaznamu = 0;
                break;
            }
        }
    }
    public static void pridani_zaznamu_o_pohybu_figurky_do_chatu_cerny_hrac(String figurka, int radek, int sloupec, Group vzhled_okna){
        Text zaznam = new Text();
        zaznam.setText("Černý hráč --> " + figurka + " na řádek " + radek + " a sloupec " + sloupec);
        zaznam.setFill(Color.WHITE);
        zaznam.setFont(Font.font("Verdana", 15));
        zaznam.setX(515);
        zaznam.setY(Y_pozice_zaznamu);
        Y_pozice_zaznamu += 15;
        zaznamy_o_pohybu_figurek.add(zaznam);
        vzhled_okna.getChildren().add(zaznam);
        pocet_zaznamu++;
        for (int i = 0; i <= zaznamy_o_pohybu_figurek.size(); i++){
            if (pocet_zaznamu % 32 == 0){
                for (Text text_zaznam : zaznamy_o_pohybu_figurek){
                    vzhled_okna.getChildren().remove(text_zaznam);
                }
                Y_pozice_zaznamu = 15;
                pocet_zaznamu = 0;
                break;
            }
        }
    }
    public static void pridani_zaznamu_o_sach_matu_do_chatu(Group vzhled_okna){
        if (je_sach_mat) {
            Text zaznam = new Text();
            zaznam.setText("Šach mat!");
            zaznam.setFill(Color.WHITE);
            zaznam.setFont(Font.font("Verdana", 15));
            zaznam.setX(515);
            zaznam.setY(Y_pozice_zaznamu);
            Y_pozice_zaznamu += 15;
            zaznamy_o_pohybu_figurek.add(zaznam);
            vzhled_okna.getChildren().add(zaznam);
            pocet_zaznamu++;
            for (int i = 0; i <= zaznamy_o_pohybu_figurek.size(); i++) {
                if (pocet_zaznamu % 32 == 0) {
                    for (Text text_zaznam : zaznamy_o_pohybu_figurek) {
                        vzhled_okna.getChildren().remove(text_zaznam);
                    }
                    Y_pozice_zaznamu = 15;
                    pocet_zaznamu = 0;
                    break;
                }
            }
        }
    }


    // Kliknutí na čtverec pro pohyb figurky bileho hrace
    private static void kliknuti_na_ctverec_bily_hrac(Rectangle ctverec, String nazev_figurky, ImageView figurka, Group vzhled_okna){
        je_sach_mat(vzhled_okna);
        if (hraje_hrac && !hraje_AI) {
            figurka.setX(ctverec.getX());
            figurka.setY(ctverec.getY());

            ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky()] = 0;
            ctvercove_pole_pro_figurky[(int) (ctverec.getY() / 64)][(int) (ctverec.getX() / 64)] = 1;

            cislo_a_figurka.remove("bila" + (Integer.toString(getRadek_figurky()) + getSloupec_figurky()));
            cislo_a_figurka.put("bila" + (Integer.toString((int) (ctverec.getY() / 64)) + (int) (ctverec.getX() / 64)), figurka);

            smazani_pomocnych_ctvercu(vzhled_okna);
            pridani_zaznamu_o_pohybu_figurky_do_chatu_bily_hrac(nazev_figurky, (int) (figurka.getY() / 64) + 1, (int) (figurka.getX() / 64) + 1, vzhled_okna);

            figurka_zakliknuta = false;
            je_bily_hrac_na_rade = false;
            je_cerny_hrac_na_rade = true;
            hraje_hrac = false;
            hraje_AI = true;
        }
        je_sach_mat(vzhled_okna);
    }
    private static void kliknuti_na_ctverec_s_figurkou_bily_hrac(Rectangle ctverec, String nazev_figurky, ImageView figurka, Group vzhled_okna){
        je_sach_mat(vzhled_okna);
        if (hraje_hrac && !hraje_AI) {
            odstraneni_figurek_ze_sachovnice_bily_hrac(vzhled_okna, ctverec);
            figurka.setX(ctverec.getX());
            figurka.setY(ctverec.getY());

            ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky()] = 0;
            ctvercove_pole_pro_figurky[(int) (ctverec.getY() / 64)][(int) (ctverec.getX() / 64)] = 1;

            cislo_a_figurka.remove("bila" + (Integer.toString(getRadek_figurky()) + getSloupec_figurky()));
            cislo_a_figurka.put("bila" + (Integer.toString((int) (ctverec.getY() / 64)) + (int) (ctverec.getX() / 64)), figurka);

            smazani_pomocnych_ctvercu(vzhled_okna);
            pridani_zaznamu_o_pohybu_figurky_do_chatu_bily_hrac(nazev_figurky, (int) (figurka.getY() / 64) + 1, (int) (figurka.getX() / 64) + 1, vzhled_okna);

            figurka_zakliknuta = false;
            je_bily_hrac_na_rade = false;
            je_cerny_hrac_na_rade = true;
            hraje_hrac = false;
            hraje_AI = true;
        }
        je_sach_mat(vzhled_okna);
    }
    private static void kliknuti_na_ctverec_bily_hrac_pro_krale(Rectangle ctverec, ImageView figurka, Group vzhled_okna){
        je_sach_mat(vzhled_okna);
        if (hraje_hrac && !hraje_AI) {
            figurka.setX(ctverec.getX());
            figurka.setY(ctverec.getY());

            ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky()] = 0;
            ctvercove_pole_pro_figurky[(int) (ctverec.getY() / 64)][(int) (ctverec.getX() / 64)] = 1;

            smazani_pomocnych_ctvercu(vzhled_okna);
            pridani_zaznamu_o_pohybu_figurky_do_chatu_bily_hrac("kral", (int) (figurka.getY() / 64) + 1, (int) (figurka.getX() / 64) + 1, vzhled_okna);

            figurka_zakliknuta = false;
            je_bily_hrac_na_rade = false;
            je_cerny_hrac_na_rade = true;
            hraje_hrac = false;
            hraje_AI = true;
        }
        je_sach_mat(vzhled_okna);
    }
    private static void kliknuti_na_ctverec_s_figurkou_bily_hrac_pro_krale(Rectangle ctverec, ImageView figurka, Group vzhled_okna){
        je_sach_mat(vzhled_okna);
        if (hraje_hrac && !hraje_AI) {
            odstraneni_figurek_ze_sachovnice_bily_hrac(vzhled_okna, ctverec);
            figurka.setX(ctverec.getX());
            figurka.setY(ctverec.getY());

            ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky()] = 0;
            ctvercove_pole_pro_figurky[(int) (ctverec.getY() / 64)][(int) (ctverec.getX() / 64)] = 1;

            smazani_pomocnych_ctvercu(vzhled_okna);
            pridani_zaznamu_o_pohybu_figurky_do_chatu_bily_hrac("kral", (int) (figurka.getY() / 64) + 1, (int) (figurka.getX() / 64) + 1, vzhled_okna);

            figurka_zakliknuta = false;
            je_bily_hrac_na_rade = false;
            je_cerny_hrac_na_rade = true;
            hraje_hrac = false;
            hraje_AI = true;
        }
        je_sach_mat(vzhled_okna);
    }

    // Kliknutí na čtverec pro pohyb figurky cerneho hrace
    private static void kliknuti_na_ctverec_cerny_hrac(Rectangle ctverec, String nazev_figurky, ImageView figurka, Group vzhled_okna){
        je_sach_mat(vzhled_okna);
        if (hraje_hrac && !hraje_AI) {
            figurka.setX(ctverec.getX());
            figurka.setY(ctverec.getY());

            ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky()] = 0;
            ctvercove_pole_pro_figurky[(int) (ctverec.getY() / 64)][(int) (ctverec.getX() / 64)] = 1;

            cislo_a_figurka.remove("cerna" + (Integer.toString(getRadek_figurky()) + getSloupec_figurky()));
            cislo_a_figurka.put("cerna" + (Integer.toString((int) (ctverec.getY() / 64)) + (int) (ctverec.getX() / 64)), figurka);

            smazani_pomocnych_ctvercu(vzhled_okna);
            pridani_zaznamu_o_pohybu_figurky_do_chatu_cerny_hrac(nazev_figurky, (int) (figurka.getY() / 64) + 1, (int) (figurka.getX() / 64) + 1, vzhled_okna);

            figurka_zakliknuta = false;
            je_cerny_hrac_na_rade = false;
            je_bily_hrac_na_rade = true;
            hraje_hrac = false;
            hraje_AI = true;
        }
        je_sach_mat(vzhled_okna);
    }
    private static void kliknuti_na_ctverec_s_figurkou_cerny_hrac(Rectangle ctverec, String nazev_figurky, ImageView figurka, Group vzhled_okna){
        je_sach_mat(vzhled_okna);
        if (hraje_hrac && !hraje_AI) {
            odstraneni_figurek_ze_sachovnice_cerny_hrac(vzhled_okna, ctverec);
            figurka.setX(ctverec.getX());
            figurka.setY(ctverec.getY());

            ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky()] = 0;
            ctvercove_pole_pro_figurky[(int) (ctverec.getY() / 64)][(int) (ctverec.getX() / 64)] = 1;

            cislo_a_figurka.remove("cerna" + (Integer.toString(getRadek_figurky()) + getSloupec_figurky()));
            cislo_a_figurka.put("cerna" + (Integer.toString((int) (ctverec.getY() / 64)) + (int) (ctverec.getX() / 64)), figurka);

            smazani_pomocnych_ctvercu(vzhled_okna);
            pridani_zaznamu_o_pohybu_figurky_do_chatu_cerny_hrac(nazev_figurky, (int) (figurka.getY() / 64) + 1, (int) (figurka.getX() / 64) + 1, vzhled_okna);

            figurka_zakliknuta = false;
            je_cerny_hrac_na_rade = false;
            je_bily_hrac_na_rade = true;
            hraje_hrac = false;
            hraje_AI = true;
        }
        je_sach_mat(vzhled_okna);
    }
    private static void kliknuti_na_ctverec_cerny_hrac_pro_krale(Rectangle ctverec, ImageView figurka, Group vzhled_okna){
        je_sach_mat(vzhled_okna);
        if (hraje_hrac && !hraje_AI) {
            figurka.setX(ctverec.getX());
            figurka.setY(ctverec.getY());

            ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky()] = 0;
            ctvercove_pole_pro_figurky[(int) (ctverec.getY() / 64)][(int) (ctverec.getX() / 64)] = 1;

            smazani_pomocnych_ctvercu(vzhled_okna);
            pridani_zaznamu_o_pohybu_figurky_do_chatu_cerny_hrac("kral", (int) (figurka.getY() / 64) + 1, (int) (figurka.getX() / 64) + 1, vzhled_okna);

            figurka_zakliknuta = false;
            je_cerny_hrac_na_rade = false;
            je_bily_hrac_na_rade = true;
            hraje_hrac = false;
            hraje_AI = true;
        }
        je_sach_mat(vzhled_okna);
    }
    private static void kliknuti_na_ctverec_s_figurkou_cerny_hrac_pro_krale(Rectangle ctverec, ImageView figurka, Group vzhled_okna){
        je_sach_mat(vzhled_okna);
        if (hraje_hrac && !hraje_AI) {
            odstraneni_figurek_ze_sachovnice_cerny_hrac(vzhled_okna, ctverec);
            figurka.setX(ctverec.getX());
            figurka.setY(ctverec.getY());

            ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky()] = 0;
            ctvercove_pole_pro_figurky[(int) (ctverec.getY() / 64)][(int) (ctverec.getX() / 64)] = 1;

            smazani_pomocnych_ctvercu(vzhled_okna);
            pridani_zaznamu_o_pohybu_figurky_do_chatu_cerny_hrac("kral", (int) (figurka.getY() / 64) + 1, (int) (figurka.getX() / 64) + 1, vzhled_okna);

            figurka_zakliknuta = false;
            je_cerny_hrac_na_rade = false;
            je_bily_hrac_na_rade = true;
            hraje_hrac = false;
            hraje_AI = true;
        }
        je_sach_mat(vzhled_okna);
    }


    // Matove čtverce
    public static void updatovani_bilych_matovych_ctvercu(Group vzhled_okna){
        BilyHrac.vytvoreni_matovych_ctvercu_bila_vez1(BilyHrac.bila_vez1, vzhled_okna);
        BilyHrac.vytvoreni_matovych_ctvercu_bila_vez2(BilyHrac.bila_vez2, vzhled_okna);
        BilyHrac.vytvoreni_matovych_ctvercu_bily_kun1(BilyHrac.bily_kun1, vzhled_okna);
        BilyHrac.vytvoreni_matovych_ctvercu_bily_kun2(BilyHrac.bily_kun2, vzhled_okna);
        BilyHrac.vytvoreni_matovych_ctvercu_bily_strelec1(BilyHrac.bily_strelec1, vzhled_okna);
        BilyHrac.vytvoreni_matovych_ctvercu_bily_strelec2(BilyHrac.bily_strelec2, vzhled_okna);
        BilyHrac.vytvoreni_matovych_ctvercu_bily_kral(BilyHrac.bily_kral, vzhled_okna);
        BilyHrac.vytvoreni_matovych_ctvercu_bila_kralovna(BilyHrac.bila_kralovna, vzhled_okna);
        BilyHrac.vytvoreni_matovych_ctvercu_bili_pesci(BilyHrac.bily_pesak1, BilyHrac.bily_pesak2, BilyHrac.bily_pesak3, BilyHrac.bily_pesak4, BilyHrac.bily_pesak5, BilyHrac.bily_pesak6, BilyHrac.bily_pesak7, BilyHrac.bily_pesak8, vzhled_okna);

        ArrayList<Rectangle> pomocny_list = new ArrayList<>(vsechny_bile_ctverce_pro_mat);

        // Odstranění duplikátů
        for (Rectangle matovy_ctverec : vsechny_bile_ctverce_pro_mat){
            boolean pridano = false;
            for (int i = 0; i < pomocny_list.size(); i++){
                Rectangle matovy_ctverec_pomocny_list = pomocny_list.get(i);
                if (matovy_ctverec_pomocny_list.getY() == matovy_ctverec.getY() && matovy_ctverec_pomocny_list.getX() == matovy_ctverec.getX()) {
                    if (!pridano) {
                        pridano = true;
                    }
                    else {
                        pomocny_list.remove(matovy_ctverec_pomocny_list);
                    }
                }
            }
        }

        vsechny_bile_ctverce_pro_mat.clear();
        vsechny_bile_ctverce_pro_mat.addAll(pomocny_list);
    }
    public static void updatovani_cernych_matovych_ctvercu(Group vzhled_okna){
        CernyHrac.vytvoreni_matovych_ctvercu_cerna_vez1(CernyHrac.cerna_vez1, vzhled_okna);
        CernyHrac.vytvoreni_matovych_ctvercu_cerna_vez2(CernyHrac.cerna_vez2, vzhled_okna);
        CernyHrac.vytvoreni_matovych_ctvercu_cerny_kun1(CernyHrac.cerny_kun1, vzhled_okna);
        CernyHrac.vytvoreni_matovych_ctvercu_cerny_kun2(CernyHrac.cerny_kun2, vzhled_okna);
        CernyHrac.vytvoreni_matovych_ctvercu_cerny_strelec1(CernyHrac.cerny_strelec1, vzhled_okna);
        CernyHrac.vytvoreni_matovych_ctvercu_cerny_strelec2(CernyHrac.cerny_strelec2, vzhled_okna);
        CernyHrac.vytvoreni_matovych_ctvercu_cerny_kral(CernyHrac.cerny_kral, vzhled_okna);
        CernyHrac.vytvoreni_matovych_ctvercu_cerna_kralovna(CernyHrac.cerna_kralovna, vzhled_okna);
        CernyHrac.vytvoreni_matovych_ctvercu_cerni_pesci(CernyHrac.cerny_pesak1, CernyHrac.cerny_pesak2, CernyHrac.cerny_pesak3, CernyHrac.cerny_pesak4, CernyHrac.cerny_pesak5, CernyHrac.cerny_pesak6, CernyHrac.cerny_pesak7, CernyHrac.cerny_pesak8, vzhled_okna);

        ArrayList<Rectangle> pomocny_list = new ArrayList<>(vsechny_cerne_ctverce_pro_mat);

        // Odstranění duplikátů
        for (Rectangle matovy_ctverec : vsechny_cerne_ctverce_pro_mat){
            boolean pridano = false;
            for (int i = 0; i < pomocny_list.size(); i++){
                Rectangle matovy_ctverec_pomocny_list = pomocny_list.get(i);
                if (matovy_ctverec_pomocny_list.getY() == matovy_ctverec.getY() && matovy_ctverec_pomocny_list.getX() == matovy_ctverec.getX()) {
                    if (!pridano) {
                        pridano = true;
                    }
                    else {
                        pomocny_list.remove(matovy_ctverec_pomocny_list);
                    }
                }
            }
        }

        vsechny_cerne_ctverce_pro_mat.clear();
        vsechny_cerne_ctverce_pro_mat.addAll(pomocny_list);
    }


    // Je šach mat
    private static void vytvoreni_pohybovych_ctvercu_cerneho_krale(int ctverec_y, int ctverec_x){
        Rectangle ctverec = new Rectangle();
        if (ctverec_x >= 0 && ctverec_x <= 7 * 64 && ctverec_y >= 0 && ctverec_y <= 7 * 64) {
            ctverec.setX(ctverec_x);
            ctverec.setY(ctverec_y);
            pohybove_ctverce_cerneho_krale.add(ctverec);
        }
    }
    private static void vytvoreni_pohybovych_ctvercu_bileho_krale(int ctverec_y, int ctverec_x){
        Rectangle ctverec = new Rectangle();
        if (ctverec_x >= 0 && ctverec_x <= 7 * 64 && ctverec_y >= 0 && ctverec_y <= 7 * 64) {
            ctverec.setX(ctverec_x);
            ctverec.setY(ctverec_y);
            pohybove_ctverce_bileho_krale.add(ctverec);
        }
    }
    public static void kontrola_sach_matu_cerny_kral(ImageView cerny_kral){
        // 1 2 3
        // 4 K 5
        // 6 7 8
        int cerny_kral_y = (int) cerny_kral.getY();
        int cerny_kral_x = (int) cerny_kral.getX();
        vytvoreni_pohybovych_ctvercu_cerneho_krale(cerny_kral_y - 64, cerny_kral_x - 64);
        vytvoreni_pohybovych_ctvercu_cerneho_krale(cerny_kral_y - 64, cerny_kral_x);
        vytvoreni_pohybovych_ctvercu_cerneho_krale(cerny_kral_y - 64, cerny_kral_x + 64);
        vytvoreni_pohybovych_ctvercu_cerneho_krale(cerny_kral_y, cerny_kral_x - 64);
        vytvoreni_pohybovych_ctvercu_cerneho_krale(cerny_kral_y, cerny_kral_x + 64);
        vytvoreni_pohybovych_ctvercu_cerneho_krale(cerny_kral_y + 64, cerny_kral_x - 64);
        vytvoreni_pohybovych_ctvercu_cerneho_krale(cerny_kral_y + 64, cerny_kral_x);
        vytvoreni_pohybovych_ctvercu_cerneho_krale(cerny_kral_y + 64, cerny_kral_x + 64);

        // Pohybove čtverce krale ktere jsou v matu vyplníme modře a když budou všechny naráz modre tak je šach mat
        for (Rectangle pohybovy_ctverec_krale : pohybove_ctverce_cerneho_krale) {
            for (Rectangle matovy_ctverec : vsechny_bile_ctverce_pro_mat) {
                if (matovy_ctverec.getY() == pohybovy_ctverec_krale.getY() && matovy_ctverec.getX() == pohybovy_ctverec_krale.getX()) {
                    pohybovy_ctverec_krale.setFill(Color.BLUE);
                    break;
                }
            }
        }

        int pocet_modrych_kralovych_pohybovych_ctvercu = 0;
        int pocet_kralovych_pohybovych_ctvercu = pohybove_ctverce_cerneho_krale.size();

        for (Rectangle pohybovy_ctverec_krale : pohybove_ctverce_cerneho_krale){
            if (pohybovy_ctverec_krale.getFill() == Color.BLUE){
                pocet_modrych_kralovych_pohybovych_ctvercu++;
            }
            if (pocet_modrych_kralovych_pohybovych_ctvercu == pocet_kralovych_pohybovych_ctvercu){
                je_sach_mat = true;
            }
        }

        pohybove_ctverce_cerneho_krale.clear();
    }
    public static void kontrola_sach_matu_bily_kral(ImageView bily_kral){
        // 1 2 3
        // 4 K 5
        // 6 7 8
        int bily_kral_y = (int) bily_kral.getY();
        int bily_kral_x = (int) bily_kral.getX();
        vytvoreni_pohybovych_ctvercu_bileho_krale(bily_kral_y - 64, bily_kral_x - 64);
        vytvoreni_pohybovych_ctvercu_bileho_krale(bily_kral_y - 64, bily_kral_x);
        vytvoreni_pohybovych_ctvercu_bileho_krale(bily_kral_y - 64, bily_kral_x + 64);
        vytvoreni_pohybovych_ctvercu_bileho_krale(bily_kral_y, bily_kral_x - 64);
        vytvoreni_pohybovych_ctvercu_bileho_krale(bily_kral_y, bily_kral_x + 64);
        vytvoreni_pohybovych_ctvercu_bileho_krale(bily_kral_y + 64, bily_kral_x - 64);
        vytvoreni_pohybovych_ctvercu_bileho_krale(bily_kral_y + 64, bily_kral_x);
        vytvoreni_pohybovych_ctvercu_bileho_krale(bily_kral_y + 64, bily_kral_x + 64);

        // Pohybove čtverce krale ktere jsou v matu vyplníme modře a když budou všechny naráz modre tak je šach mat
        for (Rectangle pohybovy_ctverec_krale : pohybove_ctverce_bileho_krale) {
            for (Rectangle matovy_ctverec : vsechny_cerne_ctverce_pro_mat) {
                if (matovy_ctverec.getY() == pohybovy_ctverec_krale.getY() && matovy_ctverec.getX() == pohybovy_ctverec_krale.getX()) {
                    pohybovy_ctverec_krale.setFill(Color.BLUE);
                    break;
                }
            }
        }

        int pocet_modrych_kralovych_pohybovych_ctvercu = 0;
        int pocet_kralovych_pohybovych_ctvercu = pohybove_ctverce_bileho_krale.size();

        for (Rectangle pohybovy_ctverec_krale : pohybove_ctverce_bileho_krale){
            if (pohybovy_ctverec_krale.getFill() == Color.BLUE){
                pocet_modrych_kralovych_pohybovych_ctvercu++;
            }
            if (pocet_modrych_kralovych_pohybovych_ctvercu == pocet_kralovych_pohybovych_ctvercu){
                je_sach_mat = true;
            }
        }

        pohybove_ctverce_bileho_krale.clear();
    }
    public static void je_sach_mat(Group vzhled_okna){
        updatovani_bilych_matovych_ctvercu(vzhled_okna);
        updatovani_cernych_matovych_ctvercu(vzhled_okna);
        kontrola_sach_matu_cerny_kral(CernyHrac.cerny_kral);
        kontrola_sach_matu_bily_kral(BilyHrac.bily_kral);
        if (je_sach_mat){
            pridani_zaznamu_o_sach_matu_do_chatu(vzhled_okna);
            hraje_hrac = false;
            hraje_AI = false;
            ScenaHryAScenaMenu.tlacitko_hrat_znovu.setVisible(true);
            ScenaHryAScenaMenu.text_hrat_znovu.setVisible(true);
        }
    }


    // Pohyb bílých figurek
    public static void pohyb_bile_veze(Group vzhled_okna, ImageView vez){
        // Pohyb po ose Y - DOLU
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky()] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX(getSloupec_figurky() * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "vez", vez, vzhled_okna);

                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + i)) + getSloupec_figurky()) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX(getSloupec_figurky() * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "vez", vez, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // Pohyb po ose Y - NAHORU
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky()] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX(getSloupec_figurky() * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "vez", vez, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - i)) + getSloupec_figurky()) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX(getSloupec_figurky() * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "vez", vez, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // Pohyb po ose X - DOLEVA
        for (int i = 1; i <= 7; i++) {
            if ((getSloupec_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky() - i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - i) * 64);
                    ctverec.setY(getRadek_figurky() * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "vez", vez, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky())) + (getSloupec_figurky() - i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() - i) * 64);
                        ctverec.setY((getRadek_figurky()) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "vez", vez, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // Pohyb po ose X - DOPRAVA
        for (int i = 1; i <= 7; i++) {
            if ((getSloupec_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky() + i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + i) * 64);
                    ctverec.setY(getRadek_figurky() * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "vez", vez, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky())) + (getSloupec_figurky() + i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() + i) * 64);
                        ctverec.setY((getRadek_figurky()) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "vez", vez, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
    }
    public static void pohyb_bileho_kone(Group vzhled_okna, ImageView kun) {
        // 1
        if ((getRadek_figurky() - 2) * 64 >= 0 && (getSloupec_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 2][getSloupec_figurky() - 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 1) * 64);
                ctverec.setY((getRadek_figurky() - 2) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - 2)) + (getSloupec_figurky() - 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 1) * 64);
                    ctverec.setY((getRadek_figurky() - 2) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 2
        if ((getRadek_figurky() - 2) * 64 >= 0 && (getSloupec_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 2][getSloupec_figurky() + 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 1) * 64);
                ctverec.setY((getRadek_figurky() - 2) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - 2)) + (getSloupec_figurky() + 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 1) * 64);
                    ctverec.setY((getRadek_figurky() - 2) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 3
        if ((getRadek_figurky() - 1) * 64 >= 0 && (getSloupec_figurky() - 2) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 1][getSloupec_figurky() - 2] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 2) * 64);
                ctverec.setY((getRadek_figurky() - 1) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - 1)) + (getSloupec_figurky() - 2)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 2) * 64);
                    ctverec.setY((getRadek_figurky() - 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 4
        if ((getRadek_figurky() - 1) * 64 >= 0 && (getSloupec_figurky() + 2) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 1][getSloupec_figurky() + 2] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 2) * 64);
                ctverec.setY((getRadek_figurky() - 1) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - 1)) + (getSloupec_figurky() + 2)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 2) * 64);
                    ctverec.setY((getRadek_figurky() - 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 5
        if ((getRadek_figurky() + 1) * 64 <= 7 * 64 && (getSloupec_figurky() - 2) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 1][getSloupec_figurky() - 2] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 2) * 64);
                ctverec.setY((getRadek_figurky() + 1) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + 1)) + (getSloupec_figurky() - 2)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 2) * 64);
                    ctverec.setY((getRadek_figurky() + 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 6
        if ((getRadek_figurky() + 1) * 64 <= 7 * 64 && (getSloupec_figurky() + 2) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 1][getSloupec_figurky() + 2] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 2) * 64);
                ctverec.setY((getRadek_figurky() + 1) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + 1)) + (getSloupec_figurky() + 2)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 2) * 64);
                    ctverec.setY((getRadek_figurky() + 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 7
        if ((getRadek_figurky() + 2) * 64 <= 7 * 64 && (getSloupec_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 2][getSloupec_figurky() - 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 1) * 64);
                ctverec.setY((getRadek_figurky() + 2) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + 2)) + (getSloupec_figurky() - 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 1) * 64);
                    ctverec.setY((getRadek_figurky() + 2) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 8
        if ((getRadek_figurky() + 2) * 64 <= 7 * 64 && (getSloupec_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 2][getSloupec_figurky() + 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 1) * 64);
                ctverec.setY((getRadek_figurky() + 2) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + 2)) + (getSloupec_figurky() + 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 1) * 64);
                    ctverec.setY((getRadek_figurky() + 2) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
    }
    public static void pohyb_bileho_strelce(Group vzhled_okna, ImageView strelec){
        // DOLU DOPRAVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64 && (getSloupec_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky() + i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + i) * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "strelec", strelec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + i)) + (getSloupec_figurky() + i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() + i) * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "strelec", strelec, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // DOLU DOLEVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64 && (getSloupec_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky() - i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - i) * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "strelec", strelec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + i)) + (getSloupec_figurky() - i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() - i) * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "strelec", strelec, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // NAHORU DOLEVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0 && (getSloupec_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky() - i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - i) * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "strelec", strelec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - i)) + (getSloupec_figurky() - i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() - i) * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "strelec", strelec, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // NAHORU DOPRAVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0 && (getSloupec_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky() + i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + i) * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "strelec", strelec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - i)) + (getSloupec_figurky() + i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() + i) * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "strelec", strelec, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
    }
    public static void pohyb_bileho_krale(Group vzhled_okna, ImageView kral){
        // Pohyb po ose Y - DOLU
        if ((getRadek_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 1][getSloupec_figurky()] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX(getSloupec_figurky() * 64);
                ctverec.setY((getRadek_figurky() + 1) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + 1)) + (getSloupec_figurky())) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky()) * 64);
                    ctverec.setY((getRadek_figurky() + 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // Pohyb po ose Y - NAHORU
        if ((getRadek_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 1][getSloupec_figurky()] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX(getSloupec_figurky() * 64);
                ctverec.setY((getRadek_figurky() - 1) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - 1)) + (getSloupec_figurky())) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky()) * 64);
                    ctverec.setY((getRadek_figurky() - 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // Pohyb po ose X - DOLEVA
        if ((getSloupec_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky() - 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 1) * 64);
                ctverec.setY(getRadek_figurky() * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky())) + (getSloupec_figurky() - 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 1) * 64);
                    ctverec.setY((getRadek_figurky()) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // Pohyb po ose X - DOPRAVA
        if ((getSloupec_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky() + 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 1) * 64);
                ctverec.setY(getRadek_figurky() * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky())) + (getSloupec_figurky() + 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 1) * 64);
                    ctverec.setY((getRadek_figurky()) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // DOLU DOPRAVA
        if ((getRadek_figurky() + 1) * 64 <= 7 * 64 && (getSloupec_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 1][getSloupec_figurky() + 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 1) * 64);
                ctverec.setY((getRadek_figurky() + 1) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + 1)) + (getSloupec_figurky() + 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 1) * 64);
                    ctverec.setY((getRadek_figurky() + 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // DOLU DOLEVA
        if ((getRadek_figurky() + 1) * 64 <= 7 * 64 && (getSloupec_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 1][getSloupec_figurky() - 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 1) * 64);
                ctverec.setY((getRadek_figurky() + 1) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + 1)) + (getSloupec_figurky() - 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 1) * 64);
                    ctverec.setY((getRadek_figurky() + 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // NAHORU DOLEVA
        if ((getRadek_figurky() - 1) * 64 >= 0 && (getSloupec_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 1][getSloupec_figurky() - 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 1) * 64);
                ctverec.setY((getRadek_figurky() - 1) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - 1)) + (getSloupec_figurky() - 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 1) * 64);
                    ctverec.setY((getRadek_figurky() - 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // NAHORU DOPRAVA
        if ((getRadek_figurky() - 1) * 64 >= 0 && (getSloupec_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 1][getSloupec_figurky() + 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 1) * 64);
                ctverec.setY((getRadek_figurky() - 1) * 64);



                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - 1)) + (getSloupec_figurky() + 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 1) * 64);
                    ctverec.setY((getRadek_figurky() - 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
    }
    public static void pohyb_bile_kralovny(Group vzhled_okna, ImageView kralovna){
        // Pohyb po ose Y - DOLU
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky()] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX(getSloupec_figurky() * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);

                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + i)) + getSloupec_figurky()) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX(getSloupec_figurky() * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // Pohyb po ose Y - NAHORU
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky()] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX(getSloupec_figurky() * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - i)) + getSloupec_figurky()) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX(getSloupec_figurky() * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // Pohyb po ose X - DOLEVA
        for (int i = 1; i <= 7; i++) {
            if ((getSloupec_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky() - i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - i) * 64);
                    ctverec.setY(getRadek_figurky() * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky())) + (getSloupec_figurky() - i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() - i) * 64);
                        ctverec.setY((getRadek_figurky()) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // Pohyb po ose X - DOPRAVA
        for (int i = 1; i <= 7; i++) {
            if ((getSloupec_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky() + i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + i) * 64);
                    ctverec.setY(getRadek_figurky() * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky())) + (getSloupec_figurky() + i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() + i) * 64);
                        ctverec.setY((getRadek_figurky()) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // DOLU DOPRAVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64 && (getSloupec_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky() + i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + i) * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + i)) + (getSloupec_figurky() + i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() + i) * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // DOLU DOLEVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64 && (getSloupec_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky() - i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - i) * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + i)) + (getSloupec_figurky() - i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() - i) * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // NAHORU DOLEVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0 && (getSloupec_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky() - i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - i) * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - i)) + (getSloupec_figurky() - i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() - i) * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // NAHORU DOPRAVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0 && (getSloupec_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky() + i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + i) * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() - i)) + (getSloupec_figurky() + i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() + i) * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
    }
    public static void pohyb_bileho_pesce(Group vzhled_okna, ImageView pesec){
        // Pohyb po ose Y - DOLU
        for (int i = 1; i <= 2; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky()] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX(getSloupec_figurky() * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_bily_hrac(ctverec, "pesec", pesec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
                else {
                    if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + i)) + getSloupec_figurky()) ) != null){
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX(getSloupec_figurky() * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "pesec", pesec, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        // Pohyb DOLU DOPRAVA když tam bude figurka protivníka
        if ((getRadek_figurky() + 1) * 64 <= 7 * 64 && (getSloupec_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 1][getSloupec_figurky() + 1] == 1) {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + 1)) + (getSloupec_figurky() + 1)) ) != null){
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 1) * 64);
                    ctverec.setY((getRadek_figurky() + 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "pesec", pesec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // Pohyb DOLU DOLEVA když tam bude figurka protivníka
        if ((getRadek_figurky() + 1) * 64 <= 7 * 64 && (getSloupec_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 1][getSloupec_figurky() - 1] == 1) {
                if (cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky() + 1)) + (getSloupec_figurky() - 1)) ) != null){
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 1) * 64);
                    ctverec.setY((getRadek_figurky() + 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_bily_hrac(ctverec, "pesec", pesec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
    }


    // Pohyb černých figurek
    public static void pohyb_cerne_veze(Group vzhled_okna, ImageView vez){
        // Pohyb po ose Y - DOLU
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky()] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX(getSloupec_figurky() * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "vez", vez, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + i)) + getSloupec_figurky()) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX(getSloupec_figurky() * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "vez", vez, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // Pohyb po ose Y - NAHORU
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky()] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX(getSloupec_figurky() * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "vez", vez, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - i)) + getSloupec_figurky()) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX(getSloupec_figurky() * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "vez", vez, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // Pohyb po ose X - DOLEVA
        for (int i = 1; i <= 7; i++) {
            if ((getSloupec_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky() - i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - i) * 64);
                    ctverec.setY(getRadek_figurky() * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "vez", vez, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky())) + (getSloupec_figurky() - i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() - i) * 64);
                        ctverec.setY((getRadek_figurky()) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "vez", vez, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // Pohyb po ose X - DOPRAVA
        for (int i = 1; i <= 7; i++) {
            if ((getSloupec_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky() + i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + i) * 64);
                    ctverec.setY(getRadek_figurky() * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "vez", vez, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky())) + (getSloupec_figurky() + i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() + i) * 64);
                        ctverec.setY((getRadek_figurky()) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "vez", vez, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
    }
    public static void pohyb_cerneho_kone(Group vzhled_okna, ImageView kun) {
        // 1
        if ((getRadek_figurky() - 2) * 64 >= 0 && (getSloupec_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 2][getSloupec_figurky() - 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 1) * 64);
                ctverec.setY((getRadek_figurky() - 2) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - 2)) + (getSloupec_figurky() - 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 1) * 64);
                    ctverec.setY((getRadek_figurky() - 2) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 2
        if ((getRadek_figurky() - 2) * 64 >= 0 && (getSloupec_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 2][getSloupec_figurky() + 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 1) * 64);
                ctverec.setY((getRadek_figurky() - 2) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - 2)) + (getSloupec_figurky() + 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 1) * 64);
                    ctverec.setY((getRadek_figurky() - 2) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 3
        if ((getRadek_figurky() - 1) * 64 >= 0 && (getSloupec_figurky() - 2) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 1][getSloupec_figurky() - 2] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 2) * 64);
                ctverec.setY((getRadek_figurky() - 1) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - 1)) + (getSloupec_figurky() - 2)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 2) * 64);
                    ctverec.setY((getRadek_figurky() - 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 4
        if ((getRadek_figurky() - 1) * 64 >= 0 && (getSloupec_figurky() + 2) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 1][getSloupec_figurky() + 2] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 2) * 64);
                ctverec.setY((getRadek_figurky() - 1) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - 1)) + (getSloupec_figurky() + 2)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 2) * 64);
                    ctverec.setY((getRadek_figurky() - 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 5
        if ((getRadek_figurky() + 1) * 64 <= 7 * 64 && (getSloupec_figurky() - 2) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 1][getSloupec_figurky() - 2] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 2) * 64);
                ctverec.setY((getRadek_figurky() + 1) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + 1)) + (getSloupec_figurky() - 2)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 2) * 64);
                    ctverec.setY((getRadek_figurky() + 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 6
        if ((getRadek_figurky() + 1) * 64 <= 7 * 64 && (getSloupec_figurky() + 2) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 1][getSloupec_figurky() + 2] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 2) * 64);
                ctverec.setY((getRadek_figurky() + 1) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + 1)) + (getSloupec_figurky() + 2)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 2) * 64);
                    ctverec.setY((getRadek_figurky() + 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 7
        if ((getRadek_figurky() + 2) * 64 <= 7 * 64 && (getSloupec_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 2][getSloupec_figurky() - 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 1) * 64);
                ctverec.setY((getRadek_figurky() + 2) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + 2)) + (getSloupec_figurky() - 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 1) * 64);
                    ctverec.setY((getRadek_figurky() + 2) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // 8
        if ((getRadek_figurky() + 2) * 64 <= 7 * 64 && (getSloupec_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 2][getSloupec_figurky() + 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 1) * 64);
                ctverec.setY((getRadek_figurky() + 2) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + 2)) + (getSloupec_figurky() + 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 1) * 64);
                    ctverec.setY((getRadek_figurky() + 2) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kun", kun, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
    }
    public static void pohyb_cerneho_strelce(Group vzhled_okna, ImageView strelec){
        // DOLU DOPRAVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64 && (getSloupec_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky() + i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + i) * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "strelec", strelec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + i)) + (getSloupec_figurky() + i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() + i) * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "strelec", strelec, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // DOLU DOLEVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64 && (getSloupec_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky() - i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - i) * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "strelec", strelec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + i)) + (getSloupec_figurky() - i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() - i) * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "strelec", strelec, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // NAHORU DOLEVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0 && (getSloupec_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky() - i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - i) * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "strelec", strelec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - i)) + (getSloupec_figurky() - i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() - i) * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "strelec", strelec, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // NAHORU DOPRAVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0 && (getSloupec_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky() + i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + i) * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "strelec", strelec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - i)) + (getSloupec_figurky() + i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() + i) * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "strelec", strelec, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
    }
    public static void pohyb_cerneho_krale(Group vzhled_okna, ImageView kral){
        // Pohyb po ose Y - DOLU
        if ((getRadek_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 1][getSloupec_figurky()] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX(getSloupec_figurky() * 64);
                ctverec.setY((getRadek_figurky() + 1) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + 1)) + (getSloupec_figurky())) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky()) * 64);
                    ctverec.setY((getRadek_figurky() + 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // Pohyb po ose Y - NAHORU
        if ((getRadek_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 1][getSloupec_figurky()] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX(getSloupec_figurky() * 64);
                ctverec.setY((getRadek_figurky() - 1) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - 1)) + (getSloupec_figurky())) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky()) * 64);
                    ctverec.setY((getRadek_figurky() - 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // Pohyb po ose X - DOLEVA
        if ((getSloupec_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky() - 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 1) * 64);
                ctverec.setY(getRadek_figurky() * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky())) + (getSloupec_figurky() - 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 1) * 64);
                    ctverec.setY((getRadek_figurky()) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // Pohyb po ose X - DOPRAVA
        if ((getSloupec_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky() + 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 1) * 64);
                ctverec.setY(getRadek_figurky() * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky())) + (getSloupec_figurky() + 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 1) * 64);
                    ctverec.setY((getRadek_figurky()) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // DOLU DOPRAVA
        if ((getRadek_figurky() + 1) * 64 <= 7 * 64 && (getSloupec_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 1][getSloupec_figurky() + 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 1) * 64);
                ctverec.setY((getRadek_figurky() + 1) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + 1)) + (getSloupec_figurky() + 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 1) * 64);
                    ctverec.setY((getRadek_figurky() + 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // DOLU DOLEVA
        if ((getRadek_figurky() + 1) * 64 <= 7 * 64 && (getSloupec_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() + 1][getSloupec_figurky() - 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 1) * 64);
                ctverec.setY((getRadek_figurky() + 1) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + 1)) + (getSloupec_figurky() - 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 1) * 64);
                    ctverec.setY((getRadek_figurky() + 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // NAHORU DOLEVA
        if ((getRadek_figurky() - 1) * 64 >= 0 && (getSloupec_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 1][getSloupec_figurky() - 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() - 1) * 64);
                ctverec.setY((getRadek_figurky() - 1) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - 1)) + (getSloupec_figurky() - 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 1) * 64);
                    ctverec.setY((getRadek_figurky() - 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // NAHORU DOPRAVA
        if ((getRadek_figurky() - 1) * 64 >= 0 && (getSloupec_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 1][getSloupec_figurky() + 1] != 1) {
                Rectangle ctverec = new Rectangle();
                nastaveni_parametru_pomocneho_ctverce(ctverec);
                ctverec.setX((getSloupec_figurky() + 1) * 64);
                ctverec.setY((getRadek_figurky() - 1) * 64);


                ctverec.setOnMouseClicked(mouseEvent -> {
                    kliknuti_na_ctverec_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                });

                vzhled_okna.getChildren().add(ctverec);
                pomocny_ctverce.add(ctverec);
            }
            else {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - 1)) + (getSloupec_figurky() + 1)) ) != null) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 1) * 64);
                    ctverec.setY((getRadek_figurky() - 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac_pro_krale(ctverec, kral, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
    }
    public static void pohyb_cerne_kralovny(Group vzhled_okna, ImageView kralovna){
        // Pohyb po ose Y - DOLU
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky()] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX(getSloupec_figurky() * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + i)) + getSloupec_figurky()) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX(getSloupec_figurky() * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // Pohyb po ose Y - NAHORU
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky()] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX(getSloupec_figurky() * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - i)) + getSloupec_figurky()) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX(getSloupec_figurky() * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // Pohyb po ose X - DOLEVA
        for (int i = 1; i <= 7; i++) {
            if ((getSloupec_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky() - i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - i) * 64);
                    ctverec.setY(getRadek_figurky() * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky())) + (getSloupec_figurky() - i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() - i) * 64);
                        ctverec.setY((getRadek_figurky()) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // Pohyb po ose X - DOPRAVA
        for (int i = 1; i <= 7; i++) {
            if ((getSloupec_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky()][getSloupec_figurky() + i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + i) * 64);
                    ctverec.setY(getRadek_figurky() * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky())) + (getSloupec_figurky() + i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() + i) * 64);
                        ctverec.setY((getRadek_figurky()) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // NAHORU DOPRAVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64 && (getSloupec_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky() + i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + i) * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + i)) + (getSloupec_figurky() + i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() + i) * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // NAHORU DOLEVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() + i) * 64 <= 7 * 64 && (getSloupec_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() + i][getSloupec_figurky() - i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - i) * 64);
                    ctverec.setY((getRadek_figurky() + i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() + i)) + (getSloupec_figurky() - i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() - i) * 64);
                        ctverec.setY((getRadek_figurky() + i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // DOLU DOLEVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0 && (getSloupec_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky() - i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - i) * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - i)) + (getSloupec_figurky() - i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() - i) * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        // DOLU DOPRAVA
        for (int i = 1; i <= 7; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0 && (getSloupec_figurky() + i) * 64 <= 7 * 64) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky() + i] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + i) * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                } else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - i)) + (getSloupec_figurky() + i)) ) != null) {
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX((getSloupec_figurky() + i) * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "kralovna", kralovna, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
    }
    public static void pohyb_cerneho_pesce(Group vzhled_okna, ImageView pesec){
        // Pohyb po ose Y - NAHORU
        for (int i = 1; i <= 2; i++) {
            if ((getRadek_figurky() - i) * 64 >= 0) {
                if (ctvercove_pole_pro_figurky[getRadek_figurky() - i][getSloupec_figurky()] != 1) {
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX(getSloupec_figurky() * 64);
                    ctverec.setY((getRadek_figurky() - i) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_cerny_hrac(ctverec, "pesec", pesec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
                else {
                    if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - i)) + getSloupec_figurky()) ) != null){
                        Rectangle ctverec = new Rectangle();
                        nastaveni_parametru_pomocneho_ctverce(ctverec);
                        ctverec.setX(getSloupec_figurky() * 64);
                        ctverec.setY((getRadek_figurky() - i) * 64);

                        ctverec.setOnMouseClicked(mouseEvent -> {
                            kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "pesec", pesec, vzhled_okna);
                        });

                        vzhled_okna.getChildren().add(ctverec);
                        pomocny_ctverce.add(ctverec);
                        break;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        // Pohyb NAHORU DOPRAVA když tam bude figurka protivníka
        if ((getRadek_figurky() - 1) * 64 >= 0 && (getSloupec_figurky() + 1) * 64 <= 7 * 64) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 1][getSloupec_figurky() + 1] == 1) {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - 1)) + (getSloupec_figurky() + 1)) ) != null){
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() + 1) * 64);
                    ctverec.setY((getRadek_figurky() - 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "pesec", pesec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
        // Pohyb NAHORU DOLEVA když tam bude figurka protivníka
        if ((getRadek_figurky() - 1) * 64 >= 0 && (getSloupec_figurky() - 1) * 64 >= 0) {
            if (ctvercove_pole_pro_figurky[getRadek_figurky() - 1][getSloupec_figurky() - 1] == 1) {
                if (cislo_a_figurka.get("bila" + (Integer.toString((getRadek_figurky() - 1)) + (getSloupec_figurky() - 1)) ) != null){
                    Rectangle ctverec = new Rectangle();
                    nastaveni_parametru_pomocneho_ctverce(ctverec);
                    ctverec.setX((getSloupec_figurky() - 1) * 64);
                    ctverec.setY((getRadek_figurky() - 1) * 64);

                    ctverec.setOnMouseClicked(mouseEvent -> {
                        kliknuti_na_ctverec_s_figurkou_cerny_hrac(ctverec, "pesec", pesec, vzhled_okna);
                    });

                    vzhled_okna.getChildren().add(ctverec);
                    pomocny_ctverce.add(ctverec);
                }
            }
        }
    }

}
