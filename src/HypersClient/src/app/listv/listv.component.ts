import { Book } from './../book.model';
import { ActorService } from './../actors/actor.service';
import { Component, OnInit } from '@angular/core';
import {MatDatepickerInputEvent} from '@angular/material/datepicker';

@Component({
  selector: 'app-listv',
  templateUrl: './listv.component.html',
  styleUrls: ['./listv.component.css']
})

export class ListvComponent implements OnInit {
  books: Book[];
  constructor(private actorService: ActorService) { }

  ngOnInit() {
    this.actorService.getBooks().subscribe(books => this.books = books);
  }

}
