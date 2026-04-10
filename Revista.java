public class Revista extends Material {
    private String edicao;

    public Revista(int codigo, int anoPublicacao, int quantidadeDisponivel, String titulo, String edicao) {
        super(codigo, anoPublicacao, quantidadeDisponivel, titulo);
        this.edicao = edicao;
    }

    @Override
    public String exibirResumo() {
        return "(REVISTA) = " + getTitulo() + " | edicao: " + edicao + " | Qtd: " + getQuantidadeDisponivel();
    }

    @Override
    public String getDetalhesEspecificos() {
        return "edicao: " + this.edicao;
    }

    public String getedicao() {
        return edicao;
    }

    public void setedicao(String edicao) {
        this.edicao = edicao;
    }
}
