# BrasilForm

Projeto criado para demonstrar os tratamentos de dados utilizados no 
Brasil como CPF (ou CNPJ), Titulo de eleitor e data.

O Documento CPF é composto por uma sequência de 11 dígitos sendo que os 9 primeiros são dígitos comuns e os 2 últimos são os verificadores.

A regra de validação do CPF consiste em multiplicar os dígitos ([0-9] no primeiro dígito verificador e [1,10] para o segundo dígito verificador) em uma sequência decrescente (de 10 até 2) somá-los, multiplicar a soma por 10 e então dividir o resultado por onze. 

Deve-se pegar o resto da divisão e verificar se ele é igual ao digito verificador, se sim para os dois dígitos verificadores o documento fornecido é válido.


