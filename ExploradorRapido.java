public class ExploradorRapido extends Explorador {
    public ExploradorRapido(String nome, String tarefa) {
        super(nome, "Rápido", Thread.MAX_PRIORITY, tarefa);
    }
    
    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        System.out.println("Explorador: " + nome + " | Tipo: " + tipo + 
                         " | Status: Desbravando " + tarefa + " rapidamente.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Explorador: " + nome + " | Tipo: " + tipo + 
                         " | Status: " + tarefa + " completamente explorada(s)");
    }
}
