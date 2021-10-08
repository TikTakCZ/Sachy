import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


public class BilyHrac {

    // Figurky
    public static final ImageView bila_vez1 = new ImageView("bile_figurky/bila_vez.png");
    public static final ImageView bily_kun1 = new ImageView("bile_figurky/bily_kun.png");
    public static final ImageView bily_strelec1 = new ImageView("bile_figurky/bily_strelec.png");
    public static final ImageView bily_kral = new ImageView("bile_figurky/bily_kral.png");
    public static final ImageView bila_kralovna = new ImageView("bile_figurky/bila_kralovna.png");
    public static final ImageView bily_strelec2 = new ImageView("bile_figurky/bily_strelec.png");
    public static final ImageView bily_kun2 = new ImageView("bile_figurky/bily_kun.png");
    public static final ImageView bila_vez2 = new ImageView("bile_figurky/bila_vez.png");

    // Pěšáci
    public static final ImageView bily_pesak1 = new ImageView("bile_figurky/bily_pesec.png");
    public static final ImageView bily_pesak2 = new ImageView("bile_figurky/bily_pesec.png");
    public static final ImageView bily_pesak3 = new ImageView("bile_figurky/bily_pesec.png");
    public static final ImageView bily_pesak4 = new ImageView("bile_figurky/bily_pesec.png");
    public static final ImageView bily_pesak5 = new ImageView("bile_figurky/bily_pesec.png");
    public static final ImageView bily_pesak6 = new ImageView("bile_figurky/bily_pesec.png");
    public static final ImageView bily_pesak7 = new ImageView("bile_figurky/bily_pesec.png");
    public static final ImageView bily_pesak8 = new ImageView("bile_figurky/bily_pesec.png");

    // Figurky ktere jsou na sachovnici
    public static boolean bila_vez1_na_sachovnici = true;
    public static boolean bily_kun1_na_sachovnici = true;
    public static boolean bily_strelec1_na_sachovnici = true;
    public static boolean bily_kral_na_sachovnici = true;
    public static boolean bila_kralovna_na_sachovnici = true;
    public static boolean bily_strelec2_na_sachovnici = true;
    public static boolean bily_kun2_na_sachovnici = true;
    public static boolean bila_vez2_na_sachovnici = true;

    public static boolean bily_pesak1_na_sachovnici = true;
    public static boolean bily_pesak2_na_sachovnici = true;
    public static boolean bily_pesak3_na_sachovnici = true;
    public static boolean bily_pesak4_na_sachovnici = true;
    public static boolean bily_pesak5_na_sachovnici = true;
    public static boolean bily_pesak6_na_sachovnici = true;
    public static boolean bily_pesak7_na_sachovnici = true;
    public static boolean bily_pesak8_na_sachovnici = true;

    // Ctverce pro mat
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_vez1 = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_kun1= new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_strelec1 = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_kral = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_kralovna = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_strelec2 = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_kun2 = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_vez2 = new ArrayList<>();

    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_pesec1 = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_pesec2 = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_pesec3 = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_pesec4 = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_pesec5 = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_pesec6 = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_pesec7 = new ArrayList<>();
    private static final ArrayList<Rectangle> nove_bile_ctverce_pro_mat_pesec8 = new ArrayList<>();


