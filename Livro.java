public class Livro extends Material {
    private String autor;

    public Livro(int codigo, int anoPublicacao, int quantidadeDisponivel, String titulo, String autor) {
        super(codigo, anoPublicacao, quantidadeDisponivel, titulo);
        this.autor = autor;
    }

    @Override
    public String exibirResumo() {
        return "(LIVRO) = " + getTitulo() + " | Autor: " + autor + " | Qtd: " + getQuantidadeDisponivel();
    }

    @Override
    public String getDetalhesEspecificos() {
        return "Autor: " + this.autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
