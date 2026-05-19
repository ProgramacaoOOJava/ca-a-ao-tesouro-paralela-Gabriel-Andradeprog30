import java.util.ArrayList;

public class CacaAoTesouroParalela {
    
    public static void main(String[] args) {
        // 2. Criando exploradores
        ExploradorRapido exp1 = new ExploradorRapido("Alice", 10, "Vasculhar a caverna");
        ExploradorCuidadoso exp4 = new ExploradorCuidadoso("Bob", 1, "Mapear a floresta");
        ExploradorCuidadoso exp3 = new ExploradorCuidadoso("Clara", 5, ""); // Inválida

        // Lista de exploradores para processamento
        ArrayList<Explorador> exploradores = new ArrayList<>();
        exploradores.add(exp1);
        exploradores.add(exp4);
        exploradores.add(exp3);

        // 7. Exibindo status inicial e tratando erro da Clara
        for (Explorador e : exploradores) {
            try {
                // Validação manual para imprimir o status ou capturar o erro
                if (e.getTarefa() == null || e.getTarefa().isEmpty()) {
                    throw new Exception("Tarefa inválida para " + e.getNome());
                }
                
                // Imprime status normal
                System.out.println("Explorador: " + e.getNome());
                System.out.println("Tipo: " + e.getTipo());
                System.out.println("Prioridade: " + e.getPrioridade());
                System.out.println("Tarefa: " + e.getTarefa());
                System.out.println("Status: Iniciando exploração...\n");
                
                // Inicia a thread apenas se for válida
                new Thread(e).start();
                
            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage() + "\n");
            }
        }
    }
}
