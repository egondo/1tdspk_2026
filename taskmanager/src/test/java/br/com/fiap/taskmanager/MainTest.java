    package br.com.fiap.taskmanager;

        import br.com.fiap.taskmanager.model.Task;
        import br.com.fiap.taskmanager.service.TaskService;
        import org.springframework.stereotype.Controller;

        import java.time.LocalDate;

        @Controller
        public class MainTest {

            private TaskService taskService;

            public TaskService getTaskService() {
                return taskService;
            }

            public static void main(String[] args) {

                    MainTest m = new MainTest();
                    TaskService taskService = m.getTaskService();
                    System.out.println("--- Teste 1: Data no Passado (Deve lançar exceção) ---");
                    Task tarefaPassado = new Task();
                    tarefaPassado.setData(LocalDate.now().minusDays(1));

                    try {
                        taskService.save(tarefaPassado);
                        System.out.println("ERRO: O sistema permitiu salvar uma tarefa com data no passado!");
                    } catch (RuntimeException e) {
                        System.out.println("SUCESSO: Exceção bloqueou o salvamento. Mensagem: " + e.getMessage());
                    }

                    System.out.println("\n--- Teste 2: Data no Futuro (Deve salvar com sucesso) ---");
                    Task tarefaFuturo = new Task();
                    tarefaFuturo.setData(LocalDate.now().plusDays(2));

                    try {
                        Task resultado = taskService.save(tarefaFuturo);
                        System.out.println("SUCESSO: Tarefa salva. Data de criação preenchida com: " + resultado.getCriacao());
                    } catch (RuntimeException e) {
                        System.out.println("ERRO: O sistema falhou ao salvar uma tarefa válida. Mensagem: " + e.getMessage());
                    }
                }
            }

