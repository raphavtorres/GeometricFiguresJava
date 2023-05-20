import java.util.InputMismatchException;
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
import SpaceFigures.SpaceFigures;
import SpaceFigures.Sphere;
import SpaceFigures.SquareBasePyramid;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    static void calcAreaPerimeter(FlatFigures objectFigure) {
        System.out.print("[0] Calculate area\n[1] Calculate perimeter\n >> ");
        String answer = scanner.next();
        if (answer == "0") {
            double area = objectFigure.calcArea();
            System.out.println("Area: " + area);
        } else {
            double perimeter = objectFigure.calcPerimeter();
            System.out.println("Perimeter: " + perimeter);
        }
    }

    static void calcVolumeSuperfArea(SpaceFigures objectFigure) {
        System.out.print("[0] Calculate area\n[1] Calculate perimeter\n >> ");
        String answer = scanner.next();
        if (answer == "0") {
            double area = objectFigure.calcVolume();
            System.out.println("Area: " + area);
        } else {
            double perimeter = objectFigure.calcSuperficialArea();
            System.out.println("Perimeter: " + perimeter);
        }
    }

    static double testNegative(Scanner scanner) {
        double value = scanner.nextDouble();
        if (value < 0) {
            throw new InputMismatchException();
        }
        return value;
    }
    
    static void useFlatFigures(int figureChoice) {
        boolean thereErrors = true;
        while (thereErrors) {
            try {
                switch (figureChoice) {
                    case 0:
                        System.out.print("Diameter >> ");
                        double diameter = testNegative(scanner);
                        Circle circle = new Circle(diameter);
                        calcAreaPerimeter(circle);
                        break;
                    case 1:
                        System.out.print("Side >> ");
                        double sideEqT = testNegative(scanner);
                        EquilateralTriangle eqTriangle = new EquilateralTriangle(sideEqT);
                        calcAreaPerimeter(eqTriangle);
                        break;
                    case 2:
                        System.out.print("Side >> ");
                        double sideHex = testNegative(scanner);
                        Hexagon hexagon = new Hexagon(sideHex);
                        calcAreaPerimeter(hexagon);                          
                        break;
                    case 3:
                        System.out.print("Small Side >> ");
                        double smallSideRec = testNegative(scanner);
                        System.out.print("Big Side >> ");
                        double bigSideRec = testNegative(scanner);
                        Rectangle rectangle = new Rectangle(smallSideRec, bigSideRec);
                        calcAreaPerimeter(rectangle);                          
                        break;
                    case 4:
                        System.out.print("Side >> ");
                        double sideSqr = testNegative(scanner);
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
    }

    static void useSpaceFigures(int figureChoice) {
        boolean thereErrors = true;
        while (thereErrors) {
            try {
                switch (figureChoice) {
                    case 0:
                        System.out.print("Small Side >> ");
                        double smallSideCobble = testNegative(scanner);
                        System.out.print("Big Side >> ");
                        double bigSideCobble = testNegative(scanner);
                        System.out.print("Height >> ");
                        double heightCobble = testNegative(scanner);
                        Cobble cobble = new Cobble(smallSideCobble, bigSideCobble, heightCobble);
                        calcVolumeSuperfArea(cobble);
                        break;
                    case 1:
                        System.out.print("Radius >> ");
                        double radiusCone = testNegative(scanner);
                        System.out.print("Geratrix >> ");
                        double greatrixCone = testNegative(scanner);
                        System.out.print("Height >> ");
                        double heightCone = testNegative(scanner);
                        Cone cone = new Cone(radiusCone, greatrixCone, heightCone);
                        calcVolumeSuperfArea(cone);
                        break;
                    case 2:
                        System.out.print("Side >> ");
                        double sideCube = testNegative(scanner);
                        Cube cube = new Cube(sideCube);
                        calcVolumeSuperfArea(cube);
                        break;
                    case 3:
                        System.out.print("Height >> ");
                        double heightCylinder = testNegative(scanner);
                        System.out.print("Radius >> ");
                        double radiusCylinder = testNegative(scanner);
                        Cylinder cylinder = new Cylinder(heightCylinder, radiusCylinder);
                        calcVolumeSuperfArea(cylinder);
                        break;
                    case 4:
                        System.out.print("Radius >> ");
                        double radiusSphere = testNegative(scanner);
                        Sphere sphere = new Sphere(radiusSphere);
                        calcVolumeSuperfArea(sphere);
                        break;
                    case 5:
                        System.out.print("Height >> ");
                        double heightSqrBP = testNegative(scanner);
                        System.out.print("Side >> ");
                        double sideSqrBP = testNegative(scanner);
                        SquareBasePyramid sqrBP = new SquareBasePyramid(heightSqrBP, sideSqrBP);
                        calcVolumeSuperfArea(sqrBP);
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
    }

    public static void main (String[] args) {
        boolean exit = true;
        int figureChoice = 0;
        while (exit) {
            try {
                System.out.print("[0] Exit\n[1] Flat Figure\n[2] Space Figure\n >> ");
                int choice = scanner.nextInt();
                // scanner.nextLine();
                switch (choice) {
                    case 0:
                        exit = false;
                        break;
                    case 1:
                        System.out.println("Choose a Flat Figure");
                        System.out.print("[0] Circle\n[1] Equilateral Triangle\n[2] Hexagon\n[3] Rectangle\n[4] Square\n >> ");
                        figureChoice = scanner.nextInt();
                        useFlatFigures(figureChoice);
                        break;
                    case 2:
                        System.out.println("Choose a Space Figure");
                        System.out.print("[0] Cobble\n[1] Cone\n[2] Cube\n[3] Cylinder\n[4] Sphere\n[5] Square Base Pyramid\n >> ");
                        figureChoice = scanner.nextInt();
                        useSpaceFigures(figureChoice);
                        break;
                    default:
                        throw new InputMismatchException();
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
