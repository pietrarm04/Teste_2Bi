
## **Resultados dos testes**

Executei os testes utilizando o comando `mvn test` e todos passaram.

- **Total de testes:** 5
- **Falhas:** 0
- **Erros:** 0
- **Ignorados:** 0
- **Resultado:** `BUILD SUCCESS`

### **Exercício 1 — Testes do serviço**

No primeiro exercício, testei o cadastro de um produto, a validação do nome em branco e a atualização do preço. Também consultei o repositório para verificar se os dados foram persistidos corretamente.

### **Exercício 2 — Testes da API**

No segundo exercício, testei o cadastro e a consulta de produtos pela API. Utilizei o `MockMvc` para simular as requisições HTTP e verificar se as respostas retornavam os dados esperados.

### **Isolamento dos testes**

Utilizei a anotação `@Transactional` para ajudar a isolar os testes. Ao final de cada teste, a transação normalmente é revertida, evitando que as alterações realizadas interfiram nos testes seguintes.

<img width="1147" height="332" alt="image" src="https://github.com/user-attachments/assets/4a20d5f7-fd3a-4a7d-88bd-e2f5a4050705" />


### **Evidência da execução**

A execução do comando `mvn test` apresentou o resultado `BUILD SUCCESS`, com cinco testes executados e nenhuma falha ou erro.

