import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe uma string: ");
        String input = scanner.nextLine();
        
        // Convertendo a string para array
        char[] caracteres = input.toCharArray();
        
        // Invertendo
        String invertida = "";
        for (int i = caracteres.length - 1; i >= 0; i--) {
            invertida += caracteres[i];
        }
        
        System.out.println("String invertida: " + invertida);
        
        scanner.close();
    }
}
