import java.util.Scanner;

import FlatFigures.Circle;
import FlatFigures.EquilateralTriangle;
import FlatFigures.FlatFigures;
import FlatFigures.Hexagon;
import FlatFigures.Rectangle;
import FlatFigures.Square;

import SpaceFigures.Cobble;
import SpaceFigures.Cone;
import SpaceFigures.Cube;
import SpaceFigures.Cylinder;
import SpaceFigures.Sphere;
import SpaceFigures.SquareBasePyramid;


public class Main {
    static void calcAreaPerimeter(FlatFigures objectFigure) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("[0] Calculate area\n[1] Calculate perimeter\n >> ");
        String answer = scanner.next();
        if (answer == "0") {
            double area = objectFigure.calcArea();
            System.out.println("Area: " + area);
        } else {
            double perimeter = objectFigure.calcPerimeter();
            System.out.println("Perimeter: " + perimeter);
        }
    
        scanner.close();
    }

    // static void calcAreaPerimeter(FlatFigures objectFigure) {
    //     Scanner scanner = new Scanner(System.in);

    //     System.out.print("[0] Calculate area\n[1] Calculate perimeter\n >> ");
    //     String answer = scanner.next();
    //     if (answer == "0") {
    //         double area = objectFigure.calcArea();
    //         System.out.println("Area: " + area);
    //     } else {
    //         double perimeter = objectFigure.calcPerimeter();
    //         System.out.println("Perimeter: " + perimeter);
    //     }
    
    //     scanner.close();
    // }
    
    static void useFlatFigures(int figureChoice) {
        Scanner scanner = new Scanner(System.in);
        boolean thereErrors = true;
            while (thereErrors) {
                try {
                    switch (figureChoice) {
                        case 0:
                            System.out.print("Diameter >> ");
                            double diameter = scanner.nextDouble();
                            Circle circle = new Circle(diameter);
                            calcAreaPerimeter(circle);
                            break;
                        case 1:
                            System.out.print("Side >> ");
                            double sideEqT = scanner.nextDouble();
                            EquilateralTriangle eqTriangle = new EquilateralTriangle(sideEqT);
                            calcAreaPerimeter(eqTriangle);
                            break;
                        case 2:
                            System.out.print("Side >> ");
                            double sideHex = scanner.nextDouble();
                            Hexagon hexagon = new Hexagon(sideHex);
                            calcAreaPerimeter(hexagon);                          
                            break;
                        case 3:
                            System.out.print("Small Side >> ");
                            double smallSideRec = scanner.nextDouble();
                            System.out.print("Big Side >> ");
                            double bigSideRec = scanner.nextDouble();
                            Rectangle rectangle = new Rectangle(smallSideRec, bigSideRec);
                            calcAreaPerimeter(rectangle);                          
                            break;
                        case 4:
                            System.out.print("Side >> ");
                            double sideSqr = scanner.nextDouble();
                            Square square = new Square(sideSqr);
                            calcAreaPerimeter(square);                          
                            break;
                        default:
                            break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid Value!");
                    scanner.nextLine();
                    continue;
                }   
                thereErrors = false;
            }
            scanner.close();
    }

    static void useSpaceFigures(int figureChoice) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean exit = true;
        int figureChoice = 0;
        while (exit) {
            try {
                System.out.print("[0] Exit\n[1] Flat Figure\n[2] Space Figure\n>>");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        exit = false;
                        break;
                    case 1:
                        System.out.println("Choose a Flat Figure");
                        System.out.print("[0] Circle\n[1] Equilateral Triangle\n[2] Hexagon\n[3] Rectangle\n[4] Square\n>>");
                        figureChoice = scanner.nextInt();
                        useFlatFigures(figureChoice);
                        break;
                    case 2:
                        System.out.println("Choose a Space Figure");
                        System.out.print("[0] Cobble\n[1] Cone\n[2] Cube\n[3] Cylinder\n[4] Sphere\n[5] Square Base Pyramid\n>> ");
                        figureChoice = scanner.nextInt();
                        break;
                    default:
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid Value!");
                scanner.nextLine();
                continue;
            }

            
        } 
        scanner.close();
    }
}
