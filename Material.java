public abstract class Material implements Exibivel {

    private int codigo, anoPublicacao, quantidadeDisponivel;
    private String titulo;

    public Material(int codigo, int anoPublicacao, int quantidadeDisponivel, String titulo) {
        this.codigo = codigo;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.titulo = titulo;
    }

    public Boolean temEstoque() {
        if (quantidadeDisponivel > 0) {
            return true;
        }
        return false;
    }

    public void reduzirEstoque() {
        quantidadeDisponivel--;
    }

    public void aumentarEstoque() {
        quantidadeDisponivel++;
    }

    public abstract String getDetalhesEspecificos();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
