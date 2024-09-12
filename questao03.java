import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String jsonData = "{"
                + "\"faturamento_diario\": [0, 221.5, 345.0, 0, 567.8, 100.0, 450.0, 0, 300.0, 220.5, 400.0, 0, 380.5, 470.0, 0, 0, 290.0, 150.0, 0, 210.0, 240.5, 0, 410.0, 0, 390.0, 600.0, 0, 200.0, 310.0, 0]"
                + "}";

        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray faturamentoDiario = jsonObject.getJSONArray("faturamento_diario");

        double menorFaturamento = Double.MAX_VALUE;
        double maiorFaturamento = Double.MIN_VALUE;
        double somaFaturamento = 0;
        int diasComFaturamento = 0;

        for (int i = 0; i < faturamentoDiario.length(); i++) {
            double faturamento = faturamentoDiario.getDouble(i);

            if (faturamento > 0) { // Ignorando dias sem faturamento
                if (faturamento < menorFaturamento) {
                    menorFaturamento = faturamento;
                }
                if (faturamento > maiorFaturamento) {
                    maiorFaturamento = faturamento;
                }
                somaFaturamento += faturamento;
                diasComFaturamento++;
            }
        }

        // média mensal
        double mediaMensal = somaFaturamento / diasComFaturamento;
        
        // faturamento superior à média
        int diasAcimaDaMedia = 0;
        for (int i = 0; i < faturamentoDiario.length(); i++) {
            double faturamento = faturamentoDiario.getDouble(i);
            if (faturamento > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }
        
        System.out.println("Menor faturamento: " + menorFaturamento);
        System.out.println("Maior faturamento: " + maiorFaturamento);
        System.out.println("Média mensal: " + mediaMensal);
        System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}
