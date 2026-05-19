public abstract class Explorador implements Runnable {
    protected String nome;
    protected String tipo;
    protected int prioridade;
    protected String tarefa;
    
    public Explorador(String nome, String tipo, int prioridade, String tarefa) {
        this.nome = nome;
        this.tipo = tipo;
        this.prioridade = prioridade;
        this.tarefa = tarefa;
    }
    
    public abstract void executarTarefa() throws TarefaInvalidaException;
    
    @Override
    public void run() {
        try {
            if (tarefa == null || tarefa.trim().isEmpty()) {
                throw new TarefaInvalidaException("Tarefa inválida para " + nome);
            }
            executarTarefa();
        } catch (TarefaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
