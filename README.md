# Sistema de Cadastro de Usuários
[![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=java&logoColor=white)](#) [![CSV](https://img.shields.io/badge/CSV-007ACC.svg?logo=csv&logoColor=white)](#)

Organize e gerencie seus usuários facilmente com o **Sistema de Cadastro de Usuários em Java**.

## Tecnologias Utilizadas
- **Backend**: Java
- **Persistência de dados**: Arquivo CSV
- **Segurança**: Hash SHA-256 para senhas

## Funcionalidades Principais
- Adicionar, listar, buscar, atualizar e remover usuários
- Validações de email, nome e senha
- Senhas armazenadas de forma segura com hash

## Como Executar Localmente

### Pré-requisitos
- **Java**: versão mais recente ([link para download](https://www.java.com/pt-BR/download/))
- **IDE**: IntelliJ, Eclipse ou VS Code com suporte a Java

### Passos para rodar o projeto
1. Clone o repositório:
```bash
git clone <URL_DO_REPOSITORIO>
```

2. Compile e execute a classe principal:
```bash
java -cp src main.Main
```
3. Use o menu interativo no console para gerenciar os usuários.

## Estrutura do Projeto
```
src/
├─ main/
│  └─ Main.java
├─ model/
│  └─ Usuario.java
├─ service/
│  ├─ UsuarioService.java
│  ├─ UsuarioRepositoryArquivo.java
│  └─ Criptografia.java
data/
└─ usuarios.csv
```
## Exemplo do Menu no Console
```
=== Sistema de Cadastro de Usuários ===
1. Adicionar usuário
2. Listar usuários
3. Remover usuário
4. Buscar usuário
5. Atualizar usuário
0. Sair

Escolha uma opção: 1
Nome: Maria
Email: maria@email.com
Senha (mínimo 6 caracteres): ******
Usuário adicionado com sucesso!
```
## Metodologias Ágeis Aplicadas
- **Scrum**: desenvolvimento em pequenas etapas, priorizando o CRUD antes das validações
- **Kanban**: acompanhamento das tarefas do projeto de forma organizada, do início à conclusão

## Próximos Passos
- Implementar banco de dados real (SQLite ou PostgreSQL)
- Criar interface gráfica com Swing ou JavaFX
- Implementar autenticação de login
- Adicionar testes automatizados

## Autor
<img src="https://github.com/VictorHugo-Rodrigues.png" width="80" style="border-radius:50%;" align="left" />

***Victor Hugo Rodrigues***

[![LinkedIn](https://custom-icon-badges.demolab.com/badge/LinkedIn-0A66C2?logo=linkedin-white&logoColor=fff)](www.linkedin.com/in/victor-hugo-rodrigues-9100b2263) [![GitHub](https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=white)](https://www.github.com/VictorHugo-Rodrigues)