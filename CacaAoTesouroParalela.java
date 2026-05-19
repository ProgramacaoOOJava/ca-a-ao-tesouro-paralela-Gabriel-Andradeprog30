import java.util.ArrayList;
import java.util.Scanner;

public class CacaAoTesouroParalela {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Thread> threads = new ArrayList<>();
        
        System.out.println("=== CAÇA AO TESOURO PARALELA ===\n");
        System.out.println("Exploradores em ação: threads, prioridades e exceções em Java\n");
        
        for (int i = 1; i <= 4; i++) {
            System.out.println("Cadastro do explorador " + i + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Tipo (Rápido/Cuidadoso): ");
            String tipo = scanner.nextLine();
            
            System.out.print("Local a explorar: ");
            String tarefa = scanner.nextLine();
            
            Explorador explorador;
            if (tipo.equalsIgnoreCase("Rápido")) {
                explorador = new ExploradorRapido(nome, tarefa);
            } else {
                explorador = new ExploradorCuidadoso(nome, tarefa);
            }
            
            Thread thread = new Thread(explorador);
            thread.setPriority(explorador.prioridade);
            threads.add(thread);
            System.out.println();
        }
        
        System.out.println("\n=== INFORMAÇÕES DAS THREADS ===");
        for (int i = 0; i < threads.size(); i++) {
            Thread t = threads.get(i);
            System.out.println("Thread " + (i+1) + " - ID: " + t.threadId() + 
                             " | Prioridade: " + t.getPriority() + 
                             " | Estado: " + t.getState());
        }
        
        System.out.println("\n=== INICIANDO EXPLORAÇÃO ===");
        for (Thread thread : threads) {
            thread.start();
        }
        
        System.out.println("\n=== AGUARDANDO CONCLUSÃO DOS EXPLORADORES ===");
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        
        System.out.println("\n=== VERIFICANDO ESTADO FINAL DAS THREADS ===");
        for (int i = 0; i < threads.size(); i++) {
            Thread t = threads.get(i);
            System.out.println("Thread " + (i+1) + " - ID: " + t.threadId() + 
                             " | Estado final: " + t.getState());
        }
        
        System.out.println("\n=== CAÇA AO TESOURO PARALELA FINALIZADA ===");
        System.out.println("Todos os exploradores principais completaram suas missões!");
        
        scanner.close();
    }
}
