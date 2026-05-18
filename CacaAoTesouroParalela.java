import java.util.ArrayList;

public class CacaAoTesouroParalela {
    
    public static void main(String[] args) {
        System.out.println("=== CAÇA AO TESOURO PARALELA ===");
        System.out.println("Exploradores em ação: threads, prioridades e exceções em Java\n");
        
        // 1. Lista para gerenciar as threads
        ArrayList<Thread> listaDeThreads = new ArrayList<>();
        
        // 2. Criando exploradores
        ExploradorRapido exp1 = new ExploradorRapido("Alice", Thread.MAX_PRIORITY, "Vasculhar a caverna");
        ExploradorRapido exp2 = new ExploradorRapido("Bruno", Thread.MAX_PRIORITY, "Explorar o pico");
        
        ExploradorCuidadoso exp3 = new ExploradorCuidadoso("Clara", Thread.MIN_PRIORITY, ""); // Inválida
        ExploradorCuidadoso exp4 = new ExploradorCuidadoso("Daniel", Thread.MIN_PRIORITY, "Mapear a floresta");
        
        // 3. Encapsulando exploradores em threads
        Thread t1 = new Thread(exp1);
        Thread t2 = new Thread(exp2);
        Thread t3 = new Thread(exp3);
        Thread t4 = new Thread(exp4);
        
        // 4. Configurando prioridades
        t1.setPriority(exp1.getPrioridade());
        t2.setPriority(exp2.getPrioridade());
        t3.setPriority(exp3.getPrioridade());
        t4.setPriority(exp4.getPrioridade());
        
        // 5. Configurando threads cuidadosas como daemon
        t3.setDaemon(true);
        t4.setDaemon(true);
        
        // 6. Adicionando à lista
        listaDeThreads.add(t1);
        listaDeThreads.add(t2);
        listaDeThreads.add(t3);
        listaDeThreads.add(t4);
        
        // 7. Exibindo status inicial
        System.out.println("\n=== INFORMAÇÕES DAS THREADS ===");
        exp1.exibirStatus();
        exp2.exibirStatus();
        exp3.exibirStatus();
        exp4.exibirStatus();
        
        // 8. Iniciando a exploração
        System.out.println("\n=== INICIANDO EXPLORAÇÃO ===");
        for (Thread t : listaDeThreads) {
            t.start();
        }
        
        // 9. Aguardando conclusão (usamos join para garantir ordem)
        System.out.println("\n=== AGUARDANDO CONCLUSÃO DOS EXPLORADORES ===");
        for (Thread t : listaDeThreads) {
            try {
                if (t.isAlive()) {
                    t.join(500); // Aguarda um pouco por cada thread
                }
            } catch (InterruptedException e) {
                System.out.println("A exploração foi interrompida.");
            }
        }
        
        // 10. Verificando estado final
        System.out.println("\n=== ESTADO FINAL DAS THREADS ===");
        for (Thread t : listaDeThreads) {
            System.out.println("Thread " + t.getId() + " finalizada? " + (t.getState() == Thread.State.TERMINATED));
        }
        
        System.out.println("\n=== CAÇA AO TESOURO PARALELA FINALIZADA ===");
    }
}
