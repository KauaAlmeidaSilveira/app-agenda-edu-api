<h1 align="center" style="font-weight: bold;">AgendaEdu API 💻</h1>

<p align="center">
    <b>O "AgendaEdu" é um sistema de agendamento de salas para instituições educacionais, permitindo que professores e outros funcionários reservem espaços como salas de aula, laboratórios, teatro e auditórios.</b>
    <br><br>
    <b>API do backend para o sistema de agendamento de salas, gerenciando autenticação e agendamentos.</b> 
</p>

<h2 id="technologies">💻 Technologies</h2>

- Java
- Spring Boot
- PostgreSQL
- Docker

<h2>🚀 Pré requisitos</h3>

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/)

<h2 id="routes">📍 API Endpoints</h2>
​
Aqui estão listadas as principais rotas da API:

| Método  | Rota                                          | Descrição                                       |
|---------|-----------------------------------------------|-------------------------------------------------|
| `POST`  | `/bookings/new`                               | Cria um novo agendamento.                       |
| `PATCH` | `/bookings/disable/{bookingId}`               | Desativa um agendamento específico.             |
| `GET`   | `/bookings/{bookingId}`                       | Retorna os detalhes de um agendamento.          |
| `GET`   | `/bookings/user/bookings`                     | Retorna os agendamentos do usuário autenticado.  |
| `GET`   | `/bookings/checkout/{date}/{localId}`         | Realiza o checkout de um local em uma data.     |
| `GET`   | `/bookings/checkin/{date}/{localId}`          | Realiza o check-in de um local em uma data.     |
| `GET`   | `/bookings/all`                               | Retorna todos os agendamentos.                  |
| `POST`  | `/auth/updateToIsDisabled/{email}`            | Desativa um usuário por email.                  |
| `POST`  | `/auth/signup`                                | Registra um novo usuário.                       |
| `POST`  | `/auth/login`                                 | Autentica um usuário e retorna o token JWT.     |
| `POST`  | `/auth/forgotPassword`                        | Inicia o processo de recuperação de senha.      |
| `GET`   | `/locals`                                     | Retorna a lista de locais disponíveis.          |
| `GET`   | `/courses`                                    | Retorna a lista de cursos.                      |

## 🤝 Collaborators

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/71604993?v=4" width="100px;" alt="Kauã Almeida Profile Picture"/><br>
        <sub>
          <b>Kauã Almeida Silveira</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
