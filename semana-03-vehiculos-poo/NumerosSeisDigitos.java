import java.util.Scanner;

public class NumerosSeisDigitos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos números de 6 dígitos desea ingresar? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int num;
            while (true) {
                System.out.print("Ingrese el número de 6 dígitos (#" + i + "): ");
                num = sc.nextInt();
                if (num >= 100000 && num <= 999999) break;
                System.out.println("Número no válido. Debe tener exactamente 6 dígitos.");
            }

            int temp = num;
            int mayorPar = -1;
            int mayorImpar = -1;
            StringBuilder pares = new StringBuilder();
            StringBuilder impares = new StringBuilder();

            for (int d = 0; d < 6; d++) {
                int dig = temp % 10;
                temp /= 10;
                if (dig % 2 == 0) {
                    if (pares.length() > 0) pares.insert(0, ", ");
                    pares.insert(0, dig);
                    if (dig > mayorPar) mayorPar = dig;
                } else {
                    if (impares.length() > 0) impares.insert(0, ", ");
                    impares.insert(0, dig);
                    if (dig > mayorImpar) mayorImpar = dig;
                }
            }

            System.out.println("Número: " + num);
            System.out.println("Dígitos pares: " + (pares.length() == 0 ? "(ninguno)" : pares.toString()));
            System.out.println("Dígitos impares: " + (impares.length() == 0 ? "(ninguno)" : impares.toString()));
            if (mayorPar == -1) System.out.println("No hay dígitos pares.");
            else System.out.println("Mayor dígito par: " + mayorPar);
            if (mayorImpar == -1) System.out.println("No hay dígitos impares.");
            else System.out.println("Mayor dígito impar: " + mayorImpar);

            if (mayorPar == -1 && mayorImpar == -1) {
                System.out.println("No hay dígitos para comparar.");
            } else if (mayorPar == -1) {
                System.out.println("El mayor es impar: " + mayorImpar);
            } else if (mayorImpar == -1) {
                System.out.println("El mayor es par: " + mayorPar);
            } else if (mayorPar > mayorImpar) {
                System.out.println("El mayor entre pares e impares es par: " + mayorPar);
            } else if (mayorImpar > mayorPar) {
                System.out.println("El mayor entre pares e impares es impar: " + mayorImpar);
            } else {
                System.out.println("Los mayores son iguales: " + mayorPar);
            }

            System.out.println();
        }
    }
}
