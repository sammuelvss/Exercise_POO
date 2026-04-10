public class Ebook extends Material {
    private String formato;
    private double tamanhoArquivo;

    public Ebook(int codigo, int anoPublicacao, int quantidadeDisponivel, String titulo, String formato,
            double tamanhoArquivo) {
        super(codigo, anoPublicacao, quantidadeDisponivel, titulo);
        this.formato = formato;
        this.tamanhoArquivo = tamanhoArquivo;
    }

    @Override
    public String exibirResumo() {
        return "(Ebook) = " + getTitulo() + " | formato: " + formato + " | Qtd: " + getQuantidadeDisponivel();
    }

    @Override
    public String getDetalhesEspecificos() {
        return "formato: " + this.formato + "Tamanho do arquivo: " + this.tamanhoArquivo + "mb";
    }

    public String getformato() {
        return formato;
    }

    public void setformato(String formato) {
        this.formato = formato;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }
}
