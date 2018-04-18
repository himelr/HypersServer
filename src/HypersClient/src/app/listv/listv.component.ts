import { Component, OnInit } from '@angular/core';
import {MatDatepickerInputEvent} from '@angular/material/datepicker';

@Component({
  selector: 'app-listv',
  templateUrl: './listv.component.html',
  styleUrls: ['./listv.component.css']
})
export class ListvComponent implements OnInit {
  events: string[] = [];

  addEvent(type: string, event: MatDatepickerInputEvent<Date>) {
    this.events.push(`${type}: ${event.value}`);
  }
  constructor() { }

  ngOnInit() {
  }

}