    // Vytvoření matovych čtvercu
    public static void vytvoreni_matovych_ctvercu_bila_vez1(ImageView figurka, Group vzhled_okna){
        if (bila_vez1_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_vez1) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_vez1.clear();
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) + (j * 64)) <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + j][(int) (figurka.getX() / 64)] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX());
                        matovy_ctverec.setY((figurka.getY()) + (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_vez1.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) - (j * 64)) >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - j][(int) (figurka.getX() / 64)] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX());
                        matovy_ctverec.setY((figurka.getY()) - (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_vez1.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getX()) - (j * 64)) >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64)][(int) (figurka.getX() / 64) - j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() - (j * 64));
                        matovy_ctverec.setY((figurka.getY()));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_vez1.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getX()) + (j * 64)) <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64)][(int) (figurka.getX() / 64) + j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() + (j * 64));
                        matovy_ctverec.setY((figurka.getY()));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_vez1.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_vez1) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_vez1.clear();
        }
    }
    public static void vytvoreni_matovych_ctvercu_bila_vez2(ImageView figurka, Group vzhled_okna){
        if (bila_vez2_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_vez2) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_vez2.clear();
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) + (j * 64)) <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + j][(int) (figurka.getX() / 64)] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX());
                        matovy_ctverec.setY((figurka.getY()) + (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_vez2.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) - (j * 64)) >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - j][(int) (figurka.getX() / 64)] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX());
                        matovy_ctverec.setY((figurka.getY()) - (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_vez2.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getX()) - (j * 64)) >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64)][(int) (figurka.getX() / 64) - j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() - (j * 64));
                        matovy_ctverec.setY((figurka.getY()));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_vez2.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getX()) + (j * 64)) <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64)][(int) (figurka.getX() / 64) + j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() + (j * 64));
                        matovy_ctverec.setY((figurka.getY()));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_vez2.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_vez2) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_vez2.clear();
        }
    }
    public static void vytvoreni_matovych_ctvercu_bily_kun1(ImageView figurka, Group vzhled_okna){
        if (bily_kun1_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_kun1) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_kun1.clear();
            if (((figurka.getY()) - (2 * 64)) >= 0 && (figurka.getX()) - (64) >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - 2][(int) (figurka.getX() / 64) - 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) - (64));
                    matovy_ctverec.setY((figurka.getY()) - (2 * 64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun1.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) - (2 * 64)) >= 0 && (figurka.getX()) + (64) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - 2][(int) (figurka.getX() / 64) + 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) + (64));
                    matovy_ctverec.setY((figurka.getY()) - (2 * 64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun1.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) - (64)) >= 0 && (figurka.getX()) - (2 * 64) >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - 1][(int) (figurka.getX() / 64) - 2] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) - (2 * 64));
                    matovy_ctverec.setY((figurka.getY()) - (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun1.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) - (64)) >= 0 && (figurka.getX()) + (2 * 64) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - 1][(int) (figurka.getX() / 64) + 2] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) + (2 * 64));
                    matovy_ctverec.setY((figurka.getY()) - (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun1.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) + (64)) <= 7 * 64 && (figurka.getX()) - (2 * 64) >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + 1][(int) (figurka.getX() / 64) - 2] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) - (2 * 64));
                    matovy_ctverec.setY((figurka.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun1.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) + (64)) <= 7 * 64 && (figurka.getX()) + (2 * 64) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + 1][(int) (figurka.getX() / 64) + 2] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) + (2 * 64));
                    matovy_ctverec.setY((figurka.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun1.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) + (2 * 64)) <= 7 * 64 && (figurka.getX()) - (64) >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + 2][(int) (figurka.getX() / 64) - 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) - (64));
                    matovy_ctverec.setY((figurka.getY()) + (2 * 64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun1.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) + (2 * 64)) <= 7 * 64 && (figurka.getX()) + (64) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + 2][(int) (figurka.getX() / 64) + 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) + (64));
                    matovy_ctverec.setY((figurka.getY()) + (2 * 64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun1.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_kun1) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_kun1.clear();
        }
    }
    public static void vytvoreni_matovych_ctvercu_bily_kun2(ImageView figurka, Group vzhled_okna){
        if (bily_kun2_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_kun2) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_kun2.clear();
            if (((figurka.getY()) - (2 * 64)) >= 0 && (figurka.getX()) - (64) >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - 2][(int) (figurka.getX() / 64) - 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) - (64));
                    matovy_ctverec.setY((figurka.getY()) - (2 * 64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun2.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) - (2 * 64)) >= 0 && (figurka.getX()) + (64) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - 2][(int) (figurka.getX() / 64) + 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) + (64));
                    matovy_ctverec.setY((figurka.getY()) - (2 * 64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun2.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) - (64)) >= 0 && (figurka.getX()) - (2 * 64) >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - 1][(int) (figurka.getX() / 64) - 2] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) - (2 * 64));
                    matovy_ctverec.setY((figurka.getY()) - (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun2.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) - (64)) >= 0 && (figurka.getX()) + (2 * 64) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - 1][(int) (figurka.getX() / 64) + 2] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) + (2 * 64));
                    matovy_ctverec.setY((figurka.getY()) - (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun2.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) + (64)) <= 7 * 64 && (figurka.getX()) - (2 * 64) >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + 1][(int) (figurka.getX() / 64) - 2] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) - (2 * 64));
                    matovy_ctverec.setY((figurka.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun2.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) + (64)) <= 7 * 64 && (figurka.getX()) + (2 * 64) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + 1][(int) (figurka.getX() / 64) + 2] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) + (2 * 64));
                    matovy_ctverec.setY((figurka.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun2.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) + (2 * 64)) <= 7 * 64 && (figurka.getX()) - (64) >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + 2][(int) (figurka.getX() / 64) - 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) - (64));
                    matovy_ctverec.setY((figurka.getY()) + (2 * 64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun2.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) + (2 * 64)) <= 7 * 64 && (figurka.getX()) + (64) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + 2][(int) (figurka.getX() / 64) + 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) + (64));
                    matovy_ctverec.setY((figurka.getY()) + (2 * 64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kun2.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_kun2) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_kun2.clear();
        }
    }
    public static void vytvoreni_matovych_ctvercu_bily_strelec1(ImageView figurka, Group vzhled_okna){
        if (bily_strelec1_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_strelec1) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_strelec1.clear();
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) + (j * 64)) <= 7 * 64 && figurka.getX() + (j * 64) <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + j][(int) (figurka.getX() / 64) + j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() + (j * 64));
                        matovy_ctverec.setY((figurka.getY()) + (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_strelec1.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) + (j * 64)) <= 7 * 64 && figurka.getX() - (j * 64) >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + j][(int) (figurka.getX() / 64) - j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() - (j * 64));
                        matovy_ctverec.setY((figurka.getY()) + (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_strelec1.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) - (j * 64)) >= 0 && figurka.getX() - (j * 64) >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - j][(int) (figurka.getX() / 64) - j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() - (j * 64));
                        matovy_ctverec.setY((figurka.getY()) - (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_strelec1.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) - (j * 64)) >= 0 && figurka.getX() + (j * 64) <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - j][(int) (figurka.getX() / 64) + j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() + (j * 64));
                        matovy_ctverec.setY((figurka.getY()) - (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_strelec1.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_strelec1) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_strelec1.clear();
        }
    }
    public static void vytvoreni_matovych_ctvercu_bily_strelec2(ImageView figurka, Group vzhled_okna){
        if (bily_strelec2_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_strelec2) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_strelec2.clear();
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) + (j * 64)) <= 7 * 64 && figurka.getX() + (j * 64) <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + j][(int) (figurka.getX() / 64) + j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() + (j * 64));
                        matovy_ctverec.setY((figurka.getY()) + (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_strelec2.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) + (j * 64)) <= 7 * 64 && figurka.getX() - (j * 64) >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + j][(int) (figurka.getX() / 64) - j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() - (j * 64));
                        matovy_ctverec.setY((figurka.getY()) + (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_strelec2.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) - (j * 64)) >= 0 && figurka.getX() - (j * 64) >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - j][(int) (figurka.getX() / 64) - j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() - (j * 64));
                        matovy_ctverec.setY((figurka.getY()) - (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_strelec2.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) - (j * 64)) >= 0 && figurka.getX() + (j * 64) <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - j][(int) (figurka.getX() / 64) + j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() + (j * 64));
                        matovy_ctverec.setY((figurka.getY()) - (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_strelec2.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_strelec2) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_strelec2.clear();
        }
    }
    public static void vytvoreni_matovych_ctvercu_bily_kral(ImageView figurka, Group vzhled_okna){
        if (bily_kral_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_kral) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_kral.clear();
            if (((figurka.getY()) + (64)) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + 1][(int) (figurka.getX() / 64)] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()));
                    matovy_ctverec.setY((figurka.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kral.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) - (64)) >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - 1][(int) (figurka.getX() / 64)] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()));
                    matovy_ctverec.setY((figurka.getY()) - (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kral.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if ((figurka.getX()) - (64) >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64)][(int) (figurka.getX() / 64) - 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) - (64));
                    matovy_ctverec.setY((figurka.getY()));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kral.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if ((figurka.getX()) + (64) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64)][(int) (figurka.getX() / 64) + 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) + (64));
                    matovy_ctverec.setY((figurka.getY()));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kral.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) + (64)) <= 7 * 64 && (figurka.getX()) + (64) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + 1][(int) (figurka.getX() / 64) + 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) + (64));
                    matovy_ctverec.setY((figurka.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kral.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) + (64)) <= 7 * 64 && (figurka.getX()) - (64) >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + 1][(int) (figurka.getX() / 64) - 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) - (64));
                    matovy_ctverec.setY((figurka.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kral.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) - (64)) >= 0 && (figurka.getX()) + (64) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - 1][(int) (figurka.getX() / 64) + 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) + (64));
                    matovy_ctverec.setY((figurka.getY()) - (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kral.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
            if (((figurka.getY()) - (64)) >= 0 && (figurka.getX()) - (64) >= 0) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - 1][(int) (figurka.getX() / 64) - 1] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX((figurka.getX()) - (64));
                    matovy_ctverec.setY((figurka.getY()) - (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_kral.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_kral) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_kral.clear();
        }
    }
    public static void vytvoreni_matovych_ctvercu_bila_kralovna(ImageView figurka, Group vzhled_okna){
        if (bila_kralovna_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_kralovna) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_kralovna.clear();
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) + (j * 64)) <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + j][(int) (figurka.getX() / 64)] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX());
                        matovy_ctverec.setY((figurka.getY()) + (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_kralovna.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) - (j * 64)) >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - j][(int) (figurka.getX() / 64)] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX());
                        matovy_ctverec.setY((figurka.getY()) - (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_kralovna.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getX()) - (j * 64)) >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64)][(int) (figurka.getX() / 64) - j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() - (j * 64));
                        matovy_ctverec.setY((figurka.getY()));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_kralovna.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getX()) + (j * 64)) <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64)][(int) (figurka.getX() / 64) + j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() + (j * 64));
                        matovy_ctverec.setY((figurka.getY()));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_kralovna.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) + (j * 64)) <= 7 * 64 && figurka.getX() + (j * 64) <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + j][(int) (figurka.getX() / 64) + j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() + (j * 64));
                        matovy_ctverec.setY((figurka.getY()) + (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_kralovna.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) + (j * 64)) <= 7 * 64 && figurka.getX() - (j * 64) >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) + j][(int) (figurka.getX() / 64) - j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() - (j * 64));
                        matovy_ctverec.setY((figurka.getY()) + (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_kralovna.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) - (j * 64)) >= 0 && figurka.getX() - (j * 64) >= 0) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - j][(int) (figurka.getX() / 64) - j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() - (j * 64));
                        matovy_ctverec.setY((figurka.getY()) - (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_kralovna.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
            for (int j = 1; j <= 7; j++) {
                if (((figurka.getY()) - (j * 64)) >= 0 && figurka.getX() + (j * 64) <= 7 * 64) {
                    if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka.getY() / 64) - j][(int) (figurka.getX() / 64) + j] != 1) {
                        Rectangle matovy_ctverec = new Rectangle();
                        matovy_ctverec.setX(figurka.getX() + (j * 64));
                        matovy_ctverec.setY((figurka.getY()) - (j * 64));
                        vzhled_okna.getChildren().add(matovy_ctverec);
                        nove_bile_ctverce_pro_mat_kralovna.add(matovy_ctverec);
                        PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                    } else {
                        break;
                    }
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_kralovna) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_kralovna.clear();
        }
    }
    public static void vytvoreni_matovych_ctvercu_bili_pesci(ImageView figurka1, ImageView figurka2, ImageView figurka3, ImageView figurka4, ImageView figurka5, ImageView figurka6, ImageView figurka7, ImageView figurka8, Group vzhled_okna){
        if (bily_pesak1_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec1) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec1.clear();
            if (((figurka1.getY()) + (64)) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka1.getY() / 64) + 1][(int) (figurka1.getX() / 64)] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX(figurka1.getX());
                    matovy_ctverec.setY((figurka1.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_pesec1.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec1) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec1.clear();
        }
        if (bily_pesak2_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec2) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec2.clear();
            if (((figurka2.getY()) + (64)) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka2.getY() / 64) + 1][(int) (figurka2.getX() / 64)] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX(figurka2.getX());
                    matovy_ctverec.setY((figurka2.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_pesec2.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec2) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec2.clear();
        }
        if (bily_pesak3_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec3) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec3.clear();
            if (((figurka3.getY()) + (64)) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka3.getY() / 64) + 1][(int) (figurka3.getX() / 64)] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX(figurka3.getX());
                    matovy_ctverec.setY((figurka3.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_pesec3.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec3) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec3.clear();
        }
        if (bily_pesak4_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec4) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec4.clear();
            if (((figurka4.getY()) + (64)) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka4.getY() / 64) + 1][(int) (figurka4.getX() / 64)] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX(figurka4.getX());
                    matovy_ctverec.setY((figurka4.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_pesec4.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec4) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec4.clear();
        }
        if (bily_pesak5_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec5) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec5.clear();
            if (((figurka5.getY()) + (64)) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka5.getY() / 64) + 1][(int) (figurka5.getX() / 64)] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX(figurka5.getX());
                    matovy_ctverec.setY((figurka5.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_pesec5.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec5) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec5.clear();
        }
        if (bily_pesak6_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec6) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec6.clear();
            if (((figurka6.getY()) + (64)) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka6.getY() / 64) + 1][(int) (figurka6.getX() / 64)] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX(figurka6.getX());
                    matovy_ctverec.setY((figurka6.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_pesec6.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec6) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec6.clear();
        }
        if (bily_pesak7_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec7) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec7.clear();
            if (((figurka7.getY()) + (64)) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka7.getY() / 64) + 1][(int) (figurka7.getX() / 64)] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX(figurka7.getX());
                    matovy_ctverec.setY((figurka7.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_pesec7.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec7) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec7.clear();
        }
        if (bily_pesak8_na_sachovnici) {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec8) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec8.clear();
            if (((figurka8.getY()) + (64)) <= 7 * 64) {
                if (PohybyFigurky.ctvercove_pole_pro_figurky[(int) (figurka8.getY() / 64) + 1][(int) (figurka8.getX() / 64)] != 1) {
                    Rectangle matovy_ctverec = new Rectangle();
                    matovy_ctverec.setX(figurka8.getX());
                    matovy_ctverec.setY((figurka8.getY()) + (64));
                    vzhled_okna.getChildren().add(matovy_ctverec);
                    nove_bile_ctverce_pro_mat_pesec8.add(matovy_ctverec);
                    PohybyFigurky.vsechny_bile_ctverce_pro_mat.add(matovy_ctverec);
                }
            }
        }
        else {
            for (Rectangle figurka_k_odstraneni : nove_bile_ctverce_pro_mat_pesec8) {
                PohybyFigurky.vsechny_bile_ctverce_pro_mat.remove(figurka_k_odstraneni);
                vzhled_okna.getChildren().remove(figurka_k_odstraneni);
            }
            nove_bile_ctverce_pro_mat_pesec8.clear();
        }
    }


    public static void nastaveni_pohybu_figurek(Group vzhled_okna){
        bila_vez1.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bila_vez1_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bila_vez1.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bila_vez1.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bile_veze(vzhled_okna, bila_vez1);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_kun1.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_kun1_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bily_kun1.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bily_kun1.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_kone(vzhled_okna, bily_kun1);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_strelec1.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_strelec1_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bily_strelec1.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bily_strelec1.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_strelce(vzhled_okna, bily_strelec1);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_kral.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_kral_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bily_kral.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bily_kral.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_krale(vzhled_okna, bily_kral);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bila_kralovna.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bila_kralovna_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bila_kralovna.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bila_kralovna.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bile_kralovny(vzhled_okna, bila_kralovna);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_strelec2.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_strelec2_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bily_strelec2.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bily_strelec2.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_strelce(vzhled_okna, bily_strelec2);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_kun2.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_kun2_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bily_kun2.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bily_kun2.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_kone(vzhled_okna, bily_kun2);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bila_vez2.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bila_vez2_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bila_vez2.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bila_vez2.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bile_veze(vzhled_okna, bila_vez2);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_pesak1.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_pesak1_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) (bily_pesak1.getY() / 64));
                PohybyFigurky.setSloupec_figurky((int) (bily_pesak1.getX() / 64));

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_pesce(vzhled_okna, bily_pesak1);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_pesak2.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_pesak2_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) (bily_pesak2.getY() / 64));
                PohybyFigurky.setSloupec_figurky((int) (bily_pesak2.getX() / 64));

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_pesce(vzhled_okna, bily_pesak2);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_pesak3.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_pesak3_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) (bily_pesak3.getY() / 64));
                PohybyFigurky.setSloupec_figurky((int) bily_pesak3.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_pesce(vzhled_okna, bily_pesak3);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_pesak4.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_pesak4_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bily_pesak4.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bily_pesak4.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_pesce(vzhled_okna, bily_pesak4);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_pesak5.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_pesak5_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bily_pesak5.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bily_pesak5.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_pesce(vzhled_okna, bily_pesak5);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_pesak6.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_pesak6_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bily_pesak6.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bily_pesak6.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_pesce(vzhled_okna, bily_pesak6);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_pesak7.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_pesak7_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bily_pesak7.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bily_pesak7.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_pesce(vzhled_okna, bily_pesak7);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
        bily_pesak8.setOnMouseClicked(mouseEvent -> {
            if (!PohybyFigurky.figurka_zakliknuta && PohybyFigurky.je_bily_hrac_na_rade && !PohybyFigurky.je_cerny_hrac_na_rade && PohybyFigurky.hraje_hrac && !PohybyFigurky.hraje_AI && bily_pesak8_na_sachovnici) {
                // Zapsani řádku a sloupce figurky
                PohybyFigurky.setRadek_figurky((int) bily_pesak8.getY() / 64);
                PohybyFigurky.setSloupec_figurky((int) bily_pesak8.getX() / 64);

                // Pohyb figurky
                PohybyFigurky.pohyb_bileho_pesce(vzhled_okna, bily_pesak8);

                PohybyFigurky.figurka_zakliknuta = true;
            } else if (PohybyFigurky.figurka_zakliknuta) {
                PohybyFigurky.smazani_pomocnych_ctvercu(vzhled_okna);
                PohybyFigurky.figurka_zakliknuta = false;
            }
        });
    }

}
