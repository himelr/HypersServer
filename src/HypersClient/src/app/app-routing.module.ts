import { ListvComponent } from './listv/listv.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import {FormComponent} from './form/form.component';
const routes: Routes = [
  { path: '', component: WelcomeComponent },
  { path: 'list', component: ListvComponent },
  { path: 'form', component: FormComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
