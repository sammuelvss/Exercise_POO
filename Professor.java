public class Professor extends Usuario {

    public Professor(int codigo, String nome, String email) {
        super(codigo, nome, email);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 5;
    }

    @Override
    public int getPrazoDevolução() {

        return 14;
    }

    @Override
    public double getValorMultaDiaria() {

        return 1.00;
    }

    @Override
    public String getTipoUsuario() {
        return "Professor";
    }

    @Override
    public String exibirResumo() {
        return "(PROFESSOR) Código: " + getCodigo() + " | Nome: " + getNome() + " | Email: " + getEmail();

    }
}
