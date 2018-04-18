import { NgModule } from '@angular/core';

import {
  MatButtonModule,
  MatMenuModule,
  MatToolbarModule,
  MatIconModule,
  MatCardModule,
  MatSidenavModule,
  MatDatepickerModule,
  MatFormFieldModule,
  MatNativeDateModule,
  MatInputModule,
  MatListModule,
  MatCheckboxModule,
  MatOptionModule,
  MatRadioModule,
  MatSelectModule,
} from '@angular/material';
@NgModule({
  imports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatSidenavModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    MatListModule,
    MatRadioModule,
    MatSelectModule,
    MatCheckboxModule,
    MatOptionModule
  ],
  exports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatSidenavModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    MatListModule,
    MatRadioModule,
    MatSelectModule,
    MatCheckboxModule,
    MatOptionModule
  ]
})
export class MaterialModule {}
