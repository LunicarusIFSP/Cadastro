package atividade.cadastro

data class Formulario(
    val nome: String,
    val telefone: String,
    val email: String,
    val ingressarEmail: Boolean,
    val sexo: String,
    val cidade: String,
    val estado: String
) {
    override fun toString(): String {
        val ingressar = if (ingressarEmail) "Sim" else "Não"
        return  "Nome: $nome, " +
                "Sexo: $sexo, " +
                "Telefone: $telefone, " +
                "Email: $email, Ingressar no Email: $ingressar," +
                "Cidade: $cidade, " +
                "Estado: $estado"
    }
}
