import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class BilyHracAI{

    Random random = new Random();

    public static int nahodna_pozice = 0;
    public static int nahodna_pozice_pesce = 0;
    public static int radek_figurky_protivnika = 0;
    public static int sloupec_figurky_protivnika = 0;

    // Radek a sloupec figurky protivnika
    public static int getRadek_figurky_protivnika() {
        return radek_figurky_protivnika;
    }
    public static void setRadek_figurky_protivnika(int radek_figurky_protivnika) {
        BilyHracAI.radek_figurky_protivnika = radek_figurky_protivnika;
    }
    public static int getSloupec_figurky_protivnika() {
        return sloupec_figurky_protivnika;
    }
    public static void setSloupec_figurky_protivnika(int sloupec_figurky_protivnika) {
        BilyHracAI.sloupec_figurky_protivnika = sloupec_figurky_protivnika;
    }


    // Vyber figurky za kterou AI bude hrat
    public void pohyb_AI_figurek(Group vzhled_okna) {
        if (PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_AI && !PohybyFigurky.hraje_hrac) {
            nahodna_pozice = random.nextInt(7)+1;
            switch (random.nextInt(9)) {
                case 0:
                    if (BilyHrac.bila_vez1_na_sachovnici) {
                        AI_pohyb_veze(vzhled_okna, BilyHrac.bila_vez1);
                        break;
                    }
                case 1:
                    if (BilyHrac.bily_kun1_na_sachovnici) {
                        AI_pohyb_kone(vzhled_okna, BilyHrac.bily_kun1);
                        break;
                    }
                case 2:
                    if (BilyHrac.bily_strelec1_na_sachovnici) {
                        AI_pohyb_strelce(vzhled_okna, BilyHrac.bily_strelec1);
                        break;
                    }
                case 3:
                    if (BilyHrac.bily_kral_na_sachovnici) {
                        AI_pohyb_krale(vzhled_okna, BilyHrac.bily_kral);
                        break;
                    }
                case 4:
                    if (BilyHrac.bila_kralovna_na_sachovnici) {
                        AI_pohyb_kralovny(vzhled_okna, BilyHrac.bila_kralovna);
                        break;
                    }
                case 5:
                    if (BilyHrac.bily_strelec2_na_sachovnici) {
                        AI_pohyb_strelce(vzhled_okna, BilyHrac.bily_strelec2);
                        break;
                    }
                case 6:
                    if (BilyHrac.bily_kun2_na_sachovnici) {
                        AI_pohyb_kone(vzhled_okna, BilyHrac.bily_kun2);
                        break;
                    }
                case 7:
                    if (BilyHrac.bila_vez2_na_sachovnici) {
                        AI_pohyb_veze(vzhled_okna, BilyHrac.bila_vez2);
                        break;
                    }
                case 8:
                    switch (random.nextInt(8)){
                        case 0:
                            if (BilyHrac.bily_pesak1_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, BilyHrac.bily_pesak1);
                                break;
                            }
                        case 1:
                            if (BilyHrac.bily_pesak2_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, BilyHrac.bily_pesak2);
                                break;
                            }
                        case 2:
                            if (BilyHrac.bily_pesak3_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, BilyHrac.bily_pesak3);
                                break;
                            }
                        case 3:
                            if (BilyHrac.bily_pesak4_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, BilyHrac.bily_pesak4);
                                break;
                            }
                        case 4:
                            if (BilyHrac.bily_pesak5_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, BilyHrac.bily_pesak5);
                                break;
                            }
                        case 5:
                            if (BilyHrac.bily_pesak6_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, BilyHrac.bily_pesak6);
                                break;
                            }
                        case 6:
                            if (BilyHrac.bily_pesak7_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, BilyHrac.bily_pesak7);
                                break;
                            }
                        case 7:
                            if (BilyHrac.bily_pesak8_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, BilyHrac.bily_pesak8);
                                break;
                            }
                    }
            }
        }
    }


    // Presunuti figurky na ctverec
    public static void presunuti_na_ctverec(Rectangle ctverec, String nazev_figurky, ImageView figurka, Group vzhled_okna){
        PohybyFigurky.je_sach_mat(vzhled_okna);
        if (PohybyFigurky.hraje_AI && !PohybyFigurky.hraje_hrac) {
            figurka.setX(ctverec.getX());
            figurka.setY(ctverec.getY());

            PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika()][getSloupec_figurky_protivnika()] = 0;
            PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64)][(int) (figurka.getX() / 64)] = 1;

            PohybyFigurky.cislo_a_figurka.remove("bila" + (Integer.toString(getRadek_figurky_protivnika()) + getSloupec_figurky_protivnika()));
            PohybyFigurky.cislo_a_figurka.put("bila" + (Integer.toString((int) (figurka.getY() / 64)) + (int) (figurka.getX() / 64)), figurka);

            PohybyFigurky.pridani_zaznamu_o_pohybu_figurky_do_chatu_bily_hrac(nazev_figurky, (int) (figurka.getY() / 64) + 1, (int) (figurka.getX() / 64) + 1, vzhled_okna);

            PohybyFigurky.figurka_zakliknuta = false;
            PohybyFigurky.je_bily_hrac_na_rade = false;
            PohybyFigurky.je_cerny_hrac_na_rade = true;
            PohybyFigurky.hraje_AI = false;
            PohybyFigurky.hraje_hrac = true;
        }
        PohybyFigurky.je_sach_mat(vzhled_okna);
    }
    public static void presunuti_na_ctverec_s_figurkou(Rectangle ctverec, String nazev_figurky, ImageView figurka, Group vzhled_okna){
        PohybyFigurky.je_sach_mat(vzhled_okna);
        if (PohybyFigurky.hraje_AI && !PohybyFigurky.hraje_hrac) {
            PohybyFigurky.odstraneni_figurek_ze_sachovnice_bily_hrac(vzhled_okna, ctverec);
            figurka.setX(ctverec.getX());
            figurka.setY(ctverec.getY());

            PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika()][getSloupec_figurky_protivnika()] = 0;
            PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64)][(int) (figurka.getX() / 64)] = 1;

            PohybyFigurky.cislo_a_figurka.remove("bila" + (Integer.toString(getRadek_figurky_protivnika()) + getSloupec_figurky_protivnika()));
            PohybyFigurky.cislo_a_figurka.put("bila" + (Integer.toString((int) (figurka.getY() / 64)) + (int) (figurka.getX() / 64)), figurka);

            PohybyFigurky.pridani_zaznamu_o_pohybu_figurky_do_chatu_bily_hrac(nazev_figurky, (int) (figurka.getY() / 64) + 1, (int) (figurka.getX() / 64) + 1, vzhled_okna);

            PohybyFigurky.figurka_zakliknuta = false;
            PohybyFigurky.je_bily_hrac_na_rade = false;
            PohybyFigurky.je_cerny_hrac_na_rade = true;
            PohybyFigurky.hraje_AI = false;
            PohybyFigurky.hraje_hrac = true;
        }
        PohybyFigurky.je_sach_mat(vzhled_okna);
    }
    public static void presunuti_na_ctverec_pro_krale(Rectangle ctverec, ImageView figurka, Group vzhled_okna){
        PohybyFigurky.je_sach_mat(vzhled_okna);
        if (PohybyFigurky.hraje_AI && !PohybyFigurky.hraje_hrac) {
            figurka.setX(ctverec.getX());
            figurka.setY(ctverec.getY());

            PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika()][getSloupec_figurky_protivnika()] = 0;
            PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64)][(int) (figurka.getX() / 64)] = 1;

            PohybyFigurky.pridani_zaznamu_o_pohybu_figurky_do_chatu_bily_hrac("kral", (int) (figurka.getY() / 64) + 1, (int) (figurka.getX() / 64) + 1, vzhled_okna);

            PohybyFigurky.figurka_zakliknuta = false;
            PohybyFigurky.je_bily_hrac_na_rade = false;
            PohybyFigurky.je_cerny_hrac_na_rade = true;
            PohybyFigurky.hraje_AI = false;
            PohybyFigurky.hraje_hrac = true;
        }
        PohybyFigurky.je_sach_mat(vzhled_okna);
    }
    public static void presunuti_na_ctverec_s_figurkou_pro_krale(Rectangle ctverec, ImageView figurka, Group vzhled_okna){
        PohybyFigurky.je_sach_mat(vzhled_okna);
        if (PohybyFigurky.hraje_AI && !PohybyFigurky.hraje_hrac) {
            PohybyFigurky.odstraneni_figurek_ze_sachovnice_bily_hrac(vzhled_okna, ctverec);
            figurka.setX(ctverec.getX());
            figurka.setY(ctverec.getY());

            PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika()][getSloupec_figurky_protivnika()] = 0;
            PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64)][(int) (figurka.getX() / 64)] = 1;

            PohybyFigurky.pridani_zaznamu_o_pohybu_figurky_do_chatu_bily_hrac("kral", (int) (figurka.getY() / 64) + 1, (int) (figurka.getX() / 64) + 1, vzhled_okna);

            PohybyFigurky.figurka_zakliknuta = false;
            PohybyFigurky.je_bily_hrac_na_rade = false;
            PohybyFigurky.je_cerny_hrac_na_rade = true;
            PohybyFigurky.hraje_AI = false;
            PohybyFigurky.hraje_hrac = true;
        }
        PohybyFigurky.je_sach_mat(vzhled_okna);
    }


    // Pohyby figurek po sachovnici
    private void AI_pohyb_veze(Group vzhled_okna, ImageView figurka){
        setRadek_figurky_protivnika((int) (figurka.getY() / 64));
        setSloupec_figurky_protivnika((int) (figurka.getX() / 64));
        switch (random.nextInt(4)) {
            case 0:
                // Pohyb po ose Y - DOLU
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getRadek_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + i][getSloupec_figurky_protivnika()] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                                presunuti_na_ctverec(ctverec, "vez", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + i)) + getSloupec_figurky_protivnika())) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "vez", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 1:
                // Pohyb po ose Y - NAHORU
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getRadek_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - i][getSloupec_figurky_protivnika()] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((getRadek_figurky_protivnika() - i) * 64);
                                presunuti_na_ctverec(ctverec, "vez", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - i)) + getSloupec_figurky_protivnika())) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((getRadek_figurky_protivnika() - i) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "vez", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 2:
                // Pohyb po ose X - DOLEVA
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getSloupec_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika()][getSloupec_figurky_protivnika() - i] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY(getRadek_figurky_protivnika() * 64);
                                presunuti_na_ctverec(ctverec, "vez", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika())) + (getSloupec_figurky_protivnika() - i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika()) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "vez", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 3:
                // Pohyb po ose X - DOPRAVA
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getSloupec_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika()][getSloupec_figurky_protivnika() + i] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY(getRadek_figurky_protivnika() * 64);
                                presunuti_na_ctverec(ctverec, "vez", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika())) + (getSloupec_figurky_protivnika() + i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika()) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "vez", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
        }
    }
    private void AI_pohyb_kone(Group vzhled_okna, ImageView figurka){
        setRadek_figurky_protivnika((int) (figurka.getY() / 64));
        setSloupec_figurky_protivnika((int) (figurka.getX() / 64));
        switch (random.nextInt(8)){
            case 0:
                // 1
                if ((getRadek_figurky_protivnika() - 2) * 64 >= 0 && (getSloupec_figurky_protivnika() - 1) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - 2][getSloupec_figurky_protivnika() - 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() - 1) * 64);
                        ctverec.setY((getRadek_figurky_protivnika() - 2) * 64);
                        presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - 2)) + (getSloupec_figurky_protivnika() - 1)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() - 1) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() - 2) * 64);
                            presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 1:
                // 2
                if ((getRadek_figurky_protivnika() - 2) * 64 >= 0 && (getSloupec_figurky_protivnika() + 1) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - 2][getSloupec_figurky_protivnika() + 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() + 1) * 64);
                        ctverec.setY((getRadek_figurky_protivnika() - 2) * 64);
                        presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - 2)) + (getSloupec_figurky_protivnika() + 1)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() + 1) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() - 2) * 64);
                            presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 2:
                // 3
                if ((getRadek_figurky_protivnika() - 1) * 64 >= 0 && (getSloupec_figurky_protivnika() - 2) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - 1][getSloupec_figurky_protivnika() - 2] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() - 2) * 64);
                        ctverec.setY((getRadek_figurky_protivnika() - 1) * 64);
                        presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - 1)) + (getSloupec_figurky_protivnika() - 2)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() - 2) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() - 1) * 64);
                            presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 3:
                // 4
                if ((getRadek_figurky_protivnika() - 1) * 64 >= 0 && (getSloupec_figurky_protivnika() + 2) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - 1][getSloupec_figurky_protivnika() + 2] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() + 2) * 64);
                        ctverec.setY((getRadek_figurky_protivnika() - 1) * 64);
                        presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - 1)) + (getSloupec_figurky_protivnika() + 2)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() + 2) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() - 1) * 64);
                            presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 4:
                // 5
                if ((getRadek_figurky_protivnika() + 1) * 64 <= 7 * 64 && (getSloupec_figurky_protivnika() - 2) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + 1][getSloupec_figurky_protivnika() - 2] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() - 2) * 64);
                        ctverec.setY((getRadek_figurky_protivnika() + 1) * 64);
                        presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + 1)) + (getSloupec_figurky_protivnika() - 2)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() - 2) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() + 1) * 64);
                            presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 5:
                // 6
                if ((getRadek_figurky_protivnika() + 1) * 64 <= 7 * 64 && (getSloupec_figurky_protivnika() + 2) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + 1][getSloupec_figurky_protivnika() + 2] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() + 2) * 64);
                        ctverec.setY((getRadek_figurky_protivnika() + 1) * 64);
                        presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + 1)) + (getSloupec_figurky_protivnika() + 2)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() + 2) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() + 1) * 64);
                            presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 6:
                // 7
                if ((getRadek_figurky_protivnika() + 2) * 64 <= 7 * 64 && (getSloupec_figurky_protivnika() - 1) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + 2][getSloupec_figurky_protivnika() - 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() - 1) * 64);
                        ctverec.setY((getRadek_figurky_protivnika() + 2) * 64);
                        presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + 2)) + (getSloupec_figurky_protivnika() - 1)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() - 1) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() + 2) * 64);
                            presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 7:
                // 8
                if ((getRadek_figurky_protivnika() + 2) * 64 <= 7 * 64 && (getSloupec_figurky_protivnika() + 1) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + 2][getSloupec_figurky_protivnika() + 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() + 1) * 64);
                        ctverec.setY((getRadek_figurky_protivnika() + 2) * 64);
                        presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + 2)) + (getSloupec_figurky_protivnika() + 1)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() + 1) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() + 2) * 64);
                            presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
        }
    }
    private void AI_pohyb_strelce(Group vzhled_okna, ImageView figurka) {
        setRadek_figurky_protivnika((int) (figurka.getY() / 64));
        setSloupec_figurky_protivnika((int) (figurka.getX() / 64));
        switch (random.nextInt(4)) {
            case 0:
                // DOLU DOPRAVA
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getRadek_figurky_protivnika() + i) * 64 <= 7 * 64 && (getSloupec_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + i][getSloupec_figurky_protivnika() + i] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                                presunuti_na_ctverec(ctverec, "strelec", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + i)) + (getSloupec_figurky_protivnika() + i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "strelec", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 1:
                // DOLU DOLEVA
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getRadek_figurky_protivnika() + i) * 64 <= 7 * 64 && (getSloupec_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + i][getSloupec_figurky_protivnika() - i] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                                presunuti_na_ctverec(ctverec, "strelec", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + i)) + (getSloupec_figurky_protivnika() - i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "strelec", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 2:
                // NAHORU DOLEVA
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getRadek_figurky_protivnika() - i) * 64 >= 0 && (getSloupec_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - i][getSloupec_figurky_protivnika() - i] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() - i) * 64);
                                presunuti_na_ctverec(ctverec, "strelec", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - i)) + (getSloupec_figurky_protivnika() - i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() - i) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "strelec", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 3:
                // NAHORU DOPRAVA
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getRadek_figurky_protivnika() - i) * 64 >= 0 && (getSloupec_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - i][getSloupec_figurky_protivnika() + i] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() - i) * 64);
                                presunuti_na_ctverec(ctverec, "strelec", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - i)) + (getSloupec_figurky_protivnika() + i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() - i) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "strelec", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
        }
    }
    private void AI_pohyb_krale(Group vzhled_okna, ImageView figurka){
        setRadek_figurky_protivnika((int) (figurka.getY() / 64));
        setSloupec_figurky_protivnika((int) (figurka.getX() / 64));
        switch (random.nextInt(8)) {
            case 0:
                // Pohyb po ose Y - DOLU
                if ((getRadek_figurky_protivnika() + 1) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + 1][getSloupec_figurky_protivnika()] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX(getSloupec_figurky_protivnika() * 64);
                        ctverec.setY((getRadek_figurky_protivnika() + 1) * 64);
                        presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + 1)) + (getSloupec_figurky_protivnika()))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika()) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() + 1) * 64);
                            presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 1:
                // Pohyb po ose Y - NAHORU
                if ((getRadek_figurky_protivnika() - 1) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - 1][getSloupec_figurky_protivnika()] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX(getSloupec_figurky_protivnika() * 64);
                        ctverec.setY((getRadek_figurky_protivnika() - 1) * 64);
                        presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - 1)) + (getSloupec_figurky_protivnika()))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika()) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() - 1) * 64);
                            presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 2:
                // Pohyb po ose X - DOLEVA
                if ((getSloupec_figurky_protivnika() - 1) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika()][getSloupec_figurky_protivnika() - 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() - 1) * 64);
                        ctverec.setY(getRadek_figurky_protivnika() * 64);
                        presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika())) + (getSloupec_figurky_protivnika() - 1))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() - 1) * 64);
                            ctverec.setY((getRadek_figurky_protivnika()) * 64);
                            presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 3:
                // Pohyb po ose X - DOPRAVA
                if ((getSloupec_figurky_protivnika() + 1) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika()][getSloupec_figurky_protivnika() + 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() + 1) * 64);
                        ctverec.setY(getRadek_figurky_protivnika() * 64);
                        presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika())) + (getSloupec_figurky_protivnika() + 1))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() + 1) * 64);
                            ctverec.setY((getRadek_figurky_protivnika()) * 64);
                            presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 4:
                // DOLU DOPRAVA
                if ((getRadek_figurky_protivnika() + 1) * 64 <= 7 * 64 && (getSloupec_figurky_protivnika() + 1) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + 1][getSloupec_figurky_protivnika() + 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() + 1) * 64);
                        ctverec.setY((getRadek_figurky_protivnika() + 1) * 64);
                        presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + 1)) + (getSloupec_figurky_protivnika() + 1))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() + 1) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() + 1) * 64);
                            presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 5:
                // DOLU DOLEVA
                if ((getRadek_figurky_protivnika() + 1) * 64 <= 7 * 64 && (getSloupec_figurky_protivnika() - 1) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + 1][getSloupec_figurky_protivnika() - 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() - 1) * 64);
                        ctverec.setY((getRadek_figurky_protivnika() + 1) * 64);
                        presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + 1)) + (getSloupec_figurky_protivnika() - 1))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() - 1) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() + 1) * 64);
                            presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 6:
                // NAHORU DOLEVA
                if ((getRadek_figurky_protivnika() - 1) * 64 >= 0 && (getSloupec_figurky_protivnika() - 1) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - 1][getSloupec_figurky_protivnika() - 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() - 1) * 64);
                        ctverec.setY((getRadek_figurky_protivnika() - 1) * 64);
                        presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - 1)) + (getSloupec_figurky_protivnika() - 1))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() - 1) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() - 1) * 64);
                            presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 7:
                // NAHORU DOPRAVA
                if ((getRadek_figurky_protivnika() - 1) * 64 >= 0 && (getSloupec_figurky_protivnika() + 1) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - 1][getSloupec_figurky_protivnika() + 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((getSloupec_figurky_protivnika() + 1) * 64);
                        ctverec.setY((getRadek_figurky_protivnika() - 1) * 64);
                        presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - 1)) + (getSloupec_figurky_protivnika() + 1))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((getSloupec_figurky_protivnika() + 1) * 64);
                            ctverec.setY((getRadek_figurky_protivnika() - 1) * 64);
                            presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
        }
    }
    private void AI_pohyb_kralovny(Group vzhled_okna, ImageView figurka){
        setRadek_figurky_protivnika((int) (figurka.getY() / 64));
        setSloupec_figurky_protivnika((int) (figurka.getX() / 64));
        switch (random.nextInt(8)){
            case 0:
                // Pohyb po ose Y - DOLU
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getRadek_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + i][getSloupec_figurky_protivnika()] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                                presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + i)) + getSloupec_figurky_protivnika())) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 1:
                // Pohyb po ose Y - NAHORU
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getRadek_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - i][getSloupec_figurky_protivnika()] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((getRadek_figurky_protivnika() - i) * 64);
                                presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - i)) + getSloupec_figurky_protivnika())) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((getRadek_figurky_protivnika() - i) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 2:
                // Pohyb po ose X - DOLEVA
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getSloupec_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika()][getSloupec_figurky_protivnika() - i] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY(getRadek_figurky_protivnika() * 64);
                                presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika())) + (getSloupec_figurky_protivnika() - i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika()) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 3:
                // Pohyb po ose X - DOPRAVA
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getSloupec_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika()][getSloupec_figurky_protivnika() + i] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY(getRadek_figurky_protivnika() * 64);
                                presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika())) + (getSloupec_figurky_protivnika() + i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika()) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 4:
                // DOLU DOPRAVA
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getRadek_figurky_protivnika() + i) * 64 <= 7 * 64 && (getSloupec_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + i][getSloupec_figurky_protivnika() + i] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                                presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + i)) + (getSloupec_figurky_protivnika() + i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 5:
                // DOLU DOLEVA
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getRadek_figurky_protivnika() + i) * 64 <= 7 * 64 && (getSloupec_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + i][getSloupec_figurky_protivnika() - i] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                                presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + i)) + (getSloupec_figurky_protivnika() - i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 6:
                // NAHORU DOLEVA
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getRadek_figurky_protivnika() - i) * 64 >= 0 && (getSloupec_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - i][getSloupec_figurky_protivnika() - i] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() - i) * 64);
                                presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - i)) + (getSloupec_figurky_protivnika() - i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() - i) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case 7:
                // NAHORU DOPRAVA
                for (int i = 1; i <= nahodna_pozice; i++) {
                    if ((getRadek_figurky_protivnika() - i) * 64 >= 0 && (getSloupec_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() - i][getSloupec_figurky_protivnika() + i] != 1) {
                            if (i == nahodna_pozice) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() - i) * 64);
                                presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() - i)) + (getSloupec_figurky_protivnika() + i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((getRadek_figurky_protivnika() - i) * 64);
                                presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
        }
    }
    private void AI_pohyb_pescu(Group vzhled_okna, ImageView figurka){
        setRadek_figurky_protivnika((int) (figurka.getY() / 64));
        setSloupec_figurky_protivnika((int) (figurka.getX() / 64));
        // Pohyb po ose Y - DOLU
        for (int i = 1; i <= 2; i++) {
            if ((getRadek_figurky_protivnika() + i) * 64 <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + i][getSloupec_figurky_protivnika()] != 1) {
                    if (i == nahodna_pozice) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX(getSloupec_figurky_protivnika() * 64);
                        ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                        presunuti_na_ctverec(ctverec, "pesec", figurka, vzhled_okna);
                    }
                }
                else {
                    if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + i)) + getSloupec_figurky_protivnika()) ) != null){
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX(getSloupec_figurky_protivnika() * 64);
                        ctverec.setY((getRadek_figurky_protivnika() + i) * 64);
                        presunuti_na_ctverec_s_figurkou(ctverec, "pesec", figurka, vzhled_okna);
                        break;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        // Pohyb DOLU DOPRAVA když tam bude figurka protivníka
        if ((getRadek_figurky_protivnika() + 1) * 64 <= 7 * 64 && (getSloupec_figurky_protivnika() + 1) * 64 <= 7 * 64) {
            if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + 1][getSloupec_figurky_protivnika() + 1] == 1) {
                if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + 1)) + (getSloupec_figurky_protivnika() + 1)) ) != null){
                    Rectangle ctverec = new Rectangle();
                    ctverec.setX((getSloupec_figurky_protivnika() + 1) * 64);
                    ctverec.setY((getRadek_figurky_protivnika() + 1) * 64);
                    presunuti_na_ctverec_s_figurkou(ctverec, "pesec", figurka, vzhled_okna);
                }
            }
        }
        // Pohyb DOLU DOLEVA když tam bude figurka protivníka
        if ((getRadek_figurky_protivnika() + 1) * 64 <= 7 * 64 && (getSloupec_figurky_protivnika() - 1) * 64 >= 0) {
            if (PohybyFigurky.ctvercove_pole_pro_figurky[getRadek_figurky_protivnika() + 1][getSloupec_figurky_protivnika() - 1] == 1) {
                if (PohybyFigurky.cislo_a_figurka.get("cerna" + (Integer.toString((getRadek_figurky_protivnika() + 1)) + (getSloupec_figurky_protivnika() - 1)) ) != null){
                    Rectangle ctverec = new Rectangle();
                    ctverec.setX((getSloupec_figurky_protivnika() - 1) * 64);
                    ctverec.setY((getRadek_figurky_protivnika() + 1) * 64);
                    presunuti_na_ctverec_s_figurkou(ctverec, "pesec", figurka, vzhled_okna);
                }
            }
        }
    }
}
