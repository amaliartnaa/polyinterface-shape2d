package polyinterface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pilih bangun datar
        int x;
        do {
            System.out.println("Silakan pilih bangun datar: ");
            System.out.println("1. Square");
            System.out.println("2. Circle");
            System.out.println("3. Right Triangle");
            System.out.println("4. Rectangle");
            System.out.println("Masukkan pilihan Anda (1-4):");

            while (!sc.hasNextInt()) {  // Memeriksa apakah input adalah angka
                System.out.println("Input tidak valid. Masukkan angka antara 1-4: ");
                sc.next();  // Membersihkan input yang tidak valid
            }
            x = sc.nextInt();

            if (x < 1 || x > 4) {
                System.out.println("Input tidak valid. Silakan masukkan angka antara 1-4.");
            }
        } while (x < 1 || x > 4);

        Geom2D shape1 = null;

        // Buat bangun datar dengan validasi input
        if (x == 1) {
            int sisi;
            do {
                System.out.println("Masukkan sisi persegi: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Input tidak valid. Masukkan sisi dengan angka positif: ");
                    sc.next();
                }
                sisi = sc.nextInt();
                if (sisi <= 0) {
                    System.out.println("Input tidak valid. Masukkan sisi dengan angka positif.");
                }
            } while (sisi <= 0);
            shape1 = new Square(sisi);

        } else if (x == 2) {
            int radius;
            do {
                System.out.println("Masukkan jari-jari lingkaran: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Input tidak valid. Masukkan radius dengan angka positif: ");
                    sc.next();
                }
                radius = sc.nextInt();
                if (radius <= 0) {
                    System.out.println("Input tidak valid. Masukkan radius dengan angka positif.");
                }
            } while (radius <= 0);
            shape1 = new Circle(radius);

        } else if (x == 3) {
            int base, height;
            do {
                System.out.println("Masukkan alas segitiga: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Input tidak valid. Masukkan alas dengan angka positif: ");
                    sc.next();
                }
                base = sc.nextInt();
                if (base <= 0) {
                    System.out.println("Input tidak valid. Masukkan alas dengan angka positif.");
                }
            } while (base <= 0);

            do {
                System.out.println("Masukkan tinggi segitiga: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Input tidak valid. Masukkan tinggi dengan angka positif: ");
                    sc.next();
                }
                height = sc.nextInt();
                if (height <= 0) {
                    System.out.println("Input tidak valid. Masukkan tinggi dengan angka positif.");
                }
            } while (height <= 0);
            shape1 = new RightTriangle(base, height);

        } else if (x == 4) {
            int height, width;
            do {
                System.out.println("Masukkan tinggi persegi panjang: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Input tidak valid. Masukkan tinggi dengan angka positif: ");
                    sc.next();
                }
                height = sc.nextInt();
                if (height <= 0) {
                    System.out.println("Input tidak valid. Masukkan tinggi dengan angka positif: ");
                }
            } while (height <= 0);

            do {
                System.out.println("Masukkan lebar persegi panjang: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Input tidak valid. Masukkan lebar dengan angka positif: ");
                    sc.next();
                }
                width = sc.nextInt();
                if (width <= 0) {
                    System.out.println("Input tidak valid. Masukkan lebar dengan angka positif: ");
                }
            } while (width <= 0);
            shape1 = new Rectangle(width, height);
        }

        // Menampilkan informasi bangun datar
        if (shape1 != null) {
            System.out.println(shape1);
            System.out.println("Dengan luas: " + shape1.getArea());
            System.out.println("dan keliling: " + shape1.getPerimeter());
            shape1.drawIllustration();

            // Tambahan fitur
            boolean continueLoop = true;
            Geom2D shape2 = null;
            boolean hasSaved = false;
            while (continueLoop) {
                System.out.println("\nPilih opsi berikut:");
                if (!hasSaved) {
                    System.out.println("1. Tambahkan dua bangun datar");
                    System.out.println("2. Bandingkan dua bangun datar");
                    System.out.println("3. Simpan bangun datar");
                }
                System.out.println("4. Keluar");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        if (!hasSaved) {
                            System.out.println("Pilih bangun datar kedua: ");
                            shape2 = createShape(sc);
                            if (shape2 != null) {
                                double totalArea = shape1.getArea() + shape2.getArea();
                                System.out.println("Luas total dua bangun datar adalah: " + totalArea);
                            } else {
                                System.out.println("Bangun datar kedua tidak valid.");
                            }
                        }
                        break;
                    case 2:
                        if (!hasSaved) {
                            System.out.println("Pilih bangun datar kedua: ");
                            shape2 = createShape(sc);
                            if (shape2 != null) {
                                double area1 = shape1.getArea();
                                double area2 = shape2.getArea();
                                if (area1 > area2) {
                                    System.out.println("Bangun datar pertama lebih besar.");
                                } else if (area1 < area2) {
                                    System.out.println("Bangun datar kedua lebih besar.");
                                } else {
                                    System.out.println("Kedua bangun datar memiliki luas yang sama.");
                                }
                            } else {
                                System.out.println("Bangun datar kedua tidak valid.");
                            }
                        }
                        break;
                    case 3:
                        if (!hasSaved) {
                            saveShape(shape1, shape2);
                            hasSaved = true;
                        }
                        break;
                    case 4:
                        System.out.println("Keluar dari perhitungan...");
                        continueLoop = false;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        break;
                }

                if (hasSaved) {
                    System.out.println("\nPilih opsi berikut:");
                    System.out.println("1. Ulang program dari awal");
                    System.out.println("2. Keluar");

                    int nextChoice = sc.nextInt();
                    switch (nextChoice) {
                        case 1:
                            main(args);  // Restart program
                            break;
                        case 2:
                            continueLoop = false;
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                            break;
                    }
                }
            }
        }

        sc.close();
    }

    // Method untuk menyimpan gambar bangun datar
    public static void saveShape(Geom2D shape1, Geom2D shape2) {
        Scanner sc = new Scanner(System.in);

        // Ask for file name
        System.out.println("Masukkan nama file (tanpa ekstensi): ");
        String fileName = sc.nextLine();

        System.out.println("Pilih format penyimpanan: ");
        System.out.println("1. .png");
        System.out.println("2. .svg");
        System.out.println("3. .pdf");

        int formatChoice = sc.nextInt();
        switch (formatChoice) {
            case 1:
                try {
                    saveAsPNG(shape1, shape2, fileName);
                } catch (IOException e) {
                    System.out.println("Gagal menyimpan gambar sebagai .png");
                }
                break;
            case 2:
                System.out.println("Menyimpan dalam format .svg (perlu implementasi tambahan)");
                break;
            case 3:
                System.out.println("Menyimpan dalam format .pdf (perlu implementasi tambahan)");
                break;
            default:
                System.out.println("Format tidak valid.");
                break;
        }
    }

    // Method to save the shape as a .png image
    public static void saveAsPNG(Geom2D shape1, Geom2D shape2, String fileName) throws IOException {
        int width = 400;
        int height = 400;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Drawing the shape
        shape1.draw(g2d);
        if (shape2 != null) {
            g2d.translate(200, 0);
            shape2.draw(g2d);  // Draw second shape if exists
        }

        // Save image to file
        File file = new File(fileName + ".png");
        ImageIO.write(image, "png", file);
        System.out.println("Gambar berhasil disimpan sebagai '" + fileName + ".png'");

        g2d.dispose();
    }

    // Helper method to create a shape with input validation
    public static Geom2D createShape(Scanner sc) {
        int shapeChoice;
        do {
            System.out.println("Silakan pilih bangun datar: ");
            System.out.println("1. Square");
            System.out.println("2. Circle");
            System.out.println("3. Right Triangle");
            System.out.println("4. Rectangle");
            System.out.println("Masukkan pilihan Anda (1-4):");

            while (!sc.hasNextInt()) {
                System.out.println("Input tidak valid. Masukkan angka antara 1-4: ");
                sc.next();
            }
            shapeChoice = sc.nextInt();

            if (shapeChoice < 1 || shapeChoice > 4) {
                System.out.println("Input tidak valid. Silakan masukkan angka antara 1-4.");
            }
        } while (shapeChoice < 1 || shapeChoice > 4);

        Geom2D newShape = null;

        if (shapeChoice == 1) {
            int sisi;
            do {
                System.out.println("Masukkan sisi persegi: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Input tidak valid. Masukkan sisi dengan angka positif: ");
                    sc.next();
                }
                sisi = sc.nextInt();
                if (sisi <= 0) {
                    System.out.println("Input tidak valid. Masukkan sisi dengan angka positif.");
                }
            } while (sisi <= 0);
            newShape = new Square(sisi);

        } else if (shapeChoice == 2) {
            int radius;
            do {
                System.out.println("Masukkan jari-jari lingkaran: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Input tidak valid. Masukkan radius dengan angka positif: ");
                    sc.next();
                }
                radius = sc.nextInt();
                if (radius <= 0) {
                    System.out.println("Input tidak valid. Masukkan radius dengan angka positif.");
                }
            } while (radius <= 0);
            newShape = new Circle(radius);

        } else if (shapeChoice == 3) {
            int base, height;
            do {
                System.out.println("Masukkan alas segitiga: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Input tidak valid. Masukkan alas dengan angka positif: ");
                    sc.next();
                }
                base = sc.nextInt();
                if (base <= 0) {
                    System.out.println("Input tidak valid. Masukkan alas dengan angka positif.");
                }
            } while (base <= 0);

            do {
                System.out.println("Masukkan tinggi segitiga: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Input tidak valid. Masukkan tinggi dengan angka positif: ");
                    sc.next();
                }
                height = sc.nextInt();
                if (height <= 0) {
                    System.out.println("Input tidak valid. Masukkan tinggi dengan angka positif.");
                }
            } while (height <= 0);
            newShape = new RightTriangle(base, height);

        } else if (shapeChoice == 4) {
            int width, height;
            do {
                System.out.println("Masukkan lebar persegi panjang: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Input tidak valid. Masukkan lebar dengan angka positif: ");
                    sc.next();
                }
                width = sc.nextInt();
                if (width <= 0) {
                    System.out.println("Input tidak valid. Masukkan lebar dengan angka positif.");
                }
            } while (width <= 0);

            do {
                System.out.println("Masukkan tinggi persegi panjang: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Input tidak valid. Masukkan tinggi dengan angka positif: ");
                    sc.next();
                }
                height = sc.nextInt();
                if (height <= 0) {
                    System.out.println("Input tidak valid. Masukkan tinggi dengan angka positif.");
                }
            } while (height <= 0);
            newShape = new Rectangle(width, height);
        }

        return newShape;
    }
}