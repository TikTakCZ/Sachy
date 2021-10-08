import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class CernyHracAIObtiznost2 {
    
    Random random = new Random();

    // Vyber figurky za kterou bude AI hrat
    public void pohyb_AI_figurek(Group vzhled_okna) {
        if (PohybyFigurky.je_cerny_hrac_na_rade && !PohybyFigurky.je_bily_hrac_na_rade && PohybyFigurky.hraje_AI && !PohybyFigurky.hraje_hrac) {
            CernyHracAI.nahodna_pozice = random.nextInt(7)+1;
            CernyHracAI.nahodna_pozice_pesce = random.nextInt(2)+1;
            switch (random.nextInt(9)) {
                case 0:
                    if (CernyHrac.cerna_vez1_na_sachovnici) {
                        AI_pohyb_veze(vzhled_okna, CernyHrac.cerna_vez1);
                        break;
                    }
                case 1:
                    if (CernyHrac.cerny_kun1_na_sachovnici) {
                        AI_pohyb_kone(vzhled_okna, CernyHrac.cerny_kun1);
                        break;
                    }
                case 2:
                    if (CernyHrac.cerny_strelec1_na_sachovnici) {
                        AI_pohyb_strelce(vzhled_okna, CernyHrac.cerny_strelec1);
                        break;
                    }
                case 3:
                    if (CernyHrac.cerny_kral_na_sachovnici) {
                        AI_pohyb_krale(vzhled_okna, CernyHrac.cerny_kral);
                        break;
                    }
                case 4:
                    if (CernyHrac.cerna_kralovna_na_sachovnici) {
                        AI_pohyb_kralovny(vzhled_okna, CernyHrac.cerna_kralovna);
                        break;
                    }
                case 5:
                    if (CernyHrac.cerny_strelec2_na_sachovnici) {
                        AI_pohyb_strelce(vzhled_okna, CernyHrac.cerny_strelec2);
                        break;
                    }
                case 6:
                    if (CernyHrac.cerny_kun2_na_sachovnici) {
                        AI_pohyb_kone(vzhled_okna, CernyHrac.cerny_kun2);
                        break;
                    }
                case 7:
                    if (CernyHrac.cerna_vez2_na_sachovnici) {
                        AI_pohyb_veze(vzhled_okna, CernyHrac.cerna_vez2);
                        break;
                    }
                case 8:
                    switch (random.nextInt(8)){
                        case 0:
                            if (CernyHrac.cerny_pesak1_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, CernyHrac.cerny_pesak1);
                                break;
                            }
                        case 1:
                            if (CernyHrac.cerny_pesak2_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, CernyHrac.cerny_pesak2);
                                break;
                            }
                        case 2:
                            if (CernyHrac.cerny_pesak3_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, CernyHrac.cerny_pesak3);
                                break;
                            }
                        case 3:
                            if (CernyHrac.cerny_pesak4_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, CernyHrac.cerny_pesak4);
                                break;
                            }
                        case 4:
                            if (CernyHrac.cerny_pesak5_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, CernyHrac.cerny_pesak5);
                                break;
                            }
                        case 5:
                            if (CernyHrac.cerny_pesak6_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, CernyHrac.cerny_pesak6);
                                break;
                            }
                        case 6:
                            if (CernyHrac.cerny_pesak7_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, CernyHrac.cerny_pesak7);
                                break;
                            }
                        case 7:
                            if (CernyHrac.cerny_pesak8_na_sachovnici) {
                                AI_pohyb_pescu(vzhled_okna, CernyHrac.cerny_pesak8);
                                break;
                            }
                    }
                    break;
            }
        }
    }


    // Pohyby figurek po sachovnici
    private void AI_pohyb_veze(Group vzhled_okna, ImageView figurka){
        CernyHracAI.setRadek_figurky_protivnika((int) (figurka.getY() / 64));
        CernyHracAI.setSloupec_figurky_protivnika((int) (figurka.getX() / 64));
        switch (random.nextInt(4)) {
            case 0:
                // Pohyb po ose Y - DOLU
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getRadek_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + i][CernyHracAI.getSloupec_figurky_protivnika()] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(CernyHracAI.getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + CernyHracAI.nahodna_pozice) * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "vez", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + i)) + CernyHracAI.getSloupec_figurky_protivnika())) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(CernyHracAI.getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + i) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "vez", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getRadek_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - i][CernyHracAI.getSloupec_figurky_protivnika()] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(CernyHracAI.getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - CernyHracAI.nahodna_pozice) * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "vez", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - i)) + CernyHracAI.getSloupec_figurky_protivnika())) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(CernyHracAI.getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - i) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "vez", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getSloupec_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika()][CernyHracAI.getSloupec_figurky_protivnika() - i] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - CernyHracAI.nahodna_pozice) * 64);
                                ctverec.setY(CernyHracAI.getRadek_figurky_protivnika() * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "vez", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika())) + (CernyHracAI.getSloupec_figurky_protivnika() - i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika()) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "vez", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getSloupec_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika()][CernyHracAI.getSloupec_figurky_protivnika() + i] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + CernyHracAI.nahodna_pozice) * 64);
                                ctverec.setY(CernyHracAI.getRadek_figurky_protivnika() * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "vez", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika())) + (CernyHracAI.getSloupec_figurky_protivnika() + i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika()) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "vez", figurka, vzhled_okna);
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
        CernyHracAI.setRadek_figurky_protivnika((int) (figurka.getY() / 64));
        CernyHracAI.setSloupec_figurky_protivnika((int) (figurka.getX() / 64));
        switch (random.nextInt(8)){
            case 0:
                // 1
                if ((CernyHracAI.getRadek_figurky_protivnika() - 2) * 64 >= 0 && (CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - 2][CernyHracAI.getSloupec_figurky_protivnika() - 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 2) * 64);
                        CernyHracAI.presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - 2)) + (CernyHracAI.getSloupec_figurky_protivnika() - 1)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 2) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 1:
                // 2
                if ((CernyHracAI.getRadek_figurky_protivnika() - 2) * 64 >= 0 && (CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - 2][CernyHracAI.getSloupec_figurky_protivnika() + 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 2) * 64);
                        CernyHracAI.presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - 2)) + (CernyHracAI.getSloupec_figurky_protivnika() + 1)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 2) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 2:
                // 3
                if ((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64 >= 0 && (CernyHracAI.getSloupec_figurky_protivnika() - 2) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - 1][CernyHracAI.getSloupec_figurky_protivnika() - 2] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 2) * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64);
                        CernyHracAI.presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - 1)) + (CernyHracAI.getSloupec_figurky_protivnika() - 2)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 2) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 3:
                // 4
                if ((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64 >= 0 && (CernyHracAI.getSloupec_figurky_protivnika() + 2) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - 1][CernyHracAI.getSloupec_figurky_protivnika() + 2] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 2) * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64);
                        CernyHracAI.presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - 1)) + (CernyHracAI.getSloupec_figurky_protivnika() + 2)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 2) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 4:
                // 5
                if ((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64 <= 7 * 64 && (CernyHracAI.getSloupec_figurky_protivnika() - 2) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + 1][CernyHracAI.getSloupec_figurky_protivnika() - 2] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 2) * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64);
                        CernyHracAI.presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + 1)) + (CernyHracAI.getSloupec_figurky_protivnika() - 2)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 2) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 5:
                // 6
                if ((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64 <= 7 * 64 && (CernyHracAI.getSloupec_figurky_protivnika() + 2) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + 1][CernyHracAI.getSloupec_figurky_protivnika() + 2] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 2) * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64);
                        CernyHracAI.presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + 1)) + (CernyHracAI.getSloupec_figurky_protivnika() + 2)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 2) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 6:
                // 7
                if ((CernyHracAI.getRadek_figurky_protivnika() + 2) * 64 <= 7 * 64 && (CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + 2][CernyHracAI.getSloupec_figurky_protivnika() - 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 2) * 64);
                        CernyHracAI.presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + 2)) + (CernyHracAI.getSloupec_figurky_protivnika() - 1)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 2) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 7:
                // 8
                if ((CernyHracAI.getRadek_figurky_protivnika() + 2) * 64 <= 7 * 64 && (CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + 2][CernyHracAI.getSloupec_figurky_protivnika() + 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 2) * 64);
                        CernyHracAI.presunuti_na_ctverec(ctverec, "kun", figurka, vzhled_okna);
                    }
                    else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + 2)) + (CernyHracAI.getSloupec_figurky_protivnika() + 1)) ) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 2) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kun", figurka, vzhled_okna);
                        }
                    }
                }
                break;
        }
    }
    private void AI_pohyb_strelce(Group vzhled_okna, ImageView figurka) {
        CernyHracAI.setRadek_figurky_protivnika((int) (figurka.getY() / 64));
        CernyHracAI.setSloupec_figurky_protivnika((int) (figurka.getX() / 64));
        switch (random.nextInt(4)) {
            case 0:
                // DOLU DOPRAVA
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getRadek_figurky_protivnika() + i) * 64 <= 7 * 64 && (CernyHracAI.getSloupec_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + i][CernyHracAI.getSloupec_figurky_protivnika() + i] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + CernyHracAI.nahodna_pozice) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + CernyHracAI.nahodna_pozice) * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "strelec", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + i)) + (CernyHracAI.getSloupec_figurky_protivnika() + i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + i) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "strelec", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getRadek_figurky_protivnika() + i) * 64 <= 7 * 64 && (CernyHracAI.getSloupec_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + i][CernyHracAI.getSloupec_figurky_protivnika() - i] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - CernyHracAI.nahodna_pozice) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + CernyHracAI.nahodna_pozice) * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "strelec", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + i)) + (CernyHracAI.getSloupec_figurky_protivnika() - i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + i) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "strelec", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getRadek_figurky_protivnika() - i) * 64 >= 0 && (CernyHracAI.getSloupec_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - i][CernyHracAI.getSloupec_figurky_protivnika() - i] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - CernyHracAI.nahodna_pozice) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - CernyHracAI.nahodna_pozice) * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "strelec", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - i)) + (CernyHracAI.getSloupec_figurky_protivnika() - i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - i) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "strelec", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getRadek_figurky_protivnika() - i) * 64 >= 0 && (CernyHracAI.getSloupec_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - i][CernyHracAI.getSloupec_figurky_protivnika() + i] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + CernyHracAI.nahodna_pozice) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - CernyHracAI.nahodna_pozice) * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "strelec", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - i)) + (CernyHracAI.getSloupec_figurky_protivnika() + i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - i) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "strelec", figurka, vzhled_okna);
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
        CernyHracAI.setRadek_figurky_protivnika((int) (figurka.getY() / 64));
        CernyHracAI.setSloupec_figurky_protivnika((int) (figurka.getX() / 64));
        switch (random.nextInt(8)) {
            case 0:
                // Pohyb po ose Y - DOLU
                if ((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + 1][CernyHracAI.getSloupec_figurky_protivnika()] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX(CernyHracAI.getSloupec_figurky_protivnika() * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64);
                        CernyHracAI.presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + 1)) + (CernyHracAI.getSloupec_figurky_protivnika()))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika()) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 1:
                // Pohyb po ose Y - NAHORU
                if ((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - 1][CernyHracAI.getSloupec_figurky_protivnika()] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX(CernyHracAI.getSloupec_figurky_protivnika() * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64);
                        CernyHracAI.presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - 1)) + (CernyHracAI.getSloupec_figurky_protivnika()))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika()) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 2:
                // Pohyb po ose X - DOLEVA
                if ((CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika()][CernyHracAI.getSloupec_figurky_protivnika() - 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64);
                        ctverec.setY(CernyHracAI.getRadek_figurky_protivnika() * 64);
                        CernyHracAI.presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika())) + (CernyHracAI.getSloupec_figurky_protivnika() - 1))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika()) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 3:
                // Pohyb po ose X - DOPRAVA
                if ((CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika()][CernyHracAI.getSloupec_figurky_protivnika() + 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64);
                        ctverec.setY(CernyHracAI.getRadek_figurky_protivnika() * 64);
                        CernyHracAI.presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika())) + (CernyHracAI.getSloupec_figurky_protivnika() + 1))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika()) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 4:
                // DOLU DOPRAVA
                if ((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64 <= 7 * 64 && (CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + 1][CernyHracAI.getSloupec_figurky_protivnika() + 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64);
                        CernyHracAI.presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + 1)) + (CernyHracAI.getSloupec_figurky_protivnika() + 1))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 5:
                // DOLU DOLEVA
                if ((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64 <= 7 * 64 && (CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + 1][CernyHracAI.getSloupec_figurky_protivnika() - 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64);
                        CernyHracAI.presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + 1)) + (CernyHracAI.getSloupec_figurky_protivnika() - 1))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + 1) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 6:
                // NAHORU DOLEVA
                if ((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64 >= 0 && (CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64 >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - 1][CernyHracAI.getSloupec_figurky_protivnika() - 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64);
                        CernyHracAI.presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - 1)) + (CernyHracAI.getSloupec_figurky_protivnika() - 1))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
            case 7:
                // NAHORU DOPRAVA
                if ((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64 >= 0 && (CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64 <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - 1][CernyHracAI.getSloupec_figurky_protivnika() + 1] != 1) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64);
                        CernyHracAI.presunuti_na_ctverec_pro_krale(ctverec, figurka, vzhled_okna);
                    } else {
                        if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - 1)) + (CernyHracAI.getSloupec_figurky_protivnika() + 1))) != null) {
                            Rectangle ctverec = new Rectangle();
                            ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64);
                            ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64);
                            CernyHracAI.presunuti_na_ctverec_s_figurkou_pro_krale(ctverec, figurka, vzhled_okna);
                        }
                    }
                }
                break;
        }
    }
    private void AI_pohyb_kralovny(Group vzhled_okna, ImageView figurka){
        CernyHracAI.setRadek_figurky_protivnika((int) (figurka.getY() / 64));
        CernyHracAI.setSloupec_figurky_protivnika((int) (figurka.getX() / 64));
        switch (random.nextInt(8)){
            case 0:
                // Pohyb po ose Y - DOLU
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getRadek_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + i][CernyHracAI.getSloupec_figurky_protivnika()] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(CernyHracAI.getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + CernyHracAI.nahodna_pozice) * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + i)) + CernyHracAI.getSloupec_figurky_protivnika())) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(CernyHracAI.getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + i) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getRadek_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - i][CernyHracAI.getSloupec_figurky_protivnika()] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(CernyHracAI.getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - CernyHracAI.nahodna_pozice) * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - i)) + CernyHracAI.getSloupec_figurky_protivnika())) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX(CernyHracAI.getSloupec_figurky_protivnika() * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - i) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getSloupec_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika()][CernyHracAI.getSloupec_figurky_protivnika() - i] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - CernyHracAI.nahodna_pozice) * 64);
                                ctverec.setY(CernyHracAI.getRadek_figurky_protivnika() * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika())) + (CernyHracAI.getSloupec_figurky_protivnika() - i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika()) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getSloupec_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika()][CernyHracAI.getSloupec_figurky_protivnika() + i] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + CernyHracAI.nahodna_pozice) * 64);
                                ctverec.setY(CernyHracAI.getRadek_figurky_protivnika() * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika())) + (CernyHracAI.getSloupec_figurky_protivnika() + i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika()) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getRadek_figurky_protivnika() + i) * 64 <= 7 * 64 && (CernyHracAI.getSloupec_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + i][CernyHracAI.getSloupec_figurky_protivnika() + i] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + CernyHracAI.nahodna_pozice) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + CernyHracAI.nahodna_pozice) * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + i)) + (CernyHracAI.getSloupec_figurky_protivnika() + i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + i) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getRadek_figurky_protivnika() + i) * 64 <= 7 * 64 && (CernyHracAI.getSloupec_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() + i][CernyHracAI.getSloupec_figurky_protivnika() - i] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - CernyHracAI.nahodna_pozice) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + CernyHracAI.nahodna_pozice) * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() + i)) + (CernyHracAI.getSloupec_figurky_protivnika() - i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() + i) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getRadek_figurky_protivnika() - i) * 64 >= 0 && (CernyHracAI.getSloupec_figurky_protivnika() - i) * 64 >= 0) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - i][CernyHracAI.getSloupec_figurky_protivnika() - i] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - CernyHracAI.nahodna_pozice) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - CernyHracAI.nahodna_pozice) * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - i)) + (CernyHracAI.getSloupec_figurky_protivnika() - i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - i) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - i) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
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
                for (int i = 1; i <= 7; i++) {
                    if ((CernyHracAI.getRadek_figurky_protivnika() - i) * 64 >= 0 && (CernyHracAI.getSloupec_figurky_protivnika() + i) * 64 <= 7 * 64) {
                        if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - i][CernyHracAI.getSloupec_figurky_protivnika() + i] != 1) {
                            if (i == 7) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + CernyHracAI.nahodna_pozice) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - CernyHracAI.nahodna_pozice) * 64);
                                CernyHracAI.presunuti_na_ctverec(ctverec, "kralovna", figurka, vzhled_okna);
                            }
                        } else {
                            if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - i)) + (CernyHracAI.getSloupec_figurky_protivnika() + i))) != null) {
                                Rectangle ctverec = new Rectangle();
                                ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + i) * 64);
                                ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - i) * 64);
                                CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "kralovna", figurka, vzhled_okna);
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
        CernyHracAI.setRadek_figurky_protivnika((int) (figurka.getY() / 64));
        CernyHracAI.setSloupec_figurky_protivnika((int) (figurka.getX() / 64));
        // Pohyb po ose Y - NAHORU
        for (int i = 1; i <= 2; i++) {
            if ((CernyHracAI.getRadek_figurky_protivnika() - i) * 64 >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - i][CernyHracAI.getSloupec_figurky_protivnika()] != 1) {
                    if (i == 2) {
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX(CernyHracAI.getSloupec_figurky_protivnika() * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - CernyHracAI.nahodna_pozice_pesce) * 64);
                        CernyHracAI.presunuti_na_ctverec(ctverec, "pesec", figurka, vzhled_okna);
                    }
                }
                else {
                    if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - i)) + CernyHracAI.getSloupec_figurky_protivnika()) ) != null){
                        Rectangle ctverec = new Rectangle();
                        ctverec.setX(CernyHracAI.getSloupec_figurky_protivnika() * 64);
                        ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - i) * 64);
                        CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "pesec", figurka, vzhled_okna);
                        break;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        // Pohyb NAHORU DOPRAVA když tam bude figurka protivníka
        if ((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64 >= 0 && (CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64 <= 7 * 64) {
            if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - 1][CernyHracAI.getSloupec_figurky_protivnika() + 1] == 1) {
                if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - 1)) + (CernyHracAI.getSloupec_figurky_protivnika() + 1)) ) != null){
                    Rectangle ctverec = new Rectangle();
                    ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() + 1) * 64);
                    ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64);
                    CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "pesec", figurka, vzhled_okna);
                }
            }
        }
        // Pohyb NAHORU DOLEVA když tam bude figurka protivníka
        if ((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64 >= 0 && (CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64 >= 0) {
            if (PohybyFigurky.ctvercove_pole_pro_figurky[CernyHracAI.getRadek_figurky_protivnika() - 1][CernyHracAI.getSloupec_figurky_protivnika() - 1] == 1) {
                if (PohybyFigurky.cislo_a_figurka.get("bila" + (Integer.toString((CernyHracAI.getRadek_figurky_protivnika() - 1)) + (CernyHracAI.getSloupec_figurky_protivnika() - 1)) ) != null){
                    Rectangle ctverec = new Rectangle();
                    ctverec.setX((CernyHracAI.getSloupec_figurky_protivnika() - 1) * 64);
                    ctverec.setY((CernyHracAI.getRadek_figurky_protivnika() - 1) * 64);
                    CernyHracAI.presunuti_na_ctverec_s_figurkou(ctverec, "pesec", figurka, vzhled_okna);
                }
            }
        }
    }
    
}
