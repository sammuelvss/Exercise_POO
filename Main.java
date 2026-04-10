
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Biblioteca ===\n");

        Biblioteca bib = new Biblioteca();

        Aluno ana = new Aluno(1, "Ana", "ana@escola.com");
        Professor carlos = new Professor(2, "Carlos", "carlos@escola.com");
        bib.cadastrarUsuario(ana);
        bib.cadastrarUsuario(carlos);

        Livro livro1 = new Livro(101, 2, 2020, "Java Básico", "Pedro");
        Livro livro2 = new Livro(102, 1, 2024, "Estruturas de dados", "Maria");
        Revista revista = new Revista(103, 1, 2023, "Revista tech", "Edição Especial");
        Ebook ebook = new Ebook(104, 10, 2022, "POO em Java", "PDF", 5.5);

        bib.cadastrarMaterial(livro1);
        bib.cadastrarMaterial(livro2);
        bib.cadastrarMaterial(revista);
        bib.cadastrarMaterial(ebook);

        bib.listarUsuarios();
        bib.listarMateriais();

        System.out.println("\n=== |Empréstimos ===");

        bib.realizarEmprestimo(1, 101);
        bib.realizarEmprestimo(1, 102);
        bib.realizarEmprestimo(1, 103);
        bib.realizarEmprestimo(2, 104);

        System.out.println("\n--- tentativas inválidas ---");

        bib.realizarEmprestimo(1, 104);
        bib.realizarEmprestimo(2, 103);

        bib.listarEmprestimosEmAndamento();

        System.out.println("\n=== Simulando Devoluções ===");

        System.out.println("\nDevolvendo Livro 1 no prazo:");
        bib.registrarDevolucao(1, LocalDate.now());

        System.out.println("\nDevolvendo Livro 2 com atraso (15 dias no futuro):");
        LocalDate dataNoFuturo = LocalDate.now().plusDays(15);
        bib.registrarDevolucao(2, dataNoFuturo);

        System.out.println("\n=== ESTADO FINAL DO SISTEMA ===");
        bib.listarMateriais();
        bib.listarEmprestimosFinalizados();
        bib.listarEmprestimosEmAndamento();
    }
}