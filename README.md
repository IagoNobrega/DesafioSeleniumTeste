# 🧪 Desafio Selenium - Automação de Testes

Projeto de automação de testes web utilizando **Selenium WebDriver**, **Cucumber (BDD)** e **JUnit 5**, desenvolvido em **Java**.

O objetivo do projeto é automatizar um cenário de geração de cupom de desconto no site da Qazando, aplicando boas práticas como **Page Object Model (POM)** e organização de testes BDD.

---

# 🚀 Tecnologias utilizadas

* Java 17
* Selenium WebDriver
* Cucumber (BDD)
* JUnit 5
* Maven
* WebDriverManager
* IntelliJ IDEA

---

# 📂 Estrutura do Projeto

```
src
 └ test
    ├ java
    │
    │  ├ runner
    │  │   RunCucumberTest.java
    │  │
    │  ├ steps
    │  │   Hooks.java
    │  │   QazandoSteps.java
    │  │
    │  └ pages
    │      HomePage.java
    │
    └ resources
       └ features
           desconto.feature
```

### Descrição das pastas

| Pasta    | Descrição                                 |
| -------- | ----------------------------------------- |
| runner   | Classe responsável por executar os testes |
| steps    | Implementação dos passos do Cucumber      |
| pages    | Page Objects da aplicação                 |
| features | Cenários de teste em Gherkin              |

---

# 🧩 Padrão utilizado

O projeto utiliza o padrão **Page Object Model (POM)**, que separa:

* lógica dos testes
* elementos da página
* ações da página

Isso torna o código mais:

* reutilizável
* organizado
* fácil de manter

---

# 🧪 Cenário automatizado

Arquivo: `desconto.feature`

```gherkin
Funcionalidade: Gerar cupom de desconto

Cenario: visualiza código de desconto
Dado que estou no site da qazando
Quando eu preencha meu e-mail
E clico em ganhar cupom
Então eu vejo o código de desconto
```

---

# ⚙️ Como executar o projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/IagoNobrega/DesafioSeleniumTeste.git
```

---

### 2️⃣ Abrir o projeto

Abra o projeto no **IntelliJ IDEA**.

---

### 3️⃣ Instalar dependências

O Maven instalará automaticamente as dependências:

```bash
mvn clean install
```

---

### 4️⃣ Executar os testes

Execute a classe:

```
RunCucumberTest
```

O navegador **Chrome** abrirá automaticamente e executará o teste.

---

# 🧠 Boas práticas aplicadas

✔ Page Object Model
✔ Estrutura organizada
✔ Reutilização de código
✔ Hooks para setup e teardown
✔ WebDriverManager para gerenciamento automático do driver

---

# 📊 Melhorias futuras

* Geração de relatório HTML
* Screenshots automáticos em falhas
* Execução paralela de testes
* Integração com CI/CD

---

# 👨‍💻 Autor

Projeto desenvolvido por **Iago Nóbrega** para prática de **automação de testes web com Selenium e Cucumber**.

---

# ⭐ Contribuição

Contribuições são bem-vindas!

Caso queira contribuir:

1. Faça um fork do projeto
2. Crie uma branch
3. Envie um pull request
