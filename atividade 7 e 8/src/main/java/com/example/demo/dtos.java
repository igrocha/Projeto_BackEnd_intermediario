import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

class ClienteDTO {
    private String nome;
    private Double saldo;

    // Construtor, Getters e Setters omitidos para brevidade
}

class TransacaoDTO {
    @NotBlank(message = "O pagador é obrigatório")
    private String pagador;

    @NotBlank(message = "O recebedor é obrigatório")
    private String recebedor;

    @Positive(message = "A quantidade deve ser maior que zero")
    private Double quantidade;

    // Getters e Setters omitidos para brevidade
}
