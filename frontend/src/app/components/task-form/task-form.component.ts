import { Component } from '@angular/core';
import { TaskService } from '../../services/task.service';
import { Task } from 'src/app/models/Task.model';


@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
})
export class TaskFormComponent {
  task: Task = {
    title: '',
    description: '',
    completed: false,
  };

  constructor(private taskService: TaskService) {}

  onSubmit(): void {
    if (!this.task.title || !this.task.description) return;
    this.taskService.addTask(this.task).subscribe(() => {
      this.task = { title: '', description: '', completed: false };
    });
  }
}
