public class ExploradorCuidadoso extends Explorador {
    public ExploradorCuidadoso(String nome, String tarefa) {
        super(nome, "Cuidadoso", Thread.MIN_PRIORITY, tarefa);
    }
    
    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        System.out.println("Explorador: " + nome + " | Tipo: " + tipo + 
                         " | Status: Mapeando " + tarefa + " cuidadosamente.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Explorador: " + nome + " | Tipo: " + tipo + 
                         " | Status: Exploração de " + tarefa + " concluído(a).");
    }
}
