  import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {
  selected = '';
  items = [
    {text: 'Refresh'},
    {text: 'Settings'},
    {text: 'Help', disabled: true},
    {text: 'Sign Out'}
  ];

  iconItems = [
    {text: 'New', icon: 'new_releases', route: 'list'},
    {text: 'Stream', icon: 'airplay', route: 'form'},
    {text: 'Disable alerts', icon: 'notifications_off', route: 'list'}
  ];
  constructor() { }

  ngOnInit() {
  }

}
