class ExploradorRapido extends Explorador implements Runnable {
    public ExploradorRapido(String nome, int prioridade, String tarefa) {
        super(nome, "Rápido", prioridade, tarefa);
    }

    public void executarTarefa() throws TarefaInvalidaException {
        if (getTarefa() == null || getTarefa().isEmpty()) {
            throw new TarefaInvalidaException("Tarefa inválida para " + getNome());
        }
        System.out.println(getNome() + " (Rápido) está correndo para: " + getTarefa());
    }

    public void run() {
        try { executarTarefa(); } catch (TarefaInvalidaException e) { System.out.println("Erro: " + e.getMessage()); }
    }
}

class ExploradorCuidadoso extends Explorador implements Runnable {
    public ExploradorCuidadoso(String nome, int prioridade, String tarefa) {
        super(nome, "Cuidadoso", prioridade, tarefa);
    }

    public void executarTarefa() throws TarefaInvalidaException {
        if (getTarefa() == null || getTarefa().isEmpty()) {
            throw new TarefaInvalidaException("Tarefa inválida para " + getNome());
        }
        System.out.println(getNome() + " (Cuidadoso) está mapeando com cuidado: " + getTarefa());
    }

    public void run() {
        try { executarTarefa(); } catch (TarefaInvalidaException e) { System.out.println("Erro: " + e.getMessage()); }
    }
}
