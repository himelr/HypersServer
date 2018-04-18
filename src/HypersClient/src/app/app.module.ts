import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { WelcomeComponent } from './welcome/welcome.component';
import { ListvComponent } from './listv/listv.component';
import { MaterialModule } from './material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';



import { ToolbarComponent } from './toolbar/toolbar.component';
import { SidenavdemoComponent } from './sidenavdemo/sidenavdemo.component';
import { FormComponent } from './form/form.component';


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    ListvComponent,
    ToolbarComponent,
    SidenavdemoComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    AppRoutingModule,
    MaterialModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
