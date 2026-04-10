import java.time.LocalDate;

public class Emprestimo implements Exibivel, CalculavelMulta {
    private int id;
    private Usuario usuario;
    private Material material;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataRealDevolucao;

    public Emprestimo(int id, Usuario usuario, Material material) {
        this.id = id;
        this.usuario = usuario;
        this.material = material;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = this.dataEmprestimo.plusDays(usuario.getPrazoDevolucao());
        this.dataRealDevolucao = null;
    }

    public void registrarDevolucao(LocalDate dataReal) {
        this.dataRealDevolucao = dataReal;
        this.material.aumentarEstoque();
    }

    @Override
    public double calcularMulta() {
        if (dataRealDevolucao == null || !dataRealDevolucao.isAfter(dataPrevistaDevolucao)) {
            return 0.0;
        }

        long diasAtraso = dataRealDevolucao.toEpochDay() - dataPrevistaDevolucao.toEpochDay();
        return diasAtraso * usuario.getValorMultaDiaria();
    }

    @Override
    public String exibirResumo() {
        String status = (dataRealDevolucao == null) ? "em andamento" : "devolvido!";
        return String.format("[Empréstimo %d] %s | Usuário: %s | Material: %s | Status: %s",
                id, dataEmprestimo, usuario.getNome(), material.getTitulo(), status);
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Material getMaterial() {
        return material;
    }

    public LocalDate getDataRealDevolucao() {
        return dataRealDevolucao;
    }

    public boolean isFinalizado() {

        return this.dataRealDevolucao != null;
    }
}
