function confirmarExclusao(tipo) {

    return confirm(
        "Tem certeza que deseja excluir esta " + tipo + "?"
    );
}


document.addEventListener("DOMContentLoaded", function () {

    const formConta = document.getElementById("formConta");

    if (formConta) {

        formConta.addEventListener("submit", function (event) {

            const nome = document.getElementById("nome");
            const valor = document.getElementById("valor");
            const vencimento = document.getElementById("vencimento");
            const status = document.getElementById("status");
            const pessoa = document.getElementById("pessoa");
            const categoria = document.getElementById("categoria");

            if (nome.value.trim().length < 3) {

                alert(
                    "O nome da conta deve ter pelo menos 3 caracteres."
                );

                nome.focus();
                event.preventDefault();

                return;
            }

            if (
                valor.value === "" ||
                Number(valor.value) <= 0
            ) {

                alert(
                    "Informe um valor maior que zero."
                );

                valor.focus();
                event.preventDefault();

                return;
            }

            if (vencimento.value === "") {

                alert(
                    "Informe a data de vencimento."
                );

                vencimento.focus();
                event.preventDefault();

                return;
            }

            if (status.value === "") {

                alert(
                    "Selecione o status da conta."
                );

                status.focus();
                event.preventDefault();

                return;
            }

            if (pessoa.value === "") {

                alert(
                    "Selecione uma pessoa."
                );

                pessoa.focus();
                event.preventDefault();

                return;
            }

            if (categoria.value === "") {

                alert(
                    "Selecione uma categoria."
                );

                categoria.focus();
                event.preventDefault();

                return;
            }

        });

    }


    const formPessoa = document.getElementById("formPessoa");

    if (formPessoa) {

        formPessoa.addEventListener("submit", function (event) {

            const nome = document.getElementById("nome");

            if (nome.value.trim().length < 2) {

                alert(
                    "O nome da pessoa deve ter pelo menos 2 caracteres."
                );

                nome.focus();
                event.preventDefault();
            }

        });

    }


    const formCategoria =
        document.getElementById("formCategoria");

    if (formCategoria) {

        formCategoria.addEventListener(
            "submit",
            function (event) {

                const nome =
                    document.getElementById("nome");

                if (nome.value.trim().length < 2) {

                    alert(
                        "O nome da categoria deve ter pelo menos 2 caracteres."
                    );

                    nome.focus();
                    event.preventDefault();
                }

            }
        );

    }

});