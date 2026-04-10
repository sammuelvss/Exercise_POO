import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Biblioteca {
    // Listas obrigatórias exigidas no PDF
    private List<Usuario> usuarios;
    private List<Material> materiais;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.materiais = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario u) {
        this.usuarios.add(u);
    }

    public void cadastrarMaterial(Material m) {
        this.materiais.add(m);
    }

    public Usuario buscarUsuario(int codigo) {
        for (Usuario u : usuarios) {
            if (u.getCodigo() == codigo)
                return u;
        }
        return null;
    }

    public Material buscarMaterial(int codigo) {
        for (Material m : materiais) {
            if (m.getCodigo() == codigo)
                return m;
        }
        return null;
    }

    public Emprestimo buscarEmprestimo(int id) {
        for (Emprestimo e : emprestimos) {
            if (e.getId() == id)
                return e;
        }
        return null;
    }

    public int contarEmprestimosAtivos(Usuario u) {
        int cont = 0;
        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().equals(u) && !e.isFinalizado()) {
                cont++;
            }
        }
        return cont;
    }

    public boolean realizarEmprestimo(int codUsuario, int codMaterial) {
        Usuario u = buscarUsuario(codUsuario);
        Material m = buscarMaterial(codMaterial);

        if (u == null || m == null) {
            System.out.println("Erro: Usuário ou Material não encontrado");
            return false;
        }

        if (!m.temEstoque()) {
            System.out.println("Erro: material esgotado no momento.");
            return false;
        }

        if (contarEmprestimosAtivos(u) >= u.getLimiteEmprestimos()) {
            System.out.println("Erro: Limite de empréstimos atingido para o usuário " + u.getNome());
            return false;
        }

        int novoId = emprestimos.size() + 1;
        Emprestimo novoEmprestimo = new Emprestimo(novoId, u, m);
        emprestimos.add(novoEmprestimo);
        m.reduzirEstoque();

        System.out.println("Sucesso! Empréstimo [ID " + novoId + "] realizado para " + u.getNome());
        return true;
    }

    public boolean registrarDevolucao(int idEmprestimo, LocalDate dataReal) {
        Emprestimo e = buscarEmprestimo(idEmprestimo);

        if (e == null) {
            System.out.println("Empréstimo não encontrado.");
            return false;
        }

        if (e.isFinalizado()) {
            System.out.println("Este empréstimo já foi finalizado.");
            return false;
        }

        e.registrarDevolucao(dataReal);
        System.out.println("Devolução registrada com sucesso! Multa: R$ " + e.calcularMulta());
        return true;
    }

    public void listarUsuarios() {
        System.out.println("\n--- USUÁRIOS CADASTRADOS ---");
        for (Usuario u : usuarios) {
            System.out.println(u.exibirResumo());
        }
    }

    public void listarMateriais() {
        System.out.println("\n--- MATERIAIS DiSPONIVEIS ---");
        for (Material m : materiais) {
            System.out.println(m.exibirResumo() + " | Extra: " + m.getDetalhesEspecificos());
        }
    }

    public void listarEmprestimosEmAndamento() {
        System.out.println("\n--- EMPRÉSTIMOS EM ANDAMENTO ---");
        for (Emprestimo e : emprestimos) {
            if (!e.isFinalizado()) {
                System.out.println(e.exibirResumo());
            }
        }
    }

    public void listarEmprestimosFinalizados() {
        System.out.println("\n--- EMPRÉSTIMOS FINALIZADOS ---");
        for (Emprestimo e : emprestimos) {
            if (e.isFinalizado()) {
                System.out.println(e.exibirResumo() + " | Multa: R$ " + e.calcularMulta());
            }
        }
    }
}