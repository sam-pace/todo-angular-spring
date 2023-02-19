import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { Todo } from "src/app/models/todo";
import { TodoService } from "src/app/services/todo.service";

@Component({
  selector: "app-finalizados",
  templateUrl: "./finalizados.component.html",
  styleUrls: ["./finalizados.component.css"],
})
export class FinalizadosComponent {
  listFinished: Todo[] = [];
  http: any;

  ngOnInit(): void {
    this.findAll();
  }

  constructor(private service: TodoService, private router: Router) {}

  findAll(): void {
    this.service.findAll().subscribe((resposta) => {
      resposta.forEach((todo) => {
        if (todo.finalizado) {
          this.listFinished.push(todo);
        }
      });
    });
  }

  voltar(): void {
    this.router.navigate(['']);
  }
}
